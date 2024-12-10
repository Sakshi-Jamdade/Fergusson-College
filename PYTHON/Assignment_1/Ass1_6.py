# Input: Principal, Rate of Interest, and Time Period
principal = float(input("Enter the principal amount: "))
rate = float(input("Enter the rate of interest (in %): "))
time = float(input("Enter the time period (in years): "))

# Calculation of Simple Interest
simple_interest = (principal * rate * time) / 100

# Output: Display the calculated interest
print(f"The calculated Simple Interest is: {simple_interest}")
