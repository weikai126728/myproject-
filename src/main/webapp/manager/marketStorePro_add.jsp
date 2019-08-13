<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>发布信息</title>
</head>
<body>
<input type="hidden" id="root" value="${pageContext.request.contextPath}"/>
<div class="clearfix" id="add_picture">

   <div class="page_right_styl" style="width: 100%;">
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>活动描述：</label>
		 <div class="formControls col-10"><input maxlength="250" type="text" class="input-text" value="" placeholder="" id="productName" onchange="productData.productName=this.value"></div>
		</div>
		<div class=" clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>活动分类：</label>
		
	<select name="" id="bmclass" onchange="getmclass()" >
    		<option value="0">请选择</option>
    		<c:forEach items="${listClass }" var="list">
    		<option value="${list.id }">${list.name }</option>
    		</c:forEach>
	</select>
	</div> 
		<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>所属店铺：</label>
			<div class="formControls col-2"><input type="hidden" value="${supermarketInfo.id }"  id="marketid"><input maxlength="20" type="text" class="input-text" value="${supermarketInfo.name }" placeholder="" readonly="readonly" ></div>
           <%--  <div class="formControls col-2"><input type="hidden" value="${info.id}"  id="marketid"><input maxlength="20" type="text" class="input-text" value="${info.name}"  ></div> --%>
            </div>
		</div>
	
	 	<div class="clearfix cl gz">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>活动规则：</label>
			 <div class="formControls col-10"> <div style="display: flex;justify-content: flex-start;"><input style="width: 8rem;"  maxlength="10" type="text" class="form-control" value="" 
			 placeholder="" 
			 name="price" id="price" onchange="productData.price=this.value"><input style="width:8rem;"  maxlength="10" type="text" class="form-control" value="" 
			 placeholder="" 
			 name="price1" id="price1" onchange="productData.price1=this.value"></div></div>
            </div>
		</div>
	
		 	<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>活动开始时间：</label>
			<div class="formControls col-2"><input type="date" step="01" name="countdown1" id="countdown1" onchange="productData.countdown1=this.value"></div>
            </div>
		</div>
			<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>活动结束时间：</label>
			<div class="formControls col-2"><input type="date" step="01" name="countdown" id="countdown" onchange="productData.countdown=this.value"></div>
            </div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>活动主图：</label>
			<div class="formControls col-2">
				<img alt="" src="" id='small-img' style="width:50px;height:50px;">
				<input type="file" style="display: none;" id="imgSmall" name="imgSmall"/>
				<span id="btn-img-add0" onclick="imgSmall.click()" class="btn btn-success">添加图片</span>
			</div>
		</div> 
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>更多图片：</label>
			<div class="formControls col-10 ">
			<div id="btn-container" class="panel panel-default btn-container">
			</div>
			<input type="file" multiple="multiple" style="display: none;" id="files" name="files" class="btn-files"/>
			<span id="btn-img-add" onclick="files.click()" class="btn btn-success">上传</span>
			</div>
		</div>
		<div style="margin-left: 4rem;margin-bottom: 2rem;margin-top: 0.6rem"><input  type="checkbox" class='integral' />&nbsp;<span><a style="border-bottom: 1px solid #999;" href="${pageContext.request.contextPath}/page/shopping/wap_disclaimer.jsp">服务协议及免责声明</a></span></div>
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
<script type="text/javascript">
function getmclass(){
	  var typ_id = $("#bmclass").val();//得到第一个下拉列表的值  
	  
	if(typ_id==1){
		 $(".gz").show();
		 $("#price").attr("placeholder","券额度");
		 $("#price1").attr("placeholder","满多少可用");
	}else if(typ_id==2){
		$(".gz").show();
		 $("#price").attr("placeholder","满多少");
		 $("#price1").attr("placeholder","减多少");
	}else if(typ_id==3){
		$(".gz").show();
		 $("#price").attr("placeholder","全场/单品");
		 $("#price1").attr("placeholder","折扣");
	}else if(typ_id==4){
		 $("#price").attr("placeholder","免费");
		 $(".gz").hide();
	}
	  
}





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
   $(".page_right_style").width($(window).width()-220); 
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	 $(".widget-box").height($(window).height()); 
	 $(".page_right_style").height($(window).height()); 
	 $(".page_right_style").width($(window).width()-220); 
	});	
});
// $(function(){
// 	var ue = UE.getEditor('editor');
// });
/******树状图********/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				productData.typeId = treeNode.id;
				return true;
			}
		}
	}
};


		

</script>
<script type="text/javascript">
//数据提交
var productData={};
function product_save_submit(){

	if(!productData.productName||productData.productName.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写商品标题！');
		return false;
	}

	if(!productData.countdown||productData.countdown.replace(/^\s+|\s+$/g,'')==''||!productData.countdown1||productData.countdown1.replace(/^\s+|\s+$/g,'')==''){
			layer.msg('请现填写活动时间！');
			return false;
	}
	var bmclass=$("#bmclass").val()
	if(bmclass==0){
		layer.msg("请选择大分类！");
		return false;
	}
	if(bmclass==1||bmclass==2||bmclass==3){
		 if(!productData.price||productData.price.replace(/^\s+|\s+$/g,'')==''||!productData.price1||productData.price1.replace(/^\s+|\s+$/g,'')==''){
				layer.msg('请现填写活动规则！');
				return false;
			}
	}
	if(!productData.imgSmall){
		layer.msg("请添加商品图片！");
		return false;
	}
	var formData = new FormData();
	for(var i=0;i<productData.fileData.length;i++){
		formData.append('files',productData.fileData[i]);
	}
	var marketid=$("#marketid").val()
	formData.append('marketid',marketid);
	formData.append('imgSmall',productData.imgSmall);
	formData.append('productName',productData.productName);
	if(bmclass==1||bmclass==2||bmclass==3){
		formData.append('price',productData.price+';'+productData.price1);
	}else if(bmclass==4){
		formData.append('price',"免费");
	}
	alert(productData.countdown)
	formData.append('countdown',productData.countdown1.substring(5,10)+";"+productData.countdown.substring(5,10));
	formData.append('bmclass',bmclass);
	var b=	$(".integral").is(":checked");
	if(b){
	$.ajax({
        url: "${pageContext.request.contextPath}/Store/upload.do",
        type: "POST",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
       	 if(data.code==0){
	      			if(data.result==true||data.result=='true'){
	      				layer.open({
	      				   content: '添加成功'
	      				   ,skin: 'msg'
	      				   ,time: 1 //2秒后自动关闭
	      				   ,success:function(){
	      					 document.location.reload();
	      				   }
	      				})
	      			}
	      			}
        },
        error: function (res) {
        }
    });
	}
/* 	var httpRequest = new XMLHttpRequest();  
    httpRequest.onreadystatechange = function(){  
        if(httpRequest.readyState == 4 && httpRequest.status == 200){  
            var data = JSON.parse(httpRequest.responseText);
            if(data.code==0){
            	if(data.result==true){
            		layer.msg("添加成功");
            		setTimeout(function(){
            			document.location.reload("${pageContext.request.contextPath}/second/marketinfo.do");
            		},1000);            		
            	}
            }
        }  
    };  
    httpRequest.open("post",'${pageContext.request.contextPath}/second/upload.do',true);  
    httpRequest.send(formData);  */
}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script> 
</body>
</html>