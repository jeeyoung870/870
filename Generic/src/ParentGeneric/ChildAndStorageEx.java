package ParentGeneric;

public class ChildAndStorageEx {

	public static void main(String[] args) {
		ChildProduct<Tv, String, String> pd = new ChildProduct<>();
		pd.setKind(new Tv("어쩌구", "티비"));
		pd.setModel("SmartTv");
		pd.setCompany("Samsung");
		
		Storage<Tv> storage = new StorageImpl<Tv>(100);
		//Storage인터페이스를 구현한 StorageImpl 클래스의 객체 생성
		//근데 바로 StorageImpl<Tv> storage = new StorageImpl<Tv>(100); 라고 해도됨
		storage.add(pd.getKind(), 3);
		Tv tv1 = storage.get(3);
		System.out.println(tv1);
		
		ChildProduct<Tv, Integer, String> pd2 = new ChildProduct<>();
		pd2.setKind(pd.getKind());
		pd2.setModel(15345);
		pd2.setCompany("엉조ㅑ누ㅑㅣ");
		
		System.out.println(pd2.getKind() +" " + pd2.getModel() + pd2.getCompany());
		

	}

}
