
let publicIp;
/* public ip 수집 */
function getPublicIp(){
	//﻿https://api.ipify.org <-ajax 적용. 
	return "124.54.23.39";
}

function lengthCheck(obj)
{
	const length = [
		["groupName",2,20],["groupCeo",2,5],["groupPin",6,6],
				["storeCode",10,10],["storeName",10,10],["storeZip",10,10],
				["storeAddr",10,10],["storeDaddr",10,10],["storePhone",10,10],
				["empCode",3,3],["empPin",6,6]
			];
	
	let result = null;
	for(let i=0; i<length.length ; i++)
	{
		if(obj.getAttribute("name") == length[i][0]){
			result = (obj.value.length >= length[i][1] &&
			obj.value.length <= length[i][2]) ? true : false;
			break;
		}
	}
	return result;
}
function createForm(name, action, method)
{
	const form = document.createElement("form");
	if(name != "") form.setAttribute("name",name);
	form.setAttribute("action",action);
	form.setAttribute("method",method);
	return form;
}
function pageInit(message)
{
	publicIp=getPublicIp();
	if(message != ''){	
		let serverMessage = message.split(":"); 
		if(serverMessage[1]=="2")
		{
			cmBoxCtl(2);
		}
		else
		{
			let content = document.getElementById("messageContent");
			document.getElementById("messageTitle").innerText = serverMessage[0];
			content.innerText = serverMessage[1];
			document.getElementById("messagebackground").style.display = "block";
			if(serverMessage[2] == "1") content.style.lineHeight = "calc(37.5vh*0.54)";
			if(serverMessage[2] == "2") content.style.lineHeight = "calc(37.5vh*0.54/2)";
			if(serverMessage[2] == "3") content.style.lineHeight = "calc(37.5vh*0.54/3)";
			if(serverMessage[2] == "4") content.style.lineHeight = "calc(37.5vh*0.54/4)";
			if(serverMessage[2] == "5") content.style.lineHeight = "calc(37.5vh*0.54/5)";
		}
	}
}
function disableMessage()
{
	document.getElementById("messageTitle").innerText="";
	document.getElementById("messageContent").innerText="";
	document.getElementById("messagebackground").style.display="none";
}
function createInputBox(type, name, value, placeholder){
	//createInputBox("hidden","center",document.getElementsByName("center")[0].options[document.getElementsByName("center")[0].selectedIndex].value,"")
	const input = document.createElement("input");
	//<input></input>
	input.setAttribute("type", type);
	//<input type="hidden"></input>
	input.setAttribute("name", name);
	//<input type="hidden" name="center"></input>
	if(value != "") input.setAttribute("value", value);
	//<input type="hidden" name="center" value="C113000"></input> 
	if(placeholder != "") input.setAttribute("placeholde", placeholder);
	console.log('create'+input);
	return input;
}
function movePage(targetPage, data){
	const form = createForm("", "MovePage", "get");
	const input=[];
	alert(data);
	input.push(createInputBox("hidden", "target", targetPage, ""));
	input.push(createInputBox("hidden", "data",data,""));
	for (let i = 0; i < input.length; i++) {
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();	
}
