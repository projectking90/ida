/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * CodeMenuDTO 클래스
 * 메뉴 DTO
 * @author Jo
 */
public class CodeMenuDTO {
	/**
	 * 속성변수 선언
	 */
	private String ma_code;	// 메뉴 대분류 코드
	private String ma_name;	// 메뉴 대분류 이름
	private List<CodeMenuAlphaDTO> ma_nameList;	// 메뉴 대분류 목록
	private String mb_code;	// 메뉴 소분류 코드
	private String mb_name;	// 메뉴 소분류 이름
	private List<CodeMenuBetaDTO> mb_nameList;	// 메뉴 소분류 목록

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * ma_code 접근자
	 * @return ma_code : 메뉴 대분류 코드
	 */
	public String getMa_code() {
		return ma_code;
	}
	/**
	 * ma_code 설정자
	 * @param ma_code : 메뉴 대분류 코드
	 */
	public void setMa_code(String ma_code) {
		this.ma_code = ma_code;
	}
	/**
	 * ma_name 접근자
	 * @return ma_name : 메뉴 대분류 이름
	 */
	public String getMa_name() {
		return ma_name;
	}
	/**
	 * ma_name 설정자
	 * @param ma_name : 메뉴 대분류 이름
	 */
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}
	/**
	 * ma_nameList 접근자
	 * @return ma_nameList : 메뉴 대분류 목록
	 */
	public List<CodeMenuAlphaDTO> getMa_nameList() {
		return ma_nameList;
	}
	/**
	 * ma_nameList 설정자
	 * @param ma_nameList : 메뉴 대분류 목록
	 */
	public void setMa_nameList(List<CodeMenuAlphaDTO> ma_nameList) {
		this.ma_nameList = ma_nameList;
	}
	/**
	 * mb_code 접근자
	 * @return mb_code : 메뉴 소분류 코드
	 */
	public String getMb_code() {
		return mb_code;
	}
	/**
	 * mb_code 설정자
	 * @param mb_code : 메뉴 소분류 코드
	 */
	public void setMb_code(String mb_code) {
		this.mb_code = mb_code;
	}
	/**
	 * mb_name 접근자
	 * @return mb_name : 메뉴 소분류 이름
	 */
	public String getMb_name() {
		return mb_name;
	}
	/**
	 * mb_name 설정자
	 * @param mb_name : 메뉴 소분류 이름
	 */
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	/**
	 * mb_nameList 접근자
	 * @return mb_nameList : 메뉴 소분류 목록
	 */
	public List<CodeMenuBetaDTO> getMb_nameList() {
		return mb_nameList;
	}
	/**
	 * mb_nameList 설정자
	 * @param mb_nameList : 메뉴 소분류 목록
	 */
	public void setMb_nameList(List<CodeMenuBetaDTO> mb_nameList) {
		this.mb_nameList = mb_nameList;
	}
}