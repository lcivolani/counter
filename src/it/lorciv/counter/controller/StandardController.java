package it.lorciv.counter.controller;
import it.lorciv.counter.command.Command;
import it.lorciv.counter.model.CommandManager;
import it.lorciv.counter.command.IncrementCommand;
import it.lorciv.counter.command.ResetCommand;
import it.lorciv.counter.model.Counter;

public class StandardController implements Controller {
	
	private Counter counter;
	
	public StandardController(Counter counter) {
		this.counter = counter;
	}
	
	public void handleIncrement() {
		System.out.println("Controller: handle increment");
//		counter.increment();
		Command command = new IncrementCommand(counter);
		CommandManager.getInstance().storeAndExecute(command);
		System.out.println(CommandManager.getInstance());
	}
	
	public void handleReset() {
		System.out.println("Controller: handle reset");
//		counter.reset();
		Command command = new ResetCommand(counter);
		CommandManager.getInstance().storeAndExecute(command);
		System.out.println(CommandManager.getInstance());
	}
	
	public void handleUndo() {
		System.out.println("Controller: handle undo");
		CommandManager.getInstance().undo();
		System.out.println(CommandManager.getInstance());
	}
	
	public void handleRedo() {
		System.out.println("Controller: handle redo");
		CommandManager.getInstance().redo();
		System.out.println(CommandManager.getInstance());
	}

}
