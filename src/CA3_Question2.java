import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

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
        Stack <Cell> cellPair = new Stack<Cell>();
        cellPair.push(new Cell(r, c));
        int count =1;

        while(!cellPair.empty()){
            Cell current = cellPair.pop();
            int x = current.getX();
            int y = current.getY();
            arr[x][y] = count;
            count++;
//check if it has already been filled
            //check north
            if(x>0 && arr[x-1][y] == 0) {
                arr[x-1][y] = count;
                cellPair.push(new Cell(x-1, y));
            }
            //check west
            if(y>0 && arr[x][y-1] == 0){
                arr[x][y-1] = count;
                cellPair.push(new Cell(x, y-1));
            }
            //check south
            if(x < 9 && arr[x+1][y] == 0){
                arr[x+1][y] = count;
                cellPair.push(new Cell(x+1, y));
            }
            //check east
            if(y<9 && arr[x][y+1] == 0){
                arr[x][y+1] = count;
                cellPair.push(new Cell(x, y+1));
            }

        }
    }

    public static void start()
    {
        int[][] arr = floodFillStart();
        fill(2,5, arr);

        display(arr);

    }
    public static void main(String[] args) {
        display(floodFillStart());
        System.out.println("\n" + "\n");
        start();
    }
}