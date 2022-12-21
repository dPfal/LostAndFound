<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="resources/js/com.js" ></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onLoad="matching('C108000')">

<!--  "matching(${ceterCode})">
onClick="movePage('c-matching.jsp','C108000')"></input> -->
${mathcingResult }
	
</body>
<script type="text/javascript">
	function matching(centerCode){
		const form = createForm("", "LFMatching", "get");
		form.appendChild(createInputBox("hidden", "centerCode", centerCode, ""));
		document.body.appendChild(form);
		form.submit();
	}
</script>
</html>