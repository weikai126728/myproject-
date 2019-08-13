<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>新闻内容</title>

		<!-- 公共样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comp/style.css" />

		<!-- 当前网页样式 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comp/news.css" />

		<!-- JS引用 -->
		<script src="${pageContext.request.contextPath}/js/comp/jquery-1.11.1.min.js"></script>

		<!-- 返回顶部样式~JS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comp/lrtk.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comp/lrtk.js"></script>

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comp/jquery-1.11.1.js"></script>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/js/common/layui/css/layui.css" media="all">

	</head>
	<style>
		.taupeTemplate .fl ul .title_,
		.taupeTemplate .fl .newS_ .blueT,
		.taupeTemplate .fr .Box_top span,
		.taupeTemplate .fr .Box_top a,
		.Box_ a:hover {
			color: #724e45;
		}
		
		.taupeTemplate .fl ul li a:hover,
		.taupeTemplate .fr .fr_top ul li b {
			background-color: #724e45;
		}
		
		.taupeTemplate .fr .Box_top {
			border-bottom-color: #724E45;
		}
		
		#demo2 a:hover {
			color: #f84f18;
		}
	</style>

	<body>

		<!-- top_nav! -->
		 <div class="gWidth top_nav">
		<div class="nav clearfix">
			<div class="fl">
				<a ><img src="${pageContext.request.contextPath}/image/comp/logo2.png" alt="logo" class="logo"></a>
			</div>
			<div class="fr">
				<ul class="clearfix">
					<li><a href="" >首页</a></li>
					<li><a href="" class="active">新闻中心</a></li>
					<li><a href="">项目介绍</a></li>
					<li><a href="">关于我们</a></li>
					<li><a href="">加入我们</a></li>
					<li><a href="">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
		<div style="width: 100%; margin-top: 20px;">
			<img style="width: 100%;" src="${pageContext.request.contextPath}/image/comp/new.jpg" alt="" />
		</div>

		<div class="news_box clearfix gWidth">
			<h2>${news.title }</h2>
			<span>分类：
				<c:if test="${news.type==1 }">新闻要闻</c:if>
				<c:if test="${news.type==2 }">行业动态</c:if>
			<em>发布时间：${news.createTime }</em></span>
			<i id="details">${news.details }</i>
		</div>
		
		
		<div>
			
		</div>

		 <!-- bottom! -->
		 <div class="bottom_ gWidth">
		<ul>
			<li><a href="">首页</a><span>|</span>
				<a href="">关于我们</a><span>|</span>
				<a href="">联系我们</a><span>|</span>
				<a href="">意见反馈</a></li>
			<li>地址：河北省保定市翠园街与复兴中路交叉口康泰国际3-607&nbsp;电话：400-700-6300</li>
			<li>冀ICP备123123123号</li>
		</ul>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comp/backtop.js"></script>

	<div style="text-align: center; margin: 50px 0"></div>

	</body>

	<script type="text/javascript">
	 var img=document.getElementById("details").getElementsByTagName("img");;
	 for (var i = 0; i < img.length; i++) {
		img[i].src="${pageContext.request.contextPath}/image/showImage.do?"+img[i].src.split('?')[1];
	 }
	
		$(".N_nav li").click(function() {
			clear();
			$(this).addClass("active");
		});

		function clear() {
			$(".N_nav li").each(function() {
				if($(this).hasClass("active")) {
					$(this).removeClass("active");
				}
			});
		}
	</script>


</html>