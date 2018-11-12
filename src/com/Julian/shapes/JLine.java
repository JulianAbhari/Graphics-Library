package com.Julian.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

/**
 * JLine 11/05/16
 * 
 * @author Julian Abhari
 */

// This class is used to easily access JComponent lines
public class JLine extends JComponent {
	// The serialVersionUID variable is used to save and load this file,
	// and other files that use it. However, if altered it is not backwards
	// compatible.
	private static final long serialVersionUID = 1L;

	double xA;
	double yA;
	double xB;
	double yB;
	int red;
	int green;
	int blue;
	boolean solidOrNot;

	// Contract:
	// JLineConstructor: double (x) double (y) double (xB) double (yB) int (red)
	// int (green) int (blue) -> JLine JComponent

	// Purpose: This is a constructor for any JLine JComponent object, it takes
	// in integers to declare it's positioning and colors.
	public JLine(double xA, double yA, double xB, double yB, int red, int green, int blue) {
		this.xA = xA;
		this.yA = yA;
		this.xB = xB;
		this.yB = yB;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public JLine(Point2D p1, Point2D p2, int red, int green, int blue) {
		this.xA = p1.getX();
		this.yA = p1.getY();

		this.xB = p2.getX();
		this.yB = p2.getY();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	// Contract:
	// paintComponent: GraphicsObject (g) -> JComponent

	// Puropse: This is a function called paintComponet which takes in a graphic
	// object BUT it's specified by the JFrame the user should never need to
	// call this function. This function is made just for the JComponet, because
	// the JComponent needs a function of this exact contract if a drawing will
	// be added. What this is doing is creating a graphics2D and line
	// object that will determine the lines position and color
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(new Color(red, green, blue));

		// The purpose of the code line below is used to render the shapes in
		// high quality. I don't know specifically what 'RenderingHints' are but
		// I will learn later.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Line2D.Double line = new Line2D.Double(xA, yA, xB, yB);

		g2.draw(line);
	}
}
