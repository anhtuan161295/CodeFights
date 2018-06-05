public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.variableName("var_1__Int"));
	}

	boolean variableName(String name) {
		String regex = "[a-zA-Z_][a-zA-Z_0-9]*";
		return name.matches(regex);
	}
}
