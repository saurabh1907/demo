package com.flp.ems.dao;

import java.util.ArrayList;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {
	public void addEmployee(Employee employee);
	public void modifyEmployee(Employee employee);
	public void removeEmployee(int empID);
	public Employee searchEmployee(int empID);
	public ArrayList<Employee> getAllEmployee();
}
