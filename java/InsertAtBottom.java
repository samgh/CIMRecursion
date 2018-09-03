import java.util.Stack;

public class InsertAtBottom {
    public static void insertAtBottomIterative(Stack<Integer> s, int i) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!s.isEmpty()) temp.push(s.pop());
        s.push(i);
        while (!temp.isEmpty()) s.push(temp.pop());
    }
    
    public static void insertAtBottomRecursive(Stack<Integer> s, int i) {
        if (s.isEmpty()) {
            s.push(i);
            return;
        }
        
        int top = s.pop();
        insertAtBottomRecursive(s, i);
        s.push(top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        insertAtBottomRecursive(s, 5);
        System.out.println(s);
    }
}