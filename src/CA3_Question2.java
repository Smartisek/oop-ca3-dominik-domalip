import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Dominik Domalip
 *  Class Group: GD2b
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        arr[0][1] = -1;
        arr[1][0] = -1;
        return arr;
    }

    // creating a class that behaves as a pair
    static class Cell{
        int x;
        int y;

        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
//        creating a stack of a cellPair with parameter cell class to be able to push coordinates into it
        Stack <Cell> cellPair = new Stack<Cell>();
//       pushing onto this stack a new cell r,c, parameter of a function that will be chosen once function called
        cellPair.push(new Cell(r, c));
        int count =1; // count for displaying the journey of the fill
//      while this stack is not empty do this
        while(!cellPair.empty()){
//            create a variable for popping a stack
            Cell current = cellPair.pop();
//            getting x and y of popped stack
            int x = current.getX();
            int y = current.getY();
//            incrementing count and assigning it to array
            arr[x][y] = count;
            count++;

            //check north if cell is 0
            if(x>0 && arr[x-1][y] == 0) {
                arr[x-1][y] = count; //set current position to current incrementation number of count
                cellPair.push(new Cell(x-1, y)); //push this cell onto the stack meaning stack is not empty and process of checking will continue
            }
            //check west if cell is 0
            if(y>0 && arr[x][y-1] == 0){
                arr[x][y-1] = count;
                cellPair.push(new Cell(x, y-1));
            }
            //check south if cell is 0
            if(x < 9 && arr[x+1][y] == 0){
                arr[x+1][y] = count;
                cellPair.push(new Cell(x+1, y));
            }
            //check east if cell is 0
            if(y<9 && arr[x][y+1] == 0){
                arr[x][y+1] = count;
                cellPair.push(new Cell(x, y+1));
            }

        }
    }

    public static void start()
    {
        int[][] arr = floodFillStart(); //initialize the array
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose x position: ");
        int x = sc.nextInt();
        System.out.println("Choose y position: ");
        int y = sc.nextInt();
        //start floodFill algorithm
        fill(x,y, arr);

        display(arr);

    }
    public static void main(String[] args) {
        display(floodFillStart());
        System.out.println("\n" + "\n");
        start();
    }
}