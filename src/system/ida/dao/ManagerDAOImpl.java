/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import system.ida.dto.ManagerDTO;
import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;

/**
 * ManagerDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class ManagerDAOImpl implements ManagerDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 관리자가 입력한 로그인 정보의 존재 개수를 가져옴
	 * @param managerDTO : 관리자 정보를 담은 DTO
	 * @return login_cnt : 관리자 정보가 데이터베이스에 존재하는 개수
	 */
	@Override
	public int getLoginCnt(ManagerDTO managerDTO) {
		int login_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getLoginCnt"
				, managerDTO);
		
		return login_cnt;
	}
	
	/**
	 * 아이디 존재 여부를 확인
	 * @param managerDTO : 관리자 정보를 담은 DTO
	 * @return id_cnt : 아이디 존재 개수
	 */
	@Override
	public int getIdCnt(ManagerDTO managerDTO) {
		int id_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getIdCnt"
				, managerDTO);
		
		return id_cnt;
	}

	/**
	 * 관리자 회원가입
	 * @param managerDTO : 관리자 정보를 담은 DTO
	 * @return insert_cnt : 회원가입 성공 개수
	 */
	@Override
	public int insertRegManager(ManagerDTO managerDTO) {
		int insert_cnt = this.sqlSession.insert(
				sqlSessionPath + "insertRegManager"
				, managerDTO);
		
		return insert_cnt;
	}

	/**
	 * 관리자 정보를 가져옴
	 * @param m_id : 아이디
	 * @return user_updateDTO : 회원정보를 수정하려는 관리자 정보
	 */
	@Override
	public ManagerDTO getManagerInfo(String m_id) {
		ManagerDTO managerDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getManagerInfo"
				, m_id
				);
		
		return managerDTO;
	}

	/**
	 * 회원정보를 수정
	 * @param managerDTO : 회원정보를 수정하려는 관리자 정보
	 * @return updateCnt : 회원정보 수정 결과
	 */
	@Override
	public int updateManagerInfo(ManagerDTO managerDTO) {
		int updateCnt = this.sqlSession.update(
				sqlSessionPath + "updateManagerInfo"
				, managerDTO);
		
		return updateCnt;
	}
}