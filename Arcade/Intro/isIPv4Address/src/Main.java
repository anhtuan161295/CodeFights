import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.isIPv4Address("172.16.254.1"));
	}

	boolean isIPv4Address(String inputString) {
		boolean result = false;

		if (!inputString.contains(".")) {
			return false;
		}

		String[] parts = inputString.split("\\.");

		if (parts.length != 4) {
			return false;
		}

//		System.out.println(Arrays.toString(parts));

		boolean isAnyPartEmpty = Arrays.stream(parts).anyMatch(i -> i.isEmpty());

		boolean isValid = true;
		try {
			for (String p : parts) {
				int i = Integer.parseInt(p);
//				System.out.println(p);
				if (i < 0 || i > 255) {
					isValid = false;
					break;
				}
			}

		} catch (Exception e) {
			isValid = false;
		}

		if (!isAnyPartEmpty && isValid) {
			result = true;
		}

		return result;
	}

}
