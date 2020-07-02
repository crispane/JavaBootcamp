/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbinarytodecimal;

/**
 *
 * @author panag
 */
public class ConvertBinaryToDecimal {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) { 
		String binaryString="1010";  
		int decimal=Integer.parseInt(binaryString,2);  
		System.out.println(decimal);  
	}
}  