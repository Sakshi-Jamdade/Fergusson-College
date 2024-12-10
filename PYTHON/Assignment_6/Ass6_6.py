#Define two classes, Engine and Body, with constructors that initialize respective attributes 
#like horsepower and material. Then, create a class Car that inherits from both Engine and Body. Use 
#the super() method to initialize both parent class attributes from the Car class.

class Engine:
    def __init__(self, horsepower):
        self.horsepower = horsepower

class Body:
    def __init__(self, material):
        self.material = material

class Car(Engine, Body):
    def __init__(self, horsepower, material, brand):
        super().__init__(horsepower)
        Body.__init__(self, material)  # Explicit call for Body's constructor
        self.brand = brand

    def display_details(self):
        print(f"Car Details:\nBrand: {self.brand}\nHorsepower: {self.horsepower} HP\nBody Material: {self.material}")

# Create a Car object
my_car = Car(horsepower=250, material="Aluminum", brand="Tesla")

# Display details
my_car.display_details()
