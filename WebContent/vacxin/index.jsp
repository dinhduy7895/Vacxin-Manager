<%@page import="model.bean.Vacxin"%>
<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList"%>

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
	<%	
		ArrayList<Vacxin> listVacxin = (ArrayList<Vacxin>) session.getAttribute("listVacxin");
	%>
	<%
		String msg = (String)session.getAttribute("vacxin_msg");
		if(msg != null)
			out.print(msg);
	%>
				<a href="<%=request.getContextPath()%>/user_list">USER</a>
				<a href="<%=request.getContextPath()%>/KhachHang_List">Khach Hang</a>
	<form action="<%=request.getContextPath()%>/Vacxin_search" method="post">
	
	
	<table>
	<tr>
		<td>Name</td>
		<td>So Mui</td>
		<td>Mo ta </td>
		<td>Gia Vacxin</td>
		<td>Ten hang </td>
		<td>Action</td>
	</tr>
	<tr>
		<td><input type="text" name="name"></td>
		<td><input type="number" name="somui"></td>
		<td><input type="text" name="mota"></td>
		<td><input type="text" name="gia"></td>
		<td><input type="hidden" name="brand" ></td>
		<td><input type="submit" name="search"></td>
	</tr>
	
	<%
		if(listVacxin.isEmpty())
		out.print("<h2>No result</h2>");
		else{
			for (Vacxin vacxin: listVacxin) {
	%>
	<tr>
		<td><%=vacxin.getName()%></td>
		<td><%=vacxin.getSoMui()%></td>
		<td><%=vacxin.getMota()%></td>
		<td><%=vacxin.getGia()%></td>
		<td><%=vacxin.getBrand()%></td>
		<td>
			<a href="../Vacxin_view?id=<%=vacxin.getMaVacxin()%>">VIEW</a>
			<a href="../Vacxin_edit?id=<%=vacxin.getMaVacxin()%>">UPDATE</a>
			<a href="../Vacxin_delete?id=<%=vacxin.getMaVacxin()%>">DELETE</a>
			
		</td>
	</tr>
	<%
			}
		}
	%>
	</table>
	</form>
	<a href="../Vacxin_add">Create New Vacxin</a>
</body>
</html>