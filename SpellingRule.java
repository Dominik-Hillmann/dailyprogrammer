import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SpellingRule {
	
	public static boolean followsIBeforeE(String str) {
		String[] arr = str.split("");
		// search for exceptions the the rule
		for (int i = 0; i < arr.length - 1; i++) {
			// case cie
			if (arr[i].equals("i") && arr[i + 1].equals("e") && i > 0) {
				if (arr[i - 1].equals("c")) {
					return false;
				}
			}	
			
			// case *ei
			if (arr[i].equals("e") && arr[i + 1].equals("i")/*&& i > 0*/) {
				try {
					if (!arr[i - 1].equals("c")) {
						return false;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					return false; // ei at the beginning
				}
			}
		}
		return true;
	}
	
	public static void printTest(String... strs) {
		for (String str : strs) {
			System.out.println(str + ": " + (followsIBeforeE(str) ? "follows the rule." : "doesn't follow the rule."));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] test = { "a", "zombie", "transceiver", "veil", "icier" };		
		String[] test2 = { "sleigh", "stein", "fahrenheit", "deifies", "either", "nuclei", "reimburse", "ancient", "juicier", "societies" };
		
		printTest(test);
		printTest(test2);
		
		String path = "C:\\Users\\Dominik\\Desktop\\enable1.txt";		
		ArrayList<String> enable1 = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			
			while ((line = reader.readLine()) != null) {
				enable1.add(line);
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("Error concerning BufferedReader");
		}		
		
		int exceptions = 0;
		for (String word : enable1) {
			if (!followsIBeforeE(word)) exceptions++;
		}
		
		System.out.println(exceptions);
	}	
}
