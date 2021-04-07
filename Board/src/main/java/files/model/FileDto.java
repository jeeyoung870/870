package files.model;

public class FileDto {  

	private int no;
	private int num;
	private String origName; 
	private String savePath;
	
	public FileDto() {}
	
	public FileDto(int no, int num, String origName, String savePath) {
		super();
		this.no = no;
		this.num = num;
		this.origName = origName;
		this.savePath = savePath;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getOrigName() {
		return origName;
	}

	public void setOrigName(String origName) {
		this.origName = origName;
	}

	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String toString() {
		return "FileDto [no=" + no + ", num=" + num + ", OrigName=" + origName + ", savePath=" + savePath + "]";
	}
	
}
