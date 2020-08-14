import java.util.LinkedList;
import java.util.Queue;

class MovingAverage{
    double mSum = 0;
    Queue<Integer> queue;
    int mSize = 0;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        mSize = size;
    }

    public double next(int val) {
        queue.add(val);
        mSum += val;
        if (queue.size() > mSize) {
            mSum -= queue.poll();
        }
        return mSum / queue.size();
    }
}
