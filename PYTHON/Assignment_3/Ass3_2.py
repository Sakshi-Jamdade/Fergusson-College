from datetime import datetime

def current_datetime():
    return datetime.now().strftime("%Y-%m-%d %H:%M:%S")

# Test
print("Current Date and Time:", current_datetime())
