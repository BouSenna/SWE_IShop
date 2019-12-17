package Statistics;

import java.sql.ResultSet;

import Models.StatisticsModel;


public class Statistics implements StatisticsInterface, QuantityObserver {
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
