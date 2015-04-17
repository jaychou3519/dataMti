$(function() {
	$("#vehicleresourcetable").jqGrid({
		caption: "车源信息",	//定义表格名称
		url:'vehicleresourceController.do?loadDataGrid',
		datatype: 'json',   //表格可以被接受的数据类型：xml，xmlstring，json，local，function 
		height:500,		//表格高度，可以是数字，像素值或者百分比
		colNames:
		 ['车源编号', '启运地','目的地','发布者名称','提供者名称','发布时间','事件有效截止日期', '网络访问地址'	],  //放置列名称的数组，必须与colModel大小相同
	    colModel:[     // 描述列信息的数组 
					{name:'vehicleResourceNumber',index: 'vehicleResourceNumber',width:$(this).width() * 0.067, align:'center'},
					{name:'placeOfDeparture',index: 'placeOfDeparture',width:$(this).width() * 0.067, align:'center'},
					{name:'destination',index: 'destination',width:$(this).width() * 0.067, align:'center'},
					{name:'issuerName',index: 'issuerName',width:$(this).width() * 0.067, align:'center'},
					{name:'providerName',index: 'providerName',width:$(this).width() * 0.067, align:'center'},
					{name:'issueDateTime',index: 'issueDateTime',width:$(this).width() * 0.067, align:'center'},
					{name:'eventEffectiveEndDateTime',index: 'eventEffectiveEndDateTime',width:$(this).width() * 0.067, align:'center'},
					{name:'netAccessAddress',index: 'netAccessAddress',width:$(this).width() * 0.067, align:'center'}
				], 
	    jsonReader: {     //描述json 数据格式的数组，
	    	 root: "griddata",   
	     	 repeatitems : false     
	    },    
		viewrecords:true, 		//是否要显示总记录数
		emptyrecords:"没有查询到记录", //当返回的数据行数为0时显示的信息。只有当属性 viewrecords 设置为ture时起作用
		rowNum:10,				//设置表格中显示的记录数，参数会被自动传到后台。如果此参数设为10，但是从服务器端返回15条记录，那么在表格中只会显示10条记录。如果设为-1则禁用此检查
		rowList:[10,20,30],		//一个数组用来调整表格显示的记录数，此参数值会替代rowNum参数值传给服务器端。如果为空则不显示，设置格式：[10,20,30]。
		pager : "#vehicleresourcepager",	//指定分页栏对象，必须为一个有效的html元素。可以是'pager', '#pager', jQuery('#pager').推荐用'#pager'
		altRows: true,			//设置表格条纹
		multiselect:true,		//定义是否可以多选
		//multikey: "ctrlKey", 	//只有在multiselect设置为ture时起作用，定义使用那个key来做多选。shiftKey，altKey，ctrlKey 
	    multiboxonly: true,	   //只有当multiselect = true.起作用，当multiboxonly 为ture时只有选择checkbox才会起作用，
		autowidth: true,		//自适应宽度
		loadComplete : function() { //当从服务器返回响应时执行，xhr：XMLHttpRequest 对象
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);  
			}, 0);
		}
	});
	
	//设置操作按钮和样式
	$("#vehicleresourcetable").jqGrid('navGrid',"#vehicleresourcepager",
		{ 	
			edit: true,
			editicon : 'icon-pencil blue',
			editfunc: editFun,
			add: true,
			
			addicon : 'icon-plus-sign purple',
			addfunc : addFun, 
			del: true,
			delicon : 'icon-trash red',
			delfunc:delFun,
			search: false,
			searchicon : 'icon-search orange',
			refresh: true,
			refreshicon : 'icon-refresh green',
			view: true,
			viewicon : 'icon-zoom-in grey',
			cloneToTop :true
		} 
	);
	
	//解决不重新加载页面的问题
	$("#addDiv").on("hidden.bs.modal", function() {
	    $(this).removeData("bs.modal");
	});
	
});

//条件查询
function seachData(){

				var vehicleresourcenumber = $("#seachvehicleresourcenumber").val();
						var placeofdeparture = $("#seachplaceofdeparture").val();
						var destination = $("#seachdestination").val();
																																																												
	$("#vehicleresourcetable").jqGrid('setGridParam',{ 
        datatype:'json', 
        postData:{
        						"vehicleresourcenumber":vehicleresourcenumber,
												"placeofdeparture":placeofdeparture,
												"destination":destination,
																																																																																																																																												        },  
        page:1 
	}).trigger("reloadGrid"); 
}

//新增
function addFun(){
	$("#addDiv").modal({
		    remote: "vehicleresourceController.do?editToView"
	});
}

//编辑
function editFun(id){
	$("#addDiv").modal({
	    remote: "vehicleresourceController.do?editToView&id=" + id
	});
}


//删除
function delFun(id){
	var url = "vehicleresourceController.do?del";
	$.jqconfirm("确定要这么做吗？", "确认提示",function(){
		$.getJSON(url,{id:id}, function(json){
			showmsg(json);
		});
	});
}

//消息提示
function showmsg(data){
	if(data==1){
	   $.jqalert("操作成功！");
	   $('#addDiv').modal('hide');  //关闭弹出窗
	   $("#vehicleresourcetable").trigger("reloadGrid");  //刷新表格
	}else{
	   $.jqalert("操作失败！");
	   $('#addDiv').modal('hide');	//关闭弹出窗
	   $("#vehicleresourcetable").trigger("reloadGrid");  //刷新表格
	}
}
