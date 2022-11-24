package otiashvili_ketevani_quiz_01;
import java.util.ArrayList;
import java.util.HashMap;

public class MapReduceAnalysis {	
	
	public ArrayList<String> map(String[] lines){
		ArrayList<String> result = new ArrayList<String>();
		for (String line : lines) {
			String body = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
			String[] words = body.split(" ");
			for (String word : words) {
				if(word.length()>7) {
					result.add(word);
				}
			}
		}
	return result;	
	}
	
	
	public void reduce(ArrayList<String> result) {
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		for (String word : result) {
			Integer count = wordCount.get(word);          
			wordCount.put(word, (count==null) ? 1 : count+1);
		}
		wordCount.forEach(
	            (key, value)
	                -> System.out.println(key + " = " + value));
	}
}
	
