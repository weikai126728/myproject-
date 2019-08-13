<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/common/layui/css/layui.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.js"></script>
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
<script src="assets/js/jquery.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='assets/js/jquery-2.0.3.min.js'>"
					+ "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
				+ "<" + "/script>");
</script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
<!-- page specific plugin scripts -->
<script
	src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js"
	type="text/javascript"></script>
<title>用户查看</title>
</head>

<body>



	<div class="add_menber" id="update_menber_style">
		<%-- <form id="upFormId"
			action="${pageContext.request.contextPath}/manager/user/updateUser.do"
			method="post"> --%>
		<ul class=" page-content" style="height: 175px;">
			<li><label class="label_name">真实姓名：</label><span
				class="add_name"><input name="name" type="text" id="name"
					value="${user.nickName }" class="text_add" /></span>
				<div class="prompt r_f"></div>
			<li><label class="label_name">手机号码：</label><span
				class="add_name"><input name="phone" type="text" id="phone" maxlength="11"
					value="${user.phone }" class="text_add" /></span>
				<div class="prompt r_f"></div></li>
			<c:choose>
				<c:when test="${user.gender==2 }">
					<li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span
						class="add_name"> <label><input name="gender"
								value="1" type="radio" class="ace"><span class="lbl">男</span></label>&nbsp;&nbsp;&nbsp;
							<label><input name="gender" type="radio" value="2"
								checked="checked" class="ace"><span class="lbl">女</span></label>

					</span>
						<div class="prompt r_f"></div></li>
				</c:when>
				<c:otherwise>
					<li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span
						class="add_name"> <label><input name="gender"
								value="1" type="radio" checked="checked" class="ace"><span
								class="lbl">男</span></label>&nbsp;&nbsp;&nbsp; <label><input
								value="2" name="gender" type="radio" class="ace"><span
								class="lbl">女</span></label>
					</span>
						<div class="prompt r_f"></div></li>
				</c:otherwise>
			</c:choose>

			<c:if test="${user.status==1 }">
				<li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span
					class="add_name"> <label><input name="status"
							value="1" type="radio" checked="checked" class="ace"><span
							class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp; <label><input
							value="0" name="status" type="radio" class="ace"><span
							class="lbl">关闭</span></label></span>
					<div class="prompt r_f"></div></li>
			</c:if>
			<c:if test="${user.status==0 }">
				<li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span
					class="add_name"> <label><input name="status"
							value="1" type="radio" class="ace"><span class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
						<label><input name="status" type="radio" value="0"
							checked="checked" class="ace"><span class="lbl">关闭</span></label></span>
					<div class="prompt r_f"></div></li>
			</c:if>
			<li hidden="hidden"><label class="label_name">ID：</label><span
				class="add_name"> <input type="text" value="${user.id }"
					id="idID" name="id" class="text_add"></span>
				<div class="prompt r_f"></div></li>
		</ul>

		<input type="button" value="修改" onclick="sub()"
			style="height: 36px; line-height: 36px; margin: 0 auto; display: block; padding: 0 15px; border: 1px solid #dedede; background-color: #f1f1f1; color: #333; border-radius: 2px; font-weight: 400; cursor: pointer; text-decoration: none; border-color: #4898d5; background-color: #2e8ded; color: #fff;" />
		<!-- </form> -->
	</div>
	<script type="text/javascript">
		function sub() {
			//发送ajax
			$.post(
			//提交的路径	
			"${pageContext.request.contextPath}/manager/user/updateUser.do",
			//提交的参数
			{
				name : $("#name").val(),
				id : $("#idID").val(),
				phone : $("#phone").val(),
				gender : $("input[name='gender']:checked").val(),
				status : $("input[name='status']:checked").val()
			},
			//返回的结果函数
			function(result) {
				//如果返回的结果不为空
				if (result != 0) {
					//拼接city的option对象
					layer_close();
				}
			}, "json");

		}
	</script>
</body>

</html>