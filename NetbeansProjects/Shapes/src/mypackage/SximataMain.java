
/* 1. Create class Shape, Circle, Square, Triangle.
2. Shape has color and size.
3. Size could be enum.
4. Shape has methods getPerimeter(), getArea(), printShape(), getters/setters.
5. Shape has only one Constructor with color and size.
5a. All Shapes should have only one full-argument Constructor.
6. Circle has radius.
7. Square has side.
8. Triangle has base, side2, side3, height.
9. All Shapes should have getPerimeter(), getArea(), printShape().
9a. All Classes should have getters/setters and toString().
10. printShape() should print a message "Printing a $SIZE $COLOR $SHAPE."
11. Create a t1, s1, c1.
12. Add them to a list of Shapes.
13. For every shape in the list, call it's printShape() and enjoy MAGIC.
14. Find the Shape that has the largest area, perimeter.
14. Create 2 more squares.
15. Print the Square with the largest perimeter.
 */
package mypackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import shapes.*;

/**
 *
 * @author f3nix
 */
public class SximataMain {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Shape t1 = new Triangle(115, 4, 3, 4, "blue", Size.LARGE);
		Shape s1 = new Square(8, "red", Size.MEDIUM);
		Shape c1 = new Circle(4, "black", Size.MEDIUM);

		List<Shape> schindler = new ArrayList();
		schindler.add(t1);
		schindler.add(s1);
		schindler.add(c1);

		System.out.println(maxPerimeter(schindler));
		
	}

	public static Shape largestArea(Shape a, Shape b) {
		Shape maxArea = b;
		for (int i = 0; i < 2; i++) {
			if (a.getArea() > b.getArea()) {
				maxArea = a;
			}
		}
		return maxArea;
	}

	public static Shape maxPerimeter(List<Shape> list) {
		Shape maxPerimeter = list.get(0);
		for (Shape shape : list) {
			if (shape.getPerimeter() > maxPerimeter.getPerimeter() );
			maxPerimeter = shape;
		}
		return maxPerimeter;
	}
}
