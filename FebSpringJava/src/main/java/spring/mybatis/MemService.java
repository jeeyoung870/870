package spring.mybatis;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;


@Service
public class MemService {
	
	@Autowired
	@Setter
	MemDao dao;
	
	@Transactional
	public void addMems() {
		MemDto dto = new MemDto("id1", "password1", "name1", "email1");
		//primary key인 memberid컬럼값이 중복이면 무결성 제약 조건에 의한 에러가 나므로,
		//Transactional로 묶인 모든 작업이 취소된다.
		MemDto dto2 = new MemDto("id1", "password2", "name2", "email2");
		//MemDto dto2 = new MemDto("id2", "password2", "name2", "email2");
		dao.insertMem(dto);
		dao.insertMem(dto2);
	}
	
	public void members() {
		List<MemDto> list = dao.selectMems();
		if(list.size() != 0) {
			for(MemDto d : list) {
				System.out.println(d);
			}
		}
	}
	
	public void addMem() {
		Scanner scan = new Scanner(System.in);
		System.out.println("id 입력 : ");
		String id = scan.next();
		System.out.println("password 입력 : ");
		String password = scan.next();
		System.out.println("name 입력 : ");
		String name = scan.next();
		System.out.println("email 입력 : ");
		String email = scan.next();
		
		MemDto dto = new MemDto(id, password, name, email);
		dao.insertMem(dto);
		
	}

}
