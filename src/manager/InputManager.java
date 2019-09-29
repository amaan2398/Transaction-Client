package manager;

public class InputManager {
	private static boolean result=false;

	public static boolean isResult() {
		return result;
	}

	public static void setResult(boolean result) {
		InputManager.result = result;
		System.out.println(result);
	}
	

}
