package Exception;

public class FileInputStream implements AutoCloseable {//java 수퍼클래스AutoCloseable
	private String file;
	
	public FileInputStream(String file) {
		this.file = file;
	}
	
	public void read() {
		System.out.println(file + "을 읽습니다.");
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(file + "을 닫습니다.");
	}

}
