package board.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.model.BoardDto;
import board.model.BoardListModel;

@Service
public class BoardService {
	
	@Autowired
	BoardDao dao;
	
	public BoardListModel list(int pageNum, int per){
		int count = dao.count();
		if(count == 0) {
			return new BoardListModel();
		}
		
		int start = (pageNum - 1) * per + 1;	//index는 0부터 시작하므로 +1해줘야함
		int end = start + per -1;
		//System.out.println(per +" "+ start +" "+end);    
		List<BoardDto> list = dao.getList(start, end);
		
		Paging p = new Paging().paging(pageNum, count, per);
		
		return new BoardListModel(list,pageNum,p.totalPageCount,start,p,count);
	}
	
	public BoardDto getContent(int num){
		dao.readCount(num);
		return dao.getContent(num);
	}
	
	public void insert(BoardDto dto, HttpServletRequest request) {
		int number = dao.selectMax()+1;
		int num = dto.getNum();
		dto.setIp(request.getRemoteAddr());	//ip값 구하기
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		if(num == 0) {
			dto.setRef(number);
			
			dao.insert(dto);
		}else {
			dao.updateRef(dto);
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
			dao.insert(dto);		
		}
	}
	
	public BoardDto updateForm(int num){
		return dao.getContent(num);
	}
	
	public void update(BoardDto dto) throws PasswordCheckException{
		String db_password = dao.password(dto.getNum());
		if(db_password.equals(dto.getPasswd())){
			dao.update(dto);
		}else {
			throw new PasswordCheckException("패스워드 틀림");
		}
	}
	
	public void delete(int num, String password)  throws PasswordCheckException{
		String db_password = dao.password(num);
		if(db_password.equals(password)){
			dao.delete(num);
		}else {
			throw new PasswordCheckException("패스워드 틀림");
		}
	}
	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
}
