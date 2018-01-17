package User_InterfaceE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import User_InterfaceE.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProductList2 extends JFrame {

	private String Muname;
	private long counter;
	
	private JFrame frameBetterJadeSystem2;
	private JPanel contentPane;
	private DAO dao;
	private int i = 0;
	private int j ;
	private int i1 = 0;
	private int j1 ;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList2 frame = new ProductList2(Muname, counter);
					frame.frameBetterJadeSystem2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductList2(String Muname, long counter) {
		
		try {
			dao = new DAO(Muname, counter);
			
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from product2");
			System.out.println(counter + " from product2");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		
		frameBetterJadeSystem2 = new JFrame();
		frameBetterJadeSystem2.getContentPane().setForeground(new Color(255, 255, 255));
		frameBetterJadeSystem2.getContentPane().setBackground(new Color(105, 105, 105));
		frameBetterJadeSystem2.setTitle("Lee-Hu Pastry");
		frameBetterJadeSystem2.setBounds(100, 100, 800, 520);
		frameBetterJadeSystem2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBetterJadeSystem2.getContentPane().setLayout(null);
		
		JLabel lblProductList = new JLabel("Merch List：");
		lblProductList.setForeground(new Color(255, 255, 255));
		Image Pimg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		lblProductList.setIcon(new ImageIcon(Pimg));
		lblProductList.setBounds(20, 23, 167, 25);
		lblProductList.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frameBetterJadeSystem2.getContentPane().add(lblProductList);
		
		JLabel Blabel = new JLabel();
		Blabel.setBackground(Color.WHITE);
		Blabel.setBounds(107, 77, 175, 150);
		Image Bimg = new ImageIcon(this.getClass().getResource("/咖哩酥.jpg")).getImage().getScaledInstance(175, 150, Image.SCALE_DEFAULT);
		Blabel.setIcon(new ImageIcon(Bimg));
		frameBetterJadeSystem2.getContentPane().add(Blabel);
		
		JLabel Elabel = new JLabel();
		Elabel.setBounds(107, 267, 175, 150);
		Image Eimg = new ImageIcon(this.getClass().getResource("/蛋黃酥.jpeg")).getImage().getScaledInstance(175, 150, Image.SCALE_DEFAULT);
		Elabel.setIcon(new ImageIcon(Eimg));
		frameBetterJadeSystem2.getContentPane().add(Elabel);
		
		JLabel labelline4 = new JLabel("");
		labelline4.setForeground(Color.GRAY);
		labelline4.setBackground(Color.WHITE);
		labelline4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelline4.setBounds(0, 239, 800, 16);
		frameBetterJadeSystem2.getContentPane().add(labelline4);
		
		JLabel labelline3 = new JLabel("");
		labelline3.setForeground(Color.GRAY);
		labelline3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelline3.setBounds(0, 430, 800, 16);
		frameBetterJadeSystem2.getContentPane().add(labelline3);
		
		JLabel b1 = new JLabel("產品名：  咖哩酥");
		b1.setForeground(new Color(255, 255, 255));
		b1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		b1.setBounds(333, 77, 147, 16);
		frameBetterJadeSystem2.getContentPane().add(b1);
		
		JLabel b1_e = new JLabel("Curry Pastry\n");
		b1_e.setForeground(new Color(255, 255, 255));
		b1_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		b1_e.setBounds(492, 73, 112, 25);
		frameBetterJadeSystem2.getContentPane().add(b1_e);
		
		JLabel b2 = new JLabel("保存期限：4 天");
		b2.setForeground(new Color(255, 255, 255));
		b2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		b2.setBounds(333, 105, 196, 16);
		frameBetterJadeSystem2.getContentPane().add(b2);
		
		JLabel b2_e = new JLabel("Shelf life: 4 days\n");
		b2_e.setForeground(new Color(255, 255, 255));
		b2_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		b2_e.setBounds(492, 105, 134, 16);
		frameBetterJadeSystem2.getContentPane().add(b2_e);
		
		JLabel b3 = new JLabel("價格：  新台幣 33 元/個");
		b3.setForeground(new Color(255, 255, 255));
		b3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		b3.setBounds(333, 133, 196, 16);
		frameBetterJadeSystem2.getContentPane().add(b3);
		
		JLabel b5 = new JLabel("購買數量：");
		b5.setForeground(new Color(255, 255, 255));
		b5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		b5.setBounds(333, 210, 98, 16);
		frameBetterJadeSystem2.getContentPane().add(b5);
		Image Cimg3 = new ImageIcon(this.getClass().getResource("/cart.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		JLabel e1 = new JLabel("產品名：  蛋黃酥");
		e1.setForeground(new Color(255, 255, 255));
		e1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		e1.setBounds(333, 268, 147, 16);
		frameBetterJadeSystem2.getContentPane().add(e1);
		
		JLabel e2 = new JLabel("保存期限：7 天");
		e2.setForeground(new Color(255, 255, 255));
		e2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		e2.setBounds(333, 296, 196, 16);
		frameBetterJadeSystem2.getContentPane().add(e2);
		
		JLabel e2_e = new JLabel("Shelf life: 7 days");
		e2_e.setForeground(new Color(255, 255, 255));
		e2_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		e2_e.setBounds(492, 296, 134, 16);
		frameBetterJadeSystem2.getContentPane().add(e2_e);
		
		JLabel e1_e = new JLabel("Yolk Pastry");
		e1_e.setForeground(new Color(255, 255, 255));
		e1_e.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		e1_e.setBounds(492, 264, 147, 25);
		frameBetterJadeSystem2.getContentPane().add(e1_e);
		
		JLabel e3 = new JLabel("價格：  新台幣 35 元/個");
		e3.setForeground(new Color(255, 255, 255));
		e3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		e3.setBounds(333, 324, 202, 16);
		frameBetterJadeSystem2.getContentPane().add(e3);
		
		JLabel e5 = new JLabel("購買數量：");
		e5.setForeground(new Color(255, 255, 255));
		e5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		e5.setBounds(333, 401, 98, 16);
		frameBetterJadeSystem2.getContentPane().add(e5);
		Image Cimg4 = new ImageIcon(this.getClass().getResource("/cart.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		JButton button = new JButton("上一頁");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameBetterJadeSystem2.dispose();
				Product1 pl1 = new Product1(Muname, counter);
				pl1.main(null);
			}
		});
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		button.setBackground(Color.WHITE);
		button.setBounds(524, 458, 117, 29);
		frameBetterJadeSystem2.getContentPane().add(button);
		
		JButton H2 = new JButton("");	
		H2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameBetterJadeSystem2.dispose();

				Home home = new Home(Muname, counter);
				home.main(null);
			}
		});
		H2.setBounds(734, 6, 60, 60);
		Image Himg2 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		H2.setIcon(new ImageIcon(Himg2));
		frameBetterJadeSystem2.getContentPane().add(H2);
		
		JButton cart2 = new JButton("");
		cart2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameBetterJadeSystem2.dispose();

				Cart cart = new Cart(Muname, counter);

				cart.setVisible(true);

				Cart.main(null);
			}
		});
		cart2.setBounds(662, 6, 60, 60);
		Image Cimg = new ImageIcon(this.getClass().getResource("/cart.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		cart2.setIcon(new ImageIcon(Cimg));
		frameBetterJadeSystem2.getContentPane().add(cart2);
		
		JButton bplus3 = new JButton("");
		bplus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double k = dao.getYolkQty();
				
				if(i < k){
				
					if(e.getSource() == bplus3){
				    
					
						if (i >= 0){
							i++;
							j=i;
							textField.setText(String.valueOf(i));
							System.out.println(i);
						}
						else{
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
		bplus3.setBounds(431, 210, 20, 20);
		Image plus3 = new ImageIcon(this.getClass().getResource("/plus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bplus3.setIcon(new ImageIcon(plus3));
		frameBetterJadeSystem2.getContentPane().add(bplus3);
		
		JButton bminus3 = new JButton("");
		bminus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == bminus3){
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
		Image minus3 = new ImageIcon(this.getClass().getResource("/minus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bminus3.setIcon(new ImageIcon(minus3));
		bminus3.setBounds(485, 210, 20, 20);
		frameBetterJadeSystem2.getContentPane().add(bminus3);
		
		JButton bplus4 = new JButton("");
		bplus4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double k = dao.getCurryQty();
				
				if(i1 < k){
				
					if(e.getSource() == bplus4){
				    
					
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
					
					 Double DK = new Double(k);
					 i1 = DK.intValue() - 1;
					 JOptionPane.showMessageDialog(null, "您輸入的數量超過庫存！");
				}
			}
			
		});
		Image plus4 = new ImageIcon(this.getClass().getResource("/plus.png")).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		bplus4.setIcon(new ImageIcon(plus4));
		bplus4.setBounds(431, 401, 20, 20);
		frameBetterJadeSystem2.getContentPane().add(bplus4);
		
		JButton bminus4 = new JButton("");
		bminus4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bminus4){
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
		bminus4.setIcon(new ImageIcon(minus2));
		bminus4.setBounds(485, 401, 20, 20);
		frameBetterJadeSystem2.getContentPane().add(bminus4);
		
		JButton button2 = new JButton("加到購物車");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				
					double text = Integer.parseInt(textField.getText());
				
				if (text > 0) {
					dao.InsertYolk(text);
				
					int response = JOptionPane.showConfirmDialog(button, "是否繼續購物？");
				
				
					if (response == JOptionPane.YES_OPTION){
						return;
					}	
				
					if (response == JOptionPane.CANCEL_OPTION){
					return;
					}
					if (response == JOptionPane.NO_OPTION){
						frameBetterJadeSystem2.dispose();
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
		button2.setBounds(528, 207, 117, 29);
		frameBetterJadeSystem2.getContentPane().add(button2);
		
		JButton button3 = new JButton("加到購物車");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			try {
				double text = Integer.parseInt(textField_1.getText());
			if (text > 0){
				
				dao.InsertCurry(text);
			
				double response1 = JOptionPane.showConfirmDialog(button3, "是否繼續購物？");
				
				if (response1 == JOptionPane.YES_OPTION){
					return;
				}	
				
				if (response1 == JOptionPane.CANCEL_OPTION){
					return;
				}
				if (response1 == JOptionPane.NO_OPTION){
					frameBetterJadeSystem2.dispose();
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
		button3.setBounds(528, 398, 117, 29);
		frameBetterJadeSystem2.getContentPane().add(button3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(452, 209, 31, 22);
		frameBetterJadeSystem2.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(452, 400, 31, 22);
		frameBetterJadeSystem2.getContentPane().add(textField_1);
		
		JLabel label = new JLabel("＊每十個裝成一盒");
		label.setForeground(new Color(240, 128, 128));
		label.setBounds(333, 187, 118, 16);
		frameBetterJadeSystem2.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("＊每十個裝成一盒");
		label_1.setForeground(new Color(240, 128, 128));
		label_1.setBounds(333, 380, 118, 16);
		frameBetterJadeSystem2.getContentPane().add(label_1);
		
		
	}

}
