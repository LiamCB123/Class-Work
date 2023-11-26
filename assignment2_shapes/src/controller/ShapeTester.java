package controller;
import java.util.ArrayList;
import java.util.Collections;
import shapes.AbstractShape;
import shapes.ShapeFactory;

/**
 * this will test if the shapes are created with a given parameter.
 * the shapes will be placed in the arraylist,
 * then will be sorted.
 * @author Liam Barragan
 * @version 1.0 11/15/2023
 */
public final class ShapeTester {

    /** this will be the constructor. */
    private ShapeTester() {
    }

    /**
     * this will create an arraylist.
     * it will add 5 of each shape into the arraylist,
     * 2 of each shape will have the same parameter (radius, sidelength, etc.).
     * this will print the arraylist before and after the sort of the shapes.
     * @param theArgs the set of strings.
     */
    public static void main(final String[] theArgs) {
        final ArrayList<AbstractShape> shapes = new ArrayList<>();
        shapes.add(ShapeFactory.createCircle(1.0));
        shapes.add(ShapeFactory.createCircle(2.0));
        shapes.add(ShapeFactory.createCircle(3.0));
        shapes.add(ShapeFactory.createCircle(5.0));
        shapes.add(ShapeFactory.createCircle(5.0));
        shapes.add(ShapeFactory.createSquare(6.0));
        shapes.add(ShapeFactory.createSquare(7.0));
        shapes.add(ShapeFactory.createSquare(7.0));
        shapes.add(ShapeFactory.createSquare(8.0));
        shapes.add(ShapeFactory.createSquare(9.0));
        shapes.add(ShapeFactory.createTriangle(10.0, 10.0));
        shapes.add(ShapeFactory.createTriangle(11.0, 11.0));
        shapes.add(ShapeFactory.createTriangle(1.0, 2.0));
        shapes.add(ShapeFactory.createTriangle(1.0, 2.0));
        shapes.add(ShapeFactory.createTriangle(3.0, 4.0));
        shapes.add(ShapeFactory.createRectangle(5.0, 5.0));
        shapes.add(ShapeFactory.createRectangle(5.0, 5.0));
        shapes.add(ShapeFactory.createRectangle(4.0, 3.0));
        shapes.add(ShapeFactory.createRectangle(5.0, 6.0));
        shapes.add(ShapeFactory.createRectangle(1.0, 3.0));
        System.out.println("----Shapes before sorting----");
        for (final Object shapeInArray : shapes) {
            System.out.println(shapeInArray);
        }
        System.out.println("-----------------------------");
        System.out.println("----Shapes after sorting----");
        Collections.sort(shapes);
        for (final Object shapeInArray : shapes) {
            System.out.println(shapeInArray);
        }
        System.out.println("----------------------------");



    }

}
