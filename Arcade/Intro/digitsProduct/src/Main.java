import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.digitsProduct(0));
	}

	int digitsProduct(int product) {
		int result = -1;

		int upperLimit = 10000;

		int num = 1;

		while (num < upperLimit) {
			List<Integer> list = String.valueOf(num).chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).map(k -> Integer.parseInt(k)).collect(Collectors.toList());

			int rs = 1;
			for (int i : list) {
				rs *= i;
			}

			if (rs == product) {
				result = num;
				break;
			}

			num++;
		}

		return result;
	}

}
