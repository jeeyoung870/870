<%@ page contentType="text/json; charset=utf-8" %>
<%@ page import="java.util.*,com.google.gson.Gson" %>
<% List<String> l = new ArrayList<>(); 
	l.add("apple");
	l.add("banana");
	l.add("calamansi");

	List<String> l2 = new ArrayList<>(); 
	l2.add("durian");
	l2.add("eggplant");
	l2.add("fig");

	List<List<String>> l3 = new ArrayList<>();
	l3.add(l);
	l3.add(l2);
	
	Gson gson = new Gson();
	String json = gson.toJson(l3);
	//String json2 = gson.toJson(l2);
	
	out.print(json);
	
	
%>
