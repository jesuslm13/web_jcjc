package jcjc.user.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import jcjc.user.biz.UserBiz;
import jcjc.user.entity.User;

@Service
public class LoginValidator implements Validator{

	@Autowired
	private UserBiz biz;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		User userEntity = biz.loginUser(user.getUser_id(), user.getUser_password());
		
		// user_id
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_id", "null", "'아이디'를 입력해주세요.");
		
		// user_password
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_password", "null", "'비밀번호'를 입력해주세요.");
		
		// 사용자가 입력한 id, pw랑 데이터베이스 안에 있는 id, pw를 비교
		// biz.loginUser(user.getUser_id().trim(), user.getUser_password().trim());
		
	}

}
