<%@include file="/layout/header.jsp" %>

	<% Vacxin getVacxin = (Vacxin)session.getAttribute("getVacxin"); %>
	<% ArrayList<String> tenBenh = (ArrayList<String>) session.getAttribute("tenBenh"); %>
	<div class="title"><h1>Thong tin chi tiet cua <%= getVacxin.getName() %> </h1></div>
	<a class="button btn btn-success" href="<%=request.getContextPath()%>/Vacxin_add">Create New Vacxin</a>
	<a class="right button btn btn-warning" href="<%=request.getContextPath()%>/Vacxin_edit?id=<%=getVacxin.getMaVacxin()%>">UPDATE</a>
	<table class="table table-striped table-bordered detail-view">
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
<%@include file="/layout/footer.jsp" %>
