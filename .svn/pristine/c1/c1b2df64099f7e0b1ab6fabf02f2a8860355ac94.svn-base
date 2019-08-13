<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.abbot.schimneylife.pojo.shopping.MallOrder" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="java.util.Iterator" %>
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
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script>      	
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/jquery.easy-pie-chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
<title>订单详细</title>
</head>

<body>
<div class="margin clearfix">
<div class="Order_Details_style">
<div class="Numbering">订单编号:<b>${order.number}</b></div></div>
 <div class="detailed_style">
 <!--收件人信息-->
    <div class="Receiver_style">
     <div class="title_name">收件人信息</div>
     <div class="Info_style clearfix">
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件人姓名： </label>
         <div class="o_content">${order.contactUser}</div>
        </div>
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件人电话： </label>
         <div class="o_content">${order.contactPhone}</div>
        </div>
<!--          <div class="col-xs-4">   -->
<!--          <label class="label_name" for="form-field-2"> 收件地邮编： </label> -->
<!--          <div class="o_content">104545</div> -->
<!--         </div> -->
         <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 收件地址： </label>
         <div class="o_content">${order.shippingAddress}</div>
        </div>
     </div>
    </div>
    <!--订单信息-->
    <div class="product_style">
    <div class="title_name">产品信息</div>
    <div class="Info_style clearfix">
    <c:forEach var="mallOrder" items="${order.mallOrder}" varStatus="status">
      <div class="product_info clearfix">
      <a href="#" class="img_link"><img src="${pageContext.request.contextPath}/image/showImage.do?image=${mallOrder.product.imgSmall}"  width="200" height="200"/></a>
      <span>
      <a href="#" class="name_link">${mallOrder.product.productName}</a>
      <b>${mallOrder.product.details}</b>
      <%
      	MallOrder mallorder = (MallOrder)pageContext.getAttribute("mallOrder");
      	JSONArray array = JSONArray.parseArray(mallorder.getProduct().getParameter().getFirstParam());
      	for(int i=0;i<array.size();i++){
      		JSONObject obj = array.getJSONObject(i);
      		Iterator<String> keys = obj.keySet().iterator();
      		while(keys.hasNext()){
      			String key = keys.next();
      %>
      <p><%=key %>：<%=obj.getString(key)%></p>
      <%}} %>
      <p>价格：<b class="price"><i>￥</i>${mallOrder.settlement}</b></p>    
      </span>
      </div>
    </c:forEach>
    </div>
    </div>
    <!--总价-->
    <div class="Total_style">
     <div class="Info_style clearfix">
<!--       	<div class="col-xs-4">   -->
<!--          <label class="label_name" for="form-field-2"> 支付方式： </label> -->
<!--          <div class="o_content">在线支付</div> -->
<!--         </div> -->
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 支付状态： </label>
         <div class="o_content">
         <c:choose>
         	<c:when test="${order.status==-2}">交易失败</c:when>
         	<c:when test="${order.status==-1}">交易关闭</c:when>
         	<c:when test="${order.status==0}">未付款</c:when>
         	<c:when test="${order.status==1}">已付款未结算</c:when>
         	<c:when test="${order.status==2}">已付款已结算</c:when>
         	<c:when test="${order.status==3}">未收货</c:when>
         	<c:when test="${order.status==4}">交易成功未评价</c:when>
         	<c:when test="${order.status==5}">交易成功已评价</c:when>
         </c:choose>
         </div>
        </div>
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2"> 订单生成日期： </label>
         <div class="o_content">${order.createTime}</div>
        </div>
        <c:if test="${order.source==0}">
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2">物流公司： </label>
         <div class="o_content">${order.logistics.company}</div>
        </div>
        <c:if test="${order.logistics.logisticsNo!=null}">
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2">物流编号： </label>
         <div class="o_content">${order.logistics.logisticsNo}</div>
        </div>
        </c:if>
        <div class="col-xs-4">  
         <label class="label_name" for="form-field-2">运单编号： </label>
         <div class="o_content">${order.logistics.waybill}</div>
        </div>
        </c:if>
        </div>
      <div class="Total_m_style"><span class="Total">总数：<b>${order.count}</b></span><span class="Total_price">总价：<b>${order.amountStr}</b>元</span></div>
    </div>
<div class="Button_operation">
				<button onclick="history.go(-1)" class="btn btn-primary radius" type="submit"><i class="icon-save "></i>返回上一步</button>
				
<!-- 				<button onclick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button> -->
			</div>
 </div>
</div>
</body>
</html>
