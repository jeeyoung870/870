package view.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfo {
	
	private String userId;
	private String name;
	private Address address;
	private String[] favorites;
	private String jobCode;
	private String tool;
	private String etc;
	private boolean contractAgreement;
	
	public boolean isContractAgreement() {
		return contractAgreement;
	}
	
	public void setContractAgreement(boolean contractAgreement) {
		this.contractAgreement = contractAgreement;
	}
}
