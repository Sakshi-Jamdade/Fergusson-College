goal = [1, 2, 3, 4, 5, 6, 7, 8, 0]  # Goal state where 0 is the blank tile

# Heuristic function: Counts misplaced tiles (ignoring 0)
def h(state):
    return sum(1 for i in range(9) if state[i] != goal[i] and state[i] != 0)

# Generate all valid neighboring states by moving the blank (0)
def neighbors(state):
    moves = []
    idx = state.index(0)  # Find index of blank tile
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # Up, Down, Left, Right
    x, y = divmod(idx, 3)  # Get row, column from index'
    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if 0 <= nx < 3 and 0 <= ny < 3:  # Stay within bounds
            ni = nx * 3 + ny  # Convert 2D position back to 1D index
            new = state[:]
            new[idx], new[ni] = new[ni], new[idx]  # Swap blank with neighbor
            moves.append(new)
    return moves

# Main hill climbing function
def solve(start):
    current = start
    while True:
        print(current)  # Print current state
        if h(current) == 0:  # If goal is reached
            print("Goal reached!")
            break
        next_moves = neighbors(current)
        best = min(next_moves, key=h)  # Choose neighbor with lowest heuristic
        if h(best) >= h(current):  # No better move found
            print("Stuck!")
            break
        current = best  # Move to better neighbor

# Initial state to solve
start = [2, 8, 3, 1, 6, 4, 7, 0, 5]
solve(start)
