import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Autocomplete {
	
	@Test
	public void autocompleteTest() {
		String[] set = { "hello", "high", "seattle", "seatac", "see", "hollow", "how" };
		String[] inputs = { "h", "se", "sea", "ho", "xyz" };
		List<List<String>> actual = new ArrayList<List<String>>();

		Trie trie = new Trie();
		// insert set into trie
		for (int i=0; i<set.length; i++) {
			trie.add(set[i]);
		}
		
		String[][] expects = {
				{"hello", "high", "hollow", "how"}, 
				{"seattle", "seatac", "see"},
				{"seattle", "seatac"},
				{"hollow", "how"}
		};
		
		// loop through inputs
		for (int i=0; i<inputs.length; i++) {
			// list result is all results for each input
			List result = trie.autocomplete(inputs[i]);
			
			System.out.println(result.toString()); // for debugging
			actual.add(result);
			
			// loop through results for each input
			for (int j=0; j<result.size(); j++) {
				
				//System.out.println(actual.get(i).get(j) + " " + expects[i][j]); // for debugging
				
				// check actual vs. expected
				assertEquals(actual.get(i).get(j), expects[i][j]);
			}
		}
	}
	
}