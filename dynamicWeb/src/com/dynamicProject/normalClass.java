package com.dynamicProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getData")
public class normalClass extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session= req.getSession();
	
	Enumeration<String> header=req.getHeaderNames();
	PrintWriter pw= resp.getWriter();
	pw.print(session.getId()+ "this was cookie");
	Cookie cookie = new Cookie("damm", "value");
}
 }
