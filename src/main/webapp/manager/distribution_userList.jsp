<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<title>用户列表</title>
</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>


					<ul class="search_content clearfix">
						<li><label class="l_f">会员名称</label><input name="name"
							id="seleName" type="text" class="text_add"
							placeholder="可根据用户名、手机号、编号查询" style="width: 400px" /></li>
						<!-- <li><label class="l_f">添加时间</label><input
							class="inline laydate-icon" id="seleTime" name="time"
							style="margin-left: 10px;"></li> -->
						<li style="width: 90px;"><button type="button"
								onclick="selectUser('1300','600')" class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>

				</div>
				<!-- -->
				<div class="border clearfix">
					<span class="r_f">共&nbsp;<b>${count }</b>&nbsp;条
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
								<th width="80">ID</th>
								<th width="100">编号</th>
								<th width="120">用户名</th>
								<th width="120">手机号码</th>
								<th width="100">余额</th>
								<th width="100">佣金</th>
								<th width="250">注册时间</th>
								<th width="250">注册IP</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:forEach items="${udList }" var="user">
								<tr>
									<td><label> <input type="checkbox" class="ace">
												<span class="lbl"></span></label></td>
									<td id="id">${user.id }</td>
									<td>${user.no }</td>
									<td>${user.name }</td>
									<td>${user.phone }</td>
									<td>${user.balance }</td>
									<td>${user.commission }</td>
									<td>${user.createDate }</td>
									<td>${user.registerIp }</td>
									<c:if test="${user.status==1 }">
										<td class="td-manage"><a 
											onClick="member_stop(this,'${user.id}')" href="javascript:;"
											title="停用" class="btn btn-xs btn-success"><i
												class="bigger-120">停用</i></a> <em
											style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>
											<a title="删除" href="javascript:;"
											onclick="member_del(this,'${user.id}')"
											class="btn btn-xs btn-warning"><i
												class="bigger-120">删除</i></a></td>
									</c:if>
									<c:if test="${user.status==0 }">
										<td class="td-manage"><a style="text-decoration: none"
											class="btn btn-xs " onClick="member_start(this,'${user.id}')"
											href="javascript:;" title="启用"><i
												class="bigger-120">启用</i></a> <em
											style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>
											<a title="删除" href="javascript:;"
											onclick="member_del(this,'${user.id}')"
											class="btn btn-xs btn-warning"><i
												class="bigger-120">删除</i></a></td>
									</c:if>
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
		var url = '${pageContext.request.contextPath}/distribution/user/findByType.do';
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
					var handle = '<a onClick="member_stop(this,'+data.result[i].id+')" href="javascript:;" title="停用" class="btn btn-xs btn-success"><i	class="bigger-120">停用</i></a>'
					+'<em style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>'
					+'<a title="删除" href="javascript:;" onclick="member_del(this,'+data.result[i].id+')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>';
					 if(data.result[i].status==0){
						handle='<a style="text-decoration: none" class="btn btn-xs " onClick="member_start(this,'+data.result[i].id+')"	href="javascript:;" title="启用"><i class="bigger-120">启用</i></a>'
						+'<em style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>'
						+'<a title="删除" href="javascript:;" onclick="member_del(this,'+data.result[i].id+')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>';
					} 
					
					data.result[i].handle = handle;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'id' },
	        { data: 'no' },
	        { data: 'name' },
	        { data: 'phone' },
	        { data: 'balance' },
	        { data: 'commission'},
	        { data: 'createDate'},
	        { data: 'registerIp'},
	        { data: 'handle'}
	    ],
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,6,7,8,9]}// 制定列不参与排序
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
	 
/* 	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 6, 7, 8, 9 ]
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

	/*用户-停用*/
	function member_stop(obj, id) {
		layer
				.confirm(
						'确认要停用吗？',
						function(index) {
							/* layer.closeAll('dialog'); */
							//发送ajax
							$
									.post(
											//提交的路径	
											"${pageContext.request.contextPath}/distribution/user/stop.do",
											//提交的参数
											{
												userId : id
											},
											//返回的结果函数
											function(data) {
												if (data.result == 'true') {
													$(obj)
															.parents("tr")
															.find(".td-manage")
															.prepend(
																	'<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,'
																			+ id
																			+ ')" href="javascript:;" title="启用"><i class="bigger-120">启用</i></a>');
													$(obj).remove();
													layer.msg('已停用!', {
														icon : 5,
														time : 1000
													});
												} else {
													layer.msg('停用失败', {
														icon : 2,
														time : 1000
													})
												}
											}, "json");
						});
	}

	/*用户-启用*/
	function member_start(obj, id) {
		layer
				.confirm(
						'确认要启用吗？',
						function(index) {
							/* 	layer.closeAll('dialog'); */
							//发送ajax
							$
									.post(
											//提交的路径
											"${pageContext.request.contextPath}/distribution/user/start.do",
											//提交的参数
											{
												userId : id
											},
											//返回的结果函数
											function(data) {
												//如果返回的结果不为空
												if (data.result == 'true') {
													$(obj)
															.parents("tr")
															.find(".td-manage")
															.prepend(
																	'<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,'
																			+ id
																			+ ')" href="javascript:;" title="停用"><i class="bigger-120">停用</i></a>');
													$(obj).remove();
													layer.msg('已启用!', {
														icon : 6,
														time : 1000
													});
												} else {
													layer.msg('启用失败', {
														icon : 2,
														time : 1000
													})
												}
											}, "json");
						});
	}

	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发送ajax
			$.post(
			//提交的路径	
			"${pageContext.request.contextPath}/distribution/user/deleteById.do",
			//提交的参数
			{
				userId : id
			},
			//返回的结果函数
			function(data) {
				//如果返回的结果不为空
				if (data.result == "true") {
					$(obj).parents("tr").remove();
					layer.msg('已删除!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.msg('删除失败!', {
						icon : 2,
						time : 1000
					});
				}
			}, "json");
		});
	}

	/*用户-查询*/
	function selectUser(w, h) {
		var url = '${pageContext.request.contextPath}/distribution/user/selectUserBy.do?name='
				+ $("#seleName").val();
		var title = '搜索结果';
		layer_show(title, url, w, h);
	}
	laydate({
		elem : '#start',
		event : 'focus'
	});
</script>