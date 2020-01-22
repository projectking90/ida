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
public class ChartSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String s_id;
	private String chart_cnt;
	private String age;
	
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getChart_cnt() {
		return chart_cnt;
	}
	public void setChart_cnt(String chart_cnt) {
		this.chart_cnt = chart_cnt;
	}
	


}