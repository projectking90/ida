/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * CustomerSearchDTO 클래스
 * 고객 검색 DTO
 * @author Jo
 */
public class CustomerSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String keyword1;	// 키워드
	private String[] date;	// 체크박스
	private int select_page_no=1;	// 페이지
	private int rowCntPerPage=10;	// 행 개수
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * keyword1 접근자
	 * @return keyword1 : 키워드
	 */
	public String getKeyword1() {
		return keyword1;
	}
	/**
	 * keyword1 설정자
	 * @param keyword1 : 키워드
	 */
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	/**
	 * date 접근자
	 * @return date : 체크박스
	 */
	public String[] getDate() {
		return date;
	}
	/**
	 * date 설정자
	 * @param date : 체크박스
	 */
	public void setDate(String[] date) {
		this.date = date;
	}
	/**
	 * select_page_no 접근자
	 * @return select_page_no : 페이지
	 */
	public int getSelect_page_no() {
		return select_page_no;
	}
	/**
	 * select_page_no 설정자
	 * @param select_page_no : 페이지
	 */
	public void setSelect_page_no(int select_page_no) {
		this.select_page_no = select_page_no;
	}
	/**
	 * rowCntPerPage 접근자
	 * @return rowCntPerPage : 행 개수
	 */
	public int getRowCntPerPage() {
		return rowCntPerPage;
	}
	/**
	 * rowCntPerPage 설정자
	 * @param rowCntPerPage : 행 개수
	 */
	public void setRowCntPerPage(int rowCntPerPage) {
		this.rowCntPerPage = rowCntPerPage;
	}
}