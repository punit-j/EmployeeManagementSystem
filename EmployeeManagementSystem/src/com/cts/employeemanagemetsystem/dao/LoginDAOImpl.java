package com.cts.employeemanagemetsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagemetsystem.util.DBUtils;

public class LoginDAOImpl implements LoginDAO {

	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		String query = "select status from login_table where userid=?";
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				int status= resultSet.getInt("status");
				return status;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(connection);
		}
		return -1;
	}

	public String getUserType(String id) {
		String query = "select usertype from login_table where userid=?";
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				String userType= resultSet.getString("usertype");
				return userType;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(connection);
		}
		return null;
	}
	public boolean authenticate(String userName,String password){
		String query= "select * from login_table where username=? and password=?";
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				return true;
			else
		return false;	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.closeConnection(connection);
		}
	}}
