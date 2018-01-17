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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Register1 extends JFrame {

	private JPanel contentPane;
	
	private String Muname;
	private long counter;

	private JFrame frmBetterJadeSystem;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JPasswordField passwordCheck;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTextField telTextField;
	private DAO dao;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register1 frame = new Register1(Muname, counter);
					frame.frmBetterJadeSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register1(String Muname, long counter) {
		try {
			dao = new DAO(Muname, counter);
			
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from register");
			System.out.println(counter + " from register");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		frmBetterJadeSystem = new JFrame();
		frmBetterJadeSystem.getContentPane().setForeground(new Color(255, 255, 255));
		frmBetterJadeSystem.getContentPane().setBackground(new Color(105, 105, 105));
		frmBetterJadeSystem.setTitle("Lee-Hu Pastry");
		frmBetterJadeSystem.setBounds(100, 100, 450, 380);
		frmBetterJadeSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBetterJadeSystem.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(389, 297, 55, 55);
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg));
		frmBetterJadeSystem.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("會員註冊");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setBounds(19, 18, 172, 40);
		Image Reimg = new ImageIcon(this.getClass().getResource("/Members.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		label_1.setIcon(new ImageIcon(Reimg));
		frmBetterJadeSystem.getContentPane().add(label_1);
		
		JLabel lblssn = new JLabel("帳號 (Ssn 後九碼)：");
		lblssn.setForeground(new Color(255, 255, 255));
		lblssn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblssn.setBounds(46, 70, 162, 22);
		frmBetterJadeSystem.getContentPane().add(lblssn);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(212, 70, 184, 26);
		frmBetterJadeSystem.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("密碼：");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_3.setBounds(46, 106, 82, 22);
		frmBetterJadeSystem.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("密碼確認：");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_4.setBounds(46, 142, 103, 22);
		frmBetterJadeSystem.getContentPane().add(label_4);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(145, 106, 184, 26);
		frmBetterJadeSystem.getContentPane().add(passwordTextField);
		
		passwordCheck = new JPasswordField();
		passwordCheck.setBounds(145, 142, 184, 26);
		frmBetterJadeSystem.getContentPane().add(passwordCheck);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_2.setBounds(46, 176, 103, 22);
		frmBetterJadeSystem.getContentPane().add(label_2);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(145, 176, 184, 26);
		frmBetterJadeSystem.getContentPane().add(nameTextField);
		
		JLabel label_5 = new JLabel("地址：");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_5.setBounds(45, 244, 103, 22);
		frmBetterJadeSystem.getContentPane().add(label_5);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(144, 244, 283, 26);
		frmBetterJadeSystem.getContentPane().add(addressTextField);
		
		JLabel lblEmail = new JLabel("e-mail：");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblEmail.setBounds(45, 278, 103, 22);
		frmBetterJadeSystem.getContentPane().add(lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(144, 278, 217, 26);
		frmBetterJadeSystem.getContentPane().add(emailTextField);
		
		JButton button = new JButton("送出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
															//這邊的getPassword不是Customer裡面的getter
				String Fp = String.valueOf(passwordTextField.getPassword());
				String Lp = String.valueOf(passwordCheck.getPassword());
				
				String userName = usernameTextField.getText();
				String U = dao.SearchAndGetSSN(userName);
				
				try{
					
					if(userName.length() == 9) {
						if(Fp.equals(Lp)){
						
							System.out.println(userName + "TEST");	
							System.out.println(U + "TEST");

						
							if(userName.equals(U)){
							
								JOptionPane.showMessageDialog(null, "此帳號已被申請");
							
							} else {
							
								saveCustomer();
								Login L = new Login();
								L.main(null);
							}
						} else {
							JOptionPane.showMessageDialog(null, "輸入的兩組密碼不一致！");
							passwordTextField.setText(null);
							passwordCheck.setText(null);
						} 
					} else {
						JOptionPane.showMessageDialog(null, "請輸入身分證字號後9碼");
						usernameTextField.setText(null);
					}

				}catch(Exception exc){
					exc.printStackTrace();
				}
			}
		});
		button.setBounds(280, 323, 82, 29);
		frmBetterJadeSystem.getContentPane().add(button);
		
		JLabel label_6 = new JLabel("電話：");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_6.setBounds(46, 210, 103, 22);
		frmBetterJadeSystem.getContentPane().add(label_6);
		
		telTextField = new JTextField();
		telTextField.setColumns(10);
		telTextField.setBounds(144, 210, 184, 26);
		frmBetterJadeSystem.getContentPane().add(telTextField);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBetterJadeSystem.dispose();
				Login L = new Login();
				L.main(null);
			}
		});
		button_1.setBounds(19, 323, 82, 29);
		frmBetterJadeSystem.getContentPane().add(button_1);
	}

	protected void saveCustomer() {
	
		// get the employee info from GUI
		String cus_ssn = usernameTextField.getText();
		String cus_name = nameTextField.getText();
		String cus_tel = telTextField.getText();
		String address = addressTextField.getText();
		String email = emailTextField.getText();
		String password = String.valueOf(passwordTextField.getPassword());
		
		// get完值，要create一個employee object，把值都放進去
		Customer customerobj = new Customer(cus_ssn, cus_name, cus_tel, address, email, password);
		
		
		try {
			// save to the database
			dao.addCustomer(customerobj);
			
			// close dialog
			frmBetterJadeSystem.setVisible(false);
			frmBetterJadeSystem.dispose();
			
			// refresh GUI ?
		
			// show success message 
			JOptionPane.showMessageDialog(null, "註冊成功！");
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
		
		
	}


}
