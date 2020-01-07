/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.ida.dao.IdaDAO;
import system.ida.dto.AddrDTO;

/**
 * IdaServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class IdaServiceImpl implements IdaService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private IdaDAO idaDAO;	// IdaDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 시 목록을 가져옴
	 * @return city_list : 시 목록
	 */
	@Override
	public List<AddrDTO> getCityList() {
		List<AddrDTO> city_list = this.idaDAO.getCityList();
		
		return city_list;
	}

	/**
	 * 군 목록을 가져옴
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return gun_list : 군 목록
	 */
	@Override
	public List<AddrDTO> getGunList(AddrDTO addrDTO) {
		List<AddrDTO> gun_list = this.idaDAO.getGunList(addrDTO);
		
		return gun_list;
	}

	/**
	 * 구 목록을 가져옴
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return gun_list : 구 목록
	 */
	@Override
	public List<AddrDTO> getGuList(AddrDTO addrDTO) {
		List<AddrDTO> gu_list = this.idaDAO.getGuList(addrDTO);
		
		return gu_list;
	}

	/**
	 * 동 목록을 가져옴
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return dong_list : 동 목록
	 */
	@Override
	public List<AddrDTO> getDongList(AddrDTO addrDTO) {
		List<AddrDTO> dong_list = this.idaDAO.getDongList(addrDTO);
		
		return dong_list;
	}
}