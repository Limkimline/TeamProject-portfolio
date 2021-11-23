<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>ID 찾기 결과</title>
      <style>
          *{
                margin: 0;
                padding: 0;
          }

          body{
                height: 100vh;
                display: flex;
                flex-direction: column;
                flex-wrap: nowrap;
                justify-content: center;
                align-items: center;
          }

          .Container{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
               
                
               
          }

          .resultContainer{
                display: flex;
                flex-direction: column;
                width: 100%;
                align-items: center;
                text-align: center;
          }

          fieldset{
                padding: 30px;
                width: 300px;
                font-size: 20px;
          }

          #btnClose{
                width: 100px;
                height: 40px;
          }
      </style>
      <script>
      	function close() {
      		  self.opener = self;
      		  window.close();
		}
      </script>
</head>
<body>
      <div class="Container">
            <fieldset>
                  <legend>ID 찾기 결과</legend>
                  <h5>검색된 ID는 총 ${size}개입니다.</h5>
                  <br>
                  <div class="resultContainer">
                        <ul>
                        <c:forEach var="IDresult" items="${IDresult}">
                              <li>${IDresult}</li>
                        </c:forEach>
                        </ul>
                        <br>
                  </div>
            </fieldset>
            
      </div>
</body>
</html>