import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DFSCombinations {
    public static class State {
        private boolean[] state;
        
        public State(int n) {
            this.state = new boolean[n];
        }
        
        private State(boolean[] state) {
            this.state = state.clone();
        }
        
        public List<State> adjacent() {
            List<State> result = new LinkedList<State>();
            for (int i = 0; i < this.state.length; i++) {
                state[i] = !state[i];
                result.add(new State(state));
                state[i] = !state[i];
            }
            
            return result;
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < this.state.length; i++) {
                if (state[i]) sb.append(i + ",");
            }
            if (sb.length() > 1) sb.setLength(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }
        
        public boolean equals(Object o) {
            if (o instanceof State) {
                State s = (State) o;
                if (this.state.length != s.state.length) return false;
                for (int i = 0; i < this.state.length; i++) {
                    if (this.state[i] != s.state[i]) return false;
                }
                return true;
            }
            return false;
        }
        
        public int hashCode() {
            return Arrays.hashCode(this.state);
        }
    }
    
    public static List<State> combinations(int n) {
        Set<State> results = new HashSet<State>();
        combinations(new State(n), results);
        return new LinkedList<State>(results);
    }
    
    private static void combinations(State curr, Set<State> results) {
        if (results.contains(curr)) return;
        results.add(curr);
        for (State s : curr.adjacent()) {
            combinations(s, results);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(combinations(4));
    }
}