<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginID = (String)session.getAttribute("loginID");
%>
<!doctype html>
 <head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css" />
  <title>Login</title>
 </head>
 <body>
  	<div id="login">
			<form>
			<fieldset>
				<legend>Login</legend>
				<div>
					<label class="login_form">아이디 : </label><input type="text" id="user_login_id" size="15" required placeholder="ID입력">
			
					</div>
					<div>
						<label class="login_form">비밀번호 : </label><input type="password" id="user_login_pw" size="15" required placeholder="Password입력">
						</div>
										<div id="lo_btn">
					<label><input type="submit" value="LOGIN" class="btn"></label>
					<label><input type="button" value="JOIN" class="btn" onclick="window.location='regForm.jsp'"></label>
					<label><input type="button" value="ID/PW 찾기" class="btn" onclick="window.location='joinus.html'"></label></div>
					</fieldset>
					</form>

	</div>
 </body>
</html>
