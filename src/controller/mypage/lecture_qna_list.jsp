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

.functionLine {
	display: flex;
	justify-content: center;
}

button {
	margin-left: 20px;
}
</style>

<title>강의게시판</title>



</head>
<body>

	<div class='top'>
		<h1>${lecture.name} 게시판 </h1>
		<br>
		<div class='functionLine'>
			<form action='' method='get'>
				<input type='text' name='searchsubject' placeholder='강의 제목을 입력해주세요'
					style='width: 400px'> <input type='submit' value='검색'
					name='btnName'>

			</form>
			
			<c:if test="${!empty member }">
			<button type='button'onclick="document.location='lecture_qna_list?btnName=내 글'">내	글 보기</button>
			</c:if>
			<button type='button'
				onclick="document.location='lecture_qna_register_form'">글쓰기</button>
		</div>
	</div>
	<div>
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
				<c:forEach var="qna" items="${lqList}">
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
						<td>비밀글입니다.</td>
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
								href="lecture_qna_list?reqPage=${index}&listKeyword=${listKeyword}">${index}
							</a></li>
						</c:when>

						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="lecture_qna_list?reqPage=${index}&listKeyword=${listKeyword}">${index}
							</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${pageGroupResult.afterPage }">
					<li class="page-item"><a class="page-link"
						href="leture_qna_list?reqPage=${pageGroupResult.groupEndNumber+1}&listKeyword=${listKeyword}">다음</a></li>
				</c:if>
			</ul>
		</c:if>

		<c:if test="${empty gqList }">
  		게시글이 없습니다.
  </c:if>
	</div>


</body>
</html>