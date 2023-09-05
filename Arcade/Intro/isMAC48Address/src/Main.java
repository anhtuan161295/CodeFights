import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.isMAC48Address("00-1B-63-84-45-E6"));
	}

	boolean isMAC48Address(String inputString) {
		boolean result = false;

		Pattern pattern = Pattern.compile("[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}");
		Matcher matcher = pattern.matcher(inputString);

		result = matcher.matches();

		return result;
	}

}
