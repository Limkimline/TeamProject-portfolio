<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	
<title>Insert title here</title>

<style>
.top{
	display : flex;
	justify-content : center;
}
.on{
 	color: #CC0000;
}

.star_rating a {
 text-decoration: none;
}

.td1{
  	background-color:#F4F4F4;
  	text-align:center;
  	}
 td{
 vertical-align: center;
 }
 
   .logo_img{
            width: 150px;
      }
      

</style>
</head>
<body>
<div class ="container">

	<div>
		<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
	</div>
	<div class = 'top'>
		<h1>${lecture.name}리뷰           </h1>
	</div>
<hr>

<c:if test="${!empty reviewList}">
<table class="table ">

 	<c:forEach var="review" items="${reviewList}">
<tr >
    		<c:if test="${review.score eq 5}">		 
  				<tr  class="table-info">
  			</c:if>
  			<c:if test="${review.score eq 4}">		 
  				<tr class ="table-primary">
  			</c:if>	
  			<c:if test="${review.score eq 3}">		 
  				<tr class ="table-success">
  			</c:if>
  			<c:if test="${review.score eq 2}">		 
  				<tr class ="table-warning">
  			</c:if>
  			<c:if test="${review.score eq 1}">		 
  				<tr class ="table-secondary">
  			</c:if>		
  			
  				

<td	class ='td1'>
	<p class="star_rating">
	<br>
 		<c:forEach var= "i" begin ="0" end = "5" >
 			<c:set var="score" value ="${review.score}" />
 			<c:if test="${ i < score }">
 			<a  class="on">★ </a>
 			</c:if>
 			
 			<c:if test="${i > score }">
 			<a  >☆</a>	
 			</c:if>
 		</c:forEach>
 
	 </p> 
 </td>
 <td>
 <h5>${review.id}</h5>
 <h5>${review.writeDate} </h5>
 <h5>${review.content}</h5>
 
 
 <!--  1027 장동주 :  -->
 <td>
 
 </td>

</tr>
	</c:forEach>
</table>


  <ul class="pagination" >
	  	<c:if test="${pageGroupResult.beforePage }">
	  	  <li class="page-item"><a  class="page-link" href="review_list?reqPage=${pageGroupResult.groupStartNumber-1}&lectureno=${lecture.lectureno}">이전</a></li>
	  	 </c:if>
	   
	   <c:forEach var = "index" begin="${pageGroupResult.groupStartNumber}" 	end= "${pageGroupResult.groupEndNumber}" > 
		<c:choose>
			<c:when test="${pageGroupResult.selectPageNumber == index}">
				<li class="page-item active"><a  class="page-link" href = "review_list?reqPage=${index}&lectureno=${lecture.lectureno}">${index} </a></li>   					
			</c:when>
		
			<c:otherwise>
				<li class="page-item"><a  class="page-link" href = "review_list?reqPage=${index}&lectureno=${lecture.lectureno}">${index} </a></li>   					
			</c:otherwise>
		</c:choose>
	   </c:forEach>
	   
	  	<c:if test="${pageGroupResult.afterPage }">
	  	 <li class="page-item"><a  class="page-link" href="review_list?reqPage=${pageGroupResult.groupEndNumber+1}&lectureno=${lecture.lectureno}">다음</a></li>
	  	</c:if>
 	</ul>
</c:if>

<c:if test="${empty reviewList}">
리뷰가 없습니다.
</c:if>


</div>

<script type ="text/javascript">
$( ".star_rating a" ).click(function() {
     $(this).parent().children("a").removeClass("on");
     $(this).addClass("on").prevAll("a").addClass("on");
     
   
     
     return false;
});
</script>



</body>
</html>