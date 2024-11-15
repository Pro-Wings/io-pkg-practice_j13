package com.prowings.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CountWordsCharacterAndLines {

	public static void main(String[] args) {
		Class<?> clazz = CountWordsCharacterAndLines.class;
		InputStream inputStream = clazz.getClassLoader().getResourceAsStream("myFile.txt");

		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				lineCount++;
				String[] words = line.split(" ");
				wordCount = wordCount + words.length;
				charCount = charCount + (line.length());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Total Lines present in file : "+lineCount);
		System.out.println("Total Words present in file : "+wordCount);
		System.out.println("Total Chars present in file : "+charCount);
		
	}

}
