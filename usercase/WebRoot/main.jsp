<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>网站应用界面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script type="text/javascript">
    	function hiddenDiv(div){
    		div.style.display=(div.style.display=='none'?'block':'none');
    	}
    </script>
  </head>
  
  <body>
  <div id="container">
  	<div id="title">书 店</div>
  		
	  	<div style="text-align: right;padding-top: 5px;padding-right: 20px;">
	  		
	  			<c:if test="${user!=null}">
	    			欢迎您，${user.nickname} <a href="${pageContext.request.contextPath}/servlet/LogoutSerlvet">注销</a> <br>
	  			</c:if>	
	  		
	  	</div>
  	
  	<hr>
  	<div id="book">
  		<div id="left">
  			<div><img src="${pageContext.request.contextPath}/images/dongtu2.gif"></div>
  			<div id="item">
  				<div class="item1" id="item1">
  					<div class="item11" id="item11">
  						<div class="item11h" id="item11h"><a href="javascript:void()" onclick="hiddenDiv(document.getElementById('item12'))">书 籍 分 类</a></div>
  					</div>
  					<div class="item12" id="item12">
  						<ul>
  							<li><a href="">武侠小说</a></li>
  							<li><a href="">文学历史</a></li>
  							<li><a href="">诗词歌赋</a></li>
  							<li><a href="">使用技能</a></li>
  						</ul>
  					</div>
  				</div>
  				<div class="item1" id="item2">
  					<div class="item11" id="item21">
  						<div class="item11h" class="item21h"><a href="javascript:void()" onclick="hiddenDiv(document.getElementById('item22'))">系 统 管 理</a></div>
  					</div>
  					<div class="item12" id="item22">
  						<ul>
  							<li><a href="">修改用户资料</a></li>
  							<li><a href="">修改用户密码</a></li>
  							<li><a href="">系统配置</a></li>
  							<li><a href="">数据更新</a></li>
  						</ul>
  					</div>
  				</div>
  				<div class="item1" id="item3">
  					<div class="item11" id="item31">
  						<div class="item11h" id="item31h"><a href="javascript:void()" onclick="hiddenDiv(document.getElementById('item32'))">安 全 管 理</a></div>
  					</div>
  					<div class="item12" id="item32">
  						<ul>
  							<li><a href="">企业安全</a></li>
  							<li><a href="">信息安全管理</a></li>
  							<li><a href="">安全审计</a></li>
  							<li><a href="">网站安全</a></li>
  						</ul>
  					</div>
  				</div>
  			</div>
  			<div id="vers">版本号:2017v1.0</div>
  		</div>
  		<div id="mid">
  			<div class="btn" id="btnl">
				<input type="button" value="<" onclick="window.location.href='${pageContext.request.contextPath}/servlet/LastPageServlet?pageCode=${pageCode}'">
			</div>
  			<table width="1080x" border="1" align="center" style="float:left">
	  				<tr>
	  					<c:forEach var="book" items="${bookList}" begin="0" end="5" step="1">
		  					<td colspan="1" width="170px" height="250px" style="text-align: center;padding: 6px;">
		  					<c:if test="${book!=null}">
								<img src="${pageContext.request.contextPath}/images/books/${book.imguri}"></img>
								<br>
								<a class="price">￥:${book.price}</a>
								<a class="buy" href="${pageContext.request.contextPath}/servlet/WatchServlet?bookId=${book.id}">查看</a>
								<a class="buy" href="">购买</a>
		  					</c:if>
							</td>
						</c:forEach>
					</tr>
					<tr>
	  					<c:forEach var="book" items="${bookList}" begin="6" end="11" step="1">
		  					<td colspan="1" width="170px" height="250px" style="text-align: center;padding: 6px;">
			  					<c:if test="${book!=null}">
									<img src="${pageContext.request.contextPath}/images/books/${book.imguri}"></img>
									<br>
									<a class="price">￥:${book.price}</a>
									<a class="buy" href="${pageContext.request.contextPath}/servlet/WatchServlet?bookId=${book.id}">查看</a>
									<a class="buy" href="">购买</a>
								</c:if>
							</td>
						</c:forEach>
					</tr>
					<tr>
	  					<c:forEach var="book" items="${bookList}" begin="12" end="17" step="1">
		  					<td colspan="1" width="170px" height="250px" style="text-align: center;padding: 6px;">
			  					<c:if test="${book!=null}">
									<img src="${pageContext.request.contextPath}/images/books/${book.imguri}"></img>
									<br>
									<a class="price">￥:${book.price}</a>
									<a class="buy" href="${pageContext.request.contextPath}/servlet/WatchServlet?bookId=${book.id}">查看</a>
									<a class="buy" href="">购买</a>
								</c:if>
							</td>
						</c:forEach>
					</tr>
  			</table>
  			<div class="btn" id="btnr">
				<input type="button" value=">" onclick="window.location.href='${pageContext.request.contextPath}/servlet/NextPageServlet?pageCode=${pageCode}'">
			</div>
			
  		</div>
  		<div id="right">
  			<div id="tianqi" style="margin:5px 10px;background-color: white;"><img src="${pageContext.request.contextPath}/images/dongtu4.gif"></div>
  			<div id="righttop">
  				<div id="bookdesimg">
  					<img src="${pageContext.request.contextPath}/images/books/${watchbook.imguri}"></img>
  				</div>
  				<div id="bookdesbean">
  					<c:if test="${null!=watchbook}">
	  					书名:《${watchbook.bookname}》<br>
	  					作者:${watchbook.author}<br>
	  					价格:${watchbook.price}元<br>
	  					出版社:${watchbook.press}
  					</c:if>
  				</div>
  				<div id="bookdestext">
  					${watchbook.description}
  				</div>
  			</div>
  			<div id="rightdown" >
  				<input type="button" value="购物车" onclick="window.location.href=''" >
  			</div>
  			
  		</div>
  	</div>
  </div>
	<div id="page" style="width:1899px; height:36px;">第 ${pageCode}/3 页</div>
  </body>
  
</html>
