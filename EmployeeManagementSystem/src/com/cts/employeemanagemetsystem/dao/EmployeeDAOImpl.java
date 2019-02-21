package com.cts.employeemanagemetsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagemetsystem.util.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {
	   private Connection connection;
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stubPreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		String insertStatement="insert into employee"+"(id,firstname,lastname,salary) "+"values(?,?,?,?)";
		connection=DBUtils.getConnection();
		try
		{
			connection.setAutoCommit(true);
			preparedStatement=connection.prepareStatement(insertStatement);
			preparedStatement.setString(1,"003");
			preparedStatement.setString(2,employee.getFirstName());
			preparedStatement.setString(3,employee.getLastName());
			preparedStatement.setFloat(4,employee.getSalary());
			int res=preparedStatement.executeUpdate();
			return "success";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try
			{
				connection.rollback();
			}
			catch(SQLException e1)
			{
				e.printStackTrace();
			}
			return "Fail";
		}
		finally{
			DBUtils.closeConnection(connection);
		}
	}
		
	

	public String updateEmployee(String id, Employee employee) {
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String insertStatement="update employee set firstname=?,lastname=?,salary=?"+"where id=?";
		connection=DBUtils.getConnection();
		try
		{
			connection.setAutoCommit(true);
			preparedStatement=connection.prepareStatement(insertStatement);
			preparedStatement.setString(1,employee.getFirstName());
			preparedStatement.setString(2,employee.getLastName());
			preparedStatement.setFloat(3,employee.getSalary());
			preparedStatement.setString(4,id);
			preparedStatement.executeUpdate();
			return "success";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try
			{
				connection.rollback();
			}
			catch(SQLException e1)
			{
				e.printStackTrace();
			}
			return "Fail";
		}
		finally{
			DBUtils.closeConnection(connection);
		}
	}

	public String deleteEmployee(String id) {
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String insertStatement="delete from employee where id=?";
		connection=DBUtils.getConnection();
		try
		{
			connection.setAutoCommit(true);
			preparedStatement=connection.prepareStatement(insertStatement);
			preparedStatement.setString(1,id);
			preparedStatement.executeUpdate();
			return "success";
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try
			{
				connection.rollback();
			}
			catch(SQLException e1)
			{
				e.printStackTrace();
			}
			return "Fail";
		}
		finally{
			DBUtils.closeConnection(connection);
		}
	}

	public Employee getEmployee(String id) {
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String insertStatement="select * from employee where id=?";
		connection=DBUtils.getConnection();
			try {
				connection.setAutoCommit(true);
				preparedStatement=connection.prepareStatement(insertStatement);
				preparedStatement.setString(1,id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					String firstname = resultSet.getString("firstname");
					String lastname = resultSet.getString("lastname");
					float salary = resultSet.getFloat("salary");
					Employee employee = new Employee(id,firstname,lastname,salary);
					return employee;
				}else{
					return null;
				}
				
	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
	}
			
	}

	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
