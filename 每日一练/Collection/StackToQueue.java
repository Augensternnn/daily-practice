package test1110;

import java.util.Stack;

/**
 * 用两个栈来实现队列，完成队列的 Push 和 pop 操作。
 * 队列中的元素类型为 int 类型
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }
    /*
    public int pop(){
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("Queue is empty!")
        }
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
     */
}
