<%@page import="java.util.ArrayList"%>
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
		ArrayList<User> listUsers = (ArrayList<User>) session.getAttribute("listUsers");
	%>
	<%= session.getAttribute("msg") %>
	<a href="<%=request.getContextPath()%>/Logout" style="float:right";>Logout</a>
	<ul>
		<li>
			<a href="Vacxin_index">Vacxin</a>
		</li>
	</ul>
	<form action="search" method="post">
	
	
	<table>
	<tr>
		<td>Name</td>
		<td>Username</td>
		<td>Role</td>
		<td>Action</td>
	</tr>
	<tr>
		<td><input type="text" name="name"></td>
		<td><input type="text" name="username"></td>
		<td><input type="number" name="role"></td>
		<td><input type="submit" name="search"></td>
	</tr>
	
	<%
		if(listUsers == null)
		out.print("<h2>No result</h2>");
		else{
			for (User list: listUsers) {
	%>
	<tr>
		<td><%=list.getUsername()%></td>
		<td><%=list.getName()%></td>
		<td><%=list.getRole()%></td>
		<td>
			<a href="user_view?id=<%=list.getId()%>">VIEW</a>
			<a href="user_edit?id=<%=list.getId()%>">UPDATE</a>
			<a href="user_delete?id=<%=list.getId()%>">DELETE</a>
			
		</td>
	</tr>
	<%
			}
		}
	%>
	</table>
	</form>
	<a href="register.jsp">Create New User</a>
</body>
</html>
