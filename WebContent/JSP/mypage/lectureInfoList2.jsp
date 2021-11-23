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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	    var obj_anchor = document.getElementById('deletelink');
		obj_anchor.onclick = function() { 
			if(confirm("정말 삭제하시겠습니까?")==true){
				document.form.submit();
			}else{
				return false;
			}
		}

});

</script>

<style type="text/css">

*{
	margin: 0;
	padding: 0;
}
aside{
  float: left;
  padding-left:7px;
  width: 14%;
  padding-top: 40px;
  bottom: 0;
}

.main{
  float: right;
  width : 85%;
  padding: 0 0 8px 10px;
  margin: 20px 0;
  min-height: 600px;
  border-left:1px solid black;
}

.image{
	float : left;
	border: 1px solid black;
	height: 170px;
	width: 200px;
	margin-right: 20px;
	
}
.lectureimg{
	height: 168px;
	width: 198px;
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

#linkmove, #deletelink{
	text-decoration: none;
	cursor: pointer;
	font-size: 15px;
	margin-left: 0px; 
}

#linkmove:hover, #deletelink:hover
	{
	border: 1px solid black;
	background-color: rgb(70, 70, 243);
	color: white;
}

.logo_img{
            width: 150px;
            display:inline-block;
            float: right;
            margin-right: 50px;

      }

table * {
	padding-left:10px;
	padding-right: 10px;
}


</style>
</head>
<body>

<aside>
<h3>마이페이지</h3>
<ul>
<li><a href="lectureInfoSearch2">수강목록</a></li>
<li><a href="myLecture_List">강의목록</a></li>
<li><a href="checkPw">내 프로필</a></li>
</ul>
</aside>

<div class="main">
<div class="container mt-3">
<h2 style="display: inline-block;">수강목록</h2>
<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
<hr>
<form action="lectureInfoSearch2" method="post">
<input type="date" name="startdate" value="${startdate}"> ~ <input type="date" name="enddate" value="${enddate}">
<input type="text" name="lectureName" value="${lectureName}" placeholder="강의명">
<input type="submit" value="조회">
</form>
<hr>
<c:forEach var="lectureInfo" items="${lectureInfoList}">

<div class="lecture">
<a href="detail_init?lectureno=${lectureInfo.lecture.lectureno}"><div class="image">
<img src="/TestProject/images/${lectureInfo.lecture.imagename}" class="lectureimg"/>
</div></a>
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
	<c:when test="${lectureInfo.progress >0}">수강중</c:when>
	<c:when test="${lectureInfo.progress ==0}">수강전</c:when>
</c:choose>
</td>
<td>출결현황</td>
<td> ${lectureInfo.attendance} </td>
</tr>

<tr>
										
<td><a href="lecture_qna_list?lectureno=${lectureInfo.lecture.lectureno}" id="linkmove">QnA</a></td>

<td>
<c:choose>
<c:when test="${lectureInfo.progress == 100}"><a href="review_register_form?lectureno=${lectureInfo.lecture.lectureno}" id="linkmove">리뷰쓰기</a></c:when>
<c:when test="${lectureInfo.progress <=15}"><a id="deletelink" href="deleteLectureInfo?deleteInfono=${lectureInfo.infono}">수강취소</a></c:when>
</c:choose>
</td>
</tr>
</table>
</div>
<hr>
</c:forEach>

  
<ul class="pagination">
	<c:if test="${pageGroupResult.beforePage}">
	<li class="page-item"><a  class="page-link"  href="lectureInfoSearch2?reqPage=${pageGroupResult.groupStartNumber-1}&startdate=${startdate}&enddate=${enddate}&lectureName=${lectureName}">before</a></li></c:if>
	
	<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">
		<c:choose>
		<c:when test="${pageGroupResult.selectPageNumber==index}">
			<li class="page-item active"><a class="page-link"  href="lectureInfoSearch2?reqPage=${index}&startdate=${startdate}&enddate=${enddate}&lectureName=${lectureName}">${index}</a></li>
		</c:when>
		
		<c:otherwise>
		<li class="page-item"><a class="page-link"  href="lectureInfoSearch2?reqPage=${index}&startdate=${startdate}&enddate=${enddate}&lectureName=${lectureName}">${index}</a></li>
		</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${pageGroupResult.afterPage}"> 
	<li class="page-item"><a  class="page-link"  href="lectureInfoSearch2?reqPage=${pageGroupResult.groupEndNumber+1}&startdate=${startdate}&enddate=${enddate}&lectureName=${lectureName}">after </a></li> </c:if>
	</ul>
	
</div>
</div>


</body>
</html>