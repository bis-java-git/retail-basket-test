package businessrule;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Agile Development Team
 */
public class BuyOneAndGetOneFreeItemsBusinessRule {

    private static final BuyOneAndGetOneFreeItemsBusinessRule INSTANCE = new BuyOneAndGetOneFreeItemsBusinessRule();

    private final  Map<String, Integer> buyOneGetOneFreeTable = new ConcurrentHashMap<String, Integer>();

    //The following business rule will be fetch from the database or rest services for simplicity its hard coded
    private BuyOneAndGetOneFreeItemsBusinessRule() {
        buyOneGetOneFreeTable.put("Melons", 1);
    }

    public static BuyOneAndGetOneFreeItemsBusinessRule getInstance() {
        return INSTANCE;
    }

    public Integer getFreeItem(final String item) {
        if (buyOneGetOneFreeTable.get(item) != null) {
            return buyOneGetOneFreeTable.get(item);
        }
        return 0;
    }
}
