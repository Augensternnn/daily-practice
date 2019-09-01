import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        queue.add(x);
    }
    public int pop(){
        // 处理前 size - 1 个数
        int size = queue.size();
        for(int i = 0; i < size - 1; i++){
            int v = queue.poll();
            queue.add(v);
        }
        return queue.poll();
    }
    public int top(){
        int size = queue.size();
        for(int i = 0; i < size - 1; i++){
            int v = queue.poll();
            queue.add(v);
        }
        int v = queue.poll();
        queue.add(v);
        return v;
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
