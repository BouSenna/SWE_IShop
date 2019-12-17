package Statistics;

import java.sql.ResultSet;

public interface StatisticsObserver {
	public void update(ResultSet resultset, String selectedOp);
}
