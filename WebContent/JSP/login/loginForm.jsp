<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <meta charset="utf-8">
      <title>로그인</title>
      <script>
              function findAccount() {
                  window.open("find_init","findwin","width=600, height=600");
              }
	  </script>
</head>
<style>
      * {
            margin: 0;
            padding: 0;
      }

      body {
            height: 100vh;
            display: flex;
            flex-direction: row wrap;
            align-items: center;
            justify-content: center;
            /* background: url("D:/7. JobTraining/구디아카데미_국비교육/JAVAWEB_2ndProject/pic/study.jpg") no-repeat; */
      }

      .fixMenu,
      .menu_left,
      .menu_middle,
      .menu_right {
            display: flex;
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

     img{
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

      a {
            text-decoration: none;
            color: black;
            font-size: 15px;
            font-weight: 500;
      }

      a:hover {
            color: grey;
      }

      

      .Container {
            width: 600px;
            height: 400px;
            /* border: 1px solid black; */
            text-align: center;
      }

      .inputContainer input {
            width: 300px;
            height: 30px;
            font-size: 15px;
            margin-top: 10px;
            padding: 5px;
      }

      .selectContainer {
            margin-top: 30px;
      }

      .selectContainer button {
            border: 1px solid black;
            width: 100px;
            height: 30px;
      }

      .Wrapper {
            margin-top: 100px;
      }

      Button,
      #loginBtn:hover {
            cursor: pointer;
      }
      
      .logo_img{
            width: 150px;
      }
      
      #join, #findID, #findPWD{
		width: 100px;
		height: 30px;     
		cursor:pointer; 
      }
      
      #join, #findID, #findPWD, #loginBtn{
      			  background: #ff0045;
                  color: white;
                  border: 1px solid #ff0045;
                  border-radius: 20px;
      }

</style>

<body>
      <div class="fixMenu">
            <div class="menu_left">
                  <a class="img_link" href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
            </div>
            <div class="menu_middle">
                  
            </div>
            <div class="menu_right">
                  <ul class="menu_list">
                        <li><a class="menu_link" href="#">LOG IN</a></li>
                        <li><a class="menu_link" href="#">Q&A</a></li>
                        <!-- <li><a class="menu_link" href="#">ACCOUNT</a></li> -->
                  </ul>
            </div>
      </div>
      <img src="image/study.jpg" alt="로고">
      <div class="Container">
            <div class="Wrapper">
            	  ${message}
                  <h3>GOOING 로그인</h3>
                  <div class="inputContainer">
                        <form action="login" method="post">
                              <input type="text" name="id" id="" placeholder="아이디"> <br>
                              <input type="password" name="password" id="" placeholder="비밀번호"> <br>
                              <input type="submit" value="로그인" id="loginBtn">
                        </form>
                  </div>
                  <div class="selectContainer">
                        <input type="button" id="findID" value="아이디 찾기" onclick="findAccount()">
                        <input type="button" id="findPWD" value="비밀번호 찾기" onclick="findAccount()">
                        <input type="button" id="join" value="회원가입" onclick="location.href='join_init'">
                  </div>
            </div>
      </div>
</body>

</html>