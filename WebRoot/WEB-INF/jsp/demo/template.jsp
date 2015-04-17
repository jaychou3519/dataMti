<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/comm.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>这是一个模板</title>
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
					<li class="active">测试</li>
				</ul>
			</div><!-- 内容导航条结束 -->
			
			<div class="page-content">
			<!-- 	<div class="page-header">
					<h1>
						简介
						<small>
							<i class="icon-double-angle-right"></i>
							这是一个ace模板
						</small>
					</h1>
				</div> -->
				
				
				<div class="goods_plane">
					 <div class="col-xs-12 col-sm-1 col-md-1 kinds_goods">
	                     <span class="owner_goods">姓名：</span>
	                     <input  type="text" id="seachname"  maxlength="20"  class="form-control owner_input" />
	                 </div>
	                 
	                 	
					  <div class="col-xs-12 col-sm-1 col-md-1 kinds_goods">
		                    <span class="owner_goods">时间：</span>
		                    	<div class="input-group">
									<input class="form-control date-picker " id="seachtime" type="text" readonly="readonly"  value="<fmt:formatDate value="${demo.time }" pattern="yyyy-MM-dd"/>"  datatype="*" nullmsg="请输入时间！"  />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
							</div>
		              </div>
	                 
	                 
		               <div class="col-xs-12 col-sm-1 col-md-1 kinds_goods">
		                      <span class="owner_goods">备注：</span>
		                      <select class="form-control owner_input" id="form-field-select-1">
			                        <option value="">请选择</option>
									<option value="AL">Alabama</option>
									<option value="AK">Alaska</option>
									<option value="AZ">Arizona</option>
									<option value="AR">Arkansas</option>
									<option value="CA">California</option>
									<option value="CO">Colorado</option>
									<option value="CT">Connecticut</option>
									<option value="DE">Delaware</option>										
		                      </select>
		                </div>
	                            
		                 <div class="col-xs-6 col-sm-1 col-md-1 button_goods">
		                	 <button class="btn btn-sm btn-danger" onclick="seachData()">查询</button>
		                 </div>
	             </div>

				<div class="row">
					<div class="col-xs-12">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
			
         	<div id="addDiv" class="modal"></div>  
  </body>
 
<script type="text/javascript" src="plug-in/js/comm/jquery_ui_dialog.js"></script> 
<script type="text/javascript" src="plug-in/js/template/template.js"></script>
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

  
