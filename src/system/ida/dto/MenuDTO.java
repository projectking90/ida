/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * MenuDTO 클래스
 * 메뉴 정보를 담을 DTO
 * @author Jo
 */
public class MenuDTO {
	/**
	 * 속성변수 선언
	 */
	private int mi_no;	// 메뉴 번호
	private String ma_code;	// 메뉴 대분류 코드
	private String mb_code;	// 메뉴 소분류 코드
	private int s_no;	// 가게 번호
	private String s_id;	// 아이디
	private String mi_name;	// 메뉴 이름
	private String price;	// 가격
	private String mi_comment;	// 설명
	private String reg_date;	// 등록일
	private String is_del;	// 삭제여부
	private String[] i_name;	// 식자재 이름
	private List<MenuDTO> mi_nameList;	// 메뉴 이름 목록

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * mi_no 접근자
	 * @return mi_no : 메뉴 번호
	 */
	public int getMi_no() {
		return mi_no;
	}
	/**
	 * mi_no 설정자
	 * @param mi_no : 메뉴 번호
	 */
	public void setMi_no(int mi_no) {
		this.mi_no = mi_no;
	}
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
	 * s_no 접근자
	 * @return s_no : 가게 번호
	 */
	public int getS_no() {
		return s_no;
	}
	/**
	 * s_no 설정자
	 * @param s_no : 가게 번호
	 */
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	/**
	 * s_id 접근자
	 * @return s_id : 아이디
	 */
	public String getS_id() {
		return s_id;
	}
	/**
	 * s_id 설정자
	 * @param s_id : 아이디
	 */
	public void setS_id(String s_id) {
		this.s_id = s_id;
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
	 * price 접근자
	 * @return price : 가격
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * price 설정자
	 * @param price : 가격
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * mi_comment 접근자
	 * @return mi_comment : 설명
	 */
	public String getMi_comment() {
		return mi_comment;
	}
	/**
	 * mi_comment 설정자
	 * @param mi_comment : 설명
	 */
	public void setMi_comment(String mi_comment) {
		this.mi_comment = mi_comment;
	}
	/**
	 * reg_date 접근자
	 * @return reg_date : 등록일
	 */
	public String getReg_date() {
		return reg_date;
	}
	/**
	 * reg_date 설정자
	 * @param reg_date : 등록일
	 */
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	/**
	 * is_del 접근자
	 * @return is_del : 삭제여부
	 */
	public String getIs_del() {
		return is_del;
	}
	/**
	 * is_del 설정자
	 * @param is_del : 삭제여부
	 */
	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}
	/**
	 * i_name 접근자
	 * @return i_name : 식자재 이름
	 */
	public String[] getI_name() {
		return i_name;
	}
	/**
	 * i_name 설정자
	 * @param i_name : 식자재 이름
	 */
	public void setI_name(String[] i_name) {
		this.i_name = i_name;
	}
	/**
	 * mi_nameList 접근자
	 * @return mi_nameList : 메뉴 이름 목록
	 */
	public List<MenuDTO> getMi_nameList() {
		return mi_nameList;
	}
	/**
	 * mi_nameList 설정자
	 * @param mi_nameList : 메뉴 이름 목록
	 */
	public void setMi_nameList(List<MenuDTO> mi_nameList) {
		this.mi_nameList = mi_nameList;
	}
}