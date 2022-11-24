package otiashvili_ketevani_quiz_01;
import java.util.ArrayList;

public class StandardAnalysis {
	
	public ArrayList<String> analyse() {
		java.util.ArrayList<String> output = new ArrayList<String>();
		
		for (String line : AsYouLikeIt.text) {
			String body = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
			String[] words = body.split(" ");
			for (String word : words) {
				if(word.length()>7) {
					output.add(word);
				}
			}
		}
		return output;
	}
}
