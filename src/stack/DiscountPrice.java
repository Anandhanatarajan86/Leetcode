package stack;

import java.util.Stack;

public class DiscountPrice {

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> priceStack = new Stack<>();
        for (int index = prices.length - 1; index >= 0; index--) {
            while (!priceStack.isEmpty() && priceStack.peek() > prices[index]) {
                priceStack.pop();

            }
            res[index] = prices[index] - (priceStack.isEmpty() ? 0 : priceStack.peek());
            priceStack.push(prices[index]);
        }
        return res;
    }
}
