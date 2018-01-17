package Inventory_StatusE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inventory_ManagementE.InventoryApp;
import Product_ProduceE.Product_DAO;
import User_InterfaceE.CartTableModel;
import User_InterfaceE.DAO;
import User_InterfaceE.OrderDetail;
import User_InterfaceE.SupplyHome;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InventoryStatusTwo extends JFrame {

	private JPanel contentPane;
	private Product_DAO dao;
	private Status_DAO Sdao;
	private java.util.List<String> list;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryStatusTwo frame = new InventoryStatusTwo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public InventoryStatusTwo() throws Exception {
		
		try {
			dao = new Product_DAO();
			Sdao = new Status_DAO();
			list = dao.getAllMaterialsNo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		setTitle("Lee-Hu Pastry");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 220);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("存貨現況 (2/2)");
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
		
		H1.setBounds(851, 6, 60, 60);
		Image Himg2 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		H1.setIcon(new ImageIcon(Himg2));
		contentPane.add(H1);
		
		JLabel label_2 = new JLabel("(* 不易腐壞 -> 經濟訂購)");
		label_2.setForeground(new Color(240, 128, 128));
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		label_2.setBounds(63, 40, 181, 22);
		contentPane.add(label_2);
		
		JButton button = new JButton("上一頁");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				InventoryStatus is = new InventoryStatus();
				is.main(null);
			}
		});
		button.setBounds(753, 39, 91, 29);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 81, 882, 68);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setTable();
		
		
		JButton button_1 = new JButton("查看庫存狀況");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get the selected item
				int row = table.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					JOptionPane.showMessageDialog(InventoryStatusTwo.this, "請選擇原料項目！", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				RawMaterials tempRawMaterials = (RawMaterials) table.getValueAt(row, InventoryTableModel.OBJECT_COL);
				
				MaterialDialog dialog = null;
				try {
					
					dialog = new MaterialDialog(InventoryStatusTwo.this, Sdao, tempRawMaterials, true);
					
					dialog.setVisible(true);
					
					dialog.adjustInventory();

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_1.setBounds(789, 163, 122, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("重新整理");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
					try {
						setTable();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		button_2.setBounds(18, 161, 117, 29);
		contentPane.add(button_2);
	}
	
	void setTable() throws InterruptedException{
		
		List<RawMaterials> rawMaterials = null;
				
		rawMaterials = Sdao.getGeneralMaterials();

		InventoryTableModel model = new InventoryTableModel(rawMaterials);
		table.setModel(model);
	}

}
