package Model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Agile development team
 */
public final class ItemPriceTable {

    private static final ItemPriceTable INSTANCE = new ItemPriceTable();

    private Map<String, Integer> pricesTable = new ConcurrentHashMap<String, Integer>();

    //The following price data will be fetch from the database or rest services for simplicity its hard coded
    private ItemPriceTable() {
        pricesTable.put("Bananas", 20);
        pricesTable.put("Apples", 35);
        pricesTable.put("Melons", 50);
        pricesTable.put("Limes", 15);
    }

    public static final ItemPriceTable getInstance() {
        return INSTANCE;
    }

    public Integer getPrice(final String item) {
        if (pricesTable.get(item) != null) {
            return pricesTable.get(item);
        }
        return 0;
    }
}
