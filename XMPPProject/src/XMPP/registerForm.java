package XMPP;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registerForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField rePassword;
	private JTextField fullName;
	private JTextField email;

	/**
	 * Create the frame.
	 */
	public registerForm() {
		setTitle("Registration Form For KAT-CHAT");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 451);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon img = new ImageIcon("C:\\Users\\aniks\\OneDrive\\Desktop\\Desktop\\git\\XMPPProject\\XMPPProject\\src\\XMPP\\image\\m-icon.png");
		setIconImage(img.getImage());
		
		JLabel label = new JLabel("Username");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label.setBackground(Color.GRAY);
		label.setBounds(25, 13, 114, 44);
		contentPane.add(label);
		
		username = new JTextField();
		username.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		username.setFont(new Font("SansSerif", Font.BOLD, 15));
		username.setColumns(10);
		username.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		username.setBounds(151, 18, 300, 39);
		contentPane.add(username);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(Color.BLACK);
		lblFullName.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblFullName.setBackground(Color.GRAY);
		lblFullName.setBounds(25, 70, 114, 42);
		contentPane.add(lblFullName);
		
		JLabel lblReenterPassword = new JLabel("Password");
		lblReenterPassword.setForeground(Color.BLACK);
		lblReenterPassword.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblReenterPassword.setBackground(Color.GRAY);
		lblReenterPassword.setBounds(25, 125, 114, 44);
		contentPane.add(lblReenterPassword);
		
		JLabel lblEmail = new JLabel("Re-enter");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblEmail.setBackground(Color.GRAY);
		lblEmail.setBounds(25, 174, 114, 44);
		contentPane.add(lblEmail);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(25, 255, 114, 44);
		contentPane.add(label_2);
		
		password = new JPasswordField();
		password.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		password.setFont(new Font("SansSerif", Font.BOLD, 15));
		password.setBounds(151, 124, 300, 39);
		contentPane.add(password);
		
		rePassword = new JPasswordField();
		rePassword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		rePassword.setFont(new Font("SansSerif", Font.BOLD, 15));
		rePassword.setBounds(151, 174, 300, 39);
		contentPane.add(rePassword);
		
		JLabel passcheckertext = new JLabel(" ");
		passcheckertext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				password.setEchoChar((char)0);
				rePassword.setEchoChar((char)0);
			}
		});
		passcheckertext.setForeground(Color.WHITE);
		passcheckertext.setBackground(Color.WHITE);
		passcheckertext.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		passcheckertext.setBounds(111, 220, 340, 32);
		contentPane.add(passcheckertext);
		
		JButton submit = new JButton("Submit");
		submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(password.equals(rePassword)) {
					getConnection getcon = new getConnection();
					getcon.register(username.getText(), password.getText(), email.getText(), fullName.getText());
					dispose();
				}else {
					passcheckertext.setText("Password Mismatch! Click here to show Password");
					passcheckertext.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 102, 51)));
					passcheckertext.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		submit.setFocusPainted(false);
		submit.setBackground(new Color(0, 153, 51));
		submit.setBounds(308, 312, 143, 44);
		contentPane.add(submit);
		
		JButton clear = new JButton("Clear");
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText(null);
				fullName.setText(null);
				password.setText(null);
				rePassword.setText(null);
				email.setText(null);
			}
		});
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		clear.setFocusPainted(false);
		clear.setBackground(new Color(165, 42, 42));
		clear.setBounds(151, 312, 143, 44);
		contentPane.add(clear);
		
		fullName = new JTextField();
		fullName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		fullName.setFont(new Font("SansSerif", Font.BOLD, 15));
		fullName.setColumns(10);
		fullName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		fullName.setBounds(151, 70, 300, 39);
		contentPane.add(fullName);
		
		email = new JTextField();
		email.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		email.setFont(new Font("SansSerif", Font.BOLD, 15));
		email.setColumns(10);
		email.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		email.setBounds(151, 260, 300, 39);
		contentPane.add(email);
		
		JLabel gobacklogin = new JLabel(" Click here for go back to LOGIN Form ");
		gobacklogin.setForeground(Color.WHITE);
		gobacklogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gobacklogin.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		gobacklogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 102, 51)));
		gobacklogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gobacklogin.setBounds(193, 369, 258, 26);
		contentPane.add(gobacklogin);
	}
}
