package tests;

import static org.junit.jupiter.api.Assertions.*;
import model.Item;
import java.math.BigDecimal;

/**
 *This will test each method for the Items class.
 * @author Liam Barragan
 * @version 1.0 10/28/2023
 */
class ItemTest {

    /** Holds an Item */
    private Item myItemTest;
    /** Holds a bad Item, which will hold bad parameters. */
    private Item myItemTestBad;
    /** Item will hold bulk quantity and bulk Price. */
    private Item myItemWBulk;

    /**
     * this will create different Items for each test method.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myItemTest = new Item("iPad", new BigDecimal("399.99"));
        myItemWBulk = new Item("Book", new BigDecimal("1.00"),
                2, new BigDecimal("2.00"));
    }

    /**
     * this will test if the get method does get the value of the Item from Item object.
     */

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(new BigDecimal("399.99"), myItemTest.getPrice());
    }

    /**
     * this will test if each exception is thrown.
     * tests if the Item name is null and if bulk quantity is out of bounds,
     * then throws IllegalArgumentException.
     * tests if price and bulk price is null,
     * then throw NullPointerException.
     * At the end I wanted to show that it can create a new Item.
     */
    @org.junit.jupiter.api.Test
    void itemConstructorTesting() {
        assertThrows(IllegalArgumentException.class,
                () -> myItemTestBad = new Item(null, new BigDecimal("1.00")));
        assertThrows(IllegalArgumentException.class,
                () -> myItemTestBad = new Item(null, new BigDecimal("1.00"),
                        -1, new BigDecimal(0.99)));
        assertThrows(NullPointerException.class,
                () -> myItemTestBad = new Item("Book", null,
                        1, null));
        final Item constructorTest = new Item("Book", new BigDecimal("1.00"),
                2, new BigDecimal("2.00"));
        assertEquals(myItemWBulk, constructorTest, "Created New Item");
    }

    /**
     * Checks to see if it gets the Bulk quantity.
     * I checked with a bulk quantity and one without it.
     */
    @org.junit.jupiter.api.Test
    void getBulkQuantity() {
        assertEquals(2, myItemWBulk.getBulkQuantity(), "The same quantity");
        assertEquals(0, myItemTest.getBulkQuantity(), "Same quantity");
    }

    /**
     * Checks to see if it gets the bulk price.
     * I checked if it does have bulk price and doesn't have one.
     */
    @org.junit.jupiter.api.Test
    void getBulkPrice() {
        assertEquals(false, myItemTest.isBulk(), "The same bulk price");
        assertEquals(true, myItemWBulk.isBulk(), "The same");

    }

    /**
     * Checks to see if the item is bulk or not.
     * I checked if it returns true or false,
     * meaning I checked if item is bulk or not.
     */
    @org.junit.jupiter.api.Test
    void isBulk() {
        assertEquals(true, myItemWBulk.isBulk(), "It is bulk");
        assertEquals(false, myItemTest.isBulk(), "Item is not bulk");
    }

    /**
     * Checks to see if the toString will print out the correct string.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        final String expectedtoString = "iPad, $399.99";
        assertEquals(expectedtoString, myItemTest.toString(), "Same String");
    }

    /**
     * checks to see if the equals methods is overrided.
     * I checked if they are true or not,
     * and checked with bulk and without bulk.
     */
    @org.junit.jupiter.api.Test
    void testEquals() {
        final Item equalsItem1 = new Item("iPad", new BigDecimal("399.99"));
        final Item equalsItem2 = new Item("Book", new BigDecimal("1.00"),
                2, new BigDecimal("2.00"));
        assertEquals(true, myItemTest.equals(equalsItem1), "They are =");
        assertEquals(false, myItemWBulk.equals(equalsItem1), "Not Same");
        assertEquals(true, myItemWBulk.equals(equalsItem2), "True");
        assertEquals(false, myItemWBulk.equals(myItemTest), "False");
    }

    /**
     * Checks to see if the hashCode() is overrided.
     * I checked with same Items and different Items.
     */
    @org.junit.jupiter.api.Test
    void testHashCode() {
        final Item equalsItem1 = new Item("iPad", new BigDecimal("399.99"));
        final Item equalsItem2 = new Item("Book", new BigDecimal("1.00"),
                2, new BigDecimal("2.00"));
        assertEquals(equalsItem1.hashCode(), myItemTest.hashCode(), "The Same");
        assertEquals(equalsItem2.hashCode(), myItemWBulk.hashCode(), "Same");
    }
}