package shapes;

/**
 * this will help create each shape.
 * @author Liam Barragan
 * @version 1.0 11/15/2023
 */
public final class ShapeFactory {

    /** this will be the constructor for the shape factory. */
    private ShapeFactory() { }

    /**
     * this will create the circle shape.
     * @param theRadius this will be the radius of the circle.
     * @return a circle object.
     */
    public static Circle createCircle(final double theRadius) {
        return new Circle(theRadius);
    }

    /**
     * this will create the square shape.
     * @param theSideLength this will be the side length of the square.
     * @return a square object.
     */
    public static Square createSquare(final double theSideLength) {
        return new Square(theSideLength);
    }

    /**
     * this will create the triangle shape.
     * @param theBase this will be the base of the triangle.
     * @param theHeight this will be the height of the triangle.
     * @return a triangle object
     */
    public static Triangle createTriangle(final double theBase, final double theHeight) {
        return new Triangle(theBase, theHeight);
    }

    /**
     * this will create the rectangle shape.
     * @param theLength this will be the length of the rectangle.
     * @param theWidth this will be the width of the rectangle.
     * @return a rectangle object.
     */
    public static Rectangle createRectangle(final double theLength, final double theWidth) {
        return new Rectangle(theLength, theWidth);
    }
}
