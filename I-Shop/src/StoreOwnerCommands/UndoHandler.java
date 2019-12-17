package StoreOwnerCommands;

import java.util.Stack;

import Forms.CollabActionsTracker;

public class UndoHandler {
	/// Stack to store the history in it so that you can undo changes.
	public Stack<IStoreOwnerCommand> undoStack;
	public CollabActionsTracker tracker;

	/// Constructor
	public UndoHandler() {
		this.undoStack = new Stack<IStoreOwnerCommand>();
		tracker = new CollabActionsTracker(this);
	}

	/// Method to execute and store the command in the stack.
	public void execute(IStoreOwnerCommand command) {
		try {
			/// executing the command
			command.execute();
			/// pushing the command in the stack in case we needed later [undo]
			undoStack.push(command);
			tracker.addUpdates(command.getName());
		} catch (IllegalStateException e) {
		}
	}

	/// Method to un-execute the last command and popping it from the stack.
	public void undo() {
		/// Checking if there isn't any command executed yet.
		if (!undoStack.isEmpty()) {
			try {
				/// Setting the command with the last command executed.
				IStoreOwnerCommand command = undoStack.pop();
				/// undoing the command.
				command.undo();
			} catch (IllegalStateException e) {

			}
		}
	}
}
