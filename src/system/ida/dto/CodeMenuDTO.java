/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * MenuDTO 클래스
 * 메뉴를 추가, 수정, 삭제할 때 사용할 DTO
 * @author Jo
 */
public class CodeMenuDTO {
	/**
	 * 속성변수 선언
	 */
	private String ma_code;
	private String ma_name;
	private List<CodeMenuAlphaDTO> ma_nameList;	// 데이터베이스에서 가져온 ma_name 값
	private String mb_code;
	private String mb_name;
	private List<CodeMenuBetaDTO> mb_nameList;	// 데이터베이스에서 가져온 mb_name 값
	public String getMa_code() {
		return ma_code;
	}
	public void setMa_code(String ma_code) {
		this.ma_code = ma_code;
	}
	public String getMa_name() {
		return ma_name;
	}
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}
	public List<CodeMenuAlphaDTO> getMa_nameList() {
		return ma_nameList;
	}
	public void setMa_nameList(List<CodeMenuAlphaDTO> ma_nameList) {
		this.ma_nameList = ma_nameList;
	}
	public String getMb_code() {
		return mb_code;
	}
	public void setMb_code(String mb_code) {
		this.mb_code = mb_code;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public List<CodeMenuBetaDTO> getMb_nameList() {
		return mb_nameList;
	}
	public void setMb_nameList(List<CodeMenuBetaDTO> mb_nameList) {
		this.mb_nameList = mb_nameList;
	}
	

	
	/**
	 * 생성자 선언
	 */
	/**
	 * 접근자, 설정자 선언
	 */

	
}