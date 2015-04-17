<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style>
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:auto;overflow-y:scroll;overflow-x:auto;}
</style>
<div  class="modal-dialog" style="width:980px;">
      <div class="modal-content">

              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title">数据字典新增</h4>
              </div>
              
              <div class="modal-body">
				   <form class="form-horizontal" role="form" id="form">
				   <input type="hidden" id="uid" name="uid" value="${dictype.uid }" />
				   
				   <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">字典编码</label>
						<div class="col-sm-9">
							<input type="text" id="id" name="id" value="${dictype.id }"  class="span2" maxlength="20" placeholder="请输入字典编码" regxType="tel" rel="popover" required  />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">名称</label>
						<div class="col-sm-9">
							<input type="text" id="text" name="text" value="${dictype.text }"  class="span2" maxlength="20" placeholder="请输入名称" regxType="tel" rel="popover" required  />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">上级字典</label>
						<div class="col-sm-9">
							<input id="pid" name="pid" type="hidden" readonly value="" class="span2"  />
								<input id="roleNames" name="roleNames" type="text"  onclick="showMenu();" readonly value="" class="span2"  />
								<ul id="treeDemo" class="ztree" style="margin-top:0; width:180px; height:auto;display:none"></ul>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">排序</label>
						<div class="col-sm-9">
							<input type="text" id="seq" name="seq" value="${dictype.seq }" class="span2"  placeholder="请输入排序号" regxType="tel" rel="popover" required  />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1">备注</label>
						<div class="col-sm-9">
							<input type="text" id="remark" name="remark" value="${dictype.remark }"  class="span2"  placeholder="请输入备注" regxType="tel" rel="popover" required  />
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
var setting = {
		check: {
			enable: true,
			chkboxType: {"Y":"", "N":""}
		},
		view: {
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeClick: beforeClick,
			onCheck: onCheck
		}
	};

	var dictypeTree = ${dictypeTree};

	function beforeClick(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}
	
	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		nodes = zTree.getCheckedNodes(true);
		v = "";
		r = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			r += nodes[i].id + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if (r.length > 0 ) r = r.substring(0, r.length-1);
		$("#pid").attr("value",r);
		var cityObj = $("#roleNames");
		cityObj.attr("value", v);
	}

	function showMenu() {
		var cityObj = $("#roleNames");
		var cityOffset = $("#roleNames").offset();
		$("#treeDemo").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	
	function hideMenu() {
		$("#treeDemo").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "roleNames" || event.target.id == "treeDemo" || $(event.target).parents("#treeDemo").length>0)) {
			hideMenu();
		}
	}

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, dictypeTree);
		//showMenu();
		onCheck("","","");
	});
$(function(){
	
});
function save(){
	var pid = $("#pid").val();
	if(pid == "" || pid.length == 0){//根节点默认为"0"
		$("#pid").val("0");
	}
	var url = "dictypeController.do?save";
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
							 $("#cgrid-table").trigger("reloadGrid");  //刷新表格
						}
					}			
				}
			});
		}
	});
}
</script>

  


  
