<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员编辑</title>
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
        <style type="text/css">
        	#Validform_msg{
        		display:none;
        	}
        </style>
</head>
<body>
<div id="add_administrator_style" class="add_menber" >
    <form action="${pageContext.request.contextPath}/manager/user/editManager.do" method="post" id="form-admin-add">
		<input type="hidden" value="${user.id}" name="id"/>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>管理员：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="${user.realName}" placeholder="" id="user-name" name="realName" datatype="*2-16" nullmsg="用户名不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>昵称：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="${user.nickName}" placeholder="" id="nick-name" name="nickName" datatype="*2-16" nullmsg="昵称不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls">
			<input ignore="ignore" type="password" placeholder="密码" name="userpassword" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="密码不能为空" id="newpassword">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>确认密码：</label>
			<div class="formControls ">
		<input ignore="ignore" value="" type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="userpassword" id="newpassword2" name="password">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>性别：</label>
			<div class="formControls  skin-minimal">
            <label><input name="gender" type="radio" <c:if test="${user.gender==1}">checked</c:if> class="ace" name="gender" value="1"><span class="lbl">男</span></label>&nbsp;&nbsp;
            <label><input name="gender" type="radio" <c:if test="${user.gender==2}">checked</c:if> class="ace" name="gender" value="2"><span class="lbl">女</span></label>
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>手机：</label>
			<div class="formControls ">
				<input type="text" class="input-text" value="${user.phone}" placeholder="" id="user-tel" name="phone" datatype="m" nullmsg="手机不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label">角色：</label>
			<div class="formControls "> <span class="select-box" style="width:150px;">
				<select class="select" name="roleId" size="1">
				<c:forEach var="role" items="${roleList}" varStatus="status">
					<option value="${role.id}" <c:if test="${user.role.id==role.id}">selected="selected"</c:if> >${role.name}</option>
				</c:forEach>
				</select>
				</span> </div>
		</div>
		<div> 
        <input class="btn btn-primary radius" type="submit" id="Add_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"></div>
	</form>
</div>
</body>
<script type="text/javascript">
(function(){
	$('#newpassword').html('${user.password}');
}())
//字数限制
function checkLength(which) {
	var maxChars = 100; //
	if(which.value.length > maxChars){
	   layer.open({
		   icon:2,
		   title:'提示框',
		   content:'您输入的字数超过限制!',	
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
//表单验证提交
$("#form-admin-add").Validform({
		
	 tiptype:2,
	 ajaxPost:true,
	callback:function(data){
	//form[0].submit();
		if(data.code==0){ 
	        layer.msg("修改成功", {icon: data.status,time: 1000}, function(){ 
	            parent.parent.iframe.location.reload();//刷新页面 
	        });   
	    } 
	    else{ 
	        layer.msg("修改失败", {icon: data.status,time: 3000}); 
	    } 		  
	}
	
	
});	
</script>
</html>