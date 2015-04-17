package system.dao.user;

import java.util.List;

import system.comm.base.BaseDao;
import system.entity.user.UserAndRole;
import system.entity.user.UserEntity;

public interface UserMapper<T> extends BaseDao<T>{
	
	public UserEntity login(UserEntity entity);
	
	public UserEntity getEntity(UserEntity entity);
	
	/**把用户和用户下的角色的关联表数据先清空*/
	public void deleteUserAndRoleByUid(String id);
	
	/**再把用户和用户下的角色的关联关系保存*/
	public void saveUserAndRole(List<UserAndRole> urL);
}
