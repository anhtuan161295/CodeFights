import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.longestWord("Ready[[[, steady, go!"));
	}

	String longestWord(String text) {
		String result = "";

		List<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("[a-zA-Z]+");

		Matcher matcher = pattern.matcher(text);

		while (matcher.find()){
			list.add(matcher.group().trim());
		}

		System.out.println(list);

		result = list.stream().max((o1, o2) -> o1.length() - o2.length()).get();

		return result;
	}

}
