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
		<div class="page_right_style">
			<div class="type_title">添加新闻</div>
			<form action="${pageContext.request.contextPath}/company/news/add.do"
				method="post" class="form form-horizontal"
				enctype="multipart/form-data" id="form-article-add">
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>新闻标题：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value=""
							name="title" id="productName"
							onchange="productData.productName=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>新闻摘要：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value=""
							name="abs" id="productName"
							onchange="productData.productName=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>推荐度：</label>
					<div class="formControls col-10">
						<input maxlength="50" type="text" class="input-text" value=""
							name="degree" id="productName" placeholder="整数数字/数值大的优先显示"
							onchange="productData.productName=this.value">
					</div>
				</div>
				<div class="clearfix cl">
					<div class="Add_p_s">
						<label class="form-label col-2"><span style="color: red">*</span>新闻分类：</label>
						<div class="formControls col-2">
							<select id="pro-source" name="type"
								onchange="productData.productSource=this.value">
								<option value="1">新闻要闻</option>
								<option value="2">行业动态</option>
							</select>
						</div>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>首页展示图片：</label>
					<div class="formControls col-2">
						<img alt="" src="" id='large-img'
							style="width: 50px; height: 50px;"/> <input type="file"
							style="display: none;" id="imgLarge" name="smallImg" /> <span
							id="btn-img-add0"  onclick="imgLarge.click()"
							class="btn btn-success">添加图片</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>新闻图片：</label>
					<div class="formControls col-2">
						<img alt="" src="" id='small-img'
							style="width: 50px; height: 50px;"/> <input type="file"
							style="display: none;" id="imgSmall" name="file" /> <span
							id="btn-img-add0"  onclick="imgSmall.click()"
							class="btn btn-success">添加图片</span>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span style="color: red">*</span>新闻内容：</label>
					<input type="text" name="details" id="content" hidden="hidden">
					<div class="formControls col-10 ">
						<div id="editor"></div>
					</div>
				</div>
				<div class="clearfix cl">
					<div class="Button_operation">
						<input class="btn btn-primary radius" type="submit"
							onclick="save()" value="保存">
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
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/wangEditor-3.0.15/wangEditor.min.js"></script>

	<script type="text/javascript">
		var E = window.wangEditor
		var editor = new E('#editor')
		// 配置服务器端地址
		editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/image/upload.do';
		// 进行下文提到的其他配置
		// 将图片大小限制为 3M
		editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
		// 限制一次最多上传 5 张图片
		editor.customConfig.uploadImgMaxLength = 1;
		//上传图片时，可自定义filename，即在使用formdata.append(name, file)添加图片文件时，自定义第一个参数。
		editor.customConfig.uploadFileName = 'files';
		//上传图片时刻自定义设置 header
		editor.customConfig.uploadImgHeaders = {
			'Accept' : 'text/x-json'
		}
		// 将 timeout 时间改为 3s
		editor.customConfig.uploadImgTimeout = 3000;

		editor.customConfig.uploadImgHooks = {
			before : function(xhr, editor, files) {
				// 图片上传之前触发
				// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件
				// 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
				// return {
				//     prevent: true,
				//     msg: '放弃上传'
				// }
			},
			success : function(xhr, editor, result) {
				// 图片上传并返回结果，图片插入成功之后触发
				// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
				 
			},
			fail : function(xhr, editor, result) {
				// 图片上传并返回结果，但图片插入错误时触发
				// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
				 
			},
			error : function(xhr, editor) {
				// 图片上传出错时触发
				// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
			},
			timeout : function(xhr, editor) {
				// 图片上传超时时触发
				// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
			},
			// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
			// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
			customInsert : function(insertImg, result, editor) {
				// 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
				// insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

				// 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
				var url = '${pageContext.request.contextPath}/image/showImage.do?image='+result.data[0];
				insertImg(url)
				// result 必须是一个 JSON 格式字符串！！！否则报错
			}
		}
		editor.create()
	</script>
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
		function save() {
			$("#content").val(editor.txt.html());
			return true;
		}
	</script>
</body>
</html>