package controller;

import Model.ItemPriceTable;
import businessrule.BuyOneAndGetOneFreeItemsBusinessRule;
import businessrule.MinimumItemsRequiredBusinessRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Agile Development Team
 */
public class BasketController {

    private BuyOneAndGetOneFreeItemsBusinessRule buyOneAndGetOneFreeItemsBusinessRule = BuyOneAndGetOneFreeItemsBusinessRule.getInstance();

    private MinimumItemsRequiredBusinessRule minimumItemsRequiredBusinessRule = MinimumItemsRequiredBusinessRule.getInstance();

    private ItemPriceTable itemPriceTable = ItemPriceTable.getInstance();

    public Integer calculateTotal(List<String> items) {

        final Map<String, Integer> freeCounter = new HashMap<String, Integer>();
        final Map<String, Integer> minCounter = new HashMap<String, Integer>();

        Integer totalCost = 0;
        for (String item : items) {

            //Business Rule 1, where no minimum items required, buy one and get one free
            if (minimumItemsRequiredBusinessRule.getMinimumItemsRequired(item) == 0) {

                //Assumptions as per requirement Buy 1 and get 1 free is implemented so far
                //Further logic can be implemented buy 2 get 3rd free, similarly buy 3 for the price of 2
                if (buyOneAndGetOneFreeItemsBusinessRule.getFreeItem(item) == 1) {
                    if (freeCounter.get(item) != null) {
                        // item already paid for it
                        freeCounter.remove(item);

                    } else {
                        totalCost = totalCost + itemPriceTable.getPrice(item);
                        freeCounter.put(item, 1);
                    }
                } else {
                    totalCost = totalCost + itemPriceTable.getPrice(item);
                }

            } else {
                //Business Rule 2, where minimum items are required
                if (minCounter.get(item) != null) {
                    if (minimumItemsRequiredBusinessRule.getMinimumItemsRequired(item) == minCounter.get(item) + 1) {
                        //Adjust price, Business Rule 3
                        Integer itemAdjustedPrice = (minCounter.get(item)-(minimumItemsRequiredBusinessRule.getMinimumItemsRequired(item)-1)) * itemPriceTable.getPrice(item);
                        totalCost = totalCost + itemAdjustedPrice;
                        minCounter.remove(item);
                    } else {
                        totalCost = totalCost + itemPriceTable.getPrice(item);
                        minCounter.put(item, minCounter.get(item) + 1);
                    }
                } else {
                    minCounter.put(item, 1);
                    totalCost = totalCost + itemPriceTable.getPrice(item);
                }
            }
        }
        //Need to check incomplete items
        //Assumption is made that incomplete items are taken back from the total cost
        final Set<String> incompletePack = minCounter.keySet();
        for (String item : incompletePack) {
            totalCost = totalCost - minCounter.get(item) * itemPriceTable.getPrice(item);
        }
        return totalCost;
    }
}
