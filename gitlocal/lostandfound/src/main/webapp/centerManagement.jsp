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
					<span class="CenterBackButton" onClick="movePage('masterCtl.jsp','')">Back</span>
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
				<input type=hidden" name="Ctnum" value=""></hidden>
				<div class="nbox">
					<span class="CenterFoundListButton" onClick="callFoundList(${centerCode})">Call Found List</span>
					<span class="CenterLostListButton" onClick="callLostList(${centerCode})">Call Lost List</span>
					<span class="CompleteButton" onClick="complete(${centerCode})"
							style="display: none">Process Complete</span>
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
	function complete(centerCode){
		const form = createForm("", "LFProcessComplete", "get");
		form.appendChld(document.getElementsByName("Ctnum")[0]);
		document.body.appendChild(form);
		form.submit();
	}
	function chageLaSelect(center){  
		const select = document.getElementsByName("LaList")[0];
		const l =center.LAlist(select.selectedIndex);
		const txtarea = document.getElementsByName("txtarea")[0];
		if(txtarea.value != null)
			txtarea.value="";
		
		const str= "[분류코드] : "+l.LaMainCategoryCode+l.LaSubCategoryCode+"\n"
				+  "[관리번호] : "+l.LaControlNumber+"\n"
				+  "[분실물품] : "+l.LaName+"\n"
				+  "[분실장소] : "+l.LaPlace+"\n"
				+  "[분실날짜] : "+l.LaDate+"\n"
				+  "[센터코드] : "+l.LaCenterCode+"\n"
				+  "[분실상태] : "+l.LaStatus+"\n"
				+  "[분실지역] : "+l.LaLocation+"\n"
				+  "[등록날짜] : "+l.LaPostDate+"\n"
				+  "[등록 Id] : "+l.LaPostId+"\n"
				+  "[물품색상] : "+l.LaColor+"\n"
				+  "[상세내용] : "+l.LaDetail;
		
		txtarea.value=str;
		document.getElementsByName("Ctnum")[0].value="L:"+l.LaControlNumber;
		Document.getElementsByClassName("CompleteButton")[0].style.display = "block";
	}
	function chageFaSelect(center){  
		const select = document.getElementsByName("FaList")[0];
		const f =center.FAlist(select.selectedIndex);
		const txtarea = document.getElementsByName("txtarea")[0];
		if(txtarea.value != null)
			txtarea.value="";
		
		const str= "[분류코드] : "+f.FaMainCategoryCode+f.FaSubCategoryCode+"\n"
				+  "[관리번호] : "+f.FaControlNumber+"\n";
		
		txtarea.value=str;
		document.getElementsByName("Ctnum")[0].value="F:"+f.FaControlNumber;
		Document.getElementsByClassName("CompleteButton")[0].style.display = "block";
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