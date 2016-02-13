package businessrule;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Agile Development Team
 */
public class MiminmumItemPriceAdjustmentBusinessRule {
    private static final MiminmumItemPriceAdjustmentBusinessRule INSTANCE = new MiminmumItemPriceAdjustmentBusinessRule();

    private final Map<String, Integer> minimumItemPriceTable = new ConcurrentHashMap<String, Integer>();

    //The following business rule will be fetch from the database or rest services for simplicity its hard coded
    private MiminmumItemPriceAdjustmentBusinessRule() {
        minimumItemPriceTable.put("Limes", 2);
    }


    public static MiminmumItemPriceAdjustmentBusinessRule getInstance() {
        return INSTANCE;
    }

    public Integer getMinimumItemsPriceRequired(final String item) {
        if (minimumItemPriceTable.get(item) != null) {
            return minimumItemPriceTable.get(item);
        }
        return 1;
    }
}
