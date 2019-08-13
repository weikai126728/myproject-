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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/js/layui/css/layui.css" media="all">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/js/shopping/layer_mobile/css/layer.css" />
		
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/shopping/layer_mobile/layer.js"></script>
		<script src="${pageContext.request.contextPath}/manager/js/layui/layui.js" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/js/jquery.min.js"></script>
<title>超市详情</title>
</head>

<body>
	<div class="member_show">
		<div class="member_jbxx clearfix">
			<dl class="right_xxln">
				<%-- <dt>
					<span class="">超市名称&nbsp;:&nbsp; </span> 
					<span class="">${market.name }</span>
				</dt> --%>
				<dt>
					<span class="">商户id&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span> 
					<input type="text" readonly="readonly"  value="${product_id}" id="product_id">
				</dt>
				<dt>
					<span class="">技术服务费&nbsp;:&nbsp; </span> 
					<input type="text" value="${sefee }" id="sfee">
				</dt>
			</dl>
			<button onclick="updateSfee()" style="margin-left: 7rem;">提交</button>
		</div>
	</div>
</body>
<script type="text/javascript">
function updateSfee(){
	var product_id=$("#product_id").val();
	var sfee=$("#sfee").val();
	$.post('${pageContext.request.contextPath}/manager/alliance/updateSfee.do',{product_id:product_id,sfee:sfee},function(data){
		if(data.result==true||data.result=='true'){
				layer.open({
				   content: '修改成功'
				   ,skin: 'msg'
				   ,time: 1 //2秒后自动关闭
				   ,success:function(){
					 document.location.href='${pageContext.request.contextPath}/manager/alliance/index.do';
				   }
				});
			}else{
				layer.open({
  				   content: '修改失败'
  				   ,skin: 'msg'
  				   ,time: 1 //2秒后自动关闭
  				});
			}
	},'json');
	
}

</script>
</html>