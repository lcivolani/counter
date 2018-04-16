package it.lorciv.counter.command;

public interface Command {
	
	public void execute();
	
	public void unexecute();

}
