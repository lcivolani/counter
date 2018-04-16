package it.lorciv.counter.controller;

public interface Controller {
	
	public void handleIncrement();
	
	public void handleReset();
	
	public void handleUndo();
	
	public void handleRedo();

}
