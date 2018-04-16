package it.lorciv.counter.controller;

public class NullController implements Controller {

	@Override
	public void handleIncrement() {
		System.out.println("Controller: handle increment (do nothing)");
	}

	@Override
	public void handleReset() {
		System.out.println("Controller: handle reset (do nothing)");
	}

	@Override
	public void handleUndo() {
		System.out.println("Controller: handle undo (do nothing)");
	}

	@Override
	public void handleRedo() {
		System.out.println("Controller: handle redo (do nothing)");
	}

}
