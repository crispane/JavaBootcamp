/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testplay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author f3nix
 */
public class CalculatorTest {
	
	public CalculatorTest() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetSumValid() {
		Calculator calc = new Calculator();
		int result = calc.getSum(2,2);
		assertEquals(4, result);
//		System.out.println("getSum");
//		int a = 0;
//		int b = 0;
//		Calculator instance = new Calculator();
//		int expResult = 0;
//		int result = instance.getSum(a, b);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
	}
	@Test
	public void testGetSumInvalid() {
		Calculator calc = new Calculator();
		int result = calc.getSum(2,2);
		assertEquals(4, result);
	
}
