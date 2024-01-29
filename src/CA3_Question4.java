import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);

        scanner.useDelimiter(" ");

        Stack<String> elements = new Stack<>();

        while(scanner.hasNext()){
            String tag = scanner.next();

            if(!tag.startsWith("</")){
                elements.push(tag);
            } else {
                String openingTag =  "<" + tag.substring(2);
                if(elements.contains(openingTag)){
                    elements.pop();
//                    System.out.println(elements.pop());
                }
            }
        }
            if(elements.empty()){
                return true;
            } else {
                return false;
            }
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"src/tags_valid.txt", "src/tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
//        validate("src/tags_valid.txt");

    }
}
