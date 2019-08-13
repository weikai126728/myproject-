<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>新增房产出租</title>
</head>
<body>
<input type="hidden" id="root" value="${pageContext.request.contextPath}"/>
<div class="clearfix" id="add_picture">
   <div class="page_right_style" style="left:0px;">
   <div class="type_title">房产出租</div>
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">出租类型：</label>
			<div class="formControls col-2">
				<select  id = "mclass">
					<option  value = "0" >整套出租</option>
					<option  value = "1" >房屋合租</option>
					<option  value = "2" >办公写字楼</option>
					<option  value = "3" >店面商铺</option>
					<option  value = "4" >厂房/仓库/车库</option>
					<option  value = "5" >其他</option>
			</select></div>
            </div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>租金：</label>
			<div class="formControls col-2">
				<div style="display: flex;justify-content: flex-start;"><input type="text" maxlength="200" class="input-text" value="" placeholder="请输入租金（0为面议）" id="rent" onchange="productData.rent=this.value"><span style="width: 6rem;">元/月</span></div>
			</div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>面积：</label>
			<div class="formControls col-2">
				<div style="display: flex;justify-content: flex-start;"><input type="text" maxlength="200" class="input-text" value="" placeholder="请输入租金（0为面议）" id="area" onchange="productData.area=this.value"><span style="width: 6rem;">M<sup>2</sup></span></div>
			</div>
		</div>
		<div class=" clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>户型介绍：</label>
	     <div class="formControls col-10"><input maxlength="100" type="text" class="input-text" value="" placeholder="" id="houseType" onchange="productData.houseType=this.value"></div>
		</div>
		<div >
            <label >配套设施：</label>
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="1" >空调
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="2" >燃气
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="3" >暖气
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="4" >有线电视
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="5" >洗衣机
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="6" >宽带
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="7" >热水器
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="8" >床
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="9" >车库
			<input maxlength="50" type="checkbox" class="input-text" name="facility" value="0" >冰箱
		</div>
		<div class="clearfix cl">
            <label class="form-label col-10"><span style="color:red">*</span>所在地址：</label>
			<div class="formControls col-10"><input maxlength="200" type="text" class="input-text" value="" placeholder="" id="address" onchange="productData.address=this.value"></div>
		</div>
		
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>联系电话：</label>
			<div class="formControls col-2"><input maxlength="20" type="text" class="input-text" value="" placeholder=""  onchange="productData.phone=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">联系人：</label>
			<div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="" placeholder=""  onchange="productData.name=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">商户openid：</label>
			<div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="" placeholder=""   onchange="productData.openid=this.value"></div>
            </div>
		</div>
		
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>相关照片：</label>
			<div class="formControls col-10">
				<div id="btn-container1" class="panel panel-default btn-container"></div>
				<input type="file" multiple="multiple" style="display:none;" id="banners" name="banners" class="btn-files1"/>
				<span id="btn-img-add1" onclick="banners.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>位置：</label>
			<div class="formControls col-10 ">
				<div class ='panel'>
				     <input id = 'input' value = '点击地图显示地址/输入地址显示位置' onfocus = 'this.value=""'></input>
				     <div id = 'message'></div>
			    </div>
		    	<div id="map" style="width:800px; height:400px" tabindex="0"></div>
			   
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
	if(!productData.name||productData.name.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写名称！');
		return false;
	}
	var facility = document.getElementsByName("facility");
	  var   check_val = [];
	    for(k in facility){
	        if(facility[k].checked)
	            check_val.push(facility[k].value);
	    }
	    alert(check_val);
	 if(!productData.rent||productData.rent.replace(/^\s+|\s+$/g,'')==''){
			layer.msg('请现填写租金！');
			return false;
	}
	if(!productData.area||productData.area.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写面积！');
		return false;
	}
	if(!productData.phone||productData.phone.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写手机！');
		return false;
	}
 
	if(!productData.houseType||productData.houseType.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写户型！');
		return false;
	}
	if(!productData.addre||productData.addre.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写地址！');
		return false;
	}
	
	if(!productData.openid||productData.openid.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写商户openid！');
		return false;
	}
	if(productData.banners.length==0){
		layer.msg("请添加轮播图！");
		return false;
	}
	
	
	//出租类型
	var mclass=$("#mclass").val();
	var address = $('#input').val();
	if(address==''||address.replace(/^\s+|\s+$/g,'')==''){
		layer.msg("请添加地理位置！");
		return false;
	}
	productData.address = address+productData.addre;
	var formData = new FormData();
	for(var i=0;i<productData.banners.length;i++){
		formData.append('banners',productData.banners[i]);
	}
	formData.append('houseType',productData.houseType);
	formData.append('area',productData.area);
	formData.append('facility',check_val);
	formData.append('rent',productData.rent);
	formData.append('openid',productData.openid);
	formData.append('mclass',mclass);
	formData.append('address',productData.address);
	formData.append('name',productData.name);
	formData.append('phone',productData.phone);
	formData.append('lat',productData.lat);
	formData.append('lng',productData.lng);
	var httpRequest = new XMLHttpRequest();  
    httpRequest.onreadystatechange = function(){  
        if(httpRequest.readyState == 4 && httpRequest.status == 200){  
            var data = JSON.parse(httpRequest.responseText);
            if(data.code==0){
            	
            	if(data.result==true){
            		layer.msg("新增成功！");
            		setTimeout(function(){
            			document.location.reload();
            		},1500);            		
            	}
            }
        }  
    };  
    httpRequest.open("post",'${pageContext.request.contextPath}/manager/house/upload.do',true);  
    //httpRequest.setRequestHeader("Content-type","multipart/form-data");  
    httpRequest.send(formData); 
}
var E = window.wangEditor
var editor = new E('#editor')
// 或者 var editor = new E( document.getElementById('editor') )
editor.create();
var map = new AMap.Map('map',{
   zoom: 10,
   center: [116.39,39.9]
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
        })
    }
})
</script>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script>
</html>