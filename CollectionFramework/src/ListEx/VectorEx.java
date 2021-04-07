package ListEx;

import java.util.List;
import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> li = new Vector<>();
		
		li.add(new Board("topic1", "content1", "writter1"));
		li.add(new Board("topic2", "content2", "writter2"));
		li.add(new Board("topic3", "content3", "writter3"));
		li.add(new Board("topic4", "content4", "writter4"));
		li.add(new Board("topic5", "content5", "writter5"));
		
		li.remove(2);
		li.remove(3);
		
		for (int i = 0; i < li.size(); ++i) {
			Board board = li.get(i);
			System.out.println(board.subject + board.content + board.writter);
		}
		
		System.out.println();
		//위의 반복문과 같음.
		for (Board s : li) {
			System.out.println(s.subject + s.content + s.writter);
		}	//public 필드일 경우 getter없이 바로 소환 가능
	}

}
