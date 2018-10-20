package com.shop.controller;
import java.io.PrintWriter;
import com.shop.service.ConnectionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.service.ItemService;
import com.shop.domain.Item;
import com.shop.service.LoginService;
/**
 * Servlet implementation class ShoppingController
 */
@WebServlet("/ShoppingController")
public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CHECKOUT_BUTTON = "Checkout";
	

	private static final String ITEMS_PAGE = "items";
	private static final String ADD_TO_CART_BUTTON = "Add to cart";
	private static final String SUMMARY_PAGE = "summary";
	//private static final String CART = "cart";
	
	ItemService itemService;
	HttpSession session;
	LoginService loginService=new LoginService();
	
	/**
	 * Default constructor.
	 */
	@Override
	public void init() throws ServletException {
		// loginService=new LoginService();
		itemService = new ItemService();
	}

	public ShoppingController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("page");
		String action=request.getParameter("action");
		String nextPage="";
		boolean isValidUser=false;
		PrintWriter out = response.getWriter();

		
		if(currentPage!=null) {
			if(currentPage.trim().equalsIgnoreCase("login")) 
			{

		
				String username=request.getParameter("username");
				String password=request.getParameter("password");

				
				isValidUser = loginService.authenticate(username, password);
				if(isValidUser) 
				{

				
				
			
					nextPage="items.jsp";
				    
				    	
				    session=request.getSession(true);
				    //session.setAttribute("cart", null);
			//session.setAttribute("username", username);
					request.setAttribute("items", itemService.fetchAllItems());
			//response.sendRedirect("items.jsp");
					
					
				}
				else
				{
					request.setAttribute("loginError", "Invalid username or password.");
					nextPage="login.jsp";

				}
			}
			else if(currentPage.trim().equalsIgnoreCase(ITEMS_PAGE)) {
				if(action.equalsIgnoreCase(ADD_TO_CART_BUTTON)) 
				{
					request.setAttribute("items", itemService.fetchAllItems());
					
					//if (session.getAttribute("cart") == null) {
					    //session.setAttribute("cart", new ArrayList<>());
					
					//session.setAttribute("cart", cart);
					
					List<Item> cart=new ArrayList<>();

					//cart = (ArrayList<Item>) session.getAttribute("cart");
					
					String[] selectedItemIds=request.getParameterValues("selectedItems");
					for(String itemId:selectedItemIds) {
						int quantity = Integer.valueOf(request.getParameter("qty"+itemId));
						Item item=itemService.getItemById(Integer.valueOf(itemId));
						item.setQuantity(quantity);
						cart.add(item);
					}
					
					session.setAttribute("cart", cart);
					nextPage="items.jsp";
					request.setAttribute("cartAddMessage", "Items updated in cart sucessfully");
				}
				else if(action.equalsIgnoreCase(CHECKOUT_BUTTON)) {
					nextPage="summary.jsp";
				}
				else if(action.equalsIgnoreCase("logout")) {
			        session.invalidate();
					nextPage="login.jsp";
				}
				else if(action.equalsIgnoreCase("help")) {
					nextPage="Help.jsp";
				}
				
			}
			else if(currentPage.trim().equalsIgnoreCase(SUMMARY_PAGE)) {
				if(action.equalsIgnoreCase("Back to cart")) {
					request.setAttribute("items", itemService.fetchAllItems());
					nextPage="items.jsp";
				}
				else if(action.equalsIgnoreCase("Checkout")) {
					nextPage="thankyou.jsp";
				}
				
			}
			
		}
		RequestDispatcher rd =request.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}
}



