/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.CustomerDTO;
import system.ida.dto.CustomerSearchDTO;

/**
 * CustomerDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 고객 정보를 가져옴
	 * @param customer_SearchDTO : 고객 검색 DTO
	 * @return customer_list : 고객 정보 리스트
	 */
	@Override
	public List<CustomerDTO> getCustomerList(CustomerSearchDTO customer_searchDTO) {
		List<CustomerDTO> customer_list = this.sqlSession.selectList(
				sqlSessionPath + "getCustomerList"
				, customer_searchDTO);
		
		return customer_list;
	}
	
	/**
	 * 성별 고객 차트 데이터를 가져옴
	 * @param s_id : 아이디
	 * @return customer_gender_chart : 성별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getGenderData(String s_id) {
		List<Map<String, String>> customer_gender_chart = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData"
				, s_id);
		
		return customer_gender_chart;
	}

	/**
	 * 남자별 고객 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return customer_gerder_chart_m : 남자별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getGenderData_M(ChartSearchDTO chart_search_DTO) {
		List<Map<String, String>> customer_gerder_chart_m = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData_M"
				, chart_search_DTO);
		
		return customer_gerder_chart_m;
	}

	/**
	 * 여자별 고객 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return customer_gerder_chart_w : 여자별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getGenderData_W(ChartSearchDTO chart_search_DTO) {
		List<Map<String, String>> customer_gerder_chart_w = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData_W"
				, chart_search_DTO);
		
		return customer_gerder_chart_w;
	}
	
	/**
	 * 나이별 고객 차트 데이터를 가져옴
	 * @param s_id : 아이디
	 * @return customer_age_chart : 나이별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getAgeData(String s_id) {
		List<Map<String, String>> customer_age_chart = this.sqlSession.selectList(
				sqlSessionPath + "getAgeData"
				, s_id);
		
		return customer_age_chart;
	}

	/**
	 * 월별 고객 차트 데이터를 가져옴
	 * @param s_id : 아이디
	 * @return customer_month_chart : 월별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthData(String s_id) {
		List<Map<String, String>> customer_month_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMonthData"
				, s_id);
		
		return customer_month_chart;
	}

	/**
	 * 시간별 고객 차트 데이터를 가져옴
	 * @param s_id : 아이디
	 * @return customer_hour_chart : 시간별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getHourData(String s_id) {
		List<Map<String, String>> customer_hour_chart = this.sqlSession.selectList(
				sqlSessionPath + "getHourData"
				, s_id);
		
		return customer_hour_chart;
	}

	/**
	 * 분기별 고객 차트 데이터를 가져옴
	 * @param s_id : 아이디
	 * @return customer_quarter_chart : 분기별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getQuarterData(String s_id) {
		List<Map<String, String>> customer_quarter_chart = this.sqlSession.selectList(
				sqlSessionPath + "getQuarterData"
				, s_id);
		
		return customer_quarter_chart;
	}

	/**
	 * 주별 고객 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return customer_week_chart : 주별 고객 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekData(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> customer_week_chart = this.sqlSession.selectList(
				sqlSessionPath + "getWeekData"
				, chart_search_DTO);
		
		return customer_week_chart;
	}
}