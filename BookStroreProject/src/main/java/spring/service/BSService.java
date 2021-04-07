package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import spring.model.customDto;
import spring.model.salesDto;

@Setter
@Service
public class BSService {

	@Autowired
	BSDao dao;
	
	public List<customDto> allCust(){
		return dao.allCust();
	}
	
	public List<salesDto> bookSales(String bookname){
		return dao.bookSales(bookname);
	}
	
	public List<salesDto> customSales1(String name) {
		return dao.customSales1(name);
	}
	public List<salesDto> customSales2(String name) {
		return dao.customSales2(name);
	}
	
	public int newCustid() {
		return dao.newCustid();
	}
	
	public int insertCust(customDto custDto) {
		return dao.insertCust(custDto);
	}
	
	public int updateAddr(customDto custDto) {
		return dao.updateAddr(custDto);
	}
	
}
