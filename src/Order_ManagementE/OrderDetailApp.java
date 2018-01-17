package Order_ManagementE;

import java.awt.BorderLayout;

import User_InterfaceE.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

//import DB.InventoryDAO;

//import DB.OrderListDAO;
//import DB.Inventory;
//import DB.OrderList;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderDetailApp extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtHi;
	private OrderListDAO orderlistdao;
	private InventoryDAO inventorydao;
	private String selectedvalue;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailApp frame = new OrderDetailApp();
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
	public OrderDetailApp() throws Exception {
			orderlistdao = new OrderListDAO();
			inventorydao = new InventoryDAO(); 
		try {
			
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		
		setTitle("Order List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//編號
		DefaultListModel<String> l1 = new DefaultListModel<>(); 
		//產品名稱
		DefaultListModel<String> l2 = new DefaultListModel<>(); 
		//數量
		DefaultListModel<String> l3 = new DefaultListModel<>(); 
		//庫存
		DefaultListModel<String> l4 = new DefaultListModel<>();
		//位置
		DefaultListModel<String> l5 = new DefaultListModel<>();
		//搜尋
		DefaultListModel<String> l6 = new DefaultListModel<>();
		
		for(int i =0;i<orderlistdao.getAllOrderList().size();i++){
          l1.addElement(orderlistdao.getAllOrderList().get(i));  
          
		}
          System.out.println(l1);
          JScrollPane scrollPane = new JScrollPane();
          scrollPane.setBounds(29, 96, 179, 323);
          contentPane.add(scrollPane);
          JList<String> list = new JList<>(l1);
          scrollPane.setViewportView(list);
          list.setFont(new Font("Arial", Font.PLAIN, 20));
          list.addMouseListener(new MouseAdapter() {
          	@Override
          	public void mouseClicked(MouseEvent e) {
          		if (e.getClickCount() == 2) {
          			try {
          				l2.removeAllElements();
          				l3.removeAllElements();
          				l4.removeAllElements();
          				l5.removeAllElements();
          				System.out.println(list.getSelectedValue());
          				selectedvalue = list.getSelectedValue();
//          				System.out.println(orderlistdao.getAllPname(list.getSelectedValue()));
          				// 商品名稱
						for(int i =0;i < orderlistdao.getAllPname(list.getSelectedValue()).size();i++){
						  String a = orderlistdao.getAllPname(list.getSelectedValue()).get(i);
						  l2.addElement(orderlistdao.getAllPname(list.getSelectedValue()).get(i));
						  l3.addElement(orderlistdao.getQuantity(list.getSelectedValue()).get(i));
						  l4.addElement(inventorydao.getQuantity(a).get(0));
						  a=null;
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
          			
          		}
          	}
          });
          
          JList list_1 = new JList<>(l2);
          list_1.setBounds(217, 96, 161, 322);
          list_1.setFont(new Font("Arial", Font.PLAIN, 18));
          contentPane.add(list_1);
          
          JLabel lblOrderno = new JLabel("訂單編號 ");
          lblOrderno.setForeground(new Color(255, 255, 255));
          lblOrderno.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          lblOrderno.setBounds(29, 61, 122, 37);
          contentPane.add(lblOrderno);
          
          JLabel lblProductname = new JLabel("產品名稱 ");
          lblProductname.setForeground(new Color(255, 255, 255));
          lblProductname.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          lblProductname.setBounds(220, 68, 135, 23);
          contentPane.add(lblProductname);
          
          JLabel lblQty = new JLabel("數量 ");
          lblQty.setForeground(new Color(255, 255, 255));
          lblQty.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          lblQty.setBounds(387, 68, 48, 23);
          contentPane.add(lblQty);
          
          JList list_2 = new JList<>(l3);
          list_2.setBounds(388, 96, 41, 323);
          list_2.setFont(new Font("Arial", Font.PLAIN, 20));
          contentPane.add(list_2);
          
          JLabel lblInvenqty = new JLabel("庫存數量");
          lblInvenqty.setForeground(new Color(255, 255, 255));
          lblInvenqty.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          lblInvenqty.setBounds(439, 68, 72, 23);
          contentPane.add(lblInvenqty);
          
          JButton btnSend = new JButton("寄送訂單");
          btnSend.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		try {
          			
          			if(e.getSource() == btnSend){
          				
          				for(int i=0;i<orderlistdao.getAllPname(list.getSelectedValue()).size();i++){
          				inventorydao.changeQty(list.getSelectedValue(), orderlistdao.getAllPname(list.getSelectedValue()).get(i));
          				}
          				
          				orderlistdao.deleteOrderList(list.getSelectedValue());
          				
          				orderlistdao.deleteOrder(list.getSelectedValue());
          				
          			}
          			
          			JOptionPane.showMessageDialog(null, "訂單已寄送\n");
          			
          			dispose();
          			OrderDetailApp frame = new OrderDetailApp();
					frame.setVisible(true);
          			
					
				} catch (Exception exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}
          		
          	}
          });
          btnSend.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          btnSend.setBounds(520, 106, 147, 55);
          contentPane.add(btnSend);
          
          JList list_3 = new JList<>(l4);
          list_3.setBounds(439, 96, 72, 322);
          list_3.setFont(new Font("Arial", Font.PLAIN, 20));
          contentPane.add(list_3);
          
          JButton btnBack = new JButton("登出");
          btnBack.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		dispose();
          		
          		Login l = new Login();
          		l.main(null);
          	}
          });
          btnBack.setFont(new Font("Dialog", Font.PLAIN, 13));
          btnBack.setBounds(522, 389, 81, 29);
          contentPane.add(btnBack);
          
          JLabel label = new JLabel("");
          Image Logoimg= new ImageIcon(this.getClass().getResource("/Home.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
          label.setIcon(new ImageIcon(Logoimg));
          label.setBounds(618, 6, 60, 60);
          contentPane.add(label);
          
          JLabel label_1 = new JLabel("搜尋訂單編號 : ");
          label_1.setForeground(new Color(255, 255, 255));
          label_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          label_1.setBounds(29, 26, 137, 23);
          contentPane.add(label_1);
          
          textField = new JTextField();
          textField.setToolTipText("");
          textField.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
          textField.setBounds(161, 24, 122, 29);
          contentPane.add(textField);
          textField.setColumns(10);
          
          JLabel label_2 = new JLabel("");
  		  label_2.setBounds(608, 349, 70, 70);
  		  Image Logomg = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
  		  label_2.setIcon(new ImageIcon(Logomg));
  		  contentPane.add(label_2);
          
          JButton btnNewButton = new JButton("搜尋");
          btnNewButton.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		String lastName = textField.getText();
          		if (lastName != null && lastName.trim().length() > 0) {
          			try {
          				l1.removeAllElements();
						for(int i =0;i<orderlistdao.searchOrderList(lastName).size();i++){
							l1.addElement(orderlistdao.searchOrderList(lastName).get(i));
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						l1.removeAllElements();
						for(int i =0;i<orderlistdao.getAllOrderList().size();i++){
						      l1.addElement(orderlistdao.getAllOrderList().get(i));  
						      
							}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
          	}
          });
          btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 16));
          btnNewButton.setBounds(311, 24, 81, 31);
          contentPane.add(btnNewButton);
          
          JButton button = new JButton("");
          button.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		dispose();
          		
          		SupplyHome s = new SupplyHome();
          		s.main(null);
          	}
          });
          button.setBounds(611, 6, 65, 65);
          contentPane.add(button);
		
		
		
		txtHi = new JTextField();
		txtHi.setBackground(Color.WHITE);
		txtHi.setForeground(Color.BLACK);
		txtHi.setHorizontalAlignment(SwingConstants.TRAILING);
		txtHi.setText("\u4F60\u597D");
		txtHi.setEditable(false);
		txtHi.setEnabled(false);
	}
}
