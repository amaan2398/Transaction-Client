package manager;

import javax.swing.JOptionPane;

public class ErrorManager {
	public static void errornotknown(){
		JOptionPane.showMessageDialog(null, "Error in opening app!");
	}
	
	public static void loginidpass() {
		JOptionPane.showMessageDialog(null, "Wrong LoginID or Password!");
	}
	public static void accountdoesntexist() {
		JOptionPane.showMessageDialog(null, "Account does not exist please check!");
	}
	public static void servererror() {
		JOptionPane.showMessageDialog(null, "Server got some Error try after sometime!");
	}
	public static void balancelow() {
		JOptionPane.showMessageDialog(null, "Your balance is low!");
	}

}
