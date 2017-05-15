<%@include file="/layout/header.jsp" %>
	<% Vacxin vacxin = (Vacxin)session.getAttribute("getVacxin"); %>
	<% List<Integer> idBenh = (List<Integer>)session.getAttribute("idBenh"); %>
	<% ArrayList<Benh> listBenh = (ArrayList<Benh>)session.getAttribute("listBenh"); 
 %>
	<div class="title">
	   <h2>USER MANAGER</h2>
    </div>
	<form action="<%=request.getContextPath()%>/Vacxin_edit?id=<%=vacxin.getMaVacxin()%>" method="post">
		<div class="form-group">
            <label>Vacxin's Name</label>
            <input class="form-control" type="text" name="name"  required="required" value="<%= vacxin.getName() %>">
        </div>
        <div class="form-group">
            <label>Number Of Glosbe</label>
            <input class="form-control" type="number" name="somui"  required="required" value="<%= vacxin.getSoMui() %>"  >
        </div>       
        <div class="form-group">
            <label>Description</label>
            <input class="form-control"  type="text" name="mota"  required="required" value="<%= vacxin.getMota() %>" >
        </div>
        <div class="form-group">
            <label>Vacxin's Price</label>
            <input class="form-control" type="text"" name="gia"  required="required" value="<%= vacxin.getGia() %>" >
        </div>
        <div class="form-group">
            <label>Brand Of Vacxin</label>
            <input class="form-control"  type="text" name="brand"  required="required" value="<%= vacxin.getBrand() %>" >
        </div>
        <div class="form-group">
            <label>List of Diseases</label>
            <select class="form-control" name="benh[]" multiple="multiple"> 
			<% for (Benh benh: listBenh) {%>
			<option value="<%= benh.getMaBenh() %>" <% 
					if(idBenh.contains(benh.getMaBenh()) == true) out.print("selected");%>
			><%= benh.getName() %></option>
			<%} %>
			</select> 
        </div>
		</br> <button class="btn btn-primary btn-lg btn-block"  type="submit" name="update">UPDATE</button>
	</form>
</body>
</html>