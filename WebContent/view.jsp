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
	<h1>Thong tin chi tiet cua <%= getUser.getName() %> </h1>
	<table>
		<tr>
			<td>Id</td>
			<td> <%=getUser.getId() %></td>
		</tr>
		<tr>
			<td>Name</td>
			<td> <%=getUser.getName() %></td>
		</tr>
		<tr>
			<td>Username</td>
			<td> <%=getUser.getUsername()%></td>
		</tr>
		<tr>
			<td>Role</td>
			<td> <%= getUser.getRole()%></td>
		</tr>
	</table>
</body>
</html>