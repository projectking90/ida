/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;

/**
 * UserDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface UserDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.UserDAO.";	// mapper의 namespace

	/**
	 * 메소드 선언
	 */
	int getLoginCnt(UserDTO userDTO);	// 사용자가 입력한 로그인 정보의 존재 개수를 가져옴
	int getLoginCnt(UserUpdateDTO user_updateDTO);	// 사용자가 입력한 로그인 정보의 존재 개수를 가져옴
	int getIdCnt(UserDTO userDTO);	// 아이디 존재 여부를 확인
	int getAddrCode(UserDTO userDTO);	// 주소 코드를 가져옴
	int getAddrCode(UserUpdateDTO user_updateDTO);	// 주소 코드를 가져옴
	int insertRegUser(UserDTO userDTO);	// 사용자 회원가입
	UserUpdateDTO getUserInfo(String s_id);	// 사용자 정보를 가져옴
	int updateUserInfo(UserUpdateDTO user_updateDTO);	// 회원정보를 수정
}