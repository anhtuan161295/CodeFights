public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.depositProfit(100, 1, 101));
	}

	int depositProfit(int deposit, int rate, int threshold) {
		int result = 0;

		double total = deposit;
		int count = 0;
		while (true) {
			if (total >= threshold) {
				break;
			}

			total += (total * rate / 100);
			count++;
		}

		result = count;

		return result;
	}
}
