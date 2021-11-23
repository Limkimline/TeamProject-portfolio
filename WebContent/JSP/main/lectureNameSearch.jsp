<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

ul li {
	list-style-type: none;
}

.loginbar ul>li {
	float: left;
}

a {
	text-decoration: none;
}

.searchbox {
	width: 300px;
	height: 40px;
	border-radius: 22px 22px 22px 22px;
	border: 2px solid #eee;
	box-shadow: 0px 1px 2px 1px gray;
}

.lectureul {
	width: 80%;
	height: 1200px;
	top: 200px;
}

.lecturelist {
	float: left;
	width: 47%;
	height: 47%;
	display: flex;
	flex-direction: column;
	padding: 30px;
}

img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: contain;
}

.logo_img {
	width: 150px;
}

.interestList {
	display: flex;
	justify-content: space-around;
	align-items: center;
	magin: 20px 20px 20px 20px;
	width: 100%;
	height: 50px;
}

.interestList>li {
	float: left;
	display: flex;
	justify-content: center;
	align-items: center;
	background: #98E0AD;
	height: 100%;
	width: 100%;
	border: 1px solid #fff;
}

.interestList>li a:hover {
	height: 100%;
	width: 100%;
	background: #138535;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
}

.interestListDiv {
	background-color: #F1F1F1;
	padding-top: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.navbar {
	border-bottom: 1px solid #eee;
}

.container-fluid barList {
	height: 100px;
	backgorund: #FFFFFF;
}

.noresult {
	color: red;
	text-align: center;
	margin-top: 50px;
}
.iconSection{
text-align:center;
}
.iconSection>input {
	background-color: #7434eb;
	color: white;
	font-weight: 200;
	border: 1px solid #7434eb;
	font-size: 10px;
	margin-top: 5px;
}

.Container {
	height: 100%;
	display: flex;
	flex-direction: column;
	border: 1px solid black;
}

.infoSection {
	height: 50%;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.infoSection>div {
	padding: 5px 0 0 0;
	display: flex;
	font-size: 14px;
	justify-content: center;
	text-align:center;
}

.imageSection {
	display: flex;
	flex-direction: column;
	
	height: 50%;
}

.imageSection a {
	height: 80%;
}

.p {
	margin: 0 2px 2px 0;
}

.lectureName {
	font-size: 17px;
	font-weight: bold;
}

.interest {
	display: flex;
	justify-content: center;
	flex-direction: column;
	align-items: center;
	width: 100%;
	height: 100%;
}

.page {
	display: flex;
	flex-direction: column;
}

.teachName {
	color: #999999;
}

header {
	position: fixed;
	right: 0;
	top: 0;
	height: 57px;
	width: 100%;
	z-index: 50;
}

section {
	margin-top: 57px;
}
</style>
</head>
<body>
	<div class="page">
		<header>
			<nav class="navbar navbar-expand-sm bg-white">
				<div class="container-fluid barList">
					<div>
						<a href="mainPage"><img class="logo_img" src="image/logo.PNG"
							alt="로고"></a>
					</div>
					<div>
						<form method="post" action="lecture_name_search?reqPage=1">
							<label> <input type="text" name="lecturename"
								placeholder=" 제목을 입력해주세요" class="searchbox"> <input
								type="submit" value="검색" class="btn btn-primary">
							</label>
						</form>
					</div>

					<c:if test="${member == null}">
						<div class="loginbar">
							<ul>
								<li><a class="nav-link" href="login_init">로그인</a></li>
								<li><a class="nav-link" href="general_qna_list">QnA</a></li>
								<li><a class="nav-link" href="lecture_input">강의개설</a></li>
							</ul>
						</div>
					</c:if>

					<c:if test="${member != null}">
						<div class="loginbar">
							<ul>
								<li><a class="nav-link" href="#">${membername}</a></li>
								<li><a class="nav-link" href="logout">로그아웃</a></li>
								<li><a class="nav-link" href="general_qna_list">QnA</a></li>
								<li><a class="nav-link" href="myProfile">마이페이지</a></li>
								<li><a class="nav-link" href="lecture_input">강의개설</a></li>
								<li><a class="nav-link" href="#">장바구니</a></li>
							</ul>
						</div>
					</c:if>
				</div>
			</nav>
		</header>
		<section>
			<div class="interestListDiv">
				<h3>종목별 전체 강의 검색</h3>
				<ul class="interestList">
					<c:forEach var="interest" items="${interestList}"
						varStatus="status">
						<li class="interest${status}"><a
							href="lecture_interest_search?int_no=${interest.int_no}&reqPage=1">${interest.int_name}</a></li>
					</c:forEach>
				</ul>

			</div>
			<c:if test="${lectureList==null}">
				<h1 class="noresult">검색 결과가 없습니다.</h1>
			</c:if>
			<div class="interest">
				<ul class="lectureul">
					<c:forEach var="lecture" items="${lectureList}">
						<li class="lecturelist">
							<div class="Container">
								<div class="imageSection">
									<a href="lecture_clickcountUp?lectureno=${lecture.lectureno}"><img
										src="/TestProject/images/${lecture.imagename}" /></a>
									<div class="iconSection">
										<input type="button" value="오리지널 VOD">
									</div>
								</div>
								<div class="infoSection">
									<div class="lectureName">${lecture.name}</div>
									<div class="teachName">강사: ${lecture.username}</div>

									<div class="lecturedate">강의 기간<br> ${lecture.startdate} ~
										${lecture.enddate}</div>
									<div class="lecturetime">강의 시간<br> ${lecture.starttime} ~
										${lecture.endtime}</div>
									<div class="lectureClikc">
										<img src="image/클릭.jpg" style="width:30px; height:30px">
										<p class="p">${lecture.clickcount}</p>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>

				<c:if test="${lectureList!=null}">

					<ul class="pagination justify-content-center pagination-sm">
						<c:if test="${PageGroupResult.beforePage}">
							<li class="page-item"><a class="page-link"
								href="lecture_name_search?reqPage=${PageGroupResult.groupStartNumber-1}&lecturename=${SearchName}">before</a>
							</li>
						</c:if>
						<c:forEach var="index" begin="${PageGroupResult.groupStartNumber}"
							end="${PageGroupResult.groupEndNumber}">
							<c:choose>
								<c:when test="${PageGroupResult.selectPageNumber==index}">
									<li class="page-item active"><a class="page-link "
										href="lecture_name_search?reqPage=${index}&lecturename=${SearchName}">
											${index} </a></li>
								</c:when>

								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="lecture_name_search?reqPage=${index}&lecturename=${SearchName}">
											${index} </a></li>
								</c:otherwise>
							</c:choose>


						</c:forEach>
						<c:if test="${PageGroupResult.afterPage}">
							<li class="page-item"><a class="page-link"
								href="lecture_name_search?reqPage=${PageGroupResult.groupEndNumber+1}&lecturename=${SearchName}">after</a>
							</li>
						</c:if>
					</ul>
				</c:if>
			</div>
		</section>
	</div>
</body>
</html>