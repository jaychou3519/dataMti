package system.controller.role;

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
import system.comm.base.TreeEntity;
import system.comm.utils.JSONHelper;
import system.comm.utils.PrimaryKey;
import system.comm.utils.StringUtil;
import system.entity.resource.ResourceEntity;
import system.entity.role.RoleEntity;
import system.entity.user.UserEntity;
import system.service.resource.ResourceService;
import system.service.role.RoleService;
import utils.interceptor.SessionUtils;
import utils.pageplugin.Page;

/**
 * 角色管理
 * @author zhouq
 * @create 2014年8月13日 下午1:41:21
 */
@Controller
@RequestMapping("roleController")
public class RoleController {
	
	@Autowired(required=false) 
	private RoleService<RoleEntity> roleService; 
	
	@Autowired(required=false) 
	private ResourceService<ResourceEntity> resourceService; 
	
	@RequestMapping(params = "list")
	public ModelAndView totemplate(HttpServletRequest request){
		return new ModelAndView("jsp/system/role/list");
	}	
	
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		List<RoleEntity> dataList = roleService.queryBylistPage(map);
		PageBean<RoleEntity> pageList = new PageBean<RoleEntity>(dataList,page);//封装结果集
		return pageList;
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
		
		//查询登陆用户所有的角色列表
		List<TreeEntity> roleTree =  new ArrayList<TreeEntity>();
		UserEntity user =SessionUtils.getUser(request);
		if (user != null) {
			if (user.getType() == 0) {//超级管理员拥有所有的权限
				roleTree = roleService.queryAllRoleList(null);
			}else {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("user_id", user.getId());// 查自己有权限的角色
				roleTree = roleService.queryUserRoleList(map1);
			}
		}
		if (StringUtil.isValid(id)) {//编辑页面
			//查询所选择的用户对应的角色列表
			RoleEntity entity = roleService.queryById(id);
			request.setAttribute("role", entity);
			//查询对应的父节点
			String pid = entity.getPid();
			if (!"0".equals(pid)) {//0：根节点，没有父菜单
				RoleEntity pRole = roleService.queryById(pid);
				List<TreeEntity> rTree =  new ArrayList<TreeEntity>();
				for (TreeEntity tree : roleTree) {
					if (tree.getId().equals(pRole.getId())) {
						tree.setChecked(true);
					}
					rTree.add(tree);
				}
				request.setAttribute("roleTree", JSONHelper.collection2json(rTree));
			}else {
				request.setAttribute("roleTree", JSONHelper.collection2json(roleTree));
			}
		}else {
			request.setAttribute("roleTree", JSONHelper.collection2json(roleTree));
		}
		return new ModelAndView("jsp/system/role/add");
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
	public Object save(HttpServletRequest request, RoleEntity entity){
		Json json = new Json();
		String id = entity.getId();
		if (!StringUtil.isValid(id)) {//新增
			entity.setId(PrimaryKey.createKey("r","yyyyMMddHHmmss",4));//主键
			try {
				//String user_id =SessionUtils.getUserId(request);
				roleService.add(entity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("新增失败！");
				return json;
			}
		}else {//更新
			try {
				roleService.update(entity);
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
	 * 跳转到角色授权页面
	 * @return
	 */
	@RequestMapping(params = "grantPage")
	public ModelAndView grantPage(String id, HttpServletRequest request) {
		
		if (id != null && !id.equalsIgnoreCase("")) {
			UserEntity user =SessionUtils.getUser(request);
			request.setAttribute("id", id);
			//查询该角色所拥有的菜单列表
			Map<String, Object> map = new HashMap<String, Object>();
//			if (user != null) {
//				map.put("user_id", user.getId());// 查自己有权限的菜单
//			}
			List<TreeEntity> user_resource = new ArrayList<TreeEntity>();
			if ("admin".equals(id)) {//超级管理员拥有所有的权限
				user_resource = resourceService.queryAllResourceList(null);
			}else {
				map.put("role_id", id);
				user_resource = resourceService.queryUserResourceList(map);
			}

			//查询该用户所有的菜单列表
			List<TreeEntity> resourceTree = new ArrayList<TreeEntity>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			if (user != null) {
				if (user.getType() == 0) {//超级管理员拥有所有的权限
					resourceTree = resourceService.queryAllResourceList(null);
				}else {
					map1.put("user_id", user.getId());// 查自己有权限的资源
					resourceTree = resourceService.queryUserResourceList(map1);
				}
			}
			if (resourceTree.size() > 0) {
				//用户已有的角色，则在页面默认显示
				List<TreeEntity> rTrees = new ArrayList<TreeEntity>();
				for (TreeEntity tree : resourceTree) {
					for (TreeEntity uresource : user_resource) {
						if (tree.getId().equals(uresource.getId())) {
							tree.setChecked(true);
						}
					}
					rTrees.add(tree);
				}
				request.setAttribute("resourceTree", JSONHelper.collection2json(rTrees));
			}else {
				request.setAttribute("resourceTree", JSONHelper.collection2json(resourceTree));
			}
		}
		return new ModelAndView("jsp/system/role/grant");
	}

	/**
	 * 用户授权
	 * @param id
	 * @return
	 */
	@RequestMapping(params = "grant")
	@ResponseBody
	public Object grant(RoleEntity role) {
		Json j = new Json();
		boolean flag = roleService.grant(role);
		if (flag) {
			j.setSuccess(true);
			j.setMsg("授权成功！");
		}else {
			j.setSuccess(false);
			j.setMsg("授权失败！");
		}
		
		return j;
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
	public Object detele(String id){
		Json json = new Json();
		if (StringUtil.isValid(id)) {
			roleService.delete(id);
		}
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}
}
