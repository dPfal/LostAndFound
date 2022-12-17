<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		.gtxt.id {
			top: 400px;
			left: 300px;
		}
		.gtxt.ceo {
			top: 480px;
		}
		.gtxt.pin {
			top: 560px;
			right : 300px;
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

<body onLoad="pageInit('${message}')">
	<div id="wrap">
		<div id="header">
			<input type="text" id="teamname" value="Lost and Found" > </input>
			<input type="text" id="teammember" value="김준석,이예림,이정한,황영현" > </input>
			</div>

		<div class="messagebackground b1" style="display:block">
			<div class="storeStepBox l1">
				${centerInfo }
				<div class="nbox">
					<span class="CenterBackButton" onClick="movePage('${param.previous}','${GROUPNAME}')">Back</span>
					<span class="CenterListButton" onClick="centerCall()">Center call</span>
					<span class="CenterSelect" onClick="centerSelect()">Center select</span>
				</div>
			</div>
		</div>
		<div class="messagebackground b2" style="display:block">
			<div class="storeStepBox l2">
				${laList }
				${faList }
				<textarea cols="50" rows="10" name="txtarea" value=""></textarea>
				<div class="nbox">
					<span class="CenterFoundListButton" onClick="callFoundList(${centerCode})">Call Found List</span>
					<span class="CenterLostListButton" onClick="callLostList(${centerCode})">Call Lost List</span>
				</div>
			</div>
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
	function chageLaSelect(){  
		const select = document.getElementsByName("LaList")[0];
		select.selectedIndex
		
	}
	function chageFaSelect(){  
		const select = document.getElementsByName("FaList")[0];
		
	}
	function callLostList(centerCode){
		const form = createForm("", "CallLostList", "get");
		form.appendChld(createInputBox("hidden", "centerCode", selectcode, ""));
		document.body.appendChild(form);
		form.submit();
	}
	function callFoundList(centerCode){
		const form = createForm("", "CallFoundList", "get");
		form.appendChld(createInputBox("hidden", "centerCode", selectcode, ""));
		document.body.appendChild(form);
		form.submit();
	}
	function centerSelect(){
		const form = createForm("", "CenterSelect", "get");
		const selectbox =document.getElementsByClassName("centerInfo")[0];
		const selectname= selectbox.options[select.selectedIndex].val(); 
		const selectcode= selectbox.options[select.selectedIndex].innerHTML();
		form.appendChld(createInputBox("hidden", "selectName", selectname, ""));
		form.appendChld(createInputBox("hidden", "selectCode", selectcode, ""));
		document.body.appendChild(form);
		form.submit();
	}
	function centerCall() {
		const form = createForm("", "CenterCall()", "get");
		document.body.appendChild(form);
		form.submit();
	}
</script>

</html>