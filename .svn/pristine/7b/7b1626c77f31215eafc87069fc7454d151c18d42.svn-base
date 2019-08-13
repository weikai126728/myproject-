<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提示</title>
<style type="text/css">
	div{
		position:relative;
		margin-top:100px;
	}
</style>
</head>
<body style="text-align:center;background-color:#F8F8FF;">
<div>${msg}</div>
</body>
<script type="text/javascript">
	var winheight = document.offsetHeight;
	var winwidth = document.offsetWidth;
	console.log(winheight);
	console.log(winwidth);
	var path = '${path}';
	if(path==''){
		setTimeout(function(){
			if(parent.parent.iframe){
				parent.parent.iframe.location.reload();
			}else if(parent.iframe){
				parent.iframe.location.reload();
			}
		},1500);
	}else{
		setTimeout(function(){
			if(path.indexOf('/user/to/login.do')>0){
				parent.location.href = '${pageContext.request.contextPath}/'+path;	
			}else if(parent.parent.iframe){
				parent.parent.iframe.location.href='${pageContext.request.contextPath}/'+path;
			}else if(parent.iframe){
				parent.iframe.location.href='${pageContext.request.contextPath}/'+path;
			}else{
				location.href = '${pageContext.request.contextPath}/'+path;
			}
		},1500);
	}
	
	
</script>
</html>