import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class SortedPermutations {
    public static List<List<Integer>> sortedPermutations(int[] arr) {
        Arrays.sort(arr);
        return Permutations.permutationsSwap(arr);
    }
    
    public static void main(String[] args) {
        System.out.println(sortedPermutations(new int[]{3,2,1}));
    }
}
