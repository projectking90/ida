package system.ida.dao;

import java.util.List;

import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;

public interface ShareDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.ShareDAO.";	// mapper의 namespace

	/**
	 * 메소드 선언
	 */
	List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO);	// 타 지점 공유 현황 목록을 가져옴
	List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO);	// 내 지점 공유 현황 목록을 가져옴
	List<StockDTO> getStockList(ShareSearchDTO share_searchDTO);	// 공유 재고 추가할 때 필요한 재고 목록을 가져옴
	int insertShare(ShareDTO shareDTO);	// 공유 재고 추가 처리함
	int getInsertedShareCnt(ShareDTO shareDTO);	// 이미 등록된 공유 재고 개수를 가져옴
	int insertStockRecord(ShareDTO shareDTO);	// 재고 기록 테이블에 추가 기록 처리함
	ShareDTO getShareDTO(int si_no);	// 공유 정보를 가져옴
	int updateShare(ShareDTO shareDTO);	// 내 지점 공유 재고 수정 처리함
	int getMyShareCnt(ShareDTO shareDTO);	// 수정할 공유 재고 개수를 가져옴
	int deleteShare(ShareDTO shareDTO);	// 내 지점 공유 재고 삭제 처리함
	int requestShare(ShareDTO shareDTO);	// 타 지점의 공유 재고 요청 처리함
	int deleteStockRecord(ShareDTO shareDTO);	// 재고 기록 테이블에 삭제 기록 처리함
	int requestStockRecord(ShareDTO shareDTO);	// 재고 기록 테이블에 요청 기록 처리함
	int requestStockRecorded(ShareDTO shareDTO);	// 같은 공유를 요청을 개수를 가져옴
	List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO); // 내 매장 공유 재고 요청 현황 목록을 가져옴
	List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO); // 타 매장 공유 재고 요청 현황 목록을 가져옴
}