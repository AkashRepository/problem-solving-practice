
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class FrequencyStack {

    static class Pair<T, K> {
        T left;
        K right;

        public Pair(T t, K k){
            this.left = t;
            this.right = k;
        }
    }

    private PriorityQueue<Integer> queue;
    private Map<Integer, Pair<Integer, Stack<Integer>>> frequencyMap;
    private int counter = 0;

    public FrequencyStack() {
        this.frequencyMap = new HashMap<>();
        this.queue = new PriorityQueue<>((a, b) -> {
            Pair<Integer, Stack<Integer>> valueOfA = this.frequencyMap.getOrDefault(a, new Pair<>(0, new Stack<>()));
            Pair<Integer, Stack<Integer>> valueOfB = this.frequencyMap.getOrDefault(b, new Pair<>(0, new Stack<>()));
            if (valueOfA.left.equals(valueOfB.left)) {
                return valueOfB.right.peek().compareTo(valueOfA.right.peek());
            }
            return valueOfB.left.compareTo(valueOfA.left);
        });

    }

    public void push(int x) {
        counter++;
        Pair<Integer, Stack<Integer>> frequency = this.frequencyMap.getOrDefault(x, new Pair<>(0, new Stack<>()));
        frequency.left = frequency.left + 1;
        frequency.right.push(counter);
        frequencyMap.put(x, frequency);
        if(frequency.left == 1)
            queue.offer(x);
        else {
            queue.remove(x);
            queue.offer(x);
        }
    }

    public int pop() {
        Integer top = queue.poll();
        Pair<Integer, Stack<Integer>> frequency = this.frequencyMap.get(top);
        frequency.left = frequency.left - 1;
        frequency.right.pop();
        if(frequency.left<=0){
            this.frequencyMap.remove(top);
        } else {
            frequencyMap.put(top, frequency);
            queue.offer(top);
        }
        System.out.println("poll : "+top);
        return top;
    }

    public void top(){
        System.out.println("Top is :"+ queue.peek());
    }

    public static void main(String[] args) {
        FrequencyStack o = new FrequencyStack();
        o.push(5);
        o.top();
        o.push(7);
        o.top();
        o.push(5);
        o.top();
        o.push(7);
        o.top();
        o.push(4);
        o.top();
        o.push(5);
        o.top();
        o.pop();
        o.pop();
        o.pop();
        o.pop();
    }
}

