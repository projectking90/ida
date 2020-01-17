/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.List;
import java.util.Map;

import system.ida.dto.AddrDTO;
import system.ida.dto.MenuTrackingDTO;

/**
 * IdaService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface IdaService {
	/**
	 * 메소드 선언
	 */
	List<AddrDTO> getCityList();	// 시 목록을 가져옴
	List<AddrDTO> getGunList(AddrDTO addrDTO);	// 군 목록을 가져옴
	List<AddrDTO> getGuList(AddrDTO addrDTO);	// 구 목록을 가져옴
	List<AddrDTO> getDongList(AddrDTO addrDTO);	// 동 목록을 가져옴
	List<MenuTrackingDTO> getMenuTracking(Map<String, String> path_user_flag);	// 메뉴 트래킹 정보를 가져옴
	String getLastUpdateTable(Map<String, String> table_name_s_id);	// 테이블의 마지막 수정 날짜를 가져옴
}