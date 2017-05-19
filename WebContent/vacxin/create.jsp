<%@include file="/layout/header.jsp" %>

	<%
	 ArrayList<Benh> listBenh = (ArrayList<Benh>)session.getAttribute("listBenh"); 
	%>
	<div class="title">
	   <h2>VACCINE MANAGER</h2>
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
	<form action="<%=request.getContextPath()%>/Vacxin_add" method="post">
		<div class="form-group">
            <label>Vaccine's Name</label>
            <input class="form-control" type="text" name="name"  required="required" >
        </div>
        <div class="form-group">
            <label>Number Of Glosbe</label>
            <input class="form-control" type="number" name="somui"  required="required" >
        </div>
        <div class="form-group">
            <label>Description</label>
            <input class="form-control" type="text" name="mota"  required="required" >
        </div>
        <div class="form-group">
            <label>Vaccine's Price</label>
            <input class="form-control" type="text"" name="gia"  required="required" >
        </div>
        <div class="form-group">
            <label>Brand Of Vaccine</label>
            <input class="form-control" type="text" name="brand"  required="required" >
        </div>
        <div class="form-group">
            <label>List of Diseases</label>
            <select class="form-control" name="benh[]" multiple="multiple"> 
			<% for (Benh benh: listBenh) {%>
				<option value="<%= benh.getMaBenh()%>"><%= benh.getName() %></option>
			<%} %>
			</select> 
        </div>
		<button class="btn btn-primary btn-lg btn-block" type="submit" name="create">Create</button>
	</form>
<%@include file="/layout/footer.jsp" %>
