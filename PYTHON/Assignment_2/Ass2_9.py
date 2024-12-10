#Create a dictionary with at least 5 key-value pairs. Write a Python program to: 
#• Add a new key-value pair to the dictionary. 
#• Update an existing key with a new value. 
#• Delete a key-value pair from the dictionary.

my_dict={"name":"Sakshi","age":22,"class":"MSC","Roll":12413,"clg":"FC"}
print(my_dict)

my_dict["gender"]="F"
my_dict["age"]=26
del my_dict["clg"]

print(my_dict)
