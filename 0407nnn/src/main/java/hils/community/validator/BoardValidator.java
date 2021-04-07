/**
 * 
 */
package hils.community.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import hils.community.model.WriteArticleModel;



/**
 * @author soldesk
 *
 */
@Component
public class BoardValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WriteArticleModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "b_subject", "notempty", "제목이 누락되었습니다..");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "b_content", "notempty", "내용이 누락되었습니다..");
	}

}
