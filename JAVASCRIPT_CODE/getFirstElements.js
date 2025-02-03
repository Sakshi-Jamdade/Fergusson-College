function getFirstElements(arr, n = 1) 
{
    return arr.slice(0, n);
}

console.log(getFirstElements([1, 2, 3, 4, 5], 3)); // [1, 2, 3]
console.log(getFirstElements([10, 20, 30]));       // [10]
