
#include <stdio.h>

void countingSort(int a[], int n, int k) 
{
    int count[k + 1];  // To store the count of each element (0 to k)
    int b[n];
	int i;           // Output array for sorted elements

    
    for (i = 0; i <= k; i++)
	{
        count[i] = 0;
    }
    
    for (i = 0; i < n; i++)
	{
        ++count[a[i]];
    }
    
    for (i = 1; i <= k; i++)
	{
        count[i] += count[i - 1];
    }

    
    for (i = n - 1; i >= 0; i--)
    {
        b[--count[a[i]]] = a[i];
    }

    
    for (i = 0; i < n; i++) 
	{
        a[i] = b[i];
    }
}
int getMax(int a[], int n) {
    int max = a[0];int i;
    for (i = 1; i < n; i++) {
        if (a[i] > max) {
            max = a[i];
        }
    }
    return max;
}


void radixSort(int a[], int n)
 {
    int max = getMax(a, n);  
	int exp;
    
    for (exp = 1; max / exp > 0; exp *= 10) 
	{
        countingSort(a, n, k);  
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

