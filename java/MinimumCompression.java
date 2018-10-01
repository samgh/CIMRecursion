import java.util.HashMap;
import java.util.Map;

public class MinimumCompression {
    public static class CompressedString {
        String value;
        int repetitions;
        
        public CompressedString(String value, int repetitions) {
            this.value = value;
            this.repetitions = repetitions;
        }
        
        public int length() {
            if (repetitions == 1) return value.length();
            return value.length() + 3;
        }
        
        public String toString() {
            if (repetitions == 1) return value;
            return "" + repetitions + "[" + value + "]";
        }
    }
    
    public static String minimumCompression(String input) {
        CompressedString result = minimumCompressionInner(input);
        return result.toString();
    }
    
    private static CompressedString minimumCompressionInner(String input) {
        CompressedString result = new CompressedString(input, 1);
        for (int i = 1; i < input.length(); i++) {
            CompressedString prefix = minimumCompressionInner(input.substring(0, i));
            CompressedString suffix = minimumCompressionInner(input.substring(i, input.length()));
            
            if (prefix.value.equals(suffix.value)) {
                if (prefix.length() < result.length()) {
                    result = new CompressedString(prefix.value, prefix.repetitions + suffix.repetitions);
                }
            } else {
                String curr = prefix.toString() + suffix.toString();
                if (curr.length() < result.length()) {
                    result = new CompressedString(curr, 1);
                }
            }
        }
        return result;
    }
    
    public static String minimumCompressionDP(String input) {
        CompressedString result = minimumCompressionDP(input, new HashMap<String, CompressedString>());
        return result.toString();
    }
    
    private static CompressedString minimumCompressionDP(String input, Map<String, CompressedString> dp) {
        if (dp.containsKey(input)) return dp.get(input);
       
        CompressedString result = new CompressedString(input, 1);
        for (int i = 1; i < input.length(); i++) {
            CompressedString prefix = minimumCompressionDP(input.substring(0, i), dp);
            CompressedString suffix = minimumCompressionDP(input.substring(i, input.length()), dp);
            
            if (prefix.value.equals(suffix.value)) {
                if (prefix.length() < result.length()) {
                    result = new CompressedString(prefix.value, prefix.repetitions + suffix.repetitions);
                }
            } else {
                String curr = prefix.toString() + suffix.toString();
                if (curr.length() < result.length()) {
                    result = new CompressedString(curr, 1);
                }
            }
        }
        
        dp.put(input, result);
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(minimumCompressionDP("abdddddabdddddabdddddabddddd"));
    }
}