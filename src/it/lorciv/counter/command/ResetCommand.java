package it.lorciv.counter.command;
import it.lorciv.counter.model.Counter;

public class ResetCommand implements Command {
	
	private Counter counter;
	private int previousValue;
	
	public ResetCommand(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void execute() {
		System.out.println("Reset command: executing");
		previousValue = counter.getValue();
		counter.reset();
	}

	@Override
	public void unexecute() {
		System.out.println("Reset command: unexecuting");
		for (int i = 0; i < previousValue; i++) {
			counter.increment();
		}
	}

}
