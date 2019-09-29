

import guihandling.Gui;
import manager.ErrorManager;

public class Client {
	/**Main Client**/
	public static void main(String[] args) {
		try {
			new Gui();
		}
		catch(Exception e) {
			ErrorManager.errornotknown();
			System.out.println("Start Error!..Client");
			System.out.println(e);
		}
	}

}
