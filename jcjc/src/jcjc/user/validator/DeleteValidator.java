package jcjc.user.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import jcjc.user.biz.UserBiz;
import jcjc.user.entity.User;

@Service
public class DeleteValidator implements Validator{

	@Autowired
	private UserBiz biz;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;

		// user_password
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_password", "null", "'비밀번호'를 입력해주세요.");
	
	}
}
