package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;

import entity.Category;
import entity.Product;
import model.ProductInCart;
import entity.Cart;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/Cart")
public class CartController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch(action) {
				case ("ADD_TO_CART"):
					addToCart(request, response);
					break;
				case ("VIEW_CART_DETAILS"):
					viewCartDetails(request, response);
					break;
			default:
			}
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void viewCartDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories;
		
		categories = categoryDAO.getCategories();
		RequestDispatcher rd = request.getRequestDispatcher("view-cart-details.jsp");
		request.setAttribute("categories", categories);		
		rd.forward(request, response);
	}
	

	
	protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String productId = request.getParameter("productId");
		
		Cart cart;
		HttpSession session = request.getSession();
		
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
			cart.setItems(new HashSet<ProductInCart>());
		}else {
			cart = (Cart) session.getAttribute("cart");
		}

		Product product = ProductDAO.getProductById(productId);
		ProductInCart productInCart = new ProductInCart(product.getId(), product.getName(), product.getPrice(), product.getPrice(), 1);
		
		if (cart.getItems().contains(productInCart)) {
			for (ProductInCart item: cart.getItems()) {
				if (item.getId()==productInCart.getId()) {
					productInCart.setQuantity(item.getQuantity()+1);
					productInCart.setSubTotal(productInCart.getQuantity()*productInCart.getPrice());
				}
			}

			cart.getItems().remove(productInCart);
			cart.getItems().add(productInCart);
		}else {
			cart.getItems().add(productInCart);
		}
		
		cart.setTotal(cart.getTotal()+productInCart.getSubTotal());
		
		session.setAttribute("cart", cart);
		response.sendRedirect("Product?productId="+productId);
	}

}
