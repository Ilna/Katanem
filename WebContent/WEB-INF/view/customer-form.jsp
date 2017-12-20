<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Customer</h3>

	<form:form action="saveCustomer" modelAttribute="customer" method="POST" class="ui form">
		<div class="field">
			<label>IdentityNumber</label> 
			<form:input path="IdentityNumber"/>
		</div>
		<div class="field">
			<label>Name</label>
			<form:input path="Name"/>
		</div>
		<div class="field">
			<label>Surname</label> 
			<form:input path="Surname"/>
		</div>
		<div class="field">
			<label>TaxNumber</label> 
			<form:input path="TaxNumber"/>
		</div>
		<div class="field">
			<label>DateCarLicence</label> 
			<form:input path="DateCarLicence"/>
		</div>
		<div class="field">
			<label>History</label> 
			<form:input path="History"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>