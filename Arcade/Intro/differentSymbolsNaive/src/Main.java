import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.differentSymbolsNaive(""));
	}

	int differentSymbolsNaive(String s) {
		int result = 0;

		result = s.chars().distinct().mapToObj(i -> String.valueOf(i)).collect(Collectors.toList()).size();

		return result;
	}
}
