def round_to_one(numbers):
    return list(map(lambda x: round(x, 1), numbers))

# Test
print(round_to_one([3.14159, 2.71828, 1.61803]))  # [3.1, 2.7, 1.6]
