/**
 *  Name:
 *  Class Group:
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

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

    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 0, 1}, {-99, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        display(image);
    }

}