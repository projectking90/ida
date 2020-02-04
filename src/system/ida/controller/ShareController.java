package system.ida.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.ChartDTO;
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;
import system.ida.service.ShareService;

@Controller
public class ShareController {

	/**
	 * 속성변수 선언
	 */
	private final String path = "Share/";	// jsp 경로
	@Autowired
	private ShareService shareService;	// shareService 인터페이스를 구현받은 객체를 생성해서 저장
	
	@RequestMapping(value="/share_form.ida")
	public ModelAndView goShareForm(
			ShareSearchDTO share_searchDTO,
			HttpSession session
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_form");
		String s_id = (String)session.getAttribute("s_id");
		try {
			share_searchDTO.setS_id(s_id);
			List<ShareDTO> my_share_list=this.shareService.getMyShareList(share_searchDTO);
			List<ShareDTO> different_share_list = this.shareService.getDifferentShareList(share_searchDTO);
			List<StockDTO> stock_list = this.shareService.getStockList(share_searchDTO);
			mav.addObject("my_share_list", my_share_list);
			mav.addObject("different_share_list", different_share_list);
			mav.addObject("stock_list", stock_list);
		}catch(Exception e) {
			System.out.println("<goShareForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/insert_share_reg.ida"
			, method = RequestMethod.POST
			, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertStockReg(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_reg_cnt=0;
		String s_id = (String)session.getAttribute("s_id");
		try {
			shareDTO.setS_id(s_id);
			share_reg_cnt=this.shareService.insertShare(shareDTO);
		}catch(Exception e){
			System.out.println("<insertStockReg 에러발생>");
			System.out.println(e.getMessage());
		}
		return share_reg_cnt;
	}
	@RequestMapping(value="/different_share_content_form.ida")
	public ModelAndView different_share_content_form(
			@RequestParam(value="si_no") int si_no
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "different_share_content_form");
		try {
			session.setAttribute("uri", "different_share_content_form.ida");
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<different_share_content_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}	
	
	@RequestMapping(value="/my_share_content_form.ida")
	public ModelAndView my_share_content_form(
			@RequestParam(value="si_no") int si_no
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "my_share_content_form");
		try {
			session.setAttribute("uri", "my_share_content_form.ida");
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<my_share_content_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/my_share_update_form.ida")
	public ModelAndView my_share_update_form(
			@RequestParam(value="si_no") int si_no
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "my_share_update_form");
		try {
			session.setAttribute("uri", "my_share_update_form.ida");
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<my_share_update_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/my_share_update_proc.ida")
	@ResponseBody
	public int my_share_update(
			ShareDTO shareDTO
	) {
		int share_update_cnt = 0;
		try {				 
			share_update_cnt = this.shareService.updateShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_update_cnt;
	}
	
	
	@RequestMapping(value="/my_share_delete_proc.ida")
	@ResponseBody
	public int my_share_delete(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_delete_cnt = 0;
		String s_id = (String)session.getAttribute("s_id");
		try {				 
			shareDTO.setS_id(s_id);
			share_delete_cnt = this.shareService.deleteShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_delete_cnt;
	}
	
	@RequestMapping(value="/request_share.ida")
	@ResponseBody
	public int request_share(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_request_cnt = 0;
		String s_id = (String)session.getAttribute("s_id");
		try {				 
			shareDTO.setS_id(s_id);	 
			share_request_cnt = this.shareService.requestShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_request_cnt;
	}
	
	
	@RequestMapping(value="/share_request_form.ida")
	public ModelAndView goShareRequestForm(
			ShareSearchDTO share_searchDTO,
			HttpSession session
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_request_form");
		String s_id = (String)session.getAttribute("s_id");
		try {
			share_searchDTO.setS_id(s_id);
			System.out.println(share_searchDTO.getS_id());
			List<ShareDTO> my_share_request_list=this.shareService.getMyShareRequestList(share_searchDTO);
			List<ShareDTO> different_share_request_list = this.shareService.getDifferentShareRequestList(share_searchDTO);

			mav.addObject("my_share_request_list", my_share_request_list);
			mav.addObject("different_share_request_list", different_share_request_list);
		}catch(Exception e) {
			System.out.println("<goShareRequestForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	@RequestMapping(value="/share_approve_form.ida")
	public ModelAndView goShareApproveForm(
			ShareSearchDTO share_searchDTO,
			HttpSession session
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_approve_form");
		String s_id = (String)session.getAttribute("s_id");
		try {
			share_searchDTO.setS_id(s_id);
			//System.out.println(share_searchDTO.getS_id());
			List<ShareDTO> my_share_approve_list=this.shareService.getMyShareApproveList(share_searchDTO);
			List<ShareDTO> different_share_approve_list = this.shareService.getDifferentShareApproveList(share_searchDTO);

			mav.addObject("my_share_approve_list", my_share_approve_list);
			mav.addObject("different_share_approve_list", different_share_approve_list);
		}catch(Exception e) {
			System.out.println("<goShareApproveForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	// 내 매장 공유 재고 요청 현황 상세보기 
	@RequestMapping(value="/share_request_content_form.ida")
	public ModelAndView share_request_content_form(
			@RequestParam(value="si_no") int si_no
			,@RequestParam(value="s_no") int s_no
			,ShareDTO shareDTO
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "share_request_content_form");
		try {
			session.setAttribute("uri", "share_request_content_form.ida");
			shareDTO.setSi_no(si_no);
			shareDTO.setS_no(s_no);
			shareDTO = this.shareService.getShareRequestDTO(shareDTO);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<share_request_content_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	// 내 매장 공유 재고 요청한 것 수락하기
	@RequestMapping(value="/approve_share_reg.ida")
	@ResponseBody
	public int approve_share_reg(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_approve_cnt = 0;
		String s_id = (String)session.getAttribute("s_id");
		try {				 
			shareDTO.setS_id(s_id);
			share_approve_cnt = this.shareService.approveShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_approve_cnt;
	}
	
	/**
	 * 발주 분석 화면을 보여줄 jsp와 가게가 신청한 발주를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /share_analysis_form.ida로 접근하면 호출
	 * @return mav : /share_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 발주 리스트
	 */
	@RequestMapping(value="/share_analysis_form.ida")
	public ModelAndView goShareAnalysisForm(
		HttpSession session,
		ChartSearchDTO chart_searchDTO
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_analysis_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
			chart_searchDTO.setS_id(s_id);
			List<ShareDTO> share_anl_list = this.shareService.getShareAnlList(chart_searchDTO);
			mav.addObject("share_anl_list",share_anl_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goShareAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 발주 분석 - 차트화면을 보여줄 jsp와 가게가 신청한 발주를 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /share_analysis_chart_form.ida로 접근하면 호출
	 * @return mav : /share_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 발주 차트
	 */
	@RequestMapping(value="/share_analysis_chart_form.ida")
	public ModelAndView goShareAnalysisChartForm(
		HttpSession session,
		ChartSearchDTO chart_searchDTO
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_analysis_chart_form");
		try {
			String s_id =(String)session.getAttribute("s_id");
			chart_searchDTO.setS_id(s_id);
			List<ShareDTO> share_anl_list = this.shareService.getShareAnlList(chart_searchDTO);
			mav.addObject("share_anl_list",share_anl_list);

		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goShareAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	@RequestMapping(value="/share_analysis_chart.ida")
	@ResponseBody 
	public ChartDTO goShareAnalysisChartData(
			ChartSearchDTO chart_searchDTO
			, HttpSession session
			, @RequestParam(value="chart_search") String chart_search
			, @RequestParam(value="chart_cnt") String chart_cnt
			, @RequestParam(value="week", required=false) String week
			, @RequestParam(value="month") String month
			, @RequestParam(value="year") String year
			, @RequestParam(value="quarter", required=false) String quarter
	) 
	{
		ChartDTO chart_data = new ChartDTO();	// 데이터베이스에 Query 실행 후 결과를 저장

		try {
			String s_id = (String)session.getAttribute("s_id");
			chart_searchDTO.setS_id(s_id);
			chart_searchDTO.setChart_cnt(chart_cnt);
			
			List<String> label = new ArrayList<String>();
			List<String> data1=new ArrayList<String>();
			List<String> dataset = new ArrayList<String>();
			List<String> label2 = new ArrayList<String>();
			List<String> data2=new ArrayList<String>();
			
			if(chart_search.equals("주")) {
				chart_searchDTO.setWeek(week);
				List<Map<String, String>> week_share_input_chart = this.shareService.getWeekShareInputData(chart_searchDTO);

				List<Map<String, String>> week_share_output_chart = this.shareService.getWeekShareOutputData(chart_searchDTO);
				
				// 주 input 
				for(int i=0; i<week_share_input_chart.size(); i++) {
					if(week_share_input_chart.get(i).get("LABEL")==null) {
						System.out.println(111);
					}
					label.add(week_share_input_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<week_share_input_chart.size(); i++) {
					data1.add(week_share_input_chart.get(i).get("DATA"));
				}
				dataset.add(week_share_input_chart.get(0).get("DATASET"));
				
				// 주 output 
				for(int i=0; i<week_share_output_chart.size(); i++) {
					label2.add(week_share_output_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<week_share_output_chart.size(); i++) {
					data2.add(week_share_output_chart.get(i).get("DATA"));
				}
				
			} else if(chart_search.equals("월")) {
				chart_searchDTO.setMonth(month);
				chart_searchDTO.setYear(year);
				List<Map<String, String>> month_share_input_chart = this.shareService.getMonthShareInputData(chart_searchDTO);

				List<Map<String, String>> month_share_output_chart = this.shareService.getMonthShareOutputData(chart_searchDTO);
				
				// 월 input 
				for(int i=0; i<month_share_input_chart.size(); i++) {
					label.add(month_share_input_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<month_share_input_chart.size(); i++) {
					data1.add(month_share_input_chart.get(i).get("DATA"));
				}
				dataset.add(month_share_input_chart.get(0).get("DATASET"));
				
				// 월 output 
				for(int i=0; i<month_share_output_chart.size(); i++) {
					label2.add(month_share_output_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<month_share_output_chart.size(); i++) {
					data2.add(month_share_output_chart.get(i).get("DATA"));
				}
				
				
			} else if (chart_search.equals("시간")) {
				List<Map<String, String>> time_share_input_chart = this.shareService.getTimeShareInputData(chart_searchDTO);
				List<Map<String, String>> time_share_output_chart = this.shareService.getTimeShareOutputData(chart_searchDTO);
			
				for(int i=0; i<time_share_input_chart.size(); i++) {
					label.add(time_share_input_chart.get(i).get("LABEL"));
				}
				
				for(int i=0; i<time_share_input_chart.size(); i++) {
					data1.add(time_share_input_chart.get(i).get("DATA"));
				}
				
				for(int i=0; i<time_share_output_chart.size(); i++) {
					label2.add(time_share_output_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<time_share_output_chart.size(); i++) {
					data2.add(time_share_output_chart.get(i).get("DATA"));
				}
				
			} else if (chart_search.equals("분기")) {
				chart_searchDTO.setQuarter(quarter);	
				// Input Pie Chart
				List<Map<String, String>> all_quarter_share_input_chart = this.shareService.getAllQuarterShareInputData(chart_searchDTO);
				
				for(int i=0; i<all_quarter_share_input_chart.size(); i++) {
					label.add(all_quarter_share_input_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<all_quarter_share_input_chart.size(); i++) {
					data1.add(all_quarter_share_input_chart.get(i).get("DATA"));
				}
				
				//Output Pie Chart
				List<Map<String, String>> all_quarter_share_output_chart = this.shareService.getAllQuarterShareOutputData(chart_searchDTO);
				
				for(int i=0; i<all_quarter_share_output_chart.size(); i++) {
					label2.add(all_quarter_share_output_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<all_quarter_share_output_chart.size(); i++) {
					data2.add(all_quarter_share_output_chart.get(i).get("DATA"));
				}
				

				List<String> label3 = new ArrayList<String>();
				List<String> data3 =new ArrayList<String>();
				List<String> label4 = new ArrayList<String>();
				List<String> data4 =new ArrayList<String>();
				

				// Bar Chart
				List<Map<String, String>> quarter_share_input_chart = this.shareService.getQuarterShareInputData(chart_searchDTO);
				List<Map<String, String>> quarter_share_output_chart = this.shareService.getQuarterShareOutputData(chart_searchDTO);
				
				for(int i=0; i<quarter_share_input_chart.size(); i++) {
					label3.add(quarter_share_input_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<quarter_share_input_chart.size(); i++) {
					data3.add(quarter_share_input_chart.get(i).get("DATA"));
				}
				
				System.out.println("quarter_share_output_chart "+quarter_share_output_chart);
				for(int i=0; i<quarter_share_output_chart.size(); i++) {
					label4.add(quarter_share_output_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<quarter_share_output_chart.size(); i++) {
					data4.add(quarter_share_output_chart.get(i).get("DATA"));
				}
				List<String> dataset2 = new ArrayList<String>();
				dataset2.add(quarter_share_input_chart.get(0).get("DATASET"));

				chart_data.setDataset2(dataset2);
				chart_data.setLabel3(label3);
				chart_data.setData3(data3);
				chart_data.setLabel4(label4);
				chart_data.setData4(data4);
			}
			chart_data.setDataset(dataset);
			chart_data.setLabel(label);
			chart_data.setData1(data1);
			chart_data.setLabel2(label2);
			chart_data.setData2(data2);
		}
		catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goShareAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return chart_data;
	}
	
	
}