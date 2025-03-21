# Input: Weight and Height
weight = float(input("Enter your weight in kilograms: "))
height = float(input("Enter your height in meters: "))

# Calculation of BMI
bmi = weight / (height ** 2)

# Categorization based on BMI
if bmi < 18.5:
    category = "Underweight"
elif 18.5 <= bmi < 24.9:
    category = "Normal weight"
elif 25 <= bmi < 29.9:
    category = "Overweight"
else:
    category = "Obese"

# Output: BMI and Category
print(f"Your BMI is: {bmi:.2f}")
print(f"Category: {category}")
