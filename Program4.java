
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program4{
    public static void main(String[] args) {
        //variables
        Scanner kb = new Scanner(System.in);
        SpellChecker spellChecker = new SpellChecker();
        String dictonaryLocation=null, toCheck, outputFileLocation;
        File dictionary, outputFile = null;
        PrintWriter printWriter=null;
        boolean stopLooping = false;
                
        //setting up dictionary
        while(!stopLooping){
            System.out.println("Example: C:\\user\\Sam\\Desktop\\correctWords.txt");
            System.out.print("Please enter the location of the dictionary: ");
            dictonaryLocation = kb.nextLine();
            dictionary = new File(dictonaryLocation);
            stopLooping = spellChecker.setDictionary(dictionary);
            System.out.println("");
        }
        
        //checking entered words
        toCheck = "";
        while(!toCheck.equals("0")){
            System.out.print("Type a word you would like to spell check. Enter 0 when you're finished: ");
            toCheck = kb.nextLine();
            //if word isn't in dictionary and it isn't 0
            if(!spellChecker.checkSpelling(toCheck) && !toCheck.equals("0")){
                //sets up outputFile once
                while(outputFile==null){
                    setUpFile();
                    outputFileLocation = kb.nextLine();
                    //avoid overwriting dictionary
                    while(outputFileLocation.equals(dictonaryLocation)){
                        System.out.println("Invalid Entry\n");
                        setUpFile();
                        outputFileLocation = kb.nextLine();
                    }
                    outputFile = new File(outputFileLocation);
                    try{
                        printWriter = new PrintWriter(outputFile);
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Output file not found");
                        outputFile=null;
                    }
                }
                printWriter.println(toCheck);
            }
            else if(toCheck.equals("0"))
                if(printWriter != null)
                    printWriter.close();
        }
        if(outputFile == null)
            System.out.println("All words that were entered were spelled correctly.");
    }
    private static void setUpFile(){
        System.out.println("\nPlease enter the location where you would like"
            + " the output file to be created: ");
        System.out.print("Example: C:\\user\\Sam\\Desktop\\outputFile.txt): ");
    }
}