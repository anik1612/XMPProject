package XMPP;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;

public class buddyList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon img;
	XMPPConnection connection;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					buddyList frame = new buddyList();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public buddyList() {
		setTitle("Buddy List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 581);
		
		//apps icon
		img = new ImageIcon("C:\\Users\\aniks\\OneDrive\\Desktop\\Desktop\\git\\XMPPProject\\XMPPProject\\src\\XMPP\\image\\m-icon.png");
		setIconImage(img.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu buddiesMenu = new JMenu("Buddies");
		buddiesMenu.setHorizontalAlignment(SwingConstants.LEFT);
		buddiesMenu.setBackground(SystemColor.controlLtHighlight);
		buddiesMenu.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		menuBar.add(buddiesMenu);
		
		JMenuItem addBuddies = new JMenuItem("Add Buddies/Friends");
		addBuddies.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		addBuddies.setBackground(Color.WHITE);
		buddiesMenu.add(addBuddies);
		
		JMenuItem addChat = new JMenuItem("Add Chat");
		addChat.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		buddiesMenu.add(addChat);
		
		JMenuItem addGroup = new JMenuItem("Add Group");
		addGroup.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		buddiesMenu.add(addGroup);
		
		JMenuItem searchBuddies = new JMenuItem("Search Buddies/Friends");
		searchBuddies.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		buddiesMenu.add(searchBuddies);
		
		JMenuItem sendIM = new JMenuItem("Send Instant Message");
		sendIM.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		buddiesMenu.add(sendIM);
		
		JMenu accountMenu = new JMenu("Account");
		accountMenu.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		menuBar.add(accountMenu);
		
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		menuBar.add(toolsMenu);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		menuBar.add(helpMenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getConnection getcon = new getConnection();
		Roster roster = getcon.connection.getRoster();
		Collection<RosterEntry> entries = roster.getEntries();
		Presence presence;

		for(RosterEntry entry : entries) {
		    presence = roster.getPresence(entry.getUser());

		    System.out.println(entry.getUser());
		    System.out.println(presence.getType().name());
		    System.out.println(presence.getStatus());
		}
	}
}
