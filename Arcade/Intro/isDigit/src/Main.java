import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// write your code here
	}

	boolean isDigit(char symbol) {
		boolean result = false;

		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(String.valueOf(symbol));
		result = matcher.matches();

		return result;
	}

}
