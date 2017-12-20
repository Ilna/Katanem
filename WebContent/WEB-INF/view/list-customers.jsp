

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
						
					</tr>
				</c:forEach>
			</table>
		</div>
