package subdomainVisitCount;

import java.util.*;

public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] splits = cpdomain.split(" ");
            int score = Integer.parseInt(splits[0]);
            List<String> subdomains = subdomains(splits[1]);
            for (String sub : subdomains) {
                int count = counts.getOrDefault(sub, 0);
                counts.put(sub, count + score);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    private List<String> subdomains(String domain) {
        List<String> subdomains = new ArrayList<>();
        String[] splits = domain.split("\\.");
        List<String> domains = Arrays.asList(splits);
        for (int i = 0; i < splits.length; i++) {
            subdomains.add(join(domains.subList(i, domains.size())));
        }
        return subdomains;
    }

    private String join(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (sb.length() != 0) {
                sb.append(".");
            }
            sb.append(str);
        }
        return sb.toString();
    }

}
