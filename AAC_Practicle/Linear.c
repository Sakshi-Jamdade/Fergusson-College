#include<stdio.h>

void main()
{
    int arr[] = {10, 43, 25, 42, 32, 1, 31, 54};
    int n = sizeof(arr) / sizeof(arr[0]);
    int i, num, found = 0;
    
    printf("\nEnter Element To Search: ");
    scanf("%d", &num); // Corrected: Added '&' before num
    
    for (i = 0; i < n; i++) // Corrected: Changed condition to i < n
    {
        if (num == arr[i])
        {
            printf("\nNumber Found At Index %d\n", i);
            found = 1;
            break; 
        }
    }
    
    if (!found) // If not found, output the message
    {
        printf("\nNumber Not Found\n");
    }
}

