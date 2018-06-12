import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.buildPalindrome("ababab"));
	}

	String buildPalindrome(String st) {
		String result = "";

		result = getPalidromeString(st);
		if (!result.equals("")) {
			return result;
		}

		List<String> chars = st.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());
		List<String> reverseChars = new ArrayList<>(chars);
		Collections.reverse(reverseChars);
		String reverseInputString = String.join("", reverseChars);

		String s = "";

		for (int i = 0; i < chars.size(); i++) {
			s += chars.get(i);
			String str = s + reverseInputString;

			String rs = getPalidromeString(str);

			if (!rs.equals("")) {
				result = rs;
				break;
			}
		}

//		System.out.println(chars);

		return result;
	}

	private String getPalidromeString(String st) {
		String result = "";

		// check if input string is palindrome
		if (st.length() % 2 == 0) {
			String firstPart = st.substring(0, (st.length() / 2));
			String secondPart = st.substring((st.length() / 2), st.length());

			// Reverse string to compare
			List<String> chars = secondPart.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());
			Collections.reverse(chars);
			secondPart = String.join("", chars);

			if (firstPart.equals(secondPart)) {
				return st;
			}
		} else if (st.length() % 2 != 0) {
			String firstPart = st.substring(0, (st.length() / 2));
			String secondPart = st.substring((st.length() / 2) + 1, st.length());

			// Reverse string to compare
			List<String> chars = secondPart.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());
			Collections.reverse(chars);
			secondPart = String.join("", chars);

			if (firstPart.equals(secondPart)) {
				return st;
			}
		}

		return result;
	}

}
