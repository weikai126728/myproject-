<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script>
<title>管理角色</title>
<style type="text/css">
	.Validform_title{
		display:none;
	}
</style>
</head>

<body>
 <div class="margin clearfix">
   <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:void(0);" id="Competence_add" class="btn btn-warning" title="添加角色"><i class="fa fa-plus"></i> 添加角色</a>
<!--         <a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash"></i> 批量删除</a> -->
       </span>
       <span class="r_f">共：<b>${roleList.size()}</b>类</span>
     </div>
     <div class="compete_list">
       <table id="sample-table-1" class="table table-striped table-bordered table-hover">
		 <thead>
			<tr>
			  <th class="center">
<!-- 			  <label><input type="checkbox" class="ace"><span class="lbl"></span></label> -->
				序号
			  </th>
			  <th>角色名称</th>
			  <th>人数</th>
			  <th>LEVEL</th>
			  <th class="hidden-480">描述</th>             
			  <th class="hidden-480">操作</th>
             </tr>
		    </thead>
             <tbody>
             <c:forEach var="role" items="${roleList}" varStatus="status">
			  <tr roleId="${role.id}">
				<td class="center">
<!-- 				<label><input type="checkbox" class="ace"><span class="lbl"></span></label> -->
					${status.index+1}
				</td>
				<td>${role.name}</td>
				<td>${role.number}</td>
				<td>${role.level}</td>
				<td>${role.describe}</td>
				<td>
                 <a title="编辑" onclick="Competence_modify(this)" href="javascript:void(0);"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>        
                 <a title="删除" href="javascript:void(0);"  onclick="Competence_del(this)" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>
                 <c:if test="${role.level!=-1 }">
	                 <a title="权限" href="javascript:void(0);"  onclick="Competence_alo(this)" class="btn btn-xs btn-danger" ><i class="fa fa-key  bigger-120"></i></a>
                 </c:if>
				</td>
			   </tr>
			  </c:forEach>											
		      </tbody>
	        </table>
     </div>
 </div>
 
 <div id="add_administrator_style" class="add_menber" style="display:none">
    <form action="${pageContext.request.contextPath}/manager/user/addRole.do" method="post" id="form-admin-add">
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>角色名：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="" placeholder="" id="user-name" name="name" datatype="*2-16" nullmsg="角色名不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label">描述：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="" placeholder="" id="nick-name" name="describe" datatype="*2-16" ignore="ignore">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>等级：</label>
			<div class="formControls ">
				<input type="number" class="input-text" value="" placeholder="" id="role-level" name="level" datatype="*" nullmsg="等级不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		
		<div> 
        <input class="btn btn-primary radius" type="submit" id="Add_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"></div>
	</form>
   </div>
</body>
</html>
<script type="text/javascript">
/*添加角色*/
$('#Competence_add').on('click', function(){
	$('form').attr('action','${pageContext.request.contextPath}/manager/user/addRole.do');
	$('#roleId').remove();
	$('.Validform_checktip').html('');
	$('.Validform_checktip').removeClass('Validform_right Validform_wrong');
	var input = $('form input');
	input.eq(0).val('');
	input.eq(0).removeAttr("ignore","ignore");
	input.eq(1).val('');
	input.eq(2).val('');
	input.eq(2).removeAttr("ignore","ignore");
	layer.open({
    type: 1,
	title:'添加角色',
	area: ['700px',''],
	shadeClose: false,
	content: $('#add_administrator_style'),
	
	});
})
	//表单验证提交
$("#form-admin-add").Validform({	
	 tiptype:2,
	 postonce:true,
	 ajaxPost:true,
	callback:function(data){
		//form[0].submit();
		if(data.code==0){ 
               layer.msg("操作成功！", {icon: 1,time: 1000}, function(){ 
					parent.iframe.location.reload();
                });   
        } 
        else{ 
            layer.msg("操作失败！", {icon: 2,time: 3000}); 
        } 		  
	}
});	
 /*权限-删除*/
function Competence_del(obj){
	 var roleId = $(obj).parents('tr').attr('roleId');
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/user/delRole.do',{roleId:roleId},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000},function(){
						parent.iframe.location.reload();
					});
				}else{
					layer.msg('删除失败!',{icon:1,time:1000});
				}
			}
		},'json');
		
	});
}
function Competence_alo(obj){
	var roleId = $(obj).parents('tr').attr('roleId');
	location.href = '${pageContext.request.contextPath}/manager/authority/allocation.do?roleId='+roleId;
}
/*字数限制*/
function checkLength(which) {
	var maxChars = 200; //
	if(which.value.length > maxChars){
	   layer.open({
	   icon:2,
	   title:'提示框',
	   content:'您出入的字数超多限制!',	
    });
		// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
		which.value = which.value.substring(0,maxChars);
		return false;
	}else{
		var curr = maxChars - which.value.length; //250 减去 当前输入的
		document.getElementById("sy").innerHTML = curr.toString();
		return true;
	}
};
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form ,#Competence_add').on('click', function(){
	var cname = $(this).attr("title");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe span').html(cname);
	parent.$('#parentIframe').css("display","inline-block");
    parent.$('.Current_page').attr("name",herf).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+">" + cnames + "</a>");
    parent.layer.close(index);
	
});
//编辑
function Competence_modify(obj){
	$('form').attr('action','${pageContext.request.contextPath}/manager/user/updateRole.do');
	$('.Validform_checktip').html('');
	$('.Validform_checktip').removeClass('Validform_right Validform_wrong');
	var roleId = $(obj).parents('tr').attr('roleId');
	var name = $(obj).parents('tr').find('td').eq(1).html();
	var level = $(obj).parents('tr').find('td').eq(3).html();
	var describe = $(obj).parents('tr').find('td').eq(4).html();
	var input = $('form input');
	input.eq(0).val(name);
	input.eq(0).attr("ignore","ignore");
	input.eq(1).val(describe);
	input.eq(2).val(level);
	input.eq(2).attr("ignore","ignore");
	if($('#roleId').length!=0){
		$('#roleId').val(roleId);	
	}else{
		$('form').append('<input type="hidden" value="'+roleId+'" name="id" id="roleId"/>');		
	}
	
	layer.open({
	    type: 1,
		title:'修改角色',
		area: ['700px',''],
		shadeClose: false,
		content: $('#add_administrator_style'),
		
		});
}
</script>