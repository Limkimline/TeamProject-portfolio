<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
.top {
	text-align: center;
}

button {
	margin-left: 20px;
	background-color: #50BCDF;
	color: white;
}

  .logo_img{
            width: 150px;
      }
      
  .container-fluid barList {
	height: 100px;
	backgorund:#FFFFFF;
}


  input.search_img {
        background: url( "images/button_search.png" ) no-repeat;
        border: none;
        width: 32px;
        height: 32px;
        cursor: pointer;
      }
</style>

<title>일반게시판</title>



</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-white">
			<div class="container-fluid barList">
				<div>
					<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
				</div>
				<div>
					<h1>일반 게시판</h1>
				</div>
				<div class="loginbar">
				
				</div>
			</div>
		</nav>
	</header>
	<section>
		<div class="search">
			<form action='general_qna_list' method='get'>
				<input type='text' name='searchsubject' placeholder='제목을 입력해주세요' style='width: 400px'>
				<input type='submit' value='검색' name='btnName'>
				<input type='image' class ="search_img" src = "image/search.PNG" value='검색' name='btnName'>
				<button type='button' onclick="document.location='general_qna_register_form'">글쓰기</button>
				<c:if test="${!empty member }">
					<button type='button' onclick="document.location='general_qna_list?btnName=내 글'">내 글 보기</button>
				</c:if>
			</form>
		</div>
		<div class="qnaList">
			<c:if test="${!empty gqList}">
				<table class="table ">
					<tr class="table-dark">
						<th>번호</th>
						<th>제목</th>
						<th>공개여부</th>
						<th>날짜</th>
						<th>조회수</th>
						<th>상태</th>
					</tr>
					<c:forEach var="qna" items="${gqList}">
						<c:if test="${empty qna.answer}">
							<tr class="table-success">
						</c:if>
						<c:if test="${!empty qna.answer}">
							<tr class="table-primary">
						</c:if>
						<c:if test="${qna.open eq 0}">
							<tr class="table-light">
						</c:if>
						<td>${qna.qnano}</td>


						<c:if test="${qna.open eq 1}">
							<td><a href="general_qna_detail?qnano=${qna.qnano }">${qna.subject}</a></td>>
	  						<td>공개</td>
						</c:if>
						
						<c:if test="${qna.open eq 0}">
						<c:choose>
							<c:when test="${qna.userno eq member.userno}">
								<td><a href="general_qna_detail?qnano=${qna.qnano }">${qna.subject}</a> <input type='image' class ="search_img" src = "image/lock.PNG" ></td>>
							</c:when>
							<c:when test="${member.id eq 'manager'}">
								<td><a href="general_qna_detail?qnano=${qna.qnano }">${qna.subject}</a> <input type='image' class ="search_img" src = "image/lock.PNG" ></td>>
							</c:when>
							<c:otherwise>
							<td>비밀글입니다. <input type='image' class ="search_img" src = "image/lock.PNG" ></td>
							</c:otherwise>
						</c:choose>
							<td>비공개</td>
						</c:if>
						<td>${qna.writeDate}</td>
						<td>${qna.clickCount}</td>
						<c:if test="${empty qna.answer}">
							<td>미답변</td>
						</c:if>
						<c:if test="${!empty qna.answer}">
							<td bgcolor="red">답변완료</td>
						</c:if>

					</c:forEach>
				</table>
			</c:if>
			<c:if test="${empty gqList}">
			게시글이 없습니다.
			</c:if>
		</div>
		<div class="paging">
			<c:if test="${!empty gqList}">
				<ul class="pagination">
					<c:if test="${pageGroupResult.beforePage }">
						<li class="page-item"><a class="page-link"
							href="general_qna_list?reqPage=${pageGroupResult.groupStartNumber-1}&listKeyword=${listKeyword}">이전</a></li>
					</c:if>

					<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}"
						end="${pageGroupResult.groupEndNumber}">
						<c:choose>
							<c:when test="${pageGroupResult.selectPageNumber == index}">
								<li class="page-item active"><a class="page-link"
									href="general_qna_list?reqPage=${index}&listKeyword=${listKeyword}">${index}
								</a></li>
							</c:when>

							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="general_qna_list?reqPage=${index}&listKeyword=${listKeyword}">${index}
								</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${pageGroupResult.afterPage }">
						<li class="page-item"><a class="page-link"
							href="general_qna_list?reqPage=${pageGroupResult.groupEndNumber+1}&listKeyword=${listKeyword}">다음</a></li>
					</c:if>
				</ul>
			</c:if>
		</div>
	</section>
</body>
</html>