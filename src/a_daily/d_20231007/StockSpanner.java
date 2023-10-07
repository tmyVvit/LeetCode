package a_daily.d_20231007;

import java.util.LinkedList;

public class StockSpanner {

    LinkedList<int[]> prices;

    public StockSpanner() {
        prices = new LinkedList<>();
    }

    public int next(int price) {
        int result = 1;
        while (!prices.isEmpty()) {
            int[] top = prices.peek();
            if (top[0] <= price) {
                result += top[1];
                prices.pop();
            } else {
                break;
            }
        }
        prices.push(new int[]{price, result});
        return result;
    }
}
