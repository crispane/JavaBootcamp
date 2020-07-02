/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatcatproject;

import static java.lang.Character.toUpperCase;
import java.util.*;
/**
 *
 * @author panag
 */
public class FatCatProject {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String userName, city, favouriteColor;
      int  yearOfbirth, yearsOfmarriage, yearOfmarriage, numberOfchildren;
   
      
      char maritalStatus, childrenStatus;
      Scanner sc = new Scanner(System.in);
            
      System.out.print("Hello there! What is your name? ");
      userName = sc.next();
      System.out.print("What year were you born " + userName + "? ");
      yearOfbirth = sc.nextInt();
      System.out.print("Sweet! And in what city were you born? ");
      city = sc.next();
         
        
      System.out.print("Are you married? (Y)es / (N)o? ");
      maritalStatus = toUpperCase(sc.next().charAt(0));
 
      while ((maritalStatus != 'Y') && (maritalStatus != 'N'))
      {
      System.out.print("Come on " + userName + "! (Y)es or (N)o? ");
      maritalStatus = toUpperCase(sc.next().charAt(0));
      }    
        
      if (maritalStatus != 'Y'){
         System.out.print("What is your favourite color " + userName + "? ");
         favouriteColor = sc.next();
         System.out.println("Dear " + userName + ", your were born in " + yearOfbirth + ", so you are " + (2020 - yearOfbirth) + " years old and you were born in the city of " + city + ".\nYou are not married and your favourite color is " + favouriteColor + ".");
                    }
      else {
      
      if(maritalStatus == 'Y'){
        System.out.print("How many years have you been married " + userName + "? ");
        yearsOfmarriage = sc.nextInt();
        System.out.print("What year did you get married? ");
        yearOfmarriage = sc.nextInt();
        System.out.print("Any children? (Y)es or (N)o? ");
        childrenStatus = toUpperCase(sc.next().charAt(0));
                      
       while ((childrenStatus != 'Y') && (childrenStatus != 'N'))
       {
       System.out.print("Come on " + userName + "! (Y)es or (N)o? ");
       childrenStatus = toUpperCase(sc.next().charAt(0));
       }   
        
      if(childrenStatus != 'Y'){
        System.out.println("What is your favourite color " + userName + "? ");
            favouriteColor = sc.next();
            System.out.println("Dear " + userName + ", your were born in " + yearOfbirth + ", so you are " + (2020 - yearOfbirth) + " years old and you were born in the city of " + city + ".\nYou have been married for " + yearsOfmarriage + " years, you got married in " + yearOfmarriage + " and you don't have any children. Your favourite color is " + favouriteColor + ".");       
            }
            else{
            
            System.out.print("That's nice! How many? ");
               numberOfchildren = sc.nextInt();
               
               while (numberOfchildren <= 0)
               {
               System.out.println("I don't know how you managed to do that " + userName + "!");
               System.out.print("Come on! How many kids you got? ");
               numberOfchildren = sc.nextInt();
               }  
               
               if (numberOfchildren > 0){
                   String[] childrenNames = new String[numberOfchildren];
                   int[] childrenAges = new int[numberOfchildren];
                   
                   for (int i = 0; i < numberOfchildren; i++) {
                       System.out.print("What's the name of your " + (i+1) +" child? ");
                       childrenNames[i] = sc.next();
                       System.out.print("How old is " + childrenNames[i] +"? ");
                       childrenAges[i] = sc.nextInt();
                   }
                System.out.print("What is your favourite color " + userName + "? ");
                favouriteColor = sc.next();
                
                System.out.println("Dear " + userName + ", your were born in " + yearOfbirth + ", so you are " + (2020 - yearOfbirth) + " years old and you were born in the city of " + city + ".\n" + "You have been married for " + yearsOfmarriage + " years, you got married in " + yearOfmarriage + " and you have " + numberOfchildren + " children.");                        
                for (int j = 0; j < numberOfchildren; j++){
                System.out.println("The name of your " + (j+1) + " child is " + childrenNames[j] + " and was born in " + (2020 - childrenAges[j]) + ".");
                
                }
                System.out.println("Your favourite color is " + favouriteColor + ".");
         }
        }
       }
      }
	}
	
}
