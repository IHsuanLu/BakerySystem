package Customer_ManagementE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hot extends JFrame {

	private JPanel contentPane;
	private hotDAO hotDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hot frame = new Hot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	DefaultListModel<String> x1 = new DefaultListModel<>(); 
	
	DefaultListModel<String> x2 = new DefaultListModel<>(); 
	
	DefaultListModel<String> x3 = new DefaultListModel<>(); 
	
	DefaultListModel<String> x4 = new DefaultListModel<>(); 

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Hot() throws Exception {
		setTitle("Lee-Hu  Pastry");
		hotDAO = new hotDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("熱門商品");
		Image Fimg = new ImageIcon(this.getClass().getResource("/hot.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(Fimg));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 6, 172, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("綠豆椪");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 86, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("鳳梨酥");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label.setBounds(50, 128, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("蛋黃酥");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_1.setBounds(50, 173, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("咖哩酥");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_2.setBounds(50, 215, 61, 16);
		contentPane.add(label_2);
		
		JList list = new JList(x1);
		x1.addElement(hotDAO.getBean().get(0));
		list.setBounds(139, 88, 80, 16);
		contentPane.add(list);
		
		JList list_1 = new JList(x2);
		x2.addElement(hotDAO.getPine().get(0));
		list_1.setBounds(139, 130, 80, 16);
		contentPane.add(list_1);
		
		JList list_2 = new JList(x3);
		x3.addElement(hotDAO.getYolk().get(0));
		list_2.setBounds(139, 175, 80, 16);
		contentPane.add(list_2);
		
		JList list_3 = new JList(x4);
		x4.addElement(hotDAO.getCurry().get(0));
		list_3.setBounds(139, 217, 80, 16);
		contentPane.add(list_3);
		
		JLabel lblNewLabel_2 = new JLabel("銷售數量");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(150, 60, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(219, 252, 80, 29);
		contentPane.add(button);
	}
}
