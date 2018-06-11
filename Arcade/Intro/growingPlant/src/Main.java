public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.growingPlant(100, 10, 910));
	}

	int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
		int result = 0;
		int plantHeight = 0;
		int count = 1;

		while (true) {
			if (plantHeight >= desiredHeight) {
				break;
			}

			plantHeight += upSpeed;
			if (plantHeight >= desiredHeight) {
				break;
			}

			plantHeight -= downSpeed;
			count++;
		}

		result = count;

		return result;
	}

}
