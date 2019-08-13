<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" /> 
        <link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css"/>       
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
        <link href="${pageContext.request.contextPath}/manager/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />   
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	    <script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>   
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script> 
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
        <script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
<title>英利律师事务所订单列表</title>
<style type="text/css">

	.layui-layer-title img{
		width:25px;
		height:25px;
		margin-right:14px;
	}
</style>
</head>
<body>
<div class=" page-content clearfix">
 <div id="products_style">
    <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">开始时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li><label class="l_f">结束时间</label><input class="inline laydate-icon" id="end" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <div class="border clearfix" style="margin-top:10px;">
       <span class="r_f">共：<b>${total}</b>个订单</span>
     </div>
     <!--产品列表展示-->
     <div class="h_products_list clearfix">
         <div class="table_menu_list" id="testIframe">
	       <table class="table table-striped table-bordered table-hover" id="sample-table">
			<thead>
			 <tr>
					<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
					<th width="80px">订单编号</th>
					<th width="80px">提交名称</th>
					<th width="100px">手机</th>
					<th width="100px">详细描述</th>
					<th width="100px">提交用户</th>
	                <th width="80px">类型</th>
	                <th width="80px">交易状态</th>				
					<th width="80px">提交时间</th>
				</tr>
			</thead>
		<tbody>
	    </tbody>
	    </table>
    </div>     
  </div>
 </div>
</div>
</body>
<script type="text/javascript">
var oTable1;
jQuery(function($) {
		
		var url = '${pageContext.request.contextPath}/manager/yingli/findByPage.do';
		oTable1 = $('#sample-table').dataTable( {
		"processing": true,  
        "serverSide": true,
		'ajax':{
			'url':url,
			'data': function (d) {
                d.startTime = $('#start').val();
                d.endTime = $('#end').val();
            },
			'dataSrc':function(data){
				for(var i=0;i<data.result.length;i++){
					data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
					var st = '<span class="label label-important">交易失败</span>';
					var ty = '<span class="label">免费</span>';
					if(data.result[i].status==1){
						st = '<span class="label label-success">交易成功</span>';
					}
					if(data.result[i].type==1){
						ty = '<span class="label label-warning">VIP</span>';
					}
					data.result[i].status = st;
					data.result[i].type = ty;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'number' },
	        { data: 'name' },
	        { data: 'phone' },
	        { data: 'details' },
	        { data: 'user.nickName' },
	        { data: 'type' },
	        { data: 'status'},
	        { data: 'createTime'}
	    ],
// 		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7,8]}// 制定列不参与排序
		] } );
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
				
		});
		
	
		$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();
	
			var off2 = $source.offset();
			var w2 = $source.width();
	
			if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
			return 'left';
		}
	});
 laydate({
    elem: '#start',
    event: 'focus' 
});
 laydate({
    elem: '#end',
    event: 'focus' 
});
$('.btn_search').on('click',function(){
	 oTable1.fnClearTable();
});
//初始化宽度、高度  
 $(".h_products_list").height($(window).height()-100); 
$(".table_menu_list").width($(window).width());
 $(".table_menu_list").height($(window).height()-100);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".h_products_list").height($(window).height()-100);
	 $(".table_menu_list").width($(window).width());
	  $(".table_menu_list").height($(window).height()-100);
	})
 
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
	
});
</script>
</html>