#include<stdio.h>

void main()
{
    int arr[] = {1, 10, 25, 31, 32, 42, 43, 54}; // Sorted array
    int n = sizeof(arr) / sizeof(arr[0]);
    int low = 0, high = n - 1, mid, num, found = 0;
    
    printf("\nEnter Element To Search: ");
    scanf("%d", &num); // Input the number to search
    
    while (low <= high)
    {
        mid = (low + high) / 2;
        
        if (arr[mid] == num)
        {
            printf("\nNumber Found At Index %d\n", mid);
            found = 1;
            break;
        }
        else if (arr[mid] < num)    // 2<5 then low =mid+1
        {
            low = mid + 1; // Search in the right half
        }
        else						// 5>2
        {
            high = mid - 1; // Search in the left half
        }
    }
    
    if (!found)
    {
        printf("\nNumber Not Found\n");
    }
}

