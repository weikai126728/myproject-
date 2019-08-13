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
	.check-order{
		background:url(${pageContext.request.contextPath}/manager/images/ok.png) no-repeat center center;
		display:inline-block;
		width:13px;
		height:11px;
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
<!--        <li><label class="l_f">订单编号</label><input name="" type="text" class="text_add" placeholder="订单订单编号" style=" width:250px"></li> -->
       <li><label class="l_f">时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="fa fa-search"></i>查询</button></li>
      </ul>
    </div>
    <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:void(0)" class="btn btn-danger" onClick="settlementBatch();"><i class="icon-trash"></i>第三方批量结算</a>
       </span>
<!--        <span class="r_f">共：<b>2334</b>件商品</span> -->
     </div>
     <!--订单列表展示-->
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="120px">订单编号</th>
				<th width="250px">产品名称</th>
				<th width="100px">总价</th>
<!-- 				<th width="100px">优惠</th> -->
                <th width="180px">订单时间</th>				
				<th width="180px">联系电话</th>
				<th width="80px">联系人</th>
                <th width="80px">数量</th>
                <th width="80px">类型</th>
                <th width="80px">实际金额</th>
                <th width="80px">买家修改</th>
				<th width="70px">状态</th>                
				<th width="200px">操作</th>
			</tr>
		</thead>
	<tbody>
     
     </tbody>
     </table>
   </div>
  </div>
 </div>
 
 <div id="Delivery_stop" style=" display:none">
  <div class="">
    <div class="content_style">
  <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">快递公司 </label>
       <div class="col-sm-9"><select class="form-control" id="form-field-select-1">
																<option value="">--选择快递--</option>
																<option value="1">天天快递</option>
																<option value="2">圆通快递</option>
																<option value="3">中通快递</option>
																<option value="4">顺丰快递</option>
																<option value="5">申通快递</option>
																<option value="6">邮政EMS</option>
																<option value="7">邮政小包</option>
																<option value="8">韵达快递</option>
															</select></div>
	</div>
   <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 快递号 </label>
    <div class="col-sm-9"><input type="text" id="form-field-1" placeholder="快递号" class="col-xs-10 col-sm-5" style="margin-left:0px;"></div>
	</div>
    <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">货到付款 </label>
     <div class="col-sm-9"><label><input name="checkbox" type="checkbox" class="ace" id="checkbox"><span class="lbl"></span></label></div>
	</div>
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
/*订单-删除*/
function Order_form_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
/**发货**/
function Delivery_stop(obj){
	var orderId = $(obj).attr("orderId");
	layer.confirm('确认结算？', {
		  btn: ['确认', '取消'] //可以无限个按钮
		}, function(index, layero){
		  $.post('${pageContext.request.contextPath}/manager/order/settlement.do',{orderIDs:orderId},function(data){
			  if(data.code==0){
				  if(data.result.success==true){
					  layer.closeAll();
					  layer.open({
						  type: 2,
						  title: '支付宝收银台',
						  shadeClose: true,
						  shade: 0.8,
						  area: ['100%', '90%'],
						  content: data.result.payUrl //iframe的url
						}); 
				  }else{
					  layer.alert(data.result.errorMsg, {
						  icon: 1,
						  skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
						})
				  }
			  }
		  },'json');
		}, function(index){
		  //按钮【按钮二】的回调
	});
};
function check_order(obj){
	var orderId = $(obj).parents("tr").find("td:first label").attr("id");
	var customerId = $(obj).parents("tr").find("td:first label").attr("customerId");
	layer.confirm('确认收款？', {
		  btn: ['确认', '取消'] //可以无限个按钮
		}, function(index, layero){
		  $.post('${pageContext.request.contextPath}/manager/order/checkOrder.do',{orderId:orderId,customerId:customerId},function(data){
			  if(data.code==0){
				  if(data.result==true){
					  layer.closeAll();
					  layer.alert("操作成功！", {
						  icon: 1,
						  skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
						});
					  oTable1.fnClearTable();
				  }else{
					  layer.alert(data.result.errorMsg, {
						  icon: 1,
						  skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
						})
				  }
			  }
		  },'json');
		}, function(index){
		  //按钮【按钮二】的回调
	});
}
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
	var url = '${pageContext.request.contextPath}/manager/order/findNoSettlementByPage.do';
	oTable1 = $('#sample-table').dataTable( {
		"processing": true,  
        "serverSide": true,
		'ajax':{
			'url':url,
			'data': function (d) {
//                 d.typeId = typeId;
				d.createTime = $('#start').val();
            },
			'dataSrc':function(data){
				for(var i=0;i<data.result.length;i++){
					data.result[i].ch = '<label id="'+data.result[i].id+'" customerId="'+data.result[i].customerId+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
					var st = '<span class="label label-important radius">未发货未结算</span>';
					var handle = '';
					switch(data.result[i].status){//-2关闭交易-1 下单失败 0 未付款 1未发货未结算 2未发货已结算  3未收货 4交易成功未评价 5交易成功已评价
					case 1:
						if(data.result[i].alibaba){
							handle = '<a orderID="'+data.result[i].alibaba.orderID+'" onClick="Delivery_stop(this)"  href="javascript:;" title="结算"  class="btn btn-xs btn-success"><i class="fa fa-cubes bigger-120"></i></a>';							
						}else{
							handle = '<a onClick="check_order(this)"  href="javascript:void(0);" title="确认收款"  class="btn btn-xs btn-success"><i class="check-order"></i></a>';	
						}
						break;
					case 2:
						st = '<span class="label label-success radius">未发货已结算</span>';
						break;
					}
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
					if(!data.result[i].successAmount){
						data.result[i].successAmount = '';
					}
					if(!data.result[i].updateTotalAmount){
						data.result[i].updateTotalAmount = '';
					}
					data.result[i].image = image;
					data.result[i].st = st;
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
// 	        { data: 'details' },
	        { data: 'createTime' },
	        { data: 'contactPhone' },
	        { data: 'contactUser' },
	        { data: 'count'},
	        { data: 'type'},
	        { data: 'successAmount'},
	        { data: 'updateTotalAmount'},
	        { data: 'st'},
	        { data: 'handle'}
	    ],
// 	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7,8,9,10,11,12]}// 制定列不参与排序
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
//第三方批量结算
function settlementBatch(){
	var ids = '';
	var g = '';
	$('tbody :checked').each(function(){
		var orderId = $(this).parents('tr').find('td').eq(9).find('a:first').attr('orderId');
		if(orderId){
			ids += g;
			g = ',';
			ids += orderId;
		}
	});
	console.log(ids);
}
</script>
</html>