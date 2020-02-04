/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.ida;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import system.ida.dto.UserDTO;

/**
 * LoginValidator 클래스
 * 로그인 기능의 유효성을 체크
 * @author Jo
 */
public class LoginValidator implements Validator{
	/**
	 * 속성변수 선언
	 */

	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */

	/**
	 * 메소드 선언
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		UserDTO user = (UserDTO) target;
		
		if(user.getPwd().length() < 4) {
			errors.rejectValue("pwd", "pwd.short", "password is minimum 4 length.");
		}
	}
}