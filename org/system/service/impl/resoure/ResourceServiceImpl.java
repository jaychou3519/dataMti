package system.service.impl.resoure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.comm.base.TreeEntity;
import system.dao.resource.ResourceMapper;
import system.entity.resource.ResourceEntity;
import system.service.resource.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl<T> implements ResourceService<T>{
	
	@Autowired
	private ResourceMapper<T> resourceDao;


	@Override
	public List<ResourceEntity> queryByPList(Map<String, Object> map) {
		return resourceDao.queryPlistPage(map);
	}

	@Override
	public List<ResourceEntity> queryByAllList(String userid) {
		return resourceDao.queryByAllList(userid);
	}

	@Override
	public List<TreeEntity> queryUserResourceList(Map<String, Object> map) {
		List<ResourceEntity> roleLists = new ArrayList<ResourceEntity>();
		roleLists = resourceDao.queryUserResourceList(map);
		List<TreeEntity> trees = new ArrayList<TreeEntity>();
		for (ResourceEntity role : roleLists) {
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

	public List<TreeEntity> queryAllResourceList(Map<String, Object> map) {
		List<ResourceEntity> roleLists = new ArrayList<ResourceEntity>();
		roleLists = resourceDao.queryAllResourceList(map);
		List<TreeEntity> trees = new ArrayList<TreeEntity>();
		for (ResourceEntity role : roleLists) {
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

	@Override
	public void add(T t) {
		resourceDao.add(t);
		/*List<RoleAndResource> urList = new ArrayList<RoleAndResource>();
		String resourceId = entity.getId();
				RoleAndResource url = new RoleAndResource();
				url.setRoleId(roleId);
				url.setResourceId(resourceId);
				urList.add(url);
			}
		}
		//重新保存角色和菜单关系
			roleDao.saveRoleAndResource(urList);*/
	}

	@Override
	public int update(T t) {
		return resourceDao.update(t);
	}

	@Override
	public int delete(Object id) {
		return resourceDao.delete(id);
	}

	/**
	 * 删除
	 * @param id
	 */
	public int deleteByPid(Object pid){
		return resourceDao.deleteByPid(pid);
	}
	
	@Override
	public List<T> queryBylistPage(Map<String, Object> map) {
		return resourceDao.queryBylistPage(map);
	}

	@Override
	public T queryById(Object id) {
		return resourceDao.queryById(id);
	}

	@Override
	public List<ResourceEntity> queryAllResourceList() {
		return resourceDao.queryAllResourceList(null);
	}

}
