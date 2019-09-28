package socketpro;

import java.io.DataInputStream;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import guihandling.ClientOptretion;

public class ClientSocket {
	private static String loginID="";
	private static String password="";
	private static String acc;
	private static String bal;
	
	private static String amount;
	private static String from;
	private static String to;
	
	private static String tosend;
	
	private static String choice;
	
	private static String balance;
	
	private static DataInputStream dis;
	private static DataOutputStream dos;
	
	public static void stringSlice(String str) {
    	StringTokenizer st1 = new StringTokenizer(str);
    	acc=st1.nextToken();
    	bal=st1.nextToken();
    }
	
	private static void serverconn() {
		try{     
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 
      
            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5101); 
      
            // obtaining input and out streams 
            dis = new DataInputStream(s.getInputStream()); 
            dos = new DataOutputStream(s.getOutputStream()); 
      
            // the following loop performs the exchange of 
            // information between client and client handler 
            while (true){
            	switch(choice) {
            	case "login":
            		dos.writeUTF("login");
            		sendlogin();
            		dos.writeUTF(tosend);
            		break;
            	case "transaction":
            		dos.writeUTF("transaction");
            		sendtransaction();
            		dos.writeUTF(tosend);
            		break;
            	case "refresh":
            		dos.writeUTF("refresh");
            		sendrefresh();
            		dos.writeUTF(tosend);
            		break;
            	default:
            		System.out.println("Error in choice");
            		break;
            	}
            	
            	
                // If client sends exit,close this connection  
                // and then break from the while loop 
                if(tosend.equals("Exit")){ 
                	
                	System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
                
            } 
              
            // closing resources 
            dis.close(); 
            dos.close(); 
        }catch(Exception e){ 
            System.out.println("Client connection Error>>");
            System.out.println(e);
        }
		
	}
	private static void sendlogin() {
		try {
			String tosend1 = loginID+" "+password; 
			dos.writeUTF(tosend1);
			
			String received = dis.readUTF();
			stringSlice(received);
			tosend="Exit";
			new ClientOptretion(acc,bal,loginID);
			
		} catch (Exception e) {
			System.out.println("Login Error client!!!");
			System.out.println(e);
		}
        
	}
	private static void sendtransaction() {
		try {
			//do something
			String tosend1=amount+" "+from+" "+to;
			dos.writeUTF(tosend1);
			
			balance = dis.readUTF();
			//setBalanceL(received);
			tosend="Exit";
			
			
		}catch(Exception e){
			System.out.println("Transcation Error client!!!");
		}
		
	}
	private static void sendrefresh() {
		try {
			dos.writeUTF(loginID);
			balance= dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void login(String id,char[] pass) {
		loginID=id;
		for(int i=0;i<pass.length;i++) {
			password+=Character.toString(pass[i]);
		}
		choice="login";
		serverconn();
		
	}
	public static String transaction(String amo,String f,String t) {
		amount=amo;
		from=f;
		to=t;
		choice="transaction";
		serverconn();
		return balance;
	}
	public static String refresh(String id) {
		loginID=id;
		choice="refresh";
		serverconn();
		return balance;
	}
	
}
