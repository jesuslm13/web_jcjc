package jcjc.user.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import jcjc.user.entity.User;


@Service
public class JoinValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		// user_id
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_id", "null", "'아이디'를 입력해주세요.");
		
		// user_password
		String pw_pattern = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{8,}$";
		Matcher  pw_matcher = Pattern.compile(pw_pattern).matcher(user.getUser_password());
		
		if(user.getUser_password()==null || !pw_matcher.matches()){
			errors.rejectValue("user_password", "pwerror", "비밀번호는 영문 대소문자, 숫자, 특수문자(!@#$%^&*) 포함 8자 이상으로 입력해주세요.");
		}
		
		// user_name
		String name_pattern = "^[가-힣()]+[가-힣()]$";
		Matcher name_matcher = Pattern.compile(name_pattern).matcher(user.getUser_name());
		
		if(user.getUser_name()==null || !name_matcher.matches()) {
			errors.rejectValue("user_name", "nameerror", "이름은 한글 2자 이상으로 입력해주세요.");
		}
		
		// user_email
		String email_pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		Matcher  email_matcher = Pattern.compile(email_pattern).matcher(user.getUser_email());
		
		if(user.getUser_email()==null || !email_matcher.matches()) {
			errors.rejectValue("user_email", "emailerror", "올바른 e-mail 형식으로 입력해주세요. ex) abc@abc.com");
		}
		
		// user_birthdate
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_birthdate", "null", "'생일'을 입력해주세요.");
		
		// user_postcode
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_postcode", "null", "'주소'를 입력해주세요.");

		// user_road_address
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_road_address", "null", "'주소'를 입력해주세요.");

		// user_jibun_address
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_jibun_address", "null", "'주소'를 입력해주세요.");		

		// user_detail_address
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_detail_address", "null", "'주소'를 입력해주세요.");
		
		// user_extra_address
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_extra_address", "null", "'주소'를 입력해주세요.");
		
		// user_voting_ex
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_voting_ex", "null", "'투표여부'를 입력해주세요.");
		
		// user_prefer_politician
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_prefer_politician", "null", "'좋아하는 정치인'을 입력해주세요.");
		
		// user_support_politician
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_support_politician", "null", "'선호하는 정치인'을 입력해주세요.");
		
		// user_interest
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_interest", "null", "'관심분야'를 입력해주세요.");
	}
	
}
