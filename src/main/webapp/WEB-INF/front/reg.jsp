<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />

<title>用户中心_IT营</title>

<link rel="shortcut icon" href="favicon.ico" />
<link rel="icon" href="animated_favicon.gif" type="static/image/gif" />
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<link href="static/css/easyui.css" rel="stylesheet" type="text/css" />
<link href="static/css/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="static/js/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="static/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/js/jquery.validate.js"></script>
<body>
	<meta property="qc:admins" content="510003565761411676375" />


	<script type="text/javascript">
		
	</script>
	<!--
<div style="width:100%; height:30spx; line-height:30px; background:#fefeee; text-align:center; font-size:16px;">
	<a style="color:#F00; text-align:center; " href="http://bbs.phonegap100.com/thread-296-1-1.html" target="_blank">【点击下载】Html5+PhoneGap跨平台移动APP开发教程</a>
</div>

--->

	<div id="toolbar">
		<div class="heaTop w">
			<div class="f_l">
				<a href="#" class="shouye">返回首页</a> <a href="javascript:void(0);"
					onclick="AddFavorite('我的网站',location.href)" class="heaTopFav">收藏本站</a>
				<script type="text/javascript" src="static/js/utils.js"></script>
				<span class="heaHalving"> <a href="flow.php">查看购物车</a> </span>
			</div>

			<div class="f_r">



				<font id="ECS_MEMBERZONE" class="f_l"> 欢迎光临本店！&nbsp;&nbsp; <span
					id="topLoginDiv" class="heaTopHighlight"
					style="display:inline-block;"> <a href="user.php"
						class="bgNone" target="_blank">登录</a><a
						href="user.php?act=register" target="_blank" class="popHover">注册</a>
				</span> </font> &nbsp;&nbsp

			</div>

			<!--
        <div class="f_r">
        	 <a href="user.php?act=oath&type=qq"><img style="padding-top:3px;" src="static/image/qq_login.gif"/> &nbsp;&nbsp
        </div>
      -->

		</div>
	</div>



	<div id="head">
		<div class="hd">
			<p class="heaLogo f_l">
				<a href="index.php" target="_parent" title="IT营"> <img
					src="static/image/logo.gif" alt="IT营">
				</a>
			</p>
			<div class="hd_search f_l">
				<div class="tab_search ">

					<div id="search" class="clearfix">
						<form id="searchForm" name="searchForm" method="get"
							action="search.php" onSubmit="return checkSearchForm()"
							class="f_r">
							<input name="keywords" type="text" id="searchinput" value=""
								class="f_l searchinput" /> <input name="imageField"
								type="submit" value="" class="searchbtn"
								style="cursor:pointer; border:none" />
						</form>
						<div class="keys f_l">


							<font>热门搜索 ：</font> <a href="search.php?keywords=Html5">Html5</a>
							<a href="search.php?keywords=PhoneGap">PhoneGap</a> <a
								href="search.php?keywords=php%E6%95%99%E7%A8%8B">php教程</a> <a
								href="search.php?keywords=Hadoop">Hadoop</a> <a
								href="search.php?keywords=Angularjs">Angularjs</a> <a
								href="search.php?keywords=cocos2d">cocos2d</a> <a
								href="search.php?keywords=NoSql">NoSql</a> <a
								href="search.php?keywords=Css3">Css3</a>
						</div>

					</div>

				</div>
			</div>

			<div class="heaCar" onmouseover="this.className='heaCar heaCar_on'"
				onmouseout="this.className='heaCar'">
				<div class="clearfix" id="ECS_CARTINFO">
					<a href="flow.php">购物车&nbsp;( <a href="flow.php" title="查看购物车">0</a>
						)&nbsp;件 </a>
				</div>
			</div>
		</div>

	</div>

	<div id="heaNav">
		<div class="bd">
			<p class="heaNavOnly">
				<a href="catalog.php"> 所有课程分类</a>
			</p>
			<ul class="heaNavNone">
				<li class="heaNav"><a href="http://www.itying.com/" class="cur">首页</a>
				</li>
				<li class="heaNav"><a href="category-1-b0.html" title="手机开发">手机开发</a>
				</li>
				<li class="heaNav"><a href="category-6-b0.html" title="网站开发">网站开发</a>
				</li>
				<li class="heaNav"><a href="category-12-b0.html" title="平面设计">平面设计</a>
				</li>
				<li class="heaNav"><a href="category-19-b0.html" title="数据库">数据库</a>
				</li>
				<li class="heaNav"><a href="category-28-b0.html" title="网络营销">网络营销</a>
				</li>
				<li class="heaNav"><a href="category-24-b0.html" title="IT新技术">IT新技术</a>
				</li>
				<li class="heaNav"><a href="category-41-b0.html"
					title="html5教程">html5教程</a>
				</li>
				<li class="heaNav"><a
					href="http://www.phonegap100.com/course.php" target="_blank"
					title="phonegap">phonegap</a>
				</li>
			</ul>

		</div>
	</div>
	<div class="block box">
		<div id="ur_here">
			<div class="box">
				<div id="ur_here">
					当前位置: <a href=".">首页</a>
					<code>&gt;</code>
					用户中心
				</div>
			</div>
			<div class="blank"></div>
		</div>
	</div>

	<div class="blank"></div>
	<div class="usBox clearfix">
		<div class="regtitle">用户注册</div>
		<div class="usBox_2 f_l clearfix">
			<form action="register.jhtml" method="get" id="form">
				<table width="100%" border="0" align="left" cellpadding="5"
					cellspacing="3">
					<tr>
						<td width="13%" align="right">用户名</td>
						<td width="87%"><input name="username" type="text" size="25"
							id="username" onblur="is_registered(this.value);" class="inputBg" />
							<span id="username_notice" style="color:#FF0000"> *</span>
						</td>
					</tr>
					<tr>
						<td align="right">email</td>
						<script>
							$(function() {
								$("#form")
										.validate(
												{
													rules : {
														username : {
															required : true
														},
														email : {
															required : true,
															email : true,
															remote : { //验证用户名是否存在
																type : "POST",
																url : "validEmail.jhtml", //servlet
																data : {
																	name : function() {
																		return $(
																				"#email")
																				.val();
																	}
																}
															}
														},
														password : {
															required : true
														},
														confirm_password : {
															required : true,
															equalTo : "#password"
														}
													},
													messages : {
														username : "请输入姓名",
														email : {
															required : "请输入Email地址",
															email : "请输入正确的email地址",
															remote : "邮箱已经存在"
														},
														password : "请输入密码",
														confirm_password : {
															required : "请输入确认密码",
															equalTo : "必须和密码一致"
														}
													}
												});
							});
							/* $(function(){
								 $("#form").form("validate");
								$("#email").blur(function(){
									if($("#email")==""){
										alert("邮箱必填");
									}else{
										//ajax
										$.post(
												"validEmail.jhtml",
												 {email:$("#email").val()},
												  
												  function(data){
													 if(data!="success"){
														 alert(data);
													 }
										});
									}
								});
							}); */
						</script>
						<td><input name="email" type="text" size="25" id="email"
							class="inputBg" /> <span style="color:#FF0000"> *</span>
						</td>
					</tr>
					<tr>
						<td align="right">密码</td>
						<td><input name="password" type="password" id="password"
							class="inputBg" style="width:179px;" /> <span
							style="color:#FF0000" id="password_notice"> *</span>
						</td>
					</tr>
					<tr>
						<td align="right">确认密码</td>
						<td><input name="confirm_password" type="password"
							id="conform_password"
							onblur="check_conform_password(this.value);" class="inputBg"
							style="width:179px;" /> <span style="color:#FF0000"
							id="conform_password_notice"> *</span>
						</td>
					</tr>
					<tr>
						<td align="right">验证码<input name="validateCode"
							style="width: 60px;" />
						</td>
						<td><img id="validateCode" src="validateCode.jhtml"
							style="width:80px;" /> <span style="color:#FF0000"
							id="conform_password_notice"> *<input type="button"
								value="refesh" id="reflesh" />
						</span>
						</td>
					</tr>
					<script>
						$(function() {
							$("#reflesh").click(function() {
								var timenow = new Date().getTime();
								var url = "validateCode.jhtml?time=" + timenow;
								$("#validateCode").attr("src", url);
							});

						});
					</script>
					<!-- <tr>
					 <td>&nbsp;</td>
					 <td>
					 <div>
					 	<span id="getId" class="classId" name="nameId">111111</span>
					 	<span><input type="text" id="getIdText" value="333333" name="nameText"/></span>
					 	<p>222222</p>
					 	<div id="namediv">
					 	  <input type="text" name="nameText" value="44444" />
					 	</div>
					 	
					 </div>
					 
					 </td>
					</tr> -->
					<tr>
						<td>&nbsp;</td>
						<td align="left"><input name="act" type="submit" value="确定">
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td class="actionSub"><a href="#">我已有账号，我要登录</a><br /> <a
							href="#">您忘记密码了吗？</a>
						</td>
					</tr>
				</table>
			</form>
		</div>

		<div class="usTxt" style="padding-top:60px; padding-bottom:60px;">
			<strong>如果您是会员，请登录</strong> <br> <strong class="f4">友情提示：</strong><br>
			您已经有本站账户请登录 <br>
			<br> <a href="#"><img src="static/image/bnt_ur_log.gif">
			</a>
		</div>


	</div>









	<div class="blank"></div>







	<div id="footer" style="background:none;">
		<div style="height:1px; width:1px; overflow:hidden;">
			<a href="http://www.ecshop.com" target="_blank"
				style=" font-family:Verdana; font-size:11px;">Powered&nbsp;by&nbsp;<strong><span
					style="color: #3366FF">ECShop</span>&nbsp;<span
					style="color: #FF9966">v2.7.3</span>
			</strong>
			</a>&nbsp;<a
				href="http://www.ecshop.com/license.php?product=ecshop_b2c&url=http%3A%2F%2Fwww.itying.com%2F"
				target="_blank">&nbsp;&nbsp;Licensed</a><br />
		</div>
	</div>

	<div id="banquan_nav">

		<div id="bottomNav" class="box">
			<div class="box_1">
				<a href="http://www.itying.com/article.php?id=8" target="_blank">联系我们</a>
				| <a href="http://www.itying.com/article.php?id=7" target="_blank">免责说明</a>

				<!--<div class="f_r">
   <a href="#top"><img src="static/image/bnt_top.gif" /></a> <a href="index.php"><img src="static/image/bnt_home.gif" /></a>
   </div>-->
				<div class="f_r" id="returnTop"
					style="display: block; background-position: 0px -81px; ">
					<a href="#top"></a>
				</div>

			</div>
		</div>


		<p class="fooCorpy">



			凡本网站转载的文章、图片等资料的版权归版权所有人所有，因无法和版权所有者一一联系，如果本网站选取的文/图威胁到您的权益，请您及时和本网站联系。<br />我们会在第一时间内采取措施，避免给双方造
			成不必要的损失。 <br /> <br /> ICP备案证书号:<a
				href="http://www.miibeian.gov.cn/" target="_blank">京ICP备13027796号-5</a><br />
			&copy; 2005-2015 IT营 版权所有，并保留所有权利。 <br>
		<div style="margin:3px auto; height:20px; text-align:center">
			技术支持: <a href="http://www.phonegap100.com/" target="_blank">phonegap中文网</a>
		</div>
	</div>

	<div id="div_leftfloat">
		<a href="javascript:closeLeftFloat();" class="float_1"></a> <a
			href="javascript:void(0);" class="float_2"></a>

	</div>


</body>

</html>
