package Customer_ManagementE;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JTextField;


public class customer extends JFrame {
	
	private JPanel contentPane;
	private customerDAO customerDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer frame = new customer();
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
	public customer() throws Exception {
		try {
			customerDAO = new customerDAO();

		} catch (Exception exc){
			exc.printStackTrace();
		}
		//編號
		DefaultListModel<String> x1 = new DefaultListModel<>(); 
		//M
		DefaultListModel<String> x2 = new DefaultListModel<>(); 
		//R
		DefaultListModel<String> x3 = new DefaultListModel<>(); 
		//F
		DefaultListModel<String> x4 = new DefaultListModel<>(); 
		//RFM
		DefaultListModel<String> x5 = new DefaultListModel<>(); 
		//RFMresult
		DefaultListModel<String> x6 = new DefaultListModel<>(); 
		//rate
		DefaultListModel<Double> x7 = new DefaultListModel<>();
		//rfmtest
		DefaultListModel<Double> x8 = new DefaultListModel<>(); 
		DefaultListModel<Integer> x9 = new DefaultListModel<>();
		DefaultListModel<String> test1 = new DefaultListModel<>(); 
		DefaultListModel<String> test2 = new DefaultListModel<>();
		for(int i =0;i<customerDAO.getCusList().size();i++){
	          x1.addElement(customerDAO.getCusList().get(i)); 
			}
		System.out.println(x1);

		for(int i =0;i<customerDAO.findF1().size();i++){
	          test1.addElement(customerDAO.findF1().get(i));
			}
		Integer element =222;
		Integer element1 =211;
		Integer element2 =122;
		Integer element3 =112;
        x9.add(0, element);
        x9.add(1,element1);
        x9.add(2,element2);
        x9.add(3,element3);
		for(int i =0;i<customerDAO.findF2().size();i++){
	          test2.addElement(customerDAO.findF2().get(i)); 
			}
		Integer e =212;
		Integer e1 =221;
		Integer e2 =121;
		Integer e3 =111;
        x9.add(4, e);
        x9.add(5,e1);
        x9.add(6,e2);
        x9.add(7,e3);
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(x9);
		
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("顧客資料");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(19, 6, 95, 51);
		contentPane.add(lblNewLabel);

		
		JLabel lblNewLabel_1 = new JLabel("顧客編號");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 60, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("消費金額");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		label.setBounds(131, 60, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("最近消費日期");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(206, 61, 78, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("購買次數");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(358, 61, 52, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("RFM");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(422, 61, 32, 16);
		contentPane.add(label_3);
		
		JList<String> list = new JList<>(x1);
		list.setBounds(19, 88, 95, 271);
		list.setFont(new Font("Arial", Font.PLAIN, 14));
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() ==1 ){
						try{
							x2.removeAllElements();
							x3.removeAllElements();
							x4.removeAllElements();
							x5.removeAllElements();
							System.out.println(list.getSelectedValue());
							for(int i=0; i< customerDAO.getM(list.getSelectedValue()).size(); i++){
								x2.addElement(customerDAO.getM(list.getSelectedValue()).get(i));
								x3.addElement(customerDAO.getR(list.getSelectedValue()).get(i));
								x4.addElement(customerDAO.getF(list.getSelectedValue()).get(i));
								x5.addElement(customerDAO.RFM(list.getSelectedValue()).get(i));
								System.out.println(x2);
								System.out.println(x3);
								System.out.println(x4);
								System.out.println(x5);
								}
							
						}catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		contentPane.add(list);
		
		JList list_1 = new JList<>(x2);
		list_1.setFont(new Font("Arial", Font.PLAIN, 14));
		list_1.setBounds(130, 88, 62, 23);
		contentPane.add(list_1);
		
		JList list_2 = new JList<>(x3);
		list_2.setBounds(204, 88, 149, 23);
		list_2.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(list_2);
		
		JList list_3 = new JList<>(x4);
		list_3.setBounds(365, 88, 42, 23);
		contentPane.add(list_3);
		
		JList list_4 = new JList<>(x5);
		list_4.setBounds(422, 88, 61, 23);
		contentPane.add(list_4);
		
		JButton button = new JButton("分析");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					x6.removeAllElements();
					x7.removeAllElements();
					x8.removeAllElements();
					
					for(int i =0;i<customerDAO.showRFM().size();i++){
					      x6.addElement(customerDAO.showRFM().get(i)); 
						}
					for(int i =0;i<customerDAO.showRes().size();i++){
					      x7.addElement(customerDAO.showRes().get(i));
					      x8.addElement(customerDAO.showRes().get(i));
						}
					
					for(int i=0; i<x8.size();i++){
						x8.remove(i);
						x8.add(i,x7.getElementAt(i)/0.12);
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(x6);
				System.out.println(x7);
				System.out.println(x8);
				
			}
		});
		button.setBounds(108, 15, 117, 29);
		contentPane.add(button);
		
		JLabel lblRfmResult = new JLabel("顧客分群 RFM");
		lblRfmResult.setForeground(Color.BLACK);
		lblRfmResult.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRfmResult.setBounds(160, 123, 183, 29);
		contentPane.add(lblRfmResult);
		
		JList list_5 = new JList(x6);
		list_5.setBounds(160, 190, 59, 166);
		contentPane.add(list_5);
		
		JList list_6 = new JList(x7);
		list_6.setBounds(217, 190, 67, 166);
		contentPane.add(list_6);
		
		JLabel label_4 = new JLabel("群組");
		label_4.setBounds(160, 162, 32, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("回應率");
		label_5.setBounds(217, 162, 51, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("損益平衡值");
		label_6.setBounds(284, 162, 78, 16);
		contentPane.add(label_6);
		
		JList list_7 = new JList(x8);
		list_7.setBounds(284, 190, 188, 166);
		contentPane.add(list_7);
		
		
		
		
		
	}
}
