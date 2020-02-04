package system.ida.dao;

import java.util.List;

import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;

public interface ShareDAO {

	String sqlSessionPath = "system.ida.dao.ShareDAO.";
	
	List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO);	// 타 지점 공유 현황 리스트
	List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO);	// 내 지점 공유 현황 리스트
	List<StockDTO> getStockList(ShareSearchDTO share_searchDTO);	// 공유 재고 추가할 때 필요한 재고 리스트
	int insertShare(ShareDTO shareDTO);	// 공유 재고 추가 메소드
	int getInsertedShareCnt(ShareDTO shareDTO);	// 이미 등록된 공유 재고 개수 count
	int insertStockRecord(ShareDTO shareDTO);	// 추가할 때 record 테이블에 기록 남기기
	int getDeletedShareCnt(ShareDTO shareDTO); // 이미 등록되었으나 삭제된 공유 재고 개수 count
	int changeInsertedShareIsDel(ShareDTO shareDTO); // is_del='T'를 'F'로 변경하는 메소드 
	ShareDTO getShareDTO(int si_no); // 상세보기
	int updateShare(ShareDTO shareDTO); // 내 지점 공유 재고 수정하는 메소드
	int getMyShareCnt(ShareDTO shareDTO); // 수정할 공유 재고 개수 count
	int deleteShare(ShareDTO shareDTO); // 내 지점 공유 재고 삭제하는 메소드
	int requestShare(ShareDTO shareDTO); // 타 지점의 공유 재고 요청하는 메소드
	int deleteStockRecord(ShareDTO shareDTO); // 삭제할 때 record 테이블에 기록 남기기
	int requestStockRecord(ShareDTO shareDTO); // 요청할 때 record 테이블에 기록 남기기
	int requestStockRecorded(ShareDTO shareDTO); // 같은 요청을 한 record 테이블의 기록 개수 count
	List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO); // 내 매장 공유 재고 요청 현황 리스트
	List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO); // 타 매장 공유 재고 요청 현황 리스트
	ShareDTO getShareRequestDTO(ShareDTO shareDTO); // 내 매장 공유 재고 요청 현황 상세보기 메소드
	int approveShare(ShareDTO shareDTO); // 수락할 때 update하는 메소드
	int approveShareRecord(ShareDTO shareDTO); // 수락할 때 record 테이블에 기록 남기기
	int approveShareCount(ShareDTO shareDTO); // 수락한 공유 재고 count 
	int shareDeletedCount(ShareDTO shareDTO); // 삭제된 공유 재고 count
	List<ShareDTO> getMyShareApproveList(ShareSearchDTO share_searchDTO); // 내 매장 공유 재고 승인 현황 리스트
	List<ShareDTO> getDifferentShareApproveList(ShareSearchDTO share_searchDTO); // 타 매장 공유 재고 승인 현황 리스트
}