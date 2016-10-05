<body>
	<div id="header">
		<h1 align="center" style="background-color: red">LOGIN</h1>
	</div>
	<div id="content">
		<div ng-controller="MyController">
			<form name="myLogin">
				Enter Your ID :<input type="text" id="id" name="id" ng-model="userDetails.id"/><br/><br/>
				Password:<input type="text" id="password" name="password" ng-model="userDetails.password"/><br/><br/>
				
				<button ng-click="getDataFromServer()" >Fetch data from Server</button>
				<div ng-show="person">
					<p>First Name : {{person.name}}</p>
					<p>Telephone Number : {{person.telephone}}</p>
					<p>Email : {{person.email}}</p>
				</div>
				<div ng-show="error">
					<p>Error :{{error}}</p>
				</div>
			</form>
			<br/>
			
		</div>
	</div>
	<div id="footer"></div>
</body>
