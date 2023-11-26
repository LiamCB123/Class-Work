// Finish and comment me!

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;

/**
 * This will create the Cart.
 * I made it into a hashSet to hold the item orders.
 * The methods will add, calculate the prices,
 * checks if they are a member and adds items and replace same items with updated quantity.
 * @author Liam Barragan
 * @version 1.0 10/26/2023
 */
public class Cart {

    /** will hold the Item order in hashSet. */
    private final HashSet<ItemOrder> myCart;
    /** this will help check if there is a membership. */
    private boolean myMembership;

    /**
     * My constructor, it will create a new hashSet.
     */
    public Cart() {
        myCart = new HashSet<>();
    }


    /**
     * this will add items into the hashset.
     * it will replace same Item with an updated Item order.
     * @param theOrder the Item order that is being added.
     */
    public void add(final ItemOrder theOrder) {
        if (theOrder == null) {
            throw new NullPointerException();
        }

        for (ItemOrder findOrder : myCart) {
            final Item itemFind = findOrder.getItem();
            if (itemFind.equals(theOrder.getItem())) {
                myCart.remove(findOrder);
                break;
            }
        }
        myCart.add(theOrder);

    }


    /**
     * checks to see if there is a membership.
     * If there isn't throw null pointer exception.
     * @throws NullPointerException if membership is not there.
     * @param theMembership The memebership for the bookstore.
     */
    public void setMembership(final boolean theMembership) {
        if (!theMembership) {
            throw new NullPointerException();
        } else {
            myMembership = theMembership;
        }
    }


    /**
     * Helps add up the total prices together inside the cart.
     * If there is a membership the bulk quantity and quantity,
     * will divide, and multiply it times the bulk price,
     * then if there is a remainder quantity,
     * then it will multiply with regular price.
     * If there is no membership then multiply quantity times regular price.
     * @return price when there is a membership.
     * @return price when no membership.
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (final ItemOrder customerOrder : myCart) {
            final Item cartItem = customerOrder.getItem();
            final int cartQuantity = customerOrder.getQuantity();
            final int cartBulkQuantity = cartItem.getBulkQuantity();
            final BigDecimal cartPrice = cartItem.getPrice();
            final BigDecimal cartBulkPrice = cartItem.getBulkPrice();
            if (customerOrder == null || cartItem == null) {
                throw new NullPointerException();
            }
            if (cartPrice == null || cartBulkPrice == null) {
                throw new NullPointerException();
            }
            if (cartQuantity < 0 || cartBulkQuantity < 0) {
                throw new IllegalArgumentException();
            }
            if (myMembership && customerOrder.getItem().isBulk()) {
                final int quantity = cartQuantity / cartBulkQuantity;
                final int remainderQuantity = cartQuantity % cartBulkQuantity;
                total = total.add(cartBulkPrice.multiply(BigDecimal.valueOf(quantity)));
                total = total.add(cartPrice.multiply(BigDecimal.valueOf(remainderQuantity)));
            } else {
                total = total.add(cartPrice.multiply(new BigDecimal(cartQuantity)));
            }
        }
        return total.setScale(2, RoundingMode.HALF_DOWN);
    }


    /**
     * clears the cart (hashSet) when called on.
     */
    public void clear() {
        myCart.clear();
    }


    /**
     * gets the size of the cart size when called on.
     * @return the size of the hashSet.
     */
    public int getCartSize() {
        return myCart.size();
    }


    /**
     * Overrides the toString to print what is inside the cart.
     * @return returns a string of Items and quantity.
     */
    @Override
    public String toString() {
        final StringBuilder sBuilder = new StringBuilder();
        for (ItemOrder orderInCart : myCart) {
            sBuilder.append(orderInCart.getItem()).append("\n");
            sBuilder.append(orderInCart.getQuantity());
        }
        return sBuilder.toString();
    }

}
