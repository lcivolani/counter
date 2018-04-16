package it.lorciv.counter.command;
import it.lorciv.counter.model.Counter;

public class IncrementCommand implements Command {

	private Counter counter;
	
	public IncrementCommand(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void execute() {
		System.out.println("Increment command: executing");
		counter.increment();
	}

	@Override
	public void unexecute() {
		System.out.println("Increment command: unexecuting");
		int value = counter.getValue();
		counter.reset();
		for (int i = 0; i < value - 1; i++) {
			counter.increment();
		}
	}

}
