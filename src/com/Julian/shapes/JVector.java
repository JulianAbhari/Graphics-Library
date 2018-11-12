package com.Julian.shapes;

import java.awt.geom.Point2D;

/**
 * JVector 11/05/16
 * 
 * @author Julian Abhari
 */

// This class is used to easily access a Vector object and variables
public class JVector extends Point2D {

	private double x;
	private double y;

	// Contract:
	// JVectorConstructor: double (x) double (y) -> JVector

	// Purpose: This is a constructor for every JVector object, it takes
	// in an x and y variable and instantiates it's x and y as the given
	// variables.
	public JVector(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	// Contract:
	// getX: -> double (JVector object's x variable)

	// Purpose: This getX function returns the x variable of the JVector object
	public double getX() {
		return this.x;
	}

	// Contract:
	// getY: double (JVector object's y variable)

	// Purpose: This getY function returns the y variable of the JVector object
	public double getY() {
		return this.y;
	}

	// Contract:
	// setX: double (JVector object's y variable) -> void (nothing because it's
	// just setting the value)

	// Purpose: This setX function sets the y variable of the JVector object to
	// the given value
	public void setX(double x) {
		this.x = x;
	}

	// Contract:
	// setY: double (JVector object's y variable) -> void (nothing because it's
	// just setting the value)

	// Purpose: This setY function sets the y variable of the JVector object to
	// the given value
	public void setY(double y) {
		this.y = y;
	}

	// Contract:
	// add: double (xA) double (yA) -> JVector object's x and y (with the given
	// variables added to the x and y)

	// Purpose: This is an add function which takes in two variables and adds
	// them to the JVector object's x and y variables
	public JVector add(double x, double y) {
		this.setX(this.getX() + x);
		this.setY(this.getY() + y);
		return this;
	}

	// Contract:
	// sub: double (xA) double (yA) -> JVector object's x and y (with the given
	// variables subtracted from the x and y)

	// Purpose: This is a sub function which takes in two variables and
	// subtracts them from the JVector object's x and y variables
	public JVector sub(double x, double y) {
		this.setX(this.getX() - x);
		this.setY(this.getY() - y);
		return this;
	}

	// Contract:
	// mult: double (xA) double (yA) -> JVector object's x and y (with the given
	// variables multiplied to the x and y)

	// Purpose: This is an add function which takes in two variables and
	// multiplies them to the JVector object's x and y variables
	public JVector mult(double x, double y) {
		this.setX(this.getX() * x);
		this.setY(this.getY() * y);
		return this;
	}

	// Contract:
	// div: double (x) double (y) -> JVector object's x and y (with the given
	// variables divided from the x and y)

	// Purpose: This is a div function which takes in two variables and
	// divides them from the JVector object's x and y variables
	public JVector div(double x, double y) {
		this.setX(this.getX() / x);
		this.setY(this.getY() / y);
		return this;
	}

	// Contract:
	// setLocation: double (x) double (y) -> void

	// Purpose: This instantiates the JVector's x and y in one function, this is
	// the same as the setX and setY but combined, the is an abstract method
	// from the Point2D class and has to be implemented.
	public void setLocation(double x, double y) {
		setX(x);
		setY(y);
	}
}
