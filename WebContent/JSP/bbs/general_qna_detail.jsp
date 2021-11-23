<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<style>
.container {
	text-align: center;
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
  
     .logo_img{
     width: 150px;

	}
	  .title{
  	display:flex;
  	justify-content:space-between;
  	align-items: center;
  }
  
  .btn {
  	margin-left: 20px;
	background-color: #50BCDF;
	color: white;
  }
</style>

<title>Q&A 상세보기</title>
</head>
<body>
	<div class="container">

		<div class="title">
			<h1>Q&A 상세보기</h1>
			<a href="mainPage"><img class="logo_img" src="image/logo.PNG"
				alt="로고"></a>
		</div>
		<hr />
		<section>
			<form method="post" action="general_qna_return_detail ">
				<input type='hidden' name='qnano' value="${gq.qnano}">

				<table>
					<c:if test="${isWriter eq 0}">
						<tr>
							<td class="td1"><h3>공개 여부</h3></td>
							<c:if test="${gq.open eq 0}">
							<td><input type='radio' name='open'  value='1' onclick="return false">공개 
								<input type='radio' name='open' checked="checked" value='0' onclick="return false">비공개
								</td>
							</c:if>
							<c:if test="${gq.open eq 1}">
							<td><input type='radio' name='open' checked="checked" value='1' onclick="return false">공개 
								<input type='radio' name='open'  value='0' onclick="return false">비공개
								</td>
							</c:if>		
						</tr>
						<tr>
							<td class="td1"><h3>작성자</h3></td>
							<td><input type='hidden' name='id' value="${writerId}">${writerId}
							</td>
						</tr>
						<tr>
							<td class="td1"><h3>제목</h3></td>
							<td><input type='text' name='subject' style='width: 400px'
								value="${gq.subject }" readonly></td>
						</tr>
						<tr>
							<td class="td1"><h3>내용</h3></td>
							<td><textarea name='content'
									style="width: 400px; height: 150px;" placeholder='내용을 입력해주세요'
									readonly>${gq.content}</textarea></td>
						</tr>
					</c:if>


					<c:if test="${isWriter eq 1}">
						<tr>
							<td class="td1"><h3>공개 여부</h3></td>
							<c:if test="${gq.open eq 0}">
							<td><input type='radio' name='open'  value='1' >공개 
								<input type='radio' name='open' checked="checked" value='0' >비공개
								</td>
							</c:if>
							<c:if test="${gq.open eq 1}">
							<td><input type='radio' name='open'  checked="checked" value='1' >공개 
								<input type='radio' name='open'  value='0' >비공개
								</td>
							</c:if>		
						</tr>
						<tr>
							<td class="td1"><h3>작성자</h3></td>
							<td><input type='hidden' name='id' value="${writerId}">${writerId}
							</td>
						</tr>
						<tr>
							<td class="td1"><h3>제목</h3></td>
							<td><input type='text' name='subject' style='width: 400px'
								value="${gq.subject }"></td>
						</tr>
						<tr>
							<td class="td1"><h3>내용</h3></td>
							<td><textarea name='content'
									style="width: 400px; height: 150px;" placeholder='내용을 입력해주세요'>${gq.content}</textarea>
							</td>
						</tr>
					</c:if>


					<c:if test="${empty gq.answer }">

						<c:if test="${isManager eq 1}">
							<tr>
								<td>
									<h2>답변</h2>
								</td>
								<td><textarea name='answer'
										style="width: 400px; height: 150px;" placeholder='답변을 입력해주세요'>${gq.answer}</textarea>
								</td>
							</tr>
						</c:if>
					</c:if>

					<c:if test="${!empty gq.answer }">
						<tr>
							<td>
								<h2>답변</h2>
							</td>

							<c:if test="${isManager eq 0}">
								<td><textarea name='answer' cols='40' rows='5' readonly>${gq.answer}</textarea>
								</td>
							</c:if>
							<c:if test="${isManager eq 1}">
								<td><textarea name='answer' cols='40' rows='5'
										placeholder='답변을 입력해주세요'>${gq.answer}</textarea></td>
							</c:if>
						</tr>
					</c:if>


					<c:if test="${isManager eq 1}">
						<td  colspan = '2'>
						<input type='submit' name='requestsubmit' value='답변등록'  class ='btn'>
						<input type='submit' name='requestsubmit' value='삭제'  class ='btn'>
						</td>

					</c:if>
					<c:if test="${isWriter eq 1}">
						<c:if test="${empty gq.answer }">
							<tr>
							<td colspan = '2'>
								<input type='submit' name='requestsubmit' value='수정' class ='btn'>
								<input type='submit' name='requestsubmit' value='삭제' class ='btn'>
							</td>
							</tr>
						</c:if>
						<c:if test="${!empty gq.answer }">
							<tr  >
								<td colspan = '2'><input type='submit' name='requestsubmit' value='삭제'  class ='btn'>
								</td>
							</tr>
						</c:if>

					</c:if>

				</table>
			</form>
		</section>
	</div>

</body>
</html>