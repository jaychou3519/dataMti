package system.controller.user;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.comm.base.Json;
import system.entity.resource.ResourceEntity;
import system.entity.user.UserEntity;
import system.service.resource.ResourceService;
import system.service.user.UserService;
import utils.interceptor.Auth;
import utils.interceptor.SessionUtils;

@Controller
@RequestMapping("loginController")
public class LoginController {
	
	@Autowired(required=false) 
	private UserService<UserEntity> userService; 
	@Autowired(required=false) 
	private ResourceService<ResourceEntity> resourceService; 

	
	@RequestMapping(params = "login")
	@ResponseBody
	public Object login(HttpSession session, HttpServletRequest request){
		UserEntity entity = new UserEntity();
		entity.setName(request.getParameter("name"));
		entity.setPwd(request.getParameter("pwd"));
		
		Json j = new Json();
		UserEntity user = userService.login(entity);
		if (user != null) {
			SessionUtils.setUser(request,user);
			j.setSuccess(true);
			//j.setSuccess(true);
			//j.setMsg("登陆成功！");
			/*SessionInfo sessionInfo = new SessionInfo();
			BeanUtils.copyProperties(user, sessionInfo);*/
			//设置User到Session
			//sessionInfo.setIp(IpUtil.getIpAddr(request));
			//sessionInfo.setResourceList(userService.resourceList(u.getId()));
		//	PropertiesUtil p = new PropertiesUtil("sysConfig.properties");
			//session.setAttribute(p.readProperty("sessionInfoName"), sessionInfo);
			//初始化一些系统公共资源
			//initService.init();
			//cachedDao.set(u.getId(),sessionInfo);//将用户信息保存至缓存
			//j.setObj(sessionInfo);
		} else {
			j.setMsg("用户名或密码错误！");
		}
		return j;
	}
	
	@RequestMapping(params = "error")
	public ModelAndView error(HttpServletRequest request,String msg,String herf){
		request.setAttribute("msg", msg);
		request.setAttribute("herf", herf);
		return new ModelAndView("error");
	}	
	
	@RequestMapping(params = "main")
	@Auth(verifyLogin=true)
	public ModelAndView main(HttpServletRequest request){
		request.setAttribute("menuList", loadMenu(request));
		return new ModelAndView("jsp/main");
	}	
	
	/**
	 * 根据用户权限加载菜单
	 * @param request
	 * @return
	 */
	public List<ResourceEntity> loadMenu(HttpServletRequest request){
		UserEntity user =SessionUtils.getUser(request);
		
		//所有菜单
		List<ResourceEntity> allList = new ArrayList<ResourceEntity>();
		if (user != null) {
			if (user.getType() == 0) {//超级管理员拥有所有的权限
				allList = resourceService.queryAllResourceList();
			}else {
				// 查自己有权限的资源
				allList = resourceService.queryByAllList(user.getId());
			}
		}
		
		//第一级菜单
		List<ResourceEntity> firstList = new ArrayList<ResourceEntity>();
		
		//结果集
		List<ResourceEntity> menuList = new ArrayList<ResourceEntity>();
		
		for (ResourceEntity resourceEntity : allList) {
			if(resourceEntity.getPid().equals("0")){
				firstList.add(resourceEntity);
			}
		}
		
		for (ResourceEntity resourceEntity : firstList) {
			menuList.add(getChildren(allList,resourceEntity));
		}
		
		return menuList;
	}
	
	/**
	 * 递归
	 * @param allList
	 * @param resourceEntity
	 * @return
	 */
	public ResourceEntity getChildren(List<ResourceEntity> allList,ResourceEntity resourceEntity){
		
		
		List<ResourceEntity> childrenList = new ArrayList<ResourceEntity>();
		
		for (ResourceEntity resource : allList) {
			if(resource.getPid().equals(resourceEntity.getId())){
				childrenList.add(resource);
			}
		}
		
		if(null != childrenList && childrenList.size() > 0){
			List<ResourceEntity> list = new ArrayList<ResourceEntity>();
			for (ResourceEntity children : childrenList) {
				list.add(getChildren(allList,children));
			}
			resourceEntity.setChildren(list);
		}
		return resourceEntity;
	}

}
