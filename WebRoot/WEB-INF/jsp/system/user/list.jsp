<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/context/comm.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>用户管理</title>
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
					<li class="active">用户管理</li>
				</ul>
			</div><!-- 内容导航条结束 -->
					
			<div class="page-content">
			
				<div class="row">
					<div class="col-xs-3">
						<button onClick="return addFun();" class="btn btn-danger btn-xs">新增</button>
						&nbsp;&nbsp;
						<button onClick="return saa();" class="btn btn-warning btn-xs">授权</button>
					</div><!-- /.col -->
				</div><!-- /.row -->
			
				<div class="row">
					<div class="col-xs-12">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
			
         	<div id="addPage" class="modal"></div>
         	<div id="grantPage" class="modal"></div>  
  </body>
 
<script type="text/javascript" >
$(function() {
	$("#grid-table").jqGrid({
		caption: "用户管理",	//定义表格名称
		url:'userController.do?loadDataGrid',
		datatype: 'json',   //表格可以被接受的数据类型：xml，xmlstring，json，local，function 
		height:500,		//表格高度，可以是数字，像素值或者百分比
		colNames: ['操作','ID', '用户名称', '密码', '创建时间'],  //放置列名称的数组，必须与colModel大小相同
	    colModel:[     // 描述列信息的数组 
	        { name: 'operate', width: 60, align: "center",formatter:operate},
	 		{ name: 'id', index: 'id', width: 40, align: "left", editable: true},
			{ name: 'name', index: 'name', width: 100, align: "center" },
			{ name: 'pwd', index: 'pwd', width: 100, align: "center" },
			{ name: 'createtime', index: 'createtime', width: 150, align: "center",sorttype:"date" }
	    ], 
	    jsonReader: {     //描述json 数据格式的数组，
	    	 root: "griddata",
	     	 repeatitems : false     
	    },     
		viewrecords:true, 		//是否要显示总记录数
		rowNum:10,				//设置表格中显示的记录数，参数会被自动传到后台。如果此参数设为10，但是从服务器端返回15条记录，那么在表格中只会显示10条记录。如果设为-1则禁用此检查
		rowList:[10,20,30],		//一个数组用来调整表格显示的记录数，此参数值会替代rowNum参数值传给服务器端。如果为空则不显示，设置格式：[10,20,30]。
		pager : "#grid-pager",	//指定分页栏对象，必须为一个有效的html元素。可以是'pager', '#pager', jQuery('#pager').推荐用'#pager'
		altRows: true,			//设置表格条纹
		multiselect:true,		//定义是否可以多选
		//multikey: "ctrlKey", 	//只有在multiselect设置为ture时起作用，定义使用那个key来做多选。shiftKey，altKey，ctrlKey 
	    multiboxonly: true,	//只有当multiselect = true.起作用，当multiboxonly 为ture时只有选择checkbox才会起作用，
		autowidth: true,		//自适应宽度
		loadComplete : function() { //当从服务器返回响应时执行，xhr：XMLHttpRequest 对象
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
		}
	});
	
	//设置操作按钮和样式
	$("#grid-table").jqGrid('navGrid',"#grid-pager",
		{ 	
			edit: true,
			editicon : 'icon-pencil blue',
			add: true,
			addicon : 'icon-plus-sign purple',
			addfunc : addFun, 
			del: true,
			delicon : 'icon-trash red',
			search: true,
			searchicon : 'icon-search orange',
			refresh: true,
			refreshicon : 'icon-refresh green',
			view: true,
			viewicon : 'icon-zoom-in grey',
		}
	);
	
	//解决不重新加载页面的问题
	$("#addPage").on("hidden.bs.modal", function() {
	    $(this).removeData("bs.modal");
	});
	$("#grantPage").on("hidden.bs.modal", function() {
	    $(this).removeData("bs.modal");
	});

});

function addFun(){
	 $("#addPage").modal({
		    remote: "userController.do?addPage"
	});
	 
} 
function detele(id){
	bootbox.confirm("是否删除此用户信息，请慎重！", function(result) {
		if(result) {
			var url = "userController.do?detele";
			$.post(url,{"id":id},function(result){
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
									 $("#grid-table").trigger("reloadGrid");  //刷新表格
								}
							}			
						}
					});
				}
			});
		}
	});
}
//操作
function operate(cellvalue, options, rowObject){  
	var html = " ";
	html ="<button onclick='return edit(\""+options.rowId+"\");' class='btn btn-xs btn-primary'>编辑</button>"
	html += "&nbsp;&nbsp";
	html +="<button onclick='return grant(\""+options.rowId+"\");' class='btn btn-xs btn-primary'>授权</button>"
	html += "&nbsp;&nbsp";
	html +="<button onclick='return detele(\""+options.rowId+"\");' class='btn btn-xs btn-danger'>删除</button>"
	return html;
}

function edit(id){
	 $("#addPage").modal({
		    remote: "userController.do?addPage&id="+id
	});
	 
} 
function grant(id){
	 $("#grantPage").modal({
		    remote: "userController.do?grantPage&id="+id
	});
}

function saa(){
	var id=$("#grid-table").jqGrid("getGridParam","selarrrow");
	grant(id);
}
</script>
</html>

  
