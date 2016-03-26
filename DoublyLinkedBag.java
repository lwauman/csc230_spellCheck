public class DoublyLinkedBag<T> implements BagInterface<T>{
    private DoublyLinkedNode firstNode;
    private int numberOfEntries;
    
    public DoublyLinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }
    
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

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

    @Override
    public void clear() {
        while(!isEmpty())
            remove();
    }

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