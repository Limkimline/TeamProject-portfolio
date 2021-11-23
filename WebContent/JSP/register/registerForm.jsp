<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
      <title>수강 신청</title>
      <style>
            .Container{
                  display: flex;
                  height: 90vh;
                  flex-direction: column;
                  justify-content: center;
                  align-items: center;
            }
            .inputBox{
                  display: flex;
                  width: 800px;
                  height: 80px;
                  justify-content: center;
                  align-items: center;
                  border: 1px solid lightgray;
                  font-size: 20px;
                  margin-bottom: 0px;
            }

            .inputBox:nth-child(8){
                  display: flex;
                  flex-direction: column;
                  height: 300px;
            }

            .inputBox:nth-child(8) textarea{
                  font-size: 13px;
            }

            #longInput{
                  width: 280px;
                  margin-left: 40px;
                  font-size: 20px;
                  border: none;
                  background: transparent;
            }

            #shortInput{
                  width: 110px;
                  margin-left: 20px;
                  font-size: 20px;
                  border: none;
                  background: transparent;
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

            #btnSubmit{
                  width: 200px;
                  height: 50px;
                  margin-top: 20px;
                  cursor: pointer;
            }

            #txtInfo{
                  resize: none;
            }
            
            .logo_img {
				width: 100px;
				height: 30px;
			}
      </style>
      <script>
                  function openAuth() {
                        window.open("auth_init", "authwin", "width=400, height=350");
                  }
                  
                  if(document.getElementById('#veryshortInput').value == "Y"){
                      const target = document.getElementById('#btnAuth');
                      target.disabled = true;
                  }
                  
                  
       
      </script>
</head>
<body>
	<form action="register" method="post">
	      <div class="Container">
	      		<div class="inputBox">
	      			<a class="img_link" href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
	      		</div>
	      		<div class="inputBox">
		            <h2>강의 신청</h2>
	      		</div>
	            <div class="inputBox">
	                  <label>강의명 <input type="text" id="longInput" name="lecName" value="${lecture.name}" readonly></label>
	            </div>
	            <div class="inputBox">
	                  <label>강의일정<input type="text" id="shortInput" name="startDate" value="${splitStart}" readonly>  ~  <input type="text" id="shortInput" name="endDate" value="${splitEnd}" readonly></label>
	            </div>
	            <div class="inputBox">
	                  <label>강의시간<input type="text" id="shortInput" name="startTime" value="${lecture.starttime}" readonly>  ~  <input type="text" id="shortInput" name="endTime" value="${lecture.endtime}" readonly></label>
	            </div>
	            <div class="inputBox">
	                  <label>모집기간<input type="text" id="shortInput" name="startDate"  value="${recSplitStart}" readonly>  ~  <input type="text" id="shortInput" name="endDate" value="${recSplitEnd}" readonly></label>
	            </div>
	            <div class="inputBox">
	                  <label>모집인원<input type="text" id="shortInput" name="recruit" value="${lecture.rec_cnt}명" readonly></label>
	            </div>
	           
	            <div class="inputBox">
	                  <h5>강의 설명</h5>
	                  <textarea name="txtInfo" id="txtInfo" cols="60" rows="500" readonly>${lecture.content}</textarea>
	            </div>
	            <input type="submit" id="btnSubmit" value="수강신청">
	            <input type="hidden" name="lectureno" value="${lecture.lectureno}">
	      </div>
     </form>
</body>
</html>