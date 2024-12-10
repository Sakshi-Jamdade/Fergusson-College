# circle_area.py

import math

def calculate_area(radius):
    if radius < 0:
        raise ValueError("Radius cannot be negative.")
    return math.pi * (radius ** 2)
