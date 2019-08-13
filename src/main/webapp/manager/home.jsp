<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="../css/style.css"/>
        <link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
        <link href="../assets/css/codemirror.css" rel="stylesheet">
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="../assets/js/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
        		<!--[if !IE]> -->
		<script src="../assets/js/jquery.min.js"></script>        
		<!-- <![endif]-->
           	<script src="../assets/dist/echarts.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/js/common/layui/css/layui.css" />
      	<script src="${pageContext.request.contextPath}/js/common/layui/layui.js" charset="utf-8"></script>
       <title>无标题文档</title>
       </head>
		
<body>
<div class="page-content clearfix">
 <div class="alert alert-block alert-success">
  <button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>
  <i class="icon-ok green"></i>欢迎使用<strong class="green">后台管理系统<small>(v1.2)</small></strong>
 </div>
 <div class="state-overview clearfix">
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                      <a href="#" title="商城会员">
                          <div class="symbol terques">
                             <i class="icon-user"></i>
                          </div>
                          <div class="value">
                              <h1>${total}</h1>
                              <p>商城用户</p>
                          </div>
                          </a>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol red">
                              <i class="icon-tags"></i>
                          </div>
                          <div class="value">
                              <h1>0</h1>
                              <p>分销记录</p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol yellow">
                              <i class="icon-shopping-cart"></i>
                          </div>
                          <div class="value">
                              <h1>${orders}</h1>
                              <p>商城订单</p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol blue">
                              <i class="icon-bar-chart"></i>
                          </div>
                          <div class="value">
                              <h1>￥${trading}</h1>
                              <p>交易记录</p>
                          </div>
                      </section>
                  </div>
              </div>
             <!--实时交易记录-->
             <div class="clearfix">
             <div class="t_Record">
               <div id="main" style="height:300px; overflow:hidden; width:100%; overflow:auto" ></div>     
              </div> 
<!--          <div class="news_style"> -->
<!--           <div class="title_name">最新消息</div> -->
<!--           <ul class="list"> -->
<!--            <li><i class="icon-bell red"></i><a href="#">还没有添加此功能。</a></li> -->
<!--           </ul> -->
<!--          </div>  -->
         </div>
 
<script type="text/javascript">
	var all = ${allOrder};
	var noPay = ${noPay};
	var noPay1 = ${noPay1};
	var pay = ${pay};
	var pay1 = ${pay1};
	var noSend = ${noSend};
	var noSend1 = ${noSend1};
     $(document).ready(function(){
		 
		  $(".t_Record").width($(window).width()-320);
		  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
		 $(".t_Record").width($(window).width()-320);
		});
 });
	 
	 
        require.config({
            paths: {
                echarts: '../assets/dist'
            }
        });
        require(
            [
                'echarts',
				'echarts/theme/macarons',
                'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                'echarts/chart/bar'
            ],
            function (ec,theme) {
                var myChart = ec.init(document.getElementById('main'),theme);
               option = {
    title : {
        text: '月购买订单交易记录',
        subtext: '实时获取用户订单购买记录'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['所有订单','待付款','已付款','代发货']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'所有订单',
            type:'bar',
            data:all,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            }           
        },
        {
            name:'待付款',
            type:'bar',
            data:noPay,
            markPoint : {
                data : [
                    {name : '年最高', value : noPay1[0], xAxis: noPay1[1], yAxis: noPay1[0], symbolSize:18},
                    {name : '年最低', value : noPay1[2], xAxis: noPay1[3], yAxis: 3}
                ]
            },
           
			
        }
		, {
            name:'已付款',
            type:'bar',
            data:pay,
            markPoint : {
                data : [
                    {name : '年最高', value : pay1[0], xAxis: pay1[1], yAxis: pay1[0], symbolSize:18},
                    {name : '年最低', value : pay1[2], xAxis: pay1[3], yAxis: 3}
                ]
            },
           
		}
		, {
            name:'代发货',
            type:'bar',
            data:noSend,
            markPoint : {
                data : [
                    {name : '年最高', value : noSend1[0], xAxis: noSend1[1], yAxis: noSend1[0], symbolSize:18},
                    {name : '年最低', value : noSend1[2], xAxis: noSend1[3], yAxis: 3}
                ]
            },
           
		}
    ]
};
                    
                myChart.setOption(option);
            }
        );
        layui.use('flow', function(){
        	  var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        	  var flow = layui.flow;
        	  flow.load({
        	    elem: '.list' //指定列表容器
        	    ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
        	      var lis = [];
        	      //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
        	      $.get('/api/list?page='+page, function(res){
        	        //假设你的列表返回在data集合中
        	        layui.each(res.data, function(index, item){
        	          lis.push('<li>'+ item.title +'</li>');
        	        }); 
        	        
        	        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
        	        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
        	        next(lis.join(''), page < res.pages);    
        	      });
        	    }
        	  });
        	});
    </script> 
     </div>
</body>
</html>
