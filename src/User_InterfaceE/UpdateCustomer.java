package User_InterfaceE;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class UpdateCustomer extends JFrame {

	public String Muname;
	private long counter;
	
	private JFrame frame;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField nameTextField;
	private JTextField telTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	
	private DAO dao;
	private Home home;
	private Customer previousCustomer = null;
	private boolean updateMode = false;

	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer(Muname, counter, previousCustomer, updateMode);
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateCustomer(String Muname, long counter, Customer previousCustomer, boolean updateMode) {
		try {
			
			dao = new DAO(Muname, counter);
				
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from updateCustomer");
			System.out.println(counter + " from updateCustomer");
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.setBounds(100, 100, 450, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(389, 271, 55, 55);
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("修改會員資料");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setBounds(19, 18, 172, 40);
		Image Reimg = new ImageIcon(this.getClass().getResource("/Edit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		label_1.setIcon(new ImageIcon(Reimg));
		frame.getContentPane().add(label_1);
		
		JLabel lblssn = new JLabel("帳號 (不得更改)：");
		lblssn.setForeground(new Color(255, 255, 255));
		lblssn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblssn.setBounds(46, 82, 145, 22);
		frame.getContentPane().add(lblssn);
		
		JLabel label_3 = new JLabel("密碼：");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_3.setBounds(46, 118, 82, 22);
		frame.getContentPane().add(label_3);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_2.setBounds(46, 152, 103, 22);
		frame.getContentPane().add(label_2);
		
		JLabel label_5 = new JLabel("地址：");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_5.setBounds(46, 220, 103, 22);
		frame.getContentPane().add(label_5);
		
		JLabel lblEmail = new JLabel("e-mail：");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblEmail.setBounds(46, 254, 103, 22);
		frame.getContentPane().add(lblEmail);
		
		JButton button = new JButton("送出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCustomer();
				frame.dispose();
				
				Home home = new Home(Muname, counter);
				home.main(null);
			}
		});
		button.setBounds(281, 297, 82, 29);
		frame.getContentPane().add(button);
		
		JLabel label_6 = new JLabel("電話：");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_6.setBounds(46, 186, 103, 22);
		frame.getContentPane().add(label_6);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				Home home = new Home(Muname, counter);
				home.main(null);
			}
		});
		button_1.setBounds(22, 297, 82, 29);
		frame.getContentPane().add(button_1);
		
		usernameTextField = new JTextField();
		usernameTextField.setText(dao.SearchAndGetSSN(Muname));
		usernameTextField.setEditable(false);
		usernameTextField.setBounds(201, 82, 201, 26);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setText(dao.SearchAndGetPassword(Muname));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(150, 118, 201, 26);
		frame.getContentPane().add(passwordTextField);
		
		nameTextField = new JTextField();
		nameTextField.setText(dao.getUsername(Muname));
		nameTextField.setColumns(10);
		nameTextField.setBounds(150, 152, 201, 26);
		frame.getContentPane().add(nameTextField);
		
		telTextField = new JTextField();
		telTextField.setText(dao.getUserTel(Muname));
		telTextField.setColumns(10);
		telTextField.setBounds(150, 186, 201, 26);
		frame.getContentPane().add(telTextField);
		
		addressTextField = new JTextField();
		addressTextField.setText(dao.getUserAddress(Muname));
		addressTextField.setColumns(10);
		addressTextField.setBounds(150, 220, 275, 26);
		frame.getContentPane().add(addressTextField);
		
		emailTextField = new JTextField();
		emailTextField.setText(dao.getUserEmail(Muname));
		emailTextField.setColumns(10);
		emailTextField.setBounds(150, 254, 201, 26);
		frame.getContentPane().add(emailTextField);
	}

	protected void saveCustomer() {
	
		// get the employee info from GUI
		String cus_ssn = usernameTextField.getText();
		String cus_name = nameTextField.getText();
		String cus_tel = telTextField.getText();
		String address = addressTextField.getText();
		String email = emailTextField.getText();
		String password = passwordTextField.getText();		

		// get完值，要create一個employee object，把值都放進去
		Customer customerobj = new Customer(cus_ssn, cus_name, cus_tel, address, email, password);		

		dao.updateCustomer(customerobj);

		
		// show success message 
		JOptionPane.showMessageDialog(null, "更改成功！");

	}

}
