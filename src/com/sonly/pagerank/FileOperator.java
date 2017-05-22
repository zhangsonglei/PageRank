package com.sonly.pagerank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Description: to read file or write file 
 * @author: Sonly
 * Company: HUST 
 * @date: 2017年5月13日上午8:51:30
 */
public class FileOperator {
	
	/**
	 * Method: getAllFileName
	 * Description: get all file name in direction
	 * @param dirction
	 * @return
	 * @throws IOException
	 */
	public static List<String> getAllFileName(String direction) throws IOException {
		List<String> list = new ArrayList<>();
		File file = new File(direction);
		File[] fileList = file.listFiles();
		
		for(File f : fileList)
			list.add(f.toString());
		
		return list;
	}
	/**
	 * read file by line and save to String
	 * @param path
	 * @return String
	 * @throws IOException
	 */
	public static String readFile(String path) throws IOException {
		String content = new String();
		File file = new File(path);
		
		if(file.isFile() && file.exists()) {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(inputStreamReader);
			
			String line = new String();
			while((line = reader.readLine()) != null) {
				content += line;
			}
			reader.close();
		}else {
			System.err.println("File:\""+path+"\" read failed!");
		}
		
		return content;	
	}
	
	/**
	 * write to file
	 * @param strings
	 * @param path
	 * @throws IOException
	 */
	public static void writeFile(String[] strings, String path) throws IOException {
		File file = new File(path);
		
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
		BufferedWriter writer = new BufferedWriter(outputStreamWriter);
		
		for(String string : strings) {
			writer.write(string);
			writer.newLine();
		}
		writer.close();
	}
}
