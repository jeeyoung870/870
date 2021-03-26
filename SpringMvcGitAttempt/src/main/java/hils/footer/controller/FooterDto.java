package hils.footer.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FooterDto {
	
	private int info_num;
	private String company_name;
	private String representative_name;
	private String business_license_number;
	private String business_address;
	private String phone_number;
	private String fax_number;
	
}
