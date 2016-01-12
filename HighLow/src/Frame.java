import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	
	/**
	 * The following declarations are documented @ their initialization
	 */
	JButton lowButton, highButton;
	JLabel number;
	JLabel pointLabel;
	Logic l = new Logic();
	Random r = new Random();
	
	public Frame() {
		super("HighLow");
		setSize(500,500);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
		//Jlabel that displays the number
		number = new JLabel("" + l.currentNumber);
		number.setBounds(190,100,200,100);
		add(number);
		number.setFont(new Font("Serif", Font.BOLD, 100));
		
		//Button to select 'High'
		highButton = new JButton("High");
		highButton.setBounds(50,275,100,30);
		add(highButton);
		
		//Button to select 'Low'
		lowButton = new JButton("Low");
		lowButton.setBounds(325,275,100,30);
		add(lowButton);
		
		//Label that displays points
		pointLabel = new JLabel("Points: 0");
		pointLabel.setBounds(50,50,100,30);
		add(pointLabel);
		
	
	
		Handler handler = new Handler();
		lowButton.addActionListener(handler);	
		highButton.addActionListener(handler);
		
	}
	
	public void update() {
		pointLabel.setText("Points: " + l.getPoints());
	}
	
	void handleButton(boolean high) {
		l.lastNumber = l.currentNumber;
		l.currentNumber = r.nextInt(100) + 1;
		number.setText("" +l.currentNumber);
		if(l.won(high)) {
			l.points++;
		} else {
			l.points = 0;
		}
		update();
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==lowButton) {
				handleButton(false);
			} else if(e.getSource()==highButton) {
				handleButton(true);
			}
			
		}
		
	}
	
	
}
