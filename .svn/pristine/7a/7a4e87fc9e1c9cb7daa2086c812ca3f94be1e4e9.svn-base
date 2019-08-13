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
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="80">编号</th>
          <th width="100px">姓名</th>
          <th width="250px">openId</th>
          <th width="120px">联系方式</th>
          <th width="200px">地址</th>
          <th width="180px">入驻时间</th>            
          <th width="80px">商家数量</th>            
          <th width="120px">交易额</th>            
          <th width="180px">状态</th>            
          <th width="250">操作</th>
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
/*留言查看*/
function Guestbook_iew(obj){
	var id = $(obj).attr("id");
	parent.iframe.location.href = '${pageContext.request.contextPath}/manager/alliance/amount.do?salesmanId='+id;
// 	layer_show("交易流水",'${pageContext.request.contextPath}/manager/alliance/trade.do?openId=${openId}');
};
function Guestbook_add(obj){
	var id = $(obj).attr("id");
	parent.iframe.location.href = '${pageContext.request.contextPath}/manager/alliance/allocation.do?id='+id;
// 	layer_show("交易流水",'${pageContext.request.contextPath}/manager/alliance/trade.do?openId=${openId}');
};
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
function member_stop(obj){
	var id = $(obj).parents('td').prev().find("span").attr("id");
	layer.confirm('确认要停用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/user/disable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					layer.msg('已停用!',{icon: 5,time:1000},function(){
						oTable1.fnClearTable();
					});
				}else{
					var error = '操作失败';
					if(data.msg){
						error = data.msg;
					}
					layer.msg(error,{icon: 5,time:1000});
				}
			}
		},'json');
		
	});
}
/*用户-启用*/
function member_start(obj){
	var id = $(obj).parents('td').prev().find("span").attr("id");
	layer.confirm('确认要启用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/user/enable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					layer.msg('已启用!',{icon: 6,time:1000},function(){
						oTable1.fnClearTable();
					});
				}else{
					layer.msg('启用失败!',{icon: 5,time:1000});
				}
			}
		},'json');
		
	});
}
var oTable1;
var search;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/alliance/manByPage.do';
		oTable1 = $('#sample-table').dataTable( {
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.startTime = $('#start').val();
					d.endTime = $('#end').val();
					search = d.search.value;
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						var handle = '<a id="'+data.result[i].id+'"  onClick="Guestbook_iew(this);" title="交易流水"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-line-chart bigger-120"></i></a>'
						+'<a id="'+data.result[i].id+'"  onClick="Guestbook_add(this);" title="商超分配"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-pie-chart bigger-120"></i></a>';
						var st = '<span id="'+data.result[i].id+'" class="label label-success radius">审核通过</span>';
						if(data.result[i].status==0){//待审核
							st = '<span id="'+data.result[i].id+'" class="label radius">等待审核</span>';
							handle = '<a  style="text-decoration:none" class="btn btn-xs btn-warn" onClick="member_start(this)" href="javascript:;" title="启用"><i class="fa fa-check  bigger-120"></i></a>'+handle;
						}else{
							handle = '<a  style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this)" href="javascript:;" title="停用"><i class="fa fa-close  bigger-120"></i></a>'+handle
						}
						data.result[i].handle = handle;
						data.result[i].amount = data.result[i].amount/100;
						data.result[i].st = st;
					}
					return data.result;
				}		
			},
			'columns': [
		        { data: 'id' },
		        { data: 'realName' },
		        { data: 'openid' },
		        { data: 'phone' },
		        { data: 'address' },
		        {data:'createTime'},
		        {data:'num'},
		        {data:'amount'},
		        {data:'st'},
		        { data: 'handle' },
		    ],
// 		"aaSorting": [[ 4, "desc" ]],//默认第几个排序
		"bStateSave": false,//状态保存
		"ordering": false,
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7]}// 制定列不参与排序
		] } );
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
 function excel(){
		var startTime = $('#start').val();
		var endTime = $('#end').val();
		location.href = '${pageContext.request.contextPath}/manager/alliance/manExcel.do?startTime='+startTime+'&search='+search+'&endTime'+endTime;
	}
</script>
</html>