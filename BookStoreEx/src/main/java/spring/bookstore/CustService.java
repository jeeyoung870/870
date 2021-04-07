package spring.bookstore;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class CustService {
	
	@Autowired
	@Setter
	CustDao dao;
	@Setter
	@Autowired
	BookDao dao2;
	
	public void orderList1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("고객 이름 : ");
		String  name = scan.next();
		
		List<BookDto> list = dao2.orderList1(name);
		if(list.size() == 0) {
			System.out.println("주문내역이 없습니다.");
		}else {
			for(BookDto book : list) {
				System.out.println(book);
			}
		}
	}
	
	/*
	 * public void orderList2() { Scanner scan = new Scanner(System.in);
	 * 
	 * System.out.println("고객번호 입력 : "); int id = scan.nextInt(); List
	 * <OrderListDto> list = dao.orderList2(id); if(list.size() == 0) {
	 * System.out.println("주문내역이 없습니다."); }else { for(OrderListDto orderListDto :
	 * list) { System.out.println(orderListDto); } int p = dao2.sumPrice(id);
	 * System.out.println("전"); } }
	 */
	public void allCust() {
		List<CustDto> list = dao.selectCusts();
		if(list.size() != 0) {
			for(CustDto d : list) {
				System.out.println(d);
			}
		}
	}
	
	public void addCust() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("name 입력 : ");
		String name = scan.next();
		System.out.println("address 입력 : ");
		String address = scan.next();
		System.out.println("phone 입력 : ");
		String phone = scan.next();
		
		CustDto dto = new CustDto(name, address, phone);
		int check = dao.insertCust(dto); 
		System.out.println("check:"+check);
		if(check == 0) {
			System.out.println("회원추가 실패");
		} else {
			System.out.println(name + " 회원 추가 성공");
		}
		
	}
	
	
}
