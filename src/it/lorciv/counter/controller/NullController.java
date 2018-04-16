package it.lorciv.counter.controller;

public class NullController implements Controller {

	@Override
	public void handleIncrement() {
		System.out.println("Controller: handle increment (doing nothing)");
	}

	@Override
	public void handleReset() {
		System.out.println("Controller: handle reset (doing nothing)");
	}

	@Override
	public void handleUndo() {
		System.out.println("Controller: handle undo (doing nothing)");
	}

	@Override
	public void handleRedo() {
		System.out.println("Controller: handle redo (doing nothing)");
	}

}
