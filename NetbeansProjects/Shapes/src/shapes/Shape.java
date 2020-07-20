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
public class Shape {
	private String color;
	private Size size;

	public Shape(String color, Size size) {
		this.color = color;
		this.size = size;
	}

	public Shape(Shape shape) {
	}
	
	public double getPerimeter(){
		return 0;
	}

	public double getArea() {
		return 0;
	}

	public void printShape() {
		System.out.printf("Printing a %s %s shape.\n", size, color); 
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shape{" + "color=" + color + ", size=" + size + '}';
	}

	
	
}
