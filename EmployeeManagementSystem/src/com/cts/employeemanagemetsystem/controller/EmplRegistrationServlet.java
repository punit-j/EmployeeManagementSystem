package com.cts.employeemanagemetsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagemetsystem.service.LoginService;
import com.cts.employeemanagemetsystem.service.LoginServiceImpl;

/**
 * Servlet implementation class EmplRegistrationServlet
 */
public class EmplRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmplRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService loginservice = LoginServiceImpl.getInstance();
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String salary=request.getParameter("salary");
		System.out.println(userId + password + firstName + lastName +salary);
	}

}
