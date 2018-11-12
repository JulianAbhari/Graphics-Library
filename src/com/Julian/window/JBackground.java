package com.Julian.window;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.Julian.shapes.JEllipse;

/**
 * JBackground 11/20/16
 * 
 * @author Julian Abhari
 */

// This class is used to easily create Java Panels.
public class JBackground extends JPanel {
	// The serialVersionUID variable is used to save and load this file,
	// and other files that use it. However, if altered it is not backwards
	// compatible.
	private static final long serialVersionUID = 1L;

	// Variables declared but not instantiated here.
	// this is so the constructor can instatiate them with the given variables.
	// The only variable that is instatiated is the panel variable.
	int red;
	int green;
	int blue;

	JPanel panel;

	// JBackground constructor takes in three integers that are used to declare
	// the color of the JPanel
	public JBackground(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		panel = new JPanel();
		panel.setBackground(new Color(red, green, blue));
	}

	// Contract:
	// addComponent: JComponent (component), String (constrants, ex:
	// BorderLayout.CENTER) -> void (it just adds the components to the JPanel)

	// Purpose: This is a function called addComponent which lets you easily add
	// components and constraints to your JPanel.
	public void addComponent(JComponent component, String constraints) {
		// You have to create a new BorderLayout if you want to implement the
		// constraints because JPanel has a specified FlowLayout, and if you
		// want to change those constraints you have to create a new Layout.
		panel.setLayout(new BorderLayout());
		panel.add(component, constraints);
	}

	// Purpose: This is a function called removeComponent which lets you easily
	// remove components that are already on your JPanel.
	public void removeComponent(JComponent component) {
		// The difference betweeen calling this function
		// and not just calling remove(component) is that
		// to call the remove you would need the raw panel
		// and to do that you would have to do something like
		// "background.getPanel().remove(component).
		// So this is trying to make it more seamless to
		// to remove components
		panel.remove(component);
	}

	// Contract:
	// getPanel: -> panel

	// Purpose: This is a getter function for the panel because when you add the
	// JBackground component to the JFrame it needs the raw panel, so you'd have
	// to do something like 'jBackground.getPanel()' for the JFrame to actually
	// get the JPanel.
	public JPanel getPanel() {
		return panel;
	}

	// Test Cases
	public static void main(String[] args) {
		// This is creating a window, background, and JEllipse
		// objects that will be added to the background.
		JWindow windy = new JWindow(400, 400, "JBackground");
		JBackground background = new JBackground(255, 255, 255);
		JEllipse ellipse = new JEllipse(100, 200, 30, 30, 255, 0, 0, 255, true);
		JEllipse ellipse2 = new JEllipse(115, 200, 30, 30, 0, 255, 0, 255, true);
		JEllipse ellipse3 = new JEllipse(130, 200, 30, 30, 0, 0, 255, 255, true);

		// This is adding the ellipse to the background, then immediately
		// adding the background to the window. I don't know why but if
		// you don't add the background immediately then when you're adding
		// the jbackground to the jwindow the jbackground will only add the last
		// component that was added to it. Basicallly you have to add the
		// background to the window immediately after you've added a component
		// to the background.
		background.addComponent(ellipse, BorderLayout.CENTER);
		windy.addComponent(background.getPanel());

		background.addComponent(ellipse2, BorderLayout.CENTER);
		windy.addComponent(background.getPanel());

		background.addComponent(ellipse3, BorderLayout.CENTER);
		windy.addComponent(background.getPanel());

		// This is removing the first ellipse then adding it
		// back right after it was removed. You can see that order matters
		// when it comes to what gets overlayed on top of what. Because without
		// removing the ellipse then it is over ellipse2 and 3 but when removing
		// the ellipse it is under the 2 and 3 ellipse.
		background.remove(ellipse);
		background.addComponent(ellipse, BorderLayout.CENTER);
	}
}
