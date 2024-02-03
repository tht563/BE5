package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;


import entity.Cart;
import entity.User;
import model.ProductInCart;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/Checkout")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addOrderInfo(request);
			addOrderDetail(request);
			viewLastOrderDetail(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void viewLastOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
	}
	
	protected void addOrderDetail(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		Set<ProductInCart> products = cart.getItems();
		OrderDAO orderDAO = new OrderDAO();

		int orderId = orderDAO.getLastOrderIdByUserId(user.getId());

		if (orderId != -1) {
			for (ProductInCart product: products) {
				System.out.print(orderId);
				orderDAO.addOrderDetail(orderId, product.getId(), product.getQuantity(), product.getPrice());
			}
		}
		
	}
	
	protected void addOrderInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getId();
		OrderDAO orderDAO = new OrderDAO();
		try {
			orderDAO.addOrderInfo(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
