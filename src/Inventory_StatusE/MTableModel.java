package Inventory_StatusE;

import javax.swing.AbstractAction;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class MTableModel extends AbstractTableModel implements Constants {

	
	public List<Integer> getDemandValue(){
		
		List<Integer> demandList = new ArrayList<>();
		
		for(int d : mDemand){
			demandList.add(d);
		}
		return demandList;
	}
	
	public List<Double> getFrequencyValue(){
		
		List<Double> frequencyList = new ArrayList<>();
		
		for(double f : mFrequency){
			frequencyList.add(f);
		}
		return frequencyList;
	}
	
	public List<Double> getCumulativeFrequencyValue(){
		
		List<Double> cumulativeFrequencyList = new ArrayList<>();
		
		for(double cf : mCumulativeFrequency){
			cumulativeFrequencyList.add(cf);
		}
		return cumulativeFrequencyList;
	}
	
	
	@Override
	public int getRowCount() {
		return 6;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
		case DEMAND_COL:
			return getDemandValue().get(row);
		case FREQUENCY_COL:
			return getFrequencyValue().get(row);
		case CUMULATIVE_FREQUENCY_COL:
			return getCumulativeFrequencyValue().get(row);
		default:
			return null;
		}
	}
	
	public String getColumnName(int index) {
	    return columnNames[index];
	}
}
