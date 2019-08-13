<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String path =   request.getContextPath();
	String basePath =  request.getScheme()  + "://" + request.getServerName() + ":" +  request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}">
	<!-- <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=2,user-scalable=no"/> -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分享赚佣金</title>
<!-- 当前网站样式！ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/swiper-3.4.2.min.css" />



<!-- 清楚默认样式&公共样式! -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/common/layui/css/layui.css" />
<script
	src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.4.0.js"></script>
<script
	src="${pageContext.request.contextPath}/js/common/swiper-3.4.2.min.js"></script>
<!-- 网站根字体! -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/css.css">

<style type="text/css">


</style>
</head>
<body>
	<div class="upload">
		<div class="upload_union">
			<div class="upload_sp">
				商圈名称：<input type="text" name="" value="${market.name }" onchange="productData.productName=this.value">
			</div>
		</div>
		<div class="upload_in">
			<div class="upload_pt">
				姓名：<input type="text" name="" value="${market.contactUser }" onchange="productData.name=this.value">
			</div>
			<div class="upload_pt">
				电话：<input type="tel" name="" value="${market.phone }" onchange="productData.phone=this.value">
			</div>
			<div class="upload_pt">
				地址：<input type="text" name="" value="${market.addre }" onchange="productData.address=this.value">
			</div>
			<div class="upload_pt">
				openid：<input type="text" name="" value="${market.openid }" onchange="productData.openid=this.value">
			</div>
			<div class="upload_pt">
			<label class="form-label col-2"><span style="color:red">*</span>mp3：</label>
			<div class="formControls  col-2">
				<img alt="" src="" id='large-img' style="width:50px;height:50px;">
				<input type="file"name="mp3file" id="mp3file" onchange="testmp3(this.files)"><br>
			</div>
		</div>
		</div>
		<div class="upload_up">
			<div class="up_load" style="width:70%;margin:0 auto;border:0;">
				<img alt="" src="${pageContext.request.contextPath}/image/showImage.do?image=${market.imgSmall}" id='small-img' style="width:80px;height:80px;">
				<input type="file" id="imgSmall" style="display: none;"> 
				<img id="btn-img-add" src="${pageContext.request.contextPath}/image/shopping/icon/upload.png" 
				onclick="imgSmall.click()" alt="" style="width: 20%;margin:0;">
			</div>
		</div>
		<div class="upload_up">
			<div class="up_load" style="width:70%;margin:0 auto;border:0;">
				<img alt="" src="${pageContext.request.contextPath}/image/showImage.do?image=${market.imgLarge}" id='small-img1' style="width:80px;height:80px;">
				<input type="file" id="imgSmall1" style="display: none;"> 
				<img id="btn-img-add" src="${pageContext.request.contextPath}/image/shopping/icon/upload.png"
				 onclick="imgSmall1.click()" alt="" style="width: 20%;margin:0;">
			</div>
		</div>
		<div class="details_con_out">
			<form method="" action="">
				<input onClick="product_save_submit()" type="button" name="" value="提交">
			</form>
		</div>
	</div>



	<script src="${pageContext.request.contextPath}/js/common/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="https://3gimg.qq.com/lightmap/components/geolocation/geolocation.min.js"></script>
	<script charset="utf-8" src="https://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script>
	<script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/icheck/jquery.icheck.min.js"></script> 
 <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script> 
<script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/wangEditor-3.0.15/wangEditor.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/pro_add.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/pro_source.js"></script>  
</body>

<script type="text/javascript">
function getSuffix(id){
	var dom=document.getElementById(id).value;//根据id得到值
	var index=dom.lastIndexOf(".")//得到最后一个"."在第几位
	return dom.substring(index).toLowerCase(); //截断"."之前的，得到后缀[忽略大写]
}	
var mp3file=null;
function testmp3(obj){
	mp3file = obj;
	var suffix=getSuffix('mp3file');
	if(suffix!=".mp3"){  //根据后缀，判断是否符合图片格式
		layer.msg("不是指定音频格式,重新选择"); 
   }
}
var productData={};
function product_save_submit(){
	if(productData.name&&productData.name.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写姓名！');
		return false;
	}
	
	if(productData.phone&&productData.phone.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写手机！');
		return false;
	}
	if(productData.openid&&productData.openid.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请填写联盟openid！');
		return false;
	}
	if(productData.productName&&productData.productName.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写联盟名称！');
		return false;
	}
	if(productData.address&&productData.address.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写位置！');
		return false;
	}
	var formData = new FormData();
	formData.append('id','${market.id}');
	if(productData.imgSmall){
		formData.append('imgSmall',productData.imgSmall);		
	}
	if(productData.imgSmall1){
		formData.append('imgSmall1',productData.imgSmall1);		
	}
	if(productData.address){
		formData.append('addre',productData.address);
	}
	if(productData.openid){
		formData.append('openid',productData.openid);
	}
	if(productData.productName){
		formData.append('name',productData.productName);		
	}
	if(productData.name){
		formData.append('contactUser',productData.name);	
	}
	if(productData.phone){
		formData.append('phone',productData.phone);		
	}
	if(mp3file!=null){
		formData.append('mp3file',mp3file[0]);
	}
	var httpRequest = new XMLHttpRequest();  
    httpRequest.onreadystatechange = function(){  
        if(httpRequest.readyState == 4 && httpRequest.status == 200){  
            var data = JSON.parse(httpRequest.responseText);
            if(data.code==0){
            	if(data.result==true){
            		layer.msg("修改成功");
            		setTimeout(function(){
            			document.location.reload();
            		},1500);    
            	}
            }
        }  
    };  
httpRequest.open("post",'${pageContext.request.contextPath}/manager/benefit/edit.do',true);  
httpRequest.send(formData); 
}
</script>

 
<script type="text/javascript">

</script>

</html>