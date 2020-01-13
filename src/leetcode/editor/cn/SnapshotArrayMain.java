//实现支持下列接口的「快照数组」- SnapshotArray： 
//
// 
// SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。 
// void set(index, val) - 会将指定索引 index 处的元素设置为 val。 
// int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。 
// int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。 
// 
//
// 
//
// 示例： 
//
// 输入：["SnapshotArray","set","snap","set","get"]
//     [[3],[0,5],[],[0,6],[0,0]]
//输出：[null,null,0,null,5]
//解释：
//SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
//snapshotArr.set(0,5);  // 令 array[0] = 5
//snapshotArr.snap();  // 获取快照，返回 snap_id = 0
//snapshotArr.set(0,6);
//snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5 
//
// 
//
// 提示： 
//
// 
// 1 <= length <= 50000 
// 题目最多进行50000 次set，snap，和 get的调用 。 
// 0 <= index < length 
// 0 <= snap_id < 我们调用 snap() 的总次数 
// 0 <= val <= 10^9 
// 
// Related Topics 数组


package leetcode.editor.cn;

public class SnapshotArrayMain{
      public static void main(String[] args) {
          SnapshotArray snapshotArray = new SnapshotArray(3);
          snapshotArray.set(0, 5);
          System.out.println(snapshotArray.snap());
          snapshotArray.set(0, 6);
          System.out.println(snapshotArray.get(0,0));
//          System.out.println(snapshotArray.snap());
//          System.out.println(snapshotArray.get(0,0));
//          System.out.println(snapshotArray.snap());
//          System.out.println(snapshotArray.get(0,0));
//          System.out.println(snapshotArray.snap());
      }
      

//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

class SnapshotArray {
    private int snap_id = 0;
    private int length = 0;
    private Node[] headers = null;

    public SnapshotArray(int length) {
        this.length = length;
        headers = new Node[length];
    }

    public void set(int index, int val) {
        if (index >= length) return ;
        Node header = headers[index];
        if (header == null) {
            header = new Node(-1, 0);
            headers[index] = header;
            Node node = new Node(snap_id, val);
            node.next = header;
            header.next = node;
            return ;
        }
        Node tmp = header.next;
        while (tmp.next != header && tmp.snap_id < snap_id) {
            tmp = tmp.next;
        }
        if (tmp.snap_id == snap_id) {
            tmp.value = val;
            return ;
        }
        Node node = new Node(this.snap_id, val);
        node.next = tmp.next;
        tmp.next = node;
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        if (index >= length || snap_id >= this.snap_id) return 0;
        Node header = headers[index];
        if (header == null) {
            return 0;
        }
        Node tmp = header.next;
        Node pre = header;
        while (tmp != header && tmp.snap_id <= snap_id) {
            if (tmp.snap_id == snap_id) {
                return tmp.value;
            }
            pre = tmp;
            tmp = tmp.next;
        }
        if (pre.snap_id < snap_id) {
            return pre.value;
        }
        return 0;
    }
}

class Node {
    public int snap_id;
    public int value;
    public Node next;

    public Node(int snap_id, int value) {
        this.snap_id = snap_id;
        this. value = value;
        next = this;
    }
}