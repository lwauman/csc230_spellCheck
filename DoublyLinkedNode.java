public class DoublyLinkedNode<T>{
    private T data;
    private DoublyLinkedNode previous;
    private DoublyLinkedNode next;
    
    public DoublyLinkedNode(T dataPortion){
        this(dataPortion, null, null);
    }
    public DoublyLinkedNode(T dataPortion, DoublyLinkedNode previousNode,
            DoublyLinkedNode nextNode){
        data = dataPortion;
        previous = previousNode;
        next = nextNode;
    }
    public T getData(){
        return data;
    }
    public void setData(T newData){
        data = newData;
    }
    public DoublyLinkedNode getNextNode(){
        return next;
    }
    public DoublyLinkedNode getPreviousNode(){
        return previous;
    }
    public void setNextNode(DoublyLinkedNode nextNode){
        next = nextNode;
    }
    public void setPreviousNode(DoublyLinkedNode previousNode){
        previous = previousNode;
    }
}