<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${pageContext.request.contextPath}" />
</head>
<body>
<span id="mes"></span>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/websocket.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.js"></script>
<script type="text/javascript">
	var onMessage = function(data){
		console.log(data);
		console.log(document.getElementById("mes"));
		$('#mes').html(data);
	}
</script>
</html>
