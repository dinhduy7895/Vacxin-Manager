<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.KhachHang"%>
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
	<%
		ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) session.getAttribute("listKhachHang");
	%>
	
	<%
		String msg = (String)session.getAttribute("khach_hang_msg");
		if(msg != null)
			out.print(msg);
	%>	
	<a href="<%=request.getContextPath()%>/KhachHang_List">Back</a>
	<a href="<%=request.getContextPath()%>/Vacxin_index">Vacxin</a>
	
	<table>
	<tr>
		<td>Ma Khach Hang</td>
		<td>Ho va Ten</td>
		<td>Tong so tien da tra</td>
	</tr>
	
	<%
		if(listKhachHang.isEmpty())
		out.print("<h2>No result</h2>");
		else{
			for (KhachHang khach_hang: listKhachHang) {
	%>
	<tr>
		<td><%=khach_hang.getMaKH()%></td>
		<td><%=khach_hang.getHoTen()%></td>
		<td><%=khach_hang.getMoney()%></td>

	</tr>
	<%
			}
		}
	%>
</body>
</html>