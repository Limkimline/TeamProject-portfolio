<%@page import="model.Member"%>
<%@ page import="dao.lecture_info.LectureInfoDaoImpl"%>
<%@ page import="dao.lecture_info.LectureInfoDao"%>
<%@ page import="dao.member.MemberDaoImpl"%>
<%@ page import="dao.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheckProc.jsp</title>
</head>
<body>
	<div style="text-align: center"></div>
	<h3>* 인증코드 확인 결과 *</h3>
	<% 
		HttpSession sess = request.getSession();
		Member curMember = (Member)sess.getAttribute("member");
		String authcode=request.getParameter("authcode"); 
		String result = null;
		
		if(curMember != null){
			
			String id = curMember.getId();
			
			LectureInfoDao lDao = new LectureInfoDaoImpl();
			result = lDao.codeSearch(id, authcode);
			
			if(result.equals("Y")) {
				lDao.updateAuthYN(id);
				//request.setAttribute("message", "인증이 완료되었습니다.");
				out.println("<strong>인증이 완료되었습니다.</strong>");
		    	out.println("<a href='javascript:apply(\"" + "Y" + "\")'>[나가기]</a>");
			} else { 
		    	out.println("<p style='color: red'>인증코드가 일치하지 않습니다.</p>"); 
		    }
			
			
		} else {
			MemberDao mDao = new MemberDaoImpl();
			result = mDao.searchCode(authcode);
			
			if(result.equals("Y")) {
				mDao.deleteCode(authcode);
				out.println("<strong>인증이 완료되었습니다.</strong>");
		    	out.println("<a href='javascript:apply(\"" + "Y" + "\")'>[인증완료]</a>");
			
			
	 %>
			<script> 
				function apply(id){ 
					
					opener.document.regForm.veryshortInput.value = id; 
					opener.document.regForm.btnAuth.disabled = true;
					window.close(); 
					
				}
			</script>
	
	<%
	
			} else { 
		    	out.println("<p style='color: red'>인증코드가 일치하지 않습니다.</p>"); 
		    }
		}
	
	%>
	
	<hr>
	<a href="javascript:history.back()">[다시시도]</a> 
	&nbsp; &nbsp;
	<a href="javascript:window.close()">[창닫기]</a>
</body>
</html>
