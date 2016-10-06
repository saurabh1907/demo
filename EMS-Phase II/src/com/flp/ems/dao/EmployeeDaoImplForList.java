package com.flp.ems.dao;

import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Properties;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao {
	private Properties props = new Properties();
	String url = props.getProperty("jdbc.url");

	{
		try {
			FileInputStream fls;
			fls = new FileInputStream("dbDetails.properties");

			props.load(fls);

			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver);

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(props.getProperty("jdbc.query.addEmployee"))) {
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getKinID());
			ps.setLong(3, employee.getPhoneNo());
			ps.setDate(4, employee.getDateOfBirth());
			ps.setDate(5, employee.getDateOfJoining());
			ps.setInt(6, employee.getDepartmentID());
			ps.setInt(7, employee.getProjectID());
			ps.setInt(8, employee.getRolesID());
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}

	@Override
	public void modifyEmployee(Employee employee) {
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(props.getProperty("jdbc.query.modifyEmployee"))) {
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getKinID());
			ps.setLong(3, employee.getPhoneNo());
			ps.setDate(4, employee.getDateOfBirth());
			ps.setDate(5, employee.getDateOfJoining());
			ps.setInt(6, employee.getDepartmentID());
			ps.setInt(7, employee.getProjectID());
			ps.setInt(8, employee.getRolesID());
			ps.executeQuery();
		} catch (SQLException e) {
		}

	}

	@Override
	public void removeEmployee(int empID) {
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(props.getProperty("jdbc.query.removeEmployee"))) {
			ps.setInt(1, empID);
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}

	@Override
	public Employee searchEmployee(String nameOrId) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement ps;
			String regexInteger = "[0-9]+";
			if (nameOrId.matches(regexInteger)){
				ps = con.prepareStatement(props.getProperty("jdbc.query.searchByID"));
			}
			else{
				ps = con.prepareStatement(props.getProperty("jdbc.query.searchByKinID"));

			}
			ps.executeQuery();
		} catch (SQLException e) {
		}
		return null;
	}

	

	@Override
	public void getAllEmployee() {
		try (Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(props.getProperty("jdbc.query.displayAll"))) {
				ps.executeQuery();
		} catch (SQLException e) {
		}
	}
}
