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
		<div class="member_jbxx clearfix">
			<img class="img" src="${pageContext.request.contextPath}/image/showImage.do?image=${customer.ico}">
			<dl class="right_xxln">
				<dt>
					<span class="">真实姓名&nbsp;:</span> 
				</dt>
				<dt><span class="">${user.nickName }</span></dt>
			</dl>
		</div>
		<div class="member_content">
			<ul>
				
				<li><label class="label_name">手机号码：</label><span class="name">${user.phone }</span></li>
				<li><label class="label_name">注册时间：</label><span class="name">${user.createTime }</span></li>
				<!-- <li><label class="label_name">剩余积分：</label><span class="name">330</span></li> -->
				<li><label class="label_name">用户等级：</label>
				<c:if test="${user.role.name != null && user.role.name !='' }">
				<span class="name">${user.role.name }</span></li>
				</c:if><c:if test="${user.role.name == null || user.role.name =='' }">
				<span class="name">普通会员</span></li>
				</c:if>
				<c:if test="${user.status==1 }">
					<li><label class="label_name">启用状态：</label><span class="name">已启用</span></li>
				</c:if>
				<c:if test="${user.status==0 }">
					<li><label class="label_name">启用状态：</label><span class="name">已禁用</span></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>

</html>