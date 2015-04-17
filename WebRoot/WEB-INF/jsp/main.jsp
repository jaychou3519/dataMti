<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/context/comm.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>主页</title>
  </head>
	<%@include file="/context/mytags.jsp"%>
  <body>
  		<!-- 头部开始 -->
  		<div class="navbar navbar-default" id="navbar">
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf green"></i>
									<span class="red">JT56</span>
									<span class="white">基础系统</span>
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-ok"></i>
									4 条任务
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">软件更新</span>
											<span class="pull-right">65%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:65%" class="progress-bar "></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">硬件升级</span>
											<span class="pull-right">35%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:35%" class="progress-bar progress-bar-danger"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">单元测试</span>
											<span class="pull-right">15%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:15%" class="progress-bar progress-bar-warning"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">BUG解决</span>
											<span class="pull-right">90%</span>
										</div>

										<div class="progress progress-mini progress-striped active">
											<div style="width:90%" class="progress-bar progress-bar-success"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										查看任务详情
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>

							<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-warning-sign"></i>
									8 条动态
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												新的评论
											</span>
											<span class="pull-right badge badge-info">+12</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<i class="btn btn-xs btn-primary icon-user"></i>
										毛佳刚刚唱了一首歌 ...
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
												新的订单
											</span>
											<span class="pull-right badge badge-success">+8</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info icon-twitter"></i>
												听众
											</span>
											<span class="pull-right badge badge-info">+11</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										查看所有动态
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-envelope-alt"></i>
									5条信息
								</li>

								<li>
									<a href="#">
										<img src="plug-in/ace1.2/assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">张三:</span>
												快还钱 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>欠我的钱什么时候还！！</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img src="plug-in/ace1.2/assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">李四:</span>
												关于ace ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>深入浅出ace框架...</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img src="plug-in/ace1.2/assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">王五:</span>
												爱情 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>再也不相信爱情了...</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="inbox.html">
										查看所有信息
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>


						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="plug-in/ace1.2/assets/avatars/user.jpg" alt="账号信息" />
								<span class="user-info">
									<small>欢迎,</small>
									管理员
								</span>
								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										账号信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#" onclick="logout();">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	
		
		
		<!-- 中间开始 -->
		<div class="main-container" id="main-container">

			<div class="main-container-inner">
				
				<!-- 左边菜单栏开始 -->
				<div class="sidebar" id="sidebar">
					<!-- 左上角四个图标开始 -->
					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>
					</div>
					<!-- 左上角四个图标结束 -->
					
					<!-- 功能菜单开始 -->
					<ul class="nav nav-list">
						<li class="active">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 功能菜单 </span>
							</a>
						</li>
						
						
						<c:forEach items="${menuList }" var="menu">
							<li>
								<a href="#"  <c:if test="${fn:length(menu.children) == 0 }"> onclick="pageJump('${menu.url }')"</c:if> 
								<c:if test="${fn:length(menu.children) > 0 }">class="dropdown-toggle"</c:if>>
									<i class="${menu.imgurl }"></i>
									<span class="menu-text"> ${menu.name }</span>
									<c:if test="${fn:length(menu.children) > 0 }">
											<b class="arrow icon-angle-down"></b>
									</c:if>
								</a>
								<c:if test="${fn:length(menu.children) > 0 }">
									<ul class="submenu">
										<c:forEach items="${menu.children }" var="children">
											<li> 
												<a href="#" onclick="pageJump('${children.url }')">
													<i class="icon-double-angle-right"></i>
													${children.name }
												</a>
											</li>
										</c:forEach>
									</ul>
								</c:if>
							</li>
						</c:forEach>
					</ul><!-- /.nav-list -->
					<!-- 功能菜单结束-->
					
					<!-- 隐藏菜单栏样式开始-->
					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div><!-- 隐藏菜单栏样式结束 -->
				</div>


				<!-- 主页面开始 -->
				<div class="main-content">
					 <iframe src="demoController.do?totemplate"  id="ifm" frameborder="0" marginheight="0" marginwidth="0" frameborder="0" scrolling="auto" onload="javascript:dyniframesize('ifm');" width="100%"></iframe>
				</div><!-- 主页面结束-->
				
				
				<script type="text/javascript">
						//iframe自适应高度
						function dyniframesize(down) {
							var pTar = null;
							if (document.getElementById){
								pTar = document.getElementById(down);
							}
							else{
								eval('pTar = ' + down + ';');
							}
							if (pTar && !window.opera){
								//begin resizing iframe
									pTar.style.display="block";
								if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight){
									//ns6 syntax
									pTar.height = pTar.contentDocument.body.offsetHeight +20;
									//pTar.width = pTar.contentDocument.body.scrollWidth+20;
								}
								else if (pTar.Document && pTar.Document.body.scrollHeight){
									//ie5+ syntax
									pTar.height = pTar.Document.body.scrollHeight;
									pTar.width = pTar.Document.body.scrollWidth;
								}
							}
						}
						
						/* function onloads(){
							var msg = "${msg }";
							if(msg != null){
								window.location.href="${pageContext.request.contextPath }/loginController.do?main";
							}
						} */
						
						//页面跳转
						function pageJump(url){
							$("#ifm").attr("src",url);
						}
						//退出
						function logout(){
							window.location.href="${pageContext.request.contextPath }/index.jsp";
						}
						
			  </script>

				<!-- 页面设置菜单-->
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; 选择皮肤</span>
						</div>

					</div>
				</div>
			</div>
			
			<!-- 回到顶部按钮 -->
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div>
		
		
  
  </body>
</html>
