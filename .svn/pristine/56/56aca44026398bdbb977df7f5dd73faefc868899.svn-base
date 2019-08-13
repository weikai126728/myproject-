<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
<title>佣金结算单列表</title>
</head>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
 	<div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">开始时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li><label class="l_f">结束时间</label><input class="inline laydate-icon" id="end" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="180">商超编号</th>
          <th width="80px">商超名称</th>
          <th width="80px">流水单号</th>
          <th width="80px">状态</th>
          <th width="180">结算交易额</th>             
          <th width="180">结算佣金</th>       
          <th width="180">结算时间</th>       
          </tr>
      </thead>
		<tbody>
        </tbody>
      </table>
    </div>
 </div>
</div>
</body>

<script type="text/javascript">
var oTable1;
var search,column,order,type;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/alliance/settlementByPage.do';
		oTable1 = $('#sample-table').dataTable( {
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.startTime = $('#start').val();
					d.endTime = $('#end').val();
					search = d.search.value;
					column = d.order[0].column;
					order = d.order[0].dir;
					type = $('#selectType').val();
					d.type = type;
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						if(data.result[i].amount){
							data.result[i].amount /=100;
						}else{
							data.result[i].amount = 0;
						}
						if(data.result[i].total){
							data.result[i].total /= 100;
						}else{
							data.result[i].total = 0;
						}
						switch(data.result[i].status){
						case 0:
							data.result[i].status = '失败';
							break;
						case 1:
							data.result[i].status = '成功';
							break;
						}
					}
					return data.result;
				}		
			},
			'columns': [
		        { data: 'product_id' },
		        { data: 'storename' },
		        { data: 'paymentNo' },
		        { data: 'status' },
		        { data: 'total' },
		        { data: 'amount' },
		        {data:'createTime'},
		    ],
		"aaSorting": [[6, "desc" ]],//默认第几个排序
		"bStateSave": false,//状态保存
// 		"ordering": false,
		"aoColumnDefs": [
		  {"orderable":false,"aTargets":[1]}// 制定列不参与排序
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
			})
//时间选择
 laydate({
    elem: '#start',
    event: 'focus' 
});
 laydate({
    elem: '#end',
    event: 'focus' 
});
</script>
</html>