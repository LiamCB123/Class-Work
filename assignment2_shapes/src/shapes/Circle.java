package shapes;
import java.util.Objects;

/**
 * This class will help give the specs of creating a circle.
 * This will help print out the name circle.
 * This will help calculate the area of a circle.
 * @author Liam Barragan
 * @version 1.0 11/14/2023
 */

public final class Circle extends AbstractShape {

    /** this will hold the radius of the circle. */
    private final double myRadius;

    /**
     * This will be the constructor
     * It will help assign what will be the radius of circle.
     * @throws IllegalArgumentException when the radius is less than 0.
     * @param theRadius initializing the radius of circle.
     */
    Circle(final double theRadius) {
        super();
        if (theRadius < 0) {
            throw new IllegalArgumentException("this is not possible");
        } else {
            this.myRadius = theRadius;
        }
    }

    /**
     * This will get the radius of the circle.
     * @return the radius of the circle.
     */
    public double getRadius() {
        return myRadius;
    }

    /**
     * this will override the area in the shapes class.
     * this will calculate the area of the circle.
     * @return the area of the circle.
     */
    @Override

    public double area() {
        return Math.PI * myRadius * myRadius;
    }

    /**
     * this will help create the name for the circle.
     * will override the name in shape class.
     * @return the word circle.
     */
    @Override
    public String name() {
        return "Circle";
    }

    /**
     * will override hashcode in shape class.
     * this will give a value to the circle
     * This will be based on the radius of the circle
     * @return a number value for the circle
     */
    @Override
    public int hashCode() {
        return Objects.hash(myRadius);
    }

}



