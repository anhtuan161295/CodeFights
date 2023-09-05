public class Main {

  public static void main(String[] args) {
    // write your code here
    Main main = new Main();
    int[][] m = new int[][]{{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}};
    System.out.println(main.matrixElementsSum(m));
  }

  int matrixElementsSum(int[][] matrix) {
    int result = 0;

    int[] row = matrix[0];

    for (int j = 0; j < row.length; j++) {

      for (int k = 0; k < matrix.length; k++) {
        int cell = matrix[k][j];

        if (cell == 0) {
          break;
        } else {
          result += cell;
        }

      }
    }

    return result;
  }
}
