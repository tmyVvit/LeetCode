package Huawei;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivateTest {
    public static void main(String[] args) {
        String[] names = {"b","b","b","b","b","b"};
        String[] times = {"22:57","23:40","03:43","21:55","20:38","00:19"};
        PrivateTest test = new PrivateTest();
        List res = test.alertNames(names, times);
        System.out.println("sdf");
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, ListNode> table = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i], time = keyTime[i];
            if (table.get(name) == null) {
                table.put(name, new ListNode());
            }
            ListNode list = table.get(name);
            if (list.addAndJudge(time)) {
                result.add(name);
            }
        }
        result.sort(String::compareTo);
        return result;
    }

    static class ListNode {
        Node head;
        int state;

        public ListNode() {
            head = new Node("head");
            state = 0;
        }

        boolean addAndJudge(String time) {
            if (state != 0) return false;
            Node preNode = head;
            while (preNode.next != null) {
                if (preNode.next.time.equals(time)) return false;
                if (preNode.next.time.compareTo(time) > 0) break;
                preNode = preNode.next;
            }
            Node added = new Node(time);
            Node next = preNode.next;
            preNode.next = added;
            added.next = next;
            added.before = preNode;
            if (next != null) next.before = added;
            boolean result =  inOneHour(preNode, next) || inOneHour(preNode.before, added);
            if (result) {
                state = 1;
                return true;
            }
            if (next != null && inOneHour(added, next.next)){
                state = 1;
                return true;
            }
            return false;
        }

        private boolean inOneHour(Node before, Node after) {
            if (before == null || after == null || before == head) return false;
            String time1 = before.time, time2 = after.time;
            String[] timeStr1 = time1.split(":");
            String[] timeStr2 = time2.split(":");
            if (timeStr1[0].equals(timeStr2[0])) return true;
            int hour1, hour2;
            hour1 = Integer.parseInt(timeStr1[0]);
            hour2 = Integer.parseInt(timeStr2[0]);
            if (hour2 - hour1 > 1) return false;
            return timeStr1[1].compareTo(timeStr2[1]) >= 0;
        }
    }

    static class Node {
        String time;
        Node next;
        Node before;
        public Node(String _time) {
            time = _time;
        }
    }
}
