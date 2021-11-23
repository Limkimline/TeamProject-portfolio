<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>계정찾기</title>
      <style>
            .Container {
                  display: flex;
                  flex-direction: column;
                  justify-content: center;
                  align-items: center;
            }

            .idContainer,
            .pwdContainer {
                  margin: 20px;
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

            .inputInfo {
                  display: flex;
                  flex-direction: row;
                  align-items: center;
            }

            .inputInfo input {
                  font-size: 15px;
                  margin-left: 20px;
                  border: 1px solid white;
                  background-color: transparent;
            }

            .Section {

                  margin-bottom: 20px;
            }

            .Section h4 {
                  font-size: 25px;
                  margin: 10px;
            }

            #btnFindID,
            #btnFindPWD {
                  margin-top: 10px;
                  width: 100px;
                  height: 30px;
            }

            #authEmail {
                  cursor: pointer;
                  border: 1px solid black;
            }

            #authEmail:hover {
                  background-color: cornflowerblue;
                  color: white;
                  font-weight: 500;
            }
      </style>
      <script>
	      function openResult() {
	    	  
	    	    var email = document.getElementById("email").value;
	    	    var userName = document.getElementById("userName").value;
	    	    window.open("find_ID?email=" + email + "&userName=" + userName , 'findPOP' , "width=400, height=700");
	    	
	      }
      </script>
</head>

<body>
      <div class="Container">
            <div class="idContainer">
                  <form action="find_ID" method="post">
                        <fieldset>
                              <legend>아이디찾기</legend>
                              <div class="inBox">
                                    <div class="inputInfo">
                                          <label>이름<input type="text" id="userName" name="userName" placeholder="이름을 입력하세요"></label>
                                    </div>
                              </div>
                              <div class="inBox">
                                    <div class="inputInfo">
                                          <label>이메일<input type="email" id="email" name="email" placeholder="이메일주소를 입력하세요"></label>
                                    </div>
                              </div>
                              <input type="button" id="btnFindID" value="아이디 찾기" onclick="openResult()"> 
                        </fieldset>
                        
                  </form>
            </div>
            <div class="pwdContainer">
                  <form action="valid_account" method="post">
                        <fieldset>
                              <legend>비밀번호 찾기</legend>
                              <div class="inBox">
                                    <div class="inputInfo">
                                          <label>아이디<input type="text" name="id" placeholder="ID를 입력하세요"></label>
                                    </div>
                              </div>
                              <div class="inBox">
                                    <div class="inputInfo">
                                          <label>이메일<input type="email" name="email" placeholder="이메일주소를 입력하세요"></label>
                                    </div>
                              </div>
                              <input type="submit" id="btnFindPWD" value="이메일 인증">
                       		  ${email_message}
                        </fieldset>
                  </form>
            </div>
      </div>
</body>

</html>