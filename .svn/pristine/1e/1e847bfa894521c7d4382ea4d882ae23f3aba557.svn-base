<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/PIE_IE678.js"></script>
<![endif]-->
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
	href="${pageContext.request.contextPath}/manager/Widget/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link
	href="${pageContext.request.contextPath}/manager/Widget/icheck/icheck.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/manager/Widget/webuploader/0.1.5/webuploader.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/manager/css/upload.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/manager/css/pro_add.css"
	rel="stylesheet" type="text/css" charset="utf-8" />
<title>代金券添加</title>
</head>
<style type="text/css">
	#div{
        border: 2px solid #ccc; 
        position: absolute; 
    }
    .datebox{
        width: 100%;
        position: relative;
        height: 24px;
        margin-top: 6px; 
    }
    #date{
        position: absolute;
        left: 1px;
        top: 1px;
        z-index: 50;
        width: 100px;
        height: 100%;
        height: 22px;     
        background-color: #FFFFFF;  
        border: 1px solid transparent;
    }
    .mydate{
        width: 150px;
        height: 24px;
        border: 1px solid #CCC;
    }
    input[readonly] {
    	background: #ffffff!important;
	}
</style>
<body>
	<input type="hidden" id="root"
		value="${pageContext.request.contextPath}" />
	<div class="clearfix" id="add_picture">
		<!-- <div id="scrollsidebar" class="left_Treeview">
			<div class="show_btn" id="rightArrow">
				<span></span>
			</div>
			<div class="widget-box side_content">
				<div class="side_title">
					<a title="隐藏" class="close_btn"><span></span></a>
				</div>
				<div class="side_list">
					<div class="widget-header header-color-green2">
						<h4 class="lighter smaller">选择产品类型</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main padding-8">
							<div id="treeDemo" class="ztree"></div>
						</div>
					</div>
				</div>
			</div>
		</div> -->
		<div class="page_right_style">
			<div class="type_title">代金券添加</div>
			<form style="margin-left: 30%;"
				action=""
				method="post" class="form form-horizontal"
				enctype="multipart/form-data" id="form-article-add">
				
				
				<div class="clearfix cl" style=" ">
					<label class="form-label col-2"><span style="color: red">*</span>批次号：</label>
					<div class="formControls col-10" style="width: 25%;">
						<input maxlength="50" type="text" class="input-text" value=""
							name="coupon_stock_id" id="coupon_stock_id"
							onchange="VoucherData.coupon_stock_id=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>时间：</label>
					<div class="formControls col-10" style="width: 25%;">
						<!-- <input maxlength="50" type="text" class="input-text" value=""
							name="sendTime" id="sendTime"
							onchange="VoucherData.sendTime=this.value"> -->
						<!--<input class="inline laydate-icon" type="date" id="start" style="width: 100%; margin-left: 0;">-->
						<div class="datebox" style="width: 100%;vertical-align: middle;">
					        <input type="text" id="date" readonly="readonly" style="margin-left: 0; padding: 0;" />
					        <input type="date" class="mydate" onchange="aaa(this)" style="width: 100%;margin-left: 0;padding: 0;" />
					    </div>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>卡包ID：</label>
					<div class="formControls col-10" style="width: 25%;">
						<input maxlength="50" type="text" class="input-text" value=""
							name="cadeId" id="cadeId"
							onchange="VoucherData.cadeId=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<div class="Button_operation" style="margin-left: 21.5%;">
						<input class="btn btn-primary radius" type="button" onclick="addVoucher()" value="添加">
					</div>
				</div>
			</form>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/Widget/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/Widget/icheck/jquery.icheck.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/webuploader/0.1.5/webuploader.min.js"></script> --%>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/ueditor/1.4.3/ueditor.config.js"></script> --%>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/ueditor/1.4.3/ueditor.all.min.js"> </script> --%>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>  --%>
	<script src="${pageContext.request.contextPath}/manager/js/lrtk.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/js/pro_add.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/js/pro_source.js"></script>
	<script>
		$(function() {
			$("#add_picture").fix({
				'float' : 'left',
				skin : 'green',
				durationTime : false,
				stylewidth : '220',
				spacingw : 0,
				spacingh : 260,
			});
		});
		$(document).ready(function() {
			//初始化宽度、高度

			$(".widget-box").height($(window).height());
			$(".page_right_style").height($(window).height());
			$(".page_right_style").width($(window).width() - 220);
			//当文档窗口发生改变时 触发  
			$(window).resize(function() {
				$(".widget-box").height($(window).height());
				$(".page_right_style").height($(window).height());
				$(".page_right_style").width($(window).width() - 220);
			});
		});
		// $(function(){
		// 	var ue = UE.getEditor('editor');
		// });
		/******树状图********/
		var setting = {
			view : {
				dblClickExpand : false,
				showLine : false,
				selectedMulti : false
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pId",
					rootPId : ""
				}
			},
			callback : {
				beforeClick : function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("tree");
					if (treeNode.isParent) {
						zTree.expandNode(treeNode);
						return false;
					} else {
						productData.typeId = treeNode.id;
						return true;
					}
				}
			}
		};

		var zNodes = $
		{
			array
		};

		var code;

		function showCode(str) {
			if (!code)
				code = $("#code");
			code.empty();
			code.append("<li>" + str + "</li>");
		}
		$(document).ready(function() {
			var t = $("#treeDemo");
			t = $.fn.zTree.init(t, setting, zNodes);
			demoIframe = $("#testIframe");
			//demoIframe.bind("load", loadReady);
			var zTree = $.fn.zTree.getZTreeObj("tree");
			//zTree.selectNode(zTree.getNodeByParam("id",'11'));
		});
	</script>
	<script type="text/javascript">
	function addVoucher() {
	$.post(
			//提交的路径	
			"${pageContext.request.contextPath}/redpack/addVoucher.do",
			//提交的参数
			$("#form-article-add").serialize(),
			//返回的结果函数
			function(data) {
				//如果返回的结果不为空
				
				if (data.result == "true") {
					layer.msg('添加成功', {
						icon : 5,
						time : 1000
					},function(){
						 location.href = '${pageContext.request.contextPath}/manager/user/queryWanghongCount.do'; 
					});
					 
				} else {
					layer.msg('添加失败', {
						icon : 2,
						time : 1000
					}, function(){
						location.reload();
					})
					 
				}
			}, "json");
	}
	</script>
	<script type="text/javascript">
		//数据提交
		var VoucherData = {};
	</script>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script>   --%>
</body>

 <script type="text/javascript">
    function aaa(obj){
        document.getElementById('date').value = obj.value;       
    }
    </script>
</html>