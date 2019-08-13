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
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script>
<title>消息列表</title>
		<style type="text/css">
			#Validform_msg{
				display:none;
			}
		</style>
</head>
<body>
<div class=" page-content clearfix">
 <div id="products_style">
     <div class="border clearfix" style="margin-top:10px;">
       <span class="l_f">
<!--         <a href="javascript:void(0);" title="添加广播" class="btn btn-warning Order_form"><i class="icon-plus"></i>添加广播</a> -->
        <a href="javascript:void(0);" class="btn btn-danger" id="batchDel"><i class="icon-trash"></i>批量删除</a>
       </span>
     </div>
     <!--产品列表展示-->
     <div class="h_products_list clearfix" id="products_list" >
         <div class="table_menu_list" id="testIframe" style="float:left;margin-left:0px;">
	       <table class="table table-striped table-bordered table-hover" id="sample-table">
			<thead>
			 <tr>
					<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
					<th width="100px">标题</th>
					<th width="200px">详细内容</th>
					<th width="100px">创建人</th>
	                <th width="100px">创建时间</th>				
					<th width="100px">修改时间</th>
					<th width="70px">状态</th>                
					<th width="100px">操作</th>
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
</html>
<script>
var oTable1;
var typeId = '${typeId}';
if(typeId==''){
	typeId=null;
}
jQuery(function($) {
		
		var url = '${pageContext.request.contextPath}/manager/tidings/findByPage.do';
		oTable1 = $('#sample-table').dataTable( {
		"processing": true,  
        "serverSide": true,
		'ajax':{
			'url':url,
			'data': function (d) {
                d.typeId = typeId;
            },
			'dataSrc':function(data){
				for(var i=0;i<data.result.length;i++){
					data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
					var st = '<span class="label label-success radius">已启用</span>';
					var handle = '<a onClick="member_stop(this)"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a>'
			        +'<a title="编辑" onclick="member_edit(this)" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a>' 
			        +'<a title="删除" href="javascript:;"  onclick="member_del(this)" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>';
					if(data.result[i].flag==0){
						st = '<span class="label radius">已停用</span>';
						handle = '<a onClick="member_start(this)"  href="javascript:;" title="启用"  class="btn btn-xs"><i class="icon-ok bigger-120"></i></a>'
				        +'<a title="编辑" onclick="member_edit(this)" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a>' 
				        +'<a title="删除" href="javascript:;"  onclick="member_del(this)" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>';
					}
					data.result[i].flag = st;
					data.result[i].handle = handle;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'name' },
	        { data: 'details' },
	        { data: 'author' },
	        { data: 'createTime' },
	        { data: 'updateTime'},
	        { data: 'flag'},
	        { data: 'handle'}
	    ],
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,7]}// 制定列不参与排序
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
//  laydate({
//     elem: '#start',
//     event: 'focus' 
// });
$(function() { 
	$("#products_style").fix({
		'float' : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false,
		spacingw:30,//设置隐藏时的距离
	    spacingh:260,//设置显示时间距
	});
});
</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()-100); 
$(".table_menu_list").width($(window).width());
 $(".table_menu_list").height($(window).height()-100);
 $(".h_products_list").height($(window).height()-100);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height()-100);
	 $(".table_menu_list").width($(window).width());
	  $(".table_menu_list").height($(window).height()-100);
	  $(".h_products_list").height($(window).height()-100);
	})
 
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
			
/*产品-停用*/
function member_stop(obj){
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要停用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/tidings/disable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("td").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
					$(obj).parents("td").prev().html('<span class="label label-defaunt radius">已停用</span>');
					$(obj).remove();
					layer.msg('已停用!',{icon: 5,time:1000});
				}
			}
		},'json');
		
	});
}

/*产品-启用*/
function member_start(obj){
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要启用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/tidings/enable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("td").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
					$(obj).parents("td").prev().html('<span class="label label-success radius">已启用</span>');
					$(obj).remove();
					layer.msg('已启用!',{icon: 6,time:1000});	
				}
			}
		},'json');
		
	});
}
/*产品-编辑*/
function member_edit(obj){
	var td = $(obj).parents('tr').find('td');
	var id = td.eq(0).find('label').attr("id");
	var url = '${pageContext.request.contextPath}/manager/tidings/to/update.do?id='+id;
	var title = td.eq(2).html();
	layer_show(title,url);
}

/*产品-删除*/
function member_del(obj){
	if($(obj).prev().prev().hasClass('btn-success')){
		layer.msg('只能删除禁用状态的数据！');
		return false;
	}
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/tidings/delete.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				}
			}
		},'json');
		
	});
}

$('#batchDel').on('click',function(){
	var ids='';
	var d = '';
	$('tbody :checked').each(function(){
		ids += d;
		d=",";
		ids += $(this).parents('label').attr('id');
	});
	$.post('${pageContext.request.contextPath}/manager/tidings/batchDelete.do',{ids:ids},function(data){
		if(data.code==0){
			if(data.result==true){
				layer.msg("批量删除成功！", {icon: data.code,time: 2000},function(){
					oTable1.fnClearTable();
				});
			}else{
				layer.msg("批量删除失败！", {icon: data.code,time: 2000}); 
			}
		}
	},'json');
});
</script>