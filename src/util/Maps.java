package util;

import java.util.*;

public final class Maps {
    private Maps() {
    }

    public static <K, V> Map<K, V> of(List<K> keys, List<V> vals) {
        if (keys == null || vals == null || keys.size() != vals.size()) {
            throw new IllegalArgumentException("keys and vals must have the same size");
        }
        Map<K, V> map = new HashMap<>();
        Iterator<K> keyIt = keys.iterator();
        Iterator<V> valIt = vals.iterator();
        while (keyIt.hasNext()) {
            map.put(keyIt.next(), valIt.next());
        }
        return map;
    }

    public static <K, V> Map<K, V> of(K key, V val) {
        Map<K, V> map = new HashMap<>();
        map.put(key, val);
        return map;
    }
}
