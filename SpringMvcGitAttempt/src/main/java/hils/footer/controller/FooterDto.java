package hils.footer.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FooterDto {
	
	private int info_num;
	private String company_name;
	private String representative_name;
	private String business_license_number;
	private String business_address;
	private String phone_number;
	private String fax_number;
	public int getInfo_num() {
		return info_num;
	}
	public void setInfo_num(int info_num) {
		this.info_num = info_num;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getRepresentative_name() {
		return representative_name;
	}
	public void setRepresentative_name(String representative_name) {
		this.representative_name = representative_name;
	}
	public String getBusiness_license_number() {
		return business_license_number;
	}
	public void setBusiness_license_number(String business_license_number) {
		this.business_license_number = business_license_number;
	}
	public String getBusiness_address() {
		return business_address;
	}
	public void setBusiness_address(String business_address) {
		this.business_address = business_address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getFax_number() {
		return fax_number;
	}
	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}
	@Override
	public String toString() {
		return "FooterDto [info_num=" + info_num + ", company_name=" + company_name + ", representative_name="
				+ representative_name + ", business_license_number=" + business_license_number + ", business_address="
				+ business_address + ", phone_number=" + phone_number + ", fax_number=" + fax_number + "]";
	}
	
	
}
