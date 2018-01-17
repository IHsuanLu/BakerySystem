package User_InterfaceE;

import java.awt.BorderLayout;
import java.awt.Color;
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

import Product_ProduceE.Product_DAO;
import User_InterfaceE.*;

public class Product1 extends JFrame {

	private DAO dao;
	private Product_DAO Pdao;
	
	private String Muname;
	private long counter;
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	private int i = 0;
	private int j ;
	private int i1 = 0;
	private int j1 ;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Product1 frame = new Product1();
//					frame.frame.setVisible(true);
					
					Product1 frame = new Product1(Muname, counter);	
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
	public Product1(String Muname, long counter) {
		try {
			dao = new DAO(Muname, counter);
			
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from product1");
			System.out.println(counter + " from product1");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 800, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProductList = new JLabel("Merch List：");
		lblProductList.setForeground(new Color(255, 255, 255));
		Image Pimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		lblProductList.setIcon(new ImageIcon(Pimg));
		lblProductList.setBounds(20, 23, 167, 25);
		lblProductList.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(lblProductList);
		
		JLabel Rlabel = new JLabel();
		Rlabel.setBounds(107, 77, 175, 150);
		Image Rimg = new ImageIcon(this.getClass().getResource("/鳳梨酥.jpg")).getImage().getScaledInstance(175, 150, Image.SCALE_DEFAULT);
		Rlabel.setIcon(new ImageIcon(Rimg));
		frame.getContentPane().add(Rlabel);
		
		JLabel Nlabel = new JLabel();
		Nlabel.setBounds(107, 267, 175, 150);
		Image Nimg = new ImageIcon(this.getClass().getResource("/綠豆椪.jpg")).getImage().getScaledInstance(175, 150, Image.SCALE_DEFAULT);
		Nlabel.setIcon(new ImageIcon(Nimg));
		frame.getContentPane().add(Nlabel);
		
		JLabel labelline1 = new JLabel("");
		labelline1.setForeground(Color.GRAY);
		labelline1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelline1.setBounds(0, 430, 800, 16);
		frame.getContentPane().add(labelline1);
		
		JButton buttonNext1 = new JButton("下一頁");
		buttonNext1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				ProductList2 pl2 = new ProductList2(Muname, counter);
				pl2.setVisible(true);
				pl2.main(null);
				
			}
		});
		buttonNext1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		buttonNext1.setBackground(Color.WHITE);
		buttonNext1.setBounds(653, 458, 117, 29);
		frame.getContentPane().add(buttonNext1);
		
		JLabel r1 = new JLabel("產品名：  鳳梨酥");
		r1.setForeground(new Color(255, 255, 255));
		r1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		r1.setBounds(333, 77, 147, 16);
		frame.getContentPane().add(r1);
		
		JLabel r1_e = new JLabel("Pineapple Cake\n");
		r1_e.setForeground(new Color(255, 255, 255));
		r1_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		r1_e.setBounds(492, 73, 133, 25);
		frame.getContentPane().add(r1_e);
		
		JLabel r2 = new JLabel("保存期限：30 天");
		r2.setForeground(new Color(255, 255, 255));
		r2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		r2.setBounds(333, 105, 139, 16);
		frame.getContentPane().add(r2);
		
		JLabel r2_e = new JLabel("Shelf life: 30 days");
		r2_e.setForeground(new Color(255, 255, 255));
		r2_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		r2_e.setBounds(506, 105, 139, 16);
		frame.getContentPane().add(r2_e);
		
		JLabel r3 = new JLabel("價格： 新台幣  18 /元個");
		r3.setForeground(new Color(255, 255, 255));
		r3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		r3.setBounds(333, 133, 196, 16);
		frame.getContentPane().add(r3);
		
		JLabel r5 = new JLabel("購買數量：");
		r5.setForeground(new Color(255, 255, 255));
		r5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		r5.setBounds(333, 210, 98, 16);
		frame.getContentPane().add(r5);
		
		
		JLabel n1 = new JLabel("產品名：  綠豆椪肉餅");
		n1.setForeground(new Color(255, 255, 255));
		n1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		n1.setBounds(333, 268, 154, 16);
		frame.getContentPane().add(n1);
		
		JLabel n2 = new JLabel("保存期限：7 天");
		n2.setForeground(new Color(255, 255, 255));
		n2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		n2.setBounds(333, 296, 196, 16);
		frame.getContentPane().add(n2);
		
		JLabel n2_e = new JLabel("Shelf life: 7 days");
		n2_e.setForeground(new Color(255, 255, 255));
		n2_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		n2_e.setBounds(506, 296, 139, 16);
		frame.getContentPane().add(n2_e);
		
		JLabel n1_e = new JLabel("Mung Bean Pastry");
		n1_e.setForeground(new Color(255, 255, 255));
		n1_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		n1_e.setBounds(528, 264, 147, 25);
		frame.getContentPane().add(n1_e);
		
		JLabel n3 = new JLabel("價格：  新台幣 26 元/個");
		n3.setForeground(new Color(255, 255, 255));
		n3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		n3.setBounds(333, 324, 196, 16);
		frame.getContentPane().add(n3);
		
		JLabel n4 = new JLabel("購買數量：");
		n4.setForeground(new Color(255, 255, 255));
		n4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		n4.setBounds(333, 401, 89, 16);
		frame.getContentPane().add(n4);
		
		JButton H1 = new JButton("");	
		H1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();

				Home home = new Home(Muname, counter);
				home.main(null);
			}
		});
		
		H1.setBounds(734, 6, 60, 60);
		Image Himg2 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		H1.setIcon(new ImageIcon(Himg2));
		frame.getContentPane().add(H1);
		
		
		JButton cart1 = new JButton("");
		cart1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				Cart cart = new Cart(Muname, counter);

				cart.setVisible(true);

				Cart.main(null);
			}
		});
		cart1.setBounds(662, 6, 60, 60);
		Image Cimg = new ImageIcon(this.getClass().getResource("/cart.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		cart1.setIcon(new ImageIcon(Cimg));
		frame.getContentPane().add(cart1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(447, 207, 32, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton bplus = new JButton("");
		bplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double k = dao.getPineappleQty();
				
				if(i < k){
				
					if(e.getSource() == bplus){
				    
						if (i >= 0){
							i++;
							j=i;
							textField.setText(String.valueOf(i));
							System.out.println(i);
						} else {
							JOptionPane.showMessageDialog(null, "助教，我有設定商品數量不能是負的哦！");
						}
					}
				} else {
					
					 Double DK = new Double(k);
					 i = DK.intValue() - 1;
					 JOptionPane.showMessageDialog(null, "您輸入的數量超過庫存！");
				}
				
			}

		});
		bplus.setBounds(426, 210, 20, 20);
		Image plus1 = new ImageIcon(this.getClass().getResource("/plus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bplus.setIcon(new ImageIcon(plus1));
		frame.getContentPane().add(bplus);
	
		
		JButton bminus = new JButton("");
		bminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bminus){
					if(j > 0){
					j--;
					i=j;
				    textField.setText(String.valueOf(j));
				    System.out.println(j);
					}
					else{
						JOptionPane.showMessageDialog(null, "助教，我有設定商品數量不能是負的哦！");
					}
				}
			}
		});
		Image minus1 = new ImageIcon(this.getClass().getResource("/minus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bminus.setIcon(new ImageIcon(minus1));
		bminus.setBounds(480, 210, 20, 20);
		frame.getContentPane().add(bminus);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(452, 398, 32, 25);
		frame.getContentPane().add(textField_1);
		
		JButton bplus2 = new JButton("");
		bplus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double k1 = dao.getMungBeanQty();
				
				if(i1 < k1){
				
					if(e.getSource() == bplus2){
				    
					
						if (i1 >= 0){
							i1++;
							j1=i1;
							textField_1.setText(String.valueOf(i1));
							System.out.println(i1);
						}
						else{
							JOptionPane.showMessageDialog(null, "助教，我有設定商品數量不能是負的哦！");
						}
					}
				} else {
					
					 Double DK = new Double(k1);
					 i1 = DK.intValue() - 1;
					 JOptionPane.showMessageDialog(null, "您輸入的數量超過庫存！");
				}
			}
		});
		Image plus2 = new ImageIcon(this.getClass().getResource("/plus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bplus2.setIcon(new ImageIcon(plus2));
		bplus2.setBounds(431, 401, 20, 20);
		frame.getContentPane().add(bplus2);
		
		
		JButton bminus2 = new JButton("");
		bminus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bminus2){
				
				if(j1 > 0){
					j1--;
					i1=j1;
				    textField_1.setText(String.valueOf(j1));
				    System.out.println(j1);
					}
					else{
						JOptionPane.showMessageDialog(null, "助教，我有設定商品數量不能是負的哦！");
					}
			}
			}
		});
		Image minus2 = new ImageIcon(this.getClass().getResource("/minus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bminus2.setIcon(new ImageIcon(minus2));
		bminus2.setBounds(485, 401, 20, 20);
		frame.getContentPane().add(bminus2);
		
		JButton button = new JButton("加到購物車");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					double text = Integer.parseInt(textField.getText());
					
					if (text > 0){
						dao.InsertPineapple(text);
						
						int response = JOptionPane.showConfirmDialog(button, "是否繼續購物？");
						
						
						if (response == JOptionPane.YES_OPTION){
							return;
						}	
						
						if (response == JOptionPane.CANCEL_OPTION){
							return;
						}
						if (response == JOptionPane.NO_OPTION){
							frame.dispose();
							Cart cart = new Cart(Muname, counter);
							cart.setVisible(true);
							Cart.main(null);
						}
					} else {
						JOptionPane.showMessageDialog(null, "產品數量不得為0");
					}
				
					
				} catch (Exception exc){
					JOptionPane.showMessageDialog(null, "請選擇商品數量");
				}
				
				
			}
		});
		button.setBounds(528, 207, 117, 29);
		frame.getContentPane().add(button);
		
		JButton button1 = new JButton("加到購物車");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					double text = Integer.parseInt(textField_1.getText());
					
				if (text > 0){
					dao.InsertMungBean(text);
				
					double response1 = JOptionPane.showConfirmDialog(button1, "是否繼續購物？");
					
					if (response1 == JOptionPane.YES_OPTION){
						return;
					}	
					
					if (response1 == JOptionPane.CANCEL_OPTION){
						return;
					}
					if (response1 == JOptionPane.NO_OPTION){
						frame.dispose();
						Cart cart = new Cart(Muname, counter);
						cart.setVisible(true);
						Cart.main(null);
					}
				} else {
					JOptionPane.showMessageDialog(null, "產品數量不得為0");
				}
				
				} catch(Exception exc){
					JOptionPane.showMessageDialog(null, "請選擇商品數量");
				}
			
			}
		});
		button1.setBounds(528, 398, 117, 29);
		frame.getContentPane().add(button1);
		
		JLabel label = new JLabel("＊每十個可裝成一盒");
		label.setForeground(new Color(240, 128, 128));
		label.setBounds(333, 182, 119, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("＊每十個可裝成一盒");
		label_1.setForeground(new Color(240, 128, 128));
		label_1.setBounds(332, 376, 119, 16);
		frame.getContentPane().add(label_1);
		
	}
}


