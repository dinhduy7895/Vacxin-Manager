<%@page import="model.bean.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Vacxin"%>
<%@page import="model.bean.Benh"%>
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
	<% Vacxin getVacxin = (Vacxin)session.getAttribute("getVacxin"); %>
	<% ArrayList<String> tenBenh = (ArrayList<String>) session.getAttribute("tenBenh"); %>
	<h1>Thong tin chi tiet cua <%= getVacxin.getName() %> </h1>
	<table>
		<tr>
			<td>Id</td>
			<td> <%=getVacxin.getMaVacxin() %></td>
		</tr>
		<tr>
			<td>Name</td>
			<td> <%=getVacxin.getName() %></td>
		</tr>
		<tr>
			<td>Gia</td>
			<td> <%=getVacxin.getGia()%></td>
		</tr>
		<tr>
			<td>So Mui</td>
			<td> <%= getVacxin.getSoMui()%></td>
		</tr>
		<tr>
			<td>Mo Ta </td>
			<td> <%= getVacxin.getMota()%></td>
		</tr>
		<tr>
			<td>Hang</td>
			<td> <%= getVacxin.getBrand()%></td>
		</tr>
		<tr>
			<td>Danh Sach Benh</td>
			<td> 
					<% for (int i = 0; i< tenBenh.size();i++) { %>
					<%= tenBenh.get(i) %>
					</br>
					<%} %>
			</td>
		</tr>
	</table>
</body>
</html>