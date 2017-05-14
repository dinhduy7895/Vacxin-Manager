<%@page import="java.util.List"%>
<%@page import="model.bean.Benh"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Vacxin"%>
<%@page import="model.bean.User"%>
<%@page import="java.util.Arrays" %>
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
	<% Vacxin vacxin = (Vacxin)session.getAttribute("getVacxin"); %>
	<% List<Integer> idBenh = (List<Integer>)session.getAttribute("idBenh"); %>
	<% ArrayList<Benh> listBenh = (ArrayList<Benh>)session.getAttribute("listBenh"); 
 %>
	<%
		/* ArrayList<Benh> listBenh = session.getAttribute("listBenh"); */
	%>
	<form action="<%=request.getContextPath()%>/Vacxin_edit?id=<%=vacxin.getMaVacxin()%>" method="post">
		Tên VacXin: <input type="text" name="name"  required="required" value="<%= vacxin.getName() %>" >
		</br>Số mũi : <input type="number" name="somui"  required="required" value="<%= vacxin.getSoMui() %>"  >
		</br>Mô tả: <input type="text" name="mota"  required="required" value="<%= vacxin.getMota() %>" >
		</br>Gia vacxin <input type="text"" name="gia"  required="required" value="<%= vacxin.getGia() %>" >
		</br>Ten hang: <input type="text" name="brand"  required="required" value="<%= vacxin.getBrand() %>" >
		</br>Danh Sach Benh
		<select name="benh[]" multiple="multiple">
			<% for (Benh benh: listBenh) {%>
			<option value="<%= benh.getMaBenh() %>" <% 
					if(idBenh.contains(benh.getMaBenh()) == true) out.print("selected");%>
			><%= benh.getName() %></option>
			<%} %>
		</select>
		</br> <button type="submit" name="update">update</button>
	</form>
</body>
</html>