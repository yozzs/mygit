<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网站应用界面</title>
    

  </head>
  
  <body>
  	<c:if test="${user!=null}">
    	欢迎您，${user.nickname} <a href="">注销</a> <br>
  	</c:if>	
  	<br/>
  	<br/>
  	<hr>
  </body>
</html>
