<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/swiper-3.4.2.min.css" />
<script src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common/swiper-3.4.2.min.js"></script>
<title>移动端首页轮播图</title>
<style type="text/css">
.banner{
	width:450px;
	height:225px;
}
.item{
	margin-top:10px;
	border:1px red solid;
	display:inline-block;
	padding:6px;
}

.file{
	display:none;
}
.clearfix:after,.clearfix:before{content: "";display: table;}
.clearfix:after{clear: both;}
.clearfix{*zoom:1;}
</style>
</head>
<body class="clearfix">
<form action="${pageContext.request.contextPath}/manager/banner/save1.do" style="text-align:center;" enctype="multipart/form-data" method="post">
	<div class="container">
	<div class="item">
		<img onClick="file1.click();" class="banner" src="${pageContext.request.contextPath}/image/shopping/wap/home-banner/home0.jpg" />
		<input id="file1" type="file" class="file" name="file"/>
		<div class="two-line"><label>链接地址：</label><input type="text" placeholder="填写对应路径" name="path"/></div>	
	</div>
	</div>
	<div style="margin-top:10px;">
		<input type="submit"/>
	</div>
</form>
</body>
<script type="text/javascript">
 $('.file').change(function(e){
	var r = new FileReader();
	r.readAsDataURL(e.target.files[0]);
	var that = $(this).prev();
	r.onload = function(e) {
		$(that).attr("src",this.result);
	}
});
function addImage(){
	var index = $('.item').length;
	var str = '<div class="item">'
		+'<img onClick="file'+index+'.click();" class="banner" src="${pageContext.request.contextPath}/image/shopping/wap/home-banner/home0.jpg" />'
			+'<input id="file'+index+'" type="file" class="file"/>'
			+'<div class="two-line"><label>链接地址：</label><input type="text" name="path" placeholder="填写对应路径"/></div>'	
		+'</div>';
	$('.container').append(str);
} 
</script>
</html>