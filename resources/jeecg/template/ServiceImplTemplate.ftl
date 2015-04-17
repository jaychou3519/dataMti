package ${bussPackage}.service.impl.${entityPackage};

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${bussPackage}.dao.${entityPackage}.${className}Mapper;
import ${bussPackage}.service.${entityPackage}.${className}Service;

@Service
public class ${className}ServiceImpl<T> implements ${className}Service<T>{
	
	@Autowired
	private ${className}Mapper ${className}Dao;

	@Override
	public void add(T t) {
		${className}Dao.add(t);
	}

	@Override
	public int update(T t) {
		return ${className}Dao.update(t);
	}

	@Override
	public int delete(Object id) {
		return ${className}Dao.delete(id);
	}

	@Override
	public List<T> queryBylistPage(Map map) {
		return ${className}Dao.queryBylistPage(map);
	}

	@Override
	public T queryById(Object id) {
		return (T) ${className}Dao.queryById(id);
	}

}
