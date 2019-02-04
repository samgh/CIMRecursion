public class MakingChange {
    public static int makingChange(int[] coins, int amt) {
        return makingChange(coins, amt, 0);
    }
    
    private static int makingChange(int[] coins, int amt, int i) {
        if (amt == 0) return 0;
        if (amt < 0 || i == coins.length) return -1;
        
        int include = makingChange(coins, amt - coins[i], i);
        int exclude = makingChange(coins, amt, i+1);
        
        if (include < 0) return exclude;
        if (exclude < 0) return include + 1;
        
        return Math.min(include+1, exclude);
    }
    
    public static void main(String[] args) {
        System.out.println(makingChange(new int[]{1,6,10}, 12));
    }
}