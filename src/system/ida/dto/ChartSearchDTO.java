/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * ChartSearchDTO 클래스
 * 차트 검색할 때 사용할 DTO
 * @author Jo
 */
public class ChartSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String s_id;	// 아이디
	private String chart_cnt;	// 검색 갯수
	private String age;	// 나이
	private String week;	// 주
	private String month;	// 월
	private String year;	// 년
	private String quarter;	// 분기
	
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
	/**
	 * chart_cnt 접근자
	 * @return chart_cnt : 검색 갯수
	 */
	public String getChart_cnt() {
		return chart_cnt;
	}
	/**
	 * chart_cnt 설정자
	 * @param chart_cnt : 검색 갯수
	 */
	public void setChart_cnt(String chart_cnt) {
		this.chart_cnt = chart_cnt;
	}
	/**
	 * age 접근자
	 * @return age : 나이
	 */
	public String getAge() {
		return age;
	}
	/**
	 * age 설정자
	 * @param age : 나이
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * week 접근자
	 * @return week : 주
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * week 설정자
	 * @param week : 주
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * month 접근자
	 * @return month : 월
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * month 설정자
	 * @param month : 월
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * year 접근자
	 * @return year : 년
	 */
	public String getYear() {
		return year;
	}
	/**
	 * year 설정자
	 * @param year : 년
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * quarter 접근자
	 * @return quarter : 분기
	 */
	public String getQuarter() {
		return quarter;
	}
	/**
	 * quarter 설정자
	 * @param quarter : 분기
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
}