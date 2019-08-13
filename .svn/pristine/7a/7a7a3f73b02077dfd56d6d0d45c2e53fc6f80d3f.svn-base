<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>佣金列表</title>
</head>

<body>
<div class="margin clearfix">
 <div class="Guestbook_style">
<!--  <div class="search_style"> -->
<!--       <div class="title_names">搜索查询</div> -->
<!--       <ul class="search_content clearfix"> -->
<!--        <li> -->
<!--        	<select id="selectType"> -->
<!--        		<option selected value="0">超市</option> -->
<!--        		<option value="1">餐饮</option> -->
<!--        		<option value="2">住宿</option>       		 -->
<!--        	</select> -->
<!--        </li> -->
<!--        <li><label class="l_f">时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"><input class="inline laydate-icon" id="end" style=" margin-left:10px;"></li> -->
<!--        <li style="width:90px;"><button type="button" class="btn_search" onClick="oTable1.fnClearTable();"><i class="icon-search"></i>查询</button></li> -->
<!--       </ul> -->
<!--     </div> -->
    <div class="border clearfix" style="margin-top:10px;">
     	<span class="l_f"><button class="btn btn-warning Order_form" onClick="commission();">设置佣金比例</button></span>
     	<span class="l_f"><button class="btn btn-primary Order_form" onClick="javascript:location.href='${pageContext.request.contextPath}/manager/alliance/business/type.do'">管理商业类型</button></span>
     	<span class="l_f"><button class="btn btn-primary Order_form" onClick="javascript:location.href='${pageContext.request.contextPath}/manager/alliance/model.do'">管理加盟方式</button></span>
     </div>
    <!--留言列表-->
    <div class="Guestbook_list">
      <table class="table table-striped table-bordered table-hover" id="sample-table">
      <thead>
		 <tr>
          <th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
          <th width="180">类型</th>
          <th width="80px">加盟方式</th>
          <th width="180">比例/1000</th>       
<!--           <th width="250">操作</th> -->
          </tr>
      </thead>
		<tbody>
        </tbody>
      </table>
    </div>
 </div>
</div>
<div id="selectId" style="display:none;text-align:center;">
<select id="first" onchange="sele()">
<c:forEach var="type" items="${typeList}" varStatus="status">
	<option value="${type.id}">${type.name}</option>
</c:forEach>
</select>
<select id="second" onchange="sele()">
<c:forEach var="model" items="${modelList}" varStatus="status">
	<option value="${model.id}">${model.name}</option>
</c:forEach>
</select>
<input id="percent" value="${percent}"/>
</div>
</body>

<script type="text/javascript">
var oTable1;
var search,column,order,type;
jQuery(function($) {
	var url = '${pageContext.request.contextPath}/manager/alliance/commission/page.do';
		oTable1 = $('#sample-table').dataTable( {
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					d.startTime = $('#start').val();
					d.endTime = $('#end').val();
					search = d.search.value;
					column = d.order[0].column;
					order = d.order[0].dir;
					type = $('#selectType').val();
					d.type = type;
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
					}
					return data.result;
				}		
			},
			'columns': [
				{ data: 'ch' },
		        { data: 'businessType' },
		        { data: 'model' },
		        { data: 'percent' },
// 		        { data: 'handle' },
		    ],
		"aaSorting": [[1, "desc" ]],//默认第几个排序
		"bStateSave": false,//状态保存
// 		"ordering": false,
		"aoColumnDefs": [
		  {"orderable":false,"aTargets":[0,3]}// 制定列不参与排序
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
function commission(){
	layer.open({
		  type:1
		  ,title:'佣金设置'
		  ,area : ['300px' , '']
		  ,content: $('#selectId')
		  ,btn: ['确定', '取消']
		  ,yes: function(index, layero){
		    $.post('${pageContext.request.contextPath}/manager/alliance/commission/edit.do',{typeId:$('#first').val(),modelId:$('#second').val(),percent:$('#percent').val()},function(data){
				var msg ='登陆超时！';
		    	if(data.code==0){
					if(data.result==true){
						msg = '修改成功！';
						
					}else{
						msg = '修改失败！';
					}
				}
		    	layer.msg(msg,{icon: 6,time:1000},function(){
				    layer.closeAll();
				    location.reload();
				});
		    },'json');
		  }
		  ,end:function(index, layero){
			  $('#name').val('');
			  $('#details').val('');
		  }
		});
}
function sele(){
	var typeId = $('#first').val();
	var modelId = $('#second').val();
	$.post('${pageContext.request.contextPath}/manager/alliance/typeAndmodel.do',{typeId:typeId,modelId:modelId},function(data){
		if(data.code==0){
			$('#percent').val(data.result);
		}
	},'json')
}
</script>
</html>