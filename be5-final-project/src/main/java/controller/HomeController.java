package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO = new ProductDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	List<Product> products;
	List<Category> categories;
	
	public HomeController() {
		super();		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {	
		
			categories = categoryDAO.getCategories();
			
			String action = request.getParameter("action");
			if (action == null) {
				action = "DEFAULT";
			}
			
			switch(action) {
				case "SHOW_ALL":{
					getAllProducts(request, response);
					break;
				}
				case "SHOW_PRODUCT_BY_CATEGORY": {
					getProductByCategory(request, response);
					break;
				}
				case "SHOW_SEARCH":{
					getProductBySearchInput(request, response);
					break;			
				}
				case "LOGOUT": {
					HttpSession session = request.getSession();
					session.invalidate();
					request.getRequestDispatcher("logout.jsp").forward(request, response);
				}
				default:
					getDefaultHomePage(request, response);
					
			}
		
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	private void getProductBySearchInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
			String searchInput = request.getParameter("search");
			products = productDAO.getProductBySearch(searchInput);
			dispatchAttributeToView(request, response);	
	}
	
	private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		products = productDAO.getAllProducts();				
		dispatchAttributeToView(request, response);	
	}	
	
	private void getDefaultHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
							
		products = productDAO.getLastestProducts();			
		dispatchAttributeToView(request, response);	
	}

	private void getProductByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
				
		String categoryId = request.getParameter("categoryId");			
		products =  productDAO.getProductByCategory(categoryId);			
		dispatchAttributeToView(request, response);
			
	}
	private void dispatchAttributeToView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);		
		rd.forward(request, response);
	}

}