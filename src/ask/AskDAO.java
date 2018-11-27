package ask;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;

public class AskDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;
	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	
	public boolean create(AskDTO dto) {
		boolean flag = false;
		int cnt = session.insert("ask.create", dto);
		if(cnt>0) flag = true;
		return flag;
	}
	
	
	public AskDTO read (String ask_code) {
		
		return session.selectOne("ask.read", ask_code);
		
	}
	public boolean update(AskDTO dto) {
		boolean flag = false;
		int cnt = session.update("ask.update", dto);
		if(cnt>0) flag = true;
		return flag;
	}
	
	public boolean delete(String ask_num) {
		boolean flag = false;
		int cnt = session.delete("ask.delete", ask_num);
		if(cnt > 0) flag = true;
		return flag;
	}
	public int total (Map map) {
		return session.selectOne("ask.total", map);
		
	}
	
	public List<AskDTO> list(Map map){
		return session.selectList("ask.list", map);
		
	}
}
