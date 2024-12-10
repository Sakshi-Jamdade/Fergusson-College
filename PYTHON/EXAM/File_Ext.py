def get_file_extension(filename):
    # Split the filename by '.' and return the last part as extension
    if '.' in filename:
        return filename.split('.')[-1]
    return "No extension"

# Example usage
filename = "example.txt"
print("File Extension:", get_file_extension(filename))

filename2 = "archive.tar.gz"
print("File Extension:", get_file_extension(filename2))

filename3 = "no_extension_file"
print("File Extension:", get_file_extension(filename3))
