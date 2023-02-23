package findTheDuplicateNumber;

public class Solution {

    //
    // 快慢指针
    // 和环形链表II 很相似
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);
        fast = 0;
        while (nums[fast] != nums[slow]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[fast];
    }
}
