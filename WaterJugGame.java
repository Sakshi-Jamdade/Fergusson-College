import java.util.Scanner;

public class WaterJugGame 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Water Game!");

        System.out.print("Enter Jug A capacity: ");
        int a = sc.nextInt();

        System.out.print("Enter Jug B capacity: ");
        int b = sc.nextInt();

        int bigger = Math.max(a, b);
        int goal;
        while (true) {
            System.out.print("Enter Goal amount (only in bigger jug): ");
            goal = sc.nextInt();
            if (goal <= bigger) break;
            System.out.println("❌ Goal must be less than or equal to the bigger jug.");
        }

        int jugA = 0, jugB = 0;

        while ((a > b && jugA != goal) || (b > a && jugB != goal)) 
        {
            System.out.println("\nCurrent Status:");
            System.out.println("A: " + jugA + "/" + a);
            System.out.println("B: " + jugB + "/" + b);

            System.out.println("\nChoose an operation:");
            System.out.println("1. Fill A");
            System.out.println("2. Fill B");
            System.out.println("3. Transfer from A to B");
            System.out.println("4. Transfer from B to A");
            System.out.println("5. Empty A");
            System.out.println("6. Empty B");
            System.out.println("7. Check Capacities");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    jugA = a;
                    System.out.println("A is now full.");
                    break;
                case 2:
                    jugB = b;
                    System.out.println("B is now full.");
                    break;
                case 3:
                    int toB = Math.min(jugA, b - jugB);
                    jugA -= toB;
                    jugB += toB;
                    System.out.println("Transferred " + toB + " from A to B.");
                    break;
                case 4:
                    int toA = Math.min(jugB, a - jugA);
                    jugB -= toA;
                    jugA += toA;
                    System.out.println("Transferred " + toA + " from B to A.");
                    break;
                case 5:
                    jugA = 0;
                    System.out.println("A is now empty.");
                    break;
                case 6:
                    jugB = 0;
                    System.out.println("B is now empty.");
                    break;
                case 7:
                    System.out.println("Capacities - Jug A: " + a + ", Jug B: " + b);
                    break;
                case 8:
                    System.out.println("Exiting game. Thank you!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }

        // 🟢 Final output
        System.out.println("\n🎉 Congratulations! " + goal + " units reached in the bigger jug.");
        System.out.println("Final State:");
        System.out.println("A: " + jugA + "/" + a);
        System.out.println("B: " + jugB + "/" + b);
    }
}


// Welcome to the Water Game!
// Enter Jug A capacity: 5
// Enter Jug B capacity: 4
// Enter Goal amount (only in bigger jug): 2

// Current Status:
// A: 0/5
// B: 0/4

// Choose an operation:
// 1. Fill A
// 2. Fill B
// 3. Transfer from A to B
// 4. Transfer from B to A
// 5. Empty A
// 6. Empty B
// 7. Check Capacities
// 8. Exit
// 1
// A is now full.

// Current Status:
// A: 5/5
// B: 0/4

// Choose an operation:
// 1. Fill A
// 2. Fill B
// 3. Transfer from A to B
// 4. Transfer from B to A
// 5. Empty A
// 6. Empty B
// 7. Check Capacities
// 8. Exit
// 3
// Transferred 4 from A to B.

// Current Status:
// A: 1/5
// B: 4/4

// Choose an operation:
// 1. Fill A
// 2. Fill B
// 3. Transfer from A to B
// 4. Transfer from B to A
// 5. Empty A
// 6. Empty B
// 7. Check Capacities
// 8. Exit
// 6
// B is now empty.

// Current Status:
// A: 1/5
// B: 0/4

// Choose an operation:
// 1. Fill A
// 2. Fill B
// 3. Transfer from A to B
// 4. Transfer from B to A
// 5. Empty A
// 6. Empty B
// 7. Check Capacities
// 8. Exit
// 3
// Transferred 1 from A to B.

// Current Status:
// A: 0/5
// B: 1/4

// Choose an operation:
// 1. Fill A
// 2. Fill B
// 3. Transfer from A to B
// 4. Transfer from B to A
// 5. Empty A
// 6. Empty B
// 7. Check Capacities
// 8. Exit
// 1
// A is now full.

// Current Status:
// A: 5/5
// B: 1/4

// Choose an operation:
// 1. Fill A
// 2. Fill B
// 3. Transfer from A to B
// 4. Transfer from B to A
// 5. Empty A
// 6. Empty B
// 7. Check Capacities
// 8. Exit
// 3
// Transferred 3 from A to B.

// ? Congratulations! 2 units reached in the bigger jug.
// Final State:
// A: 2/5
// B: 4/4
