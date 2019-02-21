package com.cts.employeemanagemetsystem.service;

public interface LoginService {
	public int getUserStatus(String id);
	public String getUserType(String id);
	public boolean authenticate(String userName,String password);
}
