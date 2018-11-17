package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField IDEnter;
	private JTextField nameEnter;
	private JTextField deptEnter;
	private int threea=0,threeb=0,fivea=0,fiveb=0;

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
		threeA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				threea=1;
				
			}
		});
		threeA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		threeA.setBounds(80, 273, 56, 21);
		panel_1.add(threeA);
		
		JCheckBox threeB = new JCheckBox("3B");
		threeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				threeb=1;
			}
		});
		threeB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		threeB.setBounds(181, 273, 47, 21);
		panel_1.add(threeB);
		
		JCheckBox fiveA = new JCheckBox("5A");
		fiveA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fivea=1;
			}
		});
		fiveA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		fiveA.setBounds(269, 273, 47, 21);
		panel_1.add(fiveA);
		
		JCheckBox fiveB = new JCheckBox("5B");
		fiveB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fiveb=1;
			}
		});
		fiveB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		fiveB.setBounds(350, 273, 47, 21);
		panel_1.add(fiveB);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
                Statement stmt=con.createStatement();
                String sql="insert into staff(id,name,dept,3a,3b,5a,5b) values('"+IDEnter.getText()+"','"+nameEnter.getText()+"','"+deptEnter.getText()+"','"+threea+"','"+threeb+"','"+fivea+"','"+fiveb+"')";
                stmt.executeUpdate(sql);
                String sql1="create table id"+IDEnter.getText()+"(day int, p1 varchar(20), p2 varchar(20),p3 varchar(20),p4 varchar(20),p5 varchar(20),p6 varchar(20),p7 varchar(20))";
                stmt.executeUpdate(sql1);
                for(int i=1;i<=5;i++) {
                	String sql2="insert into id"+IDEnter.getText()+"(day,p1,p2,p3,p4,p5,p6,p7) values('"+i+"','f','f','f','f','f','f','f')";
                	stmt.executeUpdate(sql2);
                }
                con.close();
                threea=0;
                threeb=0;
                fivea=0;
                fiveb=0;
                AddTeacher add=new AddTeacher();
                add.setVisible(true);
                
				}
			catch(Exception e)
				{
				System.out.print(e);
				}
			}});
			
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSubmit.setBounds(98, 311, 130, 34);
		panel_1.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Option op=new Option();
				op.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBack.setBounds(251, 311, 130, 34);
		panel_1.add(btnBack);
	}
}
