package Inventory_ManagementE;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Inventory_ManagementE.Inventory;

class InventoryTableModel extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	private static final int PRODUCT_NUMBER_COL = 0;
	private static final int PRODUCT_NAME_COL = 1;
	private static final int PRICE_COL = 2;
	private static final int YEAR_COL = 3;
	private static final int DESCRIPTION_COL = 4;
	private static final int QTY_COL = 5;
	
	private String[] columnNames = { "Product Number", "Product Name", "Price",
			"Year", "Description", "Quantity" };
	private List<Inventory> Inventory;
 
	public InventoryTableModel(List<Inventory> theInventory) {
		Inventory = theInventory;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return Inventory.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Inventory tempInventory = Inventory.get(row);

		switch (col) {
		case PRODUCT_NUMBER_COL:
			return tempInventory.getPno();
		case PRODUCT_NAME_COL:
			return tempInventory.getPname();
		case PRICE_COL:
			return tempInventory.getPrice();
		case YEAR_COL:
			return tempInventory.getYear();
		case DESCRIPTION_COL:
			return tempInventory.getDescription();
		case QTY_COL:
			return tempInventory.getQty();
		case OBJECT_COL:
			return tempInventory;
		default:
			return tempInventory.getPname();
		}
	}
}
