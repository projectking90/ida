/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 */
package system.ida.service;

import java.util.List;
import java.util.Map;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.CustomerDTO;
import system.ida.dto.CustomerSearchDTO;

/**
 * CustomerService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface CustomerService {
	/**
	 * 속성변수 선언
	 */

	/**
	 * 메소드 선언
	 */
	List<CustomerDTO> getCustomerList(CustomerSearchDTO Customer_SearchDTO);	// 식자재 리스트를 가져옴


	List<Map<String, String>> getGenderData(String s_id);

	List<Map<String, String>> getAgeData(String s_id);

	List<Map<String, String>> getMonthData(String s_id);

	List<Map<String, String>> getHourData(String s_id);

	List<Map<String, String>> getQuarterData(String s_id);

	List<Map<String, String>> getWeekData(ChartSearchDTO chart_search_DTO);

	List<Map<String, String>> getGenderData_M(ChartSearchDTO chart_search_DTO);

	List<Map<String, String>> getGenderData_W(ChartSearchDTO chart_search_DTO);
}
