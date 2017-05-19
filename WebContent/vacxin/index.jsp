<%@include file="/layout/header.jsp" %>

	<%	
		ArrayList<Vacxin> listVacxin = (ArrayList<Vacxin>) session.getAttribute("listVacxin");
	%>
	<div class="title">
	   <h2>VACCINE MANAGER</h2>
    </div>
	<a class="button btn btn-success" href="<%=request.getContextPath()%>/Vacxin_add">Create New Vacxin</a>
	<%
		if(session.getAttribute("msg")!=null){
	%>
		<div class="search alert alert-success">
                    <a class="close" href="#">&times;</a>
                    <p><strong>SUCCESS!!! </strong><%=session.getAttribute("msg")%></p>
		</div>
	<%
		session.removeAttribute("msg");
		}
	%>
	<form action="<%=request.getContextPath()%>/Vacxin_search" method="post">
	<table class="table1 table table-striped table-bordered table-hover">
	<tr>
		<th>Name</th>
		<th>Glosbe</th>
		<th>Description</th>
		<th>Vaccine's Price</th>
		<th>Brand Of Vaccine </th>
		<th>Action</th>
	</tr>
	<tr>
		<td><input type="text" name="name"></td>
		<td><input type="number" name="somui"></td>
		<td><input type="text" name="mota"></td>
		<td></td>
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
