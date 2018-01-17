package User_InterfaceE;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class About extends JFrame {

	private JPanel contentPane;
	private String Muname;
	private long counter;
	private DAO dao;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About(Muname, counter);
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
	public About(String Muname, long counter) {
		
		try {
			dao = new DAO(Muname, counter);
			
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from Home");
			System.out.println(counter + " from Home");
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		setTitle("Lee-Hu Pastry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("—  一個更便捷、快速的交易平台");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 22));
		lblNewLabel.setBounds(123, 38, 346, 77);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("”");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Lucida Grande", Font.ITALIC, 35));
		label.setBounds(446, 31, 49, 82);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(39, 31, 61, 16);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("鬱鬱寡歡 之 我們在憂「玉」");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(25, 19, 427, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(425, 239, 70, 70);
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		label_2.setIcon(new ImageIcon(Logoimg));
		contentPane.add(label_2);
		
		JLabel lblNewLabel_2 = new JLabel("「君子溫潤如玉」，君子雖然成竹在胸、謙謙度日，卻也有「寧可");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(16, 101, 453, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_3 = new JLabel("玉碎、不為瓦全」的磊落。如玉莊為眾君子提供各式美玉、光澤鮮明");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_3.setBounds(16, 127, 453, 34);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("、價格公道，現在更推出業界首創「我們在憂玉」系統，我們憂慮顧");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_4.setBounds(16, 156, 453, 34);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("客們的消費品質，創造一個更便捷，更快速的交易平台。只需動動手");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_5.setBounds(16, 184, 453, 34);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("指，就能獲得全面資訊，再也不必煩惱訊息落後或交易繁瑣");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_6.setBounds(16, 215, 397, 34);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("的問題。現在就開始您的選購吧！\n");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_7.setBounds(16, 248, 397, 34);
		contentPane.add(label_7);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Home home = new Home(Muname, counter);
				home.main(null);
			}
		});
		button.setBounds(338, 280, 75, 29);
		contentPane.add(button);
	}
}
