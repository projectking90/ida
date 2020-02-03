
/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.CustomerDTO;
import system.ida.dto.CustomerSearchDTO;

/**
 * CustomerDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface CustomerDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.CustomerDAO.";

	/**
	 * 메소드 선언
	 */
	List<CustomerDTO> getCustomerList(CustomerSearchDTO customer_SearchDTO);

	List<Map<String, String>> getGenderData(String s_id);
	
	List<Map<String, String>> getGenderData_M(ChartSearchDTO chart_search_DTO);
	
	List<Map<String, String>> getGenderData_W(ChartSearchDTO chart_search_DTO);

	List<Map<String, String>> getAgeData(String s_id);

	List<Map<String, String>> getMonthData(String s_id);

	List<Map<String, String>> getHourData(String s_id);

	List<Map<String, String>> getQuarterData(String s_id);

	List<Map<String, String>> getWeekData(ChartSearchDTO chart_search_DTO);
}