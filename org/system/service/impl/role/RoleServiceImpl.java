package system.service.impl.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.comm.base.TreeEntity;
import system.comm.utils.StringUtil;
import system.dao.role.RoleMapper;
import system.dao.user.UserMapper;
import system.entity.role.RoleAndResource;
import system.entity.role.RoleEntity;
import system.service.role.RoleService;

@Service("roleService")
public class RoleServiceImpl<T> implements RoleService<T>{
	
	@Autowired
	private RoleMapper<T> roleDao;
	
	@Autowired
	private UserMapper userDao;

	public List<TreeEntity> queryUserRoleList(Map<String, Object> map) {
		List<RoleEntity> roleLists = new ArrayList<RoleEntity>();
		roleLists = roleDao.queryUserRoleList(map);
		List<TreeEntity> trees = new ArrayList<TreeEntity>();
		for (RoleEntity role : roleLists) {
			TreeEntity tree = new TreeEntity();
			tree.setId(role.getId());
			tree.setpId(role.getPid());
			tree.setName(role.getName());
			/*if ("0".equals(role.getPid())) {
				tree.setNocheck(true);
			}*/
			trees.add(tree);
		}
		return trees;
	}

	@SuppressWarnings("unchecked")
	public boolean grant(RoleEntity entity) {
		String roleId = entity.getId();
		if (roleId != null && !roleId.equalsIgnoreCase("")) {
			//先清除角色和菜单之前的关系
			try {
				roleDao.deleteRoleAndResourceByRid(roleId);
			} catch (Exception e) {
				return false;
			}
			List<RoleAndResource> urList = new ArrayList<RoleAndResource>();
			String resourceIds = entity.getResourceIds();
			if (StringUtil.isValid(resourceIds)) {
				for (String resourceId : resourceIds.split(",")) {
					RoleAndResource url = new RoleAndResource();
					url.setRoleId(roleId);
					url.setResourceId(resourceId);
					urList.add(url);
				}
			}
			//重新保存角色和菜单关系
			try {
				roleDao.saveRoleAndResource(urList);
			} catch (Exception e) {
				return false;
			}					
		}else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<TreeEntity> queryAllRoleList(Map<String, Object> map) {
		List<RoleEntity> roleLists = new ArrayList<RoleEntity>();
		roleLists = roleDao.queryAllRoleList(map);
		List<TreeEntity> trees = new ArrayList<TreeEntity>();
		for (RoleEntity role : roleLists) {
			TreeEntity tree = new TreeEntity();
			tree.setId(role.getId());
			tree.setpId(role.getPid());
			tree.setName(role.getName());
			/*if ("0".equals(role.getPid())) {
				tree.setNocheck(true);
			}*/
			trees.add(tree);
		}
		return trees;
	}

	@SuppressWarnings("unchecked")
	public void add(T t) {
		roleDao.add(t);
		/*List<UserAndRole> urList = new ArrayList<UserAndRole>();
		String roleId = entity.getId();
		UserAndRole url = new UserAndRole();
		url.setRoleId(roleId);
		url.setUserId(userId);
		urList.add(url);
		//重新保存用户和角色关系
		userDao.saveUserAndRole(urList);*/
	}

	@SuppressWarnings("unchecked")
	public int update(T t) {
		return roleDao.update(t);
	}

	@Override
	public int delete(Object id) {
		//先清除角色和菜单之前的关系
		try {
			roleDao.deleteRoleAndResourceByRid((String) id);
		} catch (Exception e) {
			return 0;
		}
		return roleDao.delete(id);
	}

	public List<T> queryBylistPage(Map<String, Object> map) {
		return roleDao.queryBylistPage(map);
	}

	public T queryById(Object id) {
		return (T) roleDao.queryById(id);
	}

}
