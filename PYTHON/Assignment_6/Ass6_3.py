#Define a class Animal with a method speak(), which prints a generic message like "Animal 
#sound". Then create subclasses Dog and Cat that override the speak() method with their respective 
#sounds. 
#Bonus: Demonstrate method overriding by calling speak() on objects of Animal, Dog, and Cat.

class Animal:
    def speak(self):
        print("Animal sound")

class Dog(Animal):
    def speak(self):
        print("Woof! Woof!")

class Cat(Animal):
    def speak(self):
        print("Meow! Meow!")

# Demonstrate method overriding
animal = Animal()
dog = Dog()
cat = Cat()

print("Animal:")
animal.speak()

print("\nDog:")
dog.speak()

print("\nCat:")
cat.speak()
