

		<div class="ui segment">
			<h3>List of Customers</h3>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				
				<tr>
					<th>Plates</th>
					<th>Year</th>
					<th>Cubic</th>
					<th>Type</th>
					<th>Color</th>
					<th>OwnerId</th>
				</tr>
				
				<!-- loop over and print our customers -->
					<tr>
				<c:forEach var="tempCars" items="${cars}">

				
						<td>${tempCars.plates}</td>
						<td>${tempCars.year}</td>
						<td>${tempCars.cubic}</td>
						<td>${tempCars.type}</td>
						<td>${tempCars.color}</td>
						<td>${tempCars.ownerId}</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
