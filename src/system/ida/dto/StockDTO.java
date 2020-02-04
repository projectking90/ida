package system.ida.dto;

/**
 * StockDTO 클래스
 * 재고 정보를 담을 DTO
 * @author Jo
 */
public class StockDTO {
	/**
	 * 속성변수 선언
	 */
	private int st_no;	// 재고 번호
	private int i_no;	// 식자재 번호
	private String ia_name;	// 식자재 대분류 이름
	private String ib_name;	// 식자재 소분류 이름
	private String io_name;	// 식자재 원산지 이름
	private String i_name;	// 식자재 이름
	private String i_size;	// 규격
	private int quantity;	// 수량
	private String st_state;	// 재고 상태
	private String reg_date;	// 등록일
	private String i_price;	// 가격
	private String s_id;	// 아이디
	
	/**
	 * 메소드 선언
	 */
	/**
	 * st_no 접근자
	 * @return st_no : 재고 번호
	 */
	public int getSt_no() {
		return st_no;
	}
	/**
	 * st_no 설정자
	 * @param st_no : 재고 번호
	 */
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
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
	 * ia_name 접근자
	 * @return ia_name : 식자재 대분류 이름
	 */
	public String getIa_name() {
		return ia_name;
	}
	/**
	 * ia_name 설정자
	 * @param ia_name : 식자재 대분류 이름
	 */
	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}
	/**
	 * ib_name 접근자
	 * @return ib_name : 식자재 소분류 이름
	 */
	public String getIb_name() {
		return ib_name;
	}
	/**
	 * ib_name 설정자
	 * @param ib_name : 식자재 소분류 이름
	 */
	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}
	/**
	 * io_name 접근자
	 * @return io_name : 식자재 원산지 이름
	 */
	public String getIo_name() {
		return io_name;
	}
	/**
	 * io_name 설정자
	 * @param io_name : 식자재 원산지 이름
	 */
	public void setIo_name(String io_name) {
		this.io_name = io_name;
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
	 * @return i_size : 규격
	 */
	public String getI_size() {
		return i_size;
	}
	/**
	 * i_size 설정자
	 * @param i_size : 규격
	 */
	public void setI_size(String i_size) {
		this.i_size = i_size;
	}
	/**
	 * quantity 접근자
	 * @return quantity : 수량
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * quantity 설정자
	 * @param quantity : 수량
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * st_state 접근자
	 * @return st_state : 재고 상태
	 */
	public String getSt_state() {
		return st_state;
	}
	/**
	 * st_state 설정자
	 * @param st_state : 재고 상태
	 */
	public void setSt_state(String st_state) {
		this.st_state = st_state;
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
	 * i_price 접근자
	 * @return i_price : 가격
	 */
	public String getI_price() {
		return i_price;
	}
	/**
	 * i_price 설정자
	 * @param i_price : 가격
	 */
	public void setI_price(String i_price) {
		this.i_price = i_price;
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
}