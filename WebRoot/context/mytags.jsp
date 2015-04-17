<%@ page language="java"  pageEncoding="utf-8"%>
<link href="plug-in/ace1.2/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/ace.min.css" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="plug-in/ace1.2/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="plug-in/css/comm.css" type="text/css" />
<link rel="stylesheet" href="plug-in/validform/css/style.css" type="text/css" />
<link href="plug-in/validform/css/demo.css" type="text/css" rel="stylesheet" />
<script src="plug-in/ace1.2/assets/js/jquery-1.10.2.min.js"></script>
<script src="plug-in/ace1.2/assets/js/ace-extra.min.js"></script>
<script src="plug-in/ace1.2/assets/js/bootstrap.min.js"></script>
<script src="plug-in/ace1.2/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="plug-in/ace1.2/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<script src="plug-in/ace1.2/assets/js/ace-elements.min.js"></script>
<script src="plug-in/ace1.2/assets/js/ace.min.js"></script>
<script src="plug-in/ace1.2/assets/js/bootbox.min.js"></script>
<script src="plug-in/ace1.2/assets/js/jquery-ui-1.10.3.full.min.js"></script>
<script type="text/javascript" src="plug-in/validform/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="plug-in/js/comm/jquery_ui_dialog.js"></script>

<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
<script type="text/javascript" src="plug-in/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="plug-in/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="plug-in/ztree/jquery.ztree.exhide-3.5.js"></script>
<script>
$(function(){   
     $.datepicker.regional['zh-CN'] = {   
        clearText: '清除',   
        clearStatus: '清除已选日期',   
        closeText: '关闭',   
        closeStatus: '不改变当前选择',   
        prevText: '<上月',   
        prevStatus: '显示上月',   
        prevBigText: '<<',   
        prevBigStatus: '显示上一年',   
        nextText: '下月>',   
        nextStatus: '显示下月',   
        nextBigText: '>>',   
        nextBigStatus: '显示下一年',   
        currentText: '今天',   
        currentStatus: '显示本月',   
        monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],   
        monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二'],   
        monthStatus: '选择月份',   
        yearStatus: '选择年份',   
        weekHeader: '周',   
        weekStatus: '年内周次',   
        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],   
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],   
        dayNamesMin: ['日','一','二','三','四','五','六'],   
        dayStatus: '设置 DD 为一周起始',   
        dateStatus: '选择 m月 d日, DD',   
        dateFormat: 'yy-mm-dd',   
        firstDay: 1,   
        initStatus: '请选择日期',   
        isRTL: false};   
        $.datepicker.setDefaults($.datepicker.regional['zh-CN']);   
});  

//加载翻页样式
function updatePagerIcons(table) {
	var replacement = 
	{
		'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
		'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
		'ui-icon-seek-next' : 'icon-angle-right bigger-140',
		'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
		var icon = $(this);
		var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
		if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
	});
}

</script>