<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lost and Found</title>

<script src="resources/js/common.js" ></script>
<link rel="stylesheet" href="resources/css/common.css">
<style>

#txtsignlogo {
	border: none;
	font-size: 4vw;
	background: transparent;
	color: rgba(37, 48, 78, 1);
	font-weight: bold;

	position: absolute;
	top: 25%;
	left: 70%;
	transform: translate(-50%, -50%);
}
.btn.centerManagement{
	top: 83%;
	left: 40%;
	transform: translate(-52%, -50%);
}	
.btn.centerPerformance {
	top: 83%;
	left: 50%;
	transform: translate(-58%, -50%);
}	
.btn.centerCreate{
	top: 83%;
	left: 60%;
	transform: translate(-58%, -50%);
}	
</style>

</head>

<body onLoad="pageInit('${param.message}')">
	<div id="wrap">
		<div id="header">
			<input type="text" id="teamname" value="Lost and Found" > </input>
			<input type="text" id="teammember" value="김준석,이예림,이정한,황영현" > </input>
			</div>
			
			<div id="signup">	
				<input type="button" class="btn Management" value="Management" onClick="movePage("c-management.jsp","")"></input>
				<input type="button" class="btn Matching" value="Matching" onClick="movePage("c-matching.jsp","${ceterCode}")"></input>
			</div>
			
			<div id="footer"></div>
	</div>
	<!-- MessageBox -->
	<div id="messagebackground" style="display: none">
		<div id="messageBox">
			<div id="messageTitle">Message Title</div>
			<div id="messageZone">
				<div id="messageContent">Server Message</div>
			</div>
			<div id="messageAction">
				<div class="button solo" onClick="disableMessage()">확인</div>
			</div>
		</div>
	</div>

</body>
<script>
	
</script>
</html>