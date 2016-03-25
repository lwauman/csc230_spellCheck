import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker{
    private BagInterface<String> correctWords;
    
    public SpellChecker(){
        correctWords = new DoublyLinkedBag<>();
    }
    
    public boolean setDictionary(File correctWordFile){
        try{
            Scanner reader = new Scanner(correctWordFile);
            System.out.println("File found.");
            while(reader.hasNext()){
                correctWords.add(reader.nextLine().toLowerCase());
            }
            return true;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            return false;
        }
    }
    
    public boolean checkSpelling(String word){
        if(correctWords.contains(word.toLowerCase()))
            return true;
        else
            return false;
    }
    
    public int count(){
        return correctWords.getCurrentSize();
    }
}