<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/comm.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>错误</title>
    <%@include file="/context/mytags.jsp"%>
  </head>
  <body>
    <div class="col-xs-12">
		<div class="error-container">
			<div class="well">
				<h1 class="grey lighter smaller">
					<span class="blue bigger-125">
						<i class="icon-random"></i>
						对不起！
					</span>
					出错了。。。
				</h1>

				<hr>
				<h3 class="lighter smaller">
					
					<i class="icon-wrench icon-animated-wrench bigger-125"></i>
					${msg }
				</h3>

				<div class="space"></div>

			<!-- 	<div>
					<h4 class="lighter smaller">Meanwhile, try one of the following:</h4>

					<ul class="list-unstyled spaced inline bigger-110 margin-15">
						<li>
							<i class="icon-hand-right blue"></i>
							Read the faq
						</li>

						<li>
							<i class="icon-hand-right blue"></i>
							Give us more info on how this specific error occurred!
						</li>
					</ul>
				</div> -->

				<hr>
				<div class="space"></div>
				<div class="center">
					<a href="${pageContext.request.contextPath }/${herf }" class="btn btn-grey">
						<i class="icon-arrow-left"></i>
						后退
					</a>

				</div>
			</div>
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div>
  </body>
</html>
