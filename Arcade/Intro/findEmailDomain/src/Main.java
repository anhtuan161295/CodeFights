public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.findEmailDomain(""));
	}

	String findEmailDomain(String address) {
		String result = "";

		result = address.substring(address.lastIndexOf("@") + 1, address.length());

		return result;
	}

}
