/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author f3nix
 */
public class Circle {
	int x;
	int y;
	int r;
	double p = 3.14;
	
	public double perimeter(){
		return 2*p*r;
	}

	public Circle(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
}
