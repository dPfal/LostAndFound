<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Lost and Found</title>

<script src="resources/js/com.js"></script>

<link rel=" stylesheet" href="resources/css/bootstrap.min.css">
<link rel=" stylesheet" href="resources/css/bootstrap.css">
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

.btn.centerManagement {
	top: 83%;
	left: 40%;
	transform: translate(-52%, -50%);
}

.btn.centerPerformance {
	top: 83%;
	left: 50%;
	transform: translate(-58%, -50%);
}

.btn.centerCreate {
	top: 83%;
	left: 60%;
	transform: translate(-58%, -50%);
}
</style>

</head>

<body onLoad="pageInit('${param.message}')">
	<div id="wrap">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Lost & Found</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor01"
					aria-controls="navbarColor01" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
							href="#" role="button" aria-haspopup="true" aria-expanded="false">분실물</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">분실물 찾기</a> <a
									class="dropdown-item" href="#">분실물 신고</a>

							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
							href="#" role="button" aria-haspopup="true" aria-expanded="false">습득물</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">습득물 찾기</a> <a
									class="dropdown-item" href="#">습득물 신고</a>

							</div></li>
						<li class="nav-item"><a class="nav-link" href="#">내정보</a></li>

					</ul>
					<!-- <form class="d-flex">
					<input class="form-control me-sm-2" type="search" placeholder="Search">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				</form> -->
				</div>
			</div>
		</nav>

		<div id="signup">
			<input type="button" class="btn Management" value="Management"
				onClick="movePage('c-management.jsp','')"></input> <input
				type="button" class="btn Matching" value="Matching"
				onClick="movePage('c-matching.jsp','${ceterCode}')"></input>
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