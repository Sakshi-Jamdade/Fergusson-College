# Input: Two numbers
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Calculate the absolute difference
difference = abs(num1 - num2)

# Categorize the difference using if-elif-else
if difference < 10:
    print(f"The absolute difference ({difference:.2f}) is small.")
elif difference < 50:
    print(f"The absolute difference ({difference:.2f}) is medium.")
else:
    print(f"The absolute difference ({difference:.2f}) is large.")
