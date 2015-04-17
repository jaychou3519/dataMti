package system.controller.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.comm.base.Json;
import system.comm.base.PageBean;
import system.comm.base.TreeData;
import system.comm.base.TreeEntity;
import system.comm.utils.JSONHelper;
import system.comm.utils.PrimaryKey;
import system.comm.utils.StringUtil;
import system.entity.resource.ResourceEntity;
import system.entity.user.UserEntity;
import system.service.resource.ResourceService;
import utils.interceptor.SessionUtils;
import utils.pageplugin.Page;

/**
 * 菜单管理
 * @author zhouq
 * @create 2014年8月13日 下午1:41:21
 */
@Controller
@RequestMapping("resourceController")
public class ResourceController {
	
	@Autowired(required=false) 
	private ResourceService<ResourceEntity> resourceService; 
	

	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request){
		return new ModelAndView("jsp/system/resource/list");
	}	
	
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		List<ResourceEntity> dataList = resourceService.queryByPList(map);
		PageBean<ResourceEntity> pageList = new PageBean<ResourceEntity>(dataList,page);//封装结果集
		return pageList;
	}
	
	@RequestMapping(params = "childList")
	public ModelAndView childList(HttpServletRequest request){
		String pid = request.getParameter("pid");
		request.setAttribute("pid",pid);
		return new ModelAndView("jsp/system/resource/childList");
	}
	
	@RequestMapping(params = "loadChildDataGrid")
	@ResponseBody
	public Object loadChildDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		String pid = request.getParameter("pid");
		map.put("pid", pid);
		map.put("page", page);
		List<ResourceEntity> dataList = resourceService.queryBylistPage(map);
		PageBean<ResourceEntity> pageList = new PageBean<ResourceEntity>(dataList,page);//封装结果集
		return pageList;
	}
	
	@RequestMapping(params = "loadTreeGrid")
	@ResponseBody
	public Object loadTreeGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		List<ResourceEntity> dataList = resourceService.queryBylistPage(map);
		List<TreeData> treeDatas = new ArrayList<TreeData>();
		for (ResourceEntity resource : dataList) {
			TreeData tree = new TreeData();
			tree.setId(resource.getId());
			tree.setName(resource.getName());
			tree.setUrl(resource.getUrl());
			tree.setParent(resource.getPid());
			if (!"0".equals(resource.getPid())) {
				tree.setIsLeaf(true);
				tree.setLevel(1);
			}
			treeDatas.add(tree);
		}
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("griddata", treeDatas);
		//PageBean<ResourceEntity> pageList = new PageBean<ResourceEntity>(treeDatas,page);//封装结果集
		return map2;
	}
	/**
	 * 新增页面
	 * @author zhouq
	 * @create 2014年8月13日 下午1:41:38
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "addPage")
	public ModelAndView addPage(String id, HttpServletRequest request){
		//查询该用户所有的菜单列表
		List<TreeEntity> resourceTree = new ArrayList<TreeEntity>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		UserEntity user =SessionUtils.getUser(request);
		if (user != null) {
			if (user.getType() == 0) {//超级管理员拥有所有的权限
				resourceTree = resourceService.queryAllResourceList(null);
			}else {
				map1.put("user_id", user.getId());// 查自己有权限的资源
				resourceTree = resourceService.queryUserResourceList(map1);
			}
		}
		
		if (StringUtil.isValid(id)) {//编辑页面
			//查询所选择的用户对应的角色列表
			ResourceEntity entity = resourceService.queryById(id);
			request.setAttribute("resource", entity);
			//查询对应的父菜单
			String pid = entity.getPid();
			if (!"0".equals(pid)) {//0：根节点，没有父菜单
				ResourceEntity pResource = resourceService.queryById(pid);
				List<TreeEntity> rTree =  new ArrayList<TreeEntity>();
				for (TreeEntity tree : resourceTree) {
					if (tree.getId().equals(pResource.getId())) {
						tree.setChecked(true);
					}
					rTree.add(tree);
				}
				request.setAttribute("resourceTree", JSONHelper.collection2json(rTree));
			}else {
				request.setAttribute("resourceTree", JSONHelper.collection2json(resourceTree));
			}
		}else {
			request.setAttribute("resourceTree", JSONHelper.collection2json(resourceTree));
		}
		return new ModelAndView("jsp/system/resource/add");
	}
	
	/**
	 * 保存方法
	 * @author zhouq
	 * @create 2014年8月13日 下午1:41:47
	 * @param request
	 * @param userEntity
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public Object save(HttpServletRequest request, ResourceEntity entity){
		Json json = new Json();
		String id = entity.getId();
		if (!StringUtil.isValid(id)) {//新增
			entity.setId(PrimaryKey.createKey("m","yyyyMMddHHmmss",4));//主键
			try {
				resourceService.add(entity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("新增失败！");
				return json;
			}
		}else {//更新
			try {
				resourceService.update(entity);
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
	 * 删除功能
	 * @author zhouq
	 * @create 2014年8月13日 下午1:41:38
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "detele")
	@ResponseBody
	public Object detele(String id,String pid){
		Json json = new Json();
		if (StringUtil.isValid(id)) {
			resourceService.delete(id);
		}
		if (StringUtil.isValid(pid)) {
			resourceService.delete(pid);
			resourceService.deleteByPid(pid);
		}
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}
}
