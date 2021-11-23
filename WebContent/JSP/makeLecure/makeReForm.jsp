<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul li{
		list-style-type: none;
		 margin: 20px 0 0 20px;
  		 padding: 20px 0 0 20px;
  		 float:left;
	}
	a{
    	text-decoration: none;
	}
	#image_container{
		width: 300px;
   		height: 200px;
   		border: 1px solid black;
   		background-size: contain;           
		background-repeat: no-repeat;     
		background-position: center;     
	}
	table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
  .td1{
  	background-color:#F4F4F4;
  	text-align:center;
  }
  .title{
  	display:flex;
  	justify-content:space-between;
  	align-items: center;
  }
    .logo_img{
            width: 150px;
      }
</style>
</head>
<script type="text/javascript">
$(function() {
	var lectureTrue=null;
	
	$("#lectureCreate").click(
			function() {
			var input_startdate = $("input[name='startdate']").val();
			var input_enddate = $("input[name='enddate']").val();
			var input_starttime = $("input[name='starttime']").val();
			var input_endtime = $("input[name='endtime']").val();
			var input_userno= "${user.userno}";
			if(!input_startdate || !input_enddate || !input_starttime || !input_endtime){
				alert("날짜와 시간을 입력하세요");
				return false;
			}
				
			var url="daycheck";

			$.get(url,{"startdate_value" :  input_startdate , "enddate_value":input_enddate , "starttime_value": input_starttime , 
				"endtime_value": input_endtime, "userno": input_userno},function(data){

				var result_text = $(data).find("result").text();
				
				var result= eval(result_text);
				
				if(result){
					alert("강의를 개설했습니다,");
					var form= document.lectureinput;
					form.submit();
				}else{
					alert("다른 강의와 날짜와 시간이 중복되었습니다.");
				}
			});				
	});
	
	
			
			
	
});
</script>
<body>
	<div class="container">
	
	<div class="title">
		<h1>강의 개설</h1>
		<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
	</div>
	<hr/>
		<form method="post" enctype="multipart/form-data" action="lecture_reInsert">
			<table>
				<tr>
					<td class="td1">개설자</td>
					<td>${user.name}</td>
					<td colspan="2" rowspan="3" align=center>
					대표사진
						<div id="image_container" style="background-image: url('/TestProject/images/${lecture.imagename}')"></div>
						<input type="file" id="image" accept="image/*" onchange="setThumbnail(event)" name="imagename" placeholder="파일명">
					</td>
				</tr>
				<tr>
					<td class="td1">강의명</td>
					<td><input type="text" name="name" placeholder="강의명을 입력하세요" value="${lecture.name}" readonly="readonly"></td>
				</tr>
				<tr>
					<td class="td1">강의설명</td>
					<td colspan="2"><textarea name="content" style="width:250px; height:150px;">${lecture.content}</textarea></td>
				</tr>
				<tr>
					<td class="td1">강의시작일/강의종료일</td>
					<td colspan="2">
						<input type="date" name="startdate" value="${lecture.startdate}">
						<input type="date" name="enddate" value="${lecture.enddate}">
					</td>
				</tr>
				<tr>
					<td class="td1">강의시작시간/강의종료시간</td>
					<td colspan="2">
						 <input type="time" name="starttime" value="${lecture.starttime}">
						 <input type="time" name="endtime" value="${lecture.endtime}">
						 
					</td>
				</tr>
				<tr>
					<td class="td1">모집시작일/모집종료일</td>
					<td colspan="2">
						  <input type="date" name="rec_startdate">
						  <input type="date" name="rec_enddate">
					</td>
				</tr>
				<tr>
					<td class="td1">모집인원</td>
					<td colspan="2">
						  <input type="text" name="rec_cnt" value="${lecture.rec_cnt}">
					</td>
				</tr>
				<tr>
					<td class="td1">관심사</td>
					<td colspan="2">
						  <select name="int_no">
							<c:forEach var="interest" items="${interestList}">
								<option value="${interest.int_no}">${interest.int_name}</option>		
							</c:forEach>	
						  </select>
					</td>
				</tr>
				<tr>
					<td colspan="3" align=center>
						<input type="submit" value="강의재개설" id="lectureCreate" >
						<input type="reset" value="개설 취소">
					</td>
				</tr>
			</table>
			
			<input type="text" name="userno" value="${user.userno}" hidden="hidden"/>	
			<input type="text" name="lectureno" value="${lecture.lectureno}" hidden="hidden"/>	
		</form>
	</div>
	
<script>
	function setThumbnail(event) { 
			var reader = new FileReader();
			
			reader.onload = function(event) {
				var img = document.querySelector("div#image_container");
				img.setAttribute("style", "background-image: url(" + event.target.result +")");
				//document.querySelector("div#image_container").appendChild(img);
				}
				console.log(image);
				reader.readAsDataURL(event.target.files[0]);
			} 
</script>
</body>
</html>