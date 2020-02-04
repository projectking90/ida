package system.ida.dto;

/**
 * StockInsertDTO 클래스
 * 재고 추가할 정보를 담은 DTO
 * @author Jo
 */
public class StockInsertDTO {
	/**
	 * 속성변수 선언
	 */
	private int st_no;	// 재고 번호
	private int i_no;	// 식자재 번호
	private int quantity;	// 수량
	private String st_state;	// 재고 상태
	
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
}