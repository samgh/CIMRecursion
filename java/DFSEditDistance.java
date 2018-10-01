import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DFSEditDistance { 
    public static class State {
        private StringBuilder state;
        private Set<Character> chars;
        
        public State(String s) {
            this(s, new HashSet<Character>(Arrays.asList(new Character[]{
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'})));
        }
        
        public State(StringBuilder sb) {
            this(sb.toString());
        }
        
        public State(String s, Set<Character> chars) {
            this.state = new StringBuilder(s);
            this.chars = new HashSet<Character>(chars);
        }
        
        public List<State> adjacent() {
            List<State> results = new LinkedList<State>();
            for (int i = 0; i < state.length(); i++) {
                char curr = state.charAt(i);
                state.deleteCharAt(i);
                results.add(new State(state));
                state.insert(i, curr);
                for (Character c : chars) {
                    state.setCharAt(i, c);
                    results.add(new State(state));
                    state.setCharAt(i, curr);
                    state.insert(i, c);
                    results.add(new State(state));
                    state.deleteCharAt(i);
                }
            }
            
            return results;
        }
        
        public String toString() {
           return state.toString();
        }
        
        public boolean equals(Object o) {
            if (o instanceof State) {
                State s = (State) o;
                if (this.state.toString().equals(s.state.toString())) return true;
            }
            return false;
        }
        
        public int hashCode() {
            return this.state.toString().hashCode();
        }
    }
    
    public static List<State> editDistance(String s1, String s2) {
        List<List<State>> result = new LinkedList<List<State>>();
        editDistance(new State(s1), new State(s2), Math.max(s1.length(), s2.length()),
                     new HashSet<State>(), new LinkedList<State>(), result);
        return result.get(0);
    }
    
    private static void editDistance(State s1, State s2, int maxDepth, Set<State> visited,
                                     List<State> path, List<List<State>> result) {
        if (visited.contains(s1)) return;
            
        if (s1.equals(s2)) {
            if (result.size() == 0) result.add(new LinkedList<State>(path));
            else if (path.size() < result.get(0).size()) result.set(0, new LinkedList<State>(path));
            return;
        }
            
        if (maxDepth == path.size()) return;
        visited.add(s1);
        
        for (State s : s1.adjacent()) {
            path.add(s);
            editDistance(s, s2, maxDepth, visited, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(editDistance("abc", "cab"));
    }
}