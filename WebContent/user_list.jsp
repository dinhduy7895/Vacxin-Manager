<%@include file="/layout/header.jsp" %>

	<%
		
		ArrayList<User> listUsers = (ArrayList<User>) session.getAttribute("listUsers");
	%>
	<div class="title">
	   <h2>USER MANAGER</h2>
    </div>
	<a class="button btn btn-success" href="register.jsp">Create New User</a>
	<form action="search" method="post">
	<table class="table1 table table-striped table-bordered table-hover">
	<tr>
		<th>Name</th>
		<th>Username</th>
		<th>Role</th>
		<th>Action</th>
	</tr>
	<tr>
		<td><input type="text" name="name"></td>
		<td><input type="text" name="username"></td>
		<td><input type="number" name="role"></td>
		<td><input class="btn btn-primary" type="submit" name="search"></td>
	</tr>
	
	<%
		if(listUsers == null)
		out.print("<h2>No result</h2>");
		else{
			for (User list: listUsers) {
	%>
	<tr>
		<td><%=list.getUsername()%></td>
		<td><%=list.getName()%></td>
		<td><%=list.getRole()%></td>
		<td>
			<a class="btn btn-default" href="user_view?id=<%=list.getId()%>">VIEW</a>
			<a class="btn btn-default" href="user_edit?id=<%=list.getId()%>">UPDATE</a>
			<a class="btn btn-default" href="user_delete?id=<%=list.getId()%>">DELETE</a>
			
		</td>
	</tr>
	<%
			}
		}
	%>
	</table>
	</form>
	
<%@include file="/layout/footer.jsp" %>
