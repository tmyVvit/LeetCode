package a_daily.d_20231112;

import java.util.*;

public class HighAccessEmployees {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, PriorityQueue<AccessTime>> map = new HashMap<>();

        for (List<String> accessTime : access_times) {
            String id = accessTime.get(0);
            String time = accessTime.get(1);
            map.computeIfAbsent(id, k -> new PriorityQueue<>()).add(new AccessTime(time));
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            PriorityQueue<AccessTime> queue = map.get(key);
            if (queue == null || queue.isEmpty() || queue.size() < 3) {
                continue;
            }
            AccessTime pre = queue.poll();
            AccessTime cur = queue.poll();
            AccessTime next = null;
            while ((next = queue.poll()) != null) {
                if (pre.sameHour(next)) {
                    result.add(key);
                    break;
                }
                pre = cur;
                cur = next;
            }
        }
        return result;
    }

    static class AccessTime implements Comparable<AccessTime> {
        String originTimeStr;
        int hour;
        int minute;
        AccessTime(String time) {
            originTimeStr = time;
            hour = Integer.parseInt(time.substring(0, 2));
            minute = Integer.parseInt(time.substring(2));
        }

        boolean sameHour(AccessTime other) {
            if (hour == other.hour) {
                return true;
            }
            AccessTime after = hour > other.hour ? this : other;
            AccessTime before = after == this ? other : this;

            if (after.hour - before.hour > 1) {
                return false;
            }
            return after.minute < before.minute;
        }

        public int compareTo(AccessTime other) {
            if (hour == other.hour) {
                return Integer.compare(minute, other.minute);
            }
            return Integer.compare(hour, other.hour);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessTime) {
                AccessTime at = (AccessTime) obj;
                return originTimeStr.equals(at.originTimeStr)
                        && hour == at.hour
                        && minute == at.minute;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(originTimeStr, hour, minute);
        }
    }
}
