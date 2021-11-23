<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
</head>

<body>
      <div class="Container">
            <form action="JSP/register/authProc.jsp" method="post">
                  <h4>이메일로 본인인증코드 6자리가 발송되었습니다.</h4>
                  <div class="inputSection">
                        <label>인증코드 : <input type="text" name="authcode" id="authcode" maxlength="6"></label>
                        <input type="submit" value="인증완료">
                  </div>
            </form>
      </div>
</body>

</html>