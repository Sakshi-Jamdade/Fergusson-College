def water_jug_game(a, b, target):
    x = y = 0
    while True:
        print(f"Jug1: {x}, Jug2: {y}")
        if x == target or y == target:
            break
        op = input("1.Fill Jug1  2.Fill Jug2  3.Empty Jug1  4.Empty Jug2  5.Pour Jug1->2  6.Pour Jug2->1 : ")
        if op == "1": x = a
        elif op == "2": y = b
        elif op == "3": x = 0
        elif op == "4": y = 0
        elif op == "5": transfer = min(x, b - y); x -= transfer; y += transfer
        elif op == "6":transfer = min(y, a - x);y -= transfer;  x += transfer

water_jug_game(5, 4, 2)

# from collections import deque
 
# def bfs_water_jug(a, b, target):
#     visited = set()

#     q = deque([(0, 0, [])])
    
#     while q:
#         x, y, path = q.popleft()
#         if (x, y) in visited: continue
#         visited.add((x, y))
#         path = path + [(x, y)]

#         if x == target or y == target:
#             for step in path:
#                 print(f"Jug1: {step[0]}, Jug2: {step[1]}")
#             return

#         q.extend([
#             (a, y, path), (x, b, path), (0, y, path), (x, 0, path),
#             (x - min(x, b - y), y + min(x, b - y), path),
#             (x + min(y, a - x), y - min(y, a - x), path)
#         ])

# bfs_water_jug(5, 4, 2)



from collections import deque

def bfs_water_jug(a, b, target):
    visited = set()
    queue = deque()
    
    # Start with both jugs empty
    queue.append((0, 0, []))
    
    while queue:
        x, y, steps = queue.popleft()

        if (x, y) in visited:
            continue

        visited.add((x, y))
        steps = steps + [(x, y)]

        # Check if target amount is reached
        if x == target or y == target:
            print("Steps to reach the target:")
            
            for i, (j1, j2) in enumerate(steps):
                print(f"Step {i}: Jug1 = {j1}, Jug2 = {j2}")
            return

        # All possible valid operations
        queue.append((a, y, steps))  # Fill Jug1
        queue.append((x, b, steps))  # Fill Jug2
        queue.append((0, y, steps))  # Empty Jug1
        queue.append((x, 0, steps))  # Empty Jug2

        # Pour Jug1 → Jug2
        pour = min(x, b - y)
        queue.append((x - pour, y + pour, steps))

        # Pour Jug2 → Jug1
        pour = min(y, a - x)
        queue.append((x + pour, y - pour, steps))

    print("No solution found.")

# Try it out
bfs_water_jug(5, 4, 2)
