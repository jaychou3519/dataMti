package system.dao.resource;

import java.util.List;
import java.util.Map;

import system.comm.base.BaseDao;
import system.entity.resource.ResourceEntity;

public interface ResourceMapper<T> extends BaseDao<T>{
	
	
	public List<ResourceEntity> queryPlistPage(Map<String, Object> map);
	
	
	public List<ResourceEntity> queryByAllList(String userid);
	
	/**查询用户的菜单*/
	public List<ResourceEntity> queryUserResourceList(Map<String, Object> map);
	
	/**查询所有的菜单*/
	public List<ResourceEntity> queryAllResourceList(Map<String, Object> map);
	
	/** 删除 */
	public int deleteByPid(Object pid);
	
}
