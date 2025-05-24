from collections import deque

def WaterJugBFS(a,b,target):
    visited=set()
    queue = deque()   
    
    queue.append((0,0,[]))   
    
    while queue:
        x,y,steps = queue.popleft()
        
        if(x,y) in visited:
            continue
        
        visited.add((x,y))
        steps=steps+[(x,y)]
        
        if x==target or y==target:
            print("Steps To Reach : ")
            
            for i,(j1,j2) in enumerate(steps):
                print(f"steps {i} : Jug1 : {j1} Jug2 : {j2}")
            return
    
        # append
        queue.append((a,y,steps))
        queue.append((x,b,steps))
        queue.append((0,y,steps))
        queue.append((x,0,steps))
        
        pour = min(x,b-y)
        queue.append((x-pour,y+pour,steps))
        
        pour = min(y,a-x)
        queue.append((x+pour,y-pour,steps))
    
    print("invalid Move")

WaterJugBFS(5,4,2)

        
        
    
    
         