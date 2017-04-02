package Racurcia;

/** This program finds out the possible paths to go out of a
 * maze.
 * The input is the mouse position (remember that columns and
 * rows start at 0) and the maze pattern. The program uses
 * backtracking strategy.
 */
public class Maze
{
    private final static int MAX_ROW = 5;
    private final static int MAX_COLUMN = 5;
    private final static char OPEN = '-';
    private final static char WAY_OUT = 's';
 
    /**
     * Returns true if position is on the outline,
     * else – returns false.
     */
    private static boolean exit (int row, int col)
    {
        return (row==0) || (row==MAX_ROW-1) ||
        (col==0) || (col==MAX_COLUMN-1);
    }

    /**
     * Prints the maze (matrix) as it is.
     */
    public static void print (char [][] maze)
    {
        for (int i=0; i<MAX_ROW; i++)
        {
            for (int j=0; j<MAX_COLUMN; j++)
                System.out.print(maze[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }

    /** This is a recursive method that look for a path out of the
     * maze. The parameters are the maze and the current position
     * of the mouse.
     */
    public static void findWayOut (char [][] m, int row, int col)
    {
        // the temporary (local) array
        char [][] maze = new char [MAX_ROW][MAX_COLUMN];
        // copy the array given as a parameter to a local array.
        for (int i=0; i<MAX_ROW; i++)
            for (int j=0; j<MAX_COLUMN; j++)
                maze [i][j] = m[i][j];
        // mark the current position as a point on the path.
        maze[row][col] = WAY_OUT;
        // if the position of the mouse is on the outline of the
        // maze – print the temporary matrix that contains the path
        // out of the maze.
        if (exit (row, col))
        {
            print (maze);
        }
        else
        // the mouse is not at the exit of the maze seek for its
        // way out with four directions:
        {
            if (maze[row-1][col] == OPEN)
                findWayOut (maze, row-1, col);
            if (maze[row][col+1] == OPEN)
                findWayOut (maze, row, col+1);
            if (maze[row+1][col] == OPEN)
                findWayOut (maze, row+1, col);
            if (maze[row][col-1] == OPEN)
                findWayOut (maze, row, col-1);
        }
    } 
    
    public static void main(){
          char maze [][] =
              { {'#' , '#' , '#' , '#' , '#'},
                {'#' , '-' , '-' , '-' , '#'},
                {'#' , '-' , '#' , '-' , '#'},
                {'#' , '-' , '#' , '-' , '-'},
                {'#' , '#' , '#' , '#' , '#'}, } ;
                findWayOut(maze,1 ,1);
    }
}

