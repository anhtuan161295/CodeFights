import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.sumUpNumbers("2 apples, 12 oranges"));
	}

	int sumUpNumbers(String inputString) {
		int result = 0;

		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(inputString);

		int total = 0;
		while (matcher.find()) {
			int n = Integer.parseInt(matcher.group());
			total += n;
		}

		result = total;

		return result;
	}

}
