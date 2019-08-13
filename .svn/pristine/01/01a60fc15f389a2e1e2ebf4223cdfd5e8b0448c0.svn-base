<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.abbot.schimneylife.pojo.shopping.MallProductParameter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
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
<title>编辑商品</title>
</head>
<body>
<input type="hidden" id="root" value="${pageContext.request.contextPath}"/>
<div class="clearfix" id="add_picture">
   <div class="page_right_style" style="left:0px;">
   <div class="type_title" style="padding-left:40px;">编辑商品</div>
	<form action="" method="post" class="form form-horizontal" id="form-article-add" style="padding-left:40px;">
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>商品标题：</label>
		 <div class="formControls col-10"><input maxlength="50" type="text" class="input-text" value="${product.productName}" placeholder="" id="productName" onchange="productData.productName=this.value"></div>
		</div>
		<div class=" clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>简略标题：</label>
	     <div class="formControls col-10"><input maxlength="100" type="text" class="input-text" value="${product.details}" placeholder="" id="productDetails" onchange="productData.productDetails=this.value"></div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>产品类型：</label>
			<div class="dropdown formControls col-2">
			  <button class="btn btn-default btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			    <span  typeId="${type.id}">${type.typeName}</span>
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu pro-type" aria-labelledby="dropdownMenu1">
			  <c:forEach var="ty" items="${typeList}" varStatus="status">
			    <li id="${ty.id}"><a href="javascript:void(0);">${ty.typeName}</a></li>
		   	  </c:forEach>
			  </ul>
			</div>
		</div>
		
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>产品编号：</label>
			<div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="${product.number}" placeholder="" id="productNumber" onchange="productData.productNumber=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>关键词：</label>
			<div class="formControls col-10">
				<input type="text" maxlength="200" class="input-text" value="${product.keywords}" placeholder="" id="productKeys" onchange="productData.productKeys=this.value">
			</div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>所属省份：</label>
			<div class="formControls col-2"><input maxlength="20" type="text" class="input-text" value="${product.province}" placeholder=""  onchange="productData.province=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red">*</span>产地：</label>
			<div class="formControls col-2"><input maxlength="50" type="text" class="input-text" value="${product.productArea}" placeholder=""  onchange="productData.productArea=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">商品来源：</label>
			<div class="formControls col-2">
				<select id="pro-source" name="productSource" value="${product.source}" data="${product.source}" onchange="productData.productSource=this.value">
					<option value="0">自营</option>
					<option value="1">阿里分销</option>
					<option value="2">阿里代购</option>
				</select>
			</div>
            </div>
            <div class="formControls col-2" id="thirdID" style="display:none">
            	<input value="${productID}" type="number" placeholder="第三方商品ID" onchange="productData.thirdID=this.value"/><span class="xy-btn-update"></span><span style="width: 260px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;display: inline-block;"></span>
            </div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">热度：</label>
			<div class="formControls col-2"><input type="number" class="input-text" value="${product.degree}" step="1" placeholder=""  onchange="productData.productDegree=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2">推荐度：</label>
			<div class="formControls col-2"><input type="number" class="input-text" value="${product.recommendation}" placeholder="" step="1" onchange="productData.productRecom=this.value"></div>
            </div>
		</div>
			<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>积分比例：</label>
			 <div class="formControls col-10"><input maxlength="100" type="number" oninput="if(value>99)value=99" class="input-text" value="${product.productIntegral }" placeholder="" id="productIntegral" onchange="productData.productIntegral=this.value">%</div>
            </div>
		</div>
		<div class="clearfix cl">
		<label class="form-label col-2"><span style="color:red">*</span>规格&参数：</label>
		<div class="formControls col-2" style="text-align:center;">
		<% List<MallProductParameter> paramList = (List<MallProductParameter>)request.getAttribute("paramList"); 
			for(int i=0;i<paramList.size();i++){
		%>
		<div class="panel panel-default spec-group" paramId="<%=paramList.get(i).getId()%>" enable="<%=paramList.get(i).getStatus()%>" specId="<%=paramList.get(i).getSpecId()%>">
			<div class="panel-body">
				<i></i><i class="xy-data-status"></i>
				<div class="clearfix cl">
	             <label class="form-label col-2">原价格：</label>	
				 <div class="formControls col-2">
				 <div class="input-group" style="width:140px">
					 <input type="number" class="form-control" value="<%=paramList.get(i).getOriginal() %>" placeholder="原价" name="" step="0.01">
					 <span class="input-group-addon">元</span>
				 </div>
				 </div>
				</div>
	            <div class="clearfix cl">
	             <label class="form-label col-2">现价格：</label>	
	             <div class="formControls col-2">
					 <div class="input-group" style="width:140px">
						 <input type="number" class="form-control" value="<%=paramList.get(i).getCur_price()%>" placeholder="现价" id="" name="" step="0.01">
					 	 <span class="input-group-addon">元</span>
				 	 </div>
				 </div>
				</div>
				 <div class="clearfix cl">
	             <label class="form-label col-2">保质期：</label>	
	             <div class="formControls col-4">
					 <div class="input-group" style="width:140px">
					 	<% Integer num =  0;String qtype = "";String ding="";
					 		if(paramList.get(i).getQualityYear()!=null&&paramList.get(i).getQualityYear()!=0){
					 			num = paramList.get(i).getQualityYear();
					 			qtype = "year";
					 			ding = "年";
					 		}else if(paramList.get(i).getQualityMonth()!=null&&paramList.get(i).getQualityMonth()!=0){
					 			num = paramList.get(i).getQualityMonth();
					 			qtype = "month";
					 			ding = "月";
					 		}else if(paramList.get(i).getQualityDay()!=null&&paramList.get(i).getQualityDay()!=0){
					 			num = paramList.get(i).getQualityDay();
					 			qtype = "day";
					 			ding = "日";
					 		}
					 		JSONArray first = JSONArray.parseArray(paramList.get(i).getFirstParam());
					 		JSONArray second = JSONArray.parseArray(paramList.get(i).getSecondParam());
					 		
					 	%>
						 <input type="number" class="form-control" value="<%=num %>" placeholder="保质期" id="" name="" step="1">
					 	 <div class="input-group-btn">
					        <button class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						        <span qtype="<%=qtype%>"><%=ding %></span>
						        <span class="caret"></span>
					        </button>
					        <ul class="dropdown-menu dropdown-menu-right protime" style="min-width:53px;">
					          <li qtype="year"><a href="javascript:void(0);">年</a></li>
					          <li qtype="month"><a href="javascript:void(0);">月</a></li>
					          <li qtype="day"><a href="javascript:void(0);">日</a></li>
					        </ul>
					      </div>
				 	 </div>
				 </div>
				</div>
				<div class="clearfix cl thirdSpec" style="display:none">
	             <label class="form-label col-2">第三方规格：</label>	
	             <div class="formControls col-2">
					 <div class="input-group" style="width:140px">
						 <select value="0">
						 </select>
				 	 </div>
				 </div>
				</div>
				<div class="clearfix cl">
	             <label class="form-label col-2">首页显示：</label>	
	             <div class="formControls col-2">
					 <div class="input-group" style="width:140px">
						 <input type="text" class="form-control" value="<%=paramList.get(i).getJson() %>" placeholder="首页显示" id="" name="">
				 	 </div>
				 </div>
				</div>
				<div class="clearfix cl">
	             <label class="form-label col-2">库存：</label>	
	             <div class="formControls col-2">
					 <div class="input-group" style="width:140px">
						 <input type="number" class="form-control" value="<%=paramList.get(i).getRepertory() %>" placeholder="库存" id="" name="">
				 	 </div>
				 </div>
				</div>
				<div class="clearfix cl">
					<div class="first-param">
					<%if(first!=null&&first.size()>0){ 
						for(int j=0;j<first.size();j++){
							JSONObject o = first.getJSONObject(j);
							Iterator<String> it = o.keySet().iterator();
							String key = it.next();
					%>
						<div class="clearfix cl">
						<label class="form-label col-2"></label><span><input maxlength="10" type="text" value="<%=key%>"/>&nbsp;=&nbsp;<input maxlength="20" type="text" value="<%=o.getString(key)%>"/><em></em></span>
						</div>
					<%}} %>
					</div>
				</div>
				<div class="">
				<div class="spec-add">
				<%if(second!=null&&second.size()>0){
					for(int j=0;j<second.size();j++){
						JSONObject o = second.getJSONObject(j);
						Iterator<String> jsonKeys = o.keySet().iterator();
	
							String key = jsonKeys.next();
				%>
						<div class="clearfix cl">
							<label class="form-label col-2"></label><span><input maxlength="10" type="text" value="<%=key %>"/>&nbsp;=&nbsp;<input maxlength="20" type="text" value="<%=o.getString(key)%>"/><em></em></span>
						</div>
					
				<%
					}
				}else{
				%>
						<div class="clearfix cl">
							<label class="form-label col-2"></label><span><input maxlength="10" type="text"/>&nbsp;=&nbsp;<input maxlength="20" type="text"/><em></em></span>
						</div>
					<%} %>
					</div>
				</div>
			</div>
		</div>
		<%} %>
		<div class="btn-group group-add"></div>
		</div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>商品图片：</label>
			<div class="formControls col-2">
				<img alt="" src="${pageContext.request.contextPath}/image/showImage.do?image=${product.imgSmall}" id='small-img' style="width:50px;height:50px;">
				<input type="file" style="display: none;" id="imgSmall" name="imgSmall"/>
				<span id="btn-img-add0" onclick="imgSmall.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>轮播图：</label>
			<div class="formControls col-10">
				<div id="btn-container1" class="panel panel-default btn-container">
				<c:forEach var="banner" items="${banners}" varStatus="status">
					<div index="${status.index}" path="${banner.imgName}"><em class="btn-del"></em><img src="${pageContext.request.contextPath}/image/showImage.do?image=${banner.imgName}"></div>
				</c:forEach>
				</div>
				<input type="file" multiple="multiple" style="display:none;" id="banners" name="banners" class="btn-files1"/>
				<span id="btn-img-add1" onclick="banners.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
		
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>商品详情：</label>
			<div class="formControls col-10 ">
			<div id="btn-container" class="panel panel-default btn-container">
				<c:forEach var="image" items="${images}" varStatus="status">
					<div index="${status.index}" path="${image}"><em class="btn-del"></em><img src="${pageContext.request.contextPath}/image/showImage.do?image=${image}"></div>
				</c:forEach>
			</div>
			<input type="file" multiple="multiple" style="display: none;" id="files" name="files" class="btn-files"/>
			<span id="btn-img-add" onclick="files.click()" class="btn btn-success">添加图片</span>
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
</div>
</body>
<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>   
<script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
<script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/icheck/jquery.icheck.min.js"></script> 
 <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script> 
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/webuploader/0.1.5/webuploader.min.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/ueditor/1.4.3/ueditor.config.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/ueditor/1.4.3/ueditor.all.min.js"> </script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>  --%>
<script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/pro_add.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/pro_source.js"></script>  
<script>

$(function() { 
	$("#add_picture").fix({
		'float' : 'left',
		skin : 'green',	
		durationTime :false,
		stylewidth:'220',
		spacingw:0,
		spacingh:260,
	});
});
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

</script>
<script type="text/javascript">
//数据提交
var productData={infoId:'${infoId}',proId:'${product.id}',thirdID:'${productID}',productSource:'${product.source}'};
function product_save_submit(){
	if(productData.productName&&productData.productName.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写商品标题！');
		return false;
	}
	if(productData.productDetails&&productData.productDetails.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写简略标题！');
		return false;
	}
	if(productData.productNumber&&productData.productNumber.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写产品编号！');
		return false;
	}
	if(productData.productKeys&&productData.productKeys.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写关键词！');
		return false;
	}
	if(productData.province&&productData.province.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写所属省份！');
		return false;
	}
	if(productData.productArea&&productData.productArea.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写产地！');
		return false;
	}
	 if(!productData.productIntegral||productData.productIntegral.replace(/^\s+|\s+$/g,'')==''){
			layer.msg('请现填写积分比例！');
			return false;
		}
	var group = $('.spec-group');
	if(group.length==0){
		return false;
	}
	var inputs = group.eq(0).find('input');
	if(!inputs.eq(0).val()||!inputs.eq(1).val()
			||!inputs.eq(2).val()
			||!inputs.eq(3).val()||inputs.eq(3).val().replace(/^\s+|\s+$/g,'')==''
			||!inputs.eq(4).val()||inputs.eq(4).val().replace(/^\s+|\s+$/g,'')==''
			||!inputs.eq(5).val()||inputs.eq(5).val().replace(/^\s+|\s+$/g,'')==''
			||!inputs.eq(6).val()||inputs.eq(6).val().replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请先填写规格&参数！');
		return false;
	}
	productData.spec = [];
	group.each(function(){
		var input = $(this).find('input');
		if(!input.eq(0).val()||!input.eq(1).val()
				||!input.eq(2).val()
				||!input.eq(3).val()||input.eq(3).val().replace(/^\s+|\s+$/g,'')==''
				||!input.eq(4).val()||input.eq(4).val().replace(/^\s+|\s+$/g,'')==''
				||!input.eq(5).val()||input.eq(5).val().replace(/^\s+|\s+$/g,'')==''
				||!input.eq(6).val()||input.eq(6).val().replace(/^\s+|\s+$/g,'')==''){
			
		}else{
			var paramId = $(this).attr('paramId')!=null?$(this).attr('paramId'):'-1';
			var s = {
					id:paramId,
					original:input.eq(0).val(),
					current:input.eq(1).val(),
					qualityType:input.eq(2).next().find('button span:first').attr('qtype'),
					quality:input.eq(2).val(),
					json:input.eq(3).val(),
					repertory:input.eq(4).val()
				};
				var specId = $(this).find('.thirdSpec select').val();
				if(specId&&specId!='0'){
					s.specId = specId;
				}
				var first = [];
				var firstInputs = $(this).find('.first-param input');
				for(var f=0;f<firstInputs.length;f+=2){
					if(firstInputs.eq(f).val().replace(/^\s+|\s+$/g,'')!=''){
						first.push({key:firstInputs.eq(f).val(),value:firstInputs.eq(f+1).val()});
					}
				}
				s.first = first;
				var second = [];
				var secondInputs = $(this).find('.spec-add input');
				for(var i=0;i<secondInputs.length;i++){
					if(secondInputs.eq(i).val().replace(/^\s+|\s+$/g,'')!=''){
						second.push({key:secondInputs.eq(i).val(),value:secondInputs.eq(++i).val()});	
					}
				}
				s.second = second;
				productData.spec.push(s);
		}
	});

	if($('#btn-container').find('div[index]').length==0&&productData.fileData.length==0){
		layer.msg("请添加商品详情！");
		return false;
	}
	var st = '';
	productData.oldBanner = '';
	$('#btn-container1 div[index]').each(function(){
		productData.oldBanner+= st;
		st = ';';
		productData.oldBanner+=$(this).attr('path');
	});
	st = '';
	productData.oldInfo = '';
	$('#btn-container div[index]').each(function(){
		productData.oldInfo+= st;
		st = ';';
		productData.oldInfo+=$(this).attr('path');
	});
	var formData = new FormData();
	for(var i=0;i<productData.fileData.length;i++){
		formData.append('files',productData.fileData[i]);
	}
	for(var i=0;i<productData.banners.length;i++){
		formData.append('banners',productData.banners[i]);
	}
	if(productData.imgSmall){
		formData.append('imgSmall',productData.imgSmall);
	}
	if(productData.typeId){
		formData.append('typeId',productData.typeId);
	}
	if(productData.productName){
		formData.append('productName',productData.productName);
	}
	if(productData.productDetails){
		formData.append('productDetails',productData.productDetails);
	}
	if(productData.productNumber){
		formData.append('productNumber',productData.productNumber);
	}
	if(productData.productKeys){
		formData.append('productKeys',productData.productKeys);
	}
	if(productData.province){
		formData.append('province',productData.province);
	}
	if(productData.productArea){
		formData.append('productArea',productData.productArea);
	}
	if(productData.delParam){
		formData.append('delParam',productData.delParam.join(','));
	}
	if(productData.thirdID){
		formData.append('productID',productData.thirdID);
	}
	if(productData.productSource){
		formData.append('productSource',productData.productSource);
	}
	formData.append('oldBanner',productData.oldBanner);
	formData.append('oldInfo',productData.oldInfo);
	formData.append('infoId',productData.infoId);
	formData.append('proId',productData.proId);
	if(productData.productDegree){
		formData.append('degree',productData.productDegree);
	}
	if(productData.productRecom){
		formData.append('recom',productData.productRecom);
	}
	formData.append('productSpec',JSON.stringify(productData.spec));
	formData.append('productIntegral',productData.productIntegral);
	var httpRequest = new XMLHttpRequest();  
    httpRequest.onreadystatechange = function(){  
        if(httpRequest.readyState == 4 && httpRequest.status == 200){  
            var data = JSON.parse(httpRequest.responseText);
           
            if(data.code==0){
            	if(data.result==true){
            		layer.msg("新增成功！");
            		document.location.reload();
            	}
            }
        }  
    };  
    httpRequest.open("post",'${pageContext.request.contextPath}/manager/product/edit.do',true);  
    //httpRequest.setRequestHeader("Content-type","multipart/form-data");  
    httpRequest.send(formData); 
}
$(function(){
	$('.btn-container div em').on('click',function(){
		$(this).parents('div:first').remove();
	});
	$('.pro-type li').on('click',function(){
		var typeId = $(this).attr('id');
		var name = $(this).find('a').html();
		var span = $(this).parents('ul').prev().find('span:first');
		span.attr("typeId",typeId);
		alert(typeId)
		productData.typeId = typeId;
		span.html(name);
	});
}())

//启用规格参数
$(document).on('click','.xy-btn-disable',function(){
	var id = $(this).parents('.spec-group').attr("paramId");
	var that = this;
	layer.confirm('确认要启用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/product/paramenable.do',{paramId:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(that).removeClass('xy-btn-disable').addClass('xy-btn-enable');
					layer.msg('已启用!',{icon: 6,time:1000});	
				}
			}
		},'json');
		
	});
});
//禁用规格参数
$(document).on('click','.xy-btn-enable',function(){
	var id = $(this).parents('.spec-group').attr("paramId");
	var that = this;
	layer.confirm('确认要禁用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/product/paramdisable.do',{paramId:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(that).removeClass('xy-btn-enable').addClass('xy-btn-disable');
					layer.msg('已禁用!',{icon: 5,time:1000});	
				}
			}
		},'json');
		
	});
});
(function(){
	var index = $('#pro-source').attr("data");
	console.log($('#pro-source').find("option").eq(index));
	$('#pro-source').find("option").eq(index).attr("selected","selected");
	if(index>0){
		$('#thirdID').show();
	}
})()
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script> 
</html>