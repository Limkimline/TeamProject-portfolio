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
                  height: 100vh;
                  justify-content: center;
                  align-items: center;
            }

            .inputContainer{
                  width: 300px;
                  height: 100px;
                  display: flex;
                  margin-top: -300px;
                  flex-direction: column;
                  align-items: center;
            }

            .buttonSection{
                  display: flex;
                  flex-direction: row;
                  justify-content: center;
            }

            h3{
                  margin-bottom: 30px;
            }

            input{
                  width: 100px;
                  height: 30px;
                  margin: 15px;
                  cursor: pointer;
            }
            
             img{
            	width:500px;
            }


            #btnLogin, #btnHome{
                  width: 200px;
                  height: 50px;
                  background: #ff0045;
                  color: white;
                  border: 1px solid #ff0045;
            }
      </style>
      <script>
      	function goLogin() {
			location.href = 'login_init';
		}
      	
      	function goHome() {
			location.href = 'mainPage';
		}
      </script>
</head>
<body>
      <div class="Container">
            <div class="inputContainer">
                  <h3>GOOING 가입을 축하합니다!</h3>
                  <img alt="환영합니다" src="image/welcome.jpg">
                  <div class="buttonSection">
                        <input type="button" id="btnLogin" value="로그인 하기" onclick="goLogin()">
                        <input type="button" id="btnHome"  value="홈으로 가기" onclick="goHome()">
                  </div>
            </div>
      </div>
</body>
</html>