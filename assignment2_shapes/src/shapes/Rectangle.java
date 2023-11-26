package shapes;
import java.util.Objects;

/**
 * This class will help give the specs of creating a rectangle.
 * This will help print out the name rectangle.
 * This will help calculate the area of a rectangle.
 * @author Liam Barragan
 * @version 1.0 11/14/2023
 */
public final class Rectangle extends AbstractShape {

    /** this will hold the length of the rectangle. */
    private final double myLength;

    /** this will hold the width of the rectangle. */
    private final double myWidth;

    /**
     * this is the constructor for the rectangle class.
     * @throws IllegalArgumentException when length and width less than 0.
     * @param theLength initalizing the length of the rectangle.
     * @param theWidth initalizing the width of the rectangle.
     */
    Rectangle(final double theLength, final double theWidth) {
        super();
        if (theLength < 0 || theWidth < 0) {
            throw new IllegalArgumentException();
        }
        this.myLength = theLength;
        this.myWidth = theWidth;
    }

    /**
     * this will get the length of the rectangle.
     * @return the length of the rectangle.
     */
    public double getLength() {
        return myLength;
    }

    /**
     * this will get the width of the rectangle.
     * @return the width of rectangle.
     */
    public double getWidth() {
        return myWidth;
    }

    /**
     * this will override the area method from shape class.
     * this will calculate the area of the rectangle.
     * @return the area of the rectangle.
     */
    @Override
    public double area() {
        return myLength * myWidth;
    }

    /**
     * this will override the name method in the shapes class.
     * this will give a name to the shape.
     * @return rectangle as the name of the shape.
     */
    @Override
    public String name() {
        return "Rectangle";
    }

    /**
     * will override hashcode in shape class.
     * this will give a value to the rectangle.
     * This will be based on the length and width of the triangle.
     * @return a number value for the rectangle.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myLength, myWidth);
    }



}
