/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import system.ida.dto.AddrDTO;
import system.ida.dto.MenuTrackingDTO;

/**
 * IdaDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class IdaDAOImpl implements IdaDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 시 목록을 가져옴
	 * @return city_list : 시 목록
	 */
	@Override
	public List<AddrDTO> getCityList() {
		List<AddrDTO> city_list = this.sqlSession.selectList(
				sqlSessionPath + "getCityList");
		
		return city_list;
	}

	/**
	 * 군 목록을 가져옴
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return gun_list : 군 목록
	 */
	@Override
	public List<AddrDTO> getGunList(AddrDTO addrDTO) {
		List<AddrDTO> gun_list = this.sqlSession.selectList(
				sqlSessionPath + "getGunList"
				, addrDTO);
		
		return gun_list;
	}

	/**
	 * 구 목록을 가져옴
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return gun_list : 구 목록
	 */
	@Override
	public List<AddrDTO> getGuList(AddrDTO addrDTO) {
		List<AddrDTO> gu_list = this.sqlSession.selectList(
				sqlSessionPath + "getGuList"
				, addrDTO);
		
		return gu_list;
	}

	/**
	 * 동 목록을 가져옴
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return dong_list : 동 목록
	 */
	@Override
	public List<AddrDTO> getDongList(AddrDTO addrDTO) {
		List<AddrDTO> dong_list = this.sqlSession.selectList(
				sqlSessionPath + "getDongList"
				, addrDTO);
		
		return dong_list;
	}

	/**
	 * 메뉴 트래킹 정보를 가져옴
	 * @param path_user_flag : 경로와 유저구분
	 * @return menu_tracking : 메뉴 트래킹 정보
	 */
	@Override
	public MenuTrackingDTO getMenuTracking(Map<String, String> path_user_flag) {
		MenuTrackingDTO menu_tracking_list = this.sqlSession.selectOne(
				sqlSessionPath + "getMenuTracking"
				, path_user_flag);
		
		return menu_tracking_list;
	}

	/**
	 * 테이블의 마지막 수정 날짜를 가져옴
	 * @param table_name_s_id : 테이블 이름과 사용자 아이디
	 * @return last_update_date : 테이블 마지막 수정 날짜
	 */
	@Override
	public String getLastUpdateTable(Map<String, String> table_name_s_id) {
		String last_update_date = this.sqlSession.selectOne(
				sqlSessionPath + "getLastUpdateTable"
				, table_name_s_id);
		
		return last_update_date;
	}
}