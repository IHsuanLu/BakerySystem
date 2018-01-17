package Inventory_StatusE;

import Inventory_StatusE.Status_DAO;
import Product_ProduceE.Product_DAO;

public interface EOQ_Elements {

	Status_DAO Sdao = new Status_DAO();
	Product_DAO Pdao = new Product_DAO();


	public int orderCost = 100; 
	public int leadTime = 2;
	
	public double sLastDemand = 46231*30; 
	public double sExpectedDemand =  (sLastDemand + 0.1*(sLastDemand/30 - 45000));
	public double sKeepCost = Sdao.getMPrice("G103")*0.4;
	public double sEOQ = Math.sqrt(2*sExpectedDemand*orderCost/sKeepCost);
	public double sAverageDailyDemand = 107.35 * 30;
	public double sROP = sAverageDailyDemand*leadTime;
	
	
	
	public double bLastDemand = 46231*70; 
	public double bExpectedDemand =  (bLastDemand + 0.1*(bLastDemand - 45000*70));
	public double bKeepCost = Sdao.getMPrice("G102")*0.4;
	public double bEOQ = Math.sqrt(2*bExpectedDemand*orderCost/bKeepCost);
	public double bAverageDailyDemand = 107.35 * 70;
	public double bROP = bAverageDailyDemand*leadTime;


	
	public double fLastDemand = 46231*150; 
	public double fExpectedDemand =  (fLastDemand + 0.1*(fLastDemand - 45000*150));
	public double fKeepCost = Sdao.getMPrice("G101")*0.4;
	public double fEOQ = Math.sqrt(2*fExpectedDemand*orderCost/fKeepCost);
	public double fAverageDailyDemand = 107.35 * 150;
	public double fROP = fAverageDailyDemand*leadTime;


	
}
