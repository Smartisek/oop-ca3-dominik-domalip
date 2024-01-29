import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question3
{
    public static void readFile(String fileName)
    {
        try {
            FileReader reader = new FileReader(fileName);

            Scanner scan = new Scanner(reader);

            scan.useDelimiter(("[^A-Za-z0-9_]+"));

            Map<String, List<Integer>> identifiersContainer = new HashMap<>();

            int lineNumber = 1;

            while (scan.hasNextLine()){
                String line = scan.nextLine();
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(("[^A-Za-z0-9_]+"));

                while(lineScan.hasNext()){
                    String identifier = lineScan.next();
                    if(!identifiersContainer.containsKey(identifier)){
                        identifiersContainer.put(identifier, new ArrayList<>());
                    }
                    identifiersContainer.get(identifier).add(lineNumber);
                }
                lineNumber++;
            }
                for(Map.Entry<String, List<Integer>> entry : identifiersContainer.entrySet()){
                    System.out.println("Identifier: " + entry.getKey() + ", " + "Line: " + entry.getValue());
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
