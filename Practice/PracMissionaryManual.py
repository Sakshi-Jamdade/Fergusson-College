def is_valid(m,c):
    return(
        0<=m<=3 and 0<=c<=3 and (m==0 or m>=c) and (3-m ==0  or 3-m >= 3-c)
    )
    
def UserInput():
    m,c = 3,3 
    boat = 'left'
    
    while not (m==0 and c==0 and boat=='right'):
        
        print(f"\n Left : {m}M , {c}C | Right : {3-m}M , {3-c}C | Boat : {boat} ")
        
        x=int(input("Enter Missionary :"))
        y=int(input("Enter Cannibaals :"))
        
        if x+y == 0 or x+y>2:
            print("Only 1 or 2 Persons ")
            continue
        
        if boat=='left':
            new_m=m-x
            new_c=c-y
        else:
            new_m=m+x
            new_c=c+y
            
        if  0 <= new_m <= 3 and 0 <= new_c <= 3 and is_valid(new_m,new_c):
            m,c = new_m,new_c
            boat='right' if boat == 'left' else 'left'
        
        else:
            print("Invalid")
        
    print("You Won")

UserInput()