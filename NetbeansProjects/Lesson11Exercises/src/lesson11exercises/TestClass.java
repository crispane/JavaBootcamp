/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11exercises;

/**
 *
 * @author Chrysanthos Panagakos 
 */
public class TestClass {
	private Integer x;
	private Long l;
	private Float f;
	private Double d;

	public TestClass(int x, long l, float f, double d) {
		this.x = x;
		this.l = l;
		this.f = f;
		this.d = d;
	}

	@Override
	public String toString(){
		return  String.format("   Int is: %15d\n", getX())+
				String.format("  Long is: %15d\n", getL()) + 
				String.format(" Float is: %15.2f\n", getF()) + 
				String.format("Double is: %15.2f\n", getD()); 
	}

	public Integer getX() {
		return x;
	}

	public Long getL() {
		return l;
	}

	public Float getF() {
		return f;
	}

	public Double getD() {
		return d;
	}




	
	
}
