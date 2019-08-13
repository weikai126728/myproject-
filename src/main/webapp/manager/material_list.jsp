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
<title>临时素材列表</title>
	<style type="text/css">
		table img{
			width:50px;
			height:50px;
		}
	</style>
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
       <span class="l_f">
        <a href="${pageContext.request.contextPath}/manager/material/toAdd.do" title="添加临时素材" class="btn btn-warning Order_form"><i class="icon-plus"></i>添加临时素材</a>
       </span>
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="180">素材</th>
          <th width="80px">meida-id</th>
          <th width="200px">类型</th>
          <th width="200px">作者</th>
          <th width="200px">内容</th>
          <th width="200px">时间</th>         
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

function member_stop(obj){
	var id = $(obj).parents('td').prev().find("span").attr("id");
	layer.confirm('确认要停用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/material/disable.do',{id:id},function(data){
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
var oTable1;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/material/findByPage.do';
		oTable1 = $('#sample-table').dataTable( {
			"searching":false,
			"ordering":false,
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
						var img = '<img src="${pageContext.request.contextPath}/image/showImage.do?image='+data.result[i].image_url+'"/>';
						data.result[i].img = img;
						var handle = '<a id="'+data.result[i].id+'"  onClick="del(this);" title="删除"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-trash bigger-120"></i></a>'
						+'<a id="'+data.result[i].id+'"  onClick="preview(this);" title="发送预览"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-eye bigger-120"></i></a>'
						+'<a id="'+data.result[i].id+'"  onClick="sendAll(this);" title="消息群发"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-group bigger-120"></i></a>';
						data.result[i].handle = handle;
					}
					return data.result;
				}		
			},
			'columns': [
		        { data: 'img' },
		        { data: 'media_id' },
		        { data: 'type' },
		        { data: 'author' },
		        { data: 'content' },
		        { data: 'created_at' },
		        { data: 'handle' },
		    ],
		"bStateSave": false,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,5,6]}// 制定列不参与排序
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
function del(obj){
	var id = $(obj).attr('id');
	$.post('${pageContext.request.contextPath}/manager/material/delete.do',{id:id},function(data){
		if(data.code==0){
			if(data.result==true||data.result=='true'){
				layer.open({
				  content: '删除成功！',
				  success: function(){
					  oTable1.fnClearTable();
				  }
				});      
			}else{
				layer.open({
				  content: '删除失败！',
				  success: function(){
					  oTable1.fnClearTable();
				  }
				});
			}
		}
	},'json');
}
function preview(obj){
	var id = $(obj).attr('id');
	var name=prompt("请输入发送对象的OPENID","");
	if(name.replace(/^\s+|\s+$/g,'')==''){
		layer.open({
			  content: '请录入OPENID！'
		}); 
		return false;
	}
	  $.post('${pageContext.request.contextPath}/manager/material/preview.do',{id:id,openid:name},function(data){
		  if(data.code==0){
				if(data.result==true||data.result=='true'){
					layer.open({
					  content: '发送预览成功！'
					});      
				}else{
					layer.open({
					  content: '发送预览失败！'
					});
				}
			}
	  },'json');
}
//群发消息
function sendAll(obj){
	var id = $(obj).attr('id');
	$.post('${pageContext.request.contextPath}/manager/material/sendAll.do',{id:id},function(data){
		if(data.code==0){
			if(data.result==true||data.result=='true'){
				layer.open({
				  content: '群发成功！'
				});      
			}else{
				layer.open({
				  content: '群发失败！'
				});
			}
		}
	},'json');
}
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