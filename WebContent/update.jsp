<%@include file="/layout/header.jsp" %>

	<% User getUser = (User)request.getAttribute("getUser"); %>
	<div class="title">
	   <h2>USER MANAGER</h2>
    </div>
	<form action="user_edit?id=<%=user.getId() %>" method="post">
		<div class="form-group">
            <label>Username</label>
            <input class="form-control" type="text" name="username"  required="required" value="<%= getUser.getUsername() %>">
        </div>
        <div class="form-group">
            <label>Name</label>
            <input class="form-control" type="text" name="name"  required="required" value="<%= getUser.getName() %>">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input class="form-control" type="password" name="pass"  required="required" value="<%= getUser.getPassword() %>">
        </div>
        <div class="form-group">
            <label>Role</label>
            <input class="form-control" type="number" name="role"  required="required" value="<%= getUser.getRole() %>">
        </div>
		 <button class="btn btn-primary btn-lg btn-block" type="submit" name="update">Update</button>
	</form>
<%@include file="/layout/footer.jsp" %>
