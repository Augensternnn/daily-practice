import java.util.Stack;
public class QueueWithStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int x){
        if(stack2.empty()){
            stack1.push(x);
        }else{
            for(int i = 0;i < stack2.size() - 1; i++){
                int v = stack2.pop();
                stack1.push(v);
            }
            stack1.push(x);
        }
    }
    public int pop(){
        if(stack2.empty()){
            while(!stack1.empty()){
                int v = stack1.pop();
                stack2.push(v);
            }
            return stack2.pop();
        }else{

        }
    }
    public int peek(){

    }
    public boolean empty(){

    }
}
