<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/common.js" ></script>
<link rel="stylesheet" href="resources/css/common.css">
</head>
<body onLoad="CalPercentage()">
	
	${CalPerformance }
	
</body>
<script>
	function CalPercentage(){
		const form = createForm("", "CalPercentage", "get");
		document.body.appendChild(form);
		form.submit();
	}
</script>
</html>