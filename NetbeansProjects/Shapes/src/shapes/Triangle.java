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
public class Triangle extends Shape{
	private double base;
	private double side2;
	private double side3;
	private double height;

	public Triangle(double base, double side2, double side3, double height, String color, Size size) {
		super(color, size);
		this.base = base;
		this.side2 = side2;
		this.side3 = side3;
		this.height = height;
	}
	
	
	@Override
	public double getPerimeter(){
		return base+side2+side3;
	}

	@Override
	public double getArea() { 
		return base*height/2;
	}

	@Override
	public void printShape() {
		System.out.printf("Printing a %s %s triangle.\n", getSize(), getColor()); 
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("This is a " + getSize() + ", " + getColor() + " triangle.");
		str.append("It has a base of ").append(base);
		str.append(", a side2 of ").append(side2);
		str.append("and a side3 of ").append(side3).append(".");
		return str.toString();
	}
}
