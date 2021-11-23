package page;



public class PageManager {

	private int requestPage;

	public PageManager() {}
	
	public PageManager(int requestPage) {
		super();
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PRE_PAGE*requestPage);
		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PRE_PAGE*(requestPage-1)+1);
		
		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		int reqPageGroupNumber = (int) Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);
		pageGroupResult.setGroupStartNumber(reqPageGroupNumber*PageInfo.SHOW_PAGE_COUNT-(PageInfo.SHOW_PAGE_COUNT-1));
		pageGroupResult.setGroupEndNumber(reqPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
		
		
		int totalPageNumber = (int) Math.ceil((double)(cnt/PageInfo.ROW_COUNT_PRE_PAGE+1));
		
		if(pageGroupResult.getGroupEndNumber()>totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);	
		}
		
		
		if(pageGroupResult.getGroupStartNumber()==1) {
			pageGroupResult.setBeforePage(false);
			
		}else if(pageGroupResult.getGroupEndNumber()==totalPageNumber) {
			pageGroupResult.setAfterPage(false);
			
		}
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
		return pageGroupResult;
	}
	
	public PageRowResult getLecturePageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		pageRowResult.setRowEndNumber(PageInfo.LECTURE_ROW_COUNT_PRE_PAGE*requestPage);
		pageRowResult.setRowStartNumber(PageInfo.LECTURE_ROW_COUNT_PRE_PAGE*(requestPage-1)+1);
		// row 4
		return pageRowResult;
	}
	
	public PageGroupResult getLecturePageGroupResult(int cnt) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		int reqPageGroupNumber = (int) Math.ceil((double)requestPage/PageInfo.LECTURE_SHOW_PAGE_COUNT); // 0.5--1
		// show 2
		pageGroupResult.setGroupStartNumber(reqPageGroupNumber*PageInfo.LECTURE_SHOW_PAGE_COUNT-(PageInfo.LECTURE_SHOW_PAGE_COUNT-1));
		pageGroupResult.setGroupEndNumber(reqPageGroupNumber*PageInfo.LECTURE_SHOW_PAGE_COUNT); // 2
		
		int totalPageNumber=0;
		if(cnt/PageInfo.LECTURE_ROW_COUNT_PRE_PAGE>0) {
			totalPageNumber = (int) Math.ceil((double)(cnt/PageInfo.LECTURE_ROW_COUNT_PRE_PAGE+1));
			
		}else if(cnt/PageInfo.LECTURE_ROW_COUNT_PRE_PAGE==0) {
			totalPageNumber = (int) Math.ceil((double)(cnt/PageInfo.LECTURE_ROW_COUNT_PRE_PAGE));
		}
		
		if(pageGroupResult.getGroupEndNumber()>totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);	
		}
		
		
		if(pageGroupResult.getGroupStartNumber()==1) {
			pageGroupResult.setBeforePage(false);
			
		}
		
		if(pageGroupResult.getGroupEndNumber()==totalPageNumber) {
			pageGroupResult.setAfterPage(false);
			
		}
		
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
		return pageGroupResult;
	}
	
	
	public PageRowResult getQnaPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		pageRowResult.setRowEndNumber(PageInfo.QNA_ROW_COUNT_PRE_PAGE*requestPage);
		pageRowResult.setRowStartNumber(PageInfo.QNA_ROW_COUNT_PRE_PAGE*(requestPage-1)+1);
		// row 4
		return pageRowResult;
	}
	
	public PageGroupResult getQnaPageGroupResult(int rowCount) {
		
		PageGroupResult pgr = new PageGroupResult();
		
		int totalPage = rowCount /PageInfo.QNA_ROW_COUNT_PRE_PAGE;
		int remainRow  =rowCount %PageInfo.QNA_ROW_COUNT_PRE_PAGE;
		
		if(remainRow != 0)
			totalPage +=1 ;
		int totoalGroup = totalPage / PageInfo.SHOW_PAGE_COUNT;
		int remainPage = totalPage%PageInfo.SHOW_PAGE_COUNT;
		
		if(remainPage != 0)
			totoalGroup+=1;
		int reqGroup =requestPage/PageInfo.SHOW_PAGE_COUNT;

		int reqPageGroupNumber =(int) Math.ceil( (double) requestPage/PageInfo.SHOW_PAGE_COUNT);
		

		pgr.setGroupStartNumber(  PageInfo.SHOW_PAGE_COUNT *(reqPageGroupNumber-1) + 1);
		
		pgr.setGroupEndNumber(  PageInfo.SHOW_PAGE_COUNT * reqPageGroupNumber);

		if (totalPage - pgr.getGroupStartNumber() < PageInfo.SHOW_PAGE_COUNT)
			pgr.setGroupEndNumber(totalPage);

		//private boolean beforePage = true;
		if (  pgr.getGroupStartNumber() == 1) 
			pgr.setBeforePage(false);
		else
			pgr.setBeforePage(true);
		
		//private boolean afterPage = true;
		
		if(requestPage > PageInfo.SHOW_PAGE_COUNT * (totoalGroup-1))
			pgr.setAfterPage(false);	
		else
			pgr.setAfterPage(true);
		
		pgr.setSelectPageNumber(requestPage);
		
		return pgr;
		
		
	}
	
	public static void main(String[] args) {
		PageManager pm = new PageManager(3);
		PageRowResult prr = pm.getPageRowResult();
		//System.out.println(prr.getRowStartNumber()); //1 6 11
		//System.out.println(prr.getRowEndNumber()); //5 10 15
		
		PageGroupResult pgr = pm.getPageGroupResult(51);
		System.out.println(pgr.getGroupStartNumber()); //1
		System.out.println(pgr.getGroupEndNumber()); //3
	}
	
	public PageRowResult getBasketPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		pageRowResult.setRowEndNumber(PageInfo.BASKET_ROW_COUNT_PRE_PAGE*requestPage);
		pageRowResult.setRowStartNumber(PageInfo.BASKET_ROW_COUNT_PRE_PAGE*(requestPage-1)+1);
		// row 4
		return pageRowResult;
	}
	
	public PageGroupResult getBasketPageGroupResult(int cnt) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		int reqPageGroupNumber = (int) Math.ceil((double)requestPage/PageInfo.BASKET_SHOW_PAGE_COUNT); // 0.5--1
		
		pageGroupResult.setGroupStartNumber(reqPageGroupNumber*PageInfo.BASKET_SHOW_PAGE_COUNT-(PageInfo.BASKET_SHOW_PAGE_COUNT-1));
		
		pageGroupResult.setGroupEndNumber(reqPageGroupNumber*PageInfo.BASKET_SHOW_PAGE_COUNT); // 2
		
		int totalPageNumber=0;
		if(cnt%PageInfo.BASKET_ROW_COUNT_PRE_PAGE>0) {
			
			totalPageNumber = (int) Math.ceil((double)(cnt/PageInfo.BASKET_ROW_COUNT_PRE_PAGE+1));
		}else if(cnt%PageInfo.BASKET_ROW_COUNT_PRE_PAGE==0) {
			totalPageNumber = (int) Math.ceil((double)(cnt/PageInfo.BASKET_ROW_COUNT_PRE_PAGE));
		}
		
		if(pageGroupResult.getGroupEndNumber()>totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);	
		}
		
		
		if(pageGroupResult.getGroupStartNumber()==1) {
			pageGroupResult.setBeforePage(false);
			
		}
		
		if(pageGroupResult.getGroupEndNumber()==totalPageNumber) {
			pageGroupResult.setAfterPage(false);
			
		}
		
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
		return pageGroupResult;
	}
	
	
}
