#Create a class Employee with attributes like name, position, and salary. Use the constructor 
#(__init__()) to initialize the attributes when an object is created. Write a method to display employee 
#details.

class Employee:
    def __init__(self, name, position, salary):
        self.name = name
        self.position = position
        self.salary = salary

    def display_details(self):
        print(f"Employee Details:\nName: {self.name}\nPosition: {self.position}\nSalary: {self.salary}")


employee = Employee(name="John Doe", position="Software Engineer", salary=75000)
employee.display_details()
