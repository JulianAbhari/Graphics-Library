package com.Julian.window;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * JWindow 09/24/16
 *
 * @author Julian Abhari
 */

// This class is used to easily create windows.
public class JWindow extends JFrame {

	// The serialVersionUID variable is used to save and load this file,
	// and other files that use it. However, if altered it is not backwards
	// compatible.
	// Although, I won't be using the serialVersionUID.
	private static final long serialVersionUID = 1L;

	int width;
	int height;

	JFrame frame;

	// Contract:
	// createWindow: number (width) number (height) String (title of the window)
	// JComponent (object of JComponent: component)
	// -> JFrame (frame/window)

	// Purpose:
	// This Create function is used to easily create windows of specified
	// dimensions and add any JComponent objects.

	public JWindow(int width, int height, String windowTitle) {

		// Inventory:
		// int width - a number which is used for the width of the window
		// int height - a number which is used for the height of the window
		// String windowTitle - a String which is used for the title of the
		// window
		// JComponent - an object of a JComponent which will be added to the
		// screen

		// This sets the minimum, maximum,
		// and prefered sizes of the window automatically to the specified width
		// and height

		// This sets the title of the window to the specified title
		frame = new JFrame(windowTitle);
		this.width = width;
		this.height = height;
		// The reason 22 is added to the height is because of the bar
		// at the top of the screen. When you enter a positive width
		// and height, you're telling it where it will stop to the
		// left and for the bottom. The (0,0) coordinate of components
		// is the top of window not including bar and left of window.
		frame.setSize(width, (height + 22));
		// This calls the default close operation when the user closes the
		// window.
		// For example if the user were to close and you wanted to remind them
		// to save you WOULDN'T use this
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		// The setLocationRelativeTo(argument) is used to specify where you want
		// the window to appear
		frame.setLocationRelativeTo(null);

		// This is very important that you put the setVisible AFTER you add the
		// components
		frame.setVisible(true);
	}

	// Contract:
	// addComponent: JComponent (component) -> JFrame (window with component)

	// Purpose:
	// A function called addComponent which can add in JComponent's to the
	// window and can be called many times.

	public void addComponent(JComponent component) {
		// Inventory:
		// component - a JComponent which is used to be added in the frame

		// This is adding the component to the JFrame
		frame.add(component);

		// This is very important that you put the setVisible AFTER you add the
		// components
		frame.setVisible(true);
	}

	public void removeComponent(JComponent component) {
		// Inventory:
		// component - a JComponent which is used to be removed from the frame

		// This is removing the component from the JFrame
		frame.remove(component);

		// This is very important that you put the setVisible AFTER you remove
		// the components
		frame.setVisible(true);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

}
