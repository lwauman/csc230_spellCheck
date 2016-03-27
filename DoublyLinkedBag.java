public class DoublyLinkedBag<T> implements BagInterface<T>{
    //variables
    private DoublyLinkedNode firstNode;
    private int numberOfEntries;
    
    //constructor
    public DoublyLinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }
    
    //return numberOfEntries
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }
    
    //returns true or false depending if any nodes have been created
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    //adds a node to the bag
    @Override
    public boolean add(T newEntry){
        DoublyLinkedNode currentNode = firstNode;
        DoublyLinkedNode newNode = new DoublyLinkedNode(newEntry);
        
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        if(numberOfEntries > 1){
            currentNode.setPreviousNode(firstNode);
        }
        return true;
    }
    
    //removes firstNode from the bag (if it exists) and sets the next node to firstNode
    @Override
    public T remove() {
        T result = null;
        
        if(firstNode != null){
            result = (T)firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }
    
    //finds the node that contains anEntry (if it exists)
    private DoublyLinkedNode getReferenceTo(T anEntry){
        boolean found = false;
        DoublyLinkedNode currentNode = firstNode;
        
        while(found != true && currentNode!=null){
            if(currentNode.getData().equals(anEntry))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    //removes the first node that contains anEntry (if it exists)
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        DoublyLinkedNode nodeN = getReferenceTo(anEntry);
        
        if(nodeN != null){
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    //deletes all the nodes
    @Override
    public void clear() {
        while(!isEmpty())
            remove();
    }

    //returns the number of nodes that contain anEntry in their data field
    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int index = 0;
        DoublyLinkedNode currentNode = firstNode;
        
        while(index<numberOfEntries){
            if(currentNode.getData().equals(anEntry))
                frequency++;
            index++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;    
    }

    //returns true or false if any node contains anEntry in its data field
    @Override
    public boolean contains(T anEntry) {
        int index = 0;
        DoublyLinkedNode currentNode = firstNode;
        
        while(index<numberOfEntries){
            if(currentNode.getData().equals(anEntry))
                return true;
            index++;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    //represents all the nodes as an array
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        DoublyLinkedNode currentNode = firstNode;
        
        while(index<numberOfEntries && currentNode != null){
            result[index] = (T)currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }
}