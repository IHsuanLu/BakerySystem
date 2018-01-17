package Inventory_ManagementE;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import Inventory_ManagementE.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField qtyTextField;
	
	private Ddao Ddao;
	private InventoryApp inventoryApp;
	private Inventory exInventory = null;
	private boolean updateMode = false;
	
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextField yearTextField;
	private JTextField descriptionTextField;

	public ProductDialog(InventoryApp theInventoryApp, Ddao theDdao, Inventory theExInventory, boolean theUpdateMode){
				
			this();
			Ddao = theDdao;
			inventoryApp = theInventoryApp;
			exInventory = theExInventory;
			updateMode = theUpdateMode;
				
			if(updateMode){
				setTitle("Update Inventory");
					
				populateGui(exInventory);
			}
	}
	

	private void populateGui(Inventory theInventory){
		idTextField.setText(theInventory.getPno());
		nameTextField.setText(theInventory.getPname());
		priceTextField.setText(theInventory.getPrice());
		yearTextField.setText(theInventory.getYear());
		descriptionTextField.setText(theInventory.getDescription());
		qtyTextField.setText(String.valueOf(theInventory.getQty()));
	}
	
	public ProductDialog(InventoryApp theInventoryApp,
			Ddao theDdao){
		this(theInventoryApp, theDdao, null, false);
	}
	

	/**
	 * Create the dialog.
	 */
	public ProductDialog() {
		
		setTitle("庫存修改");
		setBounds(100, 100, 381, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("產品庫存");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(53, 196, 88, 16);
		contentPanel.add(lblNewLabel);
		
		qtyTextField = new JTextField();
		qtyTextField.setBounds(134, 192, 130, 26);
		contentPanel.add(qtyTextField);
		qtyTextField.setColumns(10);
		
		JLabel label = new JLabel("產品編號");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(53, 23, 69, 16);
		contentPanel.add(label);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(134, 18, 130, 26);
		contentPanel.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("產品名稱");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(53, 51, 69, 16);
		contentPanel.add(label_1);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(134, 46, 130, 26);
		contentPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("價格");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_2.setBounds(86, 78, 32, 16);
		contentPanel.add(label_2);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(134, 74, 130, 26);
		contentPanel.add(priceTextField);
		priceTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("年份");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_3.setBounds(86, 106, 32, 16);
		contentPanel.add(label_3);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(134, 102, 130, 26);
		contentPanel.add(yearTextField);
		yearTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("介紹");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_4.setBounds(86, 134, 32, 16);
		contentPanel.add(label_4);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(134, 131, 130, 26);
		contentPanel.add(descriptionTextField);
		descriptionTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("（不得更改）");
		label_5.setBounds(264, 24, 88, 16);
		contentPanel.add(label_5);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveInventory();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveInventory(){
		//get the qty from gui
		String id = idTextField.getText();
		String name = nameTextField.getText();
		String price = priceTextField.getText();
		String year = yearTextField.getText();
		String description = descriptionTextField.getText();
		Integer qty = Integer.parseInt(qtyTextField.getText());
		
		Inventory tempInventory = null;
		
		if(updateMode){
			tempInventory = exInventory;
			
			tempInventory.setPno(id);
			tempInventory.setPname(name);
			tempInventory.setPrice(price);
			tempInventory.setYear(year);
			tempInventory.setDescription(description);
			tempInventory.setQty(qty);
		}else {
			tempInventory = new Inventory(id, name, price, year,
					description, qty);
		}
		
		try{
			// save to the database
			if (updateMode) {
				Ddao.updateInventory(tempInventory);
			} else {
				return;
			}
			
			setVisible(false);
			dispose();
		    
			inventoryApp.refreshInventoryView();
			
			//show success message
			JOptionPane.showMessageDialog(inventoryApp,
					"產品庫存更新成功.", "庫存已儲存",
					JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception exc){
			JOptionPane.showMessageDialog(inventoryApp, 
					"Error saving inventory: " + exc.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		
		}
	}
	

	
}
