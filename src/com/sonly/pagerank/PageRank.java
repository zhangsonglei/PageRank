package com.sonly.pagerank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class: PageRank
 * Description:  to execute this program
 * Company: HUST
 * @author Sonly
 * Date: 2017Äê5ÔÂ19ÈÕ
 */
public class PageRank {

	/**
	 * Method: PR
	 * Description: get PR of each page
	 * @param pages
	 * @param path
	 * @throws IOException 
	 */
	private static void PR(List<String> pages, String path) throws IOException {
		String page = new String();
		List<PageNode> list = new ArrayList<>();
		Iterator<String> iterator = pages.iterator();
		
		while(iterator.hasNext()) {
			page = (String) iterator.next();
			PageNode pageNode = new PageNode();
			pageNode.setPageName(page);
			pageNode.setOutUrl(CalcUtil.getUrl(page));
			
			list.add(pageNode);
		}
		
		double[][] matrix = CalcUtil.generateMatrix(list);
		double[] vector = new double[list.size()];
		double[] newVector = new double[vector.length];
		for(int i = 0; i < vector.length; i++)
			vector[i] = 1.0/list.size();
		
		double[] e = vector;
		int count = 1;
		newVector = CalcUtil.calcPR(matrix, vector, e);

		while(isChanged(vector, newVector)) {
			for(int i = 0; i < newVector.length; i++)
				System.out.print(newVector[i] +" ");
			System.out.println();
			
			vector = newVector;
			newVector = CalcUtil.calcPR(matrix, vector, e);
			count++;
		}
		
		System.out.println(count+" times converge");
		FileOperator.writeFile(pages, newVector, path);
	}
	
	/**
	 * Method: isChanged
	 * Description: to judge whether two vectors is equal
	 * @param vec1
	 * @param vec2
	 * @return
	 */
	private static boolean isChanged(double[] vec1, double[] vec2) {
		if(vec1.length != vec2.length) {
			System.err.println("different length, please handle it first");
			return false;
		}
		
		for(int i = 0; i < vec1.length; i++) {
			if((vec1[i]-vec2[i]) != 0)
				return true;
		}
		
		return false;
	}

	/**
	 * Method: main
	 * Description: the entrance of the program
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String readPath = "Files\\pages";
		String writePath = "Files\\result.txt";
		
		List<String> list = FileOperator.getAllFileName(readPath);
		PR(list, writePath);			
	}
}
