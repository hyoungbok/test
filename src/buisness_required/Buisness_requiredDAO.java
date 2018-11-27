package buisness_required;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;



public class Buisness_requiredDAO {
	
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;
	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	public boolean create(Buisness_requiredDTO dto) {
		boolean flag = false;
		int cnt = session.insert("buisness_required.create",dto);
		if(cnt>0) flag = true;
		return flag;
	}
	public Buisness_requiredDTO read(int rep_num) {
		
		return session.selectOne("buisness_required.read", rep_num);
		
	}
	public boolean update(Buisness_requiredDTO dto) {
		boolean flag = false;
		int cnt = session.update("buisness_required.update", dto);
		if(cnt > 0) flag = true;
		return flag;
	}
	public boolean delete(int rep_num) {
		boolean flag = false;
		int cnt = session.delete("buisness_required.delete", rep_num);
		if(cnt > 0) flag = true;
		return flag;
		
	}
	
	public int total(Map map) {
		
		return session.selectOne("buisness_required.total", map);
	}
	
	public List<Buisness_requiredDTO> list (Map map){
		
		return session.selectList("buisness_required.list", map);
		
	}
	
}
