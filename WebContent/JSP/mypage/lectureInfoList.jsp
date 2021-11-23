<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강목록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">

*{
	margin: 0;
	padding: 0;
}
aside{
  float: left;
  width: 15%;
  padding-top: 40px;
  bottom: 0;
}

.main{
  float: right;
  width: 83%;
  border-left:1px solid black; 
  padding: 0 0 8px 10px;
  margin: 20px 0
}

.image{
	float : left;
	border: 1px solid black;
	height: 150px;
	width: 150px;
	margin-right: 20px;
}


table {
    display: inline-block;
  }
  
.lecture{
	padding:20px;
	
  }


ul{
	
  	margin: 0;
  	
}



</style>
</head>
<body>

<aside>
<h3>마이페이지</h3>
<ul>
<li><a href="myProfile">내 프로필</a></li>
<li><a href="lectureinfo_List">수강목록</a></li>
<li><a href="myLecture_List">강의목록</a></li>
</ul>
</aside>

<div class="main">
<div class="container mt-3">
<h3 style="display: inline-block;">수강목록</h3>
<a href="">메인으로</a>
<hr>
<form action="lectureInfoSearch" method="post">
<input type="date" name="startdate" value="${startdate}"> ~ <input type="date" name="enddate" value="${enddate}">
<input type="text" name="lectureName" value="${lectureName}" placeholder="강의명">
<input type="submit" value="조회">
</form>
<hr>
<c:forEach var="lectureInfo" items="${lectureInfoList}">

<div class="lecture">
<div class="image"></div>
<h5>${lectureInfo.lecture.name}</h5>


<table>
<tr>
<td>강사이름</td>
<td>
 <c:forEach var="teacher" items="${teacherNameList}">
	<c:if test="${teacher.userno==lectureInfo.lecture.userno}">
	${teacher.name}
	</c:if>
</c:forEach>
</td>
</tr>
<tr>
<td>관심사</td>
<td>
<c:forEach var="interest" items="${interestList}">
	<c:if test="${interest.int_no == lectureInfo.lecture.int_no}">
	 ${interest.int_name}
	</c:if>
</c:forEach>
 
</td>
</tr>
<tr>
<fmt:parseDate var="dateFmt" value="${lectureInfo.lecture.startdate}" pattern="yyyy-MM-dd"/>
<fmt:parseDate var="dateFmt2" value="${lectureInfo.lecture.enddate}" pattern="yyyy-MM-dd"/>
<td>강의기간</td>
<td>

<fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"/> ~ 
<fmt:formatDate value="${dateFmt2}" pattern="yyyy-MM-dd"/>
</td>
<td>진행률</td>
<td> ${lectureInfo.progress}</td>
</tr>
<tr>
<td>수강현황</td>
<td>
<c:choose>
	<c:when test="${lectureInfo.progress == 100}">수강완료</c:when>
	<c:when test="${lectureInfo.progress >=0}">수강중</c:when>
</c:choose>
</td>
<td>출결현황</td>
<td> ${lectureInfo.attendance} </td>
</tr>
<tr>
<td><a href="lecture_qna_list">QnA</a></td>
<td>
<c:choose>
<c:when test="${lectureInfo.progress == 100}"><a href="review_register_form">리뷰쓰기</a></c:when>
<c:when test="${lectureInfo.progress <=15}"><a href="deleteLectureInfo?deleteInfono=${lectureInfo.infono}">수강취소</a></c:when>
</c:choose>
</td>
</tr>
</table>
</div>
<hr>
</c:forEach>

  
<ul class="pagination">
	<c:if test="${pageGroupResult.beforePage}">
	<li class="page-item"><a  class="page-link"  href="lectureinfo_List?reqPage=${pageGroupResult.groupStartNumber-1}">before</a></li></c:if>
	
	<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
		<c:choose>
		<c:when test="${pageGroupResult.selectPageNumber==index}">
			<li class="page-item active"><a class="page-link"  href="lectureinfo_List?reqPage=${index}">${index}</a></li>
		</c:when>
		
		<c:otherwise>
		<li class="page-item"><a class="page-link"  href="lectureinfo_List?reqPage=${index}">${index}</a></li>
		</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${pageGroupResult.afterPage}"> 
	<li class="page-item"><a  class="page-link"  href="lectureinfo_List?reqPage=${pageGroupResult.groupEndNumber+1}">after </a></li> </c:if>
	</ul>
	
</div>
</div>


</body>
</html>