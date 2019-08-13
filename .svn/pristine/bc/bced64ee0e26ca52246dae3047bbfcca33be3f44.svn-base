<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%-- <link href="${pageContext.request.contextPath}/manager/assets/layer/skin/layer.css"></link> --%>
<style type="text/css">
	label{
		display:block;
	}
	.input{
		width:300px;
	}
	em{
		background:url(${pageContext.request.contextPath}/manager/images/delete.png) no-repeat center center;
		display:inline-block;
		width:20px;
		height:20px;
		background-size:13px;
		position:relative;
		top:3px;
		cursor:pointer;
	}
	.add{
		background:url(${pageContext.request.contextPath}/manager/images/add.png) no-repeat center center;
		display:inline-block;
		width:100%;
		height:20px;
		background-size:13px;
		position:relative;
		top:3px;
		cursor:pointer;	
	}
</style>
</head>
<body>
<div style="width:408px">
<div style="text-align:center;">活动列表</div>
<c:forEach var="activity" items="${activityList}" varStatus="status">
<label index="${status.index+1}">活动${status.index+1}：<span class="input" id="${activity.id}">${activity.details}</span><em></em></label>
</c:forEach>
<div class="add"></div>
</div>
<div style="display:none;width:250px;" id="container">
	<textarea id="text" rows="3" cols="50" placeholder="活动内容" maxlength="50" style="position:relative;left:12px;"></textarea>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"></script>
<script type="text/javascript">
$('.add').on('click',function(){
	var that = this;
	layer.open({
		type : 1,
		title : '添加活动',
		shadeClose : true,
		shade : false,
		//maxmin : true, //开启最大化最小化按钮
		area : [ '400px', '200px' ],
		content : $('#container')
		,btn: ['确定', '取消']
		,yes: function(index, layero){
		    var text = $('#text').val();
		    if(text==''||text.replace(/^\s+|\s+$/g,'')==''){
		    	layer.msg("内容不能为空！");
		    	return false;
		    }
		    $.post('${pageContext.request.contextPath}/manager/market/addAct.do',{details:text,marketId:'${marketId}'},function(data){
		    	if(data.code==0){
		    		if(data.result==true){
		    			layer.msg('添加成功！',{time:1000},function(){
		    				layer.closeAll();
		    				$('#text').val('');
		    				var label = $(that).prev();
		    				var index = 1;
		    				if(label.attr('index')){
		    					index = parseInt(label.attr('index'))+1;		    					
		    				}
		    				var str = '<label index="'+index+'">活动'+index+'：<span class="input" id="'+data.id+'">'+text+'</span><em></em></label>';
		    				$(that).before(str);
		    			});
		    		}
		    	}
		    },'json');
		}
	});
});
$(document).on('click','em',function(){
	var id = $(this).prev().attr('id');
	var that = this;
	$.post('${pageContext.request.contextPath}/manager/market/deleteAct.do',{id:id},function(data){
		if(data.code==0){
			if(data.result==true){
				$(that).parents('label').remove();
			}
		}
	},'json');
})
</script>
</html>