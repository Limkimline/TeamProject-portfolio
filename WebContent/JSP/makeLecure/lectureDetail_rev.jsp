<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<title>강의 상세</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	height: 100vh;
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	align-items: center;
	justify-content: center;
	padding-top: 230px;
	/* background: url("D:/7. JobTraining/구디아카데미_국비교육/JAVAWEB_2ndProject/pic/study.jpg") no-repeat; */
}

.fixMenu, .menu_left, .menu_middle, .menu_right {
	display: flex;
	flex-wrap: nowrap;
}

.fixMenu {
	position: fixed;
	width: 100%;
	top: 0;
	left: 0;
	background-color: white;
	justify-content: space-between;
	z-index: 1;
	/* border: 1px solid black; */
}

a img {
	width: 1200px;
}

.menu_left {
	position: relative;
	margin-left: 120px;
	margin-top: 40px;
}

.menu_middle {
	position: relative;
	margin: 0 30px;
}

.menu_right {
	position: relative;
	margin-right: 50px;
}

.menu_list {
	display: flex;
	flex-wrap: nowrap;
	list-style-type: none;
	margin-top: 10px;
	margin: 40px 0;
}

.menu_link {
	margin: 10px 15px;
	white-space: nowrap;
}

.menu_left .img_link {
	margin: 5px;
}

li a {
	text-decoration: none;
	color: black;
	font-size: 15px;
	font-weight: 500;
}

li a:hover {
	color: grey;
}

.relatedSection {
	display: flex;
	flex-direction: row;
}

.relatedSection p {
	margin-right: 15px;
	color: orangered;
}

.Container>.top>.left>div {
	margin-bottom: 15px;
}

.Container {
	display: flex;
	flex-direction: column;
	/*margin-top: 250px;*/
}

#tutorImg {
	cursor: pointer;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	border: 3px solid black;
	margin-right: 20px;
}

.tutorSection {
	display: flex;
	flex-direction: row;
}

.tutorInfo {
	display: flex;
	flex-direction: column;
}

#star {
	color: orangered;
}

#moreInfo {
	width: 500px;
	margin-left: 30px;
}

.infoSection {
	display: flex;
	flex-direction: row;
}

.top {
	margin-top: 50px;
	display: flex;
	flex-direction: row;
}

.bottom {
	margin-top: 30px;
}

.right {
	margin-left: 70px;
}

.dateInfo {
	padding-top: 100px;
}

.btnGroup {
	display: flex;
	flex-direction: column;
}

.btnGroup>input {
	margin-top: 20px;
	width: 195px;
	height: 50px;
	cursor: pointer;
	/* background-color: orangered; */
	border-radius: 10px;
	font-size: 15px;
}

.btnGroup>input:hover {
	background-color: orangered;
	border: 2px solid pink;
	color: white;
}

.reviewInfo {
	width: 800px;
	padding: 10px 50px;
}

.reviewContainer {
	border-radius: 10px;
	border: 1px solid gray;
	margin: 20px 0;
}

img {
	width: 700px;
	height: 500px;
}

.logo_img {
	width: 100px;
	height: 30px;
}

.on {
	color: Yellow;
}

.star_rating a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
function sessionCheck() {
	
	<%
	HttpSession sess = request.getSession();
	Member curMember = (Member)sess.getAttribute("member");
	
	int no = Integer.parseInt(request.getParameter("lectureno"));
	
	if(curMember != null){
	%>
		
		location.href = 'register_init?lectureno=<%=no%>';


	<%
		} else {
			
		
	%>
		alert('로그인 후 이용해주세요');
		location.href = 'login_init';
	
	<%
		}
	%>
}



</script>

<body>
      <div class="fixMenu">
            <div class="menu_left">
                  <a class="img_link" href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
            </div>
            
            <div class="menu_right">
                  <ul class="menu_list">
                  		<c:if test="${member == null }">
	                        <li><a class="menu_link" href="login_init">LOG IN</a></li>
	                        <li><a class="menu_link" href="#">Q&A</a></li>
                        </c:if>
                        <c:if test="${member != null }">
	                        <li><a class="menu_link" href="logout">LOGOUT</a></li>
	                        <li><a class="menu_link" href="#">Q&A</a></li>
                        </c:if>
                        <!-- <li><a class="menu_link" href="#">ACCOUNT</a></li> -->
                  </ul>
            </div>
      </div>
	<div class="Container">
		<div class="top">
			<div class="left">
				<div class="relatedSection">
					<p>
						<strong>${interest}</strong>
					</p>
					<p>
						<strong></strong>
					</p>
				</div>
				<div class="titleSection">
					<h1>${lecture.name}</h1>
				</div>
				<div class="tutorSection">
					<img src="/TestProject/images/${lecture.imagename}" id="tutorImg" alt="">
					<div class="tutorInfo">
						<p>
							<strong>${userName}</strong> 튜터
						</p>
						<p>
							<strong id="star">★</strong> (0)
						</p>
					</div>
				</div>
				<div class="imgSection">
					<img src="/TestProject/images/${lecture.imagename}" alt="logo">
				</div>
				<div class="infoSection">
					<h2>강의설명</h2>
					<p id="moreInfo">${lecture.content}</p>
				</div>
			</div>
			<div class="right">
				<div class="dateInfo">
					<fieldset style="width: 150px; text-align: center; padding: 20px;">
						<legend><strong>강의 일정</strong></legend>
						<h5>시작일</h5>
						<p>${splitStart}</p>
						<br>
						<h5>종료일</h5>
						<p>${splitEnd}</p>
						<br>
						<h5>시작시간</h5>
						<p>${lecture.starttime}</p>
						<br>
						<h5>종료시간</h5>
						<p>${lecture.endtime}</p>
					</fieldset>

					<br>

					<fieldset style="width: 150px; text-align: center; padding: 20px;">
						<legend>
							<strong>모집 인원</strong>
						</legend>
						<p>${lecture.req_cnt}/${lecture.rec_cnt}명</p>
					</fieldset>

					<br>


					<fieldset style="width: 150px; text-align: center; padding: 20px;">
						<legend>
							<strong>평점</strong>
						</legend>
						<p>0 / 5.0</p>
					</fieldset>


                              <div class="btnGroup">
                                    <input type="button" value="장바구니 담기">
                                    <input type="button" value="수강신청" onClick="sessionCheck()">
                                    <input type="button" value="Q&A 보기">
                              </div>

                        </div>
                  </div>
            </div>
            <div class="bottom">
                  <H1>리뷰</H1>
			<c:if test="${!empty reviewList}">
				<table class="table ">

					<c:forEach var="review" items="${reviewList}">
						<tr>
							<c:if test="${review.score eq 5}">
								<tr class="table-info">
								
							</c:if>
							<c:if test="${review.score eq 4}">
								<tr class="table-primary">
									
							</c:if>
							<c:if test="${review.score eq 3}">
								<tr class="table-success">
									
							</c:if>
							<c:if test="${review.score eq 2}">
								<tr class="table-warning">
									
							</c:if>
							<c:if test="${review.score eq 1}">
								<tr class="table-secondary">
									
							</c:if>



							<td>
								<p class="star_rating">
									<c:forEach var="i" begin="0" end="5">
										<c:set var="score" value="${review.score}" />
										<c:if test="${ i < score }">
											<a class="on">★ </a>
										</c:if>

										<c:if test="${i > score }">
											<a>☆</a>
										</c:if>
									</c:forEach>

								</p>
							</td>
							<td>
								<small>${review.id}</small><br>
								<small>${review.writeDate}</small>
								<h6>${review.content}</h6>
								<h6>평점 :${review.score}</h6>
							<td></td>

						</tr>
						
					</c:forEach>
				</table>													
				<button type ='button'   onclick= "document.location='review_list?lectureno?${lecture.lectureno}'"  >리뷰 더보기</button>
			</c:if>

			<c:if test="${empty reviewList}">
				리뷰가 없습니다.
			</c:if>
            </div>
      </div>
</body>

</html>