package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Option extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option frame = new Option();
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
	public Option() {
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
		
		JLabel lblLoggedInSuccessfully = new JLabel("Logged In Successfully!");
		lblLoggedInSuccessfully.setForeground(Color.WHITE);
		lblLoggedInSuccessfully.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoggedInSuccessfully.setBounds(166, 26, 217, 46);
		panel_1.add(lblLoggedInSuccessfully);
		
		JButton btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddTeacher.setBounds(134, 105, 281, 35);
		panel_1.add(btnAddTeacher);
		
		JButton btnGenerateTimetable = new JButton("Generate TimeTable");
		btnGenerateTimetable.setBackground(UIManager.getColor("Button.background"));
		btnGenerateTimetable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGenerateTimetable.setBounds(134, 161, 281, 35);
		panel_1.add(btnGenerateTimetable);
		
		JButton btnAllotSubstitution = new JButton("Allot Substitution");
		btnAllotSubstitution.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getID getid=new getID();
				getid.setVisible(true);
			}
		});
		btnAllotSubstitution.setBackground(UIManager.getColor("Button.background"));
		btnAllotSubstitution.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAllotSubstitution.setBounds(134, 221, 281, 35);
		panel_1.add(btnAllotSubstitution);
		

		
		
	}
}
