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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Cart extends JFrame {

	private JFrame frameBetterJadeSystemC;
	private JPanel contentPane;
	private JTable table;
	private DAO dao;
	private JTextField totalPriceTextField;
	
	
	private String theCounter1;
	
	private String Muname;
	private long counter;	

	public static void main(String[] args) {
		
	}

	public Cart(String Muname, long counter) {
		
		// create the DAO
		try {
			dao = new DAO(Muname, counter);
			
			this.Muname = Muname;
			this.counter = counter;
			
			System.out.println(Muname + " from Cart");
			System.out.println(counter  + " from Cart");
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		
		
		
		setTitle("Lee-Hu Pastry");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShopping = new JLabel("  Shopping Cart");
		lblShopping.setForeground(new Color(255, 255, 255));
		Image Cimg5 = new ImageIcon(this.getClass().getResource("/ShoppingCart.png")).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		lblShopping.setIcon(new ImageIcon(Cimg5));
		lblShopping.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblShopping.setBounds(292, 6, 213, 65);
		contentPane.add(lblShopping);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 83, 695, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setTable();
		
		JButton button = new JButton("確認");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					int Size = getRowCount();
					
					if(Size != 0){
						
						int response = JOptionPane.showConfirmDialog(Cart.this, "送出訂單？", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if (response == JOptionPane.YES_OPTION){
							
							String totalPrice = totalPriceTextField.getText();
							dao.insertIntoOrder(Integer.parseInt(totalPrice));
							
							JOptionPane.showMessageDialog(null, "下單成功！ 請在三天內返回店面取貨！");
							
							setEmptyTable();
							totalPriceTextField.setText(null);
							
							
							JOptionPane.showMessageDialog(null, "謝謝光臨！");
							
							dispose();

							
						} else {
							return;
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "購物車內為空！");
					}
				} catch(Exception exc){
					exc.printStackTrace();
				}
			
			}
		
		});
		button.setBounds(637, 451, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String theCounter = "#" + String.valueOf(counter);
				dao.DeleteFromCartALL(theCounter);
				
				dispose();
			}
		});
		button_1.setBounds(508, 451, 117, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("刪除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == button_2) {
//					refreshCartView();
					totalPriceTextField.setText("運算中。。。");
				}
				
				
				// get the selected row
				int row = table.getSelectedRow();
				
				if(row<0){
					JOptionPane.showMessageDialog(null, "請選擇欲刪除的項目！");
					setTextField();
				} else{
				//確認刪除？
				int response = JOptionPane.showConfirmDialog(Cart.this, "確定刪除？", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (response != JOptionPane.YES_OPTION){
					return;
				}
				}
				
				// get the current row
				OrderDetail theOrderDetail = (OrderDetail) table.getValueAt(row, CartTableModel.OBJECT_COL);
				
				// delete the order detail
				dao.DeleteFromCart(theOrderDetail.getPname());
				
				// refresh GUI
				refreshCartView();
			
			}
		});
		button_2.setBounds(637, 387, 117, 29);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("總價：");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(54, 387, 61, 40);
		contentPane.add(lblNewLabel);
		
		totalPriceTextField = new JTextField();
		totalPriceTextField.setEditable(false);
		
		setTextField();

		totalPriceTextField.setBounds(116, 397, 102, 22);
		contentPane.add(totalPriceTextField);
		totalPriceTextField.setColumns(10);
		
		JButton button_3 = new JButton("產品清單");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				
				Product1 P = new Product1(Muname, counter);
				
				P.main(null);
				
				dispose();
			}
		});
		button_3.setBounds(54, 451, 117, 29);
		contentPane.add(button_3);
	}
	
	void setTable(){
		
		List<OrderDetail> orderdetail = null;
		
		String theCounter = "#" + String.valueOf(counter);
		
		orderdetail = dao.getOrderDetail(theCounter);
		
		CartTableModel model = new CartTableModel(orderdetail);
		table.setModel(model);
	}
	
	void setEmptyTable(){
		
		List<OrderDetail> orderdetail = null;
		
		orderdetail = dao.getEmptyOrderDetail();
		
		CartTableModel model = new CartTableModel(orderdetail);
		table.setModel(model);
	}


	public void refreshCartView() {

		try {
			
			String theCounter = "#" + String.valueOf(counter);

			List<OrderDetail> orderdetail = dao.getOrderDetail(theCounter);

			// create the model and update the "table"
			CartTableModel model = new CartTableModel(orderdetail);
			table.setModel(model);

			
			// 再算一次
			theCounter = "#" + String.valueOf(counter);
			totalPriceTextField.setText(String.valueOf(dao.getCalculateFactor1(theCounter)));
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void setTextField(){
		String theCounter = "#" + String.valueOf(counter);
		totalPriceTextField.setText(String.valueOf(dao.getCalculateFactor1(theCounter)));
	}
	
	public int getRowCount() {
		
		List<OrderDetail> orderdetail = null;
		
		String theCounter = "#" + String.valueOf(counter);
		
		orderdetail = dao.getOrderDetail(theCounter);
		
		return orderdetail.size(); 
	}


}
