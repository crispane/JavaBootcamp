/* Welcome to my first project! 

---This is Part A of the Individual Project for the AFDEmp Coding Bootcamp.---

*** title: "Bootcamp Registry Program" 

*** Goal of the project: Implement a Private School Structure that can hold all courses, trainers, students and assignments
and create relations of them.

*** Implementation: My implementation is based on the abstraction of all items of the bootcamp into an *Item* Class to make mobility
in lists easier, while removing the need for multiple methods to create combinations. These combinations are mostly performed
by a single method called *combination*, found in Creators.java. In addition, I created another child of *Item* 
called *ItemList* that holds combinations of *Item*. 

Submenus are implemented, but I faced the problem of having to return multiple List<Item>. I chose to bundle them all in a List<List<Item>>
for each submenu and return them while exiting the menu. They are then passed to a *bufferlist* in order to distribute said lists 
to their respective variables.(see: line 61 in Menus.java)

*** This project is separated into 4 packages:
BaseClasses that contain classes for the basic items of the school.
ExtraClasses that contain the *Item* and *ItemList* classes.
WorkingClasses that contain the bulk of the program. Menu, Creator, Printing and Input methods.
RunClasses that contain the Main.class and SyntheticData.class for Demo purposes.

*/
package RunClasses;

import WorkingClasses.Menus;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Menus.BootMenu();
	}
	
}
