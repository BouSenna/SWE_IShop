package Statistics;

public interface Subject {
	
	public void registerObserver(Statistics stat);
	public void removeObserver(Statistics stat);
	public void notifyObserver(String ID, int quantity);
	
}
