package system.controller.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.comm.base.PageBean;
import system.entity.log.LogEntity;
import system.service.log.LogService;
import utils.pageplugin.Page;
/**
 * 系统操作日志
 * @author zhouq
 * @create 2014年8月13日 下午1:43:18
 */
@Controller
@RequestMapping("logController")
public class LogController {
	
	@Autowired(required=false) 
	private LogService<LogEntity> logService; 
	

	
	@RequestMapping(params = "list")
	public ModelAndView totemplate(HttpServletRequest request){
		return new ModelAndView("jsp/system/log/list");
	}	
	
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		List<LogEntity> dataList = logService.queryBylistPage(map);
		PageBean<LogEntity> pageList = new PageBean<LogEntity>(dataList,page);//封装结果集
		return pageList;
	}
	
	@RequestMapping(params = "addToView")
	public ModelAndView addToView(HttpServletRequest request){
		return new ModelAndView("jsp/demo/add");
	}
}
