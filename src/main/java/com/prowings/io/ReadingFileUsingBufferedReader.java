package com.prowings.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadingFileUsingBufferedReader {
	
	public static void main(String[] args) throws FileNotFoundException {

		ReadingFileUsingBufferedReader obj = new ReadingFileUsingBufferedReader();
		InputStream inputStream = obj.readFileDynamically();

	       try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream) )) {
	            String line;
	            
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public InputStream readFileDynamically() {
		return getClass().getClassLoader().getResourceAsStream("exampleText.txt");
	}

}
