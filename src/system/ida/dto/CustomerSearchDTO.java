/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * CustomerDTO 클래스
 * 고객관리 할 때  사용할 DTO
 * @author Jo
 */
public class CustomerSearchDTO {
	/**
	 * 속성변수 선언
	 */
	
	
	private String keyword1;
	private String[] date;
	private int select_page_no=1;
	private int rowCntPerPage=10;
	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */

	public String getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public int getSelect_page_no() {
		return select_page_no;
	}
	public void setSelect_page_no(int select_page_no) {
		this.select_page_no = select_page_no;
	}
	public int getRowCntPerPage() {
		return rowCntPerPage;
	}
	public void setRowCntPerPage(int rowCntPerPage) {
		this.rowCntPerPage = rowCntPerPage;
	}
}