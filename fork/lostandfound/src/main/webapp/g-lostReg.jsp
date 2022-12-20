<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8"">
<title>분실물 신고</title>
<link rel=" stylesheet" href="resources/css/bootstrap.min.css">
<link rel=" stylesheet" href="resources/css/bootstrap.css">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<style>
#regform {
	width: 70%;
	padding-left: 30%;
	padding-top: 3%;
}

.textalign {
	text-align: center;
	margin-top: 3%;
}

.width50 {
	width: 25%;
}

small {
	font-size: 12px;
}
</style>
</head>
<script src="resources/js/common.js"></script>
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

	<form id="regform">
		<h1>Report Lost</h1>

		<small>분실물 신고양식입니다. (*) 표시는 필수 입력 항목입니다.</small>
		<hr>

		<h5>분실 정보 입력</h5>

		<fieldset id="regLost">
			<div class="form-group">

				<label for="exampleSelect1" class="form-label mt-4"> * 관할 센터</label>
				<div style="display: flex; align-items: center;">
					<select style="width: 20%; margin-right: 10px;" class="form-select"
						name="center">


						<option value="">선택</option>
						<option value="C101000">서울</option>
						<option value="C109000">강원</option>
						<option value="C102000">경기</option>
						<option value="C110000">경남</option>
						<option value="C111000">경북</option>
						<option value="C103000">광주</option>
						<option value="C104000">대구</option>
						<option value="C105000">대전</option>
						<option value="C106000">부산</option>
						<option value="C107000">울산</option>
						<option value="C108000">인천</option>
						<option value="C112000">전남</option>
						<option value="C113000">전북</option>
						<option value="C115000">충남</option>
						<option value="C114000">충북</option>
						<option value="C116000">제주</option>
						<option value="C117000">세종</option>
					</select> 분실물 센터

				</div>

			</div>
			<div class="form-group">
				<label for="exampleSelect1" class="form-label mt-4">* 분실 지역</label>
				<select class="form-select" name="location">
					<option value="">선택</option>
					<option value="101000">서울특별시</option>
					<option value="109000">강원도</option>
					<option value="102000">경기도</option>
					<option value="110000">경상남도</option>
					<option value="111000">경상북도</option>
					<option value="103000">광주광역시</option>
					<option value="104000">대구광역시</option>
					<option value="105000">대전광역시</option>
					<option value="106000">부산광역시</option>
					<option value="107000">울산광역시</option>
					<option value="108000">인천광역시</option>
					<option value="112000">전라남도</option>
					<option value="113000">전라북도</option>
					<option value="115000">충청남도</option>
					<option value="114000">충청북도</option>
					<option value="116000">제주특별자치도</option>
					<option value="117000">세종특별자치시</option>
					<option value="118000">기타</option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleSelect1" class="form-label mt-4"> * 분실 장소
					분류</label> <select class="form-select" name="place">

					<option value="">선택</option>
					<option value="PL1001">버스</option>
					<option value="PL1002">택시</option>
					<option value="PL1003">지하철</option>
					<option value="PL1004">공항</option>
					<option value="PL1005">기차</option>
					<option value="PL1006">회사</option>
					<option value="PL1007">학교</option>
					<option value="PL1008">공공기관</option>
					<option value="PL1009">놀이공원</option>
					<option value="PL1010">유원지</option>
					<option value="PL1011">우체통</option>
					<option value="PL1012">백화점</option>
					<option value="PL1013">상점</option>
					<option value="PL1014">음식점</option>
					<option value="PL1015">기타</option>
					<option value="PL1016">노상</option>
					<option value="PL1017">모름</option>

				</select>
			</div>
			<div class="form-group">
				<label class="col-form-label mt-4" for="inputDefault">분실 장소
					상세</label> <input type="text" class="form-control" placeholder=""
					name="placeDetail">
			</div>
			<div class="form-group">
				<label class="col-form-label mt-4" for="inputDefault">* 분실
					날짜</label> <input type="text" class="form-control" placeholder=""
					name="date">
			</div>
			<br>
			<hr>

			<h5>물품 정보 입력</h5>
			<div class="form-group">
				<label class="col-form-label mt-4" for="inputDefault">* 글 제목</label>
				<input type="text" class="form-control" placeholder="" name="title">
				<small>분실물 목록에 표시되는 제목입니다. ex) 휴대폰분실</small>

			</div>
			<div>
				<span class="form-group" style="float: left; margin-right: 5%;">
					<label for="exampleSelect1" class="form-label mt-4">* 대분류</label> <select
					class="form-select" name="MainCategories"
					onchange="categoryChange(this)">

						<option value="">대분류 선택</option>
						<option value="BA">가방</option>
						<option value="BO">도서</option>
						<option value="IN">악기</option>
						<option value="CL">의류</option>
						<option value="EL">전자기기</option>
						<option value="WA">지갑</option>
						<option value="CE">증명서</option>
						<option value="CR">카드</option>
						<option value="CA">현금</option>
						<option value="ET">기타</option>
				</select>
				</span> <label for="exampleSelect1" class="form-label mt-4">* 소분류</label> <select
					class="form-select width50" name="SubCategories">

					<option value="">소분류 선택</option>

				</select>

			</div>
			<div class="form-group">
				<label for="exampleSelect1" class="form-label mt-4"> * 물품 색상</label>
				<select class="form-select" name="color">

					<option value="">선택</option>
					<option value="흰색">흰색</option>
					<option value="검은색">검은색</option>
					<option value="회색">회색</option>
					<option value="빨간색">빨간색</option>
					<option value="주황색">주황색</option>
					<option value="노란색">노란색</option>
					<option value="초록색">초록색</option>
					<option value="파란색">파란색</option>
					<option value="남색">남색</option>
					<option value="보라색">보라색</option>
					<option value="갈색">갈색</option>
					<option value="분홍색">분홍색</option>
					<option value="기타">기타</option>

				</select>
			</div>
			<div class="form-group">
				<label class="col-form-label mt-4" for="inputDefault">* 물품명</label>
				<input type="text" class="form-control" placeholder=""
					name="articleName">
			</div>



			<div class="form-group">
				<label for="exampleTextarea" class="form-label mt-4">* 상세 내용</label>
				<textarea class="form-control" name="detail" rows="3"></textarea>
			</div>
			<div class="form-group">
				<label for="formFile" class="form-label mt-4">물품 사진 </label> <input
					class="form-control" type="file" name="img">
			</div>
			<div style="width: 100%; text-align: center; padding: 10%">
				<div style="width: 30%" class="btn btn-primary" onClick="regLost()">등록</div>
			</div>


		</fieldset>
	</form>


</body>

<script>

	function categoryChange(e) {
	
		const category_BA = [ "백팩", "크로스백", "캐리어", "파우치", "쇼퍼백", "에코백", "기타" ];
		const category_BO = [ "잡지", "참고서", "만화책", "소설책", "사전", "기타" ];
		const category_IN = [ "건반악기", "관악기", "타악기", "현악기", "기타" ];
		const category_CL = [ "아우터", "상의", "하의", "스카프/목도리", "신발", "귀금속", "기타" ];
		const category_EL = [ "휴대폰", "노트북", "카메라", "충전기", "음향기기", "기타" ];
		const category_WA = [ "장지갑", "반지갑", "중지갑", "머니클립", "카드지갑", "동전지갑", "기타" ];
		const category_CE = [ "신분증", "면허증", "여권", "기타" ];
		const category_CR = [ "신용카드", "체크카드", "교통카드", "기타" ];
		const category_CA = [ "현금", "수표", "외화", "기타" ];
		const category_ET = [ "기타" ];

		let target = document.getElementsByName("SubCategories")[0];
		let select
		
		select = eval("category_"+e.value);
		<!-- eval : 지양해야 하는 함수 -->
		
		<!--
		if(e=="BA"){
			select = category_BA;
		}
		else if(e=="BO"){
			select = category_BO;
		}
		-->
		
		target.options.length = 0;
		for (x in select) {
			let opt = document.createElement("option");
			opt.value = '0'+x;//select[x];
			opt.innerHTML = select[x];
			target.appendChild(opt);
			
		}

	}
	
		
	function regLost(){
		
		const form = createForm("","RegLost","post");
		
		let lostData = [];
		
		lostData.push(createInputBox("hidden","center",document.getElementsByName("center")[0].options[document.getElementsByName("center")[0].selectedIndex].value,""));
		lostData.push(createInputBox("hidden","location",document.getElementsByName("location")[0].options[document.getElementsByName("location")[0].selectedIndex].value,""));
		lostData.push(createInputBox("hidden","place",document.getElementsByName("place")[0].options[document.getElementsByName("place")[0].selectedIndex].value,""));
		lostData.push(document.getElementsByName("placeDetail")[0]);
		lostData.push(document.getElementsByName("date")[0]);
		lostData.push(document.getElementsByName("title")[0]);
		lostData.push(createInputBox("hidden","MainCategories",document.getElementsByName("MainCategories")[0].options[document.getElementsByName("MainCategories")[0].selectedIndex].value,""));
		lostData.push(createInputBox("hidden","SubCategories",document.getElementsByName("SubCategories")[0].options[document.getElementsByName("SubCategories")[0].selectedIndex].value,""));
		lostData.push(createInputBox("hidden","color",document.getElementsByName("color")[0].options[document.getElementsByName("color")[0].selectedIndex].value,""));
		lostData.push(document.getElementsByName("articleName")[0]);
		lostData.push(document.getElementsByName("detail")[0]);
		 
		
		for (let i = 0; i < lostData.length; i++) {
			form.appendChild(lostData[i]);
		}
		
		document.body.appendChild(form);
		form.submit();
		}
	
</script>

</html>