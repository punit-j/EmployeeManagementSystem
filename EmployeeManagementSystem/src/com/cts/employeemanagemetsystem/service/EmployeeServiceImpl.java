package com.cts.employeemanagemetsystem.service;

import java.util.List;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagemetsystem.dao.EmployeeDAO;
import com.cts.employeemanagemetsystem.dao.EmployeeDAOImpl;
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO employeeDAO=new EmployeeDAOImpl();
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(id, employee);
	}

	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(id);
	}

	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeesByName(name);
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

}
