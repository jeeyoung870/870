<%@ page contentType="application/json; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="person.data.Person" %>
<%@ page import="com.google.gson.Gson" %>
<% 
	Person p1 = new Person("코로나", 1 , "여");
	Person p2 = new Person("메르스", 5 , "여");
	Person p3 = new Person("신종플루", 10 , "남");
    
	List<Person> list = new ArrayList<>();
	
	list.add(p1);
	list.add(p2);
	list.add(p3);
	
	//gson jar파일추가로 사용가능해진 Gson()객체 만들고 toJson()메소드로 json데이터로 변환하기
	Gson gson = new Gson();
	String text_person = gson.toJson(list);
%>
<%= text_person %>


