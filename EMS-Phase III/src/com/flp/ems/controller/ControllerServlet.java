package com.flp.ems.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.DateParser;
import com.flp.ems.util.Validate;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final String ACTION_KEY = "formType";
	private static final String ADD_EMPLOYEE_ACTION = "addEmployee";
	private static final String MODIFY_EMPLOYEE_ACTION = "modifyEmployee";
	private static final String REMOVE_EMPLOYEE_ACTION = "removeEmployee";
	private static final String SEARCH_EMPLOYEE_ACTION = "searchEmployee";
	private static final String SHOW_ALL_ACTION = "showAll";
	private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String action = request.getParameter(ACTION_KEY);

		if (action.equals(ADD_EMPLOYEE_ACTION)) {
			HashMap<String, String> employeeData = new HashMap<>();

			String name = request.getParameter("name");
			String kinID = request.getParameter("kinID");
			String phoneNo = request.getParameter("phoneNo");
			String dob = request.getParameter("dob");
			String doj = request.getParameter("doj");
			String address = request.getParameter("address");
			String deptID = request.getParameter("deptID");
			String projectID = request.getParameter("projectID");
			String rolesID = request.getParameter("rolesID");

			employeeData.put("name", name);
			employeeData.put("kinID", kinID);
			employeeData.put("phoneNo", phoneNo);
			employeeData.put("dob", dob);
			employeeData.put("doj", doj);
			employeeData.put("address", address);
			employeeData.put("deptID", deptID);
			employeeData.put("projectID", projectID);
			employeeData.put("rolesID", rolesID);

			employeeService.addEmployee(employeeData);
			response.sendRedirect("index.jsp");
		}

		if (action.equals(MODIFY_EMPLOYEE_ACTION)) {
			HashMap<String, String> employeeData = new HashMap<>();

			String name = request.getParameter("name");
			String kinID = request.getParameter("kinID");
			String phoneNo = request.getParameter("phoneNo");
			String dob = request.getParameter("dob");
			String doj = request.getParameter("doj");
			String address = request.getParameter("address");
			String deptID = request.getParameter("deptID");
			String projectID = request.getParameter("projectID");
			String rolesID = request.getParameter("rolesID");

			employeeData.put("name", name);
			employeeData.put("kinID", kinID);
			employeeData.put("phoneNo", phoneNo);
			employeeData.put("dob", dob);
			employeeData.put("doj", doj);
			employeeData.put("address", address);
			employeeData.put("deptID", deptID);
			employeeData.put("projectID", projectID);
			employeeData.put("rolesID", rolesID);

			employeeService.modifyEmployee(employeeData);
			response.sendRedirect("index.jsp");

		}
		if (action.equals(REMOVE_EMPLOYEE_ACTION)) {
			employeeService.removeEmployee(request.getParameter("employeeID"));
			response.sendRedirect("index.jsp");
		}
		if (action.equals(SEARCH_EMPLOYEE_ACTION)) {
			HashMap<String, Object> empData = employeeService.searchEmployee(request.getParameter("nameOrID"));
			request.setAttribute("empData", empData);
			RequestDispatcher rd = request.getRequestDispatcher("displayEmployee.jsp");
			rd.forward(request, response);
			System.out.println(empData.get("name") + " " + empData.get("kinID") + " " + empData.get("phoneNo") + " "
					+ empData.get("dob"));

		}
		if (action.equals(SHOW_ALL_ACTION)) {
			System.out.println("\nNAME\tKINID\tPHONENO\t\tDOB\n------------------------------------------------------");
			for (HashMap<String, Object> empData : employeeService.getAllEmployee()) {
				System.out.println(empData.get("name") + " " + empData.get("kinID") + " " + empData.get("phoneNo") + " "
						+ empData.get("dob"));
			}
			response.sendRedirect("index.jsp");
		}

	}

}
