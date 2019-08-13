<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
        <script type="text/javascript" src="${pageContext.request.contextPath}/manager/Widget/Validform/5.3.2/Validform.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/manager/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript" ></script>          
		<script src="${pageContext.request.contextPath}/manager/js/lrtk.js" type="text/javascript" ></script>
         <script src="${pageContext.request.contextPath}/manager/assets/layer/layer.js" type="text/javascript"></script>	
        <script src="${pageContext.request.contextPath}/manager/assets/laydate/laydate.js" type="text/javascript"></script>
<title>管理员</title>
</head>

<body>
<div class="page-content clearfix">
  <div class="administrator">
       <div class="d_Confirm_Order_style">
    <!--操作-->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:void(0);" id="administrator_add" class="btn btn-warning"><i class="fa fa-plus"></i> 添加管理员</a>
<!--         <a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash"></i> 批量删除</a> -->
       </span>
<!--        <span class="r_f">共：<b>5</b>人</span> -->
     </div>
     <!--管理员列表-->
     <div class="clearfix administrator_style" id="administrator">
      <div class="left_style">
      <div id="scrollsidebar" class="left_Treeview">
        <div class="show_btn" id="rightArrow"><span></span></div>
        <div class="widget-box side_content" >
         <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
         <div class="side_list"><div class="widget-header header-color-green2"><h4 class="lighter smaller">管理员分类列表</h4></div>
         <div class="widget-body">
           <ul class="b_P_Sort_list">
           <li roleLevel="ALL"><i class="fa fa-users green"></i> <a href="#">全部管理员（${total}）</a></li>
           <c:forEach var="role" items="${roleList}" varStatus="status">
           <li roleLevel="${role.level}"><i class="fa fa-users orange"></i> <a href="#">${role.name}（${role.number}）</a></li>
           </c:forEach>
           </ul>
        </div>
       </div>
      </div>  
      </div>
      </div>
      <div class="table_menu_list"  id="testIframe">
           <table class="table table-striped table-bordered table-hover" id="sample_table">
		<thead>
		 <tr>
				<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="250px">真实姓名</th>
				<th width="250px">昵称</th>
				<th width="200px">手机</th>
<!-- 				<th width="200px">出生年月</th> -->
                <th width="160px">角色</th>				
				<th width="280px">加入时间</th>
				<th width="70px">状态</th>                
				<th width="350px">操作</th>
			</tr>
		</thead>
	<tbody>
     
    </tbody>
    </table>
      </div>
     </div>
  </div>
</div>
 <!--添加管理员-->
 <div id="add_administrator_style" class="add_menber" style="display:none">
    <form action="${pageContext.request.contextPath}/manager/user/addManager.do" method="post" id="form-admin-add">
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>管理员：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="" placeholder="" id="user-name" name="realName" datatype="*2-16" nullmsg="用户名不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>昵称：</label>
			<div class="formControls">
				<input type="text" class="input-text" value="" placeholder="" id="nick-name" name="nickName" datatype="*2-16" nullmsg="昵称不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls">
			<input type="password" placeholder="密码" name="userpassword" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="密码不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>确认密码：</label>
			<div class="formControls ">
		<input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error" errormsg="您两次输入的新密码不一致！" datatype="*" nullmsg="请再输入一次新密码！" recheck="userpassword" id="newpassword2" name="password">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>性别：</label>
			<div class="formControls  skin-minimal">
            <label><input name="gender" type="radio" class="ace" name="gender" value="1"><span class="lbl">男</span></label>&nbsp;&nbsp;
            <label><input name="gender" type="radio" class="ace" name="gender" value="2"><span class="lbl">女</span></label>
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label "><span class="c-red">*</span>手机：</label>
			<div class="formControls ">
				<input type="text" class="input-text" value="" placeholder="" id="user-tel" name="phone" datatype="m" nullmsg="手机不能为空">
			</div>
			<div class="col-4"> <span class="Validform_checktip"></span></div>
		</div>
		<div class="form-group">
			<label class="form-label">角色：</label>
			<div class="formControls "> <span class="select-box" style="width:150px;">
				<select class="select" name="level" size="1">
				<c:forEach var="role" items="${roles}" varStatus="status">
					<option value="${role.level}">${role.name}</option>
				</c:forEach>
				</select>
				</span> </div>
		</div>
		<div> 
        <input class="btn btn-primary radius" type="submit" id="Add_Administrator" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"></div>
	</form>
   </div>
 </div>
</body>
</html>
<script type="text/javascript">
var level = null;
var oTable1;
jQuery(function($) {
		var url = '${pageContext.request.contextPath}/manager/user/findByPage.do';
		oTable1 = $('#sample_table').dataTable( {
			"processing": true,  
	        "serverSide": true,
			'ajax':{
				'url':url,
				'data': function (d) {
					if(level!=null){
						d.level = level;
					}
	            },
				'dataSrc':function(data){
					for(var i=0;i<data.result.length;i++){
						data.result[i].ch = '<label id="'+data.result[i].id+'"><input type="checkbox" class="ace" ><span class="lbl"></span></label>';
						var st = '<span class="label label-success radius">已启用</span>';
						var handle = '<a onClick="member_stop(this)"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i></a>'
				        +'<a title="编辑" onclick="member_edit(this)" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>' 
				        +'<a title="删除" href="javascript:;"  onclick="member_del(this)" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>';
						if(data.result[i].status==0){
							st = '<span class="label radius">已停用</span>';
							handle = '<a onClick="member_start(this)"  href="javascript:;" title="启用"  class="btn btn-xs"><i class="fa fa-check  bigger-120"></i></a>'
					        +'<a title="编辑" onclick="member_edit(this)" href="javascript:;"  class="btn btn-xs btn-info" ><i class="fa fa-edit bigger-120"></i></a>' 
					        +'<a title="删除" href="javascript:;"  onclick="member_del(this)" class="btn btn-xs btn-warning" ><i class="fa fa-trash  bigger-120"></i></a>';
						}
						data.result[i].status = st;
						data.result[i].handle = handle;
						if(!data.result[i].realName){
							data.result[i].realName = '';
						}
						if(!data.result[i].nickName){
							data.result[i].nickName = '';
						}
					}
					return data.result;
				}		
			},
			'columns': [
				{ data: 'ch' },
		        { data: 'realName' },
		        { data: 'nickName' },
		        { data: 'phone' },
// 		        { data: 'birthday' },
		        { data: 'roleName' },
		        { data: 'createTime'},
		        { data: 'status'},
		        { data: 'handle'}
		    ],
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,6,7,]}// 制定列不参与排序
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

$(function() { 
	$("#administrator").fix({
		'float' : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false,
		spacingw:50,//设置隐藏时的距离
	    spacingh:270,//设置显示时间距
	});
});
//字数限制
function checkLength(which) {
	var maxChars = 100; //
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
//初始化宽度、高度  
 $(".widget-box").height($(window).height()); 
$(".table_menu_list").width($(window).width()-260);
 $(".table_menu_list").height($(window).height());
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height());
	 $(".table_menu_list").width($(window).width()-260);
	  $(".table_menu_list").height($(window).height());
	})

/*用户-停用*/
function member_stop(obj){
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要停用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/user/disable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("tr").find('td').eq(7).prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this)" href="javascript:;" title="启用"><i class="fa fa-close bigger-120"></i></a>');
					$(obj).parents("tr").find('td').eq(6).html('<span class="label label-defaunt radius">已停用</span>');
					$(obj).remove();
					layer.msg('已停用!',{icon: 5,time:1000});
				}else{
					var error = '只能停用普通管理员';
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
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要启用吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/user/enable.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("tr").find('td').eq(7).prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this)" href="javascript:;" title="停用"><i class="fa fa-check  bigger-120"></i></a>');
					$(obj).parents("tr").find('td').eq(6).html('<span class="label label-success radius">已启用</span>');
					$(obj).remove();
					layer.msg('已启用!',{icon: 6,time:1000});
				}else{
					layer.msg('启用失败!',{icon: 5,time:1000});
				}
			}
		},'json');
		
	});
}
/*产品-编辑*/
function member_edit(obj){
	var userId = $(obj).parents('tr').find('td:first label').attr('id');
	var title = $(obj).parents('tr').find('td').eq(1).html();
	var url = '${pageContext.request.contextPath}/manager/user/manageredit.do?userId='+userId;
	layer.open({
        type: 2 //此处以iframe举例
        ,title: title
        ,area: ['390px', '260px']
        ,shade: 0
        ,maxmin: true
        ,offset: [ //为了演示，随机坐标
          ($(window).height()-400)
        ] 
        ,content: url
        
        ,zIndex: layer.zIndex //重点1
        ,success: function(layero){
          layer.setTop(layero); //重点2
        }
      });
}

/*产品-删除*/
function member_del(obj){
	var id = $(obj).parents('tr').find('td:first label').attr("id");
	layer.confirm('确认要删除吗？',function(index){
		$.post('${pageContext.request.contextPath}/manager/user/delete.do',{id:id},function(data){
			if(data.code==0){
				if(data.result==true){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
					setTimeout(function(){
						parent.iframe.location.reload();
					},1000);
				}else{
					var error = "删除失败!";
					if(data.msg){
						error = data.msg;
					}
					layer.msg(error,{icon:1,time:1000});
				}
			}
		},'json');
		
	});
}
/*添加管理员*/
$('#administrator_add').on('click', function(){
	layer.open({
    type: 1,
	title:'添加管理员',
	area: ['700px',''],
	shadeClose: false,
	content: $('#add_administrator_style'),
	
	});
})
	//表单验证提交
$("#form-admin-add").Validform({
		
		 tiptype:2,
		 beforeSubmit:function(curform){
			var nick = $('#nick-name').val();
			$.post('${pageContext.request.contextPath}/user/nick.do',{nickName:nick},function(data){
				if(data.code==0){
					if(data.result==false){
						var phone = $('#user-tel').val();
						$.post('${pageContext.request.contextPath}/user/to/checkPhone.do',{phone:phone},function(data){
							if(data.code==0){
								if(data.result==false){
									
								}else{
									layer.msg("手机号已被使用！");
									return false;
								}
							}
						},'json')
					}else{
						layer.msg("昵称已被使用！");
						return false;
					}
				}
			},'json')
				
		},
		callback:function(data){
		//form[0].submit();
		if(data.status==0){ 
			
//                 layer.msg(data.info, {icon: data.status,time: 1000}, function(){ 
// 						parent.iframe.reload();
//                  });   
            } 
            else{ 
                layer.msg(data.info, {icon: data.status,time: 3000}); 
            } 		  
			var index =parent.$("#iframe").attr("src");
			parent.layer.close(index);
			//
		}
		
		
	});	
// $('#nick-name').change(function(){
// 	var nick = $(this).val();
// 	var that = this;
// 	$.post('${pageContext.request.contextPath}/user/nick.do',{nickName:nick},function(data){
// 		if(data.code==0){
// 			if(data.result==true){
				
// 			}else{
// 				$(that).val('');
// 				layer.msg("昵称已被使用！");
// 			}
// 		}
// 	},'json')
// });
// $('#user-tel').change(function(data){
// 	var phone = $(this).val();
// 	var that = this;
// 	$.post('${pageContext.request.contextPath}/user/to/checkPhone.do',{phone:phone},function(data){
// 		if(data.code==0){
// 			if(data.result==true){
				
// 			}else{
// 				$(that).val('');
// 				layer.msg("手机号已被使用！");
// 			}
// 		}
// 	},'json')
// });

$('.b_P_Sort_list').on('click','li',function(){
	var r = $(this).attr('roleLevel');
	if(r=="ALL"){
		level = null;
	}else{
		level = r;
		
	}
	oTable1.fnClearTable();
	
});
</script>

