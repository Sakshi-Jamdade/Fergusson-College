import java.util.*;

class PuzzleNode {
    int[][] state;
    int x, y;               // Coordinates of the blank tile (0)
    int cost;               // Cost to reach this state
    int level;              // Depth in the search tree
    PuzzleNode parent;      // Parent node
    int movedNumber;        // Number that was moved to reach this state
    String moveDirection;   // Direction of the move (top, bottom, left, right)

    public PuzzleNode(int[][] state, int x, int y, int newX, int newY, int level, PuzzleNode parent, int movedNumber, String moveDirection) 
    {
        this.state = new int[3][3];
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                this.state[i][j] = state[i][j];
            }
        }
        // Swap the blank tile with the new tile
        this.movedNumber = this.state[newX][newY]; // Store the number that was moved
        this.state[x][y] = this.state[newX][newY];
        this.state[newX][newY] = 0;
        this.x = newX;
        this.y = newY;
        this.level = level;
        this.parent = parent;
        this.cost = Integer.MAX_VALUE;
        this.moveDirection = moveDirection; // Store the direction of the move
    }
}

public class EightPuzzle 
{
    private static final int[][] GOAL_STATE = 
    {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    private static final int[] ROW = {0, 0, -1, 1}; // Row movements (left, right, top, bottom)
    private static final int[] COL = {-1, 1, 0, 0}; // Column movements (left, right, top, bottom)
    private static final String[] DIRECTION = {"RIGHT", "LEFT", "BOTTOM", "TOP"}; // Directions for moves (reversed logic)

    private static boolean isSafe(int x, int y) 
    {
        return (x >= 0 && x < 3 && y >= 0 && y < 3);
    }

    private static int calculateCost(int[][] initialState, int[][] goalState) 
    {
        int count = 0;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (initialState[i][j] != 0 && initialState[i][j] != goalState[i][j]) 
                {
                    count++;
                }
            }
        }
        return count;
    }

    private static void printPath(PuzzleNode root) 
    {
        if (root == null) 
        {
            return;
        }
        printPath(root.parent);
        if (root.level > 0) 
        {
            System.out.println("Step " + root.level + ": Moved " + root.movedNumber + " to the " + root.moveDirection);
            printState(root.state);
            System.out.println();
        }
    }

    private static void printState(int[][] state) 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(int[][] initialState, int x, int y) 
    {
        PriorityQueue<PuzzleNode> openList = new PriorityQueue<>(Comparator.comparingInt(a -> (a.cost + a.level)));
        PuzzleNode root = new PuzzleNode(initialState, x, y, x, y, 0, null, 0, "START");
        root.cost = calculateCost(initialState, GOAL_STATE);
        openList.add(root);

        while (!openList.isEmpty()) 
        {
            PuzzleNode min = openList.poll();

            if (min.cost == 0) 
            {
                System.out.println("Solution Found!");
                printPath(min);
                return;
            }

            for (int i = 0; i < 4; i++)
            {
                if (isSafe(min.x + ROW[i], min.y + COL[i])) 
                {
                    PuzzleNode child = new PuzzleNode(min.state, min.x, min.y, min.x + ROW[i], min.y + COL[i], min.level + 1, min, min.state[min.x + ROW[i]][min.y + COL[i]], DIRECTION[i]);
                    child.cost = calculateCost(child.state, GOAL_STATE);
                    openList.add(child);
                }
            }
        }
        System.out.println("No solution exists for the given initial state.");
    }

    public static void main(String[] args) 
    {
        int[][] initialState = 
        {
            {1, 2, 3},
            {5, 6, 0},
            {7, 8, 4}
        };

        int x = 1, y = 2; // Coordinates of the blank tile (0)

        System.out.println("Initial State:");
        printState(initialState);
        System.out.println();

        System.out.println("Goal State:");
        printState(GOAL_STATE);
        System.out.println();

        solve(initialState, x, y);
    }
}