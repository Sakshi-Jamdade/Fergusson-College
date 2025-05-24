from collections import deque

def is_valid(m, c):
    return(
        0 <= m <= 3 and 
        0 <= c <= 3 and
        (m == 0 or m >= c) and
        (3 - m == 0 or 3 - m >= 3 - c)
    )

def bfs():
    start = (3, 3, 1)  # (missionaries, cannibals, boat side 1=left, 0=right)
    goal = (0, 0, 0)
    queue = deque([(start, [start])])
    visited = set()

    moves = [(1, 0), (0, 1), (1, 1), (2, 0), (0, 2)]

    while queue:
        
        (m, c, b), path = queue.popleft()
        
        if (m, c, b) == goal:
            for state in path:
                print(state)
            return
        
        for dm, dc in moves:
            if b == 1:
                new = (m - dm, c - dc, 0)
                
            else:
                new = (m + dm, c + dc, 1)
                
            if is_valid(new[0], new[1]) and new not in visited:
                visited.add(new)
                queue.append((new, path + [new]))

bfs()
