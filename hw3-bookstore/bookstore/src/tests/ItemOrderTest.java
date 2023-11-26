package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This will test all of the methods inside the Item Order class.
 * It will see if each of the Item Orders are created,
 * gets item and quantity and prints into a string.
 * @author Liam Barragan
 * @version 1.0 10/28/2023
 */

class ItemOrderTest {

    /** this will hold Items inside to test if Item order is created. */
    private Item myTestItem;
    /** this will be "normal" item Order created. */
    private ItemOrder myTestOrder;
    /** these will be the bad Item Orders. */
    private ItemOrder myBadOrder;

    /**
     * This will create "normal" Item and Item orders to test if methods works.
     */
    @BeforeEach
    void setUp() {
        myTestItem = new Item("Book", new BigDecimal("3.00"));
        myTestOrder = new ItemOrder(myTestItem, 9);
    }

    /**
     * this will test if the item is gotten from the item order.
     */
    @Test
    void getItem() {
        assertEquals(myTestItem, myTestOrder.getItem(), "Got Item!");
    }

    /**
     * tests the constructor
     * Tests if the NullpointerException and IllegalArguments are thrown,
     * when something not excpected happens.
     */
    @Test
    void testConstructor() {
        assertThrows(NullPointerException.class,
                () -> myBadOrder = new ItemOrder(null, 2));
        assertThrows(IllegalArgumentException.class,
                () -> myBadOrder = new ItemOrder(myTestItem, -2));
    }

    /**
     * tests to see if the quantity is returned when calling this method.
     */
    @Test
    void getQuantity() {
        assertEquals(9, myTestOrder.getQuantity(), "Got Quantity");
    }

    /**
     * tests to see if the toString() has been overridden.
     * Also sees if the contents is put into a string.
     */
    @Test
    void testToString() {
        final String testString = "Item Name: Book, $3.00 Quantity: 9";
        assertEquals(testString, myTestOrder.toString(), "Same String");
    }
}