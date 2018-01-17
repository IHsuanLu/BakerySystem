package Inventory_StatusE;

import Product_ProduceE.Product_DAO;
import User_InterfaceE.DAO;
 

public interface Constants {
	
	Status_DAO Sdao = new Status_DAO();
	
	
	static final int DEMAND_COL = 0;
	static final int FREQUENCY_COL = 1;
	static final int CUMULATIVE_FREQUENCY_COL = 2;
	
	public String[] columnNames = {"Demand (BOX)", "Frequency", "Cumulative Frequency"};


	//customize
	public int[] pDemand = {230,235,240,245,250,255};
	public double[] pFrequency = {0.1, 0.15, 0.25, 0.25, 0.15, 0.1};
	public double[] pCumulativeFrequency = {0.1, 0.25, 0.5, 0.75, 0.9, 1};
	public double pCs = Sdao.getPrice("P001") - 7;
	public double pCe = 7 - 2;
	public double pService = pCs/(pCs+pCe);
	
	public int[] mDemand = {69,72,75,78,81,90};
	public double[] mFrequency = {0.1, 0.24, 0.40, 0.16, 0.07, 0.03};
	public double[] mCumulativeFrequency = {0.10, 0.34, 0.74, 0.90, 0.97, 1};
	public double mCs = Sdao.getPrice("M001") - 10;
	public double mCe = 10 - 2;
	public double mService = mCs/(mCs+mCe);
	
	public int[] cDemand = {91,94,97,100,103,106};
	public double[] cFrequency = {0.08, 0.15, 0.27, 0.19, 0.18, 0.13};
	public double[] cCumulativeFrequency = {0.08, 0.23, 0.5, 0.69, 0.87, 1};
	public double cCs = Sdao.getPrice("C001") - 13;
	public double cCe = 13 - 2;
	public double cService = cCs/(cCs+cCe);
	
	public int[] yDemand = {170,180,190,200,210,220};
	public double[] yFrequency = {0.15, 0.18, 0.20, 0.30, 0.12, 0.05};
	public double[] yCumulativeFrequency = {0.15, 0.33, 0.53, 0.83, 0.95, 1};
	public double yCs = Sdao.getPrice("Y001") - 14;
	public double yCe = 14 - 2;
	public double yService = yCs/(yCs+yCe);
}
