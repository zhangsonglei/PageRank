package com.sonly.pagerank;

import java.util.List;

/**
 * Class: PageNode
 * Description:  
 * Company: HUST
 * @author Sonly
 * Date: 2017Äê5ÔÂ19ÈÕ
 */
public class PageNode {
	private String pageName;	//the name of page
	private List<String> outUrl;	//the urls to other pages
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public List<String> getOutUrl() {
		return outUrl;
	}
	public void setOutUrl(List<String> outUrl) {
		this.outUrl = outUrl;
	}
}
