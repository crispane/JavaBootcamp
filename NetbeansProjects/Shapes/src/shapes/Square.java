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
public class Square extends Shape{
	private double side;

	public Square(double side, String color, Size size) {
		super(color, size);
		this.side = side;
	}
	

	@Override
	public double getPerimeter(){
		return 4*side;
	}

	@Override
	public double getArea() { 
		return side*side;
	}

	@Override
	public void printShape() {
		System.out.printf("Printing a %s %s square.\n", getSize(), getColor()); 
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("This is a " + getSize() + ", " + getColor() + " square.");
		str.append("It has a side of ").append(side);
		return str.toString();
	}
	
}
