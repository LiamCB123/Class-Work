// Finish and comment me!

package model;

/**
 * This is the ItemOrder class, it will create Item orders with Item object,
 * and quantities of that Item.
 * There are getters and a toString() in this method.
 * @author Liam Barragan
 * @version 1.0 10/22/2023
 */
public final class ItemOrder {

    /** This will hold the Item Object. */
    private final Item myItem;

    /** this will hold the quantity of that Item. */
    private final int myQuantity;

    /**
     * this is the constructor.
     * This will also check if the Item and quantity are initialized.
     * Also checks what happens when Item is null and quantity is out of bounds.
     * @throws NullPointerException when Item is null.
     * @throws IllegalArgumentException when quantity is less than zero.
     * @param theItem the Item of the order.
     * @param theQuantity the Quantity of that Item.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {

        if (theItem == null) {
            throw new NullPointerException();
        }
        if (theQuantity < 0) {
            throw new IllegalArgumentException();
        }
        this.myItem = theItem;
        this.myQuantity = theQuantity;
    }

    /**
     * This will get the Item inside the order.
     * @return the item of the order.
     */
    public Item getItem() {
        return myItem;
    }


    /**
     * This will get the quantity in the Item order.
     * @return the quantity of the Item order.
     */
    public int getQuantity() {
        return myQuantity;
    }

    /**
     * this will override the toString() method.
     * this will print out the Item name followed by the quantity.
     * @return a String of the Item Order with item name and item quantities.
     */
    @Override
    public String toString() {

        return "Item Name: " + myItem + " Quantity: " + myQuantity;
    }

}
