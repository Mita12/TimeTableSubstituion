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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class getID extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public int days(String n)
	{
		if(n.equalsIgnoreCase("monday"))
			return(1);
		else if(n.equalsIgnoreCase("tuesday"))
			return(2);
		else if(n.equalsIgnoreCase("wednesday"))
			return(3);
		else if(n.equalsIgnoreCase("thurssday"))
			return(4);
		else if(n.equalsIgnoreCase("friday"))
			return(5);
		return(0);
		
        
			}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getID frame = new getID();
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
	public getID() {
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
		
		JLabel lblEnterIdOf = new JLabel("Enter ID of the teacher who is absent");
		lblEnterIdOf.setForeground(Color.WHITE);
		lblEnterIdOf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterIdOf.setBounds(100, 106, 343, 33);
		panel_1.add(lblEnterIdOf);
		
		textField = new JTextField();
		textField.setBounds(107, 149, 336, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnAllotSubstitution = new JButton("Allot Substitution");
		btnAllotSubstitution.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
                Statement stmt=con.createStatement();
               String sql="SELECT * FROM staff";
               ResultSet n=stmt.executeQuery(sql);
                   Date now = new Date();
                   SimpleDateFormat dt= new SimpleDateFormat("EEEE");
                   String s=dt.format(now);
                   int dayOfWeek=days(s);
               ResultSet rs=stmt.executeQuery("select * from absent where date='"+now+"' AND idabsent='"+textField.getText()+"'");
               if(rs.next())
               {
            	   JOptionPane.showMessageDialog(null, "Already alloted");
            	   
               }
               else
               {  ArrayList<String> arr = new ArrayList<String>();
            	   ResultSet r=stmt.executeQuery("select * from id"+textField.getText()+" where day='"+dayOfWeek+"'");
            	   while (r.next()) {
            		   arr.add(r.getString(1));
            	   }
            	  for(int j=0;j<=6;j++)
            	  {
            		  if(arr.get(j)=="f")
            			  continue;
            		  else
            		  {   
            			  
            			  ResultSet rs1=stmt.executeQuery("select * from substitution order by no_of_times");
            			 
            			  ResultSet rs2=stmt.executeQuery("select id from substitution");
            			  rs2.next();
            			  String a=(rs2.getString(1));
            			  ArrayList<String> arr1 = new ArrayList<String>();
            			  ResultSet rs3=stmt.executeQuery("select * from id"+a+" where day='"+dayOfWeek+"'");
            			 while (rs3.next()) {
            				 
                   		   arr.add(rs3.getString(1));
                   	   }
            			   if(arr1.get(j)=="f" && !(a.equals(textField.getText())))
                    		  {
            				    ResultSet rs4=stmt.executeQuery("SELECT no_of_times FROM  substitution where id="+a);
            				    rs4.next();
            				    String n1=rs4.getString(1);
            				    int n2=(Integer.parseInt(n1))+1;
            				    String sql1="update substitution set no_of_times="+n2+" where id="+a;
            				    stmt.executeUpdate(sql1);
            				    ResultSet rs5=stmt.executeQuery("select * from substitution order by no_of_times");
            				    
                    		  }
                    			  
             			 
            		  }
            	  }
           }
              	con.close();
				}catch(Exception e)
				{
				System.out.print(e);
				}
			
			}});
		btnAllotSubstitution.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAllotSubstitution.setBounds(180, 225, 196, 33);
		panel_1.add(btnAllotSubstitution);
	}}


