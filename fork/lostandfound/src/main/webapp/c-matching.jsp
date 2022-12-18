<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onLoad="matching(${ceterCode})">
${mathcingResult }
	
</body>
<script type="text/javascript">
	function matching(centerCode){
		const form = createForm("", "LFMatching", "get");
		form.appendChld(createInputBox("hidden", "centerCode", centerCode, ""));
		document.body.appendChild(form);
		form.submit();
	}
</script>
</html>