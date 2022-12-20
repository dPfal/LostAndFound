<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel=" stylesheet" href="resources/css/bootstrap.min.css">
<link rel=" stylesheet" href="resources/css/bootstrap.css">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">Lost & Found</a>
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
	${message}
</body>
</html>