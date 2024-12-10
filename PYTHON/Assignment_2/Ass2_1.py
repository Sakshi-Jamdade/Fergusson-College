def area_of_rectangle(length, width):
    return length * width

# Testing the function with different values
print("Test Cases:")
print(f"Area with length=5 and width=10: {area_of_rectangle(5, 10)}")  # Expected: 50
print(f"Area with length=2.5 and width=4: {area_of_rectangle(2.5, 4)}")  # Expected: 10.0
print(f"Area with length=7 and width=3.2: {area_of_rectangle(7, 3.2)}")  # Expected: 22.4
print(f"Area with length=0 and width=10: {area_of_rectangle(0, 10)}")  # Expected: 0
print(f"Area with length=-5 and width=6: {area_of_rectangle(-5, 6)}")  # Expected: -30 (negative area in this case)
