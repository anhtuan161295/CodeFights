import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(Arrays.toString(main.addBorder(new String[]{"abc", "ded"})));
	}

	String[] addBorder(String[] picture) {
		List<String> list = new ArrayList<>();

		int length = picture[0].length();
		String topBorder = String.join("", Collections.nCopies(length + 2, "*"));

		list.add(topBorder);
		for (String s : picture) {
			list.add("*" + s + "*");
		}
		list.add(topBorder);

		return list.toArray(new String[0]);
	}

}
