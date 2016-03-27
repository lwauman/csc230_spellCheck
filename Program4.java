import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program4{
    public static void main(String[] args) {
        //variables
        Scanner kb = new Scanner(System.in);
        SpellChecker spellChecker = new SpellChecker();
        String dictionaryLocation, toCheck;
        File dictionary;
        PrintWriter printWriter = null;
        boolean stopLooping = false;
                
        //setting up dictionary
        while(!stopLooping){
            System.out.println("Please enter the location of the dictionary.");
            System.out.print("Example: C:\\user\\YourName\\Desktop\\dictionary.txt: ");
            dictionaryLocation = kb.nextLine();
            dictionary = new File(dictionaryLocation);
            //returns true if dictionary is set up properly false otherwise 
            stopLooping = spellChecker.setDictionary(dictionary);
            System.out.println("");
        }
        
        //checking entered words
        toCheck = "";
        //while user wants to continue
        while(!toCheck.equals("0")){
            System.out.print("Type a word you would like to spell check. "
                    + "Enter 0 when you're finished: ");
            toCheck = kb.nextLine();
            //if word isn't in dictionary and it isn't 0
            if(!spellChecker.checkSpelling(toCheck) && !toCheck.equals("0")){
                //sets up outputFile once
                while(printWriter==null){
                    try{
                        printWriter = new PrintWriter("Misspelled_Words.txt");
                    }catch(FileNotFoundException e){
                        printWriter = null;
                        System.out.println("Output File not found");
                    }
                }
                //write misspelled word to file
                printWriter.println(toCheck);   
            }
            //user wants to stop
            else if(toCheck.equals("0"))
                //if there was at least 1 misspelled word
                if(printWriter != null){
                    printWriter.close();
                    System.out.println("A file called \"Misspelled_Words\""
                            + " has been created in the folder that this program"
                            + " was ran from. Misspelled_Words contains all the words that"
                            + " were entered that are misspelled.");
                }
                //all words entered were correctly spelled or 0 was the first thing entered
                else
                    System.out.println("No misspelled words were entered.");     
        }    
    }
}