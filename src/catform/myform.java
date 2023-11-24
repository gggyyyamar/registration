package catform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class myform {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldUsName;
	private JTextField textFieldPass;
	private JTextField textFieldConPass;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myform window = new myform();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public myform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 602, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 32, 235, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(61, 130, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(61, 191, 68, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(61, 249, 68, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Confirm Password:");
		lblNewLabel_4.setBounds(61, 318, 90, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(61, 371, 68, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setBounds(61, 423, 57, 22);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(61, 492, 90, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(200, 127, 351, 22);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUsName = new JTextField();
		textFieldUsName.setBounds(200, 193, 351, 22);
		frame.getContentPane().add(textFieldUsName);
		textFieldUsName.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(200, 251, 351, 22);
		frame.getContentPane().add(textFieldPass);
		textFieldPass.setColumns(10);
		
		textFieldConPass = new JTextField();
		textFieldConPass.setBounds(200, 320, 351, 20);
		frame.getContentPane().add(textFieldConPass);
		textFieldConPass.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(200, 373, 351, 22);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(200, 425, 351, 22);
		frame.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAdd = new JTextField();
		textFieldAdd.setBounds(200, 494, 351, 20);
		frame.getContentPane().add(textFieldAdd);
		textFieldAdd.setColumns(10);
		
		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cattwo?useLegacyDatetimeCode=false", "root", "calebkamau");
					String sql="INSERT INTO registration(Name,Username,Password,Email,Phone,Address) VALUES(?,?,?,?,?,?)";
					PreparedStatement pr=con.prepareStatement(sql);
					pr.setString(1,textFieldName.getText());
					pr.setString(2,textFieldUsName.getText());
					pr.setString(3,textFieldPass.getText());
					pr.setString(4,textFieldEmail.getText());
					pr.setString(5,textFieldPhone.getText());
					pr.setString(6,textFieldAdd.getText());

				if(textFieldConPass.getText().equals(textFieldPass.getText())) {
					int count=pr.executeUpdate();
					if(count > 0) {
						JOptionPane.showMessageDialog(null,"Record added successfully");
						textFieldName.setText("");
						textFieldUsName.setText("");
						textFieldPass.setText("");
						textFieldConPass.setText("");
						textFieldEmail.setText("");
						textFieldPhone.setText("");
						textFieldAdd.setText("");
						con.close();
					} else {
						JOptionPane.showMessageDialog(null,"No Record added");
						con.close();
					}
				} else {
					JOptionPane.showMessageDialog(null, "The passwords do not match");
					}
				} catch(Exception arg0) {
						arg0.printStackTrace();
						return;
				}
			}
		});
		btnSub.setBounds(95, 575, 85, 21);
		frame.getContentPane().add(btnSub);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldUsName.setText("");
				textFieldPass.setText("");
				textFieldConPass.setText("");
				textFieldEmail.setText("");
				textFieldPhone.setText("");
				textFieldAdd.setText("");
			}
		});
		btnReset.setBounds(274, 575, 85, 21);
		frame.getContentPane().add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(452, 575, 85, 21);
		frame.getContentPane().add(btnClose);
	}
}
