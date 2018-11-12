package com.Julian.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import java.awt.geom.Ellipse2D;

/**
 * JEllipse 11/03/16
 *
 * @author Julian Abhari
 */

// This class is used to easily access JComponent Ellipses
public class JEllipse extends JComponent {
	// The serialVersionUID variable is used to save and load this file,
	// and other files that use it. However, if altered it is not backwards
	// compatible.
	private static final long serialVersionUID = 1L;

	double x;
	double y;
	int width;
	int height;
	int red;
	int green;
	int blue;
	int alpha;
	boolean solidOrNot;

	// Contract:
	// JEllipseConstructor: int (x) int (y) int (width) int (height) int (red)
	// int (green) int (blue) bool (solidOrNot) -> Ellipse JComponent

	// Purpose: This is a constructor for any JEllipse JComponent object, it
	// takes in integers to declare it's positioning and color and a boolean to
	// determine if the ellipse should be a solid color or an outline
	public JEllipse(int x, int y, int width, int height, int red, int green, int blue, int alpha, boolean solidOrNot) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
		this.solidOrNot = solidOrNot;
	}
	
	public JEllipse(double x, double y, int width, int height, int red, int green, int blue, int alpha, boolean solidOrNot) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
		this.solidOrNot = solidOrNot;
	}

	// Contract:
	// paintComponent: GraphicsObject (g) -> JComponent

	// Puropse: This is a function called paintComponet which takes in a graphic
	// object BUT it's specified by the JFrame the user should never need to
	// call this function. This function is made just for the JComponet, because
	// the JComponent needs a function of this exact contract if a drawing will
	// be added. What this is doing is creating a graphics2D and ellipse
	// object that will determine the ellipses position and color
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(new Color(red, green, blue, alpha));

		// The purpose of the code line below is used to render the shapes in
		// high quality. I don't know specifically what 'RenderingHints' are but
		// I will learn later.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// The reason I'm subtracting half the width and half the height from
		// the x and y coords is so that it will place the CENTER of the object
		// at the given x and y coords
		Ellipse2D.Double ellipse = new Ellipse2D.Double(x - (width / 2), y - (height / 2), width, height);

		if (solidOrNot)
			g2.fill(ellipse);

		g2.draw(ellipse);
	}
}
