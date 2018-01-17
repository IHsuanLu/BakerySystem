package User_InterfaceE;

import java.util.List;


import javax.swing.table.AbstractTableModel;



public class CartTableModel extends AbstractTableModel {
	
	static final int OBJECT_COL = -1;
	private static final int ORDERNO_COL = 0;
	private static final int PNAME_COL = 1;
	private static final int QTY_COL = 2;
	private static final int PRICE_COL = 3;
	
	
	private String[] columnNames = { "Order Number", "Product Name", "Quantity", "Price" };
	
	private List<OrderDetail> orderdetail;

	public CartTableModel(List<OrderDetail> theOrderDetail) {
		orderdetail = theOrderDetail;
	}


	@Override
	public int getRowCount() {
		return orderdetail.size(); 
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		OrderDetail tempOrderDetail = orderdetail.get(row);

		switch (col) {
		case ORDERNO_COL:
			return tempOrderDetail.getOrderno();
		case PNAME_COL:
			return tempOrderDetail.getPname();
		case QTY_COL:
			return tempOrderDetail.getQuantity();
		case PRICE_COL:
			return tempOrderDetail.getPrice();
		case OBJECT_COL:
			return tempOrderDetail;
		default:
			return tempOrderDetail.getOrderno();
		}
	}
	
	@Override
	public String getColumnName(int index) {
	    return columnNames[index];
	}


}
