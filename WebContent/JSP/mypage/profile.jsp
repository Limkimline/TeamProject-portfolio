<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 프로필</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
		var gender = "${member.gender}";
		$('input[type=radio]').each(function(){
			if(gender==$(this).val()){
				$(this).attr('checked','checked');
			}
		});
		
		
		var int1 = "${member.int_no}";
		$('#interest1 option').each(function(){
			if(int1==$(this).val()){
				$(this).attr('selected','selected');
			}
		});
		
		var int2 = "${member.int_no2}";
		$('#interest2 option').each(function(){
			if(int2==$(this).val()){
				$(this).attr('selected','selected');
			}
		});
		
		
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

.info{
	border-bottom: 1px solid black;
	margin: 0px 50px;
	padding: 15px 50px;
}


img {
    
  }
  
.infotype{
	display: inline-block;
	width: 200px;
	
  }


ul{
  	margin: 0;
}



#image_container {
	width: 300px;
	height: 200px;
	border: 1px solid black;
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;\
}

#image_container2 {
	width: 300px;
	height: 200px;
	border: 1px solid black;
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;\
}

.save  {
	cursor: pointer;
	width: 200px;
	height: 50px;
	border: 1px solid white;
	font-size: 15px;
}

#certicheck{
	cursor: pointer;
	width: 150px;
	height: 50px;
	border: 1px solid white;
	font-size: 15px;
	margin-left: 100px; 
}

.save:hover, button:hover, #certicheck:hover, #findFile:hover, #previewPic:hover
	{
	border: 1px solid black;
	background-color: rgb(70, 70, 243);
	color: white;
}

input{
	width: 250px;
	
}

.logo_img{
            width: 150px;
            display:inline-block;
            float: right;
            margin-right: 50px;

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
<h2 style="display: inline-block;">내 프로필</h2>
<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
<hr>
<form id="formsave" action="memberUpdate?userno=${member.userno}&id=${member.id}" method="post" enctype="multipart/form-data">

<div class="info">
<div class="infotype">아이디</div> <input type="text" name="id" value="${member.id}" disabled="disabled">
</div>
<div class="info">
<div class="infotype">비밀번호</div><input type="password" value="${member.pwd}" id="password1" name="password1" placeholder="비밀번호를 입력하세요" onchange="isSame()">
</div>
<div class="info">
<div class="infotype">비밀번호확인</div><input type="password" name="password2" id="password2" placeholder="비밀번호를 입력하세요" onchange="isSame()" ><span id="same"></span>
</div>

<div class="info">
<div class="infotype">이름</div><input type="text" name="name"  value="${member.name}" style="margin-right: 50px;">

<input type="radio" name="sex" id="sex" value="M" style="width: 15px;">남
<input type="radio" name="sex" id="sex" value="F" style="width: 15px; margin-left: 20px;">여
</div>
<div class="info">
<div class="infotype">휴대전화</div><input type="tel" value="${member.phone}"  name="phone" placeholder="- 없이 입력">
</div>
<div class="info">
<div class="infotype">이메일</div><input type="email" name="email" value="${member.email}" readonly="readonly">
</div>
<div class="info">
<div class="infotype">관심사1 </div><select name="interest1" id="interest1">
								<option value="null">==선택==</option>
								<option value="1">프로그래밍</option>
								<option value="2">스포츠</option>
								<option value="3">음악</option>
								<option value="4">패션</option>
								<option value="5">언어</option>
								<option value="6">투자</option>
						</select>
</div>
<div class="info">
<div class="infotype">관심사2</div><select name="interest2" id="interest2">
								<option value="null">==선택==</option>
								<option value="1">프로그래밍</option>
								<option value="2">스포츠</option>
								<option value="3">음악</option>
								<option value="4">패션</option>
								<option value="5">언어</option>
								<option value="6">투자</option>
						</select>
</div>



<div class="info" >
<div class="infotype">프로필사진</div>
<div id="image_container" style="background-image: url('/TestProject/images/${member.imageName}');">
</div>
<input type="file" id="image"  accept="image/*" onchange="setThumbnail(event)" name="imagename" placeholder="파일명">
<input type="text" name="imagenamebe" value="${member.imageName}" hidden="hidden">
</div>
<a id="deletelink" href="deleteMember?userno=${member.userno}" style="display: inline-block; float: right; margin-right: 100px; margin-top: 10px;">회원탈퇴</a>
<div style="text-align: center; margin-top: 10px;"><input type="submit" id="save" class="save" value="저장하기"></div>

</form>

	
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script type="text/javascript">
     
    	  
    		document.getElementById('save').onclick = function(){
    			var pwcheck = document.getElementById('password1').value
    			if(document.getElementById('password2').value != pwcheck){
    				  alert('비밀번호가 일치하지 않습니다');
    				  return false;
    			  } else {
    				  document.getElementById('formsave').submit();
    				  alert('수정이 완료되었습니다.');
    			  	}
    		}
      
	
                  function setThumbnail(event) {
                        var reader = new FileReader();

                        reader.onload = function (event) {
                              //var img = document.querySelector("div#image_container");
                              var img = document.querySelector("#image_container");
                              img.setAttribute("style", "background-image: url(" + event.target.result + ")");
                              //document.querySelector("div#image_container").appendChild(img);
                              

                        }
                        console.log(image);
                        reader.readAsDataURL(event.target.files[0]);
                  }
                  
                  $('input[name=password2]').focusout(function () {
                      var pwd1 = $('input[name=password1]').val();
                      var pwd2 = $('input[name=password2]').val();
                
                      if ( pwd1 != '' && pwd2 == '' ) {
                          null;
                      } else if (pwd1 != "" || pwd2 != "") {
                          if (pwd1 == pwd2) {
                        	  $('#same').html("비밀번호가 일치합니다.");
                          } else {
                              // 비밀번호 불일치 이벤트 실행
                        	  $('#same').html("비밀번호가 일치하지 않습니다.");
                          }
                      }
                  });
            </script>

</body>
</html>