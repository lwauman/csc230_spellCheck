public class DoublyLinkedNode<T>{
    //variables
    private T data;
    private DoublyLinkedNode previous;
    private DoublyLinkedNode next;
    
    //constructor
    public DoublyLinkedNode(T dataPortion){
        this(dataPortion, null, null);
    }
    
    //constuctor 
    public DoublyLinkedNode(T dataPortion, DoublyLinkedNode previousNode, DoublyLinkedNode nextNode){
        data = dataPortion;
        previous = previousNode;
        next = nextNode;
    }
    
    //returns data field
    public T getData(){
        return data;
    }
    
    //set data field
    public void setData(T newData){
        data = newData;
    }
    
    //return next field
    public DoublyLinkedNode getNextNode(){
        return next;
    }
    
    //return previous field
    public DoublyLinkedNode getPreviousNode(){
        return previous;
    }
    
    //set next field
    public void setNextNode(DoublyLinkedNode nextNode){
        next = nextNode;
    }
    
    //set previous field
    public void setPreviousNode(DoublyLinkedNode previousNode){
        previous = previousNode;
    }
}