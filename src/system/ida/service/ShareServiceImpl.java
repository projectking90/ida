/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.ida.dao.ShareDAO;
import system.ida.dao.StockDAO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockInsertDTO;
import system.ida.dto.StockSearchDTO;

/**
 * StockServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class ShareServiceImpl implements ShareService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private ShareDAO shareDAO;	// StockDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */

	@Override
	public List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO){
		List<ShareDTO> different_share_list = this.shareDAO.getDifferentShareList(share_searchDTO);
		return different_share_list;
	}
	
	@Override
	public List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO){
		List<ShareDTO> my_share_list = this.shareDAO.getMyShareList(share_searchDTO);
		return my_share_list;
	}
	
	@Override
	public List<StockDTO> getStockList(ShareSearchDTO share_searchDTO) {
		List<StockDTO> stock_list = this.shareDAO.getStockList(share_searchDTO);
		//System.out.println("service "+share_searchDTO.getS_id());
		return stock_list;
	}
	
	@Override
	public int insertShare(ShareDTO shareDTO) {
		// 이미 등록된 공유 재고 개수 count
		int inserted_share_cnt=this.shareDAO.getInsertedShareCnt(shareDTO); 
		// 이미 같은 상태로 등록된 공유 재고의 개수가 0보다 클 때
		if(inserted_share_cnt>0) {
			return -2;
		}
		// 등록된 재고가 없을 때
		else { 
			int share_reg_cnt=this.shareDAO.insertShare(shareDTO);
			// 추가 
			if(share_reg_cnt>0) {
				// 기록 남기기
				int share_record_insert=this.shareDAO.insertStockRecord(shareDTO);
				if(share_record_insert>0) {
					return 1;	
				}
			}
		}
		return -1;
	}
}