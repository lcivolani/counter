package it.lorciv.counter.model;
import java.util.Arrays;

import it.lorciv.counter.command.Command;

public class CommandManager {
	
	private static CommandManager instance;
	
	public static CommandManager getInstance() {
		if (instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	private Command[] history;
	private int present;
	
	private CommandManager() {
		history = new Command[10];
		present = 0;
	}
	
	public void storeAndExecute(Command command) {
		if (present > history.length - 1) {
			shift();
			present = history.length - 1;
		}
		
		history[present] = command;
		present++;
		
		for (int i = present; i < history.length; i++) {
			history[i] = null;
		}
		
		command.execute();
	}
	
	private void shift() {
		for (int i = 0; i < history.length - 1; i++) {
			history[i] = history[i + 1];
		}
	}

	public void undo() {
		if (present < 1) {
			return;
		}
		
		present--;
		history[present].unexecute();
	}
	
	public void redo() {
		if (present > history.length - 1 || history[present] == null) {
			return;
		}
		
		history[present].execute();
		present++;
	}
	
	@Override
	public String toString() {
		return "History: " + Arrays.toString(history) + "(" + present + ")";
	}

}
