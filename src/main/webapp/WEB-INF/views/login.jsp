
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Log In</title>
<link href="<%=request.getContextPath()%>/resources/css/style_log.css"
	rel="stylesheet" type="text/css">

</head>

<body class="login" mycollectionplug="bind">
	<div class="login_m">
		<div class="login_boder">

			<form action="/EZComm/login" method="post">
				<div class="login_padding" id="login_model">
					<h2>User Email</h2>
					<label> <input type="text" name="userEmail"
						id="txtUserName" class="txt_input txt_input2" required="required">
					</label>
					<h2>Password</h2>
					<label> <input type="password" name="userPasd"
						id="txtPassd" class="txt_input" required="required">
					</label>

					<div class="rem_sub">
						<div class="rem_sub_l">
							<label><a class="forgotPw" id="iforget" href="resetPWD">Forgot
									your password?</a></label>
						</div>
						<label> <input type="submit" class="sub_button"
							name="button" id="button" value="Log In" style="opacity: 0.7;">
						</label>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br>
	<br>

	<div class="panel-footer" align="center">
		<font style="color: #111">Copyright @2017 <a>ezcomm.umd.com</a>,
			All Rights Reserved.
		</font>
	</div>
</body>
</html>
