<%@include file="/layout/header.jsp" %>

	<%
	 ArrayList<Benh> listBenh = (ArrayList<Benh>)session.getAttribute("listBenh"); 
	%>
	<div class="title">
	   <h2>VACXIN MANAGER</h2>
    </div>
	<form action="<%=request.getContextPath()%>/Vacxin_add" method="post">
		<div class="form-group">
            <label>Vacxin's Name</label>
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
            <label>Vacxin's Price</label>
            <input class="form-control" type="text"" name="gia"  required="required" >
        </div>
        <div class="form-group">
            <label>Brand Of Vacxin</label>
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
