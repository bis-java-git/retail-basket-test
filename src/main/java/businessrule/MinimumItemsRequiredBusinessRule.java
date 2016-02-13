package businessrule;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Agile Development team
 */
public final class MinimumItemsRequiredBusinessRule {

    private static final MinimumItemsRequiredBusinessRule INSTANCE = new MinimumItemsRequiredBusinessRule();

    private final Map<String, Integer> minimumItemTable = new ConcurrentHashMap<String, Integer>();

    //The following business rule will be fetch from the database or rest services for simplicity its hard coded
    private MinimumItemsRequiredBusinessRule() {
        minimumItemTable.put("Limes", 3);
    }


    public static MinimumItemsRequiredBusinessRule getInstance() {
        return INSTANCE;
    }

    public Integer getMinimumItemsRequired(final String item) {
        if (minimumItemTable.get(item) != null) {
            return minimumItemTable.get(item);
        }
        return 0;
    }
}
