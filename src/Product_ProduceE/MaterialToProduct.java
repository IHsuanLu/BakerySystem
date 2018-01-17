package Product_ProduceE;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import User_InterfaceE.*;

public class MaterialToProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private DAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaterialToProduct frame = new MaterialToProduct();
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
	public MaterialToProduct() {
		
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setTitle("Lee-Hu Pastry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("糕餅製作");
		label.setForeground(new Color(255, 255, 255));
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		label.setBounds(6, 6, 171, 39);
		contentPane.add(label);
		
		JButton button = new JButton("");
		Image Pineappleimg = new ImageIcon(this.getClass().getResource("/鳳梨酥.jpg")).getImage().getScaledInstance(170, 150, Image.SCALE_DEFAULT);
		button.setIcon(new ImageIcon(Pineappleimg));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				PineappleMaterials pm = new PineappleMaterials();
				pm.main(null);
			}
		});
		button.setBounds(42, 87, 170, 150);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MungBeanMaterials mm = new MungBeanMaterials();
				mm.main(null);
			}
		});
		Image Greenimg = new ImageIcon(this.getClass().getResource("/綠豆椪.jpg")).getImage().getScaledInstance(170, 150, Image.SCALE_DEFAULT);
		button_1.setIcon(new ImageIcon(Greenimg));
		button_1.setBounds(251, 87, 170, 150);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				CurryMaterials cm = new CurryMaterials();
				cm.main(null);
			}
		});
		Image Curryimg = new ImageIcon(this.getClass().getResource("/咖哩酥.jpg")).getImage().getScaledInstance(170, 150, Image.SCALE_DEFAULT);
		button_2.setIcon(new ImageIcon(Curryimg));
		button_2.setBounds(42, 328, 170, 150);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				YolkMaterials ym = new YolkMaterials();
				ym.main(null);
			}
		});
		Image Yolkimg = new ImageIcon(this.getClass().getResource("/蛋黃酥.jpeg")).getImage().getScaledInstance(170, 150, Image.SCALE_DEFAULT);
		button_3.setIcon(new ImageIcon(Yolkimg));
		button_3.setBounds(251, 328, 170, 150);
		contentPane.add(button_3);
		
		JLabel label_1 = new JLabel("(*點擊照片進入轉換頁面)");
		label_1.setForeground(new Color(240, 128, 128));
		label_1.setBounds(164, 21, 150, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("鳳梨酥");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(43, 60, 59, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("綠豆椪");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_3.setBounds(251, 60, 59, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("咖哩酥");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_4.setBounds(42, 300, 59, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("蛋黃酥");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_5.setBounds(251, 300, 59, 25);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("庫存剩餘：");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_6.setBounds(43, 241, 75, 25);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("庫存剩餘：");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_7.setBounds(251, 241, 75, 25);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("庫存剩餘：");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_8.setBounds(42, 483, 75, 25);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("庫存剩餘：");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_9.setBounds(251, 483, 75, 25);
		contentPane.add(label_9);
		
		textField = new JTextField();
		textField.setBackground(new Color(105, 105, 105));
		textField.setForeground(new Color(255, 255, 255));
		textField.setText(Integer.toString((int)dao.getPineappleQty()));
		textField.setEditable(false);
		textField.setBounds(118, 241, 75, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(105, 105, 105));
		textField_1.setText(Integer.toString((int)dao.getMungBeanQty()));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(326, 241, 75, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(105, 105, 105));
		textField_2.setText(Integer.toString((int)dao.getYolkQty()));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(326, 483, 75, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(105, 105, 105));
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setText(Integer.toString((int)dao.getCurryQty()));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(117, 483, 75, 26);
		contentPane.add(textField_3);
		
		JLabel label_10 = new JLabel("個");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_10.setBounds(197, 241, 15, 25);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("個");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_11.setBounds(406, 241, 15, 25);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("個");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_12.setBounds(406, 483, 15, 25);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("個");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_13.setBounds(197, 483, 15, 25);
		contentPane.add(label_13);
		
		JButton H1 = new JButton("");	
		H1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				SupplyHome sh = new SupplyHome();
				sh.main(null);
			}
		});
		
		H1.setBounds(398, 6, 60, 60);
		Image Himg2 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		H1.setIcon(new ImageIcon(Himg2));
		contentPane.add(H1);
	}

}
