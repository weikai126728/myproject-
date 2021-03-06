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
	<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.min.js"></script>

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
							id="seleName" type="text" class="text_add" placeholder="输入会员名称"
							style="width: 400px" /></li>
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
				<%-- <input type="hidden" value="${phone }" id="phone"/> --%>
				<!--  -->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="80">ID</th>
								<th width="100">真实姓名</th>
								<th width="80">性别</th>
								<th width="120">手机</th>

								<th width="180">加入时间</th>
								<th width="100">等级</th>
								<th width="70">状态</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:forEach items="${userList }" var="user">
								<tr>
									<td><label> <input type="checkbox" class="ace">
												<span class="lbl"></span></label></td>
									<td id="id">${user.id }</td>
									<td><u style="cursor: pointer" class="text-primary"
										onclick="member_show('${user.nickName }','${pageContext.request.contextPath}/manager/user/queryUserById.do?id=${user.id }','500','400')">${user.nickName }
									</u></td>
									<c:choose>
										<c:when test="${user.gender==1 }">
											<td>男</td>
										</c:when>
										<c:when test="${user.gender==2 }">
											<td>女</td>
										</c:when>
										<c:otherwise>
											<td>暂无</td>
										</c:otherwise>
									</c:choose>

									<td>${user.phone }</td>

									<td>${user.createTime }</td>
									<td>会员</td>
									<c:if test="${user.status==1 }">
										<td class="td-status"><span
											class="label label-success radius">已启用</span></td>
										<td class="td-manage"><a
											onClick="member_stop(this,'${user.id}')" href="javascript:;"
											title="停用" class="btn btn-xs btn-success"><i
												class="icon-ok bigger-120"></i></a> <em
											style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>
											<a title="编辑"
											onclick="member_edit('编辑','${pageContext.request.contextPath}/manager/user/findById.do?userId=${user.id}')"
											href="javascript:;" class="btn btn-xs btn-info"><i
												class="icon-edit bigger-120"></i></a></td>
									</c:if>
									<c:if test="${user.status==0 }">
										<td class="td-status"><span
											class="label label-defaunt radius">已停用</span></td>
										<td class="td-manage"><a style="text-decoration: none"
											class="btn btn-xs " onClick="member_start(this,'${user.id}')"
											href="javascript:;" title="启用"><i
												class="icon-ok bigger-120"></i></a> <em
											style="width: 42px; display: inline-block; height: 26px; vertical-align: middle;"></em>
											<a title="编辑"
											onclick="member_edit('编辑','${pageContext.request.contextPath}/manager/user/findById.do?userId=${user.id}')"
											href="javascript:;" class="btn btn-xs btn-info"><i
												class="icon-edit bigger-120"></i></a></td>
									</c:if>
								</tr>

							</c:forEach> --%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--添加用户图层-->
	<div class="add_menber" id="add_menber_style" style="display: none">
		<form
			action="${pageContext.request.contextPath}/manager/user/addUser.do"
			method="post" id="formId">
			<ul class=" page-content">
				<!-- <li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span
					class="add_name"><input value="" name="name" type="text"
						class="text_add" /></span>
					<div class="prompt r_f"></div></li> -->
				<li><label class="label_name">真实姓名：</label><span
					class="add_name"><input name="name" type="text"
						class="text_add" /></span>
					<div class="prompt r_f"></div></li>
				<li><label class="label_name">移动电话：</label><span
					class="add_name"><input name="phone" type="text"
						maxlength="11" class="text_add" /></span>
					<div class="prompt r_f"></div></li>
				<li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span
					class="add_name"> <label><input name="gender"
							type="radio" checked="checked" value="1" class="ace"><span
								class="lbl">男</span></label>&nbsp;&nbsp;&nbsp; <label><input
							name="gender" type="radio" value="2" class="ace"><span
								class="lbl">女</span></label>
				</span>
					<div class="prompt r_f"></div></li>
				<!--  <li><label class="label_name">固定电话：</label><span
					class="add_name"><input name="phone" type="text"
						class="text_add" /></span>
					<div class="prompt r_f"></div></li>  -->

				<!--   <li><label class="label_name">电子邮箱：</label><span
					class="add_name"><input name="电子邮箱" type="text"
						class="text_add" /></span>
					<div class="prompt r_f"></div></li>  
				<li class="adderss"><label class="label_name">家庭住址：</label><span
					class="add_name"><input name="家庭住址" type="text"
						class="text_add" style="width: 350px" /></span>
					<div class="prompt r_f"></div></li> -->
				<li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span
					class="add_name"> <label><input name="status"
							type="radio" checked="checked" value="1" class="ace"><span
								class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp; <label><input
							name="status" type="radio" value="0" class="ace"><span
								class="lbl">关闭</span></label></span>
					<div class="prompt r_f"></div></li>
			</ul>
		</form>
	</div>
</body>


<script>
var phone=$("#phone").val();
	var oTable1;
	var typeId = '${typeId}';
	var number='${number}';
	jQuery(function($) {
		var url = '${pageContext.request.contextPath}/manager/user/findRedDetailByType.do?number='+number;
		oTable1 = $('#sample-table')
				.dataTable(
						{
							"processing" : true,
							"serverSide" : true,
							'ajax' : {
								'url' : url,
								'data' : function(d) {

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
// 												+ '<a title="删除" href="javascript:;" onclick="member_del(this,'
// 												+ data.result[i].id
// 												+ ')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>'
												+'<a title="详情" href="javascript:;"onclick="member_detail('
												+data.result[i].nickName
												+ ","
												+ data.result[i].phone
												+ '",500,400)" class="btn btn-xs btn-warning"><i	class="bigger-120">详情</i></a>';
										if (data.result[i].status == 0) {
											handle = '<a style="text-decoration: none" class="btn btn-xs " onClick="member_start(this,'
													+ data.result[i].id
													+ ')"	href="javascript:;" title="启用"><i class="bigger-120">启用</i></a>'
// 													+ '<a title="删除" href="javascript:;" onclick="member_del(this,'
// 													+ data.result[i].id
// 													+ ')" class="btn btn-xs btn-warning"><i	class="bigger-120">删除</i></a>'
													+'<a title="详情" href="javascript:;"onclick="member_detail('
													+data.result[i].nickName
													+ ","
													+ data.result[i].phone
													+ '",500,400)" class="btn btn-xs btn-warning"><i	class="bigger-120">详情</i></a>';
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
							'columns' : [ {
								data : 'ch'
							}, {
								data : 'id'
							}, {
								data : 'nickName'
							}, {
								data : 'gender'
							}, {
								data : 'phone'
							}, {
								data : 'createTime'
							}, {
								data : 'lv'
							}, {
								data : 'status'
							}, {
								data : 'handle'
							} ],
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
	});
	/* 	jQuery(function($) {
	 var oTable1 = $('#sample-table').dataTable({
	 "aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
	 "bStateSave" : true, //状态保存
	 "aoColumnDefs" : [
	 //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	 {
	 "orderable" : false,
	 "aTargets" : [ 0, 2, 3, 4, 6, 7, 8 ]
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
	/*用户-添加*/
	$('#member_add').on(
			'click',
			function() {
				layer.open({
					type : 1,
					title : '添加用户',
					maxmin : true,
					shadeClose : true, //点击遮罩关闭层
					area : [ '800px', '' ],
					content : $('#add_menber_style'),
					btn : [ '提交', '取消' ],
					yes : function(index, layero) {
						var num = 0;
						var str = "";
						$(".add_menber input[type$='text']").each(
								function(n) {
									if ($(this).val() == "") {

										layer.alert(str += ""
												+ $(this).attr("name")
												+ "不能为空！\r\n", {
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
							layer.alert('添加成功！', {
								title : '提示框',
								icon : 1,
							});
							$("#formId").submit();

							layer.close(index);
						}
					}
				});
			});
	/*用户-查看*/
	function member_show(title, id, w, h) {
		url1 = '${pageContext.request.contextPath}/manager/user/queryUserById.do?id='
				+ id;

		layer_show(title, url1, w, h);
	}
	function member_detail(title, phone, w, h) {
		url1 = '${pageContext.request.contextPath}/manager/user/queryRedUserByPhone.do?phone='
				+ phone;

		layer_show(title, url1, w, h);
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
											"${pageContext.request.contextPath}/manager/user/stop.do",
											//提交的参数
											{
												userId : id
											},
											//返回的结果函数
											function(data) {
												if (data.result == 'true') {
													$(obj)
															.parents("td")
															.prepend(
																	'<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,'
																			+ id
																			+ ')" href="javascript:;" title="启用"><i class=" bigger-120">启用</i></a>');
													$(obj)
															.parents("td")
															.prev()
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
							$
									.post(
											"${pageContext.request.contextPath}/manager/user/start.do",
											{
												userId : id
											},
											function(data) {
												if (data.result == 'true') {
													$(obj)
															.parents("td")
															.prepend(
																	'<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,'
																			+ id
																			+ ')" href="javascript:;" title="停用"><i class=" bigger-120">停用</i></a>');
													$(obj)
															.parents("td")
															.prev()
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
	/*用户-编辑*/
	function member_edit(title, url, w, h) {
		/* layer_show(title, url, w, h); */
		layer.open({
			type : 2,
			title : title,
			shadeClose : true,
			shade : false,
			maxmin : true, //开启最大化最小化按钮
			area : [ '800px', '270px' ],
			content : url,
			end : function() {
				location.reload();
			}
		/* btn: ['提交', '取消'],
		yes: function(index, layero) {
			var num = 0;
			var str = "";
			$("#update_menber_style input[type$='text']").each(function(n) {
				if($(this).val() == "") {

					layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
						title: '提示框',
						icon: 0,
					});
					num++;
					return false;
				}
			});
			if(num > 0) {
				return false;
			} else {
				layer.alert('添加成功！', {
					title: '提示框',
					icon: 1,
				});
				$("#upFormId").submit();
				layer.close(index);
			}
		} */
		});

	}
	/* function member_edit(id) {
		layer.open({
			type: 1,
			title: '修改用户信息',
			maxmin: true,
			shadeClose: false, //点击遮罩关闭层
			area: ['800px', ''],
			content: $('#add_menber_style'),
			btn: ['提交', '取消'],
			yes: function(index, layero) {
				var num = 0;
				var str = "";
				$(".add_menber input[type$='text']").each(function(n) {
					if($(this).val() == "") {

						layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
							title: '提示框',
							icon: 0,
						});
						num++;
						return false;
					}
				});
				if(num > 0) {
					return false;
				} else {
					layer.alert('添加成功！', {
						title: '提示框',
						icon: 1,
					});
					layer.close(index);

				}
			}
		});
	} */
	/*用户-删除*/
	/* function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发送ajax
			$.post(
			//提交的路径	
			"${pageContext.request.contextPath}/manager/user/queryUserById.do",
			//提交的参数
			{
				userId : id
			},
			//返回的结果函数
			function(result) {
				//如果返回的结果不为空
				if (result != null) {
					$(".update_menber input[type$='text']").each(function(n) {
						$(this).val() = this.val();

					});
					layer.open({
						type : 1,
						title : '修改用户信息',
						maxmin : true,
						shadeClose : false, //点击遮罩关闭层
						area : [ '800px', '' ],
						content : $('#update_menber_style'),
						btn : [ '提交', '取消' ],
						yes : function(index, layero) {
							var num = 0;
							var str = "";
							$(".update_menber input[type$='text']").each(
									function(n) {
										if ($(this).val() == "") {

											layer.alert(str += ""
													+ $(this).attr("name")
													+ "不能为空！\r\n", {
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
								$("#upId").val(id);
								$("#upFormId").submit();
								layer.close(index);
							}
						}
					});

				}

			}, "json");

		});
	} */
	/*用户-查询*/
	function selectUser(w, h) {
		var url = '${pageContext.request.contextPath}/manager/user/selectUser.do?name='
				+ $("#seleName").val();
		var title = '搜索结果';
		layer_show(title, url, w, h);
		/* //发送ajax
		$.post(
		//提交的路径	
		"${pageContext.request.contextPath}/manager/user/selectUser.do",
		//提交的参数
		{
			name : $("#seleName").val()
		},
		//返回的结果函数
		function(result) {
			//如果返回的结果不为空
			if (result != "") {
				//拼接city的option对象
			}
		}, "json"); */

	}
	laydate({
		elem : '#start',
		event : 'focus'
	});
</script>
</html>