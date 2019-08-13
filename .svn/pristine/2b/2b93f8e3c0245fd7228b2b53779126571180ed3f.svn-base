<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath}/manager/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/assets/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/css/style.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script
	src="${pageContext.request.contextPath}/manager/assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<script
	src="${pageContext.request.contextPath}/manager/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/manager/assets/layer/layer.js"
	type="text/javascript"></script>
<title>登陆</title>
</head>

<body class="login-layout">
	<div class="logintop">
		<span>欢迎使用新盟易购后台管理界面平台</span>
		<ul>
			<li><a href="#">返回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<div class="login-container">
			<div class="center">
				<h1>
					<i class="icon-leaf green"></i> <span class="orange">唐森科技</span> <span
						class="white">后台管理系统</span>
				</h1>
				<h4 class="white">Background Management System</h4>
			</div>

			<div class="space-6"></div>

			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i> 管理员登陆
							</h4>

							<div class="login_icon">
								<img
									src="${pageContext.request.contextPath}/manager/images/login.png" />
							</div>

							<form class="">
								<fieldset>
									<label class="block clearfix"> <span
										class="block input-icon input-icon-right"> <input
											type="text" class="form-control" placeholder="登录名" name="登录名"
											id="loginName"> <i class="icon-user"></i>
									</span>
									</label> <label class="block clearfix"> <span
										class="block input-icon input-icon-right"> <input
											type="password" class="form-control" placeholder="密码"
											name="密码" id="password"> <i class="icon-lock"></i>
									</span>
									</label>

									<div class="space"></div>

									<div class="clearfix">
										<label class="inline"> <input type="checkbox"
											class="ace" id="remember"> <span class="lbl">保存密码</span>
										</label>

										<button type="button"
											class="width-35 pull-right btn btn-sm btn-primary"
											id="login_btn">
											<i class="icon-key"></i> 登陆
										</button>
									</div>

									<div class="space-4"></div>
								</fieldset>
							</form>

							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>

							<div class="social-login center">本网站系统不再对IE8以下浏览器支持，请见谅。</div>
						</div>
						<!-- /widget-main -->

						<div class="toolbar clearfix"></div>
					</div>
					<!-- /widget-body -->
				</div>
				<!-- /login-box -->
			</div>
			<!-- /position-relative -->
		</div>
	</div>
	<div class="loginbm">
		版权所有 2017 <a href="">唐森科技有限公司</a>
	</div>
	<strong></strong>
</body>
</html>
<script>
	$('#login_btn')
			.on(
					'click',
					function() {
						var num = 0;
						var str = "";
						$("input[type$='text']").each(
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
							var loginName = $('#loginName').val();
							var password = $('#password').val();
							
							$.post('${pageContext.request.contextPath}/manager/user/to/in.do',
											{
												loginName : loginName,
												password : password
											},
											function(data) {
												var msg = '登录名或密码错误！';
												if (data.result == true) {
													msg = '登陆成功！';
													onsubmit();
													setTimeout(
															function() {
																window.location.href = '${pageContext.request.contextPath}/manager/system/index.do';
															}, 1500);
												}
												layer.msg(msg);

												layer.close();
											}, 'json');

						}

					})
  //设置cookie
  function setCookie(name,value,day){
    var date = new Date();
    date.setDate(date.getDate() + day);
    document.cookie = name + '=' + value + ';expires='+ date;
  };
  //获取cookie
  function getCookie(name){
    var reg = RegExp(name+'=([^;]+)');
    var arr = document.cookie.match(reg);
    if(arr){
      return arr[1];
    }else{
      return '';
    }
  };
  //删除cookie
  function delCookie(name){
    setCookie(name,null,-1);
  };
  var onsubmit;
  window.onload = function(){
    var oForm = document.getElementById('loginForm');
    var oUser = document.getElementById('loginName');
    var oPswd = document.getElementById('password');
    var oRemember = document.getElementById('remember');
    //页面初始化时，如果帐号密码cookie存在则填充
    if(getCookie('user') && getCookie('pswd')){
      oUser.value = getCookie('user');
      oPswd.value = getCookie('pswd');
      oRemember.checked = true;
    }
    //复选框勾选状态发生改变时，如果未勾选则清除cookie
    oRemember.onchange = function(){
      if(!this.checked){
        delCookie('user');
        delCookie('pswd');
      }
    };
    //表单提交事件触发时，如果复选框是勾选状态则保存cookie
    onsubmit = function(){
      if(remember.checked){ 
        setCookie('user',oUser.value,7); //保存帐号到cookie，有效期7天
        setCookie('pswd',oPswd.value,7); //保存密码到cookie，有效期7天
      }
    };
  };
//登陆按钮响应enter事件
$(window).keydown(function(event){
  switch(event.keyCode) {
    // ...
    // 不同的按键可以做不同的事情
    // 不同的浏览器的keycode不同
    // 更多详细信息:     http://unixpapa.com/js/key.html
    // 常用keyCode： 空格 32   Enter 13   ESC 27
    case 13:
    	$('#login_btn').click();
    	break;
  }
});
</script>