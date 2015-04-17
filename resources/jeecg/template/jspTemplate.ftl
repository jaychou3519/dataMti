<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/comm.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>${codeName}</title>
    <%@include file="/context/mytags.jsp"%>
  </head>
  <body>
  			<!-- 内容导航条开始 -->
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">首页</a>
					</li>
					<li class="active">${codeName}</li>
				</ul>
			</div><!-- 内容导航条结束 -->
			
			<div class="page-content">
				<div class="goods_plane">
						#foreach($po in $!{columnDatas})
						#if  ($po.columnName !='id' && $velocityCount  < 4)
									 <div class="col-xs-12 col-sm-1 col-md-1 kinds_goods">
					                     <span class="owner_goods">${po.columnComment}:</span>
					                     <input  type="text" name="${po.columnName}" id="seach${po.columnName}"  maxlength="20"  class="form-control owner_input" />
					                 </div>
						#end
						#end
	                            
		                 <div class="col-xs-6 col-sm-1 col-md-1 button_goods">
		                	 <button class="btn btn-sm btn-danger" onclick="seachData()">查询</button>
		                 </div>
	             </div>

				<div class="row">
					<div class="col-xs-12">
						<table id="${lowerName}table"></table>
						<div id="${lowerName}pager"></div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
			
         	<div id="addDiv" class="modal"></div>  
  </body>
 

<script type="text/javascript" src="plug-in/js/comm/jquery_ui_dialog.js"></script> 
<script type="text/javascript" src="plug-in/js/${bussPackage}/${entityPackage}/page-${lowerName}.js"></script>

<script type="text/javascript">
	$('.date-picker').datepicker({
					autoclose:true
			 }).next().on(
			 	ace.click_event, 
				 function(){
				$(this).prev().focus();
			 });
</script>
</html>

  
