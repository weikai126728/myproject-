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
<title>发布动态</title>
</head>
<body>
<input type="hidden" id="root" value="${pageContext.request.contextPath}"/>
<div class="clearfix" id="add_picture">
<div id="scrollsidebar" class="left_Treeview">
    <div class="show_btn" id="rightArrow"><span></span></div>
    <div class="widget-box side_content" >
     <div class="side_list">
  
  </div>
  </div>  
  </div>
   <div class="page_right_style">
   <div class="type_title">发布动态</div>
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>主题描述：</label>
		 <div class="formControls col-10"><input maxlength="30" type="text" class="input-text" value="" placeholder="" id="productName" onchange="productData.productName=this.value"></div>
		</div>
	<div class="clearfix cl">
			<div class="Add_p_s">
            <label class="form-label col-2"><span style="color:red"></span>所属店铺：</label>
			<div class="formControls col-2"><input type="hidden" value="${supermarketInfo.id }"  id="marketid"><input type="hidden" value="${supermarketInfo.openid }"  id="openid"><input maxlength="20" type="text" class="input-text" value="${supermarketInfo.name }" placeholder="" readonly="readonly" ></div>
            </div>
		</div>
		<div class="clearfix cl">
			<label class="form-label col-2"><span style="color:red">*</span>主题图片：</label>
			<div class="formControls col-2">
				<img alt="" src="" id='small-img' style="width:50px;height:50px;">
				<input type="file" style="display: none;" id="imgSmall" name="imgSmall"/>
				<span id="btn-img-add0" onclick="imgSmall.click()" class="btn btn-success">添加图片</span>
			</div>
		</div>
		<div class="clearfix cl">
         <label class="form-label col-2"><span style="color:red">*</span>添加链接：</label>
		 <div class="formControls col-10"><input maxlength="300" type="text" class="input-text" value="" placeholder="" id="productName" onchange="productData.productUrl=this.value"></div>
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

var zNodes =${array};
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	//demoIframe.bind("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
});			
</script>
<script type="text/javascript">
//数据提交
var productData={};
function product_save_submit(){
	/* if(!productData.typeId){
		layer.msg('请现选择左侧商品分类！');
		return false;
	} */
	if(!productData.productName||productData.productName.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写广告标题！');
		return false;
	}
	if(!productData.productUrl||productData.productUrl.replace(/^\s+|\s+$/g,'')==''){
		layer.msg('请现填写广告链接！');
		return false;
	}
	
	productData.spec = [];
	
	if(!productData.imgSmall){
		layer.msg("请添加广告图片！");
		return false;
	}
	var formData = new FormData();
	formData.append('imgSmall',productData.imgSmall);
	formData.append('productName',productData.productName);
	formData.append('productUrl',productData.productUrl);
	
	var marketid=$('#marketid').val();
	formData.append('marketid',marketid);
	
	var openid=$('#openid').val();
	$.ajax({
         url: "${pageContext.request.contextPath}/manager/market/uploadVipcn.do",
         type: "POST",
         data: formData,
         /**
         *必须false才会自动加上正确的Content-Type
         */
         contentType: false,
         /**
         * 必须false才会避开jQuery对 formdata 的默认处理
         * XMLHttpRequest会对 formdata 进行正确的处理
         */
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
	/* var httpRequest = new XMLHttpRequest();  
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
    httpRequest.open("post",'${pageContext.request.contextPath}/market/uploadpro.do',true);  
    httpRequest.send(formData);  */
}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/upload2.js"></script> 
</body>
</html>