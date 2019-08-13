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
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script>     
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/jquery.easy-pie-chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
<title>订单管理</title>
<style type="text/css">
	.productImage{
		width:50px;
		height:50px;
	}
</style>
</head>

<body>
<!--订单表格-->
<div class="order_list" id="order_list">
  <div class="h_products_list clearfix" id="products_list" style="overflow:auto">
     <!--订单列表-->
     <div class="table_menu_list order_style" id="table_order_list" style="margin-left:0px;">
       <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="l_f">时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;" ></li>
       <li><label class="l_f">时间</label><input class="inline laydate-icon" id="end" style=" margin-left:10px;" ></li>
       <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="fa fa-search"></i>查询</button></li>
      </ul>
    </div>
    <div class="border clearfix" style="margin-top:10px;">
    <span class="l_f"><button class="btn btn-warning Order_form" onClick="excel();">导出excel</button></span>
       <span class="r_f">可提现金额：&nbsp;<b id="trade">${money}</b>&nbsp;元 <button class="btn btn-warning Order_form" id="bton" onclick="tixian()">提现</button>
					</span>
     </div>
     <!--订单列表展示-->
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="120px">订单编号</th>
				<th width="250px">产品名称</th>
				<th width="100px">总价</th>
				<th width="100px">提成</th>
                <th width="180px">订单时间</th>				
				<th width="180px">联系电话</th>
				<th width="80px">联系人</th>
                <th width="80px">数量</th>
                <th width="80px">类型</th>
				<th width="70px">状态</th>      
				<th width="100px">返现</th>      
				<th width="180px">返现时间</th>      
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
     
     </tbody>
     </table>
   </div>
  </div>
 </div>
</body>
<script>
//时间选择
 laydate({
    elem: '#start',
    event: 'focus' 
});
 laydate({
    elem: '#end',
    event: 'focus' 
});
/*订单-删除*/
function Order_form_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
function tixian(){
	layer.confirm('确认要提现吗？',function(){
		/* var customerId = $(obj).attr("customerId");
		var orderId = $(obj).attr("id"); */
		$.post('${pageContext.request.contextPath}/manager/user/tixianWanghong.do',{money:'${money}',alopenid:'${openid}',nickname:'${nickName}',userid:'${userId}'},function(data){
			if(data.code==0){
				if(data.result==true||data.result=='true'){
					layer.msg('提现成功!',{icon:1,time:1000},function(){
						/* oTable1.fnClearTable(); */
						location.href = '${pageContext.request.contextPath}/manager/user/queryWanghongCount.do';
					});
				}else {
					layer.msg('提现失败', {
						icon : 2,
						time : 1000
					}, function(){
						location.reload();
					})
					 
				}
			}
		},'json');
	});
}
function cancelOrder(obj){
	layer.confirm('确认要取消订单吗？',function(index){
		var customerId = $(obj).attr("customerId");
		var orderId = $(obj).attr("id");
		$.post('${pageContext.request.contextPath}/manager/order/cancel.do',{orderId:orderId,customerId:customerId},function(data){
			if(data.code==0){
				if(data.result==true||data.result=='true'){
					layer.msg('已取消订单!',{icon:1,time:1000},function(){
						 oTable1.fnClearTable(); 
						
					});
				}
			}
		},'json');
	});
}
//确认返现
function cashback(obj){
	layer.confirm('确认订单已返现吗？',function(index){
		var customerId = $(obj).attr("customerId");
		var orderId = $(obj).attr("id");
		$.post('${pageContext.request.contextPath}/manager/order/cashback.do',{orderId:orderId,customerId:customerId},function(data){
			if(data.code==0){
				if(data.result==true||data.result=='true'){
					layer.msg('提现成功!',{icon:1,time:1000},function(){
						location.href = '${pageContext.request.contextPath}/manager/user/queryWanghongCount.do';
					});
				}
			}
		},'json');
	});
}
/**发货**/
function Delivery_stop(obj,id){
	layer.open({
        type: 1,
        title: '发货',
		maxmin: true, 
		shadeClose:false,
        area : ['500px' , ''],
        content:$('#Delivery_stop'),
		btn:['确定','取消'],
		yes: function(index, layero){		
		if($('#form-field-1').val()==""){
			layer.alert('快递号不能为空！',{
               title: '提示框',				
			  icon:0,		
			  }) 
			
			}else{			
			 layer.confirm('提交成功！',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style=" display:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="已发货"><i class="fa fa-cubes bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发货</span>');
		$(obj).remove();
		layer.msg('已发货!',{icon: 6,time:1000});
			});  
			layer.close(index);    		  
		  }
		
		}
	})
};
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form,.order_detailed').on('click', function(){
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

//初始化宽度、高度
$(".hide_style").height($(".hide_style").height()); 
 var heights=$(".hide_style").outerHeight(true)+90;  
 $(".widget-box").height($(window).height()-heights); 
$("#products_list").width($(window).width());
 $("#products_list").height($(window).height());
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height()-heights);
	 $(".table_menu_list").width($(window).width());
	  $(".table_menu_list").height($(window).height());
	})
//比例
var oldie = /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase());
			$('.easy-pie-chart.percentage').each(function(){
				$(this).easyPieChart({
					barColor: $(this).data('color'),
					trackColor: '#EEEEEE',
					scaleColor: false,
					lineCap: 'butt',
					lineWidth: 10,
					animate: oldie ? false : 1000,
					size:103
				}).css('color', $(this).data('color'));
			});
		
			$('[data-rel=tooltip]').tooltip();
			$('[data-rel=popover]').popover({html:true});
//订单列表
var oTable1;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/order/redOrderPage.do';
	oTable1 = $('#sample-table').dataTable( {
		"processing": true,  
        "serverSide": true,
		'ajax':{
			'url':url,
			'data': function (d) {
				d.startTime = $('#start').val();
				d.endTime = $('#end').val();
				d.userId = '${userId}';
				d.linered = '${linered}';
            },
			'dataSrc':function(data){
				for(var i=0;i<data.result.length;i++){
					data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
					var str = '';
					switch(data.result[i].status){//-1 下单失败 0 未付款 1未发货 2 未收货 3交易成功未评价 4交易成功已评价 5交易关闭
					case 1:
						str='已付款未结算';
						break;
					case 2:
						str='待发货';
						break;
					case 3:
						str='待收货';
						break;
					case 4:
						str='交易成功未评价';
						break;
					case 5:
						str='交易成功已评价';
						break;
					case 0:
						str='未付款';
						break;
					case -1:
						str='交易关闭';
						break;
					case -2:
						str='交易失败';
						break;
					}
					var st = '<span class="label label-success radius">'+str+'</span>';
					var handle = '';
					handle+='<a title="订单详细"  href="${pageContext.request.contextPath}/manager/order/details.do?id='+data.result[i].id+'&customerId='+data.result[i].customerId+'"  class="btn btn-xs btn-info order_detailed" ><i class="fa fa-list bigger-120"></i></a> ';
					var image = '';
					var mallOrderList = data.result[i].mallOrder;
					for(var j=0;j<mallOrderList.length;j++){
						image+= '<img class="productImage" src="${pageContext.request.contextPath}/image/showImage.do?image='+mallOrderList[j].product.imgSmall+'">';
					}
					switch(data.result[i].source){
					case 0:
						data.result[i].type = '自营';
						break;
					case 1:
						data.result[i].type = '分销';
						break;
					case 2:
						data.result[i].type = '代购';
						break;
					}
					data.result[i].image = image;
					data.result[i].st = st;
					
					if(data.result[i].cashbackStatus==1){
						data.result[i].cashbackStatus = '已返现';
					}else{
						data.result[i].cashbackStatus = '未返现';
						handle+='<a title="确认已返现"  href="javascript:void(0);" onclick="cashback(this);" customerId="'+data.result[i].customerId+'" id="'+data.result[i].id+'"  class="btn btn-xs btn-info order_detailed" ><i class="fa fa-recycle bigger-120"></i></a> ';
					}
					data.result[i].handle = handle;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'number' },
	        { data: 'image' },
	        { data: 'amountStr' },
	        { data: 'percent' },
	        { data: 'createTime' },
	        { data: 'contactPhone' },
	        { data: 'contactUser' },
	        { data: 'count'},
	        { data: 'type'},
	        { data: 'st'},
	        { data: 'cashbackStatus'},
	        { data: 'cashbackTime'},
	        { data: 'handle'}
	    ],
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7,8,9,10,11,12,13]}// 制定列不参与排序
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
		
		
		if($("#trade").html() == 0.0){
			$("#bton").css("display","none");
		}else{
			$("#bton").css("display","inline-block");
		}
</script>



</html>