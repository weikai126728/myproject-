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
<title>修改红包概率金额判定点</title>
</head>
<body>
	<input type="hidden" id="root"
		value="${pageContext.request.contextPath}" />
	<div class="clearfix" id="add_picture">
		
		<div class="page_right_style">
			<div class="type_title">修改红包概率金额判定点</div>
			<form
				action="${pageContext.request.contextPath}/redpack/updatePromoney.do"
				method="post" class="form form-horizontal"
				enctype="multipart/form-data" id="form-article-add">
				<%-- <div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>邮政编号：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" readonly="readonly" class="input-text" value="${probability_fz.zipcode }"
							name="zipcode" id="zipcode"
							onchange="probability_fzData.zipcode=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>地区：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text"  readonly="readonly" class="input-text" value="${probability_fz.merername }"
							name="merername" id="merername"
							onchange="probability_fzData.merername=this.value">
					</div>
				</div> --%>
				<%-- <div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red"></span></label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value="${probability_fz.lowMoney }"
							name="lowMoney" id="lowMoney"
							onchange="probability_fzData.lowMoney=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>金额判定点中金额：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value="${probability_fz.middleMoney }"
							name="middleMoney" id="middleMoney"
							onchange="probability_fzData.middleMoney=this.value">
					</div>
				</div>--%>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red"></span></label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value="${probability_fz.seniorMoney }"
							name="seniorMoney" id="seniorMoney"
							onchange="bijiao()">
							<input type="hidden" id="maxmidd" value="${probability_fz.middleMoney }">
					</div>
				</div> 
				<%-- <div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>轮空概率：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value="${probability_fz.probability_4 }"
							name="probability_4" id="probability_4"
							onchange="probability_fzData.probability_4=this.value">
					</div>
				</div> --%>
				<div class="clearfix cl">
					<div class="Button_operation">
						<input class="btn btn-primary radius" type="submit" value="保存">
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


		function showCode(str) {
			if (!code)
				code = $("#code");
			code.empty();
			code.append("<li>" + str + "</li>");
		}
		$(document).ready(function() {
			var t = $("#treeDemo");
			demoIframe = $("#testIframe");
			//demoIframe.bind("load", loadReady);
			//zTree.selectNode(zTree.getNodeByParam("id",'11'));
		});
	</script>
	<script type="text/javascript">
		//数据提交
		var probability_fzData = {};
	</script>
	<script type="text/javascript">
		function bijiao(){
				if(parseInt($("#seniorMoney").val())<parseInt($("#maxmidd").val())){
					layer.msg('值需大于${probability_fz.middleMoney }', {
						icon : 5,
						time : 1000
					}, function(){
						location.reload();
					});
				}
			
		}
	
	</script>
</body>
</html>