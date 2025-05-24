import java.util.*;

public class WaterJugBFS 
{
    static int a, b, goal;

    static void bfs() 
    {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (visited.contains(x + "," + y))
                continue;

            visited.add(x + "," + y);
            System.out.println("A: " + x + ", B: " + y);

            if ((a > b && x == goal) || (b > a && y == goal)) 
            {
                System.out.println("🎯 Goal reached!");
                return;
            }

            // All possible next moves
            int[][] nextStates = {
                {a, y},         // Fill A
                {x, b},         // Fill B
                {0, y},         // Empty A
                {x, 0},         // Empty B
                {Math.min(a, x + y), y - (Math.min(a, x + y) - x)}, // B → A
                {x - (Math.min(b, x + y) - y), Math.min(b, x + y)}  // A → B
            };

            for (int[] state : nextStates)
                queue.offer(state);
        }

        System.out.println("❌ Goal not reachable.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Jug A capacity: ");
        a = sc.nextInt();
        System.out.print("Jug B capacity: ");
        b = sc.nextInt();
        System.out.print("Goal (only in bigger jug): ");
        goal = sc.nextInt();

        System.out.println("\nSteps:");
        bfs();
    }
}


// Jug A capacity: 5
// Jug B capacity: 4
// Goal (only in bigger jug): 2

// Steps:
// A: 0, B: 0
// A: 5, B: 0
// A: 0, B: 4
// A: 5, B: 4
// A: 1, B: 4
// A: 4, B: 0
// A: 1, B: 0
// A: 4, B: 4
// A: 0, B: 1
// A: 5, B: 3
// A: 5, B: 1
// A: 0, B: 3
// A: 2, B: 4
// ? Goal reached!










