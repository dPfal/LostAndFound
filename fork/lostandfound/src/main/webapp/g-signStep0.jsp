<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<style>
#regform {
	width: 25%;

}
</style>
</head>
<body class="vsc-initialized">

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">Lost &amp; Found</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="g-lostArticle.jsp" role="button" aria-haspopup="true" aria-expanded="false">분실물</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="g-lostArticle.jsp">분실물 찾기</a> <a class="dropdown-item" href="g-lostReg.jsp">분실물 신고</a>

						</div></li>
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="g-foundArticle.jsp" role="button" aria-haspopup="true" aria-expanded="false">습득물</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="g-foundArticle.jsp">습득물 찾기</a> <a class="dropdown-item" href="g-foundReg.jsp">습득물 신고</a>

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

	<div style="
    /* text-align: center; */
    display: flex;
    justify-content: center;
"><form id="regform" style="
    margin: 3%;
">

		<fieldset id="legLost">
			<h1>Sign in</h1>
<small>(*) 표시는 필수 입력 항목입니다.</small><br><br>
<hr>
			<div class="form-group">
				<label for="exampleInputID" class="form-label mt-4">* 아이디</label> <input type="id" class="form-control" id="exampleInputID" aria-describedby="IDhelp" placeholder="아이디를 입력하세요"> <small id="IDHelp" class="form-text text-muted">아이디는 최소3글자에서
					10글자이내로 입력하세요. </small>
			</div>


			<div class="form-group">
				<label for="exampleInputPassword" class="form-label mt-4">* 비밀번호</label>
				<input type="password" class="form-control" id="exampleInputPassword" aria-describedby="Passwordhelp" placeholder="비밀번호를 입력하세요"> <small id="IDHelp" class="form-text text-muted">비밀번호는 최소 6글자에서 20글자이내로
					입력하세요. </small>
			</div>

			<div class="form-group">
				<label for="exampleInputName" class="form-label mt-4">* 이름</label> <input type="Name" class="form-control" id="exampleInputName" aria-describedby="Namehelp" placeholder="이름을 입력하세요"> <small id="IDHelp" class="form-text text-muted">이름은 최소 2글자에서
					5글자이내로 입력하세요. </small>
			</div>



			<div class="form-group">
				<label for="exampleInputEmail" class="form-label mt-4">이메일</label> <input type="email" class="form-control" id="exampleInputEmail" placeholder="이메일을 입력하세요.">
			</div>


			<div class="form-group">
				<label for="exampleSelect" class="form-label mt-4">* 성별</label>
				<select class="form-select" id="exampleSelect1">
					<option>남성</option>
					<option>여성</option>
				</select>
			</div>

			<div class="form-group" style="
    display: flex;
    justify-content: space-between;
">
				<label for="exampleInputPhone" class="form-label mt-4">* 휴대폰번호<input type="text" class="form-control" placeholder="010-0000-0000" id="inputDefault"></label>
				 <label for="exampleSelect" class="form-label mt-4" style="
    width: 40%;
">* 통신사<select class="form-select" id="exampleSelect1">
					<option>SKT</option>
					<option>KT</option>
					<option>LGU+</option>
				</select></label> 
			</div>


			<div class="form-group">
				<label for="exampleInputAddress" class="form-label mt-4">* 주소</label>
				<input type="Address" class="form-control" id="exampleInputAddress" aria-describedby="addresshelp" placeholder="주소를 입력하세요."> <small id="IDHelp" class="form-text text-muted">거주지의 시,군,구 도로명
					입력해주세요. </small>
			</div>

			<div class="form-group">
				<label for="exampleInputAddressDetail" class="form-label mt-4">상세주소</label>
				<input type="AddressDetail" class="form-control" id="exampleInputAddressDetail" aria-describedby="AddressDetailhelp" placeholder="상세주소를 입력하세요."> 

				<div style="width: 100%;" text-align:center;="" "padding:="" 10%"=""></div>
				<div style="
    width: 100%;
    text-align: center;
    padding: 10%;
"><div style="width: 40%;" class="btn btn-primary" onclick="registration()">등록</div></div>

</div>

			</fieldset></form></div>
		
	





<script src="resources/js/common.js"></script>
<script>
	function registration() {
		const form = createForm("", "MemberJoin", "post");
		const ServerLayer = document.getElementById("Signup");
		let group = [];
		let submitResult = false;

		member.push(document.getElementsByName("Login")[0]);
		member.push(document.getElementsByName("Passward")[0]);
		member.push(document.getElementsByName("Name")[0]);

		for (let i = 0; i < member.length; i++) {
			submitResult = lengthCheck(group[i]);
			if (submitResult) {
				form.appendChild(group[i]);
			} else {
				//removeChild(group[i]);
				break;
			}

		}
		if (submitResult) {
			ServerLayer.appendChild(form);
			form.submit();
		}
	}
</script>
</body></html>