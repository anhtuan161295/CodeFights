public class Main {

  public static void main(String[] args) {
    // write your code here
    Main main = new Main();
    System.out.println(main.almostIncreasingSequence(new int[]{1, 2, 1, 2}));
  }

  boolean almostIncreasingSequence(int[] sequence) {
    int max = -1000;
    int secondMax = -1000;
    int count = 0;

    for (int i = 0; i < sequence.length; i++) {
      int x = sequence[i];

      if (x > max) {
        secondMax = max;
        max = x;
      } else if (x < max && x > secondMax) {
        max = x;
        count++;
      } else if (x == max && x > secondMax) {
        count++;
      } else if (x < max && x < secondMax) {
        count++;
      } else if (x < max && x == secondMax) {
        count++;
      }
    }

    return count < 2;
  }
}
