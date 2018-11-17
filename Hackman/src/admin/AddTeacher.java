package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class AddTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField IDEnter;
	private JTextField nameEnter;
	private JTextField deptEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
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
	public AddTeacher() {
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
		
		JLabel lblEnterDetailsOf = new JLabel("Enter details of the teacher");
		lblEnterDetailsOf.setForeground(Color.WHITE);
		lblEnterDetailsOf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEnterDetailsOf.setBounds(133, 23, 349, 35);
		panel_1.add(lblEnterDetailsOf);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(80, 55, 34, 23);
		panel_1.add(lblId);
		
		IDEnter = new JTextField();
		IDEnter.setBounds(80, 83, 331, 35);
		panel_1.add(IDEnter);
		IDEnter.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName.setBounds(80, 128, 93, 23);
		panel_1.add(lblName);
		
		nameEnter = new JTextField();
		nameEnter.setBounds(80, 150, 331, 35);
		panel_1.add(nameEnter);
		nameEnter.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDepartment.setBounds(80, 195, 115, 23);
		panel_1.add(lblDepartment);
		
		deptEnter = new JTextField();
		deptEnter.setBounds(80, 219, 331, 35);
		panel_1.add(deptEnter);
		deptEnter.setColumns(10);
		
		JCheckBox threeA = new JCheckBox("3A");
		threeA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		threeA.setBounds(80, 273, 56, 21);
		panel_1.add(threeA);
		
		JCheckBox threeB = new JCheckBox("3B");
		threeB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		threeB.setBounds(181, 273, 47, 21);
		panel_1.add(threeB);
		
		JCheckBox fiveA = new JCheckBox("5A");
		fiveA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		fiveA.setBounds(269, 273, 47, 21);
		panel_1.add(fiveA);
		
		JCheckBox fiveB = new JCheckBox("5B");
		fiveB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		fiveB.setBounds(350, 273, 47, 21);
		panel_1.add(fiveB);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSubmit.setBounds(181, 311, 130, 34);
		panel_1.add(btnSubmit);
	}
}
