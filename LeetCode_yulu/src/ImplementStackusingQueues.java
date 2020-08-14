import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    class MyStack {

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            for (;q.size() > 1;) {
                temp.add(q.poll());
            }
            Queue<Integer> c = temp;
            temp = q;
            q = c;
            return temp.poll();
        }

        /** Get the top element. */
        public int top() {
            for (; q.size() > 1;) {
                temp.add(q.poll());
            }
            int top = q.poll();
            temp.add(top);
            Queue<Integer> c = temp;
            temp = q;
            q = c;
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.size() == 0;
        }
    }


}
