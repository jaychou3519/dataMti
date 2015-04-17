package system.comm.base;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {
	
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t);
	/**
	 * 更新
	 * @param t
	 */
	public Integer update(T t);
	/**
	 * 更新by主键
	 * @param t
	 */
	public Integer updateBySelective(T t); 	
	/**
	 * 删除
	 * @param id
	 */
	public Integer delete(Object id);
	/**
	 * 查询数据并分页
	 * @param page
	 * @return
	 */
	public List<T> queryBylistPage(Map map);
	/**
	 * 查询实体
	 * @param id
	 * @return
	 */
	public T queryById(Object id);
}
