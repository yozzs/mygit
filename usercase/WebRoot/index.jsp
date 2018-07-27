<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录界面</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
  </head>
  
  <body>
	<div id="container">
		<div id="biaoti">
			<div>用户登录</div>
		</div>
		<div id="login">
			<div id="girl">
				<img src="${pageContext.request.contextPath}/images/girl.jpg">
			</div>
			
			<div id="form">
				<form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
					<div id="form_center">
						<div id="input">
							用户：<input type="text" name="username"/><br/>
							密码：<input type="password" name="password"/><br/>
						</div>
						<div id="btn">
							<input type="submit" value="登录" >
							<input type="button" value="注册" onclick="window.location.href='${pageContext.request.contextPath}/servlet/RegisterUIServlet'">
						</div>
					</div>
					
				</form>
			</div>
			
		</div>
	</div>
  </body>
</html>
