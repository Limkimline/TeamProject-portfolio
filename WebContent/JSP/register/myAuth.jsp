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
                  <h4>�̸��Ϸ� ���������ڵ� 6�ڸ��� �߼۵Ǿ����ϴ�.</h4>
                  <div class="inputSection">
                        <label>�����ڵ� : <input type="text" name="authcode" id="authcode" maxlength="6"></label>
                        <input type="submit" value="�����Ϸ�">
                  </div>
            </form>
      </div>
</body>

</html>