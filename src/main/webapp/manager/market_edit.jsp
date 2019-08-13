<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/PIE_IE678.js"></script>
<![endif]-->
<link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css"/>       
<link href="${pageContext.request.contextPath}/manager/assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link href="${pageContext.request.contextPath}/manager/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/manager/Widget/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/manager/css/upload.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/manager/css/pro_add.css" rel="stylesheet" type="text/css" charset="utf-8"/>
<title>编辑超市</title>
</head>
<body>
<input type="hidden" id="root" value="${pageContext.request.contextPath}"/>
<div class="clearfix" id="add_picture">
   <div class="page_right_style" style="left:0px;">
   <div class="type_title">编辑超市</div>
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>超市名称：</label>
		 <div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="${market.name}" placeholder="" id="productName" onchange="productData.name=this.value"></div>
		</div>

		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>主营产品：</label>
		 <div class="formControls col-2"><input maxlength="15" type="text" class="input-text" value="${market.products}" placeholder="" id="products" onchange="productData.products=this.value"></div>
		</div>
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>营业时间：</label>
		 <div class="formControls col-2"><input maxlength="30" type="text" class="input-text" value="${market.productTime}" placeholder="" id="productTime" onchange="productData.productTime=this.value"></div>
		</div>
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>配送相关：</label>
		 <div class="formControls col-2"><input maxlength="30" type="text" class="input-text" value="${market.distribution}" placeholder="" id="distribution" onchange="productData.distribution=this.value"></div>
		</div>
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>店铺简介：</label>
		 <div class="formControls col-2"><input maxlength="200" type="text" class="input-text" value="${market.details}" placeholder="" id="productDetails" onchange="productData.productDetails=this.value"></div>
		</div>
			<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">门店分类：</label>
			<div class="formControls col-2">
			<select id="mclass">
  				<option value ="1" <c:if test="${market.mclass==1}" >selected="selected"</c:if> >普通门店</option>
  				<option value ="2" <c:if test="${market.mclass==2}" >selected="selected"</c:if>>农副产品</option>
			</select>
				</div>
            </div>
		</div>
		
		
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>联系人姓名：</label>
			<div class="formControls col-2">
				<input type="text" maxlength="200" class="input-text" value="${market.contactUser}" placeholder="" id="productKeys" onchange="productData.contactUser=this.value">
			</div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>客服电话：</label>
			<div class="formControls col-2"><input maxlength="20" type="text" class="input-text" value="${market.phone}" placeholder=""  onchange="productData.phone=this.value"></div>
            </div>
		</div>
	
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">商户openid：</label>
			<div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="${market.openid}" placeholder=""  onchange="productData.openid=this.value"></div>
            </div>
		</div>
		
		
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>小图：</label>
			<div class="formControls col-2">
				<img alt="" src="${pageContext.request.contextPath}/image/showImage.do?image=${market.imgSmall}" id='small-img' style="width:50px;height:50px;">
				<input type="file" style="display: none;" id="imgSmall" name="imgSmall"/>
				<span id="btn-img-add0" onclick="imgSmall.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
	
		
			
	
			<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>证照信息：</label>
			<div class="formControls col-10">
				<div id="btn-container" class="panel panel-default btn-container">
				<c:forEach var="infor" items="${market.information.split(';')}" varStatus="statu">
				<div index="${statu.index}" path="${infor}"><em class="btn-del"></em><img src="${pageContext.request.contextPath}/image/showImage.do?image=${infor}"></div>
				</c:forEach>
				</div>
				<input type="file" multiple="multiple" style="display:none;" id="Information" name="Information" class="btn-files"/>
				<span id="btn-img-add" onclick="Information.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>超市详情页：</label>
			<div class="formControls col-10 ">
			<div id="editor">
		        ${market.html}
		    </div>
			</div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>公交路线：</label>
			<div class="formControls col-10"><input maxlength="50" type="text" class="input-text" value="${market.address.busRoute}" placeholder=""  onchange="productData.route=this.value"></div>
            </div>
		</div>
			<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>真实地址：</label>
			<div class="formControls col-10"><input maxlength="50" type="text" class="input-text" value="${market.addre}" placeholder=""  onchange="productData.addre=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>超市位置：</label>
			<div class="formControls col-10 ">
				<div class ='panel'>
				     <input id = 'input' value = '${market.address.detail}' onfocus = 'this.value=""'></input>
				     <div id = 'message'></div>
			    </div>
		    	<div id="map" style="width:800px; height:400px" tabindex="0"></div>
			   
			</div>
		</div>
		<input type="hidden" value="${market.address.longitude}" id="longitude">
		<input type="hidden" value="${market.address.latitude}" id="latitude">
		
		<div class="clearfix cl">
			<div class="Button_operation">
				<span onClick="product_save_submit();" class="btn btn-primary radius"><i class="icon-save"></i>保存</span>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>   
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
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/market_add.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/wangEditor-3.0.15/wangEditor.min.js"></script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.2&key=8b5743b74e8bb209ca3da09cefa7f69b"></script>  
<script>
$( document).ready(function(){
//初始化宽度、高度
  
   $(".widget-box").height($(window).height()); 
   $(".page_right_style").height($(window).height()); 
   $(".page_right_style").width($(window).width()); 
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	 $(".widget-box").height($(window).height()); 
	 $(".page_right_style").height($(window).height()); 
	 $(".page_right_style").width($(window).width()); 
	});	
});
// $(function(){
// 	var ue = UE.getEditor('editor');
// });
/******树状图********/
function getSuffix(id){
	var dom=document.getElementById(id).value;//根据id得到值
	var index=dom.lastIndexOf(".")//得到最后一个"."在第几位
	return dom.substring(index).toLowerCase(); //截断"."之前的，得到后缀[忽略大写]
}	
var files;
function test(obj){
	files=obj;
	var suffix=getSuffix('videofile');
	if(suffix!=".mp4"&&suffix!=".avi"&&suffix!=".3gp"&&suffix!=".rmvb"&&suffix!=".rm"){  //根据后缀，判断是否符合图片格式
		layer.msg("不是指定视频格式,重新选择"); 
        return false;
   }
}		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}		
//数据提交
var productData={};
function product_save_submit(){
	if(productData.name&&productData.name.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写超市名称！');
		return false;
	}
	if(productData.details&&productData.details.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写超市简介！');
		return false;
	}
	
	if(productData.contactUser&&productData.contactUser.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写联系人！');
		return false;
	}
	if(productData.phone&&productData.phone.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写手机！');
		return false;
	}
	
	var text = editor.txt.html();
	if(text==''||text.replace(/^\s+|\s+$/g,'')==''){
		layer.msg("请添加超市详情！");
		return false;
	}
	productData.text = editor.txt.html();
	if(productData.route&&productData.route.replace(/^\s+|\s+$/g,'')==''){
		layer.msg("请添加公交路线！");
		return false;
	}
	var address = $('#input').val();
	
	productData.address = address;
	
	var oriInformation = '';
	var g1='';
	$('#btn-container div[path]').each(function(){
		oriInformation += g1;
		g1=';';
		oriInformation += $(this).attr("path");
	});
	if((productData.fileData&&productData.fileData.length==0)&&oriInformation==''){
		layer.msg("请添加证照信息！");
		return false;
	}
	
	var formData = new FormData();
	for(var i=0;productData.fileData&&i<productData.fileData.length;i++){
		formData.append('information',productData.fileData[i]);
	}
	
	var mclass=$("#mclass").val();
	formData.append('mclass',mclass);
	formData.append('oriInformation',oriInformation);
	formData.append('supermarketId','${market.id}');
	formData.append('supermarketAddressId','${market.address.id}');
	formData.append('text',productData.text);
	formData.append('address',productData.address);
	if(productData.imgSmall){
		formData.append('imgSmall',productData.imgSmall);		
	}
	if(productData.addre){
		formData.append('addre',productData.addre);
	}
	if(productData.distribution){
		formData.append('distribution',productData.distribution);
	}
	if(productData.openid){
		formData.append('openid',productData.openid);
	}
	if(productData.name){
		formData.append('name',productData.name);		
	}
	if(productData.productDetails){
		formData.append('details',productData.productDetails);	
	}
	if(productData.productTime){
		formData.append('productTime',productData.productTime);		
	}
	if(productData.products){
		formData.append('products',productData.products);		
	}
	if(productData.contactUser){
		formData.append('contactUser',productData.contactUser);	
	}
	if(productData.phone){
		formData.append('phone',productData.phone);		
	}
	
	if(productData.recommendation){
		formData.append('recommendation',productData.recommendation);
	}
	if(productData.route){
		formData.append('route',productData.route);		
	}
	if(productData.lat){
		formData.append('lat',productData.lat);		
	}
	if(productData.lng){
		formData.append('lng',productData.lng);		
	}
	var httpRequest = new XMLHttpRequest();  
    httpRequest.onreadystatechange = function(){  
        if(httpRequest.readyState == 4 && httpRequest.status == 200){  
            var data = JSON.parse(httpRequest.responseText);
            if(data.code==0){
            	if(data.result==true){
            		layer.msg("修改成功！");
            		setTimeout(function(){
            			document.location.reload();
            		},1500);            		
            	}
            }
        }  
    };  
    httpRequest.open("post",'${pageContext.request.contextPath}/manager/market/edit.do',true);  
    //httpRequest.setRequestHeader("Content-type","multipart/form-data");  
    httpRequest.send(formData); 
}
var E = window.wangEditor
var editor = new E('#editor')
// 或者 var editor = new E( document.getElementById('editor') )
editor.create();
var lng = $("#longitude").val();
var lat =$("#latitude").val();
if(lng==null||lat==null||lng==''||lat==''){
	var lng = 115.493823;
	var lat = 38.869433;
}
var map = new AMap.Map('map',{
   zoom: 10,
   center: [lng,lat]
});
AMap.service('AMap.Geocoder',function(){//回调函数
    //实例化Geocoder
    geocoder = new AMap.Geocoder({
    });
    var marker = new AMap.Marker({
        map:map,
        bubble:true
    })
    var input = document.getElementById('input');
    var message = document.getElementById('message');
    map.on('click',function(e){
        marker.setPosition(e.lnglat);
        productData.lat = e.lnglat.lat;
        productData.lng = e.lnglat.lng;
        geocoder.getAddress(e.lnglat,function(status,result){
          if(status=='complete'){
             input.value = result.regeocode.formattedAddress
             message.innerHTML = ''
          }else{
             message.innerHTML = '无法获取地址'
          }
        })
    })
    
    input.onchange = function(e){
        var address = input.value;
        geocoder.getLocation(address,function(status,result){
          if(status=='complete'&&result.geocodes.length){
            marker.setPosition(result.geocodes[0].location);
            productData.lat = result.geocodes[0].location.lat;
            productData.lng = result.geocodes[0].location.lng;
            map.setCenter(marker.getPosition())
            message.innerHTML = ''
          }else{
            message.innerHTML = '无法获取位置'
          }
        });
    }
});
(function(){
	$('.btn-container div em').on('click',function(){
		$(this).parents('div:first').remove();
	});
	$('.pro-type li').on('click',function(){
		var typeId = $(this).attr('id');
		var name = $(this).find('a').html();
		var span = $(this).parents('ul').prev().find('span:first');
		span.attr("typeId",typeId);
		productData.typeId = typeId;
		span.html(name);
	});
})()
</script>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script> 
</html>