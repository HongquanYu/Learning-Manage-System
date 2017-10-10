<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Log In</title>
<link href="<%=request.getContextPath()%>/resources/css/style_log.css" rel="stylesheet" type="text/css">

</head>

<body class="login" mycollectionplug="bind">
<div class="login_m">
<div class="login_boder">

<div class="login_padding" id="login_model">

  <h2>User ID</h2>
  <label>
    <input type="text" id="username" class="txt_input txt_input2">
  </label>
  <h2>Password</h2>
  <label>
    <input type="password" name="textfield2" id="userpwd" class="txt_input">
  </label>
 
 

 
  <!-- <p class="forgot"><a id="iforget" href="javascript:void(0);">Forgot your password?</a></p> -->
  <div class="rem_sub">
  <div class="rem_sub_l">
   <label ><a class = "forgotPw" id="iforget" href="javascript:void(0);">Forgot your password?</a></label>
   </div>
    <label>
      <input type="submit" class="sub_button" name="button" id="button" value="Log In" style="opacity: 0.7;">
    </label>
  </div>
</div>

<!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
 <br> <br>



</body></html>