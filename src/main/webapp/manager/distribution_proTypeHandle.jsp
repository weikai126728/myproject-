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
 <link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css"/>       
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
        <link href="${pageContext.request.contextPath}/manager/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	    <script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
<title>添加产品分类</title>
</head>
<body>
<div class="type_style">
 <div class="type_title">产品类型信息</div>
  <div class="type_content">
  <div class="Operate_btn">
  <!-- <span class="btn  btn-warning" onClick="update(this);"><i class="icon-edit align-top bigger-125"></i>修改该类型</span> -->
  <!-- <span class="btn  btn-success" onClick="changStatus(this);"><i class="icon-ok align-top bigger-125"></i><span>禁用</span>该类型</span> -->
  <span class="btn  btn-danger" onClick="del(this);"><i class="icon-trash   align-top bigger-125"></i>删除该类型</span>
  </div>
  <form action="${pageContext.request.contextPath}/distribution/productCate/addPro.do" method="post" class="form form-horizontal" id="form-user-add">
  <c:choose>
  	<c:when test="${type==null||type.id==null||empty type.id}">
  	 
  	<div class="Operate_cont clearfix">
      <label class="form-label"><span class="c-red">*</span>分类名称：</label>
      <div class="formControls ">
        <input type="text" class="input-text" value="" placeholder="" id="typeName" name="name">
      </div>
    </div> 
 	</c:when>
  	<c:otherwise>
  	<input type="hidden" name="id" value="${type.id}" id="id"/>
  	 
  	<div class="Operate_cont clearfix">
      <label class="form-label"><span class="c-red">*</span>分类名称：</label>
      <div class="formControls ">
        <input type="text" class="input-text" value="${type.name}" placeholder="" id="typeName" name="name">
      </div>
    </div>
  	</c:otherwise>
  </c:choose>    
    <div class="">
     <div class="" style=" text-align:center">
      <input class="btn btn-primary radius" type="submit" value="提交">
      </div>
    </div>
  </form>
  </div>
</div> 
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-user-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});

/* function changStatus(e){
	if(!$('#id')&&$('#pid').val()=='0') {
		layer.msg('不能启用、禁用！');
		return false;
	}
	if(!$(e).hasClass('btn-success')) return false;
	hasChild($('#id').val(),function(data){
		if(data.code==0){
			if(data.result==true){//挂有商品
				layer.msg('该分类下有商品，不能进行该操作！',{icon: 2});
			}else{
				var status = $(e).find('span').html();
				var url = '${pageContext.request.contextPath}/manager/protype/disable';
				if(status=='启用'){
					url = '${pageContext.request.contextPath}/manager/protype/enable';
				}
				$.post(url,{id:$('#id').val()},function(data){
					if(data.code==0){
						if(data.result==true){
							layer.msg('成功！',{icon: 1});
							$(e).find('span').html(status=='启用'?'禁用':'启用');
						}else{
							layer.msg('失败！',{icon: 2});
						}
					}else if(data.code==2){
						parent.parent.document.location.href = data.path;
					}
				},'json');
			}
		}
	});
} */
function del(e){
	if(!$('#id') ) {
		layer.msg('不能删除！');
		return false;
	}
	if(!$(e).hasClass('btn-danger')) return false;
	hasChild($('#id').val(),function(data){
		if(data.code==0){
			if(data.result==true){
				layer.msg('该分类下有商品，不能进行该操作！',{icon: 2});
			}else{
				$.post('${pageContext.request.contextPath}/distribution/productCate/delete.do',{id:$('#id').val()},function(data){
						if(data.result==true){
							layer.msg('成功！',{icon: 1});
							setTimeout(function(){
								parent.document.location.reload();	
							},1500);							
						}
				},'json');
			}
		}else if(data.code==2){
			parent.parent.document.location.href = data.path;
		}
	});
}
function hasChild(id,fn){
	$.post('${pageContext.request.contextPath}/distribution/product/hasmore.do',{id:id},fn,'json');
}
</script>
</body>
</html>