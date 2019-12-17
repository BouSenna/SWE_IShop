package Statistics;

import java.sql.ResultSet;

import Forms.AdminStatistics;

public interface StatisticsSubject {
	public void registerObserver(AdminStatistics adminstat);
	public void removeObserver(AdminStatistics adminstat);
	public void notifyObserver(ResultSet resultset, String stat);
}
