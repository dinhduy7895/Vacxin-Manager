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
		<th>So Dien Thoai</th>
		<th>Dia chi</th>
		<th>Ngay sinh</th>
		<th>Lich su tiem phong</th>
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
		<td><%=khach_hang.getSdt()%></td>
		<td><%=khach_hang.getDiaChiKH()%></td>
		<td><%=khach_hang.getNgaySinh()%></td>
		<td>
			<a href="<%=request.getContextPath()%>/KhachHang_History?id=<%=khach_hang.getMaKH()%>">...</a>
		</td>
	</tr>
	<%
			}
		}
	%>
	</table>
<%@include file="/layout/footer.jsp" %>
