def WaterJug(a,b,target):
    x=y=0;
    while True:
        print(f"Jug1 : {x}, Jug2 : {y}")

        if x == target or y == target :
            print("🎯 Target achieved!")
            break
        
        op = input("1. Fill Jug1 2.Fill Jug2 3.Empty Jug1 4.EMpty Jug2 5.Pour Jug1->Jug2 6.Pour Jug2->Jug1  ")
        if op == "1" : x=a
        elif op == "2" : y=b    
        elif op == "3" : x=0
        elif op == "4" : y=0
        elif op == "5" :
            transfer = min(x,b-y)
            x -= transfer
            y += transfer
            
        elif op == "6" :
            transfer = min(y,a-x)
            y -= transfer
            x += transfer
            
        else:
            print("⚠ Invalid input, try again.")
            
WaterJug(5,4,2)
        
    
    
    
    