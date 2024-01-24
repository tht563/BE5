package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		switch(action) {
			case ("ADD_TO_CART"):
			try {
				addToCart(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			default:
				
		}
	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String productId = request.getParameter("productId");
		HttpSession session = request.getSession();
		Set<Integer> shoppingCartItems;
		
		if (session.getAttribute("cart") == null) {
			shoppingCartItems = new HashSet<Integer>();
		}else {
			shoppingCartItems = (Set<Integer>) session.getAttribute("cart");
		}
		
		shoppingCartItems.add(Integer.parseInt(productId));
		session.setAttribute("cart", shoppingCartItems);
		
		response.sendRedirect("Product?productId="+productId);
		
	}

}
