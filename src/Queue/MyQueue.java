package Queue;

public interface MyQueue {

    boolean offer(Object e);
    Object  poll();
    Object  peek();
    boolean empty();
    int     size();
    String  toString();
}
