/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.List;

import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;

/**
 * StockService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface ShareService {
	/**
	 * 속성변수 선언
	 */

	/**
	 * 메소드 선언
	 */
	List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO);	// 타 지점 공유 현황 리스트
	List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO);	// 내 지점 공유 현황 리스트
	List<StockDTO> getStockList(ShareSearchDTO share_searchDTO);	// 공유 재고 추가할 때 필요한 재고 리스트
	int insertShare(ShareDTO shareDTO);	// 공유 재고 추가 메소드
	ShareDTO getShareDTO(int si_no); // 상세보기 메소드
	int updateShare(ShareDTO shareDTO); // 내 지점 공유 재고 수정하는 메소드
	int deleteShare(ShareDTO shareDTO); // 내 지점 공유 재고 삭제하는 메소드
	int requestShare(ShareDTO shareDTO); // 타 지점의 공유 재고 요청하는 메소드
	List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO); // 내 매장 공유 재고 요청 현황 리스트
	List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO); // 타 매장 공유 재고 요청 현황 리스트
}