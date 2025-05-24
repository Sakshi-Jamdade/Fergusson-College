def safe(m, c):
    return (m == 0 or m >= c) and (3 - m == 0 or (3 - m) >= (3 - c))

def play():
    m, c = 3, 3
    boat = 'left'

    while not (m == 0 and c == 0 and boat == 'right'):
        
        print(f"\nLeft: {m}M, {c}C | Right: {3 - m}M, {3 - c}C | Boat: {boat}")
        
        x = int(input("Missionaries to move: "))
        y = int(input("Cannibals to move: "))

        if x + y == 0 or x + y > 2:
            print("❌ Move 1 or 2 people only.")
            continue

        if boat == 'left':
            new_m = m - x
            new_c = c - y
        else:
            new_m = m + x
            new_c = c + y

        if 0 <= new_m <= 3 and 0 <= new_c <= 3 and safe(new_m, new_c):
            m = new_m
            c = new_c
            boat = 'right' if boat == 'left' else 'left'
        else:
            print("❌ Invalid move. Try again.")

    print("\n🎉 You won! Everyone crossed safely.")

play()
