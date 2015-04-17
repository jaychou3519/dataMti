package system.service.role;

import java.util.List;
import java.util.Map;

import system.comm.base.BaseService;
import system.comm.base.TreeEntity;
import system.entity.role.RoleEntity;
import system.entity.user.UserEntity;


public interface RoleService<T> extends BaseService<T>{
	
	/**
	 * 查询用户对应的角色
	 * @author zhouq
	 * @create 2014年8月18日 上午11:35:24
	 * @param map
	 * @return
	 */
	public List<TreeEntity> queryUserRoleList(Map<String, Object> map);
	
	/**
	 * 查询所有的角色
	 * @author zhouq
	 * @create 2014年8月18日 上午11:35:24
	 * @param map
	 * @return
	 */
	public List<TreeEntity> queryAllRoleList(Map<String, Object> map);
	
	/**
	 * 授权
	 * @author zhouq
	 * @create 2014年8月20日 下午3:55:30
	 * @param user
	 * @return
	 */
	public boolean grant(RoleEntity user); 
	
}
