<html ng-app="myApp">
<head>
<meta charset="ISO-8859-1">
<title>AJAX with Servlets using AngularJS</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="js/myController.js"></script>
</head>
<body>
	<div>
		<div ng-controller="MyController">
			<button ng-click="getDataFromServer()">Fetch data from Server</button>
			<p>First Name : {{person.name}}</p>
			<p>Last Name : {{person.telephone}}</p>
		</div>
	</div>
</body>
</html>

