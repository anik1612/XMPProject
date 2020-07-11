package XMPP;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class loginForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon img;
	private JTextField username;
	Font font1 = new Font("SansSerif", Font.BOLD, 15);
	private JPasswordField password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 329);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Frame-Icon
		img = new ImageIcon("C:\\Users\\aniks\\OneDrive\\Desktop\\Desktop\\git\\XMPPProject\\XMPPProject\\src\\XMPP\\image\\m-icon.png");
		setIconImage(img.getImage());
		setTitle("KAT-CHAT Login");
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(29, 36, 114, 44);
		contentPane.add(lblNewLabel);

		username = new JTextField();
		username.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		username.setBounds(155, 41, 300, 39);
		contentPane.add(username);
		username.setColumns(10);
		username.setFont(font1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblPassword.setBackground(Color.GRAY);
		lblPassword.setBounds(29, 93, 114, 42);
		contentPane.add(lblPassword);

		JButton login = new JButton("Login");
		login.setForeground(Color.WHITE);
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(username.getText() != null && username.getText().equals("") || password.getText() != null && password.getText().equals(""))
				{
				        JOptionPane.showMessageDialog(null, "This field Cannot be blank");
				}
				else
				{
					getConnection getcon = new getConnection();
					getcon.getconnection(username.getText(), password.getText());
					dispose();
					buddyList bl = new buddyList();
					bl.setVisible(true);	
				}
				
			}
		});
		login.setFocusPainted(false);
		login.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		login.setBackground(new Color(0, 153, 51));
		login.setBounds(314, 190, 143, 44);
		contentPane.add(login);

		JButton register = new JButton("Register");
		register.setForeground(Color.WHITE);
		register.setFocusPainted(false);
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		register.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				registerForm regisform = new registerForm();
				regisform.setVisible(true);
			}
		});
		register.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		register.setBackground(new Color(102, 153, 153));
		register.setBounds(155, 190, 137, 44);
		contentPane.add(register);

		password = new JPasswordField();
		password.setBounds(155, 95, 300, 41);
		password.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		password.setFont(font1);
		contentPane.add(password);
		
		JCheckBox checkBox = new JCheckBox("Show Password");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					password.setEchoChar((char)0);
				   } else {
					password.setEchoChar('*');
				   }
				}
		});
		
		checkBox.setBounds(336, 145, 119, 25);
		checkBox.setFocusPainted(false);
		contentPane.add(checkBox);
		
		JLabel hyperlink = new JLabel(" Click Here For KAT-CHAT Web-Registration");
		hyperlink.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		hyperlink.setForeground(Color.WHITE);
		
		hyperlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("http://desktop-as1612:9090/plugins/registration/sign-up.jsp"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});

        hyperlink.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 102, 51)));
		hyperlink.setBounds(155, 247, 300, 22);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hyperlink);
		
	}
}
