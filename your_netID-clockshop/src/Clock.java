/**
 * This is the clock class, which will help create a Clock object
 * It will help compare, see if another clock is equal to it, and advance time of the clocks
 * This will implement the comparable class to help out with the compareTo method
 * @author Liam Barragan
 * @version 1.0 10/8/2023
 */
public class Clock implements Comparable<Clock> {

    /** This will keep track of the hour for the clock */
    private int myHour;
    /** This will keep track of the minutes for the clock */
    private int myMinute;
    /** This will keep track of seconds for the clock */
    private int mySecond;

    /**
     * This will parameterize the clock class by setting the hour, minute, and second
     * This is the one of the constructor class that passes in the hour, minute, and second
     * @param theHour
     * @param theMinute
     * @param theSecond
     */
    public Clock(final int theHour, final int theMinute, final int theSecond) {
        setHour(theHour);
        setMinute(theMinute);
        setSecond(theSecond);

    }

    /**
     * This is the constructor to help default the time to 23 hours, 58 minute, and 00 seconds
     */
    public Clock() {
        this.myHour = 23;
        this.myMinute = 58;
        this.mySecond = 0;

    }

    /**
     * @Override this is going to override the toString method
     * This will help print out the clock being (hh:mm:ss)
     * @return the clock time with the hour, minute, and second seperated by a :
     */
    public String toString() {

        return getHour() + ":" + getMinute() + ":" + getSecond();
    }

    /**
     * This will help get the hour for the clock
     * @return the hour
     */
    public int getHour() {
        return myHour;
    }

    /**
     * This will help get the minute for the clock
     * @return the minute
     */
    public int getMinute() {

        return myMinute;
    }

    /**
     * This will help get the second for the clock
     * @return the second
     */
    public int getSecond() {

        return mySecond;
    }

    /**
     * This will help set the hour, the hour boundaries are 0-23
     * @param theHour
     * @throws IllegalArgumentException when hour is outside the boundary
     */
    public void setHour(final int theHour) {
        if (theHour < 0 || theHour > 23) {
            throw new IllegalArgumentException("This is not possible, you are outside the boundaries");
        } else {
            this.myHour = theHour;
        }
    }

    /**
     * This will help set the minute, the minute boundaries are 0-59
     * @param theMinute
     * @throws IllegalArgumentException when the minute is outside the boundaries
     */
    public void setMinute(final int theMinute) {
        if (theMinute < 0 || theMinute > 59) {
            throw new IllegalArgumentException("This is not possible, you are outside the boundaries");
        } else {
            this.myMinute = theMinute;
        }
    }

    /**
     * This will help set the second, with the boundaries being 0-59
     * @param theSecond
     * @throws IllegalArgumentException when the second is outside the boundaries
     */
    public void setSecond(final int theSecond) {
        if (theSecond < 0 || theSecond > 59) {
            throw new IllegalArgumentException("This is not possible, you are outside the boundaries");
        } else {
            this.mySecond = theSecond;
        }
    }

    /**
     * This will help advance the hour for the clock
     * The hour can't be advance the hour if it is less than 0
     * @param theAmount
     * @throws IllegalArgumentException when the paramater is less than 0
     */
    public void advanceHour(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException("This is not possible, the number can't be negative");
        }
        if (theAmount >= 0) {
            this.myHour = myHour + theAmount;
            if (myHour > 23) {
               myHour = myHour % 24;
            }

        }
    }

    /**
     * This will help advance the minute
     *  Can't be advance if it is less than 0
     * @param theAmount
     * @throws IllegalArgumentException when the parameter is less than 0
     */
    public void advanceMinute(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException("this is not possible");
        }
        if (theAmount >= 0) {
            advanceHour((myMinute + theAmount) / 60);
            myMinute = (myMinute + theAmount) % 60;
        }

    }

    /**
     * this will help check if the clock object is equal to another clock object
     * @param theObject this will be the clock object
     * @return true if the clock exists and is not null
     * @return false if the clock is null
     * @return calls the compareTo method if it returns true
     */
    public boolean equals(final Object theObject) {
        if (this == theObject && theObject != null) {
            return true;
        }
        if (theObject == null) {
            return false;
        }
        final Clock otherClock = (Clock) theObject;
        return compareTo(otherClock) == 0;
    }

    /**
     * This will compare the clock objects, it will compare the hour, minute, and seconds
     * @Override compareTo method
     * @param theOtherClock the object to be compared.
     * @return -1 if the hour is less then the other clock hour (parameter), or if the minute is less than the parameter, or if the second is less then the parameter
     * @return 1 if the hour is greater then the other clock hour (parameter), or if the minute is greater then the parameter, or if the second is greater then the parameter
     * @return 0 if both clocks are equal
     */
    public int compareTo(final Clock theOtherClock) {
        if (this.myHour < theOtherClock.myHour) {
            return -1;
        } else if (this.myHour > theOtherClock.myHour) {
            return 1;
          }
        else {
            if (this.myMinute < theOtherClock.myMinute) {
                return -1;
            } else if (this.myMinute > theOtherClock.myMinute) {
                return 1;
              }
            else {
                if (this.mySecond < theOtherClock.mySecond) {
                    return -1;
                } else if (this.mySecond > theOtherClock.mySecond) {
                    return 1;
                  }
                else {
                    return 0;
                }
            }
        }
    }
}