package spring.validator;

import org.springframework.validation.Errors;
import spring.model.Address;
import spring.model.MemberInfo;

public class MemberInfoValidator /*implements Validation */{
	
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo) target;
		//id가 null이거나 빈문자열이라면,
		if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			//id필드에 required 에러코드를 추가한다.
			errors.rejectValue("id", "required");
		}
		if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		Address address = memberInfo.getAddress();
		if (address == null) {
			errors.rejectValue("address", "required");
		}
		if (address != null) {
			//pushNestedPath("address") : address객체 안의 경로로 들어감.
			errors.pushNestedPath("address");
			try {
				if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
					errors.rejectValue("zipcode", "required");
				}
				if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
					errors.rejectValue("address1", "required");
				}
			} finally {
				//pushNestedPath로 들어가서 검사한 후, popNestedPath해서 address객체로 다시 올라옴
				errors.popNestedPath();
			}
		}
	}
}