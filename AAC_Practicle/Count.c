#include <stdio.h>

void countingSort(int a[], int n, int k) 
{
    int count[k + 1];  // To store the count of each element (0 to k)
    int b[n];
	int i;           // Output array for sorted elements

    // Initialize the count array to 0
    for (i = 0; i <= k; i++)
	{
        count[i] = 0;
    }

    // Count the occurrences of each element in the input array
    for (i = 0; i < n; i++) {
        ++count[a[i]];
    }

    // Update the count array by adding the previous count
    for (i = 1; i <= k; i++) {
        count[i] += count[i - 1];
    }

    // Build the output array b[] by placing the elements in their sorted position
    for (i = n - 1; i >= 0; i--) {
        b[--count[a[i]]] = a[i];
    }

    // Copy the sorted elements back to the original array a[]
    for (i = 0; i < n; i++) {
        a[i] = b[i];
    }
}


int main() 
{
    int a[] = {4, 2, 2, 8, 3, 3, 1};  
    int n = sizeof(a) / sizeof(a[0]); 
    int k = 8;  
    int i;
    
    countingSort(a, n, k);

    printf("Sorted Array: ");
    
    for (i = 0; i < n; i++) 
	{
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}

