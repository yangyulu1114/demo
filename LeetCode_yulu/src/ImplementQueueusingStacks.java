import java.util.Stack;

public class ImplementQueueusingStacks {
    class MyQueue {

        Stack<Integer> q = new Stack<>(), temp = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            q.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            for (; q.size() > 1;) {
                temp.push(q.pop());
            }
            int result = q.pop();
            for (; temp.size() > 0;) {
                q.push(temp.pop());
            }
            return result;
        }

        /** Get the front element. */
        public int peek() {
            for (; q.size() > 1; ) {
                temp.push(q.pop());
            }
            int result = q.peek();
            for (;temp.size() > 0;) {
                q.push(temp.pop());
            }
            return result;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return q.size() == 0;
        }
    }
}
