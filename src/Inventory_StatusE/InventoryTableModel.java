package Inventory_StatusE;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int MATERIALS_NUMBER_COL = 0;
	private static final int MATERIALS_NAME_COL = 1;
	private static final int MATERIALS_PRICE_COL = 2;
	private static final int MATERIALS_WEIGHT_COL = 3;
	private static final int LATEST_PURCHASE_COL = 4;
	private static final int LATEST_ORDER_NO = 5;

	private String[] columnNames = { "m_no", "m_name", "m_price",
			"m_weight", "latest_purchase", "latest_orderno"};
	
	List<RawMaterials> rawMaterials;
	
	public InventoryTableModel(List<RawMaterials> theRawMaterials){
		
		
//		rawMaterials.add(theRawMaterials.get(1));
//		rawMaterials.add(theRawMaterials.get(2));
//		rawMaterials.add(theRawMaterials.get(3));
		rawMaterials = theRawMaterials;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rawMaterials.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		
		RawMaterials tempRawMaterials = rawMaterials.get(row);
		SimpleDateFormat st = new SimpleDateFormat("YYYY-MM-dd");
		
		switch(col){
		case MATERIALS_NUMBER_COL:
			return tempRawMaterials.getM_no();
		case MATERIALS_NAME_COL:
			return tempRawMaterials.getM_name();
		case MATERIALS_PRICE_COL:
			return tempRawMaterials.getM_price();
		case MATERIALS_WEIGHT_COL:
			return tempRawMaterials.getM_weight();
		case LATEST_PURCHASE_COL:
			return tempRawMaterials.getLatest_Purchase();
		case LATEST_ORDER_NO:
			return tempRawMaterials.getLatest_Orderno();
		case OBJECT_COL:
			return tempRawMaterials;
		default:
			return null;
		}
	}
	
	public String getColumnName(int index) {
	    return columnNames[index];
	}
}
