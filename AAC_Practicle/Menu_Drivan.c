#include <stdio.h>

// Function to print Fibonacci sequence
void fibonacci(int n) 
{
    int a = 0, b = 1, c,i;
    printf("Fibonacci Sequence: ");
    for (i = 0; i < n; i++) 
	{
        printf("%d ", a);
        c = a + b;
        a = b;
        b = c;
    }
    printf("\n");
}

// Function to calculate factorial
void factorial(int num) 
{
    int fact = 1,i;
    for (i = 1; i <= num; i++) 
	{
        fact = fact * i;
    }
    printf("Factorial of %d is: %d\n", num, fact);
}

// Function to check for perfect number
void perfect_number(int num) 
{
    int sum = 0,i;
    for (i = 1; i <= num / 2; i++) 
	{
        if (num % i == 0) 
		{
            sum += i;
        }
    }
    if (sum == num) 
	{
        printf("%d is a perfect number.\n", num);
    } 
	else 
	{
        printf("%d is not a perfect number.\n", num);
    }
}

// Function to check for palindrome
void palindrome(int num) 
{
    int org = num, reverse = 0, rem;
    while (num != 0) 
	{
        rem = num % 10;
        reverse = reverse * 10 + rem;
        num /= 10;
    }
    if (org == reverse) 
	{
        printf("%d is a palindrome.\n", org);
    } 
	else 
	{
        printf("%d is not a palindrome.\n", org);
    }
}

// Main function
int main() 
{
    int choice, n, num;

    while (1) 
	{
        printf("\nMenu:\n");
        printf("1. Generate Fibonacci Sequence\n");
        printf("2. Calculate Factorial\n");
        printf("3. Check Perfect Number\n");
        printf("4. Check Palindrome\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) 
		{
            case 1:
                printf("Enter the number of terms: ");
                scanf("%d", &n);
                fibonacci(n);
                break;
            case 2:
                printf("Enter a number: ");
                scanf("%d", &num);
                factorial(num);
                break;
            case 3:
                printf("Enter a number: ");
                scanf("%d", &num);
                perfect_number(num);
                break;
            case 4:
                printf("Enter a number: ");
                scanf("%d", &num);
                palindrome(num);
                break;
            case 5:
                printf("Exiting...\n");
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}

