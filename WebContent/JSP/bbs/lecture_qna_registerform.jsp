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
<style>

.container {
text-align: center;
}
.btn {
	margin-left: 20px;
	background-color: #50BCDF;
	color: white;
}

  .title{
  	display:flex;
  	justify-content:space-between;
  	align-items: center;
  }
    .logo_img{
     width: 150px;

	}
	
	.td1{
  	background-color:#F4F4F4;
  	text-align:center;
  	}
  
    th, td {
    border: 1px solid #444444;
  	}
  	table {
    width: 100%;
    border: 1px solid #444444;
  }
	
</style>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
	<div class="title">
		<h1>${lecture.name}  Q&A 등록</h1>
		<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
	</div>
	<hr/>
		<form method="post" action="lecture_qna_register">
		<input type= "hidden"name="lectureno" value="${lecture.lectureno}" > 
			<table >
				<tr>
					<td class="td1"><h3>공개 여부</h3></td>
					<td><input type='radio' name='open' checked="checked" value='1'>공개  <input type='radio' name='open' value='0'>비공개 </td>
				</tr>
				<tr>
					<td class="td1"><h3>작성자</h3></td>
					<c:if test="${empty member  }">
						<td><input type='hidden' name = 'id' ><h3>비회원</h3> </td>
					</c:if>
					<c:if test="${!empty member }">
						<td><input type='hidden' name = 'id' value ="${member.id}" ><h3>${member.id}</h3></td>
					</c:if>
				</tr>
				<tr>
					<td class="td1"><h3>제목</h3></td>
					<td><input type="text" name="subject" style="width:400px;" placeholder="제목을 입력하세요"></td>
				</tr>
				<tr>
					<td class="td1"><h3>내용</h3></td>
					<td colspan="2"><textarea name="content" style="width:400px; height:150px;" placeholder = '내용을 입력해주세요'></textarea></td>
				</tr>
		
				<tr>
					<td colspan = '2'><input type ='submit' name ='requstsubmit' value='등록하기' class = 'btn' > </td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>