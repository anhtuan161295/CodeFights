import java.util.regex.Pattern;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.firstDigit("var_1__Int"));
	}

	char firstDigit(String inputString) {
		char[] chars = inputString.toCharArray();
		char result = chars[0];

		Pattern pattern = Pattern.compile("\\d");

		for (char c : chars) {
			if (pattern.matcher(String.valueOf(c)).matches()) {
				result = c;
				break;
			}
		}

		return result;
	}
}
