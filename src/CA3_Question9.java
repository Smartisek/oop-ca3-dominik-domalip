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
    public void solve(int x, int y, DIRECTION dir)
    {
        Stack<DIRECTION> directions = new Stack<>();

    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 1, 0, 0, 1}, {-99, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        display(image);
    }

}