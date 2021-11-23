<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.star_rating {font-size:0; letter-spacing:-4px;}
.star_rating a {
    font-size:22px;
    letter-spacing:0;
    display:inline-block;
    margin-left:5px;
    color:#ccc;
    text-decoration:none;
}
.star_rating a:first-child {margin-left:0;}
.star_rating a.on {color:#CC0000;}

.container {
text-align: center;
}

  .title{
  	display:flex;
  	justify-content:space-between;
  	align-items: center;
  }
    .logo_img{
     width: 150px;

	}
	
	.btn {
	margin-left: 20px;
	background-color: #50BCDF;
	color: white;
}


</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<body>

		<div class="title">
			<h1>리뷰등록하기</h1>
			<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
		</div>
<hr>
<div class ="container">

<form  action = "review_register" method ="get" >

<input type='hidden' name = 'userno' value ="${member.userno}" >
<input type='hidden' name = 'lectureno' value ="${lecture.lectureno}" >

<div id = "scoresender"></div>
<table class="table table-bordered">

<tr>

<td>강의명</td><td>${lecture.name }</td>
</tr>

<tr>
<td>평점</td>
<td><p class="star_rating">    <a href="#" >★</a><a href="#" ">★</a><a href="#" >★</a><a href="#">★</a><a href="#">★</a></p> </td>

</tr>
<tr>
<td colspan = '2'><input type ='text' name = 'content'  style='width: 700px' placeholder = '내용을 적어주세요'>  </td>
</tr>
<tr>

<td colspan = '2'><input type ='submit' name = 'requsetsubmit'  value="등록" class = 'btn'>  </td>
</tr>
</table>

</form>
</div>





















<script type ="text/javascript">
$( ".star_rating a" ).click(function() {
     $(this).parent().children("a").removeClass("on");
     $(this).addClass("on").prevAll("a").addClass("on");
     var score = document.getElementsByClassName('on').length;
     document.getElementById("scoresender").innerHTML="<input type='hidden' name='score' value="+score+">";
     return false;
});
</script>
</body>
</html>