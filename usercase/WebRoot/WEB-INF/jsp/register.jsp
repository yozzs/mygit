<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>register.html</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script type="text/javascript">
    	function changeImage(img){
    		img.src=img.src+"?"+new Date().getTime();
    	}
    </script>
    
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
		登录帐号:<input type="text" name="username" value="${form.username}"> ${form.errors.username}<br>
		登录密码:<input type="password" name="password" value="${form.password}">  ${form.errors.password}<br>
		确认密码:<input type="password" name="password2" value="${form.password2}">  ${form.errors.password2}<br>
		电子邮箱:<input type="text" name="email" value="${form.email}">  ${form.errors.email}<br>
		用户昵称:<input type="text" name="nickname" value="${form.nickname}">  ${form.errors.nickname}<br>
		验证码:<input type="text" name="checkcode">
		<img src="${pageContext.request.contextPath}/servlet/ImageServlet" onclick="changeImage(this)" alt="换一张" style="cursor:hand">${form.errors.checkcode}<br>
		<input type="submit" value="注册"/>
	</form>
  </body>
</html>
