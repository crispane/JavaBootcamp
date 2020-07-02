/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package return10ints;

/**
 *
 * @author panag
 */
public class Return10ints {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8,9,0,22,23,26,1235,-564};
		int array2[] = return10(array);
		System.out.println(array2.length);
		for (int i = 0; i < array2.length; i++)
			System.out.println(array2[i]);
	}

	public static int[] return10(int array[]){
			for (int i = 0; i <= array.length-1; i++)
				array[i] += 5;
		return array;
	}

}
