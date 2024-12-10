#Create a class Car with two attributes: brand and year. Write a method display_info() that prints 
#the car's brand and year. Then, create an object of the Car class and call the display_info() method to 
#display the car's details. Bonus: Add an attribute for color and include it in the display_info() method!

class Car:
    def __init__(self, brand, year, color):
        self.brand = brand
        self.year = year
        self.color = color

    def display_info(self):
        print(f"Car Details:\nBrand: {self.brand}\nYear: {self.year}\nColor: {self.color}")

my_car = Car(brand="Toyota", year=2021, color="Red")
my_car.display_info()
