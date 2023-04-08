package smallestSufficientTeam;

import java.util.*;

public class Solution {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        // 使用一个 bitmap 记录所有技能
        Map<String, Integer> offsetMap = new HashMap<>();
        int target = 0;
        for (int i = 0; i < req_skills.length; i++) {
            offsetMap.put(req_skills[i], i);
            target |= (1 << i);
        }

        // 每个人拥有的技能也是一个 bitmap
        int[] peopleSkills = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int skill = 0;
            for (String p : people.get(i)) {
                skill |= (1 << offsetMap.getOrDefault(p, 0));
            }
            peopleSkills[i] = skill;
            if (skill == target) {
                return new int[]{i};
            }
        }

        // 使用动态规划，dp[i] 代表达到满足 技能列表 i 时需要的最少人数
        int[] dp = new int[1 << req_skills.length];
        Arrays.fill(dp, people.size());
        dp[0] = 0;
        // prevPerson[i] 代表满足时的最后添加的人
        int[] prevPerson = new int[1 << req_skills.length];
        // prevSkill[i] 代表前一个 skill
        int[] prevSkill = new int[1 << req_skills.length];

        for (int i = 0; i < peopleSkills.length; i++) {

            for (int pre = 0; pre < dp.length; pre++) {
                int res = pre | peopleSkills[i];
                if (dp[res] > dp[pre] + 1) {
                    dp[res] = dp[pre] + 1;
                    prevPerson[res] = i;
                    prevSkill[res] = pre;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int i = dp.length;
        while (i > 0) {
            res.add(prevPerson[i]);
            i = prevSkill[i];
        }

        return res.stream().mapToInt(a -> a).toArray();
    }

}
