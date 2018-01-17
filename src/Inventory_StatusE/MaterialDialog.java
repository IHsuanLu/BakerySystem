package Inventory_StatusE;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class MaterialDialog extends JDialog implements EOQ_Elements {

	private final JPanel contentPanel = new JPanel();


	private Status_DAO Sdao;
	private InventoryStatusTwo inventoryStatusTwo;
	private RawMaterials exRawMaterials = null;
	private boolean updateMode = false;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	public MaterialDialog(InventoryStatusTwo theInventoryStatusTwo, Status_DAO theSdao, RawMaterials theExRawMaterials, boolean theUpdateMode) throws InterruptedException{
		
		this();
		inventoryStatusTwo = theInventoryStatusTwo;
		Sdao = theSdao;
		exRawMaterials = theExRawMaterials;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Inventory");
				
			populateGui(exRawMaterials);
			
			setEOQElement();
		}
	
	}

	
	private void populateGui(RawMaterials theExRawMaterials) {
				
		textField.setText(theExRawMaterials.getM_name());
		textField_1.setText(String.valueOf(theExRawMaterials.getM_price()));
		textField_2.setText(String.valueOf(theExRawMaterials.getM_weight()));
		textField_3.setText(theExRawMaterials.getLatest_Purchase());
		textField_4.setText(theExRawMaterials.getLatest_Orderno());	
		textField_12.setText(theExRawMaterials.getM_no());

	}
	
	private void setEOQElement() throws InterruptedException{
		
		if(textField.getText().equals("Flour")){
			
			textField_5.setText(String.format("%.0f", fEOQ));
			textField_7.setText(String.format("%.0f", fExpectedDemand));
			textField_8.setText(String.valueOf(orderCost));
			textField_9.setText(String.format("%.4f", fKeepCost));
			
			textField_6.setText(String.format("%.0f", fROP));
			textField_10.setText(String.format("%.0f", fAverageDailyDemand));
			textField_11.setText(String.valueOf(leadTime));

		} else if (textField.getText().equals("Butter")){
			
			textField_5.setText(String.format("%.0f", bEOQ));
			textField_7.setText(String.format("%.0f", bExpectedDemand));
			textField_8.setText(String.valueOf(orderCost));
			textField_9.setText(String.format("%.4f", bKeepCost));

			textField_6.setText(String.format("%.0f", bROP));
			textField_10.setText(String.format("%.0f", bAverageDailyDemand));
			textField_11.setText(String.valueOf(leadTime));
			
		} else if (textField.getText().equals("Sugar")){
			
			textField_5.setText(String.format("%.0f", sEOQ));
			textField_7.setText(String.format("%.0f", sExpectedDemand));
			textField_8.setText(String.valueOf(orderCost));
			textField_9.setText(String.format("%.4f", sKeepCost));

			textField_6.setText(String.format("%.0f", sROP));
			textField_10.setText(String.format("%.0f", sAverageDailyDemand));
			textField_11.setText(String.valueOf(leadTime));
		} 
	}
	
	public void adjustInventory() throws InterruptedException{
				
		Thread.sleep(100);
		
		if(Integer.parseInt(textField_2.getText()) < Integer.parseInt(textField_6.getText())){

			int response = JOptionPane.showConfirmDialog(MaterialDialog.this, "庫存小於再訂購點，是否進貨？");
			
			if (response == JOptionPane.YES_OPTION){
				
				Date date = new Date(); 
				SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				
				int totalWeight = Integer.parseInt(textField_2.getText()) + Integer.parseInt(textField_5.getText());
				
				
				Sdao.updateMaterialWeight(totalWeight, ft.format(date), textField_12.getText(), date.getTime());

				JOptionPane.showMessageDialog(MaterialDialog.this, "進貨成功！" + "\n目前庫存： " + totalWeight + "\n" + "原料將於兩天後送達");
				
				
				textField_3.setText(ft.format(date));
				textField_2.setText(String.valueOf(totalWeight));
				textField_4.setText(String.valueOf(date.getTime()));
				
			} else {
				JOptionPane.showMessageDialog(MaterialDialog.this, "賠錢不要怪我");
			}
		}
	}


	public static void main(String[] args) {
		try {
			MaterialDialog dialog = new MaterialDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MaterialDialog() {
		
		setTitle("Lee-Hu Pastry");
		
		setBounds(100, 100, 599, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSystemSuggestion = new JLabel("System Suggestion");
		Image Logoimg = new ImageIcon(this.getClass().getResource("/info.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		lblSystemSuggestion.setIcon(new ImageIcon(Logoimg));
		lblSystemSuggestion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSystemSuggestion.setForeground(new Color(255, 255, 255));
		lblSystemSuggestion.setBounds(6, 6, 220, 30);
		contentPanel.add(lblSystemSuggestion);
		
		JLabel label = new JLabel("使用模型：經濟訂購量模型");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(32, 185, 194, 20);
		contentPanel.add(label);
		{
			JLabel label_1 = new JLabel("原料品項：");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label_1.setBounds(63, 81, 80, 20);
			contentPanel.add(label_1);
		}
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(105, 105, 105));
		textField.setBounds(144, 77, 112, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("成本 (克)：");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(63, 109, 90, 20);
		contentPanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(105, 105, 105));
		textField_1.setColumns(10);
		textField_1.setBounds(144, 105, 112, 26);
		contentPanel.add(textField_1);
		
		JLabel label_2 = new JLabel("產品資訊：");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_2.setBounds(32, 51, 194, 20);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("剩餘庫存：");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_3.setBounds(63, 137, 90, 20);
		contentPanel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(105, 105, 105));
		textField_2.setColumns(10);
		textField_2.setBounds(144, 135, 112, 26);
		contentPanel.add(textField_2);
		
		JLabel label_4 = new JLabel("上次訂購時間：");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_4.setBounds(268, 107, 128, 20);
		contentPanel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(new Color(105, 105, 105));
		textField_3.setColumns(10);
		textField_3.setBounds(382, 105, 187, 26);
		contentPanel.add(textField_3);
		
		JLabel label_5 = new JLabel("編號：");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_5.setBounds(268, 137, 128, 20);
		contentPanel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(105, 105, 105));
		textField_4.setColumns(10);
		textField_4.setBounds(318, 135, 119, 26);
		contentPanel.add(textField_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 169, 537, 12);
		contentPanel.add(separator);
		
		JLabel lblEoq = new JLabel("EOQ：");
		lblEoq.setForeground(Color.WHITE);
		lblEoq.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEoq.setBounds(63, 225, 80, 20);
		contentPanel.add(lblEoq);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 0));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setBounds(114, 223, 112, 26);
		contentPanel.add(textField_5);
		
		JLabel lblRop = new JLabel("ROP：");
		lblRop.setForeground(Color.WHITE);
		lblRop.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblRop.setBounds(332, 225, 80, 20);
		contentPanel.add(lblRop);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 0, 0));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setBounds(384, 223, 112, 26);
		contentPanel.add(textField_6);
		
		JLabel label_6 = new JLabel("本期需求預測：");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_6.setBounds(63, 263, 128, 20);
		contentPanel.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.WHITE);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(105, 105, 105));
		textField_7.setBounds(192, 261, 119, 26);
		contentPanel.add(textField_7);
		
		JLabel label_7 = new JLabel("訂購成本：");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_7.setBounds(63, 290, 128, 20);
		contentPanel.add(label_7);
		
		JLabel label_8 = new JLabel("持有成本：");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_8.setBounds(63, 318, 128, 20);
		contentPanel.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.WHITE);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(105, 105, 105));
		textField_8.setBounds(158, 288, 119, 26);
		contentPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.WHITE);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(105, 105, 105));
		textField_9.setBounds(158, 316, 119, 26);
		contentPanel.add(textField_9);
		
		JLabel label_9 = new JLabel("過去平均日需求：");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_9.setBounds(332, 266, 128, 20);
		contentPanel.add(label_9);
		
		JLabel label_10 = new JLabel("前置時間：");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_10.setBounds(332, 293, 128, 20);
		contentPanel.add(label_10);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.WHITE);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(105, 105, 105));
		textField_10.setBounds(460, 261, 119, 26);
		contentPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setForeground(Color.WHITE);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(105, 105, 105));
		textField_11.setBounds(412, 288, 119, 26);
		contentPanel.add(textField_11);
		
		JLabel label_11 = new JLabel("/");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_11.setBounds(268, 81, 61, 16);
		contentPanel.add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setForeground(Color.WHITE);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(105, 105, 105));
		textField_12.setBounds(290, 77, 112, 26);
		contentPanel.add(textField_12);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 255, 255));
			buttonPane.setBackground(new Color(105, 105, 105));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("關閉");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
