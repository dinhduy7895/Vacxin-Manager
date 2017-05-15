<%@include file="/layout/header.jsp" %>

	<%	
		ArrayList<Vacxin> listVacxin = (ArrayList<Vacxin>) session.getAttribute("listVacxin");
	%>
	<div class="title">
	   <h2>VACXIN MANAGER</h2>
    </div>
	<a class="button btn btn-success" href="<%=request.getContextPath()%>/Vacxin_add">Create New Vacxin</a>
	<form action="<%=request.getContextPath()%>/Vacxin_search" method="post">
	<table class="table1 table table-striped table-bordered table-hover">
	<tr>
		<th>Name</th>
		<th>So Mui</th>
		<th>Mo ta </th>
		<th>Gia Vacxin</th>
		<th>Ten hang </th>
		<th>Action</th>
	</tr>
	<tr>
		<td><input type="text" name="name"></td>
		<td><input type="number" name="somui"></td>
		<td><input type="text" name="mota"></td>
		<td><input type="text" name="gia"></td>
		<td><input type="text" name="brand" ></td>
		<td><input class="btn btn-primary" type="submit" name="search"></td>
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
			<a class="btn btn-default" href="../Vacxin_view?id=<%=vacxin.getMaVacxin()%>">VIEW</a>
			<a class="btn btn-default" href="../Vacxin_edit?id=<%=vacxin.getMaVacxin()%>">UPDATE</a>
			<a class="btn btn-default" href="../Vacxin_delete?id=<%=vacxin.getMaVacxin()%>">DELETE</a>
			
		</td>
	</tr>
	<%
			}
		}
	%>
	</table>
	</form>
<%@include file="/layout/footer.jsp" %>
