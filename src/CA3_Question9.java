import java.util.Stack;
// I had no idea how to start on this with the enums and i had some help from my friend who already works with java 

/**
 *  Name: Dominik Domalip
 *  Class Group:  GD2b
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {
//    giving each direction the coordinates x, y that point that direction
    NORTH (-1,0),
    SOUTH (1, 0),
    EAST (0, 1),
    WEST (0, -1);
    private final int dx;
    private final int dy;
// Constructor for the enums direction in cell x, y
    DIRECTION(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
// getters for x and y
    public int getX(){return dx;}
    public int getY(){return dy;}
}

public class CA3_Question9
{
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public static boolean solve(int x, int y, int [][] arr,Stack<CA3_Question2.Cell> path)
    {
//        Create a cell with starting point and push it into the stack
        CA3_Question2.Cell start = new CA3_Question2.Cell(x, y);
        path.push(start);
//      if statement for checking if cell(x,y) is withing the bounds of the grid otherwise we'd be checking non-existing grid
        if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length){
            return false;
        }
//      when the cell is 7 we found the exit and push this last cell onto a stack
        if(arr[x][y] == 7){
            path.push((new CA3_Question2.Cell(x,y)));
            return true;
        }
//      if cell is not zero which in this example 0 represent a possible path, then return false
        if(arr[x][y] != 0){
            return false;
        }
//      visited cell turn into -1 when already visited
        arr[x][y] = -1;

//      for each loop that iterates over each direction in DIRECTION enum and direction.values returns its constant x y
        for(DIRECTION direction : DIRECTION.values()){
//           make a new x and y by adding current direction to it
            int newX = x + direction.getX();
            int newY = y + direction.getY();
//            then do recursion and add new x and y into parameter and check until it is true or false
            if(solve(newX, newY, arr, path)){
                return true;
            }
        }

//        if not found return false and pop
        path.pop();
        return false;
    }

    public static void main(String[] args) {
        Stack<CA3_Question2.Cell> path = new Stack<>();
        int[][] image = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 7, 1, 1}
        };
        display(image);

//      it works well when i start at this cell it goes straight down, but if i were to start one point left or right it would visit all the 0 cells and print out the path while going all possible ways
//        I tried to fix this with adding another stack just for successful path but that did not work for me
//      if solve method is true
        if(solve(1, 2, image, path)){
            System.out.println("Path found buttom up: ");
//            while stack is not empty print each cell representing the path to the exit
            while(!path.isEmpty()){
                CA3_Question2.Cell cell = path.pop();
                System.out.println("( " + cell.getX() + ", " + cell.getY() + ")");
            }

//            else it is false and no exit was found
        } else {
            System.out.println("No path was found");
        }
        display(image);
    }
}