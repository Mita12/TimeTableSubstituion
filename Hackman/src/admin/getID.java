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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class getID extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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
				
			}
		});
		btnAllotSubstitution.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAllotSubstitution.setBounds(180, 225, 196, 33);
		panel_1.add(btnAllotSubstitution);
	}

}
