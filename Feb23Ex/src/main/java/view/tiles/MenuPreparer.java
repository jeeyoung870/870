package view.tiles;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class MenuPreparer implements ViewPreparer {

	public void execute(Request tilesContext, AttributeContext attributeContext) {
		List<String> menuList = new ArrayList<String>();
		menuList.add("홈");
		menuList.add("로그인");
		menuList.add("회원가입");
		//Attribute 객체로 추가해줘야 함. true : 여러 페이지에서 사용가능 지정
		attributeContext.putAttribute("menuList", new Attribute(menuList), true);
	}
}
