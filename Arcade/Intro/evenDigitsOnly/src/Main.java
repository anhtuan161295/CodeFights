public class Main {

	public static void main(String[] args) {
		// write your code here
	}

	boolean evenDigitsOnly(int n) {
		String num = String.valueOf(n);
		return num.chars().boxed().mapToInt(i -> i.intValue()).allMatch(i -> i % 2 == 0);
	}
}
