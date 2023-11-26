package shapes;
import java.util.Objects;

/**
 * This class will help give the specs of creating a triangle.
 * This will help print out the name triangle.
 * This will help calculate the area of a triangle.
 * @author Liam Barragan
 * @version 1.0 11/14/2023
 */
public final class Triangle extends AbstractShape {

    /** this will hold the base of the triangle. */
    private final double myBase;

    /** this will hold the height of the triangle. */
    private final double myHeight;

    /**
     * this is the constructor for the triangle.
     * @throws IllegalArgumentException if height or base is less than 0.
     * @param theBase initializing the base of triangle.
     * @param theHeight initializing the height of triangle.
     */
    Triangle(final double theBase, final double theHeight) {
        super();
        if (theBase < 0 || theHeight < 0) {
            throw new IllegalArgumentException("this is not possible");
        }
        this.myBase = theBase;
        this.myHeight = theHeight;
    }

    /**
     * this will get the base of the triangle.
     * @return the base of triangle.
     */
    public double getBase() {
        return myBase;
    }

    /**
     * this will get the height of the triangle.
     * @return the height of the triangle.
     */
    public double getHeight() {
        return myHeight;
    }

    /**
     * this will override the area of the shapes class.
     * this will calculate the area of the triangle.
     * @return the area of the triangle.
     */
    @Override
    public double area() {
        return (myBase * myHeight) / 2;
    }

    /**
     * this will override the name method in teh shapes class.
     * this will make the name of the shape.
     * @return triangle as the name of the shape.
     */
    @Override
    public String name() {
        return "Triangle";
    }

    /**
     * will override hashcode in shape class.
     * this will give a value to the triangle.
     * This will be based on the base and height of the triangle.
     * @return a number value for the triangle.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myBase, myHeight);
    }

}
