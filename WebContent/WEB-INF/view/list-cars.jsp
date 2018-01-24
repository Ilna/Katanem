

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
				</tr>
				
				<!-- loop over and print our customers -->
					<tr>
				<c:forEach var="tempCars" items="${cars}">

				
						<td>${tempCars.plates}</td>
						<td>${tempCars.year}</td>
						<td>${tempCars.cubic}</td>
						<td>${tempCars.type}</td>
						<td>${tempCars.color}</td>
						<td><button type="submit" id="${tempCars.plates}" class="ui button"
					name="deleteCar"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button"
					href="<c:url value="/cars/${tempCars.plates}"></c:url>"><i class="unhide icon"></i>
					View/Edit</a>
						
						
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<script type="text/javascript">
	$("[name='deleteCar']").click(function() {
		var urlCall = "<c:url value="/api/cars/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('plates'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/cars/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>
