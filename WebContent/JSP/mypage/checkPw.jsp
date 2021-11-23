<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <style>
            *{
                  margin: 0;
                  padding: 0;
            }

            .Container{
                  display: flex;
                  flex-direction: column;
                  justify-content: center;
                  align-items: center;
            }

            .inputContainer{
                  width: 300px;
                  height: 100px;
                  display: flex;
                  flex-direction: column;
                  align-items: center;
            }

            .buttonSection{
                  display: flex;
                  flex-direction: row;
                  justify-content: center;
                  align-items: center;
                  position: absolute;
                  margin-top:100px;
                  right: 50%;
                  left: 50%
            }

            h3{
                  margin-bottom: 30px;
            }

            input{
                  width: 200px;
                  height: 30px;
            }
            
body {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	align-items: center;
	justify-content: center;
	padding-top: 230px;
	/* background: url("D:/7. JobTraining/구디아카데미_국비교육/JAVAWEB_2ndProject/pic/study.jpg") no-repeat; */
}

.fixMenu, .menu_left, .menu_middle, .menu_right {
	display: flex;
	flex-wrap: nowrap;
}

.fixMenu {
	position: fixed;
	width: 100%;
	top: 0;
	left: 0;
	background-color: white;
	justify-content: space-between;
	z-index: 1;
	/* border: 1px solid black; */
}

a img {
	width: 1200px;
}

.menu_left {
	position: relative;
	margin-left: 120px;
	margin-top: 40px;
}

.menu_middle {
	position: relative;
	margin: 0 30px;
}

.menu_right {
	position: relative;
	margin-right: 50px;
}

.menu_list {
	display: flex;
	flex-wrap: nowrap;
	list-style-type: none;
	margin-top: 10px;
	margin: 40px 0;
}

.menu_link {
	margin: 10px 15px;
	white-space: nowrap;
}

.menu_left .img_link {
	margin: 5px;
}


.logo_img {
	width: 100px;
	height: 30px;
}


      </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		  var memberPw = ${memberPw};
			document.getElementById('checkbtn').onclick = function(){
				if(document.getElementById('password').value != memberPw){
					  alert('비밀번호가 일치하지 않습니다');
				  } else {
					  document.getElementById('checkForm').submit();
				  }
	 		}
	 }
</script>
</head>
<body>
      <div class="fixMenu">
            <div class="menu_left">
                  <a class="img_link" href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
            </div>
            
            <div class="menu_right">
                  <ul class="menu_list">
	                        <li><a class="menu_link" href="logout">LOGOUT</a></li>
	                        <li><a class="menu_link" href="#">Q&A</a></li>
                  </ul>
            </div>
      </div>
      
      <div class="Container">
            <div class="inputContainer">
                  <h3>본인확인이 필요합니다.<br>
                  	비밀번호를 입력해주세요.</h3>
                  	
                  <div class="buttonSection">
                  <form method="post" id="checkForm" action="myProfile">
                       <input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요">
                        <input type="button" value="확인" id="checkbtn">
                   </form>
                  </div>
            </div>
      </div>
</body>

</html>