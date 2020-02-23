public class Queue {
    static class Node{
        int val;
        Node next = null;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void push(int element){
        size++;
        if(rear != null){
            rear.next = new Node(element);
            rear = rear.next;
        }else{
            front = rear = new Node(element);
        }
    }

    public int pop(){
        int element = front.val;
        size--;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return element;
    }

    public int rear(){
        return rear.val;
    }
}
