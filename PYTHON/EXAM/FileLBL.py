def merge_files(file1, file2, output_file):
    with open(file1, 'r') as f1, open(file2, 'r') as f2, open(output_file, 'w') as out:
        lines1 = f1.readlines()
        lines2 = f2.readlines()

        # Iterate over both files and write line by line
        for i in range(min(len(lines1), len(lines2))):
            out.write(lines1[i])
            out.write(lines2[i])

        # If file1 has extra lines
        for i in range(len(lines1) - len(lines2)):
            out.write(lines1[len(lines2) + i])

        # If file2 has extra lines
        for i in range(len(lines2) - len(lines1)):
            out.write(lines2[len(lines1) + i])

# Example usage
merge_files('file1.txt', 'file2.txt', 'merged_output.txt')
