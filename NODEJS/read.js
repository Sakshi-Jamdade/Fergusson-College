const fs = require('fs');

// Create & Write to file
fs.writeFileSync('Sample.txt', 'Hello, Sakshi!');
console.log('File created and content written.');

// Read file
const data = fs.readFileSync('Sample.txt', 'utf8');
console.log('File content:', data);

// Append to file (optional)
fs.appendFileSync('Sample.txt', '\nAnother line added.');
console.log('New line appended.');

// Read again
const updatedData = fs.readFileSync('Sample.txt', 'utf8');
console.log('Updated File content:\n', updatedData);

// Delete file
fs.unlinkSync('Sample.txt');
console.log('Sample.txt file deleted successfully.');
