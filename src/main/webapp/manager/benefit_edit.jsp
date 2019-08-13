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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=2,user-scalable=no"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分享赚佣金</title>
<!-- 当前网站样式！ -->
<%--  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/swiper-3.4.2.min.css" />  --%>



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

.btn_z{
	width:22%;
	float:left;
	position: relative;
}
.btn-del{
	background: url(../images/del4.png) no-repeat center;
	position: absolute;
	width: 14px;
	height: 22px;
	z-index: 100;
	opacity:1;
	background-size: 15px;
	right: 1px;
	top: -3px;
	transition: opacity 0.5s ease-in-out;
	cursor: pointer;
	
}
</style>
</head>
<body>
	<div class="upload">
		<div class="upload_union">
			<div class="upload_sp">
				联盟编号：<input type="text" name="" value="${info.hopenid }" onchange="productData.hopenid=this.value">
			</div>
			<div class="upload_sp">
				活动价值描述：<input type="text" name="" value="${info.html }" onchange="productData.activityValue=this.value">
			</div>
		</div>
		<div class="upload_in">
			<c:set value="${fn:split(info.productDetails,';')}" var="discount" ></c:set>
			<div class="upload_pt">
				优惠一：<input type="text" name="" value="${discount[0] }" onchange="productData.discount1=this.value">
			</div>
			<div class="upload_pt">
				优惠二：<input type="text" name="" value="${discount[1] }" onchange="productData.discount2=this.value">
			</div>
			<div class="upload_pt">
				优惠三：<input type="text" name="" value="${discount[2] }" onchange="productData.discount3=this.value">
			</div>
			<div class="upload_pt">
				优惠四：<input type="text" name="" value="${discount[3] }" onchange="productData.discount4=this.value">
			</div>
		</div>
		<div class="upload_pt">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>活动结束时间：</label>
			<div class="formControls col-2"><input type="date" step="01" name="user_date" id="user_date" value="${info.countdown.substring(0,10)}"   onchange="productData.user_date=this.value"></div>
            </div>
		</div>
		<div class="upload_up">
			<div class="up_load up_dy  btn-container" id="btn-container">
			<c:forEach var="image" items="${info.imgname.split(';')}" varStatus="status">
					<div index="${status.index}" path="${image}" class="btn_z"><em onclick="deleteElement(this)" class="btn-del"></em><img src="${pageContext.request.contextPath}/image/showImage.do?image=${image}" style="width: 100%"></div>
				</c:forEach>
			</div>
			<div class="up_load" style="width:70%;margin:0 auto;border:0;">
				<input type="file" id="file" class="btn-files" style="display:none;" multiple="multiple"> 
				<img id="btn-img-add" src="${pageContext.request.contextPath}/image/shopping/icon/upload.png" onclick="file.click()" alt="" style="width: 100%;margin:0;">
			</div>
		</div>
		<div class="details_con_out">
			<form method="" action="">
				<input onClick="product_save_submit()" type="button" name="" value="提交">
			</form>
		</div>
	</div>



	 <script
		src="${pageContext.request.contextPath}/js/common/layui/layui.js"
		charset="utf-8"></script> 
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
var productData={};
function product_save_submit(){
	if(productData.hopenid&&productData.hopenid.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请填写所属联盟！');
		return false;
	}
	if(productData.user_date&&productData.user_date.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请填写活动倒计时！');
		return false;
	}
	if(productData.activityValue&&productData.activityValue.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请填写活动价值！');
		return false;
	}
	if($('#btn-container').find('div[index]').length==0&&productData.fileData.length==0){
		layer.msg("请添加商品详情！");
		return false;
	}
	var discount="";
	if(productData.discount1){
		discount+=productData.discount1;
	}
	if(productData.discount2){
		discount+=";"
		discount+=productData.discount2;
	}
	if(productData.discount3){
		discount+=";"
		discount+=productData.discount3;
	}
	if(productData.discount4){
		discount+=";"
		discount+=productData.discount4;
	}
	var formData = new FormData();
	st = '';
	productData.oldInfo = '';
	$('#btn-container div[index]').each(function(){
		productData.oldInfo+= st;
		st = ';';
		productData.oldInfo+=$(this).attr('path');
	});
	if(discount!=''){
		formData.append('productDetails',discount);
	}
	if(productData.user_date){
		formData.append('user_date',productData.user_date);
	}
	if(productData.hopenid){
		formData.append('hopenid',productData.hopenid);
	}
	if(productData.activityValue){
		formData.append('activityValue',productData.activityValue);
	}
	for(var i=0;i<productData.fileData.length;i++){
		formData.append('files',productData.fileData[i]);
	}
	formData.append('id','${info.id}');
	formData.append('orimg',productData.oldInfo);
	var httpRequest = new XMLHttpRequest();  
    httpRequest.onreadystatechange = function(){  
        if(httpRequest.readyState == 4 && httpRequest.status == 200){  
            var data = JSON.parse(httpRequest.responseText);
            if(data.code==0){
            	if(data.result==true){
            		layer.msg("创建成功！待审核");
            		setTimeout(function(){
            			document.location.reload();
            		},1000);            		
            	}
            }
        }  
    };  
    httpRequest.open("post",'${pageContext.request.contextPath}/manager/benefit/editBenefit.do',true);  
    httpRequest.send(formData); 
}
</script>
 
<script type="text/javascript">
	function deleteElement(Obj){
	    Obj.parentNode.parentNode.removeChild(Obj.parentNode);
	}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script>
</html>