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
<title>编辑便民</title>
</head>
<body>
<input type="hidden" id="root" value="${pageContext.request.contextPath}"/>
<div class="clearfix" id="add_picture">
   <div class="page_right_style" style="left:0px;">
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>便民标题：</label>
		 <div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="${market.productName}" placeholder="" id="productName" onchange="productData.productName=this.value"></div>
		</div>
	
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>手机：</label>
			<div class="formControls col-2"><input maxlength="20" type="text" class="input-text" value="${market.phone}" placeholder=""  onchange="productData.phone=this.value"></div>
            </div>
		</div>
	
			<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>更多图片：</label>
			<div class="formControls col-10">
				<div id="btn-container1" class="panel panel-default btn-container">
				<c:forEach var="banner" items="${market.imgname.split(';')}" varStatus="status">
				<div index="${status.index}" path="${banner}"><em class="btn-del"></em><img src="${pageContext.request.contextPath}/image/showImage.do?image=${banner}"></div>
				</c:forEach>
				</div>
				<input type="file" multiple="multiple" style="display:none;" id="banners" name="banners" class="btn-files1"/>
				<span id="btn-img-add1" onclick="banners.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
	
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
	
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}		
//数据提交
var productData={};
function product_save_submit(){
	
	
	var oribanner = '';
	var g='';
	$('#btn-container1 div[path]').each(function(){
		oribanner += g;
		g=';';
		oribanner += $(this).attr("path");
		
	});
	var formData = new FormData();
	for(var i=0;productData.banners&&i<productData.banners.length;i++){
		formData.append('banners',productData.banners[i]);
	}
	formData.append('oribanner',oribanner);
	formData.append('id','${market.id}');

	if(productData.productName){
		formData.append('productName',productData.productName);		
	}
	if(productData.phone){
		formData.append('phone',productData.phone);		
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
    httpRequest.open("post",'${pageContext.request.contextPath}/manager/market/editSecond.do',true);  
    httpRequest.send(formData); 
}

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