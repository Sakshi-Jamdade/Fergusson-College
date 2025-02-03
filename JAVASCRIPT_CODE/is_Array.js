function isArray(input) 
{
    return Array.isArray(input);
}

console.log(isArray([1, 2, 3])); // true
console.log(isArray('Hello'));   // false
console.log(isArray({a: 1}));    // false
console.log(isArray(123));       // false