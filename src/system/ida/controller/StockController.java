/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockInsertDTO;
import system.ida.service.StockService;

/**
 * IdaController 클래스
 * 컨트롤러 클래스
 * 프로젝트 시작 시 접근 할 경로, 공동으로 접근할 경로를 설정
 * @author Jo
 */
@Controller
public class StockController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Stock/";	// jsp 경로
	@Autowired
	private StockService stockService;	// StockService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */

	/**
	 * 메소드 선언
	 */
	/**
	 * 재고 관리 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_form.ida로 접근하면 호출
	 * @return mav : /stock_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_form.ida")
	public ModelAndView goStockForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "stock_form");
		
		try {
			List<StockDTO> stock_list = this.stockService.getStockList();
			List<IngredientDTO> ingredient_list=this.stockService.getIngredientList();
			mav.addObject("stock_list", stock_list);
			mav.addObject("ingredient_list", ingredient_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goStockForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	@RequestMapping(value="/insert_stock_reg.ida", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertStockReg(
			StockDTO stockDTO) {
		int stock_reg_cnt=0;
		try {
			stock_reg_cnt=this.stockService.insertStock(stockDTO);
			
		}catch(Exception e){
			System.out.println("<insertStockReg 에러발생>");
			System.out.println(e.getMessage());
			stock_reg_cnt=-1;
		}
		return stock_reg_cnt;
	}

	/**
	 * 재고 수정 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_update_form.ida로 접근하면 호출
	 * @return mav : /stock_update_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_update_form.ida")
	public ModelAndView goStockUpdateForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "stock_update_form");
		
		try {
			List<StockDTO> stock_list = this.stockService.getStockList();
			mav.addObject("stock_list", stock_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goStockUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	@RequestMapping(value="/stock_update_proc.ida")
	@ResponseBody
	public int tableUpdateProc(
			@RequestParam(value="trArr") ArrayList<String> stock_update
	) 
	{
		int stock_update_cnt = 0;
		
		try {				 
			stock_update_cnt = this.stockService.updateStock(stock_update);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return stock_update_cnt;
	}

	/**
	 * 재고 삭제 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_delete_form.ida로 접근하면 호출
	 * @return mav : /stock_delete_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_delete_form.ida")
	public ModelAndView goStockDeleteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "stock_delete_form");
		
		try {
			List<StockDTO> stock_list = this.stockService.getStockList();
			mav.addObject("stock_list", stock_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goStockDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="/stock_delete_proc.ida")
	@ResponseBody
	public int stockdeleteProc(
			@RequestParam(value="trArr") ArrayList<String> stock_delete
	) 
	{
		int stock_update_cnt = 0;
		for(int index=0; index<stock_delete.size(); index++) {
			System.out.println(stock_delete.get(index));
		}
		try {				 
			stock_update_cnt = this.stockService.deleteStock(stock_delete);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return stock_update_cnt;
	}
}