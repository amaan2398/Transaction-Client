package guihandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import socketpro.ClientSocket;

public class ClientOptretion extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int x=100,y=100;
	private static String account;
	private static String balance;
	private static String loginID;
	private static JLabel balanceL;
	private static JTextField amountTF;
	private static JTextField AtranTF;
	
	public ClientOptretion(String acc,String bal,String id) {
		account=acc;
		balance=bal;
		loginID=id;
		userDetails();
		transactionButton();
		refreash();
		setSize(600,600);
		setLayout(null);  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void userDetails() {
		JLabel accT=new JLabel("Account Number:");
		accT.setBounds(x,y,100,30);
		JLabel accNo=new JLabel();
		accNo.setText("\t"+account);
		accNo.setBounds(x+100,y,100,30);
		add(accNo);
		add(accT);
		JLabel balT=new JLabel("balance:");
		balT.setBounds(x,y+50,100,30);
		balanceL=new JLabel();
		balanceL.setText("\t"+balance);
		balanceL.setBounds(x+50,y+50,100,30);
		add(balanceL);
		add(balT);
			
	}
	public void transactionButton() {
		JLabel Atran;  
		
		Atran=new JLabel("Account No. to transfer:");  
		Atran.setBounds(x,y+100, 250,30);
	    add(Atran);
	    AtranTF=new JTextField();  
	    AtranTF.setBounds(x,y+150, 200,30);
	    add(AtranTF);
	    
	    JLabel amount;  
		
		amount=new JLabel("Amount:");  
		amount.setBounds(x,y+200, 250,30);
	    add(amount);
	    amountTF=new JTextField();  
	    amountTF.setBounds(x,y+250, 200,30);
	    add(amountTF);
	    
	    
		JButton tran=new JButton("Transact");
		tran.setBounds(x,y+300,95,30);
		add(tran);
		tran.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str =ClientSocket.transaction(amountTF.getText(), loginID, AtranTF.getText());
				balanceL.setText("\t"+str);	
			}
		});
	}
	public void refreash() {
		JButton tran=new JButton("Refresh");
		tran.setBounds(x+175,y+75,95,30);
		add(tran);
		tran.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=ClientSocket.refresh(loginID);
				balanceL.setText(str);
				amountTF.setText("");
				AtranTF.setText("");
			}
		});
	}
}
