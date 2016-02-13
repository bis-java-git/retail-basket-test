package controller;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Agile development Team.
 */
public class BasketControllerTest {

    private BasketController basketController = new BasketController();

    @Test
    public void normalItemsOnlyTest() {
        final String[] items = {"Apples", "Bananas", "Apples", "Bananas"};
        final Integer actualPrice = 2 * 35 + 2 * 20;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void justBuy1Get1FreeItemsOnlyTest() {
        final String[] items = {"Melons", "Melons", "Melons", "Melons"};
        final Integer actualPrice = 2 * 50;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void justBuy1Get1FreeWithOddItemsTest() {
        final String[] items = {"Melons", "Melons", "Melons", "Melons", "Melons"};
        final Integer actualPrice = 3 * 50;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void mixedBuy1Get1FreeWithOddItemsTest() {
        final String[] items = {"Melons", "Melons", "Melons", "Melons", "Apples", "Bananas"};
        final Integer actualPrice = 2 * 50 + 35 + 20;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void justMinNumberOfItemsOnlyTest() {
        final String[] items = {"Limes", "Limes", "Limes", "Limes", "Limes", "Limes"};
        final Integer actualPrice = 4 * 15;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void justMinNumberOfItemsWithIncompletePackTest() {
        final String[] items = {"Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes"};
        final Integer actualPrice = 4 * 15;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void justMinNumberOfItemsWithIncompletePackNegativeTestTest() {
        final String[] items = {"Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes"};
        final Integer actualPrice = 4 * 15;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertNotEquals(expectedPrice, actualPrice);

    }

    @Test
    public void allItemsWithCompletePackTest() {
        final String[] items = {"Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Melons", "Melons", "Melons", "Melons", "Apples", "Bananas", "Apples", "Bananas", "Apples", "Bananas"};
        final Integer actualPrice = 4 * 15 + 2 * 50 + 35 + 20 + 2 * 35 + 2 * 20;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }


    @Test
    public void allItemsWithInCompletePackTest() {
        final String[] items = {"Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Melons", "Melons", "Melons", "Melons", "Apples", "Bananas", "Apples", "Bananas", "Apples", "Bananas"};
        final Integer actualPrice = 4 * 15 + 2 * 50 + 35 + 20 + 2 * 35 + 2 * 20;

        Integer expectedPrice = basketController.calculateTotal(Arrays.asList(items));
        assertEquals(expectedPrice, actualPrice);

    }
}
