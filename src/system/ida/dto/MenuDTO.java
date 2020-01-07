/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * MenuSearchDTO 클래스
 * 메뉴 검색할 때 사용할 DTO
 * @author Jo
 */
public class MenuDTO {
	/**
	 * 속성변수 선언
	 */
	private int mi_no;
	private String ma_code;
	private String mb_code;
	private int s_no;
	private String s_id;
	private String mi_name;
	private int price;
	private String mi_comment;
	private String reg_date;
	private String is_del;

	
	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */
	public int getMi_no() {
		return mi_no;
	}

	public void setMi_no(int mi_no) {
		this.mi_no = mi_no;
	}

	public String getMa_code() {
		return ma_code;
	}

	public void setMa_code(String ma_code) {
		this.ma_code = ma_code;
	}

	public String getMb_code() {
		return mb_code;
	}

	public void setMb_code(String mb_code) {
		this.mb_code = mb_code;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getMi_name() {
		return mi_name;
	}

	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMi_comment() {
		return mi_comment;
	}

	public void setMi_comment(String mi_comment) {
		this.mi_comment = mi_comment;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	/**
	 * s_id 접근자
	 * @return s_id : 
	 */
	public String getS_id() {
		return s_id;
	}
	/**
	 * s_id 설정자
	 * @param s_id : 
	 */
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
}