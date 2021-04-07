package spring.validator;

import org.springframework.validation.Errors;

import spring.model.customDto;

public class customerValidator {

	public void validate(Object target, Errors errors) {
		customDto dto = (customDto)target;
		if(dto.getName() == null || dto.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if(dto.getAddress() == null || dto.getAddress().trim().isEmpty()) {
			errors.rejectValue("address", "required");
		}
		if(dto.getPhone() == null || dto.getPhone().trim().isEmpty()) {
			errors.rejectValue("phone", "required");
		}
	}
}
