import java.util.*;

// Node class represents a state in the BFS search tree
class Node implements Comparable<Node>
{
    int city;                // Current city the salesman is at
    int cost;                // Total cost so far to reach this city
    List<Integer> path;     // Path taken to reach this city

    Node(int city, int cost, List<Integer> path)
    {
        this.city = city;
        this.cost = cost;
        this.path = path;
    }

    // This method is used for PriorityQueue to sort nodes by cost (min-heap)
    @Override
    public int compareTo(Node other) 
    {
        return this.cost - other.cost; // lower cost = higher priority
    }
}

public class SimpleTSP_BFS 
{

    // Representing the cost/distance between cities
    static final int INF = 999; // A large number to represent 'no direct path' or self-loops
    static int[][] graph = 
    {
        {INF, 10, 15, 20},
        {10, INF, 35, 25},
        {15, 35, INF, 30},
        {20, 25, 30, INF}
    };

    static int numCities = graph.length; // Total number of cities

    public static void main(String[] args) 
    {

        // PriorityQueue to always expand the path with the lowest cost first
        PriorityQueue<Node> queue = new PriorityQueue<>();

        // Start from city 0, cost is 0, path starts with city 0
        queue.add(new Node(0, 0, Arrays.asList(0)));

        int minCost = Integer.MAX_VALUE;       // To store the minimum cost found
        List<Integer> bestPath = new ArrayList<>(); // To store the best path found

        // BFS traversal using priority queue (best-first search)
        while (!queue.isEmpty()) 
        {
            Node current = queue.poll(); // Take the path with the lowest cost so far

            // If all cities are visited, return to starting city (0)
            if (current.path.size() == numCities)
            {
                int totalCost = current.cost + graph[current.city][0]; // Add return cost to start
                if (totalCost < minCost)
                {
                    minCost = totalCost;                  // Update best cost
                    bestPath = new ArrayList<>(current.path); 
                    bestPath.add(0);                      // Add return to start city in path
                }
            } 
            else
            {
                // Try visiting unvisited cities
                for (int nextCity = 0; nextCity < numCities; nextCity++) 
                {
                    if (!current.path.contains(nextCity)) 
                    { // If next city not already visited

                        int nextCost = current.cost + graph[current.city][nextCity];            // Update cost
                        List<Integer> newPath = new ArrayList<>(current.path);                   // Copy current path
                        newPath.add(nextCity);                                              // Add next city to path
                        queue.add(new Node(nextCity, nextCost, newPath));                   // Add to queue

                    }
                }
            }
        }

        // Output final best path and cost
        System.out.println("🚀 Best Path using BFS (TSP): " + bestPath);
        System.out.println("💰 Minimum Cost: " + minCost);
    }
}

