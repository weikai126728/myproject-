<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css"/>       
        <link href="${pageContext.request.contextPath}/manager/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/font/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
<title>新增临时素材</title>
<style type="text/css">
	form{
		width:400px;
		margin-left:200px;
	}
	form div{
		margin:10px 0px;
/* 		display:inline-block; */
	}
	form img{
		width:200px;
		height:200px;
	}
	form input[type="text"]{
		width:350px;
	}
</style>
</head>

<body>
<div class="margin clearfix">
<form action="" method="post" id="form" enctype="multipart/form-data">
<div>
	<input type="text" name="title" placeholder="标题" style="margin-left:0px;" onchange="data.title=this.value">
</div>
<div>
	<input type="hidden" name="type" value="image"/>
</div>
<div>
	<img alt="请选择图片" src="" id="image" onclick="img.click()">
	<input type="file" name="file" id="img" style="display:none;margin-left:0px;" accept="image/bmp,image/png,image/jpeg,image/jpg,image/gif">
</div>
<div>
	<input type="text" name="digest" placeholder="摘要" style="margin-left:0px;" onchange="data.digest=this.value">
</div>
<div>
	<input type="text" name="content" maxlength="100" placeholder="具体内容" style="margin-left:0px;" onchange="data.content=this.content">
</div>
<div>
	<span>是否显示封面:</span>
	<input type="radio" name="show_cover_pic" value="1" checked id="yes"><label for="yes">是</label>
	<input type="radio" name="show_cover_pic" value="0" id="no"><label for="no">否</label>
</div>
<div>
	<input type="text" placeholder="图文消息的原文地址" name="content_source_url" style="margin-left:0px;" onchange="data.content_source_url=this.value">
</div>
<button onclick="save()">提交</button>
</form>
</div>
</body>

<script type="text/javascript">
$('#img').on('change',function(e){
	var r = new FileReader();
	var max = 1048576;
	var size = e.target.files[0].size;
	if(size>max){
		alert("图片最大限制2M");
		return false;	
	}
	data.file = e.target.files[0];
	r.readAsDataURL(e.target.files[0]);
	r.onload = function(e) {
		document.getElementById('image').src = this.result;
	}
});
 var data = {};
	function save(){
		var url = '${pageContext.request.contextPath}/manager/material/add.do';
		data.show_cover_pic = $("input:checked").val();
		console.log(data);
	}
</script>
</html>