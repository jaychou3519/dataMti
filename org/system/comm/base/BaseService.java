package system.comm.base;

import java.util.List;
import java.util.Map;

public interface BaseService<T>{
	
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t);
	/**
	 * 0
	 * 更新
	 * @param t
	 */
	public int update(T t);

	/**
	 * 删除
	 * @param id
	 */
	public int delete(Object id);
	/**
	 * 查询数据并分页
	 * @param page
	 * @return
	 */
	public List<T> queryBylistPage(Map<String, Object> map);
	/**
	 * 查询实体
	 * @param id
	 * @return
	 */
	public T queryById(Object id);
}
