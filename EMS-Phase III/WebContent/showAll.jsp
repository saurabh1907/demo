<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get All Employee</title>
</head>
<body>
<form action="ControllerServlet" method="post">
<input type="hidden" name= "formType" value = "showAll">
<input type="submit" name="showAll" value="show all" /><br><br>
<a href="index.jsp">Home</a>
</form>
</body>
</html>