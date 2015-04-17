package system.service.impl.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.comm.utils.StringUtil;
import system.dao.user.UserMapper;
import system.entity.user.UserAndRole;
import system.entity.user.UserEntity;
import system.service.user.UserService;

@Service("userService")
public class UserServiceImpl<T> implements UserService<T>{
	
	@Autowired
	private UserMapper<T> userDao;

	@Override
	public UserEntity login(UserEntity entity) {
		return userDao.login(entity);
	}

	@Override
	public UserEntity getEntity(UserEntity entity) {
		return userDao.getEntity(entity);
	}

	@Override
	public boolean grant(UserEntity user) {
		String userId = user.getId();
		if (userId != null && !userId.equalsIgnoreCase("")) {
			//先清除用户和角色之前的关系
			try {
				userDao.deleteUserAndRoleByUid(userId);
			} catch (Exception e) {
				return false;
			}
			List<UserAndRole> urList = new ArrayList<UserAndRole>();
			String roleIds = user.getRoleIds();
			if (StringUtil.isValid(roleIds)) {
				for (String roleId : roleIds.split(",")) {
					UserAndRole url = new UserAndRole();
					url.setRoleId(roleId);
					url.setUserId(userId);
					urList.add(url);
				}
			}
			//重新保存用户和角色关系
			try {
				userDao.saveUserAndRole(urList);
			} catch (Exception e) {
				return false;
			}					
		}else {
			return false;
		}
		return true;
	}

	@Override
	public void add(T t) {
		userDao.add(t);
	}

	@Override
	public int update(T t) {
		return userDao.update(t);
	}

	@Override
	public int delete(Object id) {
		//先清除用户和角色之前的关系
		try {
			userDao.deleteUserAndRoleByUid((String) id);
		} catch (Exception e) {
			return 0;
		}
		return userDao.delete(id);
	}

	@Override
	public List<T> queryBylistPage(Map<String, Object> map) {
		return userDao.queryBylistPage(map);
	}

	@Override
	public T queryById(Object id) {
		return userDao.queryById(id);
	}

}
