package XMPP;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class getConnection {
	XMPPConnection connection;
	
	public XMPPConnection getconnection(String username, String password) {
		ConnectionConfiguration config = new ConnectionConfiguration("127.0.0.1", 5222);
		connection = new XMPPConnection(config);
	
		try {
			connection.connect();
			System.out.println("Connection Established With Server!");
			connection.login(username, password);
			System.out.println("Login Successfull");
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public void login(String username, String password) {
//		try {
//			
//		} catch (XMPPException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void register(String username, String password, String email, String fullname) {
		AccountManager manager = connection.getAccountManager();
		Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("username", username);
        attributes.put("password", password);
        attributes.put("email", email);
        attributes.put("name", fullname);  
		try {
			manager.createAccount(username, password, attributes);
			System.out.println("Account Created!");
			JOptionPane.showMessageDialog(null, "Account Created");
			int input = JOptionPane.showConfirmDialog(null, "Do you want to LOGIN now ?");
			if (input == 0) {
				loginForm lf = new loginForm();
				lf.setVisible(true);
			} else if (input == 1) {
				JOptionPane.showMessageDialog(null, "Thanks For Registration, Hope to see you soon");
				System.exit(0);
			} else if (input == 2) {
				System.exit(0);
			}
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}
}
