<%@include file="/layout/header.jsp" %>

	<% User getUser = (User)request.getAttribute("getUser"); %>
	<div class="title"><h1>Thong tin chi tiet cua <%= getUser.getName() %> </h1></div>
	<a class="button btn btn-success" href="register.jsp">Create New User</a>
	<a class="right button btn btn-warning" href="user_edit?id=<%=getUser.getId()%>">UPDATE</a>
	<table class="table table-striped table-bordered detail-view">
		<tr>
			<td>Id</td>
			<td> <%=getUser.getId() %></td>
		</tr>
		<tr>
			<td>Name</td>
			<td> <%=getUser.getName() %></td>
		</tr>
		<tr>
			<td>Username</td>
			<td> <%=getUser.getUsername()%></td>
		</tr>
		<tr>
			<td>Role</td>
			<td> <%= getUser.getRole()%></td>
		</tr>
	</table>
<%@include file="/layout/footer.jsp" %>
