<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		User user = (User) session.getAttribute("user");
		if(user == null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		else{
			out.print("welcome "+user.getName());
		}
	%>
	<% User getUser = (User)request.getAttribute("getUser"); %>
	<form action="user_edit?id=<%=user.getId() %>" method="post">
		Username: <input type="text" name="username"  required="required" value="<%= getUser.getUsername() %>">
		</br>Name: <input type="text" name="name"  required="required" value="<%= getUser.getName() %>">
		</br>Password: <input type="password" name="pass"  required="required" value="<%= getUser.getPassword() %>">
		</br>Role: <input type="text" name="role"  required="required" value="<%= getUser.getRole() %>">
		</br> <input type="hidden" value="duy">
		</br> <button type="submit" name="update">Update</button>
	</form>
</body>
</html>