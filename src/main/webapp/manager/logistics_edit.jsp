<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.min.js"></script>
<title>物流信息修改</title>
<style type="text/css">
.banner{
	width:450px;
	height:225px;
}
.item{
	margin-top:10px;
	border:1px red solid;
	display:inline-block;
	padding:6px;
}

.file{
	display:none;
}
.clearfix:after,.clearfix:before{content: "";display: table;}
.clearfix:after{clear: both;}
.clearfix{*zoom:1;}
</style>
</head>
<body class="clearfix">
<form action="${pageContext.request.contextPath}/manager/logistics/save.do" style="text-align:center;" enctype="multipart/form-data" method="post">
	<label>物流公司：</label><select name="company"><option value="${logistics.company}" selected>中通快递</option></select>
	<label>物流编号：</label><input type="text" name="logisticsNo" value="${logistics.logisticsNo}"/>
	<label><span style="color:red;">*</span>运单编号：</label><input type="text" name="waybill" id="waybill" value="${logistics.waybill}" />
	<input type="button" onClick="submit();" />
</form>
</body>
<script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>  
<script type="text/javascript">
function submit(){
// 	var company = $('#company').val();
	var waybill = $('#waybill').val();
// 	if(company.replace(/^\s+|\s+$/g,'')){
// 		layer.open({
// 			   icon:2,
// 			   title:'提示框',
// 			   content:'请输入物流公司!',	
// 		    });
// 		return false;
// 	}
	if(waybill.replace(/^\s+|\s+$/g,'')){
		layer.open({
			   icon:2,
			   title:'提示框',
			   content:'请输入运单编号!',	
		    });
		return false;
	}
	$('form').submit();
}
</script>
</html>