<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
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
	width: 100%;
	height:1200px;
	top:200px;
	}
	.lecturelist{
	float: left;
	width: 33%;
	height: 33%;
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
.lecturelist>div:nth-child(1) {
	width: 100%;
	height: 80%;
}

.lecturelist>div:nth-child(2) {
	width: 100%;
	height: 20%;
	font-size: 15px;
}
  .logo_img{
            width: 150px;
      }
.interestList{
     display:flex;
     justify-content:space-around;
     align-items: center;
     magin: 20px 20px 20px 20px;
     width:100%;
     height:50px;
 }
	.interestList>li{
      	float: left;
      	display:flex;
     	justify-content: center;
    	 align-items: center;
     	 background: #98E0AD;     
     	 height:100%;
		width:100%;
		border: 1px solid #fff;
	}
.interestList>li a:hover{  
	height:100%;
	width:100%;
	background:#138535;
	color:#fff;
	display:flex;
    justify-content: center;
    align-items: center;
}
.interestListDiv{
	background-color:#F1F1F1;
	padding-top:20px;
	display:flex;
	flex-direction: column;
	align-items: center;
}
.navbar{
	border-bottom: 1px solid #eee;
}

.container-fluid barList {
	height: 100px;
	backgorund:#FFFFFF;
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
	<div class="interestListDiv">
	<h3>종목별 전체 강의 검색</h3>
	<ul class="interestList">
		<c:forEach var="interest" items="${interestList}" varStatus="status">
			<li class="interest${status}"><a href="interest_search?int_no=${interest.int_no}">${interest.int_name}</a></li>
		</c:forEach>
	</ul>
	</div>
<ul class="lectureul">
	<c:forEach var="lecture" items="${lectureList}">
	<li class="lecturelist">
		<div>
			<a href="detail_init?lectureno=${lecture.lectureno}">
				<img src="/TestProject/images/${lecture.imagename}" />
			</a>
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

</body>
</html>