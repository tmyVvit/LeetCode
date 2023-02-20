package longestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, JoinSet> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {

            if (map.containsKey(num)) {
                continue;
            }

            JoinSet minus = map.get(num - 1);
            JoinSet plus = map.get(num + 1);

            if (minus != null && plus != null) {
                if (minus == plus) {
                    minus.add(num);
                    map.put(num, minus);
                    max = Math.max(max, minus.size());
                } else {
                    plus.add(num);
                    JoinSet combine = minus.combine(plus);
                    for (int v : plus.member) {
                        map.put(v, combine);
                    }
                    max = Math.max(max, combine.size());
                }
            } else if (minus != null) {
                minus.add(num);
                map.put(num, minus);
                max = Math.max(max, minus.size());
            } else if (plus != null){
                plus.add(num);
                map.put(num, plus);
                max = Math.max(max, plus.size());
            } else {
                map.put(num, new JoinSet(num));
                max = Math.max(max, 1);
            }
        }
        return max;
    }

    static class JoinSet {
        Set<Integer> member;

        JoinSet(int num) {
            member = new HashSet<>();
            member.add(num);
        }

        void add(Integer i) {
            member.add(i);
        }

        JoinSet combine(JoinSet set) {
            this.member.addAll(set.member);
            return this;
        }

        int size() {
            return member.size();
        }

    }
}
