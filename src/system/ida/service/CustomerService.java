/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 */
package system.ida.service;

import java.util.List;

import system.ida.dto.CustomerDTO;
import system.ida.dto.CustomerSearchDTO;
import system.ida.dto.IngredientSearchDTO;

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
 
}
