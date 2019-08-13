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
<title>留言</title>
</head>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
 <div class="search_style">
      <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
<!--        <li><label class="l_f">留言</label><input name="" type="text" class="text_add" placeholder="输入留言信息" style=" width:250px"></li> -->
       <li><label class="l_f">时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
          <th width="180">评价产品</th>
          <th width="80px">用户名</th>
          <th width="200px">留言内容</th>
          <th width="180px">留言时间</th>
          <th width="200px">回复内容</th>
          <th width="180px">回复时间</th>
          <th width="80px">回复人</th>
          <th width="70">状态</th>                
          <th width="250">操作</th>
          </tr>
      </thead>
		<tbody>
        </tbody>
      </table>
    </div>
 </div>
</div>
<!--留言详细-->
<div id="Guestbook" style="display:none">
 <div class="content_style">
  <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">评价用户 </label>
       <div class="col-sm-9 user-name"></div>
	</div>
   <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1"> 评价内容 </label>
       <div class="col-sm-9 evaluate-describe"></div>
	</div>
    <div class="form-group"><label class="col-sm-2 control-label no-padding-right" for="form-field-1">是否回复 </label>
       <div class="col-sm-9">
       <label><input name="checkbox" type="checkbox" class="ace" id="checkbox"><span class="lbl"> 回复</span></label>
       <div class="Reply_style">
          <textarea name="权限描述" class="form-control" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea>
          <span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span>
       </div>
       </div>
	</div>
 </div>
</div>
</body>

<script type="text/javascript">
 /*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url+'#?='+id,w,h);
}
/*留言-删除*/
function member_del(obj){
	var id = $(obj).parents('tr').find('td:first label').attr('id');
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/evaluate/delete.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					layer.msg('已删除!',{icon:1,time:1000},function(){
						oTable1.fnClearTable();
					});
				}
			}
		},'json');
	});
}
//审核
function pass(obj){
	var id = $(obj).parents('tr').find('td:first label').attr('id');
	layer.confirm('确认要审核通过吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/evaluate/pass.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents('td').prev().find('span').html('审核通过');
					$(obj).parents('td').prev().find('span').removeClass('label-important').addClass('label-success');
					$(obj).remove();
					layer.msg('已通过!',{icon:1,time:1000});
				}
			}
		},'json');
	});
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
	var id = $(obj).parents('tr').find('td:first label').attr('id');
	var username = $(obj).parents('tr').find('td').eq(2).html();
	$('#Guestbook').find('.user-name').html(username);
	var describe = $(obj).parents('tr').find('td').eq(3).html();
	$('#Guestbook').find('.evaluate-describe').html(describe);
	var index = layer.open({
        type: 1,
        title: '评价信息',
		maxmin: true, 
		shadeClose:false,
        area : ['600px' , ''],
        content:$('#Guestbook'),
		btn:['确定','取消'],
		yes: function(index, layero){		 
		  if($('input[name="checkbox"]').prop("checked")){			 
			 if($('.form-control').val()==""){
				layer.alert('回复内容不能为空！',{
               title: '提示框',				
			  icon:0,		
			  }) 
			 }else{			
			      layer.alert('确定回复该内容？',{
				   title: '提示框',				
				   icon:0,	
				   btn:['确定','取消'],	
				   yes: function(index){
					   var reply = $('#form_textarea').val();
					   	$.post('${pageContext.request.contextPath}/manager/evaluate/reply.do',{id:id,reply:reply},function(data){
					   		if(data.code==0){
					   			if(data.result==true){
									layer.msg("回复成功！",{time:1000},function(){
								    	layer.closeAll();
								    	oTable1.fnClearTable();
									})					   				
					   			}else{
					   				layer.msg("回复失败！",{time:1000});
					   			}
					   		}
					   	},'json');
					   }
				  }); 		  
		   }			
	      }else{			
			 layer.alert('是否要取消回复！',{
               title: '提示框',				
			icon:0,		
			  }); 
			  layer.close(index);      		  
		  }
	   },
	   cancel:function(index, layero){
		   $('#Guestbook').find('.user-name').html('');
		   $('#Guestbook').find('.evaluate-describe').html('');
		   $('#form_textarea').val('');
		   if($('input[name="checkbox"]').prop("checked")){
			   $('input[name="checkbox"]').click();
		   }
		   $('#sy').html('200');
	   }
	})	
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
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/evaluate/findByPage.do';
		oTable1 = $('#sample-table').dataTable( {
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.createTime = $('#start').val();
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
						var st = '<span class="label label-success radius">审核通过</span>';
						var handle = '<a  onClick="Guestbook_iew(this);" title="回复"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>'     
				        +'<a  href="javascript:;"  onclick="member_del(this)" title="删除" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>';
						switch(data.result[i].status){//-1 下单失败 0 未付款 1未发货 2 未收货 3交易成功未评价 4交易成功已评价 5交易关闭
						case 1:
							st = '<span class="label label-important radius">未审核</span>';
							handle = '<a onClick="pass(this)"  href="javascript:;" title="审核"  class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i></a>'+handle;
							break;
						case 2:
							st = '<span class="label label-success radius">已审核</span>';
							
							break;
						}
						data.result[i].st = st;
						data.result[i].handle = handle;
						if(!data.result[i].reply){
							data.result[i].reply='<em style="color:red;">未回复</em>';
						}
						if(!data.result[i].replyTime){
							data.result[i].replyTime ='';
						}
						if(!data.result[i].replyAuthor){
							data.result[i].replyAuthor='';
						}
					}
					return data.result;
				}		
			},
			'columns': [
				{ data: 'ch' },
		        { data: 'product.productName' },
		        { data: 'customer.nickName' },
		        { data: 'describe' },
		        { data: 'createTime' },
		        {data:'reply'},
		        {data:'replyTime'},
		        {data:'replyAuthor'},
		        { data: 'st' },
		        { data: 'handle' },
		    ],
		"aaSorting": [[ 4, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,5,6,7,8,9]}// 制定列不参与排序
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
</script>
</html>