package com.cts.employeemanagemetsystem.service;

import com.cts.employeemanagemetsystem.dao.LoginDAO;
import com.cts.employeemanagemetsystem.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	private LoginServiceImpl(){}
	private static LoginServiceImpl loginserviceimpl;
	public static LoginServiceImpl getInstance(){
		if (loginserviceimpl == null)
			loginserviceimpl = new LoginServiceImpl();
		return loginserviceimpl;
	}
	
	private LoginDAO dao = LoginDAOImpl.getInstance();
	
	
	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		return dao.getUserStatus(id);
	}

	public String getUserType(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}

	public boolean authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(userName, password);
	}

}
