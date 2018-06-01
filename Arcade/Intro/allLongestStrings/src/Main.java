import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		String[] rs = main.allLongestStrings(new String[]{"aba", "aa", "ad", "vcd", "aba"});
		List<String> list = Arrays.asList(rs);
		System.out.println(list);
	}

	String[] allLongestStrings(String[] inputArray) {
		List<String> result = new ArrayList<>();

		int max = 0;
		for (String input: inputArray){
			if(input.length() > max){
				max = input.length();
			}
		}


		for (String input : inputArray){
			if (input.length() == max){
				result.add(input);
			}
		}

		return result.toArray(new String[0]);
	}

}
