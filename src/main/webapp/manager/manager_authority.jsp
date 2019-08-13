<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath}/manager/assets/js/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		<!--[if !IE]> -->
		<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
		<!-- <![endif]-->
		<!--[if IE]>
         <script type="text/javascript">window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");</script>
        <![endif]-->
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
		</script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="${pageContext.request.contextPath}/manager/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/ace.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>

		<script type="text/javascript">
			$(function() {
				var cid = $('#nav_list> li>.submenu');
				cid.each(function(i) {
					$(this).attr('id', "Sort_link_" + i);

				})
			})
			jQuery(document).ready(function() {
				$.each($(".submenu"), function() {
					var $aobjs = $(this).children("li");
					var rowCount = $aobjs.size();
					var divHeigth = $(this).height();
					$aobjs.height(divHeigth / rowCount);
				});
				//初始化宽度、高度    
				$("#main-container").height($(window).height() - 76);
				$("#iframe").height($(window).height() - 140);

				$(".sidebar").height($(window).height() - 99);
				var thisHeight = $("#nav_list").height($(window).outerHeight() - 173);
				$(".submenu").height();
				$("#nav_list").children(".submenu").css("height", thisHeight);

				//当文档窗口发生改变时 触发  
				$(window).resize(function() {
					$("#main-container").height($(window).height() - 76);
					$("#iframe").height($(window).height() - 140);
					$(".sidebar").height($(window).height() - 99);

					var thisHeight = $("#nav_list").height($(window).outerHeight() - 173);
					$(".submenu").height();
					$("#nav_list").children(".submenu").css("height", thisHeight);
				});
				$(".iframeurl").click(function() {
					var cid = $(this).attr("name");
					var cname = $(this).attr("title");
					$("#iframe").attr("src", cid).ready();
					$("#Bcrumbs").attr("href", cid).ready();
					$(".Current_page a").attr('href', cid).ready();
					$(".Current_page").attr('name', cid);
					$(".Current_page").html(cname).css({
						"color": "#333333",
						"cursor": "default"
					}).ready();
					$("#parentIframe").html('<span class="parentIframe iframeurl"> </span>').css("display", "none").ready();
					$("#parentIfour").html('').css("display", "none").ready();
				});

			});

			//jQuery( document).ready(function(){
			//	  $("#submit").click(function(){
			//	// var num=0;
			//     var str="";
			//     $("input[type$='password']").each(function(n){
			//          if($(this).val()=="")
			//          {
			//              // num++;
			//			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
			//                title: '提示框',				
			//				icon:0,				
			//          }); 
			//             // layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
			//             layer.close(index);
			//          }		  
			//     });    
			//})		
			//	});
			/*********************点击事件*********************/
			$(document).ready(function() {
						$('#nav_list').find('li.home').click(function() {
							$('#nav_list').find('li.home').removeClass('active');
							$(this).addClass('active');
						});
			});
		</script>

		<style type="text/css">
			.xx1 {
				vertical-align: middle;
				margin-bottom: 3px;
			}
		</style>
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/manager/authority/save.do" method="post">
		<input type="hidden" name="roleId" value="${roleId}"/>
		<ul class="nav nav-list" style="margin: 0 15px; border: 1px solid #e5e5e5; margin-top: 40px;" id="nav_list">
			<c:forEach items="${list}" var="authority" varStatus="status">
			<li>
				<a href="#" class="dropdown-toggle"><span class="menu-text">${authority.name}</span><b class="arrow icon-angle-down"></b></a>
				<ul class="submenu">
					<li class="home">
						<a href="javascript:void(0)"  title="" class="iframeurl">
							<i class="icon-double-angle-right"></i>
							<input type="checkbox" name="authority" class="quanxuan" id="${authority.id}" style="vertical-align: middle; margin-bottom: 7px; margin-right: 5px;" value="${authority.id}" />全选
						</a>
					</li>
					<c:forEach items="${authority.children}" var="child" varStatus="status">
					<li class="home">
						<a href="javascript:void(0)" title="${child.name}" class="iframeurl">
							<i class="icon-double-angle-right"></i>
							<input type="checkbox" name="authority" class="qx" id="${child.id}" style="vertical-align: middle; margin-bottom: 7px; margin-right: 5px;" value="${child.id}" />${child.name}
						</a>
					</li>
					</c:forEach>
				</ul>
			</li>
			</c:forEach>
		</ul>
		<div style="text-align:center;margin-top:20px;"><input type="submit" value="保存"/></div>
		</form>
	</body>

	<script type="text/javascript">
		$(".quanxuan").click(function() { //给全选按钮加上点击事件
			var xz = $(this).prop("checked"); //判断全选按钮的选中状态
			var ck = $(this).parents('.submenu').find(".qx").prop("checked", xz); //让class名为qx的选项的选中状态和全选按钮的选中状态一致。  
		});
		$('.qx').click(function(){
			var xz = $(this).prop("checked");
			if(!xz){
				var ch = $(this).parents('.submenu').find(".qx:checked");
				if(ch.length==0){
					$(this).parents('.submenu').find('.quanxuan').prop("checked", xz);
				}
			}else{
				var ch = $(this).parents('.submenu').find(".qx:checked");
				var all = $(this).parents('.submenu').find(".qx");
				if(ch.length==all.length){
					$(this).parents('.submenu').find('.quanxuan').prop("checked", xz);
				}
			}
		});
		(function(){
			var array = ${array};
			for(var i=0;i<array.length;i++){
				$('#'+array[i]).attr('checked',true);
			}
		}())
	</script>

</html>