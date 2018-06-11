import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.longestDigitsPrefix("123aa1"));
	}

	String longestDigitsPrefix(String inputString) {
		String result = "";

		String s = "";
		if (inputString.contains(" ")) {
			s = inputString.substring(0, inputString.indexOf(" ") + 1);
			if (s.trim().equals("")) {
				result = "";
			} else {
				Pattern pattern = Pattern.compile("[0-9]+");
				Matcher matcher = pattern.matcher(s);
				if (matcher.find()) {
					result = matcher.group();
				}
			}
		} else {
			Pattern pattern = Pattern.compile("[0-9]+");
			Matcher matcher = pattern.matcher(inputString);
			if (matcher.find()) {
				result = matcher.group();
			}
		}

		return result;
	}
}
