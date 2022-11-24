package otiashvili_ketevani_quiz_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Main {

	public static void main(String[] args) {
		StandardAnalysis standardAnalysis = new StandardAnalysis();
		ArrayList<String> longWords = standardAnalysis.analyse();
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for (String word : longWords) {
			Integer count = wordCount.get(word);          
			wordCount.put(word, (count==null) ? 1 : count+1);
		}
		wordCount.forEach(
	            (key, value)
	                -> System.out.println(key + " = " + value));
	}
}
