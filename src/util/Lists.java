package util;

import java.util.ArrayList;
import java.util.List;

public final class Lists {
    private Lists() {
    }

    public static <V> List<V> of(V... vals) {
        List<V> list = new ArrayList<>();
        for (V val : vals) {
            list.add(val);
        }
        return list;
    }

}
