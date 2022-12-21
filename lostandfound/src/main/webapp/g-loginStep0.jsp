<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>

<body class="vsc-initialized">
	<style>
#regform {
	    width: 100%;
    /* margin-top: 10%; */
    display: flex;
    /* padding-left: 30%; */
    /* padding-top: 3%; */
    justify-content: center;
}
</style>
	<div style="width: 100vw; height: 100vh;">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary"
			style="position: relative; height: 8%;">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">Lost &amp; Found</a>
				<button class="navbar-toggler collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor01"
					aria-controls="navbarColor01" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="navbar-collapse collapse" id="navbarColor01" style="">
					<ul class="navbar-nav me-auto">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
							href="g-lostArticle.jsp" role="button" aria-haspopup="true"
							aria-expanded="false">분실물</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="g-lostArticle.jsp">분실물 찾기</a> <a
									class="dropdown-item" href="g-lostReg.jsp">분실물 신고</a>

							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
							href="g-foundArticle.jsp" role="button" aria-haspopup="true"
							aria-expanded="false">습득물</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="g-foundArticle.jsp">습득물 찾기</a> <a
									class="dropdown-item" href="g-foundReg.jsp">습득물 신고</a>

							</div></li>
						<li class="nav-item"><a class="nav-link" href="myPage.jsp">내정보</a></li>

					</ul>
					<!-- <form class="d-flex">
					<input class="form-control me-sm-2" type="search" placeholder="Search">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				</form> -->
				</div>
			</div>
		</nav>

		<div
			style="width: 100%; height: 92%; position: absolute; background-color: #1f5b8308; display: flex; align-items: center;">
			<form id="regform">

				<fieldset id="legLost"
					style="width: 25%; border: 1px solid lightgray; border-radius: 10px; background-color: white;
	/* display: flex; */ padding: 3%;">
					<legend>LOG IN</legend>

					<div class="form-group">
						<label for="exampleInputID" class="form-label mt-4">ID</label> <input
							type="id" class="form-control" id="exampleInputID" name ="MM_ID" 
							placeholder="ID를 입력하세요">

					</div>


					<div class="form-group" style="margin-bottom: 10%;">
						<label for="exampleInputPassword" class="form-label mt-4">Password</label>
						<input type="password" class="form-control"
							id="exampleInputPassword" placeholder="Password를 입력하세요" name="MM_PW">

					</div>

					<div style="width: 100%; text-align: center;  margin-top:5%">
						<div style="width: 30%;" class="btn btn-primary" onclick="Login()">Log in</div>
					</div>



				</fieldset>
			</form>
		</div>
	</div>


	<script src="resources/js/common.js"></script>
	<script src="resources/js/common.js"></script>
	<script>
		function Login() {
			const form = createForm("", "Login", "post");

			let loginData = [];
			let submitResult = false;

			loginData.push(document.getElementsByName("MM_ID")[0]);
			loginData.push(document.getElementsByName("MM_PW")[0]);

			for (let i = 0; i < loginData.length; i++) {
				submitResult = lengthCheck(loginData[i]);

				if (submitResult) {
					form.appendChild(loginData[i]);
				} else
					break;

			}
			if (submitResult) {
				document.body.appendChild(form);
				form.submit();
			}

		}
	</script>
</body>
</html>