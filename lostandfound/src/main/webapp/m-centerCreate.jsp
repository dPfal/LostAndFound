<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lost and Found</title>
<script src="resources/js/common.js"></script>
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

.gtxt.id {
	top: 400px;
	left: 300px;
}

.gtxt.ceo {
	top: 480px;
}

.gtxt.pin {
	top: 560px;
	right: 300px;
}

.btn.sign {
	top: 83%;
	left: 40%;
	transform: translate(-52%, -50%);
}

.btn.back {
	top: 83%;
	left: 60%;
	transform: translate(-58%, -50%);
}
</style>

</head>

<body onLoad="pageInit('${param.message}')">
	<div id="wrap">
		<div id="header">
			<input type="text" id="teamname" value="Lost and Found"> </input> <input
				type="text" id="teammember" value="김준석,이예림,이정한,황영현"> </input>
		</div>

		<div id="signup" name="signUp">
			<input type="text" id="txtsignlogo" value="Sign up"></input> <input
				type="text" class="gtxt id" name="CenterId" placeHolder="Center Id"></input>
			<input type="text" class="gtxt pw" name="CenterPw"
				placeHolder="Center Pw"></input> <input type="text"
				class="gtxt code" name="CenterCode" placeHolder="Center Code"></input>
			<input type="text" class="gtxt name" name="CenterName"
				placeHolder="Center Name"></input> <input type="text"
				class="gtxt phone" name="CenterPhone" placeHolder="Center Phone"></input>
			<input type="text" class="gtxt addr" name="CenterAddr"
				placeHolder="Center Addr"></input> <input type="text"
				class="gtxt locode" name="CenterLocode" placeHolder="Center Locode"></input>

			<input type="button" class="btn sign" value="Sign up"
				onClick="centerCreate()"></input> <input type="button"
				class="btn back" value="Back"
				onClick="movePage('${param.previous}','${GROUPNAME}')"></input>
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
	</div>
</body>
<script>
	function centerCreate() {
		const form = createForm("", "CenterCreate", "post");
		const ServerLayer = document.getElementById("signup");
		let group = [];
		let submitResult = false;
		group.push(document.getElementsByName("signUp")[0]);

		for (let i = 0; i < group.length; i++) {
			form.appendChild(group[i]);
		}
		ServerLayer.appendChild(form);
		form.submit();
	}
</script>

</html>