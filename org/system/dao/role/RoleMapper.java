package system.dao.role;

import java.util.List;
import java.util.Map;

import system.comm.base.BaseDao;
import system.entity.role.RoleAndResource;
import system.entity.role.RoleEntity;

public interface RoleMapper<T> extends BaseDao<T>{
	
	/**
	 * 查询用户对应的角色
	 * @author zhouq
	 * @create 2014年8月18日 上午11:35:24
	 * @param map
	 * @return
	 */
	public List<RoleEntity> queryUserRoleList(Map<String, Object> map);
	
	/**查询所有的角色列表*/
	public List<RoleEntity> queryAllRoleList(Map<String, Object> map);
	
	/**把角色和菜单的关联表数据先清空*/
	public void deleteRoleAndResourceByRid(String id);
	
	/**把角色和菜单的关联关系保存 */
	public void saveRoleAndResource(List<RoleAndResource> urL);
	
}
