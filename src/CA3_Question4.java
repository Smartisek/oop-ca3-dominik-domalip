import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */
public class CA3_Question4 {

    /*
        filename: tags_valid.txt, tags_invalid.txt
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        FileReader fileReader = new FileReader(filename); //creating a reader that reads a file
        Scanner scanner = new Scanner(fileReader); //scanner for file reader

        scanner.useDelimiter(" "); // delimiter whenever there is a space then cut

        Stack<String> elements = new Stack<>(); //initialization of a stack where the tags will be passed to

        while(scanner.hasNext()){  //while there is content in the file do this
            String tag = scanner.next(); //string variable for reading tags
//          if tag does not start with </ meaning it is not a closing tag then push tag into our elements stack
            if(!tag.startsWith("</")){
                elements.push(tag);
//          else, meaning it is a closing tag containing </
            } else {
//          variable string that starts with < + string after index 2, position 2
                String openingTag =  "<" + tag.substring(2);
//                if our openingTag variable is contained in elements stack that means it has a pair, we pop it from the stack
                if(elements.contains(openingTag)){
                    elements.pop();
//                    System.out.println(elements.pop());
//                    I used this to see how tags are added to stack one by one and if when there was a closing tag
//                    in the next sout line the pair was removed until there was an empty stack, for invalid there were tags without pair left
//                    only work when function called with single file
                }
            }
        }
//        return statement that returns true when elements stack is empty which means there were only pairs so file is valid
//        if otherwise elements stack has anything in it left then there is a tag that doesn't have closing one
//        it is shorter logic, it could be if(elements.empty()) return true, else return false
        return elements.empty();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        array with file names
        String[] files = {"src/tags_valid.txt", "src/tags_invalid.txt"};
//        for loop that loops through files and passes them into validate function
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }


    }
}
