package admin;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class AdminApp extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminApp frame = new AdminApp();
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
	public AdminApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 0, 401, 355);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(401, 0, 552, 355);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(197, 10, 154, 43);
		panel_1.add(lblWelcome);
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(67, 78, 108, 29);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(67, 154, 108, 37);
		panel_1.add(lblPassword);
		
		user = new JTextField();
		user.setBounds(77, 107, 320, 37);
		panel_1.add(user);
		user.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(77, 184, 320, 37);
		panel_1.add(pwdPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
                Statement stmt=con.createStatement();
                String sql="Select * from login where username='"+user.getText()+"' and password='"+pwdPassword.getText().toString()+"'";
                ResultSet rs=stmt.executeQuery(sql);
            	if(rs.next()) {
				Option op=new Option();
				op.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect username and password...try again");
					con.close();
				}
			}catch(Exception e)
				{
				System.out.print(e);
				}
			}});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(178, 250, 133, 37);
		panel_1.add(btnSubmit);
	
	}}
