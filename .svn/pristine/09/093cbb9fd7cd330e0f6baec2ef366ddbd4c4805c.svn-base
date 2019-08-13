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
						<li><label class="l_f">超市名称</label><input name="name"
							id="seleName" type="text" class="text_add" placeholder="输入超市名称"
							style="width: 400px" /></li>
						<!-- <li><label class="l_f">添加时间</label><input
							class="inline laydate-icon" id="seleTime" name="time"
							style="margin-left: 10px;"></li> -->
						<li style="width: 90px;"><button type="button"
								onclick="selectMarket('1300','600')" class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>

				</div>
		<div class="border clearfix" style="margin-top:10px;">
       <span class="l_f">
        <a href="${pageContext.request.contextPath}/manager/market/toAdd.do" title="添加商品" class="btn btn-warning Order_form"><i class="icon-plus"></i>添加商品</a>
<!--         <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a> -->
       </span>
      
     </div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="${pageContext.request.contextPath}/manager/market/goAdd.do"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>新增超市</a>
						<a href="javascript:ovid()" class="btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
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
								<th width="80">ID</th>
								<th width="120">商品图片</th>
								<th width="100">商品名称</th>
								<th width="120">商品描述</th>
								<th width="120">所属店铺</th>
								<th width="180">商品图片轮播</th>
								<th width="180">商品图片详情图</th>
								<th width="250">商品状态</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							 <c:forEach items="${ProList }" var="pro">
								<tr>
									<td><label> <input type="checkbox" class="ace">
												<span class="lbl"></span></label></td>
									<td id="id">${pro.id }</td>
									<td style="width: 3rem;height: 2rem;"><img src="${pageContext.request.contextPath}/image/showImage.do?image=${pro.img_small}" style="width: 4rem;height:3rem"/></td>
									<td>${pro.productName }</td>
									<td>${pro.productDetails }</td>
									<td><u style="cursor: pointer" class="text-primary"
										onclick="member_show('${pro.name }','${pageContext.request.contextPath}/manager/market/marketShow.do?id=${pro.marketid }','500','400')">${pro.name }
									</u></td>
									<td>
										<c:set value="${fn:split(pro.banners,';')}" var="str1"></c:set>
									 <c:forEach items="${str1}" var="b">
									 <u>
									 <img src="${pageContext.request.contextPath}/image/showImage.do?image=${b}" alt="" style="width: 4rem;height:3rem"/>
									</u>
									 </c:forEach>
									
									</td>
									<td style="width: 3rem;height: 2rem;">
									<c:set value="${fn:split(pro.imgname,';')}" var="str"></c:set>
									<c:forEach items="${str}" var="b">
									 <u>
									 <img src="${pageContext.request.contextPath}/image/showImage.do?image=${b}" alt="" style="width: 4rem;height:3rem"/>
									</u>
									 </c:forEach>
									
									</td>
										<c:if test="${pro.status==1 }">
										<td class="td-status"><span
											class="label label-success radius">已启用</span></td>
										<td class="td-manage"><a
											onClick="member_stop(this,'${pro.id}')"
											href="javascript:;" title="停用" class="btn btn-xs btn-success"><i
												class="icon-ok bigger-120"></i></a> <a title="编辑"
											onclick="member_edit('编辑','${pageContext.request.contextPath}/manager/market/goEditPro.do?marketId=${pro.id}')"
											href="javascript:;" class="btn btn-xs btn-info"><i
												class="icon-edit bigger-120"></i></a> <a title="删除"
											href="javascript:;" onclick="member_del(this,'${pro.id}')"
											class="btn btn-xs btn-warning"><i
												class="icon-trash  bigger-120"></i></a></a>
											<%-- 	<a title="活动"
											href="javascript:;" onclick="member_show('活动','${pageContext.request.contextPath}/manager/market/activity.do?marketId=${market.id}',440,410)"
											class="btn btn-xs btn-warning"><i
												class="icon-ok  bigger-120"></i></a> --%>
											<%-- 	<a title="添加商品"
											href="javascript:;" onclick="member_show('添加商品','${pageContext.request.contextPath}//manager/market/toAdd.do?marketId=${market.id}')"
											class="btn btn-xs btn-warning"><i
												class="icon-ok  bigger-120"></i></a> --%>
												<c:if test="${pro.promote==1 }">
												<a onClick="promote_stop(this,'${pro.id}')"
											href="javascript:;" title="返佣停用" class="btn btn-xs btn-success"><i
												class="icon-ok bigger-120"></i></a>
												</c:if>
												<c:if test="${pro.promote==0 }">
												<a onClick="promote_start(this,'${pro.id}')"
												class="btn btn-xs "
											href="javascript:;" title="返佣启用"><i
											
												class="icon-ok bigger-120"></i></a>
												</c:if>
												</td>
									</c:if>
									<c:if test="${pro.status==0 }">
										<td class="td-status"><span
											class="label label-defaunt radius">已停用</span></td>
										<td class="td-manage"><a style="text-decoration: none"
											class="btn btn-xs "
											onClick="member_start(this,'${pro.id}')"
											href="javascript:;" title="启用"><i
												class="icon-ok bigger-120"></i></a> <a title="编辑"
											onclick="member_edit('编辑','${pageContext.request.contextPath}/manager/market/goEditPro.do?marketId=${pro.id}')"
											href="javascript:;" class="btn btn-xs btn-info"><i
												class="icon-edit bigger-120"></i></a><a title="删除"
											href="javascript:;" onclick="member_del(this,'${pro.id}')"
											class="btn btn-xs btn-warning"><i
												class="icon-trash  bigger-120"></i></a>
											<%-- 	<a title="活动"
											href="javascript:;" onclick="member_show('活动','${pageContext.request.contextPath}/manager/market/activity.do?marketId=${market.id}')"
											class="btn btn-xs btn-warning"><i
												class="icon-ok  bigger-120"></i></a> --%>
											<%-- 	<a title="添加商品"
											href="javascript:;" onclick="member_show('添加商品','${pageContext.request.contextPath}/manager/market/toAdd.do?marketId=${pro.marketid}')"
											class="btn btn-xs btn-warning"><i
												class="icon-ok  bigger-120"></i></a> --%>
												<c:if test="${pro.promote==1 }">
												<a onClick="promote_stop(this,'${pro.id}')"
											href="javascript:;" title="返佣停用" class="btn btn-xs btn-success"><i
												class="icon-ok bigger-120"></i></a>
												</c:if>
												<c:if test="${pro.promote==0 }">
												<a onClick="promote_start(this,'${pro.id}')"
												class="btn btn-xs "
											href="javascript:;" title="返佣启用"><i
												class="icon-ok bigger-120"></i></a>
												</c:if>
												</td>
									</c:if>
								</tr>

							</c:forEach> 
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--添加用户图层-->
	 
</body>

</html>
<script>
/* var oTable1;
var typeId = '${typeId}';
if(typeId==''){
	typeId=null;
}
jQuery(function($) {
		var url = '${pageContext.request.contextPath}/manager/market/findByType.do';
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
					var status='<span class="label label-success radius">已启用</span>';
					var handle = '<a onClick="member_stop(this,'+data.result[i].id+')" href="javascript:;" title="停用" class="btn btn-xs btn-success"><i	class="bigger-120">停用</i></a>'
					+'<a title="编辑" onclick="member_edit("编辑","${pageContext.request.contextPath}/manager/market/goEdit.do?marketId="'+data.result[i].id+'")"	href="javascript:;" class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a> '
					+'<a title="删除" href="javascript:;" onclick="member_del(this,'+data.result[i].id+')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>'
					+'<a title="活动" href="javascript:;" onclick="member_show("活动","${pageContext.request.contextPath}/manager/market/activity.do?marketId="'+data.result[i].id+'",440,410)" class="btn btn-xs btn-warning"><i	class="icon-ok  bigger-120"></i></a>';
					 if(data.result[i].status==0){
						 status='<span	class="label label-defaunt radius">已停用</span>';
						handle='<a style="text-decoration: none" class="btn btn-xs " onClick="member_start(this,'+data.result[i].id+')"	href="javascript:;" title="启用"><i class="bigger-120">启用</i></a>'
						+'<a title="编辑" onclick="member_edit("编辑","${pageContext.request.contextPath}/manager/market/goEdit.do?marketId="'+data.result[i].id+'")"	href="javascript:;" class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a> '
						+'<a title="删除" href="javascript:;" onclick="member_del(this,'+data.result[i].id+')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>'
						+'<a title="活动" href="javascript:;" onclick="member_show("活动","${pageContext.request.contextPath}/manager/market/activity.do?marketId="'+data.result[i].id+'",440,410)" class="btn btn-xs btn-warning"><i	class="icon-ok  bigger-120"></i></a>';
					} 
					
					data.result[i].status = status;
					data.result[i].handle = handle;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'id' },
	        { data: 'name' },
	        { data: 'contactUser' },
	        { data: 'phone' },
	        { data: 'tel'},
	        { data: 'address.busRoute'},
	        { data: 'createTime'},
	        { data: 'status'},
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
	}); */
	 jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 6, 8]
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
	}) 
	/*用户-查看*/
	function member_show(title, url, w, h) {
		layer_show(title, url, w, h);
	}
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
											"${pageContext.request.contextPath}/manager/market/prostop.do",
											//提交的参数
											{
												proid : id
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
																			+ ')" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
													$(obj)
															.parents("tr")
															.find(".td-status")
															.html(
																	'<span class="label label-defaunt radius">已停用</span>');
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
											"${pageContext.request.contextPath}/manager/market/startPro.do",
											//提交的参数
											{
												proid : id
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
																			+ ')" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
													$(obj)
															.parents("tr")
															.find(".td-status")
															.html(
																	'<span class="label label-success radius">已启用</span>');
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
	
	/*用户-启用*/
	function promote_start(obj, id) {
		layer
				.confirm(
						'确认要启用吗？',
						function(index) {
							/* 	layer.closeAll('dialog'); */
							//发送ajax
							$
									.post(
											//提交的路径	
											"${pageContext.request.contextPath}/manager/market/startPromote.do",
											//提交的参数
											{
												proid : id
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
																			+ ')" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
													$(obj)
															.parents("tr")
															.find(".td-status")
															.html(
																	'<span class="label label-success radius">已启用</span>');
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
	
	/*用户-停用*/
	function promote_stop(obj, id) {
		layer
				.confirm(
						'确认要停用吗？',
						function(index) {
							/* layer.closeAll('dialog'); */
							//发送ajax
							$
									.post(
											//提交的路径	
											"${pageContext.request.contextPath}/manager/market/stopPromote.do",
											//提交的参数
											{
												proid : id
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
																			+ ')" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
													$(obj)
															.parents("tr")
															.find(".td-status")
															.html(
																	'<span class="label label-defaunt radius">已停用</span>');
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


	/*用户-编辑*/
	function member_edit(title, url, w, h) {
		layer.open({
			type : 2,
			title : title,
			shadeClose : true,
			shade : false,
			maxmin : true, //开启最大化最小化按钮
			area : [ '800px', '370px' ],
			content : url,
			end : function() {
				location.reload();
			}
		});
	} 

	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发送ajax
			$.post(
			//提交的路径	
			"${pageContext.request.contextPath}/manager/market/deleteMarketPro.do",
			//提交的参数
			{
				marketId : id
			},
			//返回的结果函数
			function(date) {
				//如果返回的结果不为空
				if (date.result == "true") {
					$(obj).parents("tr").remove();
					layer.msg('已删除!', {
						icon : 1,
						time : 1000
					});
				}
			}, "json");
		});
	}
	/*用户-查询*/
	function selectMarket(w, h) {
		var url = '${pageContext.request.contextPath}/manager/market/selectByName.do?name='
				+ $("#seleName").val();
		var title = '搜索结果';
		layer_show(title, url, w, h);
	}
</script>