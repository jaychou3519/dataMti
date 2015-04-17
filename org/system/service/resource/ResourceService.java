package system.service.resource;

import java.util.List;
import java.util.Map;

import system.comm.base.BaseService;
import system.comm.base.TreeEntity;
import system.entity.resource.ResourceEntity;


public interface ResourceService<T> extends BaseService<T>{
	
	public List<ResourceEntity> queryByPList(Map<String, Object> map);
	
	public List<ResourceEntity> queryByAllList(String userid);
	
	/**
	 * 管理員則獲取所有的菜單
	 * @author zhouq
	 * @create 2014年8月28日 上午9:24:44
	 * @param userid
	 * @return
	 */
	public List<ResourceEntity> queryAllResourceList();
	/**
	 * 获取用户对应的菜单
	 * @author zhouq
	 * @create 2014年8月19日 下午3:07:05
	 * @param map
	 * @return
	 */
	public List<TreeEntity> queryUserResourceList(Map<String, Object> map);
	
	public List<TreeEntity> queryAllResourceList(Map<String, Object> map);
	
	/**
	 * 删除
	 * @param id
	 */
	public int deleteByPid(Object pid);
		
}
