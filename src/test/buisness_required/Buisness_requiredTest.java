package test.buisness_required;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ask.AskDTO;
import buisness_required.Buisness_requiredDAO;
import buisness_required.Buisness_requiredDTO;

public class Buisness_requiredTest {
	
	public static void main(String[] args) {
		
		Buisness_requiredDAO dao = new Buisness_requiredDAO();
		
		//create(dao);
		//read(dao);
		update(dao);
		//delete(dao);
		//total(dao);
		//list(dao);
	}

	private static void list(Buisness_requiredDAO dao) {
		
		Map map = new HashMap();
		map.put("buisnessID", "soldesk");
		map.put("result_code", "x");
		map.put("sno", 1);
		map.put("eno", 5);
		List<Buisness_requiredDTO> list = dao.list(map);
		Iterator<Buisness_requiredDTO> iter = list.iterator();
		while(iter.hasNext()) {
		
			Buisness_requiredDTO dto = iter.next();
			p(dto);
			p("----------------");
		}
	}
	
	
	private static void total(Buisness_requiredDAO dao) {
		Map map = new HashMap();

		map.put("col", "");
		map.put("word", "");
		
		int total = dao.total(map);
		p("전체레코드수:" + total);
		
	}

	private static void delete(Buisness_requiredDAO dao) {
		int rep_num = 5;
		if(dao.delete(rep_num)) {
			p("delete성공");
		} else {
			p("delete실패");
		}
		
	}

	private static void update(Buisness_requiredDAO dao) {
		int rep_num = 1;
		Buisness_requiredDTO dto = dao.read(rep_num);
		dto.setReq_content("content");
		dto.setReq_title("title");
		dto.setReq_file("req_file");
		dto.setResult_code("o");
		if(dao.update(dto)) {
			p("update성공");
		}else {
			p("update실패");
		}
	}

	private static void read(Buisness_requiredDAO dao) {
		int rep_num = 1;
		Buisness_requiredDTO dto = dao.read(rep_num);
		p(dto);
		
	}

	private static void create(Buisness_requiredDAO dao) {
		Buisness_requiredDTO dto =new Buisness_requiredDTO();
		dto.setAsk_code("A002");
		dto.setBuisnessID("soldesk1");
		dto.setR_code("R002");
		dto.setReq_content("req_content1");
		dto.setReq_file("file1");
		dto.setReq_title("req_title1");
		
		if(dao.create(dto)) {
			p("create성공");
		}else {
			p("create실패");
		}
		
	}

	private static void p(String string) {
		System.out.println(string);
		
	}
	private static void p(Buisness_requiredDTO dto) {
		p("번호:"+ dto.getReq_num());
		p("요청코드:"+ dto.getAsk_code());
		p("제목:"+ dto.getReq_title());
		p("내용:"+ dto.getReq_content());
		p("파일:"+ dto.getReq_file());
		p("날짜:"+ dto.getReq_date());
		p("사없자ID:"+ dto.getBuisnessID());
		p("식당코드:"+ dto.getR_code());
		p("result_code:"+ dto.getResult_code());
		
		
		
	}

}
