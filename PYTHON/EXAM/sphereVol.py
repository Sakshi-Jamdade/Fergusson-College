import math

# Input: Radius of the sphere
radius = float(input("Enter the radius of the sphere: "))

# Calculate Volume of the sphere
volume = (4 / 3) * math.pi * (radius ** 3)

# Output: Display the volume
print(f"The volume of the sphere is: {volume:.2f}")
