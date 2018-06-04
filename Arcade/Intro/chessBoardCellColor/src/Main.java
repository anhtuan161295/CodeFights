import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.chessBoardCellColor("A2", "B3"));

  }

  boolean chessBoardCellColor(String cell1, String cell2) {
    boolean result = false;

    if (cell1.isEmpty() || cell2.isEmpty()) {
      return false;
    }

    List<String> characters = Arrays.asList("", "A", "B", "C", "D", "E", "F", "G", "H");
    List<String> numbers = Arrays.asList("", "1", "2", "3", "4", "5", "6", "7", "8");

    List<String> firstCell = cell1.chars().mapToObj(i -> (char) i).map(i -> String.valueOf(i)).collect(Collectors.toList());
    List<String> secondCell = cell2.chars().mapToObj(i -> (char) i).map(i -> String.valueOf(i)).collect(Collectors.toList());

    int firstCellBottom = characters.indexOf(firstCell.get(0));
    int firstCellLeft = numbers.indexOf(firstCell.get(1));
    boolean isFirstCellEvenOrOdd = (firstCellBottom % 2 == 0) && (firstCellLeft % 2 == 0) || (firstCellBottom % 2 != 0) && (firstCellLeft % 2 != 0);

    int secondCellBottom = characters.indexOf(secondCell.get(0));
    int secondCellLeft = numbers.indexOf(secondCell.get(1));
    boolean isSecondCellEvenOrOdd = (secondCellBottom % 2 == 0) && (secondCellLeft % 2 == 0) || (secondCellBottom % 2 != 0) && (secondCellLeft % 2 != 0);

    // Check if both borders are equal, if borders are equal, then the cell is black
    boolean isFirstCellBlack = firstCellBottom == firstCellLeft;
    boolean isSecondCellBlack = secondCellBottom == secondCellLeft;

    // If borders are not equal, check if the borders are both even or both odd
    if (!isFirstCellBlack) {
      isFirstCellBlack = isFirstCellEvenOrOdd;
    }

    if (!isSecondCellBlack) {
      isSecondCellBlack = isSecondCellEvenOrOdd;
    }

//    System.out.println(isFirstCellBlack);
//    System.out.println(isSecondCellBlack);

    // If both cell are black or white, return true
    if (isFirstCellBlack && isSecondCellBlack || (!isFirstCellBlack && !isSecondCellBlack)) {
      result = true;
    }

    return result;
  }

}
