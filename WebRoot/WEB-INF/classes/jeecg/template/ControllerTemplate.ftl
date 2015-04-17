package ${bussPackage}.controller.${entityPackage};

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
import system.comm.base.Json;
import system.comm.base.PageBean;
import system.comm.utils.PrimaryKey;
import ${bussPackage}.entity.${entityPackage}.${className};
import ${bussPackage}.service.${entityPackage}.${className}Service;
import utils.interceptor.Auth;
import utils.pageplugin.Page;

@Controller
@RequestMapping("/${lowerName}Controller") 
public class ${className}Controller {

	
	@Autowired(required=false) 
	private ${className}Service<${className}> ${lowerName}Service; 
	
	/**
	 * 页面跳转
	 * @param request
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "toListView")
	public ModelAndView toListView(HttpServletRequest request){
		return new ModelAndView("jsp/${bussPackage}/${entityPackage}/${lowerName}");
	}
	
	/**
	 * 加载数据
	 * @param request
	 * @param page
	 * @param entity
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page,${className} entity){
		//设置查询条件
		Map map = new HashMap();
		map.put("page", page);
		map.put("entity", entity);
		
		List<${className}> dataList = ${lowerName}Service.queryBylistPage(map);//查询
	
		PageBean pageList = new PageBean(dataList,page);//封装结果集
		
		return pageList;
	}
	
	/**
	 * 跳转新增编辑页面
	 * @param request
	 * @param id
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "editToView")
	public ModelAndView editToView(HttpServletRequest request,String id){
		String title = "新增";
		if(StringUtils.isNotEmpty(id)){
			${className} entity = (${className}) ${lowerName}Service.queryById(id);
			title = "编辑";
			request.setAttribute("entity", entity);
		}
		request.setAttribute("title", title);
		return new ModelAndView("jsp/${bussPackage}/${entityPackage}/add");
	}
	
	/**
	 * 新增和更新
	 * @param request
	 * @param entity
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "add")
	@ResponseBody
	public Object add(HttpServletRequest request,${className} entity){
		Json json = new Json();
		String id = entity.getId();
		if (StringUtils.isNotEmpty(id)) {//新增
			entity.setId(PrimaryKey.createKey("u","yyyyMMddHHmmss",4));//主键
			try {
				${lowerName}Service.add(entity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("新增失败！");
				return json;
			}
		}else {//更新
			try {
				${lowerName}Service.update(entity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("更新失败！");
				return json;
			}
		}
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param entity
	 * @return
	 */
	@Auth(verifyLogin=true)
	@RequestMapping(params = "del")
	@ResponseBody
	public Object del(HttpServletRequest request,${className} entity){
		return (Integer)  ${lowerName}Service.delete(entity.getId());
	}
}

