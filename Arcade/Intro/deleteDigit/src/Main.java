import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.deleteDigit(152));
	}

	int deleteDigit(int n) {
		int result = 0;

		String num = String.valueOf(n);

		List<String> chars = num.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());

		int max = 0;
		for (int i = 0; i < chars.size(); i++) {
			List<String> list = new ArrayList<>(chars);
			list.remove(i);

			String numberString = String.join("", list);
			int number = Integer.parseInt(numberString);

			if (number > max) {
				max = number;
			}

		}

		result = max;

		return result;
	}

}
