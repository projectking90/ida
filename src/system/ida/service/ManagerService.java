/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import system.ida.dto.ManagerDTO;
import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;

/**
 * ManagerService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface ManagerService {
	/**
	 * 메소드 선언
	 */
	int insertRegManager(ManagerDTO managerDTO);	// 관리자 회원가입
	ManagerDTO getUserInfo(String m_id);	// 관리자 정보를 가져옴
	int updateManagerInfo(ManagerDTO managerDTO);	// 회원정보를 수정
}