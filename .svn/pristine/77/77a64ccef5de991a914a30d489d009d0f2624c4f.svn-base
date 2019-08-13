<%@page import="java.util.Iterator"%>
<%@page import="com.alibaba.fastjson.JSONObject"%>
<%@page import="com.alibaba.fastjson.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="com.abbot.schimneylife.pojo.shopping.MallProductParameter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
<title>商品详情页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/swiper-3.4.2.min.css" />
<!-- 当前网站样式！ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping/wap/shangpin_xiangqing.css" />

<!-- 清楚默认样式&公共样式! -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping/wap/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/shopping/layer_mobile/css/layer.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shopping/layer_mobile/layer.js"></script>
<!-- 网站根字体! -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shopping/wap/web.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery-1.11.1.js"></script>
<script
	src="${pageContext.request.contextPath}/js/common/swiper-3.4.2.min.js"></script>
<!--规格选择-->
<script src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common/iscroll.js"></script>
<script
	src="${pageContext.request.contextPath}/js/common/jquery.drawer.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common/websocket.js"></script>
<style type="text/css">
.swiper-pagination .swiper-pagination-bullet-active {
	background: white;
}
</style>

</head>

<body>

	<!--top-->
	<div class="top clearfix">
		<i class="fl"><img
			src="${pageContext.request.contextPath}/image/shopping/wap/left.png"
			alt="" /></i> <span>商品详情</span>
	</div>
	<!--banner-->
	<div class="banner swiper-container">
		<!-- 		<div class="swiper-container"> -->
		<div class="swiper-wrapper" onclick="banner()">
			
				<img class="swiper-slide"
					src="${pageContext.request.contextPath}/image/showImage.do?image=${product.imgSmall}"
					alt="" />
			
		</div>
		<div class="swiper-pagination"></div>
		<!-- 		</div> -->
	</div>
	
	<div class="banner_qp swiper-container2" onclick="nobanner()">
		<div class="swiper-wrapper">
			<c:forEach var="banner" items="${banners}" varStatus="status">
				<img class="swiper-slide"
					src="${pageContext.request.contextPath}/image/showImage.do?image=${banner.imgName}"
					alt="" />
			</c:forEach>
		</div>
		<div class="swiper-pagination1" style="color: #FFFFFF; font-size: 0.6rem; position: absolute; left:50%; margin-left: -0.5rem;"></div>
	</div>

	<div class="clearfix" style="width: 100%; background-color: #FDFBE6;"
		id="radio">
		<img
			src="${pageContext.request.contextPath}/image/shopping/wap/gonggao.png"
			style="width: 0.7rem; height: 0.7rem; margin-left: 0.592rem; margin-top: 0.5rem;"
			class="fl" alt="" />
		<div id="demo" class="qimo8 fl">
			<div class="qimo">
				<div id="demo1">
					<ul>
						<c:forEach var="radio" items="${radios}" varStatus="status">
							<li id="${radio.id}"><span>${radio.details} </span></li>
						</c:forEach>
					</ul>
				</div>
				<div id="demo2"></div>
			</div>
		</div>
	</div>

	<!--title&简介-->
	<div class="title">
		<span class="title_top">${product.productName}</span> <span
			class="title_bottom">${product.details}</span>
	</div>

	<!--价格&产地-->
	<div class="jiage_chandi clearfix">
		<span class="fl"><em>¥</em>${proParam.cur_price}<c:if
				test="${proParam.original!=proParam.cur_price}">
				<i>¥${proParam.original}</i>
			</c:if></span> <span style="display: inline-block;">库存：${proParam.repertory}</span>
		<%-- 			<span class="fr">产地：${product.productArea}</span> --%>
		<span class="fr">运费：包邮</span>
	</div>

	<ul class="renzheng clearfix">
		<li><em></em>企业认证</li>
		<li><em></em>食品许可</li>
		<li><em></em>担保交易</li>
		<li><em></em>极速退款</li>
	</ul>

	<div class="guige clearfix" id="guige" onclick="clli()">
		<span class="fl">规格数量选择</span> <img class="fr"
			src="${pageContext.request.contextPath}/image/shopping/wap/right.png"
			alt="" />
	</div>
	<div class="all-evalute"
		<c:if test="${totalResult==0}">style="display:none;"</c:if>>
		<!--评价-->
		<div class="pingjia">
			<div class="pingjia_top clearfix">
				<span class="fl">评价&nbsp;(&nbsp;<em>${totalResult}</em>&nbsp;)
				</span> <span class="fr">好评度<em>${praise}%</em></span>
			</div>
		</div>

		<!--评价内容-->
		<c:forEach var="evaluate" items="${evaluateList}" varStatus="status">
			<div class="pingjia_neirong">
				<div class="nr_top clearfix">
					<div class="fl">
						<c:choose>
							<c:when
								test="${evaluate.customer.ico==null||evaluate.customer.ico==''}">
								<img
									src="${pageContext.request.contextPath}/image/shopping/wap/wd_top_tx.png" />
							</c:when>
							<c:otherwise>
								<img
									src="${pageContext.request.contextPath}/image/showImage.do?image=${evaluate.customer.ico}" />
							</c:otherwise>
						</c:choose>
						<span>${evaluate.customer.nickName}</span>
					</div>
					<ul class="fr">
						<li><span>${evaluate.createTime}</span></li>
						<li><c:forEach var="i" begin="1" end="5" varStatus="status">
								<c:choose>
									<c:when test="${i<=evaluate.proStart}">
										<i class="active"></i>
									</c:when>
									<c:otherwise>
										<i></i>
									</c:otherwise>
								</c:choose>
							</c:forEach></li>
					</ul>
				</div>

				<div class="nr_bottom">
					<span class="nr">${evaluate.describe}</span>
					<ul class="clearfix">
						<c:if test="${!empty evaluate.img}">
							<c:forEach var="img" items="${evaluate.img.split(';')}"
								varStatus="status">
								<li class="fl"><img
									src="${pageContext.request.contextPath}/image/showImage.do?type=1&image=${img}"
									alt="" /></li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
			</div>
		</c:forEach>
		<c:if test="${totalResult>0}">
			<div class="chakan">
				<i>查看全部评价</i>
			</div>
		</c:if>
	</div>
	<div class="tab" js-tab="1" style="background-color: #FFFFFF;">
		<div class="tab-title" id="cccccc">
			<span class="item item-cur" id="item0">产品描述</span> <span class="item"
				id="item1">产品参数</span>
		</div>
		<div class="tab-cont swiper-container">
			<ul class="tab-cont__wrap swiper-wrapper">
				<li class="item swiper-slide"><c:forEach var="path"
						items="${paths}" varStatus="status">
						<img
							src="${pageContext.request.contextPath}/image/showImage.do?image=${path}" />
					</c:forEach></li>
				<li class="item shangpin_canshu swiper-slide">
					<table>
						<ul class="canshu_bottom">
							<%
								MallProductParameter param = (MallProductParameter) request.getAttribute("proParam");
								JSONArray first = JSONArray.parseArray(param.getFirstParam());
								JSONArray second = JSONArray.parseArray(param.getSecondParam());
								for (int i = 0; i < first.size(); i++) {
									String key = first.getJSONObject(i).keySet().iterator().next();
							%>
							<li style="margin-right: 0;"><em><%=key%></em><span
								class="cb_1"><%=first.getJSONObject(i).getString(key)%></span></li>
							<%
								}
								for (int i = 0; i < second.size(); i++) {
							%>
							<%
								String key = second.getJSONObject(i).keySet().iterator().next();
							%>
							<li><em><%=key%></em><span class="cb_3"><%=second.getJSONObject(i).getString(key)%></span></li>
							<%
								}
							%>
							<%-- 						<li>配料表<span class="cb_4"><c:choose><c:when test="${proParam.formula==null}">无</c:when><c:otherwise>${proParam.formula}</c:otherwise></c:choose></span></li> --%>
							<li class="cb_bottom"><em>保质期</em><span class="cb_5"><c:if
										test="${proParam.qualityYear!=null&&proParam.qualityYear!=0}">${proParam.qualityYear}年</c:if>
									<c:if
										test="${proParam.qualityMonth!=null&&proParam.qualityMonth!=0}">${proParam.qualityMonth}月</c:if>
									<c:if
										test="${proParam.qualityDay!=null&&proParam.qualityDay!=0}">${proParam.qualityDay}天</c:if></span></li>
						</ul>
					</table>
				</li>
			</ul>
		</div>
	</div>

	<!--产品描述-->

	<!--底部-->
	<ul class="dibu_nav clearfix" id="gwc">
		<li class="sc_li" onclick="clickDemo()">
			<div id="shoucang"
				<c:if test="${fav==1}">style="display:none;"</c:if>>
				<img
					src="${pageContext.request.contextPath}/image/shopping/wap/sc_xx.png"
					alt="" /> <span>收藏</span>
			</div>
			<div <c:if test="${fav==0}">style="display:none;"</c:if>
				id="qx_shoucang">
				<img
					src="${pageContext.request.contextPath}/image/shopping/wap/sc_xx_xz.png"
					alt="" /> <span style="color: #E69617;">已收藏</span>
			</div>
		</li>
		<li class="gwc_li" style="border-right: 1px solid #F0F0F0;"
			onclick="javascript:window.open('http://wpa.qq.com/msgrd?v=3&uin=2410934800&site=qq&menu=yes')">
			<img
			src="${pageContext.request.contextPath}/image/shopping/wap/sm_kefu.png"
			alt="" /> <em>客服</em>
		</li>
		<li class="gwc_li"
			onClick="javascript:window.location.href='${pageContext.request.contextPath}/cart/wap/myCart.do'">
			<img
			src="${pageContext.request.contextPath}/image/shopping/wap/gwc_che.png"
			alt="" /> <em>购物车</em>
		</li>
		<li class="jr_li"><b onclick="clli(0)">加入购物车</b></li>
		<li class="gm_li"><b onclick="clli(1)">立即购买</b></li>
	</ul>

	<div class="dino wrap" id="dinono"
		style="z-index: 2; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.5); position: fixed; left: 0; bottom: 0;">
		<!--选择规格-->
		<div id="wrap">

			<span onclick="off()" class="off"><img
				src="${pageContext.request.contextPath}/image/shopping/wap/off_1.png"
				alt="" /></span>

			<div class="wrap_top clearfix">
				<img
					src="${pageContext.request.contextPath}/image/showImage.do?image=${banners[0].imgName}"
					alt="" class="fl" onclick="banner2()" />
				<ul class="fl">
					<li style="color: #F10507;" paramId="${proParam.id}">¥<span
						id='price' price="${proParam.cur_price}" paramId="${proParam.id}">${proParam.cur_price}</span>
					</li>
					<li style="color: #8E8E8E;">库存<em id="repertory">${proParam.repertory}</em>件
					</li>
					<li style="color: #333333;">请选择规格</li>
				</ul>
			</div>
			<div class="banner_qp2">
				<img
					src="${pageContext.request.contextPath}/image/showImage.do?image=${banners[0].imgName}"
					alt="" onclick="nobanner2()"/>
			</div>
			<div id="top">

				<p class="p_num clearfix" style="margin-top: 1rem; font-size: 0;">
					<i class="fl" style="color: #8E8E8E; font-size: 0.6rem;">购买数量：</i>
					<i class="sy_minus fl" id="sy_minus_gid1">-</i><input
						class="sy_num fl" id="sy_num_gid1" onblur="lose()" type="text"
						name="number1" value="1" /><i class="sy_plus fl"
						id="sy_plus_gid1">+</i>
				</p>
			</div>

			<div id="bottom">
				<button style="background-color: #F09F1C;">加入购物车</button>
				<button>立即购买</button>
			</div>
		</div>
	</div>

	<ul class="bottom_logo">
		<li><i>店铺首页</i><span>|</span><i>关于我们</i><span>|</span><i>加盟代理</i></li>
		<li class="clearfix" style="margin-top: 0.8rem;"><img
			src="${pageContext.request.contextPath}/image/shopping/wap/erweima.png"
			style="width: 2.5rem; height: 2.5rem; margin-left: 4.27rem;" alt=""
			class="fl" /> <img
			src="${pageContext.request.contextPath}/image/shopping/wap/bottom_logo.png"
			style="width: 4.27rem; margin-left: 0.3rem; margin-top: 0.4rem;"
			alt="" class="fl" /></li>
	</ul>


	<a href="javascript:scroll(0,0)" class="fhdb"></a>

</body>

<script type="text/javascript">
	$(document).scroll(function(){
			if($(document).scrollTop() >= 40){
				$(".fhdb").css("opacity","1");
			}else{
				$(".fhdb").css("opacity","0");
			}
		})
</script>
<script type="text/javascript">
		var a1 = ${fav};
		var demoParam = {pid:'${product.id}'};
		function clickDemo() {
			if(a1 == 0) {//添加收藏
				a1 = 1;
				$.post('<%=response.encodeURL(request.getContextPath() + "/favourites/addFavourites.do")%>',
						demoParam,
						function(data){
					if(data.code&&data.code==2){
						window.location.href = data.path;
					}else{
						if(data.result==true){
							$("#shoucang").hide();
							$("#qx_shoucang").show();
						}else{
							layer.open({
								content : "添加收藏失败！",
								skin : 'msg',
								time : 2
							//2秒后自动关闭
							});
						}
					}
				},'json');
			} else {//取消收藏
				a1 = 0;
				$.post('<%=response.encodeURL(request.getContextPath() + "/favourites/deleteByProId.do")%>',
						demoParam,
						function(data){
					if(data.code&&data.code==2){
						window.location.href = data.path;
					}else{
						if(data.result==true){
							$("#shoucang").show();
							$("#qx_shoucang").hide();
						}else{
							layer.open({
								content : " 取消收藏失败！",
								skin : 'msg',
								time : 2
							//2秒后自动关闭
							});
							 
						}
					}
				},'json');
			}
		}
		(function() {
			var isNed = false;
			var height = $('.tab-title').height();
			$(window).scroll(function() {
				var top = $('.tab-title').offset().top - $(document).scrollTop();
				if(top < 0 && !isNed) {
					isNed = true;
					$('.tab-title').css({
						"position": "fixed",
						"top": "1.95rem"
					});
					return true;
				}
				var childTop = $('.tab-cont').offset().top - $(document).scrollTop();
				if(childTop > height && isNed) {
					isNed = false;
					$('.tab-title').css({
						"position": "",
						"top": ""
					});

				}
			});
		})()
		var params = ${params};
		function clli(index) {
			$('#model').find('em').first().click();
			$(".dino").attr("class", "");
		}
		function go(index){
			if(index==0){//加入购物车
				var paramId = $('#price').attr('paramId');
				var num = $('#sy_num_gid1').val();
				var proId = '${product.id}';
				$.post('<%=response.encodeUrl(request.getContextPath() + "/cart/addCart.do")%>',
							{
								proId : proId,
								paramId : paramId,
								num : num
							}, function(data) {
								if (data.code == 0 && data.result == true) {
									off();
									layer.open({
										content : "添加成功",
										skin : 'msg',
										time : 2
									//2秒后自动关闭
									});
								}
								if (data.code == 2) {
									window.location.href = data.path;
								}
							}, 'json');
		}else if(index == 1){
			var paramId = $('#price').attr('paramId');
			var num = $('#sy_num_gid1').val();
			var proId = '${product.id}';
			window.location.href = '<%=response.encodeURL(request.getContextPath()+"/order/placeOrderNow.do")%>?paramId='+paramId+'&count='+num+'&productId='+ proId;
			<%-- $.post('<%=response.encodeUrl(request.getContextPath() + "/order/placeOrderNow.do")%>?paramId='+paramId+'&count='+num+'&productId='+ proId,
						{
							proId : proId,
							paramId : paramId,
							num : num
						}, function(data) {
							if (data.code == 0 && data.result == true) {
								
								off();
								
							}
							if (data.code == 2) {
								window.location.href = data.path;
							}
						}, 'json'); --%>
		} 
	}

	$(document).bind('click',function(e) {
						var e = e || window.event; //浏览器兼容性   
						var elem = e.target || e.srcElement;
						while (elem) { //循环判断至跟节点，防止点击的是div子元素   
							if (elem.id	&& (elem.id == 'wrap' || elem.id == 'gwc' || elem.id == 'guige')) {
								return;
							}
							elem = elem.parentNode;
						}
						$('#dinono').attr('class', 'dino'); //点击的不是div或其子元素   
					});

	$(document).ready(function() {
		$(".sy_minus").click(
				function() {
					var me = $(this), txt = me.next(":text"), pc = me.closest("p");
					var val = parseFloat(txt.val());
					val = val - 1 < 1 ? 1 : val - 1;
					txt.val(val);
					price();
		});
		$(".sy_plus").click(
				function() {
					var me = $(this), txt = me.prev(":text"), pc = me.closest("p");
					var val = parseFloat(txt.val());
					txt.val(val + 1);
					price();
			});
			//初始化规格参数
			var str = [];
			var o = params;
			var index = 0;
			while (o.length > 0) {
				str = [];
				str.push('<p index="' + (index++) + '"><font>'+ o[0].key + '</font>');
				for (var i = 0; i < o.length; i++) {
					if (o[i].end) {
						str.push('<em index="'+i+'" paramId="'+o[i].id+'" price="'+o[i].price+'">' + o[i].value + '</em>');
					} else {
						str.push('<em index="'+i+'">' + o[i].value + '</em>');
					}
				}
				str.push('</p>');
				$('.p_num').before(str.join(''));
				o = o[0].datas;
			}
			// 		$('#top p:not(:last) em:nth-child(2)').addClass('on');
			$('.p_num').parents('#top').find('p').each(function(){
				$(this).find('em:first').addClass('on');
			});
		})
	//规格参数点击事件
	$('#top').on('click','p:not(:last) em',
					function() {
						$(this).siblings('em').removeClass('on');
						$(this).addClass('on');
						var paramId = $(this).attr('paramId');
						if (paramId) {
							$('#price').html($(this).attr('price'));
							$('#repertory').html($(this).attr('repertory'));
							$('#price').attr('paramId', paramId);
							$('#price').attr('price', $(this).attr('price'));
							return false;
						}
						var that = this;
						var strs = [];
						$('#top').find('.on').each(function() {
							strs.push({
								value : $(this).html(),
								index : $(this).attr('index')
							});
							if ($(this).is(that)) {
								return false;
							}
						})
						var datas = params;
						for (var i = 0; i < strs.length; i++) {
							datas = datas[strs[i].index].datas;
						}
						$(this).parents('p:first').nextUntil('.p_num').remove();
						var index = strs[strs.length - 1].index;
						var str = [];
						while (true) {
							if (datas.length == 0) {
								break;
							}
							str = [];
							str.push('<p index="' + (index++) + '"><font>' + datas[0].key + '</font>');
							for (var i = 0; i < datas.length; i++) {
								if (datas[i].end) {
									str.push('<em index="'+i+'" paramId="'+datas[i].id+'" price="'+datas[i].price+'" repertory="'+datas[i].repertory+'">' + datas[i].value + '</em>');
								} else {
									str.push('<em index="'+i+'">' + datas[i].value + '</em>');
								}
							}
							str.push('</p>');
							$('.p_num').before(str.join(''));
							if (datas[0].end) {
								$('#price').html(datas[0].price);
								$('#price').attr('paramId', datas[0].id);
								break;
							}

							datas = datas[0].datas;
						}
						$(this).parents('p:first').nextUntil('.p_num').find(
								'em:nth-child(2)').addClass('on');
					});

	function price() {
		var count = $('#sy_num_gid1').val();
		var price = $('#price').attr('price');
		$('#price').html((parseFloat(count) * parseFloat(price)).toFixed(2));
	}
	function off() {
		$('#dinono').attr("class", "dino");
	}
	var mySwiper = new Swiper('.banner', {
		loop : true,
		pagination : '.swiper-pagination'
	})
	var mySwiper = new Swiper('.swiper-container2', {
		pagination: '.swiper-pagination1',
		paginationType: 'fraction',
		autoplay:2000,
		//paginationType : 'progress',
		//paginationType : 'custom',
		loop: true,
	})
	function goBack() {
		var histo = document.referrer;
		 
		histo = histo.split('?')[0];
		
		if ( histo.indexOf("updateOrder.do")>0) {
			self.location = '${pageContext.request.contextPath}/wap/home/index.do';
		}else{
			history.go(-1);
		}
	}
	//处理消息部分
	onMessage = function(data) {
		if (!data) {
			return false;
		}
		data = JSON.parse(data);
		if (data.type == 0) {//广播类信息
			if (data.handle == "ADD") {//添加新的广播
				$('#radio').show();
				$('#radio').find('ul').append('<li id="'+data.content.id+'"><span>'	+ data.content.details + '</span></li>')
			} else if (data.handle == "DEL") {//删除广播
				$("#radio ul li[id='" + data.content.id + "']").remove();
				if ($('#radio ul:first li').length == 0) {
					$('#radio').hide();
				}
			}
		} else if (data.type == 1) {//消息类信息
			if (data.handle == "ADD") {
				$('.xiaoxi em').show();
			} else if (data.handle == "DEL") {

			}
		}
	}
	if ($('#radio ul:first li').length == 0) {
		$('#radio').hide();
	}
</script>

<script type="text/javascript">
	var demo = document.getElementById("demo");
	var demo1 = document.getElementById("demo1");
	var demo2 = document.getElementById("demo2");
	demo2.innerHTML = document.getElementById("demo1").innerHTML;

	function Marquee() {
		if (demo.scrollLeft - demo2.offsetWidth >= 0) {
			demo.scrollLeft -= demo1.offsetWidth;
		} else {
			demo.scrollLeft++;
		}
	}
	var myvar = setInterval(Marquee, 30);
	demo.onmouseout = function() {
		myvar = setInterval(Marquee, 30);
	}
	demo.onmouseover = function() {
		clearInterval(myvar);
	}
</script>

<script type="text/javascript">
		function banner(){
			$(".banner_qp").css("visibility","visible");
		}
		
		function nobanner(){
			$(".banner_qp").css("visibility","hidden");
		}
	</script>
	
	<script type="text/javascript">
		function banner2(){
			$(".banner_qp2").css("visibility","visible");
			$(".fhdb").css("opacity","0");
		}
		
		function nobanner2(){
			$(".banner_qp2").css("visibility","hidden");
			$(".fhdb").css("opacity","1");
		}
	</script>

<!--swiper插件JS-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/swiper-3.4.2.min.js"></script>
<script type="text/javascript">
	var showTime = 0;
	var mySwiper1 = new Swiper('.swiper-container', {
		onSlideChangeEnd : function(swiper) {
			if (swiper.activeIndex == 1) {
				$("#item1").addClass("item-cur");
				$("#item0").removeClass("item-cur");
				$(".tab-cont__wrap").animate({
					height : $(".shangpin_canshu").height(),
					overflow : "hidden",
				}, showTime);
			} else {
				$("#item0").addClass("item-cur");
				$("#item1").removeClass("item-cur");
				$(".tab-cont__wrap").animate({
					height : "100%",
					overflow : "",
				}, showTime);
			}
		},
		prevButton : '#item0',
		nextButton : '#item1'
	});
	
</script>

</html>