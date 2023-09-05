import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[][] rs = main.spiralNumbers(5);
	}

	int[][] spiralNumbers(int n) {
		int[][] result = new int[n][n];

		int[][] arr = new int[n][n];
		int count = 1;
		int max = n * n;

		int x = n;
		int y = n;
		int startX = 0;
		int startY = 0;

		while (count < max) {
			for (int i = startX; i < x; i++) {

				if (count > max) {
					break;
				}

				// Left to right
				for (int j = startY; j < y; j++) {
					arr[i][j] = count++;

					if (count >= max) {
						break;
					}

					if (j == y - 1) {
						// Top to bottom
						for (int k = i + 1; k < x; k++) {
							arr[k][j] = count++;

							if (k == x - 1) {
								y--;
								// Right to left
								for (int l = y - 1; l >= startY; l--) {
									arr[k][l] = count++;
//									System.out.println(arr[k][l]);

									if (l == startY) {
										x--;
										// Bottom to top
										for (int m = x - 1; m >= startX; m--) {
											if (m == i) {
												startX = m + 1;
												startY = l + 1;
												break;
											}
											arr[m][l] = count++;
										}
									}
								}
							}
						}
					}
				}


			}

		}


		for (int i = 0; i < arr.length; i++) {
			int[] a = arr[i];
			System.out.println(Arrays.toString(a));
		}

		result = arr;

		return result;
	}

}
