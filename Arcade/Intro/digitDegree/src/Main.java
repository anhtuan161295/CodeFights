public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.digitDegree(91));
	}

	int digitDegree(int n) {
		int result = 0;

		if (String.valueOf(n).length() == 1) {
			return 0;
		}

		String number = String.valueOf(n);
		int count = 0;

		while (true) {

			if (String.valueOf(number).length() == 1) {
				break;
			}

			char[] chars = number.toCharArray();

			int sum = 0;
			for (int i = 0; i < chars.length; i++) {
				sum += Integer.parseInt(String.valueOf(chars[i]));
			}

			String sumString = String.valueOf(sum);

			if (sumString.length() > 1) {
				number = sumString;
				count++;
				continue;
			}

			if (sumString.length() == 1){
				count++;
				break;
			}
		}

		result = count;

		return result;
	}

}
