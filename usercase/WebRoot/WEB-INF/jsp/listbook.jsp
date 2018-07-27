<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>书籍列表界面</title>
    

  </head>
  
  <body style="text-align: center">
  	<table>
  		<tr>
  			<td>书名</td>
  			<td>作者</td>
  			<td>售价</td>
  			<td>描述</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach var="entry" items="${map}">
  			<tr>
  			<td>${entry.value.bookname}</td>
  			<td>${entry.value.author}</td>
  			<td>${entry.value.price}</td>
  			<td>${entry.value.description}</td>
  			<td><a href="" target="_blank">购买</a></td>
  		</tr>
  		
  		
  		</c:forEach>
  	</table>
	  	
  </body>
</html>