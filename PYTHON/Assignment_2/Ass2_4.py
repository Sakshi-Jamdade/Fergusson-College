def print_details(**kwargs):
    for key, value in kwargs.items():
        print(f"{key}: {value}")
        
print("Test Case 1:")
print_details(name="Sakshi", age=22, country="India")


