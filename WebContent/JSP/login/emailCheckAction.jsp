<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>인증구역</title>
<style>
.Container {
	display: flex;
	height: 100vh;
	justify-content: center;
	align-items: center;
}

.chgPassword {
	display: flex;
	flex-direction: column;
}

.inBox {
	margin: 30px;
}

input {
	width: 300px;
	height: 30px;
}

#submit {
	margin-left: 100px;
}
</style>
</head>
<body>

	<c:if test="${status == 'yes'}">
		<div class="Container">
		<div class="chgPassword">
			<form action="chg_pwd" method="post">
				<fieldset>
					<legend>비밀번호 변경</legend>
					<div class="inBox">
						<div class="inputInfo">
							<label>변경할 비밀번호 <input type="password" name="password"
								placeholder="비밀번호를 입력하세요"></label>
						</div>
					</div>
					<div class="inBox">
						<div class="inputInfo">
							<label>비밀번호 확인 <input type="password"
								name="passwordConfirm" placeholder="비밀번호를 다시 입력하세요"></label>
						</div>
					</div>
					<input type="hidden" value="${code}" name = "code">
					<input type="submit" id="submit" value="비밀번호 변경">
				</fieldset>
			</form>
			${error}
		</div>
	</div>
	</c:if>
	<c:if test="${status == 'no'}">
		<h2>만료된 인증입니다.</h2>
	</c:if>
</body>
</html>