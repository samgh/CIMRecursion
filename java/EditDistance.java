import java.util.LinkedList;
import java.util.List;

public class EditDistance {
    public static class Step {
        String before;
        String after;
        
        public Step(String before, String after) {
            this.before = before;
            this.after = after;
        }
        
        public String toString() {
            return "\"" + before + "\" -> \"" + after + "\""; 
        }
    }
    
    public static List<Step> editDistance(String s1, String s2) {
        return editDistance(s1, s2, 0);
    }
    
    private static List<Step> editDistance(String s1, String s2, int i) {
        if (s1.equals(s2)) {
            return new LinkedList<Step>();
        }
        
        if (i >= s1.length()) {
            return insert(s1, s2, i);
        }
        
        if (i >= s2.length()){
            return remove(s1, s2, i);
        }
        
        List<Step> inserted = insert(s1, s2, i);
        List<Step> removed = remove(s1, s2, i);
        List<Step> swapped = swap(s1, s2, i);
        
        List<Step> toReturn = inserted;
        if (removed.size() < toReturn.size()) toReturn = removed;
        if (swapped.size() < toReturn.size()) toReturn = swapped;
        
        if (s1.charAt(i) == s2.charAt(i)) {
            List<Step> skipped = editDistance(s1, s2, i+1);
            if (skipped.size() < toReturn.size()) toReturn = skipped;
        }
        
        return toReturn;
    }

    private static List<Step> insert(String s1, String s2, int i) {
        String insert = s1.substring(0, i) + s2.charAt(i) + s1.substring(i, s1.length());
        List<Step> toReturn = editDistance(insert, s2, i+1);
        toReturn.add(0, new Step(s1, insert));
        return toReturn;
    }
    
    private static List<Step> remove(String s1, String s2, int i) {
        String remove = s1.substring(0, i) + s1.substring(i+1, s1.length());
        List<Step> toReturn = editDistance(remove, s2, i);
        toReturn.add(0, new Step(s1, remove));
        return toReturn;
    }
    
    private static List<Step> swap(String s1, String s2, int i) {
        String swap = s1.substring(0, i) + s2.charAt(i) + s1.substring(i+1, s1.length());
        List<Step> toReturn = editDistance(swap, s2, i+1);
        toReturn.add(0, new Step(s1, swap));
        return toReturn;
    }

    public static void main(String[] args) {
        System.out.println(editDistance("adi", "abcadefghai"));
    }
}