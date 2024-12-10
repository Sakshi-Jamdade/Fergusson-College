# Create a simple calculator that allows the user to input two numbers and an operator (+, -, *, 
# /, %, **, //). Based on the operator provided, the program should perform the corresponding 
# arithmetic operation and display the result.

num1=int(input("Enter 1st Number = "))
num2=int(input("Enter 2st Number = "))
op=input("Enter Operation (+, -, *, /, %, **, //) = ")

if op== '+':
    result = num1+num2
elif op=='-':
    result = num1-num2
elif op=='*':
    result = num1*num2
elif op=='/':
    result = num1/num2
elif op=='%':
    result = num1%num2
elif op=='**':
    result = num1**num2
elif op=='//':
    result = num1//num2
else:
    print("Invalid Operation")

print(" Result = ",result)
