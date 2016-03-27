import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker{
    //variable
    private BagInterface<String> correctWords;
    
    //constructor. sets correctWords to an empty bag of strings
    public SpellChecker(){
        correctWords = new DoublyLinkedBag<>();
    }
    
    //takes a file of words and reads them into the bag as nodes
    public boolean setDictionary(File correctWordFile){
        try{
            Scanner reader = new Scanner(correctWordFile);
            System.out.println("File found.");
            while(reader.hasNext()){
                //replaceAll gets rid of spaces so that a word with a space before/after/within
                //it won't be considered misspelled
                correctWords.add(reader.nextLine().toLowerCase().replaceAll(" ", ""));
            }
            return true;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            return false;
        }
    }
    
    //takes a word and see if it is contained in any node's data field
    public boolean checkSpelling(String word){
        if(correctWords.contains(word.toLowerCase()))
            return true;
        else
            return false;
    }
    
    //returns the number of nodes in the bag
    public int count(){
        return correctWords.getCurrentSize();
    }
}