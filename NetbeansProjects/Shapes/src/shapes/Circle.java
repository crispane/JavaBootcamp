/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import mypackage.Size;

/**
 *
 * @author f3nix
 */
public class Circle extends Shape{
	private double radius;

	public Circle(double radius, String color, Size size) {
		super(color, size);
		this.radius = radius;
	}
	
	
	@Override
	public double getPerimeter(){
		return 2*radius*Math.PI;
	}

	@Override
	public double getArea() { 
		return radius*radius*Math.PI;
	}

	@Override
	public void printShape() {
		System.out.printf("Printing a %s %s circle.\n", getSize(), getColor()); 
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("This is a " + getSize() + ", " + getColor() + " circle.");
		str.append("It has a radius of ").append(radius);
		return str.toString();
	}

	
}
