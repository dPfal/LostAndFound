<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>CSS PRACTICE</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap')
	;

#wrap {
	height: 100vh;
	width: 100vw;
}

#header {
	height: 5%;
	background-color: rgb(37, 48, 78);
	color: white;
	font-size: 20px;
	text-align: right;
	width: 100%;
	font-family: 'Noto Sans KR', sans-serif;
}

.footerbutton {
	transition-duration: 0.4s;
	background-color: rgb(37, 48, 78);
	color: white;
	font-size: 20px;
	border: 0;
	padding-top: 5px;
	display: inline-block;
	float: left;
	height: 100%;
	font-family: 'Noto Sans KR', sans-serif;
}

.button1 {
	width: 10%;
}

.button2 {
	width: 30%;
}



.footerbutton:hover {
	background-color: rgb(6, 1, 36);
}

#menu1, #menu2 {
	margin-right: 10%;
	margin-left: 10%;
	text-align: center;
}

#menu1 {
	margin-top: 5%
}

#content {
	height: 80%;
}

#footer {
	width: 100%;
	height: 5%;
	color: white;
	font-size: 20px;
	position: fixed;
	bottom: 0;
}

#menus {
	float: left;
	width: 1000%;
	background-color: rgb(37, 48, 78);
	height: 100%;
}

#logout {
	float: right;
	padding: 10px;
	text-align: right;
	width: 5%;
}

#headerleft {
	background-color: rgb(37, 48, 78);
}

img {
	width: 60%;
	height: auto;
	margin-bottom: 20%;
}

.menubutton {
	width: 15%;
	border: 0;
	background-color: rgb(233, 232, 240);
	border-radius: 20px;
	margin: 2%;
	padding-top: 3%;
	padding-bottom: 1%;
	font-size: 20px;
	transition-duration: 0.4s;
	font-family: 'Noto Sans KR', sans-serif;
}

.menubutton:hover {
	background-color: rgb(221, 221, 230);
}

body, content
		html {
	margin: 0px;
	padding: 0px;
}

#hamburger {
	width: 20%;
	height: auto;
}
</style>

</head>
<script>

	function func() {
		alert("ë§¤ì¶ê´ë¦¬");
	}
</script>

<body>
	<div id="wrap">
		<div id="header">
			<div id="headerleft"></div>
			<div id="logout">
				<a href="http://127.0.0.1:5500/web-pos/src/main/webapp/index.html"
					style="color: white; text-decoration-line: none">ë¡ê·¸ìì</a>
			</div>
		</div>

		<div id="content">
			<div id="menu1">
				<button class="menubutton">
					<img src="resources/images/sales.png"><br> ë§¤ì¶ê´ë¦¬
				</button>

				<button class="menubutton">
					<img src="resources/images/product.png"><br>ìíê´ë¦¬
				</button>
				<button class="menubutton">
					<img src="resources/images/customer.png"><br>ê³ ê°ê´ë¦¬
				</button>
			</div>
			<div id="menu2">
				<button class="menubutton">
					<img src="resources/images/store.png"><br> ë§¤ì¥ê´ë¦¬
				</button>

				<button class="menubutton">
					<img src="resources/images/employee.png"><br>ì§ìê´ë¦¬
				</button>
				<button class="menubutton">
					<img src="resources/images/off.png"><br>ì¢ë£
				</button>
			</div>
		</div>

		<div id="footer">
			<button class="footerbutton button1" onclick=func()>
				<img src="resources/images/hamburger.png" id="hamburger">
			</button>
			<button class="footerbutton button2" onclick=func()>ìí</button>
			<button class="footerbutton button2" onclick=func()>íì´ë¸</button>
			<button class="footerbutton button2" onclick=func()>ì£¼ë¬¸ë´ì­</button>
		</div>
	</div>

	</div>
</body>

</html>