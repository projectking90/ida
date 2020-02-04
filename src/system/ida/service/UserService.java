/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;

/**
 * UserService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface UserService {
	/**
	 * 메소드 선언
	 */
	int getLoginCnt(UserDTO userDTO);	// 사용자가 입력한 로그인 정보의 존재 개수를 가져옴
	int getAddrCode(UserDTO userDTO);	// 주소 코드를 가져옴
	int getAddrCode(UserUpdateDTO user_updateDTO);	// 주소 코드를 가져옴
	int insertRegUser(UserDTO userDTO);	// 사용자 회원가입 처리함
	UserUpdateDTO getUserInfo(String s_id);	// 사용자 정보를 가져옴
	int updateUserInfo(UserUpdateDTO user_updateDTO);	// 회원정보 수정 처리함
}