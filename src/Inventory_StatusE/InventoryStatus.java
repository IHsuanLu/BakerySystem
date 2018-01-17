package Inventory_StatusE;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inventory_ManagementE.InventoryApp;

import java.awt.Color;
import javax.swing.JSeparator;


import User_InterfaceE.SupplyHome;

import javax.swing.JTextField;

import User_InterfaceE.*;
import Product_ProduceE.*;

public class InventoryStatus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	
	private Product_DAO dao;
	private DAO Udao;
	private Status_DAO Sdao;
	private java.util.List<String> list;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryStatus frame = new InventoryStatus();
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
	public InventoryStatus() {
		
		try {
			dao = new Product_DAO();
			Udao = new DAO();
			Sdao = new Status_DAO();
			list = dao.getAllMaterialsNo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		setTitle("Lee-Hu Pastry");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("存貨現況 (1/2)");
		label.setForeground(new Color(255, 255, 255));
		Image Logoimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Logoimg));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		label.setBounds(6, 6, 222, 39);
		contentPane.add(label);
		
		JButton H1 = new JButton("");	
		H1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				SupplyHome sh = new SupplyHome();
				sh.main(null);
			}
		});
		
		H1.setBounds(514, 6, 60, 60);
		Image Himg2 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		H1.setIcon(new ImageIcon(Himg2));
		contentPane.add(H1);
		
		JLabel label_2 = new JLabel("(* 易腐壞 -> 單期訂購)");
		label_2.setForeground(new Color(240, 128, 128));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		label_2.setBounds(63, 40, 153, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("1. 鳳梨餡 （進貨時間 2天）");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_3.setBounds(42, 83, 242, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("2.1. 綠豆餡（進貨時間 2天）");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_4.setBounds(43, 205, 255, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("2.2. 滷肉餡（進貨時間 2天）");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_5.setBounds(42, 303, 256, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("3. 咖哩餡（進貨時間 2天）");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_6.setBounds(42, 432, 242, 22);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("4. 蛋黃餡（進貨時間 2天）");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_7.setBounds(42, 561, 242, 22);
		contentPane.add(label_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 192, 484, 12);
		contentPane.add(separator);
		
		JLabel label_8 = new JLabel("上次進貨時間：");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_8.setBounds(63, 113, 105, 22);
		contentPane.add(label_8);
		
		JLabel label_11 = new JLabel("預計進貨數量：");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_11.setBounds(63, 139, 105, 22);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("庫存剩餘 (克)：");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_12.setBounds(280, 84, 105, 22);
		contentPane.add(label_12);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(105, 105, 105));
		textField.setEditable(false);
		textField.setText(Sdao.getLatestPurchase("P101"));
		textField.setBounds(169, 112, 162, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("49000");
		textField_3.setColumns(10);
		textField_3.setBounds(169, 138, 96, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText(" " + String.valueOf(dao.getWeightOf(list.get(6))));
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(105, 105, 105));
		textField_4.setColumns(10);
		textField_4.setBounds(384, 83, 82, 26);
		contentPane.add(textField_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 418, 484, 12);
		contentPane.add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(42, 677, 484, 12);
		contentPane.add(separator_3);
		
		JButton button = new JButton("系統建議");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_Advice pa = new P_Advice();
				pa.main(null);
			}
		});
		button.setBounds(55, 164, 96, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("進貨");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if (textField_3.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(InventoryStatus.this, "請輸入欲進貨數量");
					
				} else {
					
					Date date = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					
					// 比較與之前的時間差異
					Long lastOrder = Long.parseLong(textField_15.getText());
					Date lastOrderDate = new Date(lastOrder);
					
					if(date.compareTo(lastOrderDate) <= 86400000){
						
						Long remainTime = lastOrder + 86400000 - date.getTime();
						
						int h = (int) ((remainTime / 1000) / 3600);
						int m = (int) (((remainTime / 1000) / 60) % 60);
						int s = (int) ((remainTime / 1000) % 60);
						
						JOptionPane.showMessageDialog(InventoryStatus.this, "進貨失敗！\n原因：上一批商品尚未抵達。", "Error",
								JOptionPane.ERROR_MESSAGE);	
						JOptionPane.showMessageDialog(InventoryStatus.this, "請於: "+ h + "小時 " + m + "分鐘 " + s + "秒" + "後再試一次！");
						
					} else if (date.compareTo(lastOrderDate) >= 604800000){
						
						int totalWeight = Integer.parseInt(textField_3.getText()) + dao.getWeightOf("P101");
						
						Sdao.updateMaterialWeight(totalWeight, ft.format(date), "P101", date.getTime());
						Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Pineapple", Integer.parseInt(textField_3.getText())*3.5, ft.format(date));
						
						JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_3.getText()) + " 克鳳梨餡\n目前庫存： " + totalWeight);
						
						//更新資訊
						textField_3.setText("");
						textField.setText(ft.format(date));
						textField_4.setText(" " + String.valueOf(dao.getWeightOf(list.get(6))));
						textField_15.setText(String.valueOf(date.getTime()));
						
						
					} else {
						
						int response = JOptionPane.showConfirmDialog(button_1, "距離上次進貨不到一期，確定進貨？");
						
						if (response == JOptionPane.YES_OPTION){
							
							JOptionPane.showMessageDialog(InventoryStatus.this, "賠錢別怪我唷！");
							
							int totalWeight = Integer.parseInt(textField_3.getText()) + dao.getWeightOf("P101");
							
							Sdao.updateMaterialWeight(totalWeight, ft.format(date), "P101", date.getTime());
							Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Pineapple", Integer.parseInt(textField_3.getText())*3.5, ft.format(date));

							
							JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_3.getText()) + " 克鳳梨餡\n目前庫存： " + totalWeight + "\n\n" + "原料將於兩天後送達");
							
							//更新資訊
							textField_3.setText("");
							textField.setText(ft.format(date));
							textField_4.setText(" " + String.valueOf(dao.getWeightOf(list.get(6))));
							textField_15.setText(String.valueOf(date.getTime()));
							
						} else {
							
							JOptionPane.showMessageDialog(InventoryStatus.this, "進貨已取消。");
						}
					}
				}
				
			}
		});
		button_1.setBounds(430, 164, 96, 29);
		contentPane.add(button_1);
		
		JLabel label_9 = new JLabel("庫存剩餘 (克)：");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_9.setBounds(282, 206, 105, 22);
		contentPane.add(label_9);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(105, 105, 105));
		textField_1.setBounds(386, 205, 82, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(105, 105, 105));
		textField_2.setEditable(false);
		textField_2.setText(Sdao.getLatestPurchase("M101"));
		textField_2.setColumns(10);
		textField_2.setBounds(171, 234, 162, 26);
		contentPane.add(textField_2);
		
		JLabel label_10 = new JLabel("上次進貨時間：");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_10.setBounds(65, 235, 105, 22);
		contentPane.add(label_10);
		
		JLabel label_13 = new JLabel("預計進貨數量：");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_13.setBounds(65, 261, 105, 22);
		contentPane.add(label_13);
		
		textField_5 = new JTextField();
		textField_5.setText("7500");
		textField_5.setColumns(10);
		textField_5.setBounds(171, 260, 94, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText(" " + String.valueOf(dao.getWeightOf(list.get(5))));
		textField_6.setForeground(Color.WHITE);
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(105, 105, 105));
		textField_6.setBounds(386, 303, 82, 26);
		contentPane.add(textField_6);
		
		JLabel label_1 = new JLabel("庫存剩餘 (克)：");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(282, 304, 105, 22);
		contentPane.add(label_1);
		
		JLabel label_14 = new JLabel("上次進貨時間：");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_14.setBounds(65, 333, 105, 22);
		contentPane.add(label_14);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(255, 255, 255));
		textField_7.setBackground(new Color(105, 105, 105));
		textField_7.setEditable(false);
		textField_7.setText(Sdao.getLatestPurchase("M102"));
		textField_7.setColumns(10);
		textField_7.setBounds(171, 332, 162, 26);
		contentPane.add(textField_7);
		
		JLabel label_15 = new JLabel("預計進貨數量：");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_15.setBounds(65, 359, 105, 22);
		contentPane.add(label_15);
		
		textField_8 = new JTextField();
		textField_8.setText("7500");
		textField_8.setColumns(10);
		textField_8.setBounds(171, 358, 94, 26);
		contentPane.add(textField_8);
		
		JButton button_2 = new JButton("系統建議");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M_Advice ma = new M_Advice();
				ma.main(null);
			}
		});
		button_2.setBounds(55, 391, 96, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("進貨");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// T 2/7  Q 5/8
				if (textField_5.getText().isEmpty() && textField_8.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(InventoryStatus.this, "請輸入欲進貨數量");
					
				} else {
					
					Date date = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					
					// 比較與之前的時間差異
					Long lastOrder = Long.parseLong(textField_16.getText());
					Date lastOrderDate = new Date(lastOrder);
					
					if(date.compareTo(lastOrderDate) <= 86400000){
						
						Long remainTime = lastOrder + 86400000 - date.getTime();
						
						int h = (int) ((remainTime / 1000) / 3600);
						int m = (int) (((remainTime / 1000) / 60) % 60);
						int s = (int) ((remainTime / 1000) % 60);
						
						JOptionPane.showMessageDialog(InventoryStatus.this, "進貨失敗！\n原因：上一批商品尚未抵達。", "Error",
								JOptionPane.ERROR_MESSAGE);	
						JOptionPane.showMessageDialog(InventoryStatus.this, "請於: "+ h + "小時 " + m + "分鐘 " + s + "秒" + "後再試一次！");
						
					} else if (date.compareTo(lastOrderDate) >= 345600000){
						
						int totalWeight1 = Integer.parseInt(textField_5.getText()) + dao.getWeightOf("M101");
						int totalWeight2 = Integer.parseInt(textField_8.getText()) + dao.getWeightOf("M102");
							
						Sdao.updateMaterialWeight(totalWeight1, ft.format(date), "M101", date.getTime());
						Sdao.updateMaterialWeight(totalWeight2, ft.format(date), "M102", date.getTime());
						Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Mung", Integer.parseInt(textField_5.getText())*1.5, ft.format(date));
						Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "Meat_Mung", Integer.parseInt(textField_8.getText())*5, ft.format(date));


						
						JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_5.getText()) + " 克綠豆餡\n目前庫存： " + totalWeight1 + "\n" + "已增加 " + Integer.parseInt(textField_8.getText()) + " 克滷肉餡\n目前庫存： " + totalWeight2);
						
						//更新資訊
						textField_5.setText("");
						textField_8.setText("");					
						textField_2.setText(ft.format(date));
						textField_7.setText(ft.format(date));
						textField_1.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
						textField_1.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
						textField_6.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
						textField_16.setText(String.valueOf(date.getTime()));
						textField_17.setText(String.valueOf(date.getTime()));
						
					} else {
						
						int response = JOptionPane.showConfirmDialog(button_1, "距離上次進貨不到一期，確定進貨？");
						
						if (response == JOptionPane.YES_OPTION){
							
							int totalWeight1 = Integer.parseInt(textField_5.getText()) + dao.getWeightOf("M101");
							int totalWeight2 = Integer.parseInt(textField_8.getText()) + dao.getWeightOf("M102");
								
							Sdao.updateMaterialWeight(totalWeight1, ft.format(date), "M101", date.getTime());
							Sdao.updateMaterialWeight(totalWeight2, ft.format(date), "M102", date.getTime());
							Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Mung", Integer.parseInt(textField_5.getText())*1.5, ft.format(date));
							Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "Meat_Mung", Integer.parseInt(textField_8.getText())*5, ft.format(date));

							
							JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_5.getText()) + " 克綠豆餡\n目前庫存： " + totalWeight1 + "\n" + "已增加 " + Integer.parseInt(textField_8.getText()) + " 克滷肉餡\n目前庫存： " + totalWeight2);
							
							//更新資訊
							textField_5.setText("");
							textField_8.setText("");					
							textField_2.setText(ft.format(date));
							textField_7.setText(ft.format(date));
							textField_1.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
							textField_1.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
							textField_6.setText(" " + String.valueOf(dao.getWeightOf(list.get(4))));
							textField_16.setText(String.valueOf(date.getTime()));
							textField_17.setText(String.valueOf(date.getTime()));
							
						} else {
							JOptionPane.showMessageDialog(InventoryStatus.this, "進貨已取消。");
						}
					}

				}
			}
		});
		button_3.setBounds(430, 391, 96, 29);
		contentPane.add(button_3);
		
		textField_9 = new JTextField();
		textField_9.setForeground(new Color(255, 255, 255));
		textField_9.setBackground(new Color(105, 105, 105));
		textField_9.setEditable(false);
		textField_9.setText(Sdao.getLatestPurchase("C101"));
		textField_9.setColumns(10);
		textField_9.setBounds(171, 461, 162, 26);
		contentPane.add(textField_9);
		
		JLabel label_16 = new JLabel("庫存剩餘 (克)：");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_16.setBounds(282, 433, 105, 22);
		contentPane.add(label_16);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setText(" " + String.valueOf(dao.getWeightOf(list.get(0))));
		textField_10.setForeground(Color.WHITE);
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(105, 105, 105));
		textField_10.setBounds(386, 432, 82, 26);
		contentPane.add(textField_10);
		
		JLabel label_17 = new JLabel("上次進貨時間：");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_17.setBounds(65, 462, 105, 22);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("預計進貨數量：");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_18.setBounds(65, 488, 105, 22);
		contentPane.add(label_18);
		
		textField_11 = new JTextField();
		textField_11.setText("20000");
		textField_11.setColumns(10);
		textField_11.setBounds(171, 487, 96, 26);
		contentPane.add(textField_11);
		
		JButton button_4 = new JButton("系統建議");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_Advice ca = new C_Advice();
				ca.main(null);
			}
		});
		button_4.setBounds(55, 520, 96, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("進貨");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// T9 Q11
				if (textField_11.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(InventoryStatus.this, "請輸入欲進貨數量");
					
				} else {
					
					Date date = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					
					Long lastOrder = Long.parseLong(textField_16.getText());
					Date lastOrderDate = new Date(lastOrder);
					
					if(date.compareTo(lastOrderDate) <= 86400000){
						
						Long remainTime = lastOrder + 86400000 - date.getTime();
						
						int h = (int) ((remainTime / 1000) / 3600);
						int m = (int) (((remainTime / 1000) / 60) % 60);
						int s = (int) ((remainTime / 1000) % 60);
						
						JOptionPane.showMessageDialog(InventoryStatus.this, "進貨失敗！\n原因：上一批商品尚未抵達。", "Error",
								JOptionPane.ERROR_MESSAGE);	
						JOptionPane.showMessageDialog(InventoryStatus.this, "請於: "+ h + "小時 " + m + "分鐘 " + s + "秒" + "後再試一次！");
						
					} else if (date.compareTo(lastOrderDate) >= 345600000){
						
						int totalWeight = Integer.parseInt(textField_11.getText()) + dao.getWeightOf("C101");
						
						Sdao.updateMaterialWeight(totalWeight, ft.format(date), "C101", date.getTime());
						Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Curry", Integer.parseInt(textField_11.getText())*9.5, ft.format(date));

						
						JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_11.getText()) + " 克咖哩餡\n目前庫存： " + totalWeight);
						
						//更新資訊
						textField_11.setText("");
						textField_9.setText(ft.format(date));
						textField_10.setText(" " + String.valueOf(dao.getWeightOf(list.get(0))));
						textField_18.setText(String.valueOf(date.getTime()));
						
					} else {
						
						int response = JOptionPane.showConfirmDialog(button_1, "距離上次進貨不到一期，確定進貨？");

						if (response == JOptionPane.YES_OPTION){
							
							int totalWeight = Integer.parseInt(textField_11.getText()) + dao.getWeightOf("C101");
							
							Sdao.updateMaterialWeight(totalWeight, ft.format(date), "C101", date.getTime());
							Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Curry", Integer.parseInt(textField_11.getText())*9.5, ft.format(date));

							
							JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_11.getText()) + " 克咖哩餡\n目前庫存： " + totalWeight);
							
							//更新資訊
							textField_11.setText("");
							textField_9.setText(ft.format(date));
							textField_10.setText(" " + String.valueOf(dao.getWeightOf(list.get(0))));
							textField_18.setText(String.valueOf(date.getTime()));
							
						} else {
							JOptionPane.showMessageDialog(InventoryStatus.this, "進貨已取消。");
						}
					}
					
				}
			}
		});
		button_5.setBounds(430, 520, 96, 29);
		contentPane.add(button_5);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(42, 547, 484, 12);
		contentPane.add(separator_4);
		
		JLabel label_19 = new JLabel("庫存剩餘 (克)：");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_19.setBounds(282, 563, 105, 22);
		contentPane.add(label_19);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setText(" " + String.valueOf(dao.getWeightOf(list.get(7))));
		textField_12.setForeground(Color.WHITE);
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(105, 105, 105));
		textField_12.setBounds(386, 562, 82, 26);
		contentPane.add(textField_12);
		
		JLabel label_20 = new JLabel("上次進貨時間：");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_20.setBounds(65, 592, 105, 22);
		contentPane.add(label_20);
		
		textField_13 = new JTextField();
		textField_13.setForeground(new Color(255, 255, 255));
		textField_13.setBackground(new Color(105, 105, 105));
		textField_13.setEditable(false);
		textField_13.setText(Sdao.getLatestPurchase("Y101"));
		textField_13.setColumns(10);
		textField_13.setBounds(171, 591, 162, 26);
		contentPane.add(textField_13);
		
		JLabel label_21 = new JLabel("預計進貨數量：");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_21.setBounds(65, 618, 105, 22);
		contentPane.add(label_21);
		
		textField_14 = new JTextField();
		textField_14.setText("40000");
		textField_14.setColumns(10);
		textField_14.setBounds(171, 617, 94, 26);
		contentPane.add(textField_14);
		
		JButton button_6 = new JButton("進貨");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// T13 Q14
				if (textField_14.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(InventoryStatus.this, "請輸入欲進貨數量");
					
				} else {
					
					Date date = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					
					Long lastOrder = Long.parseLong(textField_16.getText());
					Date lastOrderDate = new Date(lastOrder);
					
					if(date.compareTo(lastOrderDate) >= 604800000){
						
						int totalWeight = Integer.parseInt(textField_14.getText()) + dao.getWeightOf("Y101");
						
						Sdao.updateMaterialWeight(totalWeight, ft.format(date), "Y101", date.getTime());
						Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Yolk", Integer.parseInt(textField_14.getText())*10.5, ft.format(date));

						
						JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_14.getText()) + " 克蛋黃餡\n目前庫存： " + totalWeight);
						
						//更新資訊
						textField_14.setText("");
						textField_13.setText(ft.format(date));
						textField_12.setText(" " + String.valueOf(dao.getWeightOf(list.get(7))));
						textField_19.setText(String.valueOf(date.getTime()));
						
					} else {
						
						int response = JOptionPane.showConfirmDialog(button_1, "距離上次進貨不到一期，確定進貨？");

						if (response == JOptionPane.YES_OPTION){
							
							int totalWeight = Integer.parseInt(textField_14.getText()) + dao.getWeightOf("Y101");
							
							Sdao.updateMaterialWeight(totalWeight, ft.format(date), "Y101", date.getTime());
							Sdao.InsertStoreOrder(String.valueOf(date.getTime()), "In_Yolk", Integer.parseInt(textField_14.getText())*10.5, ft.format(date));

							
							JOptionPane.showMessageDialog(InventoryStatus.this, "已增加 " + Integer.parseInt(textField_14.getText()) + " 克蛋黃餡\n目前庫存： " + totalWeight);
							
							//更新資訊
							textField_14.setText("");
							textField_13.setText(ft.format(date));
							textField_12.setText(" " + String.valueOf(dao.getWeightOf(list.get(7))));
							textField_19.setText(String.valueOf(date.getTime()));
							
						} else {
							JOptionPane.showMessageDialog(InventoryStatus.this, "進貨已取消。");
						}
					
					}
				}

			}
		});
		button_6.setBounds(430, 650, 96, 29);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("系統建議");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Y_Advice ya = new Y_Advice();
				ya.main(null);
			}
		});
		button_7.setBounds(55, 650, 96, 29);
		contentPane.add(button_7);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(42, 677, 484, 12);
		contentPane.add(separator_2);
		
		JButton button_8 = new JButton("下一頁");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				InventoryStatusTwo ist;
				try {
					ist = new InventoryStatusTwo();
					ist.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_8.setBounds(412, 39, 96, 29);
		contentPane.add(button_8);
		
		JLabel label_22 = new JLabel("編號：");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_22.setBounds(340, 113, 45, 22);
		contentPane.add(label_22);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setText(Sdao.getLatestOrderno("P101"));
		textField_15.setForeground(new Color(255, 255, 255));
		textField_15.setBackground(new Color(105, 105, 105));
		textField_15.setBounds(384, 112, 130, 26);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setText(Sdao.getLatestOrderno("M101"));
		textField_16.setForeground(Color.WHITE);
		textField_16.setColumns(10);
		textField_16.setBackground(new Color(105, 105, 105));
		textField_16.setBounds(384, 234, 130, 26);
		contentPane.add(textField_16);
		
		JLabel label_23 = new JLabel("編號：");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_23.setBounds(340, 235, 45, 22);
		contentPane.add(label_23);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setText(Sdao.getLatestOrderno("M102"));
		textField_17.setForeground(Color.WHITE);
		textField_17.setColumns(10);
		textField_17.setBackground(new Color(105, 105, 105));
		textField_17.setBounds(384, 333, 130, 26);
		contentPane.add(textField_17);
		
		JLabel label_24 = new JLabel("編號：");
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_24.setBounds(340, 334, 45, 22);
		contentPane.add(label_24);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setText(Sdao.getLatestOrderno("C101"));
		textField_18.setForeground(Color.WHITE);
		textField_18.setColumns(10);
		textField_18.setBackground(new Color(105, 105, 105));
		textField_18.setBounds(384, 461, 130, 26);
		contentPane.add(textField_18);
		
		JLabel label_25 = new JLabel("編號：");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_25.setBounds(340, 462, 45, 22);
		contentPane.add(label_25);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setText(Sdao.getLatestOrderno("Y101"));
		textField_19.setForeground(Color.WHITE);
		textField_19.setColumns(10);
		textField_19.setBackground(new Color(105, 105, 105));
		textField_19.setBounds(384, 592, 130, 26);
		contentPane.add(textField_19);
		
		JLabel label_26 = new JLabel("編號：");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_26.setBounds(340, 593, 45, 22);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel("(* 預計進貨數量的預設值 = 單期最佳進貨克數)");
		label_27.setForeground(new Color(240, 128, 128));
		label_27.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		label_27.setBounds(42, 688, 343, 22);
		contentPane.add(label_27);
		
	}
}
