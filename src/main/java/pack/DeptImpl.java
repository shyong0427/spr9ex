package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

@Service
public class DeptImpl extends JdbcDaoSupport implements DeptInter {
	public DeptImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List<DeptDto> selectList() throws DataAccessException {
		RowMapper rowMapper = new DeptRowMapper();
		
		System.out.print("부서번호  : ");
		Scanner scanner3 = new Scanner(System.in);
		String num = scanner3.nextLine();
		
		if(num.equals("10") || num.equals("20") || num.equals("30") || num.equals("40")) return getJdbcTemplate().query("select jikwon_no, jikwon_name, buser_name, jikwon_jik from jikwon a join buser b on a.buser_num = b.buser_no where buser_no=" + num, rowMapper);
		
		return getJdbcTemplate().query("select jikwon_no, jikwon_name, buser_name, jikwon_jik from jikwon a join buser b on a.buser_num = b.buser_no", rowMapper);
	}
	
	class DeptRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptDto dto = new DeptDto();
			dto.setJikwon_no(rs.getString("jikwon_no"));
			dto.setJikwon_name(rs.getString("jikwon_name"));
			dto.setBuser_name(rs.getString("buser_name"));
			dto.setJikwon_jik(rs.getString("jikwon_jik"));
			
			return dto;
		}
	}
}