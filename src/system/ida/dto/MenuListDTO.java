/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * MenuListDTO 클래스
 * 메뉴 목록 DTO
 * @author Jo
 */
public class MenuListDTO {
	/**
	 * 속성변수 선언
	 */
	private String mi_no;	// 메뉴 번호
	private String mi_name;	// 메뉴 이름
	private List<MenuDTO> mi_nameList;	// 메뉴 목록
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * mi_no 접근자
	 * @return mi_no : 메뉴 번호
	 */
	public String getMi_no() {
		return mi_no;
	}
	/**
	 * mi_no 설정자
	 * @param mi_no : 메뉴 번호
	 */
	public void setMi_no(String mi_no) {
		this.mi_no = mi_no;
	}
	/**
	 * mi_name 접근자
	 * @return mi_name : 메뉴 이름
	 */
	public String getMi_name() {
		return mi_name;
	}
	/**
	 * mi_name 설정자
	 * @param mi_name : 메뉴 이름
	 */
	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}
	/**
	 * mi_nameList 접근자
	 * @return mi_nameList : 메뉴 목록
	 */
	public List<MenuDTO> getMi_nameList() {
		return mi_nameList;
	}
	/**
	 * mi_nameList 설정자
	 * @param mi_nameList : 메뉴 목록
	 */
	public void setMi_nameList(List<MenuDTO> mi_nameList) {
		this.mi_nameList = mi_nameList;
	}
}