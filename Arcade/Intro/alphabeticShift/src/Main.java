import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.alphabeticShift("crazy"));
	}

	String alphabeticShift(String inputString) {
		String result = "";

		String line = "abcdefghijklmnopqrstuvwxyz";
		List<String> alphabet = line.chars()
				.mapToObj(i -> (char) i)
				.map(i -> String.valueOf(i)).collect(Collectors.toList());

		List<String> characters = inputString.chars()
				.mapToObj(i -> (char) i)
				.map(i -> String.valueOf(i)).collect(Collectors.toList());

		List<String> tempList = characters;

		for (int i = 0; i < characters.size(); i++) {
			String s = characters.get(i);
			int index = line.indexOf(s);
			int indexToReplace = index + 1;

			if (indexToReplace >= 26) {
				indexToReplace = indexToReplace - 26;
//				System.out.println(indexToReplace);
			}

			String s1 = alphabet.get(indexToReplace);
			tempList.set(i, s1);

		}

		StringBuilder sb = new StringBuilder();
		for (String s : tempList) {
			sb.append(s);
		}

		result = sb.toString();

		return result;
	}
}
