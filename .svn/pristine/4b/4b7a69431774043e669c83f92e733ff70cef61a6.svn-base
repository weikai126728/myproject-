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
	<title>售后信息</title>
</head>

<body>
	<div class="page-content clearfix">
		<div class="sort_style">
				<div class="border clearfix">
					<span class="r_f">共&nbsp;<b>${count }</b>&nbsp;条
					</span>
				</div>
			<div class="sort_list">
				<table class="table table-striped table-bordered table-hover"
					id="sample-table">
					<thead>
						<tr>
							<th width="25px"><label><input type="checkbox"
									class="ace"><span class="lbl"></span></label></th>
							<th width="250px">退款编号</th>
							<th width="100px">联系人</th>
							<th width="150px">联系方式</th>
							<th width="100px">退款方式</th>
							<th width="300px">描述</th>
							<th width="180px">购买时间</th>
							<th width="70px">状态</th>
							<th width="250px">操作</th>
						</tr>
					</thead>
						<tbody>
				   		<c:forEach items="${serviceList }" var="service">
								<tr>
								<td><label><input type="checkbox" class="ace"><span	class="lbl"></span></label></td>
								
								<td> ${service.refundNum }</td>
								<c:if
									test="${service.serviceType == 1 || service.isSubmit == 0}">
									<td>${service.cOrder.contactUser }</td>
								</c:if>
								<c:if
									test="${service.serviceType != 1 && service.isSubmit == 1}">
									<td><u style="cursor: pointer" class="text-primary"
										onclick="member_show('${service.cOrder.contactUser }','${pageContext.request.contextPath}/manager/service/queryLogById.do?id=${service.id }','500','400')">
											${service.cOrder.contactUser }</u></td>
								</c:if>
								<td>${service.cOrder.contactPhone }</td>
								<c:choose>
									<c:when test="${service.serviceType == 1 }">
										<td>仅退款</td>
									</c:when>
									<c:when test="${service.serviceType == 2 }">
										<td>退货退款</td>
									</c:when>
									<c:when test="${service.serviceType == 3 }">
										<td>换货</td>
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
								<td>${service.describe }</td>
								<td>${service.cOrder.mOrder.createTime }</td>
								<c:choose>
									<c:when test="${service.serviceStatus== -1 }">
										<td class="td-status"><span
											class="label label-default radius">拒绝</span></td>
									</c:when>
									<c:when test="${service.serviceStatus== 1 }">
										<td class="td-status"><span
											class="label label-success radius">同意</span></td>
									</c:when>
									<c:when test="${service.serviceStatus== 0 }">
										<td class="td-status"><span
											class="label label-info radius">申请中</span></td>
									</c:when>
									<c:otherwise>
										<td class="td-status"><span
											class="label label-info radius">售后结束</span></td>
									</c:otherwise>
								</c:choose>
								<td class="td-manage"><a
									onClick="member_start(this,'${service.id }')"
									href="javascript:;" title="同意" class="btn btn-xs btn-success"><i
										class="fa bigger-120">同意</i></a>  <a onClick="member_stop(this,'${service.id }')"
									href="javascript:;" title="拒绝" class="btn btn-xs btn-success"><i
										class="fa bigger-120">拒绝</i></a><c:if
										test="${service.isSubmit == 1 }">
										<a onClick="member_agree(this,'${service.id }')"
											href="javascript:;" title="退款/退货"
											class="btn btn-xs btn-success"><i class="fa bigger-120">确认退款/退货</i></a>
									</c:if><a href="javascript:ovid()"
									name="Ads_list.html" class="btn btn-xs btn-pink ads_link"
									onclick="AdlistOrders('${service.id }');" title="图片详情"><i
										class="fa  bigger-120">图片详情</i></a></td>
							</tr>
						</c:forEach>
						</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="add_menber" id="add_menber_style" style="display: none">
		<form action="${pageContext.request.contextPath}/manager/.do"
			method="post" id="formId">
			<ul class=" page-content">
				<li><label class="label_name">拒绝原因：</label><span
					class="add_name"><textarea name="name" id="refuseReason"
							class="text_add"></textarea></span>
					<div class="prompt r_f"></div></li>
			</ul>
		</form>
	</div>
</body>

</html>
<script type="text/javascript">
	/*申请-拒绝*/
	function member_stop(obj, id) {
		layer.confirm('确认要拒绝吗？',function(index) {
			layer.open({
				type : 1,
				title : '拒绝原因',
				maxmin : true,
				shadeClose : true, 
				//点击遮罩关闭层
				area : [ '800px', '' ],
				content : $('#add_menber_style'),
				btn : [ '提交', '取消' ],
				yes : function(index, layero) {
					var num = 0;
					var str = "";
					$(".add_menber input[type$='text']").each(function(n) {
						if ($(this).val() == "") {
							layer.alert(
									str += "" + $(this).attr("name") + "不能为空！\r\n",{
										title : '提示框',
										icon : 0,
									});
							num++;
							return false;
						}
					});
					if (num > 0) {
						return false;
					} else {
						var refuseReason = $("#refuseReason").val();
						//发送ajax
						$.post(
							//提交的路径
							"${pageContext.request.contextPath}/manager/service/disagree.do",
							//提交的参数
							{
								sId : id,
								refuseReason : refuseReason
							},
							//返回的结果函数
							function(data) {
								if (data.result == true) {
									$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">拒绝</span>');
									layer.msg('已拒绝!',{icon : 5,time : 1000});
								} else {
									layer.msg('拒绝失败',{icon : 2,time : 1000})
								}										
							}, "json");
						layer.close(index);
					}
				}
			});
		});
	}
	/*广告图片-启用*/
	function member_start(obj, id) {
		layer.confirm('确认要同意吗？',function(index) {
			$.post("${pageContext.request.contextPath}/manager/service/agree.do",{sId : id},function(data) {
					if (data.result == 'true') {
						$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">同意</span>');
						layer.msg('已同意!', {icon : 6,time : 1000});
					} else {
						layer.msg('同意失败', {icon : 2,time : 1000})
					}
				}, "json");
		});
	}
	function member_agree(obj, id) {
		layer.confirm('确认收货？',function(index) {
					$.post("${pageContext.request.contextPath}/manager/service/agreegoods.do",{sId : id},function(data) {
							if (data.result == 'true') {
								layer.msg('已确认!', {icon : 6,time : 1000});
							} else {
									layer.msg('确认失败', {icon : 2,time : 1000})
							}
						}, "json");
				});
	}
	//面包屑返回值
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	$('.Order_form ,.ads_link').on('click', function() {
		var cname = $(this).attr("title");
		var cnames = parent.$('.Current_page').html();
		var herf = parent.$("#iframe").attr("src");
		parent.$('#parentIframe span').html(cname);
		parent.$('#parentIframe').css("display", "inline-block");
		parent.$('.Current_page').attr("name", herf).css({
			"color" : "#4c8fbd",
			"cursor" : "pointer"
		});
		//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+">" + cnames + "</a>");
		parent.layer.close(index);

	});

	function AdlistOrders(id) {
		window.location.href = '${pageContext.request.contextPath}/manager/service/checkImg.do?id='+ id;
	};
</script>
<script type="text/javascript">
	function member_show(title, url, w, h) {
		layer_show(title, url, w, h);
	}
	/* var oTable1;
	var typeId = '${typeId}';
	if (typeId == '') {
		typeId = null;
	}
	jQuery(function($) {
		var url = '${pageContext.request.contextPath}/manager/service/findByType.do';
		oTable1 = $('#sample-table')
				.dataTable(
						{
							"processing" : true,
							"serverSide" : true,
							'ajax' : {
								'url' : url,
								'data' : function(d) {
									d.typeId = typeId;
								},
								'dataSrc' : function(data) {
									for (var i = 0; i < data.result.length; i++) {
										data.result[i].ch = '<label id='+data.result[i].id+'><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
										data.result[i].nickName = "<u style='cursor: pointer' class='text-primary' onclick='member_show("
												+ data.result[i].nickName
												+ ","
												+ data.result[i].id
												+ ",500,400)'>"
												+ data.result[i].nickName;
										var gender = '<td>男</td>';
										var status = '<span class="label label-success radius">已启用</span>';
										var handle = '<a onClick="member_stop(this,'
												+ data.result[i].id
												+ ')" href="javascript:;" title="停用" class="btn btn-xs btn-success"><i	class="bigger-120">停用</i></a>'
												+ '<em style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>'
												+ '<a title="删除" href="javascript:;" onclick="member_del(this,'
												+ data.result[i].id
												+ ')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>';
										if (data.result[i].status == 0) {
											handle = '<a style="text-decoration: none" class="btn btn-xs " onClick="member_start(this,'
													+ data.result[i].id
													+ ')"	href="javascript:;" title="启用"><i class="bigger-120">启用</i></a>'
													+ '<em style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>'
													+ '<a title="删除" href="javascript:;" onclick="member_del(this,'
													+ data.result[i].id
													+ ')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>';
										}
										if (data.result[i].gender == 2) {
											gender = '<td>女</td>';
										}
										if (data.result[i].status == 0) {
											status = '<span class="label label-defaunt radius">已停用</span>';
										}
										data.result[i].gender = gender;
										data.result[i].handle = handle;
										data.result[i].status = status;
										data.result[i].lv = '<td>会员</td>';
									}
									return data.result;
								}
							},
							'columns' : [ 
								{data : 'ch'}, 
								{data : 'id'}, 
								{data : 'nickName'}, 
								{data : 'gender'}, 
								{data : 'phone'}, 
								{data : 'createTime'}, 
								{data : 'lv'}, 
								{data : 'status'}, 
								{data : 'handle'} 
								],
							"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
							"bStateSave" : true,//状态保存
							"aoColumnDefs" : [
							//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
							{
								"orderable" : false,
								"aTargets" : [ 0, 2, 3, 4, 5, 6, 7, 8 ]
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
	}); */
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 7, 8 ]
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
</script>