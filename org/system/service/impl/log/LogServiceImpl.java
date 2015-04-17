package system.service.impl.log;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.dao.log.LogMapper;
import system.service.log.LogService;

@Service("logService")
public class LogServiceImpl<T> implements LogService<T>{
	
	@Autowired
	private LogMapper<T> logDao;

	@Override
	public void add(T t) {
		logDao.add(t);
	}

	@Override
	public int update(T t) {
		return logDao.update(t);
	}

	@Override
	public int delete(Object id) {
		return logDao.delete(id);
	}

	@Override
	public List<T> queryBylistPage(Map map) {
		return logDao.queryBylistPage(map);
	}

	@Override
	public T queryById(Object id) {
		return logDao.queryById(id);
	}

}
