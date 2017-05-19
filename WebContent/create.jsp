<%@include file="/layout/header.jsp" %>
	<div class="title">
	   <h2>USER MANAGER</h2>
    </div>
    <%
		if(session.getAttribute("msg")!=null){
	%>
		<div class="search alert alert-danger">
                    <a class="close" href="#">&times;</a>
                    <p><strong>ERROR!!!</strong><%=session.getAttribute("msg")%></p>
		</div>
	<%
		session.removeAttribute("msg");
		}
	%>
	<form action="checkRegister" method="post">
		<div class="form-group">
            <label>Username</label>
            <input class="form-control" type="text" name="username"  required="required" >
        </div>
        <div class="form-group">
            <label>Name</label>
            <input class="form-control" type="text" name="name"  required="required" >
        </div>
        <div class="form-group">
            <label>Password</label>
            <input class="form-control" type="password" name="pass"  required="required" >
        </div>
        <div class="form-group">
            <label>Confirm-Password</label>
            <input class="form-control" type="password" name="rePass"  required="required" >
        </div>
        <div class="form-group">
            <label>Role</label>
            <input class="form-control" type="number" name="role"  required="required" >
        </div>
		 <button class="btn btn-primary btn-lg btn-block" type="submit" name="register">REGISTER</button>
	</form>
<%@include file="/layout/footer.jsp" %>
