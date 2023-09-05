public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.messageFromBinaryCode("010010000110010101101100011011000110111100100001"));
	}

	String messageFromBinaryCode(String code) {
		String result = "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < code.length(); i += 8) {
			int charCode = Integer.parseInt(code.substring(i, i + 8), 2);
			sb.append((char) charCode);
		}

		result = sb.toString();

		return result;
	}

}
