public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.circleOfNumbers(10, 2));
  }

  int circleOfNumbers(int n, int firstNumber) {
    int result = 0;
    if (firstNumber >= (n / 2)) {
      result = Math.abs((n / 2) - firstNumber);
    } else {
      result = n + (firstNumber - (n / 2));
    }

    return result;
  }
}
