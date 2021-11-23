<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" nonce="f9d76f0fbeb54f7ea2a9ea1324a"
	src="//local.adguard.org?ts=1634862422856&amp;type=content-script&amp;dmn=swiperjs.com&amp;app=chrome.exe&amp;css=1&amp;js=1&amp;gcss=1&amp;rel=1&amp;rji=1&amp;sbe=0&amp;stealth=1&amp;uag="></script>
<script type="text/javascript" nonce="f9d76f0fbeb54f7ea2a9ea1324a"
	src="//local.adguard.org?ts=1634862422856&amp;name=AdGuard%20Popup%20Blocker&amp;name=AdGuard%20Extra&amp;type=user-script"></script>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 
Servers의 Tomcat 파일 server.xml의 content 밑에 추가하기 
<Context docBase="D:\fileserver" path="/TestProject/images/" reloadable="true"/> */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}
.span{
		color: red;
	}
ul li {
	list-style-type: none;
}

.loginbar ul>li {
	float: left;
}

nav {
	display: flex;
}
.navbar{
	border-bottom: 1px solid #eee;
}

.container-fluid barList {
	height: 100px;
	backgorund:#FFFFFF;
}

.barList {
	display: flex;
}

.lecturelist {
	float: left;
	width: 33%;
	height: 33%;
	display: flex;
	flex-direction: column;
	padding: 30px;
}

.lecturelist>div:nth-child(1) {
	width: 100%;
	height: 80%;
}

.lecturelist>div:nth-child(2) {
	width: 100%;
	height: 20%;
	font-size: 15px;
}

.lecturelist>div:nth-child(2)>ul>li {
	float: none;
}

.swiper-slide>div {
	display: flex;
}

	.searchbox {
	width: 300px;
	height: 40px;
	border-radius: 22px 22px 22px 22px;
	border: 2px solid #eee;
	box-shadow: 0px 1px 2px 1px gray;
}

.category {
	display: flex;
	justify-content: center;
}

html, body {
	position: relative;
}

body {
	background: #eee;
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	overflow: scroll;
}

ul li {
	list-style-type: none;
	float: left;
}

.card-body ul li {
	width: 100%;
	height: 100%;
}

.swiper {
	width: 100%;
}

section {
	display: flex;
}

.swiper-slide {
	width: 100%;
	height: 100%;
	padding-top:50px;
	text-align: center;
	font-size: 18px;
	background: #fff;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: contain;
}

.swiper {
	margin-left: auto;
	margin-right: auto;
}

.mySwiper {
	display: flex;
	width: 100%;
	height: auto;
}

.swiper-pagination {
	display: flex;
	justify-content: center;
	top: 10px;
	height: 70px;
}

.swiper-wrapper {
	display: flex;
	width: 100%;
}

.swiper-pagination-bullet {
	display: flex;
	border-radius: 0px;
	width: 80px;
	height: 40px;
	justify-content: center;
	line-height: 20px;
	font-size: 12px;
	color: #000;
	opacity: 1;
	background: rgba(0, 0, 0, 0.2);
	align-items: center;
}
.interest , .Popularity{
	width: 100%;
	height: 100%;
}
.lectureul {
	width: 100%;
	height:1200px;
	top:200px;
}

.swiper-pagination-bullet-active {
	color: #fff;
	background: #007aff;
}
  .logo_img{
            width: 150px;
      }
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-white">
			<div class="container-fluid barList">
				<div>
					<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
				</div>
				<div>
					<form method="post" action="lecture_search2">
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
					<ul>
						<li>${membername}</li>
						<li><a class="nav-link" href="logout">로그아웃</a></li>
						<li><a class="nav-link" href="general_qna_list">QnA</a></li>
						<li><a class="nav-link" href="myProfile">마이페이지</a></li>
						<li><a class="nav-link" href="lecture_input">강의개설</a></li>
						<li><a class="nav-link" href="#">장바구니</a></li>
					</ul>
				</c:if>
			</div>
		</nav>
	</header>
	<section>
		<div class="swiper mySwiper">
			<ul class="swiper-pagination">
			</ul>
			<div class="swiper-wrapper">
			
				<div class="swiper-slide">
					<div class="Popularity">
						<ul class="lectureul">
							<c:forEach var="lecture" items="${lectureListPopularity}">
								<li class="lecturelist">
									<div>
										<a href="lecture_detail?lectureno=${lecture.lectureno}"><img
											src="/TestProject/images/${lecture.imagename}" /></a>
									</div>
									<div>
										<ul>
											<li>강의명: ${lecture.name}</li>
											<li>강사: ${lecture.username}</li>
											<li>시작일: ${lecture.startdate}</li>
										</ul>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				
				<c:forEach var="ListInList" items="${ListInList}" varStatus="status">
				<div class="swiper-slide">
						<div class="interest int${status.count}">
							<ul class="lectureul">
								<c:forEach var="lecture" items="${ListInList}">
									<li class="lecturelist">
										<div>
											<a href="lecture_detail?lectureno=${lecture.lectureno}"><img
												src="/TestProject/images/${lecture.imagename}" /></a>
										</div>
										<div>
											<ul>
												<li>강의명: ${lecture.name}</li>
												<li>강사: ${lecture.username}</li>
												<li>시작일: ${lecture.startdate}</li>
											</ul>
										</div>

									</li>
								</c:forEach>
							</ul>
						</div>
				</div>
				</c:forEach>
				<c:if test="${member != null}">
				<div class="swiper-slide">
					<div class="Popularity">
						<ul class="lectureul">
							<c:forEach var="lecture" items="${lectureListInterest}">
								<li class="lecturelist">
									<div>
										<a href="lecture_detail?lectureno=${lecture.lectureno}"><img
											src="/TestProject/images/${lecture.imagename}" /></a>
									</div>
									<div>
										<ul>
											<li>강의명: ${lecture.name}</li>
											<li>강사: ${lecture.username}</li>
											<li>시작일: ${lecture.startdate}</li>
										</ul>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				</c:if>
			</div>
			
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		
		</div>
	</section>
	<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper(".mySwiper", {
			slidesPerView : 1,
			spaceBetween : 30,
			loop : true,
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
				renderBullet : function(index, className) {

					return ('<li class="' + className + " " + "interest"
							+ (index + 1) + '"></li>');
					// return '<span class="' + className + '">' + (index + 1) + "</span>";
				}
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
		var List1 = document.querySelector("li.interest1");
		List1.innerHTML = "인기 많은 강의";
		var count=2;
		<c:forEach var="interest" items="${interestList}" varStatus="status">
		var Interest = "${interest.int_name}";
		var List = document.querySelector("li.interest${status.count+1}");
		List.innerHTML = "${interest.int_name}";
		count=count+1;
		</c:forEach>
		
		if ("${member}"!=null) {
			var List2 = document.querySelector("li.interest"+count);
			List2.innerHTML = "관심 강의 추천";
		}
			

	</script>
</body>
</html>