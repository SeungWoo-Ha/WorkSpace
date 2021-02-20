<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css" />

  <title>join</title>
 </head>
 <body>
	<div id="wrap">
		<form id="join">
		<fieldset>
		<legend>회원가입정보</legend>
			<ul>
				<li><label class="label">아이디　</label><input type="text" id="user_id" required autofocus> <input type="button" value="중복확인" class="btn"> </li>
				<li><label class="label">패스워드　</label><input type="password" id="user_pw" required></li>
				<li><label class="label">패스워드 확인　</label><input type="password" id="user_pw_ck" required></li>
				<li><label class="label">이름　</label><input type="text" id="user_name" required></li>
				<li><label class="label">전화번호　</label><select name="mobile1" >
								<option value="">선택</option>
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
									</select>-<input type="tel" id="user_tel_1" maxlength="4" required size="5">
									-<input type="tel" id="user_tel_2" maxlength="4" required size="5"></li>
				<li><label class="label">우편번호　</label> <input type="text" id="user_post_code" size="10"> <input type="button" value="찾기" class="zipCheck()"></li>
				<li><label class="label">주소 1　</label> <input type="text" id="user_addr_1" size="30"></li>
				<li><label class="label">주소 2　</label> <input type="text" id="user_addr_2" size="30"></li>
				<li><div class="center"><input type="submit" value="회원가입" class="btn"> <input type="reset" value="다시입력" class="btn"></div></li>
			</ul>
			</fieldset>
		</form>
	</div><!--wrap 닫는태그-->
  
 </body>
</html>
