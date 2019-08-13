<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/swiper-3.4.2.min.css" />
<script src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common/swiper-3.4.2.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>
<title>移动端首页轮播图</title>
<style type="text/css">
.banner{
	width:450px;
	height:225px;
}
.banners{
	width:225px;
	height:112px;
}
.item{
	position:relative;
	margin-top:10px;
	border:1px red solid;
	display:inline-block;
	padding:6px;
}

.file{
	display:none;
}
em{
	position:absolute;
	width:10px;
	height:10px;
	background:url(../images/delete.png) no-repeat center;
	background-size:10px;
	cursor:pointer;
	display:inline-block;
	float:right;
	right:9px;
	top:9px;
}
.add{
	position:relative;
	left:50px;
	top:106px;
}
.clearfix:after,.clearfix:before{content: "";display: table;}
.clearfix:after{clear: both;}
.clearfix{*zoom:1;}
</style>
</head>
<body class="clearfix">
<div class="add">
	<div><button onClick="toSave();">添加轮播图</button></div>
	<div>
	<input type="text" placeholder="商品编号" id="proNumber"/><button onClick="findPro();">搜索,查看ID</button>
	<p id="productName">请输入商品编号，点击搜索</p>
	<p id="productID"></p>
	<p>详情页路径:product/details.do?gid=ID</p>
	</div>
</div>
<div class="banner swiper-container" id="swiper1">
		<div class="swiper-wrapper">
		<c:forEach var="banner" items="${banners}" varStatus="status">
		<img class="swiper-slide" src="${pageContext.request.contextPath}/image/showImage.do?image=${banner.images}" />
		</c:forEach>	
		</div>
		<div class="swiper-pagination"></div>
	</div>
	<c:forEach var="banner" items="${banners}" varStatus="status">
	<div class="item" id="${banner.id}">
		<img onClick="file${status.index}.click();" class="banners" src="${pageContext.request.contextPath}/image/showImage.do?image=${banner.images}" />
		<div class="two-line"><label>链接地址：</label><p>${banner.image_path}</p></div>	
		<em></em>
	</div>
	</c:forEach>
</body>
<script type="text/javascript">
new Swiper('#swiper1', {
	pagination : '.swiper-pagination',
	loop : true,
	autoplay : 4000,
	autoplayDisableOnInteraction : false,
// 		effect : 'fade',
});
$('em').on('click',function(){
	var id = $(this).parents('.item').attr("id");
	$.post('${pageContext.request.contextPath}/manager/banner/delete.do',{id:id},function(data){
		if(data.code==0){
			if(data.result=='true'||data.result==true){
				location.reload();		
			}else{
				layer.open({
				  title: '警告'
				  ,content: '删除失败'
				}); 
			}
		}
	},'json');
});
function toSave(){
	layer.open({
	      type: 2,
	      title: "添加",
	      shadeClose: true,
	      shade: false,
	      maxmin: true, //开启最大化最小化按钮
	      area: ['500px', '400px'],
	      content: '${pageContext.request.contextPath}/manager/banner/toSave.do',
	});
}
//查询商品信息
function findPro(){
	var number = $('#proNumber').val();
	if(number.replace(/^\s+|\s+$/g,'')==''){
		layer.open({
		  title: '警告'
		  ,content: '请输入商品编号'
		}); 
		return false;
	}
	$.post('${pageContext.request.contextPath}/manager/banner/findPro.do',{number:number},function(data){
		if(data.code==0){
			if(data.result.id){
				$("#productName").html(data.result.productName);
				$("#productID").html(data.result.id);
			}else{
				layer.open({
					  title: '警告'
					  ,content: '没有查到信息'
					}); 
			}
		}
	},'json');
} 
</script>
</html>