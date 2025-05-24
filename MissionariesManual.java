import java.util.Scanner;

public class MissionariesManual 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int ml = 3, cl = 3, mr = 0, cr = 0;
        int boat = 0; // 0 = left, 1 = right

        while (true) 
        {
            System.out.println("\nLeft -> M: " + ml + ", C: " + cl + " | Right -> M: " + mr + ", C: " + cr + " | Boat: " + (boat == 0 ? "Left" : "Right"));
            System.out.print("Enter missionaries to move: ");
            int m = sc.nextInt();
            System.out.print("Enter cannibals to move: ");
            int c = sc.nextInt();

            if (m + c > 2 || m + c == 0) {
                System.out.println("Invalid move! Boat can carry 1 or 2.");
                continue;
            }

            if (boat == 0) {
                if (m > ml || c > cl) {
                    System.out.println("Not enough people on the left!");
                    continue;
                }
                ml -= m;
                cl -= c;
                mr += m;
                cr += c;
                boat = 1;
            }
            else 
            {
                if (m > mr || c > cr) 
                {
                    System.out.println("Not enough people on the right!");
                    continue;
                }
                mr -= m;
                cr -= c;
                ml += m;
                cl += c;
                boat = 0;
            }

            if ((ml > 0 && ml < cl) || (mr > 0 && mr < cr)) 
            {
                System.out.println("Cannibals eat missionaries! Game over.");
                break;
            }

            if (ml == 0 && cl == 0) 
            {
                System.out.println("🎉 All missionaries and cannibals safely crossed!");
                break;
            }
        }
    }
}


// PS C:\Users\Supriya\Desktop\FS+AL EXAM> java MissionariesManual

// Left -> M: 3, C: 3 | Right -> M: 0, C: 0 | Boat: Left
// Enter missionaries to move: 0
// Enter cannibals to move: 2

// Left -> M: 3, C: 1 | Right -> M: 0, C: 2 | Boat: Right
// Enter missionaries to move: 0
// Enter cannibals to move: 1

// Left -> M: 3, C: 2 | Right -> M: 0, C: 1 | Boat: Left
// Enter missionaries to move: 0
// Enter cannibals to move: 2

// Left -> M: 3, C: 0 | Right -> M: 0, C: 3 | Boat: Right
// Enter missionaries to move: 0
// Enter cannibals to move: 1

// Left -> M: 3, C: 1 | Right -> M: 0, C: 2 | Boat: Left
// Enter missionaries to move: 2
// Enter cannibals to move: 0

// Left -> M: 1, C: 1 | Right -> M: 2, C: 2 | Boat: Right
// Enter missionaries to move: 1
// Enter cannibals to move: 1

// Left -> M: 2, C: 2 | Right -> M: 1, C: 1 | Boat: Left
// Enter missionaries to move: 2
// Enter cannibals to move: 0

// Left -> M: 0, C: 2 | Right -> M: 3, C: 1 | Boat: Right
// Enter missionaries to move: 0
// Enter cannibals to move: 1

// Left -> M: 0, C: 3 | Right -> M: 3, C: 0 | Boat: Left
// Enter missionaries to move: 0
// Enter cannibals to move: 2

// Left -> M: 0, C: 1 | Right -> M: 3, C: 2 | Boat: Right
// Enter missionaries to move: 0
// Enter cannibals to move: 1

// Left -> M: 0, C: 2 | Right -> M: 3, C: 1 | Boat: Left
// Enter missionaries to move: 0
// Enter cannibals to move: 2
// ? All missionaries and cannibals safely crossed!
