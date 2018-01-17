
package User_InterfaceE;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	
	private String Muname;
	private long counter;
	private Customer previousCustomer = null;
	private boolean updateMode = false;
	public boolean KKK = false;
	
	private DAO dao;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblNewLabel;
	private JLabel label_6;
	private JLabel label_8;
	private JButton button_3;
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Home frame = new Home();
//					frame.setVisible(true);
					
					Home newframe = new Home(Muname, counter);
					newframe.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Home(String Muname, long counter) {
		setTitle("Lee-Hu Pastry");
		
		try {
			dao = new DAO(Muname, counter);
			
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from Home");
			System.out.println(counter + " from Home");
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("早安！");
		label.setForeground(new Color(255, 255, 255));
		Image Logoimg4 = new ImageIcon(this.getClass().getResource("/sun.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg4));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label.setBounds(48, 14, 156, 29);
		contentPane.add(label);
		
		label_2 = new JLabel("");
		label_2.setBounds(133, 237, 180, 200);
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
		label_2.setIcon(new ImageIcon(Logoimg));
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(537, 247, 156, 200);
		Image Listimg = new ImageIcon(this.getClass().getResource("/List.png")).getImage().getScaledInstance(145, 145, Image.SCALE_DEFAULT);
		label_3.setIcon(new ImageIcon(Listimg));
		contentPane.add(label_3);
		
		button = new JButton("修改會員資料");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				dispose();
				
				UpdateCustomer U = new UpdateCustomer(Muname, counter, previousCustomer, updateMode);
				
				U.main(null);
				
			}
		});
		button.setBounds(657, 13, 117, 29);
		contentPane.add(button);
		
		label_4 = new JLabel("關於我們");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		label_4.setBounds(133, 119, 231, 120);
		contentPane.add(label_4);
		
		label_5 = new JLabel("產品目錄");
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		label_5.setBounds(515, 119, 231, 120);
		contentPane.add(label_5);
		
		button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				Product1 P = new Product1(Muname, counter);
				P.setVisible(true);
				P.main(null);
				
				dispose();
			}
		});
		button_2.setBounds(424, 76, 346, 396);
		contentPane.add(button_2);	
		
		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				About about = new About(Muname, counter);
				about.main(null);
			}
		});
		button_1.setBounds(48, 76, 346, 396);
		contentPane.add(button_1);
		
		label_6 = new JLabel("");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setText(dao.getUsername(Muname));
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_6.setBounds(147, 14, 154, 29);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("本次消費的訂單編號為：");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_7.setBounds(273, 18, 198, 25);
		contentPane.add(label_7);
		
		label_8 = new JLabel((String) null);
		label_8.setForeground(new Color(255, 255, 255));
		String theCounter = "#" + counter;
		label_8.setText(theCounter);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_8.setBounds(475, 14, 180, 29);
		contentPane.add(label_8);
		
		button_3 = new JButton("登出");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "謝謝光臨！");
				
				dispose();
				
				Login l = new Login();
				l.main(null);
			}
		});
		button_3.setBounds(699, 35, 75, 29);
		contentPane.add(button_3);
}
}
