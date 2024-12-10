def add_lists(list1, list2):
    return list(map(lambda x, y: x + y, list1, list2))

# Test
print(add_lists([1, 2, 3], [4, 5, 6]))  # [5, 7, 9]
