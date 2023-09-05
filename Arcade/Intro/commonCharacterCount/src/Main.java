import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int rs = main.commonCharacterCount("zza", "zzz");
//		int rs = main.commonCharacterCount("abcdefghxyzttw", "hgfedcbaabcwwt");
//		int rs = main.commonCharacterCount("aabcc", "adcaa");
		System.out.println(rs);
	}

	int commonCharacterCount(String s1, String s2) {
		int count = 0;

		if (s1.contains(s2)) {
			return s2.length();
		} else if (s2.contains(s1)) {
			return s1.length();
		} else {

			List<String> noDuplicateList = new ArrayList<>();

			Map<String, Integer> map = new HashMap<>();

			String longer = "";
			String shorter = "";

			if (s1.length() < s2.length()) {
				longer = s2;
				shorter = s1;
			} else {
				longer = s1;
				shorter = s2;
			}

			char[] charArr1 = shorter.toCharArray();
			char[] charArr2 = longer.toCharArray();

			for (char c : charArr1) {
				String val = String.valueOf(c);
				if (!noDuplicateList.contains(val)) {
					noDuplicateList.add(val);
				}
			}

			for (String s : noDuplicateList) {

				if (longer.contains(s)) {

					int numberOccur1 = 0;
					int numberOccur2 = 0;

					for (char c1 : charArr1) {
						String val = String.valueOf(c1);
						if (s.equals(val)) {
							numberOccur1++;
						}
					}

					for (char c1 : charArr2) {
						String val = String.valueOf(c1);
						if (s.equals(val)) {
							numberOccur2++;
						}
					}

					if (numberOccur1 < numberOccur2) {
						map.put(s, numberOccur1);
					} else {
						map.put(s, numberOccur2);
					}

				}

			}

			System.out.println(map.toString());
			int total = 0;

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				total += entry.getValue();
			}

			count = total;
		}

		return count;
	}

}
