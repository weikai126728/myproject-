<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
<title>404</title>

<!-- 当前网站样式！ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/404.css" />

<!-- 清楚默认样式&公共样式! -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping/wap/style.css" />

<!-- 网站根字体! -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shopping/wap/web.js"></script>

</head>
<body>

	<ul class="shiqu_yemian">
		<li><img src="${pageContext.request.contextPath}/image/404.png"
			alt="" /></li>
		<li><span>真的很抱歉~</span></li>
		<li><em>"暂时没有找到您要访问的页面！"</em></li>
		<li><a
			href="${pageContext.request.contextPath}/wap/home/index.do">返回首页&gt;</a></li>
	</ul>
	 
</body>
</html>
