package com.sonly.pagerank;

import java.io.IOException;

/**
 * Class: PageRank
 * Description:  to execute this program
 * Company: HUST
 * @author Sonly
 * Date: 2017��5��19��
 */
public class PageRank {

	/**
	 * Method: main
	 * Description: the entrance of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String string = "Files\\pages\\1.txt";
		string = FileOperator.readFile(string);
		String cont = CalcUtil.getUrl(string);
		
		//System.out.print(cont);
			
	}
}
