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
<title>新增商品</title>
</head>
<body>
	<input type="hidden" id="root"
		value="${pageContext.request.contextPath}" />
	<div class="clearfix" id="add_picture">
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
						<h4 class="lighter smaller">选择产品类型</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main padding-8">
							<div id="treeDemo" class="ztree"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="page_right_style">
			<div class="type_title">添加商品</div>
			<form
				action="${pageContext.request.contextPath}/distribution/product/upload.do"
				method="post" class="form form-horizontal"
				enctype="multipart/form-data" id="form-article-add">
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>商品标题：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value=""
							name="productName" id="productName"
							onchange="productData.productName=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>商品内容：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value=""
							name="content" id="content"
							onchange="productData.content=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					 
						<label class="form-label col-2"><span style="color: red">*</span>上级分类：</label>
						<div class="formControls col-2">
							<select id="pro-source" name="productCate" value="0"
								onchange="productData.productSource=this.value">
								 
							</select>
						</div>
						<div class="formControls col-2">
							<select id="pro-source" name="productCate" value="0"
								onchange="productData.productSource=this.value">
								 
							</select>
						</div>
						<div class="formControls col-2">
							<select id="pro-source" name="productCate" value="0"
								onchange="productData.productSource=this.value">
								 
							</select>
						</div>
					 
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>面额：</label>
					<div class="input-group" style="width: 140px">
						<input type="number" class="form-control" value=""
							placeholder="面额" name="bills" step="0.01"> <span
							class="input-group-addon">元</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>售价：</label>
					<div class="input-group" style="width: 140px">
						<input type="number" class="form-control" value=""
							placeholder="售价" id="" name="money" step="0.01"> <span
							class="input-group-addon">元</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>一级佣金：</label>
					<div class="input-group" style="width: 140px">
						<input type="number" class="form-control" value=""
							placeholder="一级佣金" id="" name="rateA" step="0.01"> <span
							class="input-group-addon">元</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>二级佣金：</label>
					<div class="input-group" style="width: 140px">
						<input type="number" class="form-control" value=""
							placeholder="二级佣金" id="" name="rateB" step="0.01"> <span
							class="input-group-addon">元</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>三级佣金：</label>
					<div class="input-group" style="width: 140px">
						<input type="number" class="form-control" value=""
							placeholder="三级佣金" id="" name="rateC" step="0.01"> <span
							class="input-group-addon">元</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>库存：</label>
					<div class="input-group" style="width: 140px">
						<input type="number" class="form-control" value=""
							placeholder="库存" id="" name="inventory">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>商品图片：</label>
					<div class="formControls col-2">
						<img alt="" src="" id='small-img'
							style="width: 50px; height: 50px;"> <input type="file"
							style="display: none;" id="imgSmall" name="file" /> <span
							id="btn-img-add0" onclick="imgSmall.click()"
							class="btn btn-success">添加图片</span>
					</div>
				</div>

				<div class="clearfix cl">
					<div class="Button_operation">
						<input class="btn btn-primary radius" type="submit" value="保存">
						<!-- <span onClick="product_save_submit();" class="btn btn-primary radius"><i class="icon-save"></i>保存</span> -->
						<!-- <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button> -->

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
		//数据提交
		var productData = {};
	</script>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script>   --%>
</body>
</html>