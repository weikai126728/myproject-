<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 


</head>
<body>
<div>
<c:if test="${msg!=''||msg!=null}"> 
<div style="text-align: center;margin-top: 2rem;margin-bottom: 2rem;">${msg}</div>
</c:if> 
<form action="#" id="form">
店名： <input type="text" value="${info.name }"><br>
	<input type="hidden" value="${info.openid }" id="openid" name="openid" ><br>
	<input type="hidden" value="${info.id }"><br>
金额： <input type="text" id="amount" name="amount">
	<button onclick="tijiao()">提交</button>
</form>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"></script>
<script type="text/javascript">
function tijiao(){
	var openid =$("#openid").val();
	var b=true;
	if(openid==null||openid==""){
		  layer.msg('hello');
		b=false;
	}
	if(b){
		var amount=$("#amount").val();
		$("#form").attr({
			action : "${pageContext.request.contextPath}/manager/market/addshareGold.do",
			method : "post"
		})
		/* $.ajax({
            type: "post",
            url: "",
            data: {
           	 openid:openid,
           	 amount:amount
           	 },
            dataType: "json",
            success:function(data){
            	
           }
        }); */
	}else{
		$("#form").attr({
			action : "#",
			method : "post"
		})
	}
	
}

</script>
</html>