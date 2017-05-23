package com.sonly.pagerank;

import java.io.IOException;
import java.util.ArrayList;
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
	private static final double alpha = 0.85;  
  
	/**
	 * Method: getUrl
	 * Description: obtain all url from page
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static List<String> getUrl(String filePath) throws IOException {
		List<String> list = new ArrayList<String>();
		String regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
		String content = FileOperator.readFile(filePath);
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(content);
		
		while (ma.find())
			list.add(ma.group(2));

		return list;
	}
	
	/**
	 * Method: calcMatrix
	 * Description: calculate PR value
	 * @param matrix
	 * @param vector
	 * @return
	 */
	public static double[] calcPR(double[][] matrix, double[] vector, double[] e) {
		double[] res = new double[vector.length];
		
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i].length != vector.length) {
				System.err.println("wrong length for matrix and vector");
				return null;
			}
			
			for(int j = 0; j < vector.length; j++) {
				res[i] += alpha * matrix[i][j] * vector[j] + (1.0 - alpha) * e[j];
				//res[i] += matrix[i][j] * vector[j];
			}//end for(j)
		}//end for(i)
		return res;
	}
	
	/**
	 * Method: generateMatrix
	 * Description: generate matrix according to pages and urls in them;
	 * @param list
	 * @return
	 */
	public static double[][] generateMatrix(List<PageNode> list) {
		double[][] matrix = new double[list.size()][list.size()];
		double p = 0.0;
		int size = 0;
		for(int i = 0; i < list.size(); i++) {
			size = list.get(i).getOutUrl().size();
			if(size != 0)
				p = 1.0 / size;
			
			for(int j = 0; j < list.size(); j++) {
				
				if(list.get(i).getOutUrl().contains(list.get(j).getPageName()))
					matrix[j][i] = p;
				else
					matrix[j][i] = 0.0;
			}// end for(j)
		}//end for(i)

		showMatrix(matrix);
		return matrix;
	}
	
	/**
	 * Method: showMatrix
	 * Description: print matrix
	 * @param matrix
	 */
	public static void showMatrix(double[][] matrix) {
		if(0 == matrix.length)
			System.err.println("null matrix");
		else
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++)
					System.out.print(matrix[i][j] + " ");
				System.out.println();
			}
		
	}
}
