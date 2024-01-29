import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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

            while (scan.hasNext()){
                String identifier = scan.next();
                System.out.println(identifier);
            }
            scan.close();
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
