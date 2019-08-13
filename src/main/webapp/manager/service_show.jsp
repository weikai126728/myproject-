<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link
	href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/css/style.css" />
<link
	href="${pageContext.request.contextPath}/manager/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script
	src="${pageContext.request.contextPath}/manager/assets/js/jquery.min.js"></script>
<title>用户查看</title>
</head>

<body>
	<div class="member_show">
		<div class="member_content">
			<ul>
				
				<li><label class="label_name">物流单号：</label><span class="name">${log.logistics }</span></li>
				<li><label class="label_name">承运公司：</label><span class="name">${log.logistics_company }</span></li>
				<li><label class="label_name">发货时间：</label><span class="name">${log.createTime }</span></li>
				<li><label class="label_name">图片信息：</label>
				<c:forEach var="image" items="${log.img_path}" varStatus="status">
					<span class="name"><img src="${pageContext.request.contextPath}/image/showImage.do?image=${image}"></span>
				</c:forEach> 
				</li>
			</ul>
		</div>
	</div>
</body>

</html>