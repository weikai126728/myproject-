<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/common/layui/css/layui.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.js"></script>
<link
	href="${pageContext.request.contextPath}/manager/assets/css/codemirror.css"
	rel="stylesheet">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
	<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
	<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	<script src="assets/js/jquery.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='${pageContext.request.contextPath}/manager/assets/js/jquery-2.0.3.min.js'>"
								+ "<" + "/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='${pageContext.request.contextPath}/manager/assets/js/jquery.mobile.custom.min.js'>"
							+ "<" + "/script>");
	</script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
	<!-- page specific plugin scripts -->
	<script
		src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script>
	<script
		src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"
		type="text/javascript"></script>
		
	<script
		src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js"
		type="text/javascript"></script>
	<title>商城意见</title>
</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				 
				<!-- -->
				<div class="border clearfix">
					<span class="l_f"> 
					</span> <span class="r_f">共&nbsp;<b>${count }</b>&nbsp;条
					</span>
				</div>
				<!--  -->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="60">ID</th>
								<th width="80">姓名</th>
								<th width="100">手机</th>
								<th width="150">邮箱</th>
								<th width="180">留言信息</th>
								<th width="120">留言时间</th> 
								<th width="80">操作</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:forEach items="${opinionList }" var="list">
								<tr>
									<td><label> <input type="checkbox" class="ace">
												<span class="lbl"></span></label></td>
									<td id="id">${list.id }</td>
									<td> ${list.name }	</td>
									<td>${list.phone }</td>
									<td>${list.message }</td>
									<td>${list.problemType }</td>
									<td>${list.createTime }</td>
									<td><a href="javascript:;" onclick="member_del(this,'${list.id}')" title="删除" class="btn btn-xs btn-warning"><i class="fa fa-trash  bigger-120">删除</i></a></td>
									 
								</tr>

							</c:forEach> --%>
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
		var url = '${pageContext.request.contextPath}/company/opinion/findByType.do';
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
					 
					var handle = '<a title="删除" href="javascript:;"  onclick="member_del(this,'+data.result[i].id+')" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>';
					 
					data.result[i].handle = handle;
					 
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'id' },
	        { data: 'name' },
	        { data: 'phone' },
	        { data: 'email' },
	        { data: 'message' },
	        { data: 'createTime'},
	        { data: 'handle'}
	    ],
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,7]}// 制定列不参与排序
		] } );
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox').each(function(){
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
	/* jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 6 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});

		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}
	}) */
	 
	/* 用户-删除 */
	 function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			$.post("${pageContext.request.contextPath}/company/opinion/deleteById.do",{opinionId : id},function(data) {
				if(data.result == "true"){
					$(obj).parents("tr").remove();
					layer.msg('已删除!', {icon: 1,time: 1000}); 
				 }else{
					 layer.msg('删除失败!', {icon: 2,time: 1000});
				 }
			}, "json");

		});
	} 
	laydate({
		elem : '#start',
		event : 'focus'
	});
</script>