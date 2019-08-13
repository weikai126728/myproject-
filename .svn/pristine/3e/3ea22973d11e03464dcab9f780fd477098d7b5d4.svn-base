<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<style type="text/css">
		.market{
			cursor:pointer;
			margin-right:11px;
		}
		.market input{
			position:relative;
			bottom:-4px;
		}
		.market label{
			width:90px;
			text-overflow:ellipsis;
		}
		.margin{
			position:relative;
			width:710px;
			
		}
	</style>
</head>

<body>
<div class="margin clearfix">
<form action="${pageContext.request.contextPath}/manager/alliance/update.do" method="post">
<input type="hidden" name="userId" value="${userId}"/>
	<c:forEach var="alliance" items="${list}" varStatus="status">
		<span class="market"><input type="checkbox" name="alliances" value="${alliance.alid}" id="${alliance.alid}"><label for="${alliance.alid}"><nobr>${alliance.storename}</nobr></label></span>
	</c:forEach>
	<div>
		<input type="submit">
	</div>
</form>
</div>
</body>

<script type="text/javascript">
(function(){
	var rel = ${rel};
	if(rel&&rel.length){
		for(var i=0;i<rel.length;i++){
			$('#'+rel[i]).attr('checked','true');
		}
	}
})()
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
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						var handle = '<a openId="'+data.result[i].alopenid+'"  onClick="Guestbook_iew(this);" title="商超列表"  href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>';
						var st = '<span id="'+data.result[i].id+'" class="label label-success radius">审核通过</span>';
						if(data.result[i].status==0){//待审核
							st = '<span id="'+data.result[i].id+'" class="label radius">等待审核</span>';
							handle = '<a  style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this)" href="javascript:;" title="停用"><i class="fa fa-check  bigger-120"></i></a>'+handle;
						}
						data.result[i].handle = handle;
						data.result[i].st = st;
					}
					return data.result;
				}		
			},
			'columns': [
		        { data: 'id' },
		        { data: 'nickName' },
		        { data: 'openid' },
		        { data: 'phone' },
		        { data: 'address' },
		        {data:'createTime'},
		        {data:'st'},
		        { data: 'handle' },
		    ],
// 		"aaSorting": [[ 4, "desc" ]],//默认第几个排序
		"bStateSave": false,//状态保存
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
</script>
</html>