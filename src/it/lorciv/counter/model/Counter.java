package it.lorciv.counter.model;
import it.lorciv.counter.util.Observer;
import it.lorciv.counter.util.Subject;

public class Counter implements Subject {
	
	private Observer observer;
	private int value;
	
	public Counter() {
		reset();
	}
	
	public int getValue() {
		return value;
	}
	
	public void increment() {
		value++;
		notifyObservers();
	}
	
	public void reset() {
		value = 0;
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return "Counter " + value;
	}

	@Override
	public void attach(Observer observer) {
		this.observer = observer;
	}

	@Override
	public void detach(Observer observer) {
		this.observer = null;
	}

	@Override
	public void notifyObservers() {
		if (observer != null) {
			observer.update();
		}
	}

}
