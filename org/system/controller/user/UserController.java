package system.controller.user;

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
import system.comm.utils.DateUtils;
import system.comm.utils.JSONHelper;
import system.comm.utils.PrimaryKey;
import system.comm.utils.StringUtil;
import system.entity.dictype.DicTypeEntity;
import system.entity.role.RoleEntity;
import system.entity.user.UserEntity;
import system.service.dictype.DictypeService;
import system.service.role.RoleService;
import system.service.user.UserService;
import utils.interceptor.SessionUtils;
import utils.pageplugin.Page;

/**
 * 用户管理
 * @author zhouq
 * @create 2014年8月13日 下午1:41:21
 */
@Controller
@RequestMapping("userController")
public class UserController {
	
	@Autowired(required=false) 
	private UserService<UserEntity> userService; 

	@Autowired(required=false) 
	private RoleService<RoleEntity> roleService; 
	
	@Autowired(required=false) 
	private DictypeService<DicTypeEntity> dictypeService; 
	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request){
		return new ModelAndView("jsp/system/user/list");
	}	
	
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		List<UserEntity> dataList = userService.queryBylistPage(map);
		PageBean<UserEntity> pageList = new PageBean<UserEntity>(dataList,page);//封装结果集
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
		if (StringUtil.isValid(id)) {//编辑页面
			//查询所选择的用户对应的角色列表
			UserEntity entity = userService.queryById(id);
			request.setAttribute("user", entity);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", "sex");
		List<DicTypeEntity> sexDicList = dictypeService.queryDicTypeList(map);
		request.setAttribute("sexDicList", sexDicList);
		return new ModelAndView("jsp/system/user/add");
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
	public Object save(HttpServletRequest request, UserEntity userEntity){
		Json json = new Json();
		String id = userEntity.getId();
		if (!StringUtil.isValid(id)) {//新增
			userEntity.setId(PrimaryKey.createKey("u","yyyyMMddHHmmss",4));//主键
			userEntity.setCreatetime(DateUtils.getCurrentTime());//创建时间
			try {
				userService.add(userEntity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("新增失败！");
				return json;
			}
		}else {//更新
			userEntity.setUpdatetime(DateUtils.getCurrentTime());//更新时间
			try {
				userService.update(userEntity);
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
	 * 跳转到用户授权页面
	 * @return
	 */
	@RequestMapping(params = "grantPage")
	public ModelAndView grantPage(String id, HttpServletRequest request) {
		
		if (id != null && !id.equalsIgnoreCase("")) {
			request.setAttribute("id", id);
			//查询所选择的用户对应的角色列表
			List<TreeEntity> user_role = new ArrayList<TreeEntity>();
			UserEntity uEntity = userService.queryById(id);
			if (uEntity != null && 0 == uEntity.getType()) {//超级管理员则拥有所有的权限
				user_role = roleService.queryAllRoleList(null);
			}else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("user_id", id);
				user_role = roleService.queryUserRoleList(map);
			}
			
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
			if (roleTree.size() > 0) {
				//用户已有的角色，则在页面默认显示
				List<TreeEntity> rTrees =  new ArrayList<TreeEntity>();
				for (TreeEntity tree : roleTree) {
					for (TreeEntity urole : user_role) {
						if (tree.getId().equals(urole.getId())) {
							tree.setChecked(true);
						}
					}
					rTrees.add(tree);
				}
				request.setAttribute("roleTree", JSONHelper.collection2json(rTrees));
			}else {
				request.setAttribute("roleTree", JSONHelper.collection2json(roleTree));
			}
		}
		return new ModelAndView("jsp/system/user/grant");
	}

	/**
	 * 用户授权
	 * @param id
	 * @return
	 */
	@RequestMapping(params = "grant")
	@ResponseBody
	public Object grant(UserEntity user) {
		Json j = new Json();
		boolean flag = userService.grant(user);
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
			userService.delete(id);
		}
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}
}
