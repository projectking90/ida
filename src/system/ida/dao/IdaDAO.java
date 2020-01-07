/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;

import system.ida.dto.AddrDTO;

/**
 * IdaDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface IdaDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.IdaDAO.";

	/**
	 * 메소드 선언
	 */
	List<AddrDTO> getCityList();	// 시 목록을 가져옴
	List<AddrDTO> getGunList(AddrDTO addrDTO);	// 군 목록을 가져옴
	List<AddrDTO> getGuList(AddrDTO addrDTO);	// 구 목록을 가져옴
	List<AddrDTO> getDongList(AddrDTO addrDTO);	// 동 목록을 가져옴
}