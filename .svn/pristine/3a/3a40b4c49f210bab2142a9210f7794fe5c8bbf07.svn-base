<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>商超</title>
</head>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
 <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
<!--        <li><label class="l_f">留言</label><input name="" type="text" class="text_add" placeholder="输入留言信息" style=" width:250px"></li> -->
       <li><label class="l_f">开始时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li><label class="l_f">结束时间</label><input class="inline laydate-icon" id="end" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
     <div class="border clearfix" style="margin-top:10px;">
     	<span class="l_f"><button class="btn btn-warning Order_form" onClick="excel();">导出excel</button></span>
       <span class="r_f">交易额：&nbsp;<b id="trade"></b>&nbsp;元
					</span>
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
          <th width="180">交易编号</th>
          <th width="180">付款编号</th>
          <th width="180">商超编号</th>
          <th width="80">姓名</th>
          <th width="180">商超名称</th>
          <th width="80px">金额(元)</th>
          <th width="200px">交易时间</th>
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
 /*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url+'#?='+id,w,h);
}
/*checkbox激发事件*/
$('#checkbox').on('click',function(){
	if($('input[name="checkbox"]').prop("checked")){
		 $('.Reply_style').css('display','block');
		}
	else{
		
		 $('.Reply_style').css('display','none');
		}	
	})
	/*字数限制*/
function checkLength(which) {
	var maxChars = 200; //
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
var oTable1;
var search;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/alliance/tradeByPage.do';
		oTable1 = $('#sample-table').dataTable( {
			"searching" : true, 
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.startTime = $('#start').val();
					d.endTime = $('#end').val();
					d.userId = '${userId}';
					d.openId = '${openId}';
					search = d.search.value;
	            },
				'dataSrc':function(data){
					$("#trade").html(data.totalTrade/100);
					for(var i=0;i<data.result.length;i++){
						data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
						data.result[i].money = data.result[i].money/100;
					}
					return data.result;
				}		
			},
			'columns': [
				{ data: 'ch' },
		        { data: 'tradeNo' },
		        { data: 'paymentNo' },
		        { data: 'alliance.product_id' },
		        { data: 'user.realName' },
		        { data: 'alliance.storename' },
		        { data: 'money' },
		        { data: 'payTime' },
		    ],
 		"aaSorting": [[ 4, "desc" ]],//默认第几个排序
		"ordering": false,
		"bStateSave": false,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,5]}// 制定列不参与排序
		] } );
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
				
		});	
		$.fn.dataTable.ext.errMode = 'none';
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
			/* 	$('table th input:checkbox').on('click' , function(){
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
				} */
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
function excel(){
	var startTime = $('#start').val();
	var endTime = $('#end').val();
	var userId = '${userId}';
	var openId = '${openId}';
	location.href = '${pageContext.request.contextPath}/manager/alliance/tradeExcel.do?startTime='+startTime+'&endTime='+endTime+'&userId'+userId+'&openId='+openId+'&search='+search;
}
</script>
</html>