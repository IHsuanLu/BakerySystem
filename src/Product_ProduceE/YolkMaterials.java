package Product_ProduceE;

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

import User_InterfaceE.DAO;
import User_InterfaceE.SupplyHome;

import java.awt.Color;

public class YolkMaterials extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	private Product_DAO dao;
	private DAO Udao;
	
	private java.util.List<String> list;
	
	private int i = 0;
	private int j ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YolkMaterials frame = new YolkMaterials();
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
	public YolkMaterials() {
		
		try {
			dao = new Product_DAO();
			Udao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setTitle("Lee-Hu Pastry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("產品結構 (蛋黃酥)");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(17, 12, 144, 22);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(388, 6, 56, 56);
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(56, 56, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("欲製作數量 (單位：盒)：");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(48, 48, 192, 22);
		contentPane.add(label_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int inner = dao.getWeightOf(String.valueOf(list.get(7)));
				int flour = dao.getWeightOf(String.valueOf(list.get(1)));
				int butter = dao.getWeightOf(String.valueOf(list.get(2)));
				int sugar = dao.getWeightOf(String.valueOf(list.get(3)));
				
				if(i*200 < inner && i*150 < flour && i*70 < butter && i*30 < sugar){
					
					if(e.getSource() == button){
						
						if(i >= 0){
							i++;
							j=i;
							textField.setText(String.valueOf(i));
							textField_1.setText(String.valueOf(i*200));
							textField_2.setText(String.valueOf(i*150));
							textField_3.setText(String.valueOf(i*70));
							textField_4.setText(String.valueOf(i*30));
							
						} else {
							JOptionPane.showMessageDialog(null, "此欄數值不得為負");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "原料不足");
				}	
			}
		});
		Image plus1 = new ImageIcon(this.getClass().getResource("/plus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		button.setIcon(new ImageIcon(plus1));
		button.setBounds(235, 49, 20, 20);
		contentPane.add(button);
		
		
		

		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(j > 0){
					j--;
					i=j;
					textField.setText(String.valueOf(j));
					textField_1.setText(String.valueOf(j*200));
					textField_2.setText(String.valueOf(j*150));
					textField_3.setText(String.valueOf(j*70));
					textField_4.setText(String.valueOf(j*30));
				}
				else{
					JOptionPane.showMessageDialog(null, "此欄數值不得為負");
				}
			}
		});
		Image plus2 = new ImageIcon(this.getClass().getResource("/minus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		button_1.setIcon(new ImageIcon(plus2));
		button_1.setBounds(303, 49, 20, 20);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("0");
		textField.setBounds(260, 46, 38, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("------------------------------------------------------");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(6, 72, 438, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("所需原料  /  剩餘原料：");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_2.setBounds(17, 92, 172, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("蛋黃餡 (200 克/盒)：");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_3.setBounds(48, 126, 154, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("麵粉 (150 克/盒)：");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_4.setBounds(48, 160, 144, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("無鹽奶油 (70 克/盒)：");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_5.setBounds(48, 184, 172, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("細砂糖 (30 克/盒)：");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_6.setBounds(48, 209, 154, 22);
		contentPane.add(label_6);
		
		JLabel lblNewLabel_2 = new JLabel("( * 生產單位為「盒」，一盒 = 十二個。)");
		lblNewLabel_2.setForeground(new Color(240, 128, 128));
		lblNewLabel_2.setBounds(17, 252, 259, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(227, 126, 85, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(227, 160, 85, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(227, 184, 85, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("0");
		textField_4.setColumns(10);
		textField_4.setBounds(227, 209, 85, 26);
		contentPane.add(textField_4);
		
		
		list = dao.getAllMaterialsNo();
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(255, 255, 255));
		textField_5.setBackground(new Color(105, 105, 105));
		textField_5.setText(String.valueOf(dao.getWeightOf(list.get(7))));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(344, 126, 85, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(255, 255, 255));
		textField_6.setBackground(new Color(105, 105, 105));
		textField_6.setText(String.valueOf(dao.getWeightOf(list.get(1))));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(344, 160, 85, 26);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(255, 255, 255));
		textField_7.setBackground(new Color(105, 105, 105));
		textField_7.setText(String.valueOf(dao.getWeightOf(list.get(2))));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(344, 184, 85, 26);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setForeground(new Color(255, 255, 255));
		textField_8.setBackground(new Color(105, 105, 105));
		textField_8.setText(String.valueOf(dao.getWeightOf(list.get(3))));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(344, 209, 85, 26);
		contentPane.add(textField_8);
		
		JLabel label_7 = new JLabel("/");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_7.setBounds(324, 127, 8, 22);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("/");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_8.setBounds(324, 165, 8, 22);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("/");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_9.setBounds(324, 189, 8, 22);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("/");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_10.setBounds(324, 214, 8, 22);
		contentPane.add(label_10);
		
		JButton button_2 = new JButton("製作");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(textField_1.getText());

				if(temp != 0){
					
					//處理庫存
					int originQty = (int)Udao.getYolkQty();
					int addedQty = Integer.parseInt(textField.getText())*12;
					originQty = originQty + addedQty;
					
					dao.setInventoryQty(originQty, "Y001");
					
					
					//處理剩餘存貨
					int innerWeight = dao.getWeightOf(list.get(7));
					int flourWeight = dao.getWeightOf(list.get(1));
					int butterWeight = dao.getWeightOf(list.get(2));
					int sugarWeight = dao.getWeightOf(list.get(3));
					
					innerWeight = innerWeight - Integer.parseInt(textField_1.getText());
					flourWeight = flourWeight - Integer.parseInt(textField_2.getText());
					butterWeight = butterWeight - Integer.parseInt(textField_3.getText());
					sugarWeight = sugarWeight - Integer.parseInt(textField_4.getText());
					
	
					dao.setMaterialWeight(innerWeight, "Y101");
					dao.setMaterialWeight(flourWeight, "G101");
					dao.setMaterialWeight(butterWeight, "G102");
					dao.setMaterialWeight(sugarWeight, "G103");
					
					
					JOptionPane.showMessageDialog(null, "已增加 " + addedQty + " 個蛋黃酥\n目前庫存： " + originQty);
					
					int response = JOptionPane.showConfirmDialog(button_2, "繼續原料轉換？");
	
					if (response == JOptionPane.YES_OPTION){
						dispose();
						MaterialToProduct mp = new MaterialToProduct();
						mp.main(null);
					} else {
						dispose();
						SupplyHome sh = new SupplyHome();
						sh.main(null);
					}
					
				} else {
					JOptionPane.showMessageDialog(null,"請設定製作數量");
				}
			}
		});
		button_2.setBounds(363, 247, 81, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MaterialToProduct mp = new MaterialToProduct();
				mp.main(null);
			}
		});
		button_3.setBounds(282, 247, 81, 29);
		contentPane.add(button_3);
	}

}
