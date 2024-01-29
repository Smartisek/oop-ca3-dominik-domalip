import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */

// Resources: https://www.youtube.com/watch?v=3RSXHVyzdmg [Nathan S], YouTube video for understanding what delimiter does
// Using my last project activity tracker for reading a file

public class CA3_Question3
{
    public static void readFile(String fileName)
    {
//        Try/Catch block of code for reading the file etc., if anything in the try block goes wrong, throws an error, the code skip to catch and executes that code
        try {
            FileReader reader = new FileReader(fileName); //creating a new file reader

            Scanner scan = new Scanner(reader); //Scanner that scans everything in the reader
//          Delimiter splits our strings, anything that is not capital a through Za and lower case z, 0-9 and + at least one or more
//            basically anything that is not a letter or number is where the scanner is going split into identifier
//            this delimiter probably wouldn't have to be included since we are just separating lines here
            scan.useDelimiter(("[^A-Za-z0-9_]+"));
//          creating a map where it's key is a string and a value is a list of intergers
            Map<String, List<Integer>> identifiersContainer = new HashMap<>();
//          int variable to keep track of a current line starting with 1
            int lineNumber = 1;
//          While our reader scanner has next line
            while (scan.hasNextLine()){
                String line = scan.nextLine();  //putting line into a string
                Scanner lineScan = new Scanner(line); //creating a scanner for what is included in current line
                lineScan.useDelimiter(("[^A-Za-z0-9_]+")); //same delimiter for splitting when character is not a letter, number or _
//             another while inside the first one for the line content, while scanner for line has next
                while(lineScan.hasNext()){
                    String identifier = lineScan.next(); //put into a string variable scanned in the line when looking for next in the line
//                    if our map does not contain the word that has been scanned (identifier) then add this identifier into the map as a key and create an array list for lines as a value
                    if(!identifiersContainer.containsKey(identifier)){
                        identifiersContainer.put(identifier, new ArrayList<>());
                    }
//                    add a pair (value to key) to identifier which is the line number it is on, which is our array of lines where this identifier appeared
                    identifiersContainer.get(identifier).add(lineNumber);
                }
                lineNumber++; //increment lineNumber after each loop
            }
//            for loop for displaying the data, identifying type we are looping through which is map with par of string and list of integers
//            loop through each set in the identifiersContainer which is our initial map
                for(Map.Entry<String, List<Integer>> entry : identifiersContainer.entrySet()){
//                    printing out the data, first identifier which in the map pair is first as a key and then the array with lines which is value of the pair map
                    System.out.println("Identifier: " + entry.getKey() + ", " + "Line: " + entry.getValue());
                }

        } catch (IOException e) { //an exception if anything goes wrong inside try block
            throw new RuntimeException(e);
//            System.out.println("Something went wrong");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
