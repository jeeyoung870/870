package spring.collection;

import java.util.*;

public class CollectionEx {
	List <String> greeting;
	Map<Integer, String> names;
	Properties props;
	
	public void setGreeting(List<String> greeting) {
		this.greeting = greeting;
	}
	public void setNames(Map<Integer, String> names) {
		this.names = names;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	@Override
	public String toString() {
		return "CollectionEx [greeting=" + greeting + ", names=" + names + ", props=" + props + "]";
	}
	
	

}
