public class BinarySearch {
    public static boolean contains(int[] arr, int x) {
        return contains(arr, x, 0, arr.length - 1);
    }
    
    private static boolean contains(int[] arr, int x, int min, int max) {
        if (min == max) return arr[min] == x;
        
        int mid = (min + max) / 2;
        
        if (arr[mid] > x) return contains(arr, x, min, mid-1);
        if (arr[mid] < x) return contains(arr, x, mid+1, max);
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(contains(new int[]{1,2,3,4,5,6}, 1));
        System.out.println(contains(new int[]{1,2,3,4,5,6}, 7));
    }
}