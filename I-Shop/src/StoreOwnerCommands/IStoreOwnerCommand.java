package StoreOwnerCommands;

public interface IStoreOwnerCommand {
	void execute();
	void undo();
	String getName();
}

