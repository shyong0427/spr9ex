package pack;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface DeptInter {
	List<DeptDto> selectList() throws DataAccessException;
}