package User_InterfaceE;

import java.awt.BorderLayout;





import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Inventory_StatusE.*;
import Order_ManagementE.*;
import Product_ProduceE.*;
import Customer_ManagementE.*;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SupplyHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyHome frame = new SupplyHome();
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
	public SupplyHome() {
		setTitle("Lee-Hu Pastry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("店家倉儲管理系統");
		label.setForeground(new Color(255, 255, 255));
		Image img = new ImageIcon(this.getClass().getResource("/warehouse.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(img));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(20, 6, 225, 43);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("   訂單資訊");
		Image Oimg = new ImageIcon(this.getClass().getResource("/orderlist.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(Oimg));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		lblNewLabel.setBounds(64, 89, 354, 69);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("   糕餅製作");
		Image Bimg = new ImageIcon(this.getClass().getResource("/barcode.png")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		label_1.setIcon(new ImageIcon(Bimg));
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		label_1.setBounds(72, 201, 249, 73);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				try {
					OrderDetailApp o = new OrderDetailApp();
					o.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image Fimg = new ImageIcon(this.getClass().getResource("/hot.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(Fimg));
		lblNewLabel_1.setBounds(384, 120, 73, 69);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHot = new JLabel("HOT!!");
		lblHot.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblHot.setBounds(388, 70, 115, 69);
		contentPane.add(lblHot);
		
		JLabel label_2 = new JLabel("  顧客管理");
		Image KKKimg = new ImageIcon(this.getClass().getResource("/CustomerMana.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		label_2.setIcon(new ImageIcon(KKKimg));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		label_2.setBounds(72, 311, 249, 73);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("庫存現況\n");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		label_3.setBounds(378, 230, 115, 69);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		Image BBimg = new ImageIcon(this.getClass().getResource("/box.png")).getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
		label_4.setIcon(new ImageIcon(BBimg));
		label_4.setBounds(395, 280, 94, 91);
		contentPane.add(label_4);
		btnNewButton.setBounds(45, 75, 308, 100);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MaterialToProduct mp = new MaterialToProduct();
				mp.main(null);
			}
		});
		button.setBounds(45, 186, 308, 100);
		contentPane.add(button);
		
		JButton button_1 = new JButton("登出");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "登出成功！");
				
				dispose();
			}
		});
		button_1.setBounds(452, 6, 62, 29);
		contentPane.add(button_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hot h;
				try {
					h = new Hot();
					h.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(365, 74, 117, 129);
		contentPane.add(btnNewButton_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					dispose();
		
					customer c = new customer();
					c.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setBounds(45, 298, 308, 100);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				InventoryStatus is = new InventoryStatus();
				is.main(null);
			}
		});
		button_3.setBounds(365, 215, 117, 182);
		contentPane.add(button_3);
		
		
	}

}
