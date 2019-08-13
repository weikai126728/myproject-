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
<title>代金券未使用列表</title>
</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<!-- <div class="search_style">
					<div class="title_names">搜索查询</div>


					<ul class="search_content clearfix">
						<li><label class="l_f">查询内容</label><input name="activitsName"
							id="activitsName" type="text" class="text_add"
							placeholder="可根据用户OPENID、有效期查询" style="width: 400px" /></li>
						<li><label class="l_f">添加时间</label><input
							class="inline laydate-icon" id="seleTime" name="time"
							style="margin-left: 10px;"></li>
						<li style="width: 90px;"><button type="button"
								onclick="selectActivities('1300','600')" class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>

				</div> -->
				<!-- -->
				<div class="border clearfix">
					<span class="r_f">共&nbsp;<b>${totalCount }</b>&nbsp;条
					</span>
				</div>
				<!--  -->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="25px"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="100px">用户OPENID</th>
								<th width="100px">最低消费金额(元)</th>
								<th width="100px">有效期至</th>
								<th width="100px">面值(元)</th>
								
								<!-- <th width="80px">操作</th> -->
							</tr>
						</thead>
						<tbody>

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
		 
		var url = '${pageContext.request.contextPath}/redpack/queryOverdueVouchersBytime.do';
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
					data.result[i].ch = '<label id="'+data.result[i].aid+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
					data.result[i].coupon_mininum=data.result[i].coupon_mininum/100;
					data.result[i].coupon_value=data.result[i].coupon_value/100;
					//var handle ='<a title="编辑" data="'+data.result[i].merername+'" onclick="member_edit(this)" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120">编辑</i></a>'   ;
			     	
// 					data.result[i].handle = handle;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'openid' },
	        { data: 'coupon_mininum' },
	        { data: 'endTime' },
	        { data: 'coupon_value' }
	    ],
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,4]}// 制定列不参与排序
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
	
	
function member_edit(obj){
	 var merername = $(obj).attr("data");
	var url = '${pageContext.request.contextPath}/redpack/queryRedgailvByzipcode.do?merername='+merername;
	 
	layer_show("编辑",url);
}

	/*用户-查询*/
	function selectActivities(w, h) {
		var url = '${pageContext.request.contextPath}/redpack/getActivitiesCountLikeList.do?activitsName='
				+ $("#activitsName").val();
		var title = '搜索结果';
		layer_show(title, url, w, h);
	}
</script>