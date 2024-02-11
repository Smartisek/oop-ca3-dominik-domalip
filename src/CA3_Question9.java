import java.util.Stack;


/**
 *  Name: Dominik Domalip
 *  Class Group:  GD2b
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {
    NORTH (-1,0),
    SOUTH (1, 0),
    EAST (0, 1),
    WEST (0, -1);
    private final int dx;
    private final int dy;

    DIRECTION(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

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
        CA3_Question2.Cell start = new CA3_Question2.Cell(x, y);
        path.push(start);

        if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length){
            return false;
        }

        if(arr[x][y] == 7){
            path.push((new CA3_Question2.Cell(x,y)));
            return true;
        }

        if(arr[x][y] != 0){
            return false;
        }

        arr[x][y] = -1;


        for(DIRECTION direction : DIRECTION.values()){
            int newX = x + direction.getX();
            int newY = y + direction.getY();
            if(solve(newX, newY, arr, path)){
                return true;
            }
        }
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


        if(solve(3, 1, image, path)){
            System.out.println("Path found buttom up: ");
            while(!path.isEmpty()){
                CA3_Question2.Cell cell = path.pop();
                System.out.println("( " + cell.getX() + ", " + cell.getY() + ")");
            }
        } else {
            System.out.println("No path was found");
        }
        display(image);
    }
}