/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;

/**
 * UserDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨 / 
 * 직접 데이터베이스와 연동해 Query를 수행
 * @author Jo
 */
@Repository
public class UserDAOImpl implements UserDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 사용자가 입력한 로그인 정보의 존재 개수를 가져옴
	 * @param userDTO : 사용자 정보 DTO
	 * @return login_cnt : 사용자 정보 존재 개수
	 */
	@Override
	public int getLoginCnt(UserDTO userDTO) {
		int login_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getLoginCnt"
				, userDTO);
		
		return login_cnt;
	}
	
	/**
	 * 사용자가 입력한 로그인 정보의 존재 개수를 가져옴
	 * @param user_updateDTO : 변경하려는 사용자 정보 DTO
	 * @return login_cnt : 사용자 정보 존재 개수
	 */
	@Override
	public int getLoginCnt(UserUpdateDTO user_updateDTO) {
		int login_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getLoginCnt"
				, user_updateDTO);
		
		return login_cnt;
	}

	/**
	 * 아이디 존재 여부를 확인
	 * @param userDTO : 사용자 정보 DTO
	 * @return id_cnt : 아이디 존재 개수
	 */
	@Override
	public int getIdCnt(UserDTO userDTO) {
		int id_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getIdCnt"
				, userDTO);
		
		return id_cnt;
	}

	/**
	 * 주소 코드를 가져옴
	 * @param userDTO : 사용자 정보 DTO
	 * @return addr_code : 주소 코드
	 */
	@Override
	public int getAddrCode(UserDTO userDTO) {
		int addr_code = this.sqlSession.selectOne(
				sqlSessionPath + "getAddrCode"
				, userDTO);
		
		return addr_code;
	}

	/**
	 * 주소 코드를 가져옴
	 * @param user_updateDTO : 변경하려는 사용자 정보 DTO
	 * @return addr_code : 주소 코드
	 */
	@Override
	public int getAddrCode(UserUpdateDTO user_updateDTO) {
		int addr_code = this.sqlSession.selectOne(
				sqlSessionPath + "getAddrCode"
				, user_updateDTO);
		
		return addr_code;
	}

	/**
	 * 사용자 회원가입
	 * @param userDTO : 사용자 정보 DTO
	 * @return insert_cnt : 회원가입 Query 결과
	 */
	@Override
	public int insertRegUser(UserDTO userDTO) {
		int insert_cnt = this.sqlSession.insert(
				sqlSessionPath + "insertRegUser"
				, userDTO);
		
		return insert_cnt;
	}

	/**
	 * 사용자 정보를 가져옴
	 * @param s_id : 아이디
	 * @return user_updateDTO : 사용자 정보
	 */
	@Override
	public UserUpdateDTO getUserInfo(String s_id) {
		UserUpdateDTO user_updateDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getUserInfo"
				, s_id);
		
		return user_updateDTO;
	}

	/**
	 * 회원정보를 수정
	 * @param user_updateDTO : 변경하려는 사용자 정보 DTO
	 * @return updateCnt : 회원정보 수정 Query 결과
	 */
	@Override
	public int updateUserInfo(UserUpdateDTO user_updateDTO) {
		int updateCnt = this.sqlSession.update(
				sqlSessionPath + "updateUserInfo"
				, user_updateDTO);
		
		return updateCnt;
	}
}