import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.validTime("24:00"));
	}

	boolean validTime(String time) {
		return time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
	}

}
