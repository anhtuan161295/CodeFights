public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.isLucky(1230));
	}

	boolean isLucky(int n) {
		boolean result = false;

		String num = String.valueOf(n);
		String firstHalf = num.substring(0, num.length() / 2);
		String secondHalf = num.substring(num.length() / 2, num.length());

		int totalFirst = 0;
		char[] char1 = firstHalf.toCharArray();
		for (char c : char1) {
			int a = Integer.parseInt(String.valueOf(c));
			totalFirst += a;
		}

		int totalSecond = 0;
		char[] char2 = secondHalf.toCharArray();
		for (char c : char2) {
			int a = Integer.parseInt(String.valueOf(c));
			totalSecond += a;
		}

		System.out.println(totalFirst);
		System.out.println(totalSecond);

		return totalFirst == totalSecond;
	}
}
