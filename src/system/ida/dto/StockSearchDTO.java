package system.ida.dto;

/**
 * StockSearchDTO 클래스
 * 재고 검색 DTO
 * @author Jo
 */
public class StockSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String s_id;	// 아이디

	/**
	 * 메소드 선언
	 */
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