package view.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Code {
	
	private String code;
	private String label;
	
	public Code() {
	}
	
	public Code(String code, String label) {
		this.code = code;
		this.label = label;
	}
}
