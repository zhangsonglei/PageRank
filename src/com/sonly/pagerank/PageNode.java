package com.sonly.pagerank;

/**
 * Class: PageNode
 * Description:  
 * Company: HUST
 * @author Sonly
 * Date: 2017Äê5ÔÂ19ÈÕ
 */
public class PageNode {
	
	private String pageName;	//the name of page
	private String[] inUrl;		//the urls from other pages
	private String[] outUrl;	//the urls to other pages
	private int PR;
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String[] getInUrl() {
		return inUrl;
	}
	public void setInUrl(String[] inUrl) {
		this.inUrl = inUrl;
	}
	public String[] getOutUrl() {
		return outUrl;
	}
	public void setOutUrl(String[] outUrl) {
		this.outUrl = outUrl;
	}
	public int getPR() {
		return PR;
	}
	public void setPR(int pR) {
		PR = pR;
	}
}
