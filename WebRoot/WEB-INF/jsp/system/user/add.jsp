<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/comm.jsp"%>
<div class="modal-dialog" style="width:980px;">
      <div class="modal-content">

              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title">用户新增</h4>
              </div>
              
               <div class="modal-body">
				   <form class="form-horizontal" role="form" id="form">
				   <input type="hidden" id="id" name="id" value="${user.id}" />
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">姓名</label>
						<div class="col-sm-9">
							<input type="text" id="name" name="name" value="${user.name}" class="col-xs-5 col-sm-5" maxlength="20" placeholder="请输入姓名" regxType="tel" rel="popover" required  />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">密码</label>
						<div class="col-sm-9">
							<input type="text" id="pwd" name="pwd" value="${user.pwd}" class="col-xs-5 col-sm-5" maxlength="20" placeholder="请输入密码" regxType="tel" rel="popover" required  />
						</div>
					</div>
					

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-2">备注</label>	
						<div class="col-sm-3">
								<select class="form-control" id="form-field-select-1">
									<c:forEach items="${sexDicList}" var="sexDic">
										<option value="${sexDic.id}">${sexDic.text}</option>
										<br />
									</c:forEach>
								</select>
						</div>
					</div>
				</form>
			</div>        
            
            <div class="modal-footer">
             	 <button type="button" class="btn btn-primary btn-sm" onClick="return save();" anchor="top">保存</button>
             	 <button type="button"  class="btn btn-warning btn-sm" data-dismiss="modal" anchor="top">取消</button>
            </div>

    </div>
    <!-- /.modal-content --> 
 </div>

<script type="text/javascript" >
$(function(){
	
});
function save(){
	var url = "userController.do?save";
	$.post(url,$("#form").serialize(),function(result){
		if(result.success){
			bootbox.dialog({
				message: "<span class='bigger-110'>"+result.msg+"</span>",
				buttons: 			
				{
					"success" :
					 {
						"label" : "<i class='icon-ok'></i> 确认!",
						"className" : "btn-sm btn-success",
						"callback": function() {
							 $("#addPage").modal("hide");
							 $("#grid-table").trigger("reloadGrid");  //刷新表格
						}
					}			
				}
			});
		}
	});
}
</script>

  
