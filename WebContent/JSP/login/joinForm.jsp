<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<script>
                  function idCheck() {
                        window.open("JSP/login/idCheckForm.jsp", "idwin", "width=400, height=350");
                  }
                  
                  function openAuth() {
                	  
              	    var email = document.getElementById("email").value;
              	    window.open("join_auth?email=" + email , 'joinAuthPop' , "width=400, height=350");
              	
                }
</script>
<style>
* {
	margin: 0;
	padding: 0;
}

.Container {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.inBox {
	display: flex;
	flex-direction: column;
	border: 1px solid lightgray;
	width: 500px;
	height: 44px;
	padding: 10px;
	justify-content: center;
}

.inputInfo {
	font-size: 15px;
	color: grey;
}

.inputInfo input {
	font-size: 15px;
	margin-left: 20px;
	border: 1px solid white;
	background-color: transparent;
}

.Section {
	border: 1px solid grey;
	margin-bottom: 20px;
}

.Section h4 {
	font-size: 25px;
	margin: 10px;
}

.Section:nth-child(6), .Section:nth-child(7) {
	display: flex;
	flex-direction: row;
}

.Section:nth-child(6)>.inBox {
	width: 235px;
}

.inputInfo {
	display: flex;
	flex-direction: row;
	align-items: center;
}

.join {
	cursor: pointer;
	width: 530px;
	height: 60px;
	border: 1px solid white;
	font-size: 15px;
}

.join:hover, button:hover, #idcheck:hover, #findFile:hover, #previewPic:hover
	{
	border: 1px solid black;
	background-color: rgb(70, 70, 243);
	color: white;
}

#interest {
	border: 1px solid white;
	font-size: 15px;
}

button {
	width: 100px;
	height: 30px;
	cursor: pointer;
	border: 1px solid white;
}

img {
	width: 400px;
	cursor:pointer;
}

#idcheck, #findFile, #previewPic {
	width: 80px;
	height: 30px;
	cursor: pointer;
}

#preview {
	cursor: pointer;
}

#image_container {
	width: 300px;
	height: 200px;
	border: 1px solid black;
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;
}

.Section:nth-child(7)>.inBox {
	height: 200px;
	border: 1px solid black;
}

#veryshortInput{
                  width: 50px;
                  margin-left: 20px;
                  font-size: 20px;
                  border: none;
                  background: transparent;
                  text-align: center;
            }
            
#btnAuth{
                  width: 100px;
                  height: 30px;
                  margin-left: 10px;
                  cursor: pointer;
            }
            
            #btnJoin{
            	width:250px;
            	height:30px;
            	background: #ff0045;
                color: white;
                border: 1px solid #ff0045;
            	cursor:pointer;
            }
</style>
<script type="text/javascript">



if(document.getElementById('#veryshortInput').value == "Y"){
  const target = document.getElementById('#btnAuth');
  target.disabled = true;
}


window.onload = function() {
	document.getElementById('btnJoin').onclick = function(){
		if(document.getElementById('password').value != document.getElementById('password_confirm').value){
			  alert('비밀번호가 일치하지 않습니다');
		  } else {
			  document.getElementById('joinForm').submit();
			  return false;
		 }
	}
}

</script>
</head>

<body>
	<form name="regForm" id="joinForm" enctype="multipart/form-data" action="join" method="post">
		<div class="Container">
			<a href="mainPage">
				<img src="image/logo.PNG" alt="logo" >
			</a>
			<div class="Section">
				<h4>회원가입</h4>
				<div class="inBox">
					<div class="inputInfo">
						<label>아이디<input type="text" name="id"
							placeholder="ID를 입력하세요" readonly></label> <input type="button"
							id="idcheck" value="ID중복확인" onclick="idCheck()">
					</div>
				</div>
				<div class="inBox">
					<div class="inputInfo">
						<label>비밀번호<input type="password" name="password" id="password"
							placeholder="비밀번호를 입력하세요"></label>
						<p>${error}</p>
					</div>
				</div>
				<div class="inBox">
					<div class="inputInfo">
						<label>비밀번호 확인<input type="password" id="password_confirm"
							name="password_confirm" placeholder="비밀번호를 다시 한번 입력하세요"></label>
					</div>
				</div>
			</div>
			<div class="Section">
				<div class="inBox">
					<div class="inputInfo">
						<label>이름<input type="text" name="name" id=""></label> <input
							type="radio" name="sex" id="sex" value="M">남 <input
							type="radio" name="sex" id="sex" value="F">여
					</div>
				</div>
			</div>
			<div class="Section">
				<div class="inBox">
					<div class="inputInfo">
						<label>휴대전화<input type="tel" name="phone"
							placeholder="- 없이 입력"></label>
					</div>
				</div>
			</div>
			<div class="Section">
				<div class="inBox">
					<div class="inputInfo">
						<form name="authForm" action="#" method="post">
							<label>이메일<input type="email" id="email" name="email" placeholder="메일주소 입력"></label>
							<c:if test="${authYN != 'Y'}">
		                  	<input type="button" id="btnAuth" value="본인인증하기" onclick="openAuth()">
		                  	</c:if>
						</form>
					</div>
				</div>
			</div>
			<div class="Section">
				<div class="inBox">
					<div class="inputInfo">
						<label>관심사1 <select name="interest1" id="interest">
								<option value="null">==선택==</option>
								<option value="1">프로그래밍</option>
								<option value="2">스포츠</option>
								<option value="3">음악</option>
								<option value="4">패션</option>
								<option value="5">언어</option>
								<option value="6">투자</option>
						</select></label>
					</div>
				</div>
				<div class="inBox">
					<div class="inputInfo">
						<label>관심사2 <select name="interest2" id="interest">
								<option value="null">==선택==</option>
								<option value="1">프로그래밍</option>
								<option value="2">스포츠</option>
								<option value="3">음악</option>
								<option value="4">패션</option>
								<option value="5">언어</option>
								<option value="6">투자</option>
						</select></label>
					</div>
				</div>
			</div>
			
			<div class="Section">
				<div class="inBox">
					<div class="inputInfo">
						<p>프로필 사진</p>
						<div id="image_container"></div>
						<input type="file" id="image"  accept="image/*"
							onchange="setThumbnail(event)" name="imagename" placeholder="파일명">
					</div>
				</div>
			</div>
			
			<!-- <form name="authForm" action="join" method="post">
	        </form> -->
		        <label><input type="hidden" id="veryshortInput" name="authYN" value="N" readonly></label>
			
			<!-- <input type="submit" class="join" value="가입하기"> -->
			<input type="button" id = "btnJoin" class="btnJoin" value="가입하기" onclick="clkJoin()">
		</div>
	</form>
	<script type="text/javascript">
                  function setThumbnail(event) {
                        var reader = new FileReader();

                        reader.onload = function (event) {
                              var img = document.querySelector("div#image_container");
                              img.setAttribute("style", "background-image: url(" + event.target.result + ")");
                              //document.querySelector("div#image_container").appendChild(img);
                        }
                        console.log(image);
                        reader.readAsDataURL(event.target.files[0]);
                  }
                  
                  
                  function clkJoin() {
                	  if(document.getElementById('password').value != document.getElementById('password_confirm').value){
            			  alert('비밀번호가 일치하지 않습니다');
            		  } else {
            			  if(document.getElementById('btnAuth').disabled){
            				  document.getElementById('joinForm').submit();
                			  return false;
            			  } else {
            				  alert('본인인증을 진행하고 가입을 진행해주세요');
            			  }
            		 }
				}
                  
                  
    </script>
</body>

</html>