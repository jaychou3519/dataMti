package system.dao.dictype;

import java.util.List;
import java.util.Map;

import system.comm.base.BaseDao;
import system.entity.dictype.DicTypeEntity;

public interface DictypeMapper<T> extends BaseDao<T>{
	
	public List<DicTypeEntity> queryPlistPage(Map<String, Object> map);
	
	/**查询所有的数据字典*/
	public List<DicTypeEntity> queryAllDictypeList(Map<String, Object> map);
	
	public DicTypeEntity getEntityByUid(String uid);
	
	/** 删除 */
	public int deleteByPid(Object pid);
}
