import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		String[] s = new String[]{
				"doc",
				"doc",
				"image",
				"doc(1)",
				"doc"
		};
		String[] rs = main.fileNaming(s);
		System.out.println(Arrays.toString(rs));
	}

	String[] fileNaming(String[] names) {
		String[] result = new String[]{};

		List<String> defaultList = Arrays.asList(names);

		List<String> list = new ArrayList<>();
		list.addAll(defaultList);

		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);

			for (int j = i + 1; j < list.size(); j++) {
				String name2 = list.get(j);


				if (name.equals(name2)) {

					List<String> subList = list.subList(0, j);

					int count = 1;
					while (true) {
						String newName = name2 + "(" + count + ")";

						if (subList.contains(newName)) {
							count++;
							continue;
						} else {
							list.set(j, newName);
							break;
						}
					}
				}
			}
		}

//		System.out.println(list);

		result = list.toArray(new String[0]);

		return result;
	}

}
