import heapq

# List of all cities
cities = ['A', 'B', 'C', 'D']

# Travel costs between cities (bidirectional)
costs = {
    ('A', 'B'): 1, ('B', 'A'): 1,
    ('A', 'C'): 3, ('C', 'A'): 3,
    ('A', 'D'): 6, ('D', 'A'): 6,
    ('B', 'C'): 1, ('C', 'B'): 1,
    ('B', 'D'): 4, ('D', 'B'): 4,
    ('C', 'D'): 1, ('D', 'C'): 1
}

start = 'A'  # Starting city
visited = set()  # Set to track visited cities
path = []  # Final path taken
priority_queue = []  # Min-heap for BFS

# Push the starting point into the queue: (total_cost, current_city, path_so_far)
heapq.heappush(priority_queue, (0, start, [start]))

# Greedy Best First Search Loop
while priority_queue:
    cost_so_far, current, path_till_now = heapq.heappop(priority_queue)

    # Visit this city if not already visited
    if current not in visited:
        visited.add(current)
        path = path_till_now

        # If all cities are visited, stop
        if len(visited) == len(cities):
            break

        # Try all unvisited neighbors
        for next_city in cities:
            if next_city not in visited and (current, next_city) in costs:
                new_cost = cost_so_far + costs[(current, next_city)]
                new_path = path_till_now + [next_city]
                heapq.heappush(priority_queue, (new_cost, next_city, new_path))

# Output the result
print("Best First Search Path (Greedy):", path)
