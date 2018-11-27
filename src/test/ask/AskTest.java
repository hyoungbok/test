package test.ask;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ask.AskDAO;
import ask.AskDTO;

public class AskTest {

	public static void main (String[] args) {
		AskDAO dao = new AskDAO();
		
		//create(dao);
		//read(dao);
		//update(dao);
		//delete(dao);
		//total(dao);
		list(dao);
	}

	

	private static void list(AskDAO dao) {
		Map map = new HashMap();
		
		List<AskDTO> list = dao.list(map);
		Iterator<AskDTO> iter = list.iterator();
		while(iter.hasNext()) {
			AskDTO dto = iter.next();
			p(dto);
		}
		
	}



	private static void total(AskDAO dao) {
		
		Map map = new HashMap();
		int total = dao.total(map);
		p("전체레코드수:" + total);
	}



	private static void delete(AskDAO dao) {
		String ask_num = "12";
		if(dao.delete(ask_num)) {
			p("delete성공");
		} else {
			p("delete실패");
		}
		
	}



	private static void update(AskDAO dao) {
		AskDTO dto = dao.read("11");
		dto.setAsk_name("수정ask_name");
		if(dao.update(dto)) {
			p("update성공");
		} else {
			p("update실패");
		}
		
	}



	private static void read(AskDAO dao) {
		String ask_code = "A001";
		AskDTO dto = dao.read(ask_code);
		p(dto);
		
	}


	
	private static void create(AskDAO dao) {
		AskDTO dto = new AskDTO();
		dto.setAsk_code("A008");
		dto.setAsk_name("문의 7");
		if(dao.create(dto)) {
			p("create성공");
			
		}else {
			p("create실패");
		}
	}




	private static void p(String string) {
		System.out.println(string);
	}
	
	private static void p(AskDTO dto) {
		p("코드번호:"+ dto.getAsk_code());
		p("코드이름:"+dto.getAsk_name());
		
	}

}