<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add Car for ${car.customer}</h3>

	<form:form action="${pageContext.request.contextPath}/cars/saveCar/${car.customer.identityNumber}" modelAttribute="cars" method="POST" class="ui form">
		<div class="field">
			<label>plates</label> 
			<form:input path="plates"/>
			<label>year</label> 
			<form:input path="year"/>
			<label>cubic</label> 
			<form:input path="cubic"/>
			<label>type</label> 
			<form:input path="type"/>
			<label>color</label> 
			<form:input path="color"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>