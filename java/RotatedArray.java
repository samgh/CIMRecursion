public class RotatedArray {
    public static int findMin(int[] arr) {
        return findMin(arr, 0, arr.length-1);
    }
    
    private static int findMin(int[] arr, int min, int max) {
        if (arr[min] < arr[max]) return min;
        if (min+1 == max) return max;
        
        int mid = (min + max) / 2;
        if (arr[min] < arr[mid]) return findMin(arr, mid, max);
        return findMin(arr, min, mid);
    }
    
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,2,3,4}));
        System.out.println(findMin(new int[]{1,2,3,4,5,6}));
        System.out.println(findMin(new int[]{2,3,4,5,6,1}));
        System.out.println(findMin(new int[]{3,4,5,6,1,2}));
        System.out.println(findMin(new int[]{4,5,6,1,2,3}));
        System.out.println(findMin(new int[]{5,6,1,2,3,4}));
        System.out.println(findMin(new int[]{6,1,2,3,4,5}));
    }
}