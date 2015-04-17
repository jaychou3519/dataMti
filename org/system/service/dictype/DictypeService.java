package system.service.dictype;

import java.util.List;
import java.util.Map;

import system.comm.base.BaseService;
import system.comm.base.TreeEntity;
import system.entity.dictype.DicTypeEntity;


public interface DictypeService<T> extends BaseService<T>{
	
	public List<DicTypeEntity> queryByPList(Map<String, Object> map);
	
	public List<TreeEntity> queryAllDictypeList(Map<String, Object> map);
	
	public DicTypeEntity getEntityByUid(String uid);
	
	/**
	 * 删除
	 * @param id
	 */
	public int deleteByPid(Object pid);
	
	public List<DicTypeEntity> queryDicTypeList(Map<String, Object> map);
}
