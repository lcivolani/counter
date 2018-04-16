package it.lorciv.counter.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.lorciv.counter.controller.Controller;
import it.lorciv.counter.controller.NullController;
import it.lorciv.counter.model.Counter;
import it.lorciv.counter.util.Observer;

public class View implements Observer, ActionListener {

	private Counter counter;
	private Controller controller;
	
	private JFrame frame;
	private JPanel flowPanel1;
	private JPanel flowPanel2;
	private JLabel label;
	private JButton buttonIncrement;
	private JButton buttonReset;
	private JButton buttonUndo;
	private JButton buttonRedo;
	
	public View(Counter counter) {
		this.counter = counter;
		this.controller = new NullController();
		
		frame = new JFrame("Counter");
		flowPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		flowPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		label = new JLabel();
		buttonIncrement = new JButton("Increment");
		buttonReset = new JButton("Reset");
		buttonUndo = new JButton("Undo");
		buttonRedo = new JButton("Redo");
		
		counter.attach(this);
		
		buttonIncrement.addActionListener(this);
		buttonReset.addActionListener(this);
		buttonUndo.addActionListener(this);
		buttonRedo.addActionListener(this);
		
		flowPanel1.add(label);
		flowPanel2.add(buttonIncrement);
		flowPanel2.add(buttonReset);
		flowPanel2.add(buttonUndo);
		flowPanel2.add(buttonRedo);
		
		frame.getContentPane().add(flowPanel1, BorderLayout.CENTER);
		frame.getContentPane().add(flowPanel2, BorderLayout.SOUTH);
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		update();
	}
	
	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void update() {
		label.setText(counter.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("View: event " + e.getActionCommand());
		
		if (e.getSource() == buttonIncrement) {
			controller.handleIncrement();
		} else if (e.getSource() == buttonReset) {
			controller.handleReset();
		} else if (e.getSource() == buttonUndo) {
			controller.handleUndo();
		} else if (e.getSource() == buttonRedo) {
			controller.handleRedo();
		}
	}

}
