package com.Julian.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import com.Julian.shapes.JLine;
import com.Julian.window.JWindow;

/**
 * JText 11/05/16
 *
 * @author Julian Abhari
 */

// This class is used to easily draw text strings
public class JText extends JComponent {

	// The serialVersionUID variable is used to save and load this file,
	// and other files that use it. However, if altered it is not backwards
	// compatible.
	private static final long serialVersionUID = 1L;

	int x;
	int y;
	int red;
	int green;
	int blue;
	int textStyle;
	int textSize;
	String string;
	String font;

	// Contract:
	// JTextConstructor: int (x) int (y) String (text) int (textStyle: bold,
	// etc) int (textSize) int (green) int (blue) bool (solidOrNot) -> Text
	// JComponent

	// Purpose: This is a constructor for any JText JComponent object, it
	// takes in integers to declare it's positioning, style and size
	public JText(int x, int y, String string, String font, int textStyle, int textSize) {
		this.x = x;
		this.y = y;
		this.textStyle = textStyle;
		this.textSize = textSize;
		this.string = string;
		this.font = font;
	}

	// Purpose: This is an addColor function which adds color according to the
	// specified parameters.

	// Contract: int (red), int (blue), int (green) -> JComponent Text with
	// Color
	public void addColor(int red, int green, int blue) {
		// This is setting the variables to the specified parameters
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	// Contract:
	// paintComponent: GraphicsObject (g) -> JComponent Text

	// Puropse: This is a function called paintComponet which takes in a graphic
	// object BUT it's specified by the JFrame the user should never need to
	// call this function. This function is made just for the JComponet, because
	// the JComponent needs a function of this exact contract if a component
	// will be added. What this is doing is creating a graphics2D and text
	// object that will determine the text's position and color
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// The purpose of the code line below is used to render the shapes in
		// high quality. I don't know specifically what 'RenderingHints' are but
		// I will learn later.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(new Color(red, green, blue));

		g2.setFont(new Font(font, textStyle, textSize));
		g2.drawString(string, x, y + (textSize - 10) / 2);
	}

	// TEST CASES
	// This creates a window and Text JComponet object to see if adding
	// this JComponent to a JFrame will work
	public static void main(String[] args) {
		JWindow windy = new JWindow(400, 400, "Text");
		JLine line = new JLine(0, 200, 400, 200, 0, 0, 0);
		JText text = new JText(0, 0, "Hello World", "monospace", Font.PLAIN, 58);
		text.addColor(255, 30, 60);
		windy.addComponent(text);
		windy.addComponent(line);
	}

}
