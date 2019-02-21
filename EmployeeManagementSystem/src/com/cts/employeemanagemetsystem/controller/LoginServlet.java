package com.cts.employeemanagemetsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		RequestDispatcher requestDispatcher= null;
		if(userId.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")){
			//response.sendRedirect("admin.html");
			requestDispatcher = request.getRequestDispatcher("admin.html");
			requestDispatcher.forward(request, response);
		}else{
			
		}
			
		
	}

}
