package system.service.user;

import system.comm.base.BaseService;
import system.entity.user.UserEntity;


public interface UserService<T> extends BaseService<T>{
	/**
	 * 登陆验证
	 * @author zhouq
	 * @create 2014年8月18日 上午9:34:28
	 * @param entity
	 * @return
	 */
	public UserEntity login(UserEntity entity);
	
	/**
	 * 通过属性获取实体
	 * @author zhouq
	 * @create 2014年8月18日 上午9:33:43
	 * @param entity
	 * @return
	 */
	public UserEntity getEntity(UserEntity entity);
	
	public boolean grant(UserEntity user); 
}
