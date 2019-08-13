<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" /> 
        <link href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/css/style.css"/>       
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/manager/Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
        <link href="${pageContext.request.contextPath}/manager/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />   
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	    <script src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>   
        <script src="${pageContext.request.contextPath}/manager/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/js/H-ui.admin.js"></script> 
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script> 
        <script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
<title>产品列表</title>
<style type="text/css">
	.tidings{
		position: relative;
	    width: 14px;
	    height: 14px;
	    display: inline-block;
	    background:url(${pageContext.request.contextPath}/manager/images/tidings.png) no-repeat center center;
	    background-size:cover;
	}
	td img{
		width:50px;
		height:50px;
	}
	.layui-layer-title img{
		width:25px;
		height:25px;
		margin-right:14px;
	}
	.preview{
		position: relative;
	    width: 14px;
	    height: 14px;
	    display: inline-block;
	    background:url(${pageContext.request.contextPath}/manager/images/phone.png) no-repeat center center;
	    background-size:cover;
	}
</style>
</head>
<body>
<div class=" page-content clearfix">
 <div id="products_style">
<!--     <div class="search_style"> -->
<!--       <div class="title_names">搜索查询</div> -->
<!--       <ul class="search_content clearfix"> -->
<!--        <li><label class="l_f">产品名称</label><input name="" type="text"  class="text_add" placeholder="输入品牌名称"  style=" width:250px"/></li> -->
<!--        <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li> -->
<!--        <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li> -->
<!--       </ul> -->
<!--     </div> -->
     <div class="border clearfix" style="margin-top:10px;">
       <span class="l_f">
        <a href="${pageContext.request.contextPath}/distribution/product/toAdd.do" title="添加商品" class="btn btn-warning Order_form"><i class="icon-plus"></i>添加商品</a>
<!--         <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a> -->
       </span>
       <span class="r_f">共：<b>${totalCount}</b>件商品</span>
     </div>
     <!--产品列表展示-->
     <div class="h_products_list clearfix" id="products_list">
       <div id="scrollsidebar" class="left_Treeview">
        <div class="show_btn" id="rightArrow"><span></span></div>
        <div class="widget-box side_content" >
         <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
         <div class="side_list"><div class="widget-header header-color-green2"><h4 class="lighter smaller">产品类型列表</h4></div>
         <div class="widget-body">
          <div class="widget-main padding-8"><div id="treeDemo" class="ztree"></div></div>
        </div>
       </div>
      </div>  
     </div>
         <div class="table_menu_list" id="testIframe">
	       <table class="table table-striped table-bordered table-hover" id="sample-table">
			<thead>
			 <tr>
					<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
					<th width="80px">ID</th>
					<th width="250px">标题</th>
					<th width="100px">所属分类</th>
					<th width="100px">面额</th>
	                <th width="80px">售价</th>				
					<th width="80px">库存</th>
					<th width="150px">发布时间</th>                
					<th width="250px">操作</th>
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
		
		var url = '${pageContext.request.contextPath}/distribution/product/findByType.do';
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
					var st = '<span class="label label-success radius">已启用</span>';
					var handle = '<a title="编辑" onclick="member_edit(this)" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a>' 
			        +'<a title="删除" href="javascript:;"  onclick="member_del(this)" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>';
					var image = '<img src="${pageContext.request.contextPath}/image/showImage.do?image='+data.result[i].imgSmall+'">';
					data.result[i].image = image;
					data.result[i].status = st;
					data.result[i].handle = handle;
				}
				return data.result;
			}		
		},
		'columns': [
			{ data: 'ch' },
	        { data: 'id' },
	        { data: 'title' },
	        { data: 'productCate.name' },
	        { data: 'bills' },
	        { data: 'money' },
	        { data: 'inventory'},
	        { data: 'createDate'},
	        { data: 'handle'}
	    ],
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,3,4,5,6,7,8]}// 制定列不参与排序
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
//  laydate({
//     elem: '#start',
//     event: 'focus' 
// });
$(function() { 
	$("#products_style").fix({
		'float' : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false,
		spacingw:30,//设置隐藏时的距离
	    spacingh:260,//设置显示时间距
	});
});
//初始化宽度、高度  
 $(".widget-box").height($(window).height()-100); 
$(".table_menu_list").width($(window).width()-260);
 $(".table_menu_list").height($(window).height()-100);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height()-100);
	 $(".table_menu_list").width($(window).width()-260);
	  $(".table_menu_list").height($(window).height()-100);
	})
 
/*******树状图*******/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				typeId = null;
				oTable1.fnClearTable();
				return false;
			} else {
				typeId = treeNode.id;
				oTable1.fnClearTable();
// 				demoIframe.attr("src",'${pageContext.request.contextPath}/manager/product/index.do?typeId='+treeNode.id);
				return true;
			}
		}
	}
};

var zNodes = ${array};
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
		
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	demoIframe.bind("load", function(){});
	var zTree = $.fn.zTree.getZTreeObj("tree");
// 	zTree.selectNode(zTree.getNodeByParam("id",'11'));
});	
 
/*产品-编辑*/
function member_edit(obj){
	var td = $(obj).parents('tr').find('td');
	var paramId = td.eq(0).find('label').attr("id");
	var url = '${pageContext.request.contextPath}/distribution/product/toEdit.do?proId='+paramId;
	var title = td.eq(2).html();
	layer_show(title,url);
}

/*产品-删除*/
function member_del(obj){
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/distribution/product/delete.do',{proId:id},function(data){
				if(data.result==true){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				}
		},'json');
		
	});
}
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
	
});
</script>