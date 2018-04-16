package it.lorciv.counter.model;
import it.lorciv.counter.controller.StandardController;
import it.lorciv.counter.view.View;

public class Main {

	public static void main(String[] args) {
		Counter counter = new Counter();
		View view = new View(counter);
		StandardController controller = new StandardController(counter);
		view.setController(controller);
	}

}
