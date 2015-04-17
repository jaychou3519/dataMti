package system.service.impl.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.demo.DemoMapper;
import system.service.demo.DemoService;

@Service("demoService")
public class DemoServiceImpl<T> implements DemoService<T>{
	
	@Autowired
	private DemoMapper<T> demoDao;

	@Override
	public void add(T t) {
		demoDao.add(t);
	}

	@Override
	public int update(T t) {
		return demoDao.update(t);
	}

/*	@Override
	public int updateBySelective(T t) {
		return demoDao.updateBySelective(t);
	}*/

	@Override
	public int delete(Object id) {
		return demoDao.delete(id);
	}

	@Override
	public List<T> queryBylistPage(Map<String, Object> map) {
		return demoDao.queryBylistPage(map);
	}

	@Override
	public T queryById(Object id) {
		return (T) demoDao.queryById(id);
	}

}
