<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/context/comm.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑</title>
  </head>
  <body>
	 <div class="modal-dialog" style="width:980px;">
      <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title">${title }</h4>
              </div>
              
             <form class="form-horizontal" name="demoform" id="demoform" method="post" action="demoController.do?add">
             			<input type="hidden" name="id" value="${demo.id }" />
	                <div class="modal-body">
						<div class="confirm_form" style=" width:100%;">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">姓名</label>
									<div class="col-sm-9">
										<input type="text" id="name" name="name" class="col-xs-5 col-sm-5" maxlength="20"  value="${demo.name }" datatype="*" nullmsg="请输入姓名！"  />
										<span class="name_validform_checktip"></span>
									</div>
								</div>
					
								<div class="space-4"></div>
					
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-2">时间</label>
									<div class="col-xs-5 col-sm-4">
										<div class="input-group">
											<input class="form-control date-picker" name="time" id="time" type="text" readonly="readonly"  value="<fmt:formatDate value="${demo.time }" pattern="yyyy-MM-dd"/>"  datatype="*" nullmsg="请输入时间！"  />
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
								    </div>
								    <span class="time_validform_checktip"></span>
								</div>	
								
								<div class="space-4"></div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-2">备注</label>
					
									<div class="col-sm-4">
											<select class="form-control" name="mark" id="mark"  datatype="*" nullmsg="请选择备注！" >
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
									<span class="mark_validform_checktip"></span>
								</div>
	     				</div>
	 				</div>        
	            
		            <div class="modal-footer">
		                <button type="submit"  class="btn btn-primary" id="btn_sub">确定</button>
		            	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		            </div>
           </form>
    </div>
 </div>
<script type="text/javascript">
			$('.date-picker').datepicker({
					autoclose:true
			 }).next().on(
			 	ace.click_event, 
				 function(){
				$(this).prev().focus();
			 });
				 
			$(function(){
				  $("#demoform").Validform({
		    	     tiptype:function(msg,o,cssctl){
						if(!o.obj.is("form")){
							var curfield = o.obj.attr("name");
							var objtip = $("." + curfield + "_validform_checktip");
							cssctl(objtip,o.type);
							objtip.html(msg);
						}
					 },
			    	 btnSubmit:"#btn_sub",
			    	 ajaxPost:true,
			    	 callback:function(data){
			    		showmsg(data);
			    	 }
			      });
			      
			      $("#mark").val("${demo.mark }");
			})
</script>
  </body>
</html>

  
