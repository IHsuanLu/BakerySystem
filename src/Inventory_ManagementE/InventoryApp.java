package Inventory_ManagementE;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import Inventory_ManagementE.*;
import User_InterfaceE.*;
import java.awt.Color;

public class InventoryApp extends JFrame {

	private JPanel contentPane;
	private JTextField productNameTextField;
	private JTextField productNumberTextField;
	private JTable table;
	
	private Ddao Ddao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryApp frame = new InventoryApp();
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
	public InventoryApp() {
		
		//create the Ddao
		
		try{
			Ddao = new Ddao();
		} catch (Exception exc){
			JOptionPane.showMessageDialog(this,"Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("玉玉寡歡");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("貨物庫存");
		label.setForeground(new Color(255, 255, 255));
		Image Rimg = new ImageIcon(this.getClass().getResource("/inventory.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(Rimg));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		label.setBounds(16, 6, 197, 44);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("輸入產品名稱：");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(92, 62, 97, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("輸入產品序號：");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(92, 79, 91, 16);
		contentPane.add(label_2);
		
		productNameTextField = new JTextField();
		productNameTextField.setBounds(216, 54, 176, 26);
//		productNameTextField.setEditable(false);
		contentPane.add(productNameTextField);
		productNameTextField.setColumns(10);
		
		productNumberTextField = new JTextField();
		productNumberTextField.setBounds(216, 74, 176, 26);
		contentPane.add(productNumberTextField);
		productNumberTextField.setColumns(10);
		
		//搜尋產品序號跟產品名稱
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get product name from the text field
				 
				//Call Ddao and get Inventory for the product name
				
				//If product name is empty, then get all Inventory
				
				//Print out Inventory
				try {
					String p_name = productNameTextField.getText();
					
					List<Inventory> Inventory = null;
					
					if(p_name != null && p_name.trim().length() > 0) {
						Inventory = Ddao.searchProductName(p_name);
					} else {
						Inventory = Ddao.getAllInventory();
					}
					
					//create the model and update the "table"
					InventoryTableModel model = new InventoryTableModel(Inventory);
					
					table.setModel(model);
					
					/*
					for (Inventory temp : Invetory) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(InventoryApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		button.setBounds(402, 54, 117, 29);
		contentPane.add(button);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 112, 569, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				SupplyHome s = new SupplyHome();
				s.main(null);
			}
		});
		Image Himg2 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		button_1.setIcon(new ImageIcon(Himg2));
		button_1.setBounds(564, 6, 60, 60);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("修改");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// get the selected item
				int row = table.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					JOptionPane.showMessageDialog(InventoryApp.this, "請選擇欲修改項目！", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				// get the current employee
				Inventory tempInventory = (Inventory) table.getValueAt(row, InventoryTableModel.OBJECT_COL);
				
				
				// create dialog
				ProductDialog dialog = new ProductDialog(InventoryApp.this, Ddao, 
															tempInventory, true);

				// show dialog
				dialog.setVisible(true);
				
			}
		});
		button_2.setBounds(41, 315, 117, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("刪除");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//get the selected row
					int row = table.getSelectedRow();
					
					//make sure a row is selected
					if(row < 0){
						JOptionPane.showMessageDialog(InventoryApp.this, "您必須選擇一項產品", "Error",
								JOptionPane.ERROR_MESSAGE);				
						return;
					}
					//prompt the user
					int response = JOptionPane.showConfirmDialog(InventoryApp.this, "確定要刪除此產品嗎?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
					if (response != JOptionPane.YES_OPTION){
						return;
					}
					//get the current employee
					Inventory tempInventory = (Inventory) table.getValueAt(row, InventoryTableModel.OBJECT_COL);
					
					//delete the employee
					Ddao.deleteProduct(tempInventory.getPno());
					
					//refresh GUI
					refreshInventoryView();
					
					//show success message
					JOptionPane.showMessageDialog(InventoryApp.this, "成功刪除產品.",
							"Product Deleted", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exc){
					JOptionPane.showMessageDialog(InventoryApp.this, "Error deleting product: " 
						 + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		button_3.setBounds(189, 315, 117, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Search");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String p_no = productNumberTextField.getText();
					
					List<Inventory> Inventory = null;
					
					if(p_no != null && p_no.trim().length() > 0) {
						Inventory = Ddao.searchProductNumber(p_no);
					} else {
						Inventory = Ddao.getAllInventory();
					}
					
					//create the model and update the "table"
					InventoryTableModel model = new InventoryTableModel(Inventory);
					
					table.setModel(model);
					
					/*
					for (Inventory temp : Invetory) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(InventoryApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		button_4.setBounds(402, 74, 117, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("登出");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
          		
          		Login l = new Login();
          		l.main(null);
			}
		});
		button_5.setBounds(488, 6, 75, 26);
		contentPane.add(button_5);
	}
	
	public void refreshInventoryView() {

		try {
			List<Inventory> Inventory = Ddao.getAllInventory();

			// create the model and update the "table"
			InventoryTableModel model = new InventoryTableModel(Inventory);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
}
