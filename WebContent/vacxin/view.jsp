<%@include file="/layout/header.jsp" %>

	<% Vacxin getVacxin = (Vacxin)session.getAttribute("getVacxin"); %>
	<% ArrayList<String> tenBenh = (ArrayList<String>) session.getAttribute("tenBenh"); %>
	<div class="title"><h1>Information of <%= getVacxin.getName() %> </h1></div>
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
			<td>Vaccine's Price</td>
			<td> <%=getVacxin.getGia()%></td>
		</tr>
		<tr>
			<td>Number Of Glosbe</td>
			<td> <%= getVacxin.getSoMui()%></td>
		</tr>
		<tr>
			<td>Description</td>
			<td> <%= getVacxin.getMota()%></td>
		</tr>
		<tr>
			<td>Brand Of Vaccine</td>
			<td> <%= getVacxin.getBrand()%></td>
		</tr>
		<tr>
			<td>List of Diseases</td>
			<td> 
					<% for (int i = 0; i< tenBenh.size();i++) { %>
					<%= tenBenh.get(i) %>
					</br>
					<%} %>
			</td>
		</tr>
	</table>
<%@include file="/layout/footer.jsp" %>
