package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import model.Cart;
import model.Item;
import model.ItemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This will test if each of the methods will work.
 * This is more specifically for the cart class.
 * It will test if the cart is created,
 * if it calculates total, and if there is a membership or not.
 * @author Liam Barragan
 * @version 1.0 10/28/23
 */
class CartTest {

    /** holds Item without bulk. */
    private Item myTestItem;
    /** holds item with bulk. */
    private Item myTestItemBulk;
    /** Item order for regular testing normal stuff. */
    private ItemOrder myTestItemOrder;
    /** Item order will be used for different stuff such as with bulk. */
    private ItemOrder myTestItemOrder1;
    /** cart that will be used throughout the class. */
    private Cart myCartTester;

    /**
     * this will help set up the carts and Items that will be used around the class.
     * these will include Item orders with or without bulk and empty carts.
     */
    @BeforeEach
    void setUp() {
        myTestItem = new Item("Book", new BigDecimal("2.00"));
        myTestItemBulk = new Item("iPad", new BigDecimal("39.99"),
                3, new BigDecimal("8.99"));
        myTestItemOrder = new ItemOrder(myTestItem, 2);
        myTestItemOrder1 = new ItemOrder(myTestItemBulk, 3);
        myCartTester = new Cart();
    }

    /**
     * Tests to see if the constructors work in making a new Cart.
     */
    @Test
    void testConstructor() {
        final Cart tempCart = new Cart();
        assertEquals(0, tempCart.getCartSize(), "shows new cart made");
    }

    /**
     * tests to see if the items are added.
     * It also tests if items are replaced.
     * Also sees if the NullPointerException is thrown when Cart is null
     */
    @Test
    void add() {
        assertThrows(NullPointerException.class,
                () -> myCartTester.add(null));
        myCartTester.add(myTestItemOrder);
        assertEquals(1, myCartTester.getCartSize(), "it added something");
        myCartTester.add(new ItemOrder(myTestItem, 3));
        assertEquals(1, myCartTester.getCartSize(), "contains item");
        final Item testerItem = new Item("Food", new BigDecimal("2.00"));
        final ItemOrder testerOrder = new ItemOrder(testerItem, 5);
        myCartTester.add(testerOrder);
        assertEquals(2, myCartTester.getCartSize(), "has 2 items");
    }

    /**
     * checks to see if membership is working.
     * Shows when membership is true then bulk price and quantity are applied.
     * Shows that it throws NullPointerException is thrown when it is false.
     */
    @Test
    void setMembership() {
        myCartTester.setMembership(true);
        final ItemOrder tempOrder = new ItemOrder(myTestItemBulk, 3);
        myCartTester.add(tempOrder);
        assertEquals(new BigDecimal("8.99"), myCartTester.calculateTotal(),
                "membership was included");
        assertTrue(true, "has membership");
        assertThrows(NullPointerException.class,
                () -> myCartTester.setMembership(false));

    }

    /**
     * Tests to see if the cart adds all the prices togethers.
     * It also shows zero when there is nothing inside.
     */
    @Test
    void calculateTotal() {
        myCartTester.add(myTestItemOrder);
        assertEquals(new BigDecimal("4.00"), myCartTester.calculateTotal(),
                "shows that it adds cart orders");
        myCartTester.add(myTestItemOrder1);
        assertEquals(new BigDecimal("123.97"), myCartTester.calculateTotal(),
                "shows that it adds multiple stuff");
        myCartTester.clear();
        assertEquals(new BigDecimal("0.00"), myCartTester.calculateTotal(),
                "shows that it puts zero if nothing is inside");


    }

    /**
     * tests to see what happens to calculate total has a membership applied.
     * Checks to see if bulk price and quantity are applied when there is a membership.
     */
    @Test
    void calculateTotalWMembership() {
        myCartTester.setMembership(true);
        myCartTester.add(myTestItemOrder1);
        assertEquals(new BigDecimal("8.99"), myCartTester.calculateTotal(),
                "with membership");
        myCartTester.add(myTestItemOrder);
        assertEquals(new BigDecimal("12.99"), myCartTester.calculateTotal(),
                "continues to add");

    }

    /**
     * Checks to see if the cart is cleared after calling this method.
     * I showed the before and after the cart is cleared out.
     */
    @Test
    void clear() {
        myCartTester.add(myTestItemOrder);
        assertEquals(1, myCartTester.getCartSize(),
                "before clearing");
        myCartTester.clear();
        assertEquals(0, myCartTester.getCartSize(), "after clearing");
    }

    /**
     * this checks to show the size of the cart.
     * tests should show the same number of items inside when calling this method.
     */
    @Test
    void getCartSize() {
        final Cart tempCart = new Cart();
        tempCart.add(myTestItemOrder);
        assertEquals(1, tempCart.getCartSize(),
                "shows there is something inside cart");
    }

    /**
     * Prints the cart as a string.
     * This basically sees if the hashset is printed out as a string.
     */
    @Test
    void testToString() {
        final String testToString = "Book, $2.00\n2";
        myCartTester.add(myTestItemOrder);
        assertEquals(testToString, myCartTester.toString(),
                "prints out stuff as a string");
    }
}