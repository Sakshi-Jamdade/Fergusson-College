import java.util.*;

class State {
    int leftM, leftC;
    boolean boatOnLeft;
    State previous;

    State(int m, int c, boolean boat, State prev) {
        leftM = m;
        leftC = c;
        boatOnLeft = boat;
        previous = prev;
    }

    boolean isGoal() {
        return leftM == 0 && leftC == 0 && !boatOnLeft;
    }

    boolean isValid() {
        int rightM = 3 - leftM;
        int rightC = 3 - leftC;

        return leftM >= 0 && leftC >= 0 && rightM >= 0 && rightC >= 0 &&
               (leftM == 0 || leftM >= leftC) &&
               (rightM == 0 || rightM >= rightC);
    }

    List<State> getNextStates() {
        List<State> next = new ArrayList<>();
        int[][] moves = {{1,0}, {2,0}, {0,1}, {0,2}, {1,1}};

        for (int[] move : moves) {
            int m = move[0], c = move[1];
            State newState;

            if (boatOnLeft)
                newState = new State(leftM - m, leftC - c, false, this);
            else
                newState = new State(leftM + m, leftC + c, true, this);

            if (newState.isValid())
                next.add(newState);
        }
        return next;
    }

    void printPath() {
        if (previous != null) previous.printPath();
        System.out.println(
            "Left Bank -> M: " + leftM + " C: " + leftC +
            " | Boat: " + (boatOnLeft ? "Left" : "Right")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof State)) return false;
        State s = (State) o;
        return leftM == s.leftM && leftC == s.leftC && boatOnLeft == s.boatOnLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftM, leftC, boatOnLeft);
    }
}

public class MissionariesBFS {
    public static void main(String[] args) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State start = new State(3, 3, true, null);
        queue.offer(start);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.isGoal()) {
                System.out.println("🎯 Solution found:\n");
                current.printPath();
                return;
            }

            if (visited.contains(current)) continue;
            visited.add(current);

            for (State next : current.getNextStates()) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
        }

        System.out.println("❌ No solution found.");
    }
}


// PS C:\Users\Supriya\Desktop\FS+AL EXAM> java MissionariesDFS        
// ? Solution:
// Left -> M: 3 C: 3 | Boat: Left
// Left -> M: 2 C: 2 | Boat: Right
// Left -> M: 3 C: 2 | Boat: Left
// Left -> M: 3 C: 0 | Boat: Right
// Left -> M: 3 C: 1 | Boat: Left
// Left -> M: 1 C: 1 | Boat: Right
// Left -> M: 2 C: 2 | Boat: Left
// Left -> M: 0 C: 2 | Boat: Right
// Left -> M: 0 C: 3 | Boat: Left
// Left -> M: 0 C: 1 | Boat: Right
// Left -> M: 0 C: 2 | Boat: Left
// Left -> M: 0 C: 0 | Boat: Right