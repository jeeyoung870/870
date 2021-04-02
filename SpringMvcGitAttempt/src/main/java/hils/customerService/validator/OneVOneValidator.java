package hils.customerService.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sun.jdi.event.Event;

@Component
public class OneVOneValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Event.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userSubject", "notempty", "제목이 비었습니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textToManager", "notempty", "내용이 비었습니다.");
	}

}
