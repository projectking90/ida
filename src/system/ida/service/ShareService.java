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
 * ShareService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface ShareService {
	/**
	 * 메소드 선언
	 */
	List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO);	// 타 지점 공유 현황 목록을 가져옴
	List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO);	// 내 지점 공유 현황 목록을 가져옴
	List<StockDTO> getStockList(ShareSearchDTO share_searchDTO);	// 공유 재고 추가할 때 필요한 재고 목록을 가져옴
	int insertShare(ShareDTO shareDTO);	// 공유 재고 추가 처리함
	ShareDTO getShareDTO(int si_no);	// 공유 정보를 가져옴
	int updateShare(ShareDTO shareDTO);	// 내 지점 공유 재고 수정 처리함
	int deleteShare(ShareDTO shareDTO);	// 내 지점 공유 재고 삭제 처리함
	int requestShare(ShareDTO shareDTO);	// 타 지점의 공유 재고 요청 처리함
	List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO);	// 내 매장 공유 재고 요청 현황 목록을 가져옴
	List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO);	// 타 매장 공유 재고 요청 현황 목록을 가져옴
	ShareDTO getShareRequestDTO(ShareDTO shareDTO);	// 내 매장 공유 재고 요청 현황 상세보기를 가져옴
	int approveShare(ShareDTO shareDTO);	// 요청에 대해 수락 처리함
	List<ShareDTO> getMyShareApproveList(ShareSearchDTO share_searchDTO);	// 내 매장 공유 재고 승인 현황 목록을 가져옴
	List<ShareDTO> getDifferentShareApproveList(ShareSearchDTO share_searchDTO);	// 타 매장 공유 재고 승인 현황 목록을 가져옴
}