package system.controller.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.comm.base.PageBean;
import system.comm.utils.PrimaryKey;
import system.entity.demo.DemoEntity;
import system.service.demo.DemoService;
import utils.interceptor.Auth;
import utils.pageplugin.Page;

@Controller
@RequestMapping("demoController")
@SuppressWarnings("rawtypes")
public class DemoController {
	
	
	@Autowired(required=false) 
	private DemoService<DemoEntity> demoService; 
	
	/**
	 * 页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "totemplate")
	@Auth(verifyLogin=true)
	public ModelAndView totemplate(HttpServletRequest request){
		return new ModelAndView("jsp/demo/template");
	}
	
	/**
	 * 加载数据
	 * @param request
	 * @param page
	 * @param demo
	 * @return
	 */
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page,DemoEntity demo){
		//设置查询条件
		Map map = new HashMap();
		map.put("page", page);
		map.put("demo", demo);
		
		List<DemoEntity> demoList = demoService.queryBylistPage(map);//查询
	
		PageBean pageList = new PageBean(demoList,page);//封装结果集
		
		return pageList;
	}
	
	/**
	 * 跳转新增编辑页面
	 * @param request
	 * @param id
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "addToView")
	public ModelAndView addToView(HttpServletRequest request,String id){
		String title = "新增";
		if(StringUtils.isNotEmpty(id)){
			DemoEntity demo = (DemoEntity) demoService.queryById(id);
			title = "编辑";
			request.setAttribute("demo", demo);
		}
		request.setAttribute("title", title);
		return new ModelAndView("jsp/demo/add");
	}
	
	/**
	 * 新增和更新
	 * @param request
	 * @param demo
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "add")
	@ResponseBody
	public Object add(HttpServletRequest request,DemoEntity demo){
		int flag = 0;
		if(StringUtils.isNotEmpty(demo.getId())){
			flag = demoService.update(demo);
		}else{
			demo.setId(PrimaryKey.createKey("d","yyyyMMddHHmmss",4));
			demoService.add(demo);
		}
		return flag;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param demo
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "del")
	@ResponseBody
	public Object del(HttpServletRequest request,DemoEntity demo){
		return (Integer) demoService.delete(demo.getId());
	}
}
