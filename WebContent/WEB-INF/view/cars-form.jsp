<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Car</h3>

	<form:form action="saveCar" modelAttribute="cars" method="POST" class="ui form">
		<div class="field">
			<label>plates</label> 
			<form:input path="year"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>