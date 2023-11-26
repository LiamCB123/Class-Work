
package shapes;
/**
 * This will be an abstract class that implements comparable.
 * This is the Parent class for the other shape classes (Circle, square, etc.).
 * Methods were overrided to meet the needs of the shapes.
 * @author Liam Barragan
 * @version 1.0 10/11/2023
 */
public abstract class AbstractShape implements Comparable<AbstractShape> {

    /**
     * this is what will be used to return the area of the shape.
     * @return area of the shape.
     */
    public abstract double area();

    /**
     * this will return the name of the shape.
     * @return name of the shape.
     */
    public abstract String name();

    /**
     * this will be used for the hashcode.
     * @return the hashcode needed
     */
    public abstract int hashCode();

    /**
     * This is compareTo method that needed to be overrided.
     * this will compare the name of the shape.
     * then if they are both equal compare the area.
     * @param theOtherShape the object to be compared.
     * @return the negative number if name comes before the other,
     * 0 if they are the same, and positive number if name comes after.
     */

    @Override
    public int compareTo(final AbstractShape theOtherShape) {
        final int nameDifference = name().compareTo(theOtherShape.name());
        if (nameDifference != 0) {
            return nameDifference;
        }
        return Double.compare(area(), theOtherShape.area());

    }

    /**
     * This will override toString method.
     * This will return the name of shape,
     * followed by area of that shape.
     * @return name of shape, then area of shape.
     */
    @Override
    public String toString() {
        return "Name: " + name() + " , Area: " + area();
    }

    /**
     * this will override the equals method.
     * this will check if the two shapes are the same.
     * @param theOtherShape holds the other shape that is being compared.
     * @return false if shapes are null and they are not the same.
     * @return true if the first statement is not true.
     */
    @Override
    public boolean equals(final Object theOtherShape) {

        if (theOtherShape == null || this.getClass() != theOtherShape.getClass()) {
            return false;
        }
        final AbstractShape shapes = (AbstractShape) theOtherShape;
        return compareTo(shapes) == 0;
    }

}
