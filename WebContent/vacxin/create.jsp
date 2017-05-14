<%@page import="model.bean.Benh"%>
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
	%>
	<%
		 ArrayList<Benh> listBenh = (ArrayList<Benh>)session.getAttribute("listBenh"); 
	%>
	<form action="../Vacxin_add" method="post">
		Tên VacXin: <input type="text" name="name"  required="required" >
		</br>Số mũi : <input type="number" name="somui"  required="required" >
		</br>Mô tả: <input type="text" name="mota"  required="required" >
		</br>Gia vacxin <input type="text"" name="gia"  required="required" >
		</br>Ten hang: <input type="text" name="brand"  required="required" >
		</br> Danh sach benh: 
		<select name="benh[]" multiple="multiple"> 
			<% for (Benh benh: listBenh) {%>
			<option value="<%= benh.getMaBenh()%>"><%= benh.getName() %></option>
			<%} %>
		</select> 
		</br> <button type="submit" name="create">Create</button>
	</form>
</body>
</html>