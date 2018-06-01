import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}

	String reverseParentheses(String s) {
		String result = s;
		String openParentheses = "(";
		String closeParentheses = ")";

		if (!s.contains(openParentheses)) {
			return s;
		}

		String temp = s;

		while (temp.contains(openParentheses)) {
			int indexOpen = temp.lastIndexOf(openParentheses);
			int indexClose = temp.indexOf(closeParentheses, indexOpen);

			String stringInParentheses = temp.substring(indexOpen + 1, indexClose);

			StringBuilder sb = new StringBuilder(stringInParentheses);

			String stringToReplace = String.join("", sb.reverse().toString());
//			System.out.println(stringToReplace);

			String beforeOpen = temp.substring(0, indexOpen);
//			System.out.println(beforeOpen);
			String afterClose = temp.substring(indexClose + 1, temp.length());
//			System.out.println(afterClose);

			temp = beforeOpen + stringToReplace + afterClose;
//			System.out.println(temp);
		}

		result = temp;
		System.out.println(result);
		return result;
	}

}
