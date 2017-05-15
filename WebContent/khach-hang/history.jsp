<%@include file="/layout/header.jsp" %>
	<%
		ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) session.getAttribute("listKhachHang");
	%>
	<div class="title">
	   <h2>CUSTOMERS MANAGER</h2>
    </div>
	<table class="table1 table table-striped table-bordered table-hover">
	<tr>
		<th>Ma Khach Hang</th>
		<th>Ho va Ten</th>
		<th>Ten Benh</th>
		<th>Ma Vacxin</th>
		<th>Ten Vacxin</th>
		<th>Tong so mui phai tiem</th>
	</tr>
	
<%
		if(listKhachHang.isEmpty())
		out.print("<div class='title'> <h2>NO RESULTS</h2></div>");
		else{
			for (KhachHang khach_hang: listKhachHang) {
	%>
	<tr>
		<td><%=khach_hang.getMaKH()%></td>
		<td><%=khach_hang.getHoTen()%></td>
		<td><%=khach_hang.getTenBenh()%></td>
		<td><%=khach_hang.getMaVacXin()%></td>
		<td><%=khach_hang.getTenVacxin()%></td>
		<td><%=khach_hang.getSoMui()%></td>
	</tr>
	<%
			}
		}
	%>
	</table>
<%@include file="/layout/footer.jsp" %>
