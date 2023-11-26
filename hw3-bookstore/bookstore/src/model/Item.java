package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This will make the Items as an Object.
 * There are getters, overrided equals method, and hashcode.
 * This will create Items with name, price, bulk price, and bulk quantity.
 * @author Liam Barragan
 * @version 1.0 10/20/2023
 */
public class Item {

    /** helps format the price. */
    private static final NumberFormat MY_FORMAT =
            NumberFormat.getCurrencyInstance(Locale.US);
    /** holds Item name. */
    private final String myName;
    /** holds the Item price. */
    private final BigDecimal myPrice;
    /** Holds the Bulk price. */
    private BigDecimal myBulkPrice;
    /** Holds the bulk quantity. */
    private int myBulkQuantity;

    /**
     * This is the constructor for the Item, this will contain price and name.
     * @param theName Name of the Item.
     * @param thePrice Price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice) {

        this(theName, thePrice, 0, new BigDecimal("0.00"));

    }


    /**
     * this is the constructor of the item class.
     * this will contain the Item name, item price, bulk price, and bulk quantity.
     * Checks if each parameter is either null or less than 0.
     * @thows IllegalArgumentException if name is null and bulk quantity is < 0.
     * @throws NullPointerException price and bulk price are null.
     * @param theName Item name.
     * @param thePrice Item price.
     * @param theBulkQuantity Hold bulk quantity.
     * @param theBulkPrice Hold bulk price.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        if (theName == null || theBulkQuantity < 0) {
            throw new IllegalArgumentException();
        }
        if (thePrice == null || theBulkPrice == null) {
            throw new NullPointerException();
        }
        this.myName = theName;
        this.myPrice = thePrice;
        this.myBulkPrice = theBulkPrice;
        this.myBulkQuantity = theBulkQuantity;

    }


    /**
     * this will get the price from of the Item.
     * @return the price of the Item.
     */
    public BigDecimal getPrice() {
        return myPrice;
    }


    /**
     * this will get the bulk quantity of the Item.
     * @return the bulk quantity of the item.
     */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    /**
     * this will get the bulk price of the Item.
     * @return bulk price of the Item.
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }


    /**
     * checks if the Item is bulk
     * @return true if quantity is more than zero, false otherwise.
     */
    public boolean isBulk() {
        return myBulkQuantity > 0;
    }

    /**
     * This will override toString.
     * This will show the Item name, then price.
     * If it is a bulk then, it will add bulk quantity and bulk price.
     * @return String of the Item and price
     */
    @Override
    public String toString() {
        String stringItem = myName + ", " + MY_FORMAT.format(myPrice);
        if (isBulk()) {
            stringItem += " (" + myBulkQuantity + " for $"
                    + myBulkPrice + ")";
        }
        return stringItem;
    }

    /**
     * this will override the equals() method.
     * checks to see if the item is the same.
     * if not the same then it will return false.
     * but if it will return each parameter of an item and compare each.
     * @param theOther the other Item.
     * @return each parameter of an Object and compares.
     * @return false if it is not the same or Item does not exist.
     */
    @Override
    public boolean equals(final Object theOther) {
        if (theOther == null || this.getClass() != theOther.getClass()) {
            return false;
        }
        final Item otherItem = (Item) theOther;
        return  myName.equals(otherItem.myName)
                && myPrice.equals(otherItem.myPrice)
                && myBulkPrice.equals(otherItem.myBulkPrice)
                && myBulkQuantity == otherItem.myBulkQuantity;
    }

    /**
     * This will override hashCode() method
     * It will assign a value to each of the Item parameter
     * @return value to each of the parameter.
     */
    @Override
    public int hashCode() {
        return myName.hashCode() + myPrice.hashCode() + myBulkPrice.hashCode()
                + myBulkQuantity;
    }

}
