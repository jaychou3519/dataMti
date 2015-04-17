package system.service.impl.dictype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.comm.base.TreeEntity;
import system.dao.dictype.DictypeMapper;
import system.entity.dictype.DicTypeEntity;
import system.service.dictype.DictypeService;

@Service("dictypeService")
public class DictypeServiceImpl<T> implements DictypeService<T>{
	
	@Autowired
	private DictypeMapper<T> dictypeDao;

	public List<T> queryBylistPage(Map<String, Object> map) {
		return dictypeDao.queryBylistPage(map);
	}

	public List<DicTypeEntity> queryByPList(Map<String, Object> map) {
		return dictypeDao.queryPlistPage(map);
	}
	
	public void add(T entity) {
		dictypeDao.add(entity);
	}

	public List<TreeEntity> queryAllDictypeList(Map<String, Object> map) {
		List<DicTypeEntity> roleLists = new ArrayList<DicTypeEntity>();
		roleLists = dictypeDao.queryAllDictypeList(map);
		List<TreeEntity> trees = new ArrayList<TreeEntity>();
		for (DicTypeEntity role : roleLists) {
			TreeEntity tree = new TreeEntity();
			tree.setId(role.getId());
			tree.setpId(role.getPid());
			tree.setName(role.getText());
			/*if ("0".equals(role.getPid())) {
				tree.setNocheck(true);
			}*/
			trees.add(tree);
		}
		return trees;
	}

	public T queryById(Object id) {
		return dictypeDao.queryById(id);
	}

	public int update(T entity) {
		return dictypeDao.update(entity);
	}

	@Override
	public DicTypeEntity getEntityByUid(String uid) {
		return dictypeDao.getEntityByUid(uid);
	}

	@Override
	public int delete(Object id) {
		return dictypeDao.delete(id);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public int deleteByPid(Object pid){
		return dictypeDao.deleteByPid(pid);
	}

	public List<DicTypeEntity> queryDicTypeList(Map<String, Object> map) {
		return dictypeDao.queryAllDictypeList(map);
	}
}
