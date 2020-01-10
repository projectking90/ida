/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.ida.dao.IdaDAO;
import system.ida.dao.UserDAO;
import system.ida.dto.ManagerDTO;
import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;

/**
 * ManagerServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private UserDAO userDAO;	// UserDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 관리자 회원가입
	 * @param managerDTO : 관리자 정보를 담은 DTO
	 * @return insert_cnt : 관리자 등록 성공 결과
	 */
	@Override
	public int insertRegManager(ManagerDTO managerDTO) {
		/*
		 * int insert_cnt = this.userDAO.getIdCnt(userDTO);
		 * 
		 * if(insert_cnt>0) { return -1; } else { insert_cnt =
		 * this.userDAO.insertRegUser(userDTO); }
		 * 
		 * return insert_cnt;
		 */
		return 0;
	}

	/**
	 * 사용자 정보를 가져옴
	 * @param s_id : 아이디
	 * @return user_updateDTO : 회원정보를 수정하려는 사용자 정보
	 */
	@Override
	public UserUpdateDTO getUserInfo(String s_id) {
		UserUpdateDTO user_updateDTO = this.userDAO.getUserInfo(s_id);
		
		return user_updateDTO;
	}

	/**
	 * 회원정보를 수정
	 * @param user_updateDTO : 변경하려는 회원정보를 담은 DTO
	 * @return updateCnt : 회원정보 변경 결과
	 */
	@Override
	public int updateUserInfo(UserUpdateDTO user_updateDTO) {
		int updateCnt = this.userDAO.getLoginCnt(user_updateDTO);
		
		if(updateCnt==0) {
			return -1;
		}
		
		updateCnt = this.userDAO.updateUserInfo(user_updateDTO);
		
		return updateCnt;
	}
}