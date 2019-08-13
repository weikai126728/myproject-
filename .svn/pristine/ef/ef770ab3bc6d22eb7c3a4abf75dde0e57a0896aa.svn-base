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
<title>超市详情</title>
</head>

<body>
	<div class="member_show">
		<div class="member_jbxx clearfix">
			<img class="img" src="${pageContext.request.contextPath}/image/showImage.do?image=${market.imgSmall}">
			<dl class="right_xxln">
				<%-- <dt>
					<span class="">超市名称&nbsp;:&nbsp; </span> 
					<span class="">${market.name }</span>
				</dt> --%>
				<dt>
					<span class="">联系人&nbsp;:&nbsp; </span> 
					<span class="">${market.contactUser }</span>
				</dt>
				<dt>
					<span class="">经营类别&nbsp;:&nbsp; </span> 
					<span class="">${market.details }</span>
				</dt>
				<%-- <dd class="" style="margin-left: 0">简介：&nbsp;${market.details }</dd> --%>
			</dl>
		</div>
		<div class="member_content">
			<ul>

				<li><label class="label_name">超市简介：</label><span class="name">${market.introduction }</span></li>
				<li><label class="label_name">详细地址：</label><span class="name">${market.address.detail }</span></li>
				<li><label class="label_name">店铺编号：</label><span class="name">${market.product_id }</span></li>
				<li><label class="label_name">联系电话：</label><span class="name">${market.phone }</span></li>
				<li><label class="label_name">入驻时间：</label><span class="name">${market.createTime }</span></li>


			</ul>
		</div>
	</div>
</body>

</html>