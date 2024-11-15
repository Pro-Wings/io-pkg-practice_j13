package com.prowings.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CalculateWordOccuranceFromGivenTextFile {

	public static void main(String[] args) {

		// read file
		// prepare list of all words
		CalculateWordOccuranceFromGivenTextFile obj = new CalculateWordOccuranceFromGivenTextFile();
		List<String> allWords = obj.readAllWordsFromFile("Sample2.txt");
		System.out.println(allWords);
		// code to calculate occurrence/frequency of each word

//		for(String word : allWords)
//		{
//			int frequency = Collections.frequency(allWords, word);
//			System.out.println(word+" : "+frequency);
//		}

		Map<String, Integer> wordCountMap = new HashMap<>();

		for (String word : allWords) {
			if (wordCountMap.containsKey(word)) {
				Integer oldVal = wordCountMap.get(word);
				wordCountMap.put(word, oldVal + 1);
			} else
				wordCountMap.put(word, 1);
		}

		Set<Entry<String, Integer>> entries = wordCountMap.entrySet();

		for (Entry<String, Integer> e : entries)
			System.out.println(e.getKey() + " : " + e.getValue());

	}

	public List<String> readAllWordsFromFile(String filename) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

		List<String> allWords = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String[] words = line.split(" ");
				allWords.addAll(Arrays.asList(words));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return allWords;

	}

}
