graph = [
    [0, 29, 20, 21],
    [29, 0, 15, 17],
    [20, 15, 0, 28],
    [21, 17, 28, 0]
]

n = len(graph)
visited = [False] * n
path = []
cost = 0
current = 0

visited[current] = True
path.append(current)

for _ in range(n - 1):
    next_city = -1
    min_cost = float('inf')
    
    for j in range(n):
        if not visited[j] and graph[current][j] < min_cost:
            min_cost = graph[current][j]
            next_city = j
            
    visited[next_city] = True
    path.append(next_city)
    cost += min_cost
    current = next_city

cost += graph[current][path[0]]
path.append(path[0])

print("Path:", path)
print("Total Cost:", cost)
