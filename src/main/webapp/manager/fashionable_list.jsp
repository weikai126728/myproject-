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
    <!--   <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
      </ul> 
    </div>-->
     <div class="border clearfix" style="margin-top:10px;">
       <span class="l_f">
        <a href="${pageContext.request.contextPath}/manager/alliance/toAddFash.do" title="添加分账信息" class="btn btn-warning Order_form"><i class="icon-plus"></i>添加分账信息</a>
       </span>
      
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
           <th width="180">商户id</th>
          <th width="180">类型</th>
          <th width="80">账户</th>
          <th width="180px">商户名称</th>
          <th width="180">金额比例</th>
          <th width="80px">描述</th>
           <th width="80px">操作</th>
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
var handle;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/alliance/findfashionable.do';
		oTable1 = $('#sample-table').dataTable( {
			  "paging": true,  
	          "lengthChange": true,  
	          "searching": true,  
	          "aaSorting" : [[0, "asc"]], //默认的排序方式，第1列，升序排列  
	          "info": true,  
	          "autoWidth": false,  
	          "destroy":true,  
	          "processing":true,  
	          "scrollX": true,   //水平新增滚动轴  
// 			"searching" : false, 
	        "serverSide": true,
	        "select":true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.startTime = $('#start').val();
					d.endTime = $('#end').val();
					d.salesmanId = '${salesmanId}';
					search = d.search.value;
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
						handle = '<a  style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_delete(this)" href="javascript:;" title="分账删除"><span id="'+data.result[i].id+'" class="label radius"></span><i class="fa fa-close  bigger-120"></i></a>';
						data.result[i].handle =handle;
					}
				
					return data.result;
				}		
			},
			'columns': [
				{ data: 'ch' },
		        { data: 'product_id' },
		        { data: 'type' },
		        { data: 'account' },
		        { data: 'name' },
		        { data: 'amount' },
		        { data: 'description' },
		        { data: 'handle' },
		    ],
// 		"aaSorting": [[ 4, "desc" ]],//默认第几个排序
		"ordering": false,
		"bStateSave": false,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2]}// 制定列不参与排序
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
function excel(){
	var startTime = $('#start').val();
	var endTime = $('#end').val();
	var salesmanId = '${salesmanId}';
	location.href = '${pageContext.request.contextPath}/manager/alliance/amountExcel.do?startTime='+startTime+'&search='+search+'&endTime='+endTime+'&salesmanId='+salesmanId;
}

function member_delete(obj){
	var id = $(obj).find("span").attr("id");
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/alliance/deletfashionable.do',{id:id},function(data){
			if(data.result==true||data.result=='true'){
				layer.open({
				   content: '删除成功'
				   ,skin: 'msg'
				   ,time: 1 //2秒后自动关闭
				   ,success:function(){
					 document.location.href='${pageContext.request.contextPath}/manager/alliance/fashionable.do';
				   }
				});
			}else{
				layer.open({
  				   content: '修改失败'
  				   ,skin: 'msg'
  				   ,time: 1 //2秒后自动关闭
  				});
			}
		},'json');
		
	});
}
/*用户-启用*/
function member_start(obj){
	var id = $(obj).find("span").attr("id");
	layer.confirm('确认要启用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/alliance/enable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result=='true'){
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
</script>
</html>