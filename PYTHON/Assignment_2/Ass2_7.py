# Write a Python function multiply(a, *args) that multiplies a fixed argument a with a variable 
# number of additional arguments. Return the produc

def multiply(a,*args):
    product=a
    for num in args:
        product *= num
    return product

c=multiply(2,3,4,5,6)
print(c)
