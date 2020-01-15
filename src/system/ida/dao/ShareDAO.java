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
}