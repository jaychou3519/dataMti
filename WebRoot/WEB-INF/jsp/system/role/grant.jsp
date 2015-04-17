<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style>
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
</style>
<div class="modal-dialog" style="width:980px;">
      <div class="modal-content">

              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title">角色授权</h4>
              </div>
              
              <div class="modal-body">
				   <form class="form-horizontal" resource="form" id="form">
					
					<input name="id" type="hidden" class="span2" value="${id}" readonly="readonly">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-2">菜单</label>	
						<div class="col-sm-3">
								<input id="resourceIds" name="resourceIds" type="hidden" readonly value="" class="span2"  />
								<input id="resourceNames" name="resourceNames" type="text" readonly value="" class="span2"  />
								<ul id="treeDemo" class="ztree" style="margin-top:0; width:180px;height:auto;"></ul>
								<!--  <button type="button" id="menuBtn" class="btn btn-primary btn-sm" onclick="showMenu(); return false;" >选择</button>
								-->
						</div>
					</div>
				</form>
</div>        
            
            <div class="modal-footer">
             	 <button type="button" class="btn btn-primary btn-sm" onClick="return grantresource();" anchor="top">确认</button>
             	 <button type="button"  class="btn btn-warning btn-sm" data-dismiss="modal" anchor="top">取消</button>
            </div>

    </div>
    <!-- /.modal-content --> 
    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
		
	</div>
 </div>

<script type="text/javascript" >
var setting = {
		check: {
			enable: true,
			chkboxType: {"Y":"p", "N":""}
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

	var resourceTree = ${resourceTree};

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
		$("#resourceIds").attr("value",r);
		var cityObj = $("#resourceNames");
		cityObj.attr("value", v);
	}

	function showMenu() {
		var cityObj = $("#resourceNames");
		var cityOffset = $("#resourceNames").offset();
		//$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	
	function hideMenu() {
		//$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "resourceNames" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, resourceTree);
		showMenu();
		onCheck("","","");
	});
$(function(){
	
});
function grantresource(){
	var url = "roleController.do?grant";
	$.post(url,$("#form").serialize(),function(result){
		//if(result.success){
			bootbox.dialog({
				message: "<span class='bigger-110'>"+result.msg+"</span>",
				buttons: 			
				{
					"success" :
					 {
						"label" : "<i class='icon-ok'></i> 确认!",
						"className" : "btn-sm btn-success",
						"callback": function() {
							 $("#grantPage").modal("hide");
						}
					}			  
				}
			});
		//}
	});
}
</script>

  
