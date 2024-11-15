package com.prowings.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileDynamically {
	
	public static void main(String[] args) {
		
		ReadFileDynamically obj = new ReadFileDynamically();
		String dataFromFile = obj.readFromFile("exampleText.txt");
		
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		System.out.println(dataFromFile);
		
	}

	public String readFromFile(String string) {
		  InputStream inputStream = getClass().getClassLoader().getResourceAsStream("exampleText.txt");
	      StringBuffer sb = new StringBuffer(); 
		  try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream) )) {
	            String line;
	            
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	                sb.append(line); 
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return new String(sb);

	}

}
