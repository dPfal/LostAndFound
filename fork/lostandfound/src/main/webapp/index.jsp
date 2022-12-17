<html>
<head>
<meta charset="UTF-8">
<title>Lost and Found</title>
<script src="resources/js/common.js" ></script>
<link rel="stylesheet" href="resources/css/common.css">
</head>
<body>
<div id="wrap">
	<div id="header">
			<input type="text" id="teamname" value="Lost and Found" > </input>
			<input type="text" id="teammember" value="김준석,이예림,이정한,황영현" > </input>
			</div>
	
	<div id="signup">
			<img class="logo" src="resources/images/Logo.png" >	
			<input type="button" class="btn login" value="Log in" onClick="moveLoginPage()"></input>
			<input type="button" class="btn sign" value="Sign up" onClick="moveSignPage()"></input>		
	</div>
	<div id="messagebackground" style="display: none">
			<div id="lightBox">
				<div id="messageTitle">Message Title</div>
				<div id="messageZone">
					<div id="messageContent">Server Message</div>
				</div>
				<div id="messageAction">
					<div class="button solo" onClick="disableMessage()">확인</div>
				</div>
			</div>
	</div>
</div> 
</body>
<script>
	function moveLoginPage()
	{
		const form = createForm("","LoginMove","get");
		document.body.appendChild(form);
		form.submit();
	}
	function moveSignPage()
	{
		const form = createForm("","Join","get");
		document.body.appendChild(form);
		form.submit();
	}
</script>
</html>