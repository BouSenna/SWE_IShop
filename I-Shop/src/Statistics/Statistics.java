package Statistics;

import Models.ProductModel;
import Models.StatisticsModel;


public class Statistics implements StatisticsInterface, Observer {
	public Statistics(){}
	public void viewStat(int storeID) {
		StatisticsModel statisticsmodel = new StatisticsModel();
		statisticsmodel.getStatistics(storeID);
		
	}
	
	public void update(String ID, int quantity) { 
		StatisticsModel statisticsmodel = new StatisticsModel();
		statisticsmodel.updateStatistics(ID, quantity);

	}
	
	
}
