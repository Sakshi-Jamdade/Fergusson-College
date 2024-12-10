#Write a Python program to reverse a given string without using built-in functions. For 
#example, input "hello" should return "olleh".

str="hello"
print(str[::-1])

reversed_str=""

for char in str:
    reversed_str = char + reversed_str

print(reversed_str)
