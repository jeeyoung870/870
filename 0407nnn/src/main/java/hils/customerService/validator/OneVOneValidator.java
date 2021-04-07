package hils.customerService.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import hils.customerService.model.WriteOneOneVO;



@Component
public class OneVOneValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WriteOneOneVO.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userSubject", "notempty", "누락된 항목이 있습니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textToManager", "notempty", "누락된 항목이 있습니다.");
	}

}
