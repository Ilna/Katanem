

		<div class="ui segment">
			<h3>List of Customers</h3>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				
				<tr>
					<th>IdentityNumber</th>
					<th>Name</th>
					<th>Surname</th>
					<th>TaxNumber</th>
					<th>DateCarLicence</th>
					<th>History</th>
				</tr>
				
				<!-- loop over and print our customers -->
					<tr>
				<c:forEach var="tempCustomer" items="${custs}">

				
						<td>${tempCustomer.identityNumber}</td>
						<td>${tempCustomer.name}</td>
						<td>${tempCustomer.surname}</td>
						<td>${tempCustomer.taxNumber}</td>
						<td>${tempCustomer.dateCarLicence}</td>
						<td>${tempCustomer.history}</td>
						<td>
						<button class="ui button" type="submit" id="${tempCustomer.identityNumber}"
					name="deleteCustomer"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button" href="<c:url value="/customer/${tempCustomer.identityNumber}"></c:url>"><i class="unhide icon"></i>
					Edit Customer</a>
					<a class="ui button" href="<c:url value="/cars/showAddCarForm/${tempCustomer.identityNumber}"></c:url>"><i
						class="add circle icon"></i>Create Car</a>
					<a class="ui button" href="<c:url value="/cars/customer/${tempCustomer.identityNumber}/list"></c:url>"><i
						class="list icon"></i>List Cars</a>	
						
					</tr>
				</c:forEach>
			</table>
			<a class="ui button" href="${pageContext.request.contextPath}/customer/showAddForm" class="item"><i
						class="add circle icon"></i>Add Customer</a>
			
		</div>
		
		<script type="text/javascript">
	$("[name='deleteCustomer']").click(function() {
		var urlCall = "<c:url value="/api/customer/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('identityNumber'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/customer/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>
