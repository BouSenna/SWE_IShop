package StoreOwnerCommands;

import java.util.Stack;

public class UndoHandler {
	/// Stack to store the history in it so that you can undo changes.
	private Stack<IStoreOwnerCommand> undoStack;

	/// Constructor
	public UndoHandler() {
		this.undoStack = new Stack<IStoreOwnerCommand>();
	}
}
