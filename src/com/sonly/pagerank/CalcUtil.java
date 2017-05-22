package com.sonly.pagerank;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class: CalcUtil
 * Description: provide necessary compute methods to this program
 * Company: HUST
 * @author Sonly
 * Date: 2017Äê5ÔÂ19ÈÕ
 */
public class CalcUtil {
	public static String getUrl(String file) {
		String regex;
		final List list = new ArrayList();
		regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(file);
		String re = "";
		
		while (ma.find())
		{
			list.add(ma.group());
			for(int i = 0; i <= ma.groupCount(); i++) {
				re =re + i +"::" + ma.group(i) + "\r\n";
			}
		}
		
//		
//		String strtemp = "",saveFileName = "",strtotal = "";
//		int x1=0,x2=0;FileWriter f2 = null;
//		for (int i = 0; i < list.size(); i++) { 
//			strtemp = (String)list.get(i) ;
//			strtemp = strtemp.toLowerCase() ;
//			strtotal = strtotal + strtemp +"\r\n";
//		}

		return re;
	}
	
}
