package User_InterfaceE;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Random;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private String Muname;
	private long counter ;
	
	private JFrame frmBetterJadeSystem;
	private JTextField usernameTextFieldL;
	private JPasswordField passwordFieldL;
	private DAO dao;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmBetterJadeSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		try {
			dao = new DAO(Muname, counter);			
			
			System.out.println(counter);
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		frmBetterJadeSystem = new JFrame();
		frmBetterJadeSystem.setResizable(false);
		frmBetterJadeSystem.setBackground(new Color(105, 105, 105));
		frmBetterJadeSystem.setForeground(new Color(105, 105, 105));
		frmBetterJadeSystem.getContentPane().setBackground(new Color(105, 105, 105));
		frmBetterJadeSystem.setTitle("Lee-Hu Pastry");
		frmBetterJadeSystem.setBounds(100, 100, 450, 360);
		frmBetterJadeSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBetterJadeSystem.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(374, 256, 70, 76);
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg));
		frmBetterJadeSystem.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("李鵠餅店 好吃到讓你驚艷！");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Lucida Grande", Font.ITALIC, 26));
		label_1.setBounds(77, 24, 323, 31);
		frmBetterJadeSystem.getContentPane().add(label_1);
			
		JLabel label_2 = new JLabel("帳號：");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_2.setBounds(107, 119, 70, 31);
		frmBetterJadeSystem.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("密碼：");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_3.setBounds(107, 162, 70, 31);
		frmBetterJadeSystem.getContentPane().add(label_3);
		
		usernameTextFieldL = new JTextField();
		usernameTextFieldL.setBounds(168, 123, 171, 26);
		frmBetterJadeSystem.getContentPane().add(usernameTextFieldL);
		usernameTextFieldL.setColumns(10);
		
		passwordFieldL = new JPasswordField();
		passwordFieldL.setBounds(168, 166, 171, 26);
		frmBetterJadeSystem.getContentPane().add(passwordFieldL);
		
		JButton button = new JButton("註冊");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBetterJadeSystem.dispose();
				Register1 R = new Register1(Muname, counter);
				R.main(null);
			}
		});
		button.setBounds(168, 204, 70, 29);
		frmBetterJadeSystem.getContentPane().add(button);
		
		JButton button_1 = new JButton("登入");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = usernameTextFieldL.getText();
				String password = String.valueOf(passwordFieldL.getPassword());
				
				Muname = dao.SearchAndGetSSN(uname);
				String Mpassword = dao.SearchAndGetPassword(uname);
				
				System.out.println(Mpassword);
				System.out.println(Muname);
				System.out.println(uname);
				System.out.println(password);

				if (uname != null || password != null){
				
				if (uname.equals(Muname) && password.equals(Mpassword)){
					
					JOptionPane.showMessageDialog(null, "歡迎 " + dao.getUsername(Muname) + " 使用本系統！");
					
					Date date = new Date();
					counter = date.getTime();
										
					frmBetterJadeSystem.dispose();
					Home P = new Home(Muname, counter);
					P.main(null);

					
				} else {
					JOptionPane.showMessageDialog(null, "帳號或密碼錯誤！");
				} 
				
				} else {
					JOptionPane.showMessageDialog(null, "帳號或密碼錯誤！");

				}
			}
		});
		button_1.setBounds(269, 204, 70, 29);
		frmBetterJadeSystem.getContentPane().add(button_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setBounds(30, 123, 65, 65);
		Image Loginimg = new ImageIcon(this.getClass().getResource("/Lock.png")).getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT);
		label_4.setIcon(new ImageIcon(Loginimg));
		frmBetterJadeSystem.getContentPane().add(label_4);
		
		JButton button_2 = new JButton("我是店家");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBetterJadeSystem.dispose();
				
				ConnectTo C = new ConnectTo();
				
				C.main(null);
				
			}
		});
		button_2.setBounds(16, 303, 117, 29);
		frmBetterJadeSystem.getContentPane().add(button_2);

	}
}
