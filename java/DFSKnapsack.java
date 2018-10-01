public class DFSKnapsack {
////    private Item[] items;
//    private int maxWeight;
//    
//    public static class State {
//        private boolean[] state;
//        private int currentWeight;
//        private int currentValue;
//        
//        public State(int n) {
//            this.state = new boolean[n];
//            this.currentWeight = 0;
//            this.currentValue = 0;
//        }
//        
//        public List<State> adjacent() {
//            List<State> result = new LinkedList<State>();
//            for (int i = 0; i < this.state.length; i++) {
//                if (state[i]) {
//                    state[i] = !state[i];
//                    currentWeight -= items[i].weight;
//                    currentValue -= items[i].value;
//                    result.add(new State(state));
//                    state[i] = !state[i];
//                    currentWeight += items[i].weight;
//                    currentValue += items[i].value;
//                } else if (items[i].weight + currentWeight < maxWeight) {
//                    state[i] = !state[i];
//                    currentWeight += items[i].weight;
//                    currentValue += items[i].value;
//                    result.add(new State(state));
//                    state[i] = !state[i];
//                    currentWeight -= items[i].weight;
//                    currentValue -= items[i].value;
//                }
//            }
//            
//            return result;
//        }
//    }
}