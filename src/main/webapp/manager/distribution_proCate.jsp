<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	href="${pageContext.request.contextPath}/manager/Widget/zTree/css/zTreeStyle/zTreeStyle.css">
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
<!-- <![endif]-->
<!--[if IE]>
       <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <![endif]-->
<!--[if !IE]> -->
<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/manager/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script
	src="${pageContext.request.contextPath}/manager/assets/js/ace-elements.min.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/ace.min.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/manager/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/lrtk.js"
	type="text/javascript"></script>
<title>分类管理</title>
</head>

<body>
	<div class=" clearfix">
		<div id="category">
			<div id="scrollsidebar" class="left_Treeview">
				<div class="show_btn" id="rightArrow">
					<span></span>
				</div>
				<div class="widget-box side_content">
					<div class="side_title">
						<a title="隐藏" class="close_btn"><span></span></a>
					</div>
					<div class="side_list">
						<div class="widget-header header-color-green2">
							<h4 class="lighter smaller">产品类型列表</h4>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-8">
								<div id="treeDemo" class="ztree"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!---->
			<iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0
				SCROLLING=AUTO
				SRC="${pageContext.request.contextPath}/distribution/productCate/to/handle.do"
				class="page_right_style"></iframe>
		</div>
	</div>
</body>
</html>
<script type="text/javascript"> 
$(function() { 
	$("#category").fix({
		float : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false
	});
});
</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()); 
 $(".page_right_style").width($(window).width()-220);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height());
	 $(".page_right_style").width($(window).width()-220);
	})
 
/**************/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src",'${pageContext.request.contextPath}/distribution/productCate/to/handle.do?id='+treeNode.id);
				return true;
			}
		}
	}
};

var zNodes = ${array};
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
		
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	demoIframe.bind("load", function(){});
	var zTree = $.fn.zTree.getZTreeObj("tree");
	console.log(zTree);
// 	zTree.selectNode(zTree.getNodeByParam("id",'11'));
});	
</script>