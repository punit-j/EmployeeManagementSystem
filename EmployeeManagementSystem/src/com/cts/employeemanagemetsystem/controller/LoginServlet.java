package com.cts.employeemanagemetsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagemetsystem.service.LoginService;
import com.cts.employeemanagemetsystem.service.LoginServiceImpl;

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
		LoginService loginservice = LoginServiceImpl.getInstance();
		
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		RequestDispatcher requestDispatcher= null;
		if(loginservice.authenticate(userId, password)){
			//response.sendRedirect("admin.html");
			int userStatus = loginservice.getUserStatus(userId);
			if(userStatus != 2){
				String userType = loginservice.getUserType(userId);
				if("a".equals(userType)){
					requestDispatcher = request.getRequestDispatcher("adminHome.html");
					requestDispatcher.forward(request, response);}
				if("v".equals(userType)){
				requestDispatcher = request.getRequestDispatcher("vendorHome.html");
				requestDispatcher.forward(request, response);}
				if("u".equals(userType)){
					requestDispatcher = request.getRequestDispatcher("userHome.html");
					requestDispatcher.forward(request, response);
				}
			}
			else{requestDispatcher = request.getRequestDispatcher("deactivatedAcc.html");
			requestDispatcher.forward(request, response);
				}
		}else{
			response.sendRedirect("login.html");
		}
			
		
	}

}
