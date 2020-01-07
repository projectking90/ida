/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * IngredientDTO 클래스 식자재 관리 할 때 사용할 DTO
 * 
 * @author Jo
 */
public class IngredientDTO {
	/**
	 * 속성변수 선언
	 */
	private int i_no;	// 식자재 번호
	private int s_no;	// 가게 번호
	private String ia_code;	// 식자재 대분류
	private String ib_code;	// 식자재 소분류
	private String io_code;	// 식자재 원산지
	private String i_name;	// 식자재 이름
	private String i_size;	// 식자재 규격
	private int i_price;	// 식자재 가격
	private String reg_date;	// 식자재 등록일
	private String is_del;	// 삭제여부

	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * i_no 접근자
	 * @return i_no : 식자재 번호
	 */
	public int getI_no() {
		return i_no;
	}
	/**
	 * i_no 설정자
	 * @param i_no : 식자재 번호
	 */
	public void setI_no(int i_no) {
		this.i_no = i_no;
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
	 * ia_code 접근자
	 * @return ia_code : 식자재 대분류
	 */
	public String getIa_code() {
		return ia_code;
	}
	/**
	 * ia_code 설정자
	 * @param ia_code : 식자재 대분류
	 */
	public void setIa_code(String ia_code) {
		this.ia_code = ia_code;
	}
	/**
	 * ib_code 접근자
	 * @return ib_code : 식자재 소분류
	 */
	public String getIb_code() {
		return ib_code;
	}
	/**
	 * ib_code 설정자
	 * @param ib_code : 식자재 소분류
	 */
	public void setIb_code(String ib_code) {
		this.ib_code = ib_code;
	}
	/**
	 * io_code 접근자
	 * @return io_code : 식자재 원산지
	 */
	public String getIo_code() {
		return io_code;
	}
	/**
	 * io_code 설정자
	 * @param io_code : 식자재 원산지
	 */
	public void setIo_code(String io_code) {
		this.io_code = io_code;
	}
	/**
	 * i_name 접근자
	 * @return i_name : 식자재 이름
	 */
	public String getI_name() {
		return i_name;
	}
	/**
	 * i_name 설정자
	 * @param i_name : 식자재 이름
	 */
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	/**
	 * i_size 접근자
	 * @return i_size : 식자재 규격
	 */
	public String getI_size() {
		return i_size;
	}
	/**
	 * i_size 설정자
	 * @param i_size : 식자재 규격
	 */
	public void setI_size(String i_size) {
		this.i_size = i_size;
	}
	/**
	 * i_price 접근자
	 * @return i_price : 식자재 가격
	 */
	public int getI_price() {
		return i_price;
	}
	/**
	 * i_price 설정자
	 * @param i_price : 식자재 가격
	 */
	public void setI_price(int i_price) {
		this.i_price = i_price;
	}
	/**
	 * reg_date 접근자
	 * @return reg_date : 식자재 등록일
	 */
	public String getReg_date() {
		return reg_date;
	}
	/**
	 * reg_date 설정자
	 * @param reg_date : 식자재 등록일
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
}