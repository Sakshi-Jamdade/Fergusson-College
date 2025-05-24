import java.util.*;

public class SimpleHillClimbing8Puzzle {

    static int[][] goal = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    static class State {
        int[][] puzzle;
        int cost;
        int x, y;

        State(int[][] puzzle) {
            this.puzzle = new int[3][3];
            for (int i = 0; i < 3; i++)
                this.puzzle[i] = puzzle[i].clone();

            this.cost = heuristic();
            findBlank();
        }

        void findBlank() {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (puzzle[i][j] == 0) {
                        x = i;
                        y = j;
                    }
        }

        int heuristic() {
            int h = 0;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (puzzle[i][j] != 0 && puzzle[i][j] != goal[i][j])
                        h++;
            return h;
        }

        List<State> neighbors() {
            List<State> list = new ArrayList<>();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d], newY = y + dy[d];
                if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
                    int[][] newPuzzle = new int[3][3];
                    for (int i = 0; i < 3; i++)
                        newPuzzle[i] = puzzle[i].clone();

                    newPuzzle[x][y] = newPuzzle[newX][newY];
                    newPuzzle[newX][newY] = 0;
                    list.add(new State(newPuzzle));
                }
            }
            return list;
        }

        void print() {
            for (int[] row : puzzle) {
                for (int num : row)
                    System.out.print(num + " ");
                System.out.println();
            }
            System.out.println("Heuristic: " + cost + "\n");
        }

        boolean isGoal() {
            return cost == 0;
        }
    }

    public static void main(String[] args) {
        int[][] start = {
            {1, 2, 3},
            {5, 6, 0},
            {7, 8, 4}
        };

        State current = new State(start);
        current.print();

        while (true) {
            List<State> nextStates = current.neighbors();
            State best = current;

            for (State next : nextStates) {
                if (next.cost < best.cost)
                    best = next;
            }

            if (best.cost >= current.cost) {
                System.out.println("Stopped at local minimum.");
                break;
            }

            current = best;
            current.print();

            if (current.isGoal()) {
                System.out.println("🎯 Goal reached!");
                break;
            }
        }
    }
}


// PS C:\Users\Supriya\Desktop\FS+AL EXAM> java SimpleHillClimbing8Puzzle        
// 1 2 3 
// 5 6 0 
// 7 8 4 
// Heuristic: 3

// 1 2 3 
// 5 0 6 
// 7 8 4 
// Heuristic: 2

// 1 2 3
// 0 5 6
// 7 8 4
// Heuristic: 1

// Heuristic: 2

// 1 2 3
// 0 5 6
// 7 8 4
// Heuristic: 1

// Stopped at local minimum.
// PS C:\Users\Supriya\Desktop\FS+AL EXAM>
