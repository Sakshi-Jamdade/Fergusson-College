def validate_username(username):
    if len(username) >= 5:
        return True
    else:
        print("Username must be at least 5 characters long.")
        return False

def validate_password(password):
    if len(password) < 8:
        print("Password must be at least 8 characters long.")
        return False
    
    if not any(char.isdigit() for char in password):
        print("Password must contain at least one digit.")
        return False
    
    if not any(char.isalpha() for char in password):
        print("Password must contain at least one letter.")
        return False
    return True

# Input and validation
username = input("Enter your username: ")
password = input("Enter your password: ")

if validate_username(username) and validate_password(password):
    print(f"Your password is: {password}")
else:
    print("Invalid username or password.")
