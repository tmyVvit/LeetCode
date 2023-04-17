package jianzhi;

import java.util.ArrayList;
import java.util.List;

public class CombinesK {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        choose(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    private void choose(int i, int n, int k, List<Integer> res, List<List<Integer>> ans) {
        if (res.size() == k) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if (i > n || (n - i + 1 + res.size()) < k) {
            return;
        }

        choose(i + 1, n, k, res, ans);
        res.add(i);
        choose(i + 1, n, k, res, ans);
        res.remove(res.size() - 1);
    }
}
