/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truthtable;

/**
 *
 * @author panag
 */
public class TruthTable {

	/**
	 * @param args the command line arguments
	 */
	
	public interface PrintLogic{
		public void print(boolean x, boolean y, boolean z);
	}

	public static class PrintAND implements PrintLogic {
		@Override
		public void print(boolean x, boolean y, boolean z){
			System.out.println("(" + x + " AND " + y + ")" + " AND " + z + " = " + ((x&&y) && z));
		}
	}
	public static class PrintOR implements PrintLogic {
		@Override
		public void print(boolean x, boolean y, boolean z){
			System.out.println("(" + x + " OR " + y + ")" + " OR " + z + " = " + ((x||y) || z));
		}
	}
	public static class PrintNOT implements PrintLogic {
		@Override
		public void print(boolean x, boolean y, boolean z){
			System.out.println("(" + x + " NOT " + y + ")" + " NOT " + z + " = " + !x);
		}
	}

	public static void printTruthTable(PrintLogic printTable){
		boolean x, y, z;
		x = y = z = false;
		int i, j, k;
		for (i = 0; i < 2; i++){
			x = !x;
			for (j = 0; j < 2; j++){
				y = !y;
				for (k = 0; k < 2; k++){
					z = !z;
					printTable.print(x, y, z);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		printTruthTable(new PrintAND());
		printTruthTable(new PrintOR());
		printTruthTable(new PrintNOT());
	}

}
	
