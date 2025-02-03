function mergeAndRemoveDuplicates(arr1, arr2) 
{
    return [...new Set([...arr1, ...arr2])];
}

console.log(mergeAndRemoveDuplicates([1, 2, 3], [2, 3, 4, 5])); // [1, 2, 3, 4, 5]
