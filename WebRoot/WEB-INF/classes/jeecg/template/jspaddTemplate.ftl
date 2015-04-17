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
                  <h4 class="modal-title">${'$'}{title}</h4>
              </div>
              
             <form class="form-horizontal" name="${lowerName}form" id="${lowerName}form" method="post" action="${lowerName}Controller.do?add">
             			<input type="hidden" name="id" value="${'$'}{entity.id}" />
	                <div class="modal-body">
						<div class="confirm_form" style=" width:100%;">
				
				    #foreach($po in $!{columnDatas})
				    <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">${po.filedComment}</label>
						<div class="col-sm-9">
							<input type="text" id="${po.columnName}" name="${po.columnName}" class="col-xs-5 col-sm-5" maxlength="20"  value="${'$'}{entity.${po.columnName}}" datatype="*" nullmsg="请输入${po.filedComment}！"  />
							<span class="${po.columnName}_validform_checktip"></span>
						</div>
					</div>
					#end
						
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
				  $("#${lowerName}form").Validform({
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
			      
			})
</script>
  </body>
</html>

  
