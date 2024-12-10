#Create a class Vehicle with attributes brand and speed. Add a method show_details() to 
#display these details. Then, create a subclass Car that inherits from Vehicle and adds an attribute 
#mileage. Use the super() method to call the show_details() of the parent class inside the Car class's 
#show_details() method.

class Vehicle:
    def __init__(self, brand, speed):
        self.brand = brand
        self.speed = speed

    def show_details(self):
        print(f"Vehicle Details:\nBrand: {self.brand}\nSpeed: {self.speed} km/h")

class Car(Vehicle):
    def __init__(self, brand, speed, mileage):
        super().__init__(brand, speed)
        self.mileage = mileage

    def show_details(self):
        super().show_details()
        print(f"Mileage: {self.mileage} km/l")

# Create a Car object
my_car = Car(brand="Honda", speed=180, mileage=15)

# Display details
my_car.show_details()
