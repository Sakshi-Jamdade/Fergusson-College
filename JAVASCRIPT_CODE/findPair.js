function findPair(arr, target) 
{
    let map = new Map();
    for (let i = 0; i < arr.length; i++) 
    {
        let complement = target - arr[i];
        if (map.has(complement)) 
        {
            return [map.get(complement), i];
        }
        map.set(arr[i], i);
    }
    return [];
}


console.log(findPair([10, 20, 10, 40, 50, 60, 70], 50)); // [2, 3]
