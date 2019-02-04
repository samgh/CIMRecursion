import java.util.LinkedList;
import java.util.List;

public class Knapsack {
    public static class Item {
        int weight;
        int value;
        
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        
        public String toString() {
            return "{w: " + weight + ", v: " + value + "}";
        }
    }
    
    public static List<Item> knapsackBruteForce(Item[] items, int totalWeight) {
        List<List<Item>> results = new LinkedList<List<Item>>();
        knapsackBruteForce(items, 0, new LinkedList<Item>(), results);
        
        List<Item> maxList = null;
        int max = Integer.MIN_VALUE;
        
        for (List<Item> l : results) {
            int weight = 0;
            int value = 0;
            for (Item i : l) {
                weight += i.weight;
                value += i.value;
            }
            
            if (weight <= totalWeight && value > max) {
                maxList = l;
                max = value;
            }
        }
        
        return maxList;
    }
    
    private static void knapsackBruteForce(Item[] items, int i, List<Item> path,
                                             List<List<Item>> results) {
        if (i == items.length) {
            results.add(new LinkedList<Item>(path));
            return;
        }
        
        knapsackBruteForce(items, i+1, path, results);
        path.add(items[i]);
        knapsackBruteForce(items, i+1, path, results);
        path.remove(path.size() - 1);
    }
    
    public static List<Item> knapsackBacktracking(Item[] items, int totalWeight) {
        List<List<Item>> results = new LinkedList<List<Item>>();
        knapsackBacktracking(items, 0, new LinkedList<Item>(), 0, totalWeight, results);
        
        List<Item> maxList = null;
        int max = Integer.MIN_VALUE;
        
        for (List<Item> l : results) {
            int sum = 0;
            for (Item i : l) {
                sum += i.value;
            }
            
            if (sum > max) {
                maxList = l;
                max = sum;
            }
        }
        
        return maxList;
    }
    
    private static void knapsackBacktracking(Item[] items, int i, List<Item> path, 
                                             int currentWeight, int totalWeight,
                                             List<List<Item>> results) {
        if (currentWeight > totalWeight) return;
        if (i == items.length) {
            results.add(new LinkedList<Item>(path));
            return;
        }
        
        knapsackBacktracking(items, i+1, path, currentWeight, totalWeight, results);
        path.add(items[i]);
        knapsackBacktracking(items, i+1, path, currentWeight+items[i].weight, totalWeight, results);
        path.remove(path.size() - 1);
    }
    
    public static List<Item> knapsackBacktrackingOptimized(Item[] items, int totalWeight) {
        List<List<Item>> result = new LinkedList<List<Item>>();
        result.add(new LinkedList<Item>());
        knapsackBacktrackingOptimized(items, 0, new LinkedList<Item>(), 0, totalWeight, result);
        return result.get(0);
    }
    
    private static void knapsackBacktrackingOptimized(Item[] items, int i, List<Item> path,
                                                      int currentWeight, int totalWeight,
                                                      List<List<Item>> result) {
         if (currentWeight > totalWeight) return;
         if (i == items.length) {
             if (itemsValue(result.get(0)) < itemsValue(path)) {
                 result.set(0, new LinkedList<Item>(path));
             }
             return;
         }
         
         knapsackBacktrackingOptimized(items, i+1, path, currentWeight, totalWeight, result);
         path.add(items[i]);
         knapsackBacktrackingOptimized(items, i+1, path, currentWeight+items[i].weight, totalWeight, result);
         path.remove(path.size() - 1);
    }
        
    private static int itemsValue(List<Item> l) {
        int sum = 0;
        for (Item i : l) sum +=i.value;
        return sum;
    }
    
    public static class Result {
        List<Item> result;
        int value;
        
        public Result() {
            this.result = new LinkedList<Item>();
            this.value = 0;
        }
    }
    
    
    public static List<Item> knapsackOptimized(Item[] items, int totalWeight) {
        Result result = new Result();
        knapsackOptimized(items, 0, new LinkedList<Item>(), 0, totalWeight, result, 0);
        return result.result;
    }
    
    private static void knapsackOptimized(Item[] items, int i, List<Item> path, int currentWeight,
                                         int totalWeight, Result result, int currentValue) {
        if (currentWeight > totalWeight) return;
        if (i == items.length) {
            if (currentValue > result.value) {
                result.result = new LinkedList<Item>(path);
                result.value = currentValue;
            }
            return;
        }
        
        knapsackOptimized(items, i+1, path, currentWeight, totalWeight, result, currentValue);
        path.add(items[i]);
        knapsackOptimized(items, i+1, path, currentWeight+items[i].weight, totalWeight, result, currentValue+items[i].value);
        path.remove(path.size() - 1);
    }
    
    public static List<Item> knapsackBuiltUp(Item[] items, int totalWeight) {
        Result result = knapsackBuiltUp(items, totalWeight, 0);
        return result.result;
    }
    
    private static Result knapsackBuiltUp(Item[] items, int totalWeight, int i) {
        if (i == items.length) return new Result();
        
        Result exclude = knapsackBuiltUp(items, totalWeight, i+1);
        
        if (totalWeight-items[i].weight >= 0) {        
            Result include = knapsackBuiltUp(items, totalWeight - items[i].weight, i+1);
            
            if (include.value + items[i].value > exclude.value) {
                include.result.add(0, items[i]);
                include.value += items[i].value;
                return include;
            }
        }
        
        return exclude;
    }
    
    public static void main(String[] args) {
        System.out.println(knapsackBruteForce(new Item[]{new Item(1,6), new Item(2,10), new Item(3,12)}, 5));
        System.out.println(knapsackOptimized(new Item[]{new Item(1,6), new Item(2,10), new Item(3,12)}, 5));
        System.out.println(knapsackBuiltUp(new Item[]{new Item(1,6), new Item(2,10), new Item(3,12)}, 5));
    }
    // * items = {(w:1, v:6), (w:2, v:10), (w:3, v:12)}

}