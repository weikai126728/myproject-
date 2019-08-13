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

<style>
/* <div id="commission" style="display:none;">
	<div>
		<input type="checkbox"/><h5>超市</h5><input type="number"/>
	</div>
	<div>
		<input type="checkbox"/><h5>餐饮</h5><input type="number"/>
	</div>
	<div>
		<input type="checkbox"/><h5>住宿</h5><input type="number"/>
	</div>
</div> */
#commission input{ background-color: transparent; border: none; outline: none;}
#commission{ position: fixed; top: 50%; left: 50%; width: 300px; height: 300px; margin-top: -150px; margin-left: -150px; background-color: #FFFFFF; border:1px solid red;}
#commission h5{ display: inline-block; vertical-align: middle;}
#commission div input{ vertical-align: middle; margin-right: 5px; border: 1px solid #ccc;}
#commission div{ width: 300px; margin: 0 auto; text-align: center; padding-top: 30px;}
#commission .sub{ width: 100px; height: 30px; background-color: #6fb3e0; color: #FFFFFF; margin-top: 40px; margin-left: 30px;}
	

</style>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
 <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
		<li><label class="l_f">开始时间</label><input class="inline laydate-icon" id="startTime" style=" margin-left:10px;"></li>
       <li><label class="l_f">结束时间</label><input class="inline laydate-icon" id="endTime" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="icon-search"></i>查询</button></li>
      <!--  <li>
       <label class="l_f">佣金结算时间：</label>
       <input class="inline laydate-icon" id="startTime" style=" margin-left:10px;">
       <input class="inline laydate-icon" id="endTime" style=" margin-left:10px;">
       </li>
       <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="icon-search"></i>查询</button></li> -->
      </ul>
    </div>
    <div class="border clearfix" style="margin-top:10px;">
     	<span class="l_f"><button class="btn btn-warning Order_form" onClick="excel();">导出excel</button></span>
     	<span class="l_f"><button class="btn btn-warning Order_form" onClick="settlement();">佣金结算</button></span>
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
          <th width="120">商超编号</th>
           <th width="260px">商户openid</th>
          <th width="100px">姓名</th>
          <th width="130">商超名称</th>
          <th width="160px">联系方式</th>
          <th width="120px">已结算佣金</th>
          <th width="120px">未结算佣金交易额</th>
          <th width="120px">未结算佣金</th>
          <th width="120px">交易额</th>
          <th width="120px">交易笔数</th>
           <th width="120px">技术服务费</th>
          <th width="120px">推广会员数</th>
          <th width="100px">入驻时间</th>            
          <th width="340px">操作</th>
          </tr>
      </thead>
		<tbody>
        </tbody>
      </table>
    </div>
 </div>
</div>
<div id="commission" style="display:none;">
	<input type="button" class="sub" value="确定" onclick="save()"/><input class="sub" type="button" onclick="off()" value="取消" />
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
	var openId = $(obj).attr("openId");
	parent.iframe.location.href = '${pageContext.request.contextPath}/manager/alliance/trade.do?openId='+openId;
// 	layer_show("交易流水",'${pageContext.request.contextPath}/manager/alliance/trade.do?openId=${openId}');
};
function getTrading(obj){
	var product_id = $(obj).attr("product_id");
	parent.iframe.location.href = '${pageContext.request.contextPath}/manager/alliance/amount1.do?product_id='+product_id;
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
var oTable1;
var search,column,order;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/alliance/findByPage.do';
		oTable1 = $('#sample-table').dataTable( {
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.createTime = $('#start').val();
					d.startTime = $('#startTime').val();
					d.endTime = $('#endTime').val();
					search = d.search.value;
					column = d.order[0].column;
					order = d.order[0].dir;
	            },
				'dataSrc':function(data){
					$('#totalNo').html(data.totalNo/100);
					for(var i=0;i<data.result.length;i++){
						data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
						var handle = '<a product_id="'+data.result[i].product_id+'"  onClick="getTrading(this);" title="查看交易"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-line-chart bigger-120"></i></a>';
						handle += '<a openId="'+data.result[i].alopenid+'"  onClick="Guestbook_iew(this);" title="查看结算"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-line-chart bigger-120"></i></a>';
						handle += '<a product_id="'+data.result[i].product_id+'"  onClick="goodBoy(this);" title="佣金设置"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-percent bigger-120"></i></a>';
						handle += '<a product_id="'+data.result[i].product_id+'"  onClick="serviceFee(this);" title="技术服务费修改"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-percent bigger-120"></i></a>';
						handle += '<a product_id="'+data.result[i].product_id+'"  onClick="rout(this);" title="分账"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-percent bigger-120"></i></a>';
						data.result[i].handle = handle;
						if(data.result[i].noSettlementAmount){
							data.result[i].noSettlementAmount /=100; 
						}else{
							data.result[i].noSettlementAmount = 0;
						}
						if(data.result[i].setlement){
							data.result[i].setlement /=100;
						}else{
							data.result[i].setlement = 0;
						}
						if(data.result[i].hasSettlement){
							data.result[i].hasSettlement /=100;
						}else{
							data.result[i].hasSettlement = 0;
						}
						if(data.result[i].sumamount){
							data.result[i].sumamount /=100;
						}else{
							data.result[i].sumamount = 0;
						}
						if(data.result[i].servicefee){
							data.result[i].servicefee;
						}else{
							data.result[i].servicefee = 0;
						}
					}
					return data.result;
				}		
			},
			'columns': [
				{ data: 'ch' },
		        { data: 'product_id' },
		        { data: 'alopenid' },
		        { data: 'alname' },
		        { data: 'storename' },
		        { data: 'altel' },
		        { data: 'hasSettlement' },
		        { data: 'noSettlementAmount' },
		        { data: 'setlement' },
		        { data: 'sumamount' },
		        { data: 'countamount' },
		        { data: 'servicefee' },
		        {data:'countuser'},
		        {data:'createTime'},
		        { data: 'handle' },
		    ],
		"aaSorting": [[6, "desc" ]],//默认第几个排序
		"bStateSave": false,//状态保存
// 		"ordering": false,
		"aoColumnDefs": [
		  {"orderable":false,"aTargets":[0,1,2,3,4,5]}// 制定列不参与排序
		] } );
		$.fn.dataTable.ext.errMode = 'none';
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
/*  laydate({
    elem: '#start',
    event: 'focus' 
});
laydate({
    elem: '#end',
    event: 'focus' 
}); */
 laydate({
    elem: '#startTime',
    event: 'focus' 
});
 laydate({
    elem: '#endTime',
    event: 'focus' 
});
function excel(){
	var createTime = $('#start').val();
	location.href = '${pageContext.request.contextPath}/manager/alliance/allianceExcel.do?createTime='+createTime+'&search='+search+'&orderCol'+column+'&order='+order;
}
function settlement(){
	
	var r=confirm("确定要结算佣金吗？");
	if(r==true){
		var createTime = $('#start').val();
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		$.post('${pageContext.request.contextPath}/manager/alliance/settlement.do',{createTime:createTime,startTime:startTime,endTime:endTime,search:search,orderCol:column,order:order},function(data){
			if(data.code==0){
				if(data.result==true){
					alert('佣金结算成功！');
				}else{
					layer.open({
						title:'信息'
						,type:1
						,content:'失败'
					});
					alert('佣金结算失败！');
				}
			}else{
				alert('登陆超时！');
			}
		},'json');
	}
}
var product_id;
function goodBoy(obj){
	product_id = $(obj).attr('product_id');
	$.post('${pageContext.request.contextPath}/manager/alliance/typeByProductId.do',{product_id:product_id},function(data){
		$('#commission').html('');
		if(data.code==0){
			var result = data.result;
			var li = [],str;
			for(var i =0;i<result.length;i++){
				str = '<input type="checkbox"/>';
				if(result[i].pri_status&&result[i].pri_status==1){
					str='<input type="checkbox" checked/>';
				}
				li.push('<div>'+str+
						'<h5 id="'+result[i].business_type_id+'">'+result[i].typeName+'</h5><input type="number" value="'+result[i].percent+'"/>'+
						'</div>');				
			}
			li.push('<input type="button" class="sub" value="确定" onclick="save()"/><input class="sub" type="button" onclick="off()" value="取消" />');
			$('#commission').prepend(li.join(''));
			$('#commission').show();
		}
	},'json');
}
var product_id;
function serviceFee(obj){
	product_id = $(obj).attr('product_id');
	location.href ='${pageContext.request.contextPath}/manager/alliance/updateserviceFee.do?product_id='+product_id;
}
function off(){
	$('#commission').hide();
}
function save(){
	var divs = $('#commission').find('div');
	
	var data = [];
	for(var i=0;i<divs.length;i++){
		var input = $(divs[i]).find('input').first();
		var obj = {};
		obj.pri_status = input.prop('checked')?1:0;
		obj.business_type_id = input.next().attr('id');
		obj.percent = input.next().next().val();
		obj.product_id = product_id;
		data.push(obj);
	}
	$.post('${pageContext.request.contextPath}/manager/alliance/pri/insert.do',{array:JSON.stringify(data)},function(res){
		off();
		if(res.code==0){
			if(res.result==true){
				alert('操作成功！');
			}else{
				alert('操作失败！');
			}
		}
		
	},'json');
}

function rout(obj){
 var product_id = $(obj).attr('product_id');
 $.post('${pageContext.request.contextPath}/manager/alliance/addfash.do',{product_id:product_id},function(res){
		if(res.code==0){
			if(res.result==true){
				alert('操作成功！');
			}else{
				alert('操作失败！');
			}
		}
		
	},'json');
}
</script>
</html>