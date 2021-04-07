package spring.model;

public class FileDto {

	private int no;
	private String OrigName; 
	private String savePath;
	
	public FileDto() {}
	
	public FileDto(int no, String origName, String savePath) {
		super();
		this.no = no;
		OrigName = origName;
		this.savePath = savePath;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOrigName() {
		return OrigName;
	}
	public void setOrigName(String origName) {
		OrigName = origName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}
