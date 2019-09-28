package guihandling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import socketpro.ClientSocket;

public class Gui extends JFrame{
	/** Login Page **/
	private static final long serialVersionUID = 1L;
	private static int x=100,y=100;
	
	public Gui() {
		
		loginpage();
		//here below code is for window size
		setSize(600,600);//width and height
		setLayout(null);//no specific Layout  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//safely close window.
		
	}
	private void loginpage() {
		//Login UI
		JLabel logL;  
		JTextField logT;
		logL=new JLabel("Login ID");  
	    logL.setBounds(x,y, 100,30);
	    add(logL);
	    logT=new JTextField();  
	    logT.setBounds(x,y+50, 200,30);
	    add(logT);
	    
	    //Password UI
	    JLabel passL;
	    passL=new JLabel("Password");  
	    passL.setBounds(x,y+100, 100,30);
	    add(passL);
	    JPasswordField passT= new JPasswordField();
	    passT.setBounds(x,y+150, 200,30);
	    add(passT);
	    
	    //Login button UI
	    JButton logB=new JButton("Login");
	    logB.setBounds(x,y+200,95,30);
	    logB.addActionListener(new ActionListener()
	    {
	    	@Override
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        	ClientSocket.login(logT.getText(),passT.getPassword());
	        	dispose();
	        }
	      });
	    add(logB);
	}
	
}
