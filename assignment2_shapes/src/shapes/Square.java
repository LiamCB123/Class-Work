package shapes;
import java.util.Objects;

/**
 * This class will help give the specs of creating a square.
 * This will help print out the name square.
 * This will help calculate the area of a circle.
 * @author Liam Barragan
 * @version 1.0 11/14/2023
 */
public final class Square extends AbstractShape {

    /** this will hold the side length of the square. */
    private final double mySideLength;

    /**
     * this will be the constructor for the square.
     * @throws IllegalArgumentException if side length is less than 0.
     * @param theSideLength this is the side length of the square.
     */
    Square(final double theSideLength) {
        super();
        if (theSideLength < 0) {
            throw new IllegalArgumentException("this is not possible");
        } else {
            this.mySideLength = theSideLength;
        }
    }

    /**
     * this will get the side length of the square.
     * @return the sidelength of the square.
     */
    public double getSideLength() {
        return mySideLength;
    }

    /**
     * this will calculate the area of the square.
     * this will override the area in shapes class.
     * @return the calculated area.
     */
    @Override
    public double area() {
        return mySideLength * mySideLength;
    }

    /**
     * this will override the name method in shapes class.
     * this will produce the name the square name.
     * @return the name of the shape (square).
     */
    @Override
    public String name() {
        return "Square";
    }

    /**
     * will override hashcode in shape class.
     * this will give a value to the square.
     * This will be based on the side length of the square.
     * @return a number value for the circle.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mySideLength);
    }
}
