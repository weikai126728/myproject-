<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link
		href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css"
		rel="stylesheet" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/manager/css/style.css" />
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
<script
			src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/js/lrtk.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
		<script
			src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"
			type="text/javascript"></script>
		<title>售后管理</title>
</head>

<body>
	<div class="page-content clearfix">
		<div class="sort_style">

			<div class="sort_list">
				<table class="table table-striped table-bordered table-hover"
					id="sample-table">
					<thead>
						<tr>
							<th width="25px"><label><input type="checkbox"
									class="ace"><span class="lbl"></span></label></th>
							<th width="50px">ID</th>
							<th width="1250px">图片</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label><input type="checkbox" class="ace"><span
										class="lbl"></span></label></td>
							<td>${service.id }</td>

							<c:forEach var="image" items="${images}" varStatus="status">
								<td><img
									src="${pageContext.request.contextPath}/image/showImage.do?image=${image}"></td>
							</c:forEach>



						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 1, 2 ]
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
</html>