<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css"/>       
        <link href="${pageContext.request.contextPath}/manager/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/font/css/font-awesome.min.css" />
		<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
<title>商业类型</title>
</head>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
 	<div class="border clearfix" style="margin-top:10px;">
     	<span class="l_f"><button class="btn btn-warning Order_form" onClick="add();">新增类型</button></span>
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="180">名称</th>
          <th width="80px">详情</th>
          <th width="180">操作</th>       
          </tr>
      </thead>
		<tbody>
		<c:forEach var="type" items="${typeList}" varStatus="status">
			<tr>
				<td>${type.name}</td>
				<td>${type.details}</td>
				<td id="${type.id}" name="${type.name}" details="${type.details}">
					<a title="修改" href="javascript:edit(${type.id});" class="btn btn-xs btn-info"><i class="fa fa-cog bigger-120"></i></a>
					<a title="删除" href="javascript:del(${type.id});" class="btn btn-xs btn-info"><i class="fa fa-trash bigger-120"></i></a>
				</td>
			</tr>
		</c:forEach>
        </tbody>
      </table>
    </div>
 </div>
</div>
<div id="modelEdit" style="display:none;text-align:center">
	<div><label>名称:</label><input id="name"/></div>
	<div><label>描述:</label><input id="details"/></div>
</div>
</body>

<script type="text/javascript">

var oTable1;
jQuery(function($) {
		oTable1 = $('#sample-table').dataTable( {
			"bStateSave": false,//状态保存
			"aoColumnDefs": [
				  {"orderable":false,"aTargets":[0,1,2]}// 制定列不参与排序
				] 
		} );
})
/**
 * 修改
 */
function edit(id){
	var name = $('#'+id).attr("name");
	$('#name').val(name);
	var details = $('#'+id).attr("details");
	$('#details').val(details);
	layer.open({
		  type:1
		  ,title:'修改'
		  ,area : ['300px' , '']
		  ,content: $('#modelEdit')
		  ,btn: ['确定', '取消']
		  ,yes: function(index, layero){
		    $.post('${pageContext.request.contextPath}/manager/alliance/business/edit.do',{name:$('#name').val(),details:$('#details').val(),id:id},function(data){
				var msg ='登陆超时！';
		    	if(data.code==0){
					if(data.result=='true'){
						msg = '修改成功！';
						
					}else{
						msg = '修改失败！';
					}
				}
		    	layer.msg(msg,{icon: 6,time:1000},function(){
				    layer.closeAll();
				    location.reload();
				});
		    },'json');
		  }
		  ,end:function(index, layero){
			  $('#name').val('');
			  $('#details').val('');
		  }
		});
	
}	
/**
 * 删除
 */
function del(id){
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/alliance/business/del.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					layer.msg('已删除!',{icon: 6,time:1000},function(){
						location.reload();
					});
				}else{
					layer.msg('删除失败!',{icon: 5,time:1000});
				}
			}
		},'json');
		
	});
}
/*
 * 新增
 */
 function add(){
	$('#name').val('');
	$('#details').val('');
	 layer.open({
		  type:1
		  ,title:'新增'
		  ,area : ['300px' , '']
		  ,content: $('#modelEdit')
		  ,btn: ['确定', '取消']
		  ,yes: function(index, layero){
		    $.post('${pageContext.request.contextPath}/manager/alliance/business/add.do',{name:$('#name').val(),details:$('#details').val()},function(data){
				var msg ='登陆超时！';
		    	if(data.code==0){
					if(data.result==true){
						msg = '新增成功！';
						
					}else{
						msg = '新增失败！';
					}
				}
		    	layer.msg(msg,{icon: 6,time:1000},function(){
				    layer.closeAll();
				    location.reload();
				});
		    },'json');
		  }
		  ,end:function(index, layero){
			  $('#name').val('');
			  $('#details').val('');
		  }
		});
}
</script>
</html>