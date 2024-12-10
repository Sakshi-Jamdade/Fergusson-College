def count_vowels(string):
    vowels = "aeiou"
    count = 0

    for char in string.lower():  # Convert to lowercase to ignore case
        if char in vowels:
            count += 1

    return count

# Input: User-provided string
input_string = input("Enter a string: ")
vowel_count = count_vowels(input_string)

# Output: Display the number of vowels
print(f"The number of vowels in the string is: {vowel_count}")
