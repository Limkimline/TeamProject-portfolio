<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" nonce="f9d76f0fbeb54f7ea2a9ea1324a"
	src="//local.adguard.org?ts=1634862422856&amp;type=content-script&amp;dmn=swiperjs.com&amp;app=chrome.exe&amp;css=1&amp;js=1&amp;gcss=1&amp;rel=1&amp;rji=1&amp;sbe=0&amp;stealth=1&amp;uag="></script>
<script type="text/javascript" nonce="f9d76f0fbeb54f7ea2a9ea1324a"
	src="//local.adguard.org?ts=1634862422856&amp;name=AdGuard%20Popup%20Blocker&amp;name=AdGuard%20Extra&amp;type=user-script"></script>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img {
	display: block;
	width: 100px;
	height: 100px;
	object-fit: contain;
}

.title {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.logo_img {
	width: 150px;
}

table {
	width: 100%;
	
}

th, td {
	
	text-align: center;
}

td {
	vertical-align: middle;
	background-color: #F4F4F4;
}
</style>
</head>
<body>
	<div class="container mt-3">
		<div class="title">
			<h1>장바구니</h1>
			<a href="mainPage"><img class="logo_img" src="image/logo.PNG"
				alt="로고"></a>
		</div>

		<form method="post">

			<table class="table">
				<thead class="table-dark">
					<tr>
						<td>강의이미지</td>
						<td>강의명</td>
						<td>강의기간</td>
						<td>강의시간</td>
						<td>모집인원</td>
						<td>모집기간</td>
						<td>강의신청</td>
						<td><label>전체선택<br>
							<input type="checkbox" id="AllCheck" value="all"></label></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lecture" items="${basketList}" varStatus="status">
						<tr>
							<td><a
								href="lecture_clickcountUp?lectureno=${lecture.lectureno}"><img
									src="/TestProject/images/${lecture.imagename}" /></a></td>
							<td>${lecture.name}</td>
							<td>${lecture.startdate}~ ${lecture.enddate}</td>
							<td>${lecture.starttime}~ ${lecture.endtime}</td>
							<td>${lecture.req_cnt}/${lecture.rec_cnt}</td>
							<td>${lecture.rec_startdate}~ ${lecture.rec_enddate}</td>
							<td><input type="button" value="수강신청" class="btn btn-primary register Lectureno:${lecture.lectureno}" id="${lecture.userno}" >
							<td><input type="checkbox" name="checkbox"
								class="checkbox${status.count}" value="${lecture.lectureno}"></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<input type="submit" id="deletebutton" value="선택한 리스트 삭제"
				class="btn btn-primary" disabled="disabled" formaction="basket_delete">
			<input type="submit" id="deleteDateButton" value="모집기간이 지난 리스트 삭제"
				class="btn btn-primary" formaction="basket_DateDelete">	
		</form>
		
		<ul class="pagination justify-content-center pagination-sm">
					<c:if test="${PageGroupResult.beforePage}">
						<li class="page-item"><a class="page-link"
							href="basket_list?reqPage=${PageGroupResult.groupStartNumber-1}">before</a>
						</li>
					</c:if>
					<c:forEach var="index" begin="${PageGroupResult.groupStartNumber}"
						end="${PageGroupResult.groupEndNumber}">
						<c:choose>
							<c:when test="${PageGroupResult.selectPageNumber==index}">
								<li class="page-item active"><a class="page-link "
									href="basket_list?reqPage=${index}">
										${index} </a></li>
							</c:when>

							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="basket_list?reqPage=${index}">
										${index} </a></li>
							</c:otherwise>
						</c:choose>


					</c:forEach>
					<c:if test="${PageGroupResult.afterPage}">
						<li class="page-item"><a class="page-link"
							href="basket_list?reqPage=${PageGroupResult.groupEndNumber+1}">after</a>
						</li>
					</c:if>
				</ul>
		
		
		
<script>
$(document).ready(function() {
	$("#AllCheck").click(function() {
		if($("#AllCheck").is(":checked")) {
			$("input[name=checkbox]").prop("checked", true);
			$("#deletebutton").attr("disabled", false);
		}
		else{
			$("input[name=checkbox]").prop("checked", false);
			$("#deletebutton").attr("disabled", true);
		}
	});

	$("input[name=checkbox]").click(function() {
		var total = $("input[name=checkbox]").length;
		var checked = $("input[name=checkbox]:checked").length;

		if(total != checked) $("#AllCheck").prop("checked", false);
		else $("#AllCheck").prop("checked", true); 
	});
	
	
	
	$("input[name=checkbox]").change(function() {
		$("#deletebutton").attr("disabled", true);
		for (var i = 1; i < $("input[name=checkbox]").length+1; i++) {
			var checkbox= ("checkbox"+i);
			if($("."+checkbox).prop("checked")){
				$("#deletebutton").attr("disabled", false);
			}
		}
	});
	
	
	$(".register").click(function() {
		var userno= "${member.userno}";
		var id_check = $(this).attr("id");
		var class_check = $(this).attr("class").substring(35);
		if(userno==id_check){
			alert("본인이 등록한 강의입니다.");
		}else{
			location.href='register_init?lectureno='+class_check;
		}
	
	});

});
</script>
	</div>
</body>
</html>