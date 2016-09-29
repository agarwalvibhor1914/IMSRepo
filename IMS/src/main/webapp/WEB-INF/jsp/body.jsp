<body>
	<div id="header"></div>
        <div id="content"><div>
		<div ng-controller="MyController">
			<button ng-click="getDataFromServer()" >Fetch data from Server</button>
			<p>First Name : {{person.name}}</p>
			<p>Telephone Number : {{person.telephone}}</p>
			<p>Email : {{person.email}}</p>
		 </div>
		 </div>
    </div>
    <div id="footer"></div>
	
</body>